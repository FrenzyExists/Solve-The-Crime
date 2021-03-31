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

  --path-tester         -- parse the path of the folder containing the data (F_i_j.txt)
  --company-size | -c   -- the number of companies that gave their phone calls reports for experimentation
  --init-size    | -i   -- the initial size for experimentation
  --final-size   | -f   -- final size for experimentation
  --step-size    | -x   -- increment of sizes
  --rep          | -r   -- number of repetitions for a each size
  --plot         | -p   -- plot data using gnuplot
  --save         | -s   -- save all output data
  --help         | -h   -- display this help and exit

  NOTE: In case a path to the tester is not specified a Solve will use the
  default path which is utilized for testing. If the folder is empty it will
  automatically generate the files
  "
  exit 1
}

default_path_to_save="$HOME/Documents/"   #
stress_file_name="stress.txt"             #
path_tester="default"                     #
rep=200                                   # Default Stress Size, aka repetitions

if [[ "$1" == "" ]] ; then
  welcome
fi

while test $# -gt 0; do
  case "$1" in
    -h|--help)
      welcome
      ;;

    -c|--company-size)
      shift
      if [[ "$1" == "p1" ]] ; then
          n="$1"
      elif [[ "$1" == "p1" ]] ; then
          printf ""
          exit 1
      else
        printf "Please do not let this flag empty, enter path of desired data to be analyzed"
        exit 1
      fi
      shift

      ;;

        -i|--init-size)
      shift
      if [[ "$1" == "p1" ]] ; then
          isize="$1"
      elif [[ "$1" == "p1" ]] ; then
          printf ""
          exit 1
      else
        printf "Please do not let this flag empty, enter path of desired data to be analyzed"
        exit 1
      fi
      shift

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
    -s)
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
#    java -Dfile.encoding=UTF-8 -classpath "$DIR"/out/production/Solve p1MainClasses.Stress $method $path_tester "$save_me,$path_to_save,$solved_case_file_name"
    java -Dfile.encoding=UTF-8 -classpath "$DIR"/out/production/Solve p1MainClasses.Stress $n $m $isize $fsize $rep $graph $path_tester "$save_me,$path_to_save,$stress_file_name"
  exit 1
}

stress_me

