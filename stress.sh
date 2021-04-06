#!/usr/bin/env bash

welcome() {
  printf "%s" "\


      _/_/_/  _/_/_/_/_/  _/_/_/    _/_/_/_/    _/_/_/    _/_/_/
   _/            _/      _/    _/  _/        _/        _/
    _/_/        _/      _/_/_/    _/_/_/      _/_/      _/_/
       _/      _/      _/    _/  _/              _/        _/
_/_/_/        _/      _/    _/  _/_/_/_/  _/_/_/    _/_/_/
                  _/_/_/_/_/  _/_/_/_/    _/_/_/  _/_/_/_/_/  _/_/_/_/  _/_/_/
                     _/      _/        _/            _/      _/        _/    _/
                    _/      _/_/_/      _/_/        _/      _/_/_/    _/_/_/
                   _/      _/              _/      _/      _/        _/    _/
                  _/      _/_/_/_/  _/_/_/        _/      _/_/_/_/  _/    _/


  version 0.3: Mozzarella

  This script generates a series of dummy data and sends it to all methods, then it generates a series of points
  that will later be plot using gnuplot

  Options:

  --path-tester    -- parse the path of the folder containing the data (F_i_j.txt)
  --params  | -p   -- parameters for stress testers:
                        n     -> The number of companies
                        m     -> The number of crime events
                        isize -> The initial size for experimentations
                        fsize -> The final size for experimentation
                        istep -> The increment of sizes
                        rep   -> The number of repetitions for a each size

  --default | -d   -- automatically run Stress tester with default parameters
  --plot    | -g   -- plot data using gnuplot
  --save    | -s   -- save all output data
  --help    | -h   -- display this help and exit

  "
  exit 1
}

default_path_to_save="$HOME/Documents/"
stress_file_name="stress.csv"             #
path_tester="default"                     #
graph="false"                             #

if [[ "$1" == "" ]] ; then
  welcome
fi

while test $# -gt 0; do
  case "$1" in
    -h|--help)
      welcome
      ;;
    -p|--params)
      shift
      case "$1" in # n
        ''|*[!0-9]*)
          printf "Please enter a positive Integer: n"
          exit 1
        ;;
        *)
          n="$1"
        ;;
      esac
      case "$2" in # m
            ''|*[!0-9]*)
          printf "Please enter a positive Integer: m"
          exit 1
        ;;
        *)
          m="$2"
        ;;
      esac
      case "$3" in # isize
        ''|*[!0-9]*)
          printf "Please enter a positive Integer: initial size"
          exit 1
        ;;
        *)
          isize="$3"
        ;;
      esac
      case "$4" in # fsize
        ''|*[!0-9]*)
          printf "Please enter a positive Integer: final size"
          exit 1
        ;;
        *)
          fsize="$4"
        ;;
      esac
      case "$5" in # n
        ''|*[!0-9]*)
          printf "Please enter a positive Integer: increments of the size (Δx)"
          exit 1
        ;;
        *)
          istep="$6"
        ;;
      esac
      case "$5" in # rep
        ''|*[!0-9]*)
          printf "Please enter a positive Integer: number of repetitions of each size"
          exit 1
        ;;
        *)
          rep="$6"
        ;;
      esac
      shift
      ;;

    -d|--default)

      # Default Values
      shift
      n=10
      m=50
      isize=50
      fsize=1000
      istep=50
      rep=200
    ;;
    -g|--plot)
      shift
      graph="true"

      ;;
    --path-tester)
      shift
      if test $# -gt 0; then
        path_tester="$1"
      elif [[ "$1"  == " " ]] ; then
        path_tester="default"
      fi
      shift
      ;;
    -s|--save)
      save_me="save"
      shift
      if test $# -gt 0; then
        case "$1" in
          */) path_to_save="$1"
            break
            ;;
          *) path_to_save="$1"/
            break
            ;;
        esac
      else
        path_to_save="$default_path_to_save"
      fi
      shift
      ;;
    *)
      break
      ;;
  esac
done

stress_me() {
    DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )"
    java -Dfile.encoding=UTF-8 -classpath "$DIR"/out/production/Solve p1MainClasses.Stress "$n,$m,$isize,$fsize,$istep,$rep" $graph $path_tester "$save_me,$path_to_save,$stress_file_name"
  exit 1
}

# Fire the torture!!!
stress_me
