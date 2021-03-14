#!/usr/bin/env bash

welcome() {
  printf "%s" "\

      _/_/_/    _/_/    _/      _/      _/  _/_/_/_/     _/_/_/      _/_/         _/_/_/  _/_/_/    _/_/_/  _/      _/  _/_/_/_/
   _/        _/    _/  _/      _/      _/  _/           _/    _/  _/    _/     _/        _/    _/    _/    _/_/  _/_/  _/
    _/_/    _/    _/  _/      _/      _/  _/_/_/       _/    _/  _/_/_/_/     _/        _/_/_/      _/    _/  _/  _/  _/_/_/
       _/  _/    _/  _/        _/  _/    _/           _/    _/  _/    _/     _/        _/    _/    _/    _/      _/  _/
_/_/_/      _/_/    _/_/_/_/    _/      _/_/_/_/     _/_/_/    _/    _/       _/_/_/  _/    _/  _/_/_/  _/      _/  _/_/_/_/


 version 0.1: Bitch Lasagna

 Options:

--path-of-data  -- parse the path of the folder containing the data (F_i_j.txt)
--all           -- if it finds the path contains multiple foders process all of em
                   else, just process the very first one
--method        -- choose one of 4 available methods: p1, p2, p3, p4, all
-s              -- save data to we_caught_the_mtherfker.txt
-v              -- verbose aka print input data and solved data
-h              -- display this help and exit
 "
 exit 1
}

additional_params=""
default_path_to_save="$HOME/Documents/"
solved_case_file_name="we_caught_the_mtherfker.txt"
#method="null"
verbosity=0


if [[ "$1" == "" ]] ; then
  welcome
fi

while test $# -gt 0; do
  case "$1" in
    -h|--help)
      welcome
      ;;
    -m|--method)
      shift
      if [[ "$1" == "p1" ]] ; then
          method="p1"
      elif [[ "$1" == "p2" ]] ; then
        method="p2"
      elif [[ "$1" == "p3" ]] ; then
        method="p3"
      elif [[ "$1" == "p4" ]] ; then
        method="p4"
      elif [[ "$1" == "all" ]] ; then
        method="all"
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
      else
        path_tester="default"
      fi
      shift
      ;;
    -v)
      verbosity="verbosity"
      ;;
    -s)
      save_me="save"
      shift
      if test $# -gt 0; then
        path_to_save="$1"
      fi
      shift
      ;;
    *)
      break
      ;;
  esac
done



solve_em() {
  DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )"
  additional_params="$verbosity,$save_me,$path_to_save$solved_case_file_name"
  java -Dfile.encoding=UTF-8 -classpath $DIR/out/production/Solve Main $method $path_tester $additional_params

  exit 1

}


#solve_em
echo $path_to_tester
echo $method