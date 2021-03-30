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
  --init-size    |      -- the initial size for experimentation
  --final-size   |      -- final size for experimentation
  --step-size    |      -- increment of sizes
  --rep          |      -- number of repetitions for a each size
  --plot         | -p   -- plot data using gnuplot
  --save         | -s   -- save all output data
  --help         | -h   -- display this help and exit

  NOTE: In case a path to the tester is not specified a Solve will use the
  default path which is utilized for testing. If the folder is empty it will
  automatically generate the files
  "
  exit 1
}

default_path_to_save="$HOME/Documents/"
solved_case_file_name="stress.txt"
path_tester="default"

if [[ "$1" == "" ]] ; then
  welcome
fi


stress_me() {
    DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )"
#    java -Dfile.encoding=UTF-8 -classpath "$DIR"/out/production/Solve p1MainClasses.Stress $method $path_tester "$save_me,$path_to_save,$solved_case_file_name"

  exit 1
}

stress_me

