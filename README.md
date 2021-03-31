
# Solve the Crime


<a href="https://github.com/FrenzyExists/Solve-The-Crime/stargazers"><img src="https://img.shields.io/github/stars/FrenzyExists/Solve-The-Crime?colorA=4c566a&colorB=BF616A&style=for-the-badge&logo=starship"></a>
<a href="https://github.com/FrenzyExists/Solve-The-Crime/issues"><img src="https://img.shields.io/github/issues/FrenzyExists/Solve-The-Crime?colorA=4c566a&colorB=88C0D0&style=for-the-badge&logo=bugatti"></a>
<a href="https://github.com/FrenzyExists/Solve-The-Crime/network/members"><img src="https://img.shields.io/github/forks/FrenzyExists/Solve-The-Crime?colorA=4c566a&colorB=BF616A&style=for-the-badge&logo=github"></a>

[![Made withJava](https://img.shields.io/badge/Made%20with-Java-BF616A?style=for-the-badge&colorA=4c566a&logo=Java)](https://java.com/en/)


<h3>:shipit: Oh Hello There! </h3>

<p align="center"> This is a Data Structures Project 🏗 </p>

Solve the Crime is a simple project done by the students taking the course of, well, Data Structures of the University of Puerto Rico, Spring 2021. This project is based upon a story that our Professor gave us. You can refer to the document located at `specifications`

## TL;DR
Our job is to program something that takes a folder full of data, convert it into a 3D matrix, convert that 3D matrix into a multiset, which represents the union of the 3D matrix and finally implement 4 distinct methods which are given (in a partial pseudocode). These methods given are ways to obtain a 1D set which represents the intersection of the given multiset, each more efficient than the other. If, you want to know more in depth about each method refer to the doc the prof gave us.

## Ok, so what?
Well, this Set that the program outputs represents the number of events that appear in ALL events T. So, yeah, that's kinda it...
...
...
... 
Nope! This branch also contains a stress test, which is part of the optional part of this project. According to the document, each technique to obtain the intersection varies in efficiency, the optional part of the project was to display a stress run over each technique and plot the data on an Excel-like program like Google Sheets. However, I thought this was quite silly. Why plotting the data manually over an external program when we have gnuplot to the heavy-lifting for us?

And so, this branch can plot the test in gnuplot (so make sure you have gnuplot installed). The stress tester also will pretty-print a data table and also has the option to save such in a csv file.

## So... ok, I get it, a college project, cool. But what is the purpose of it?
#### Simple: ~make us suffer~ 🤣

Ok no, just joking. During the course we've been learning different structures like Bags, Stacks, Sets and other structures. In this case we would apply Sets, and the different ways it may be implemented.

## Sounds cool n all, but how can I run this?
* At the moment you could manually compile the java code via the terminal, but it is preferred if it's done from an IDE such as [IntelliJ](https://www.jetbrains.com/idea/). Make sure you have Java compiler and its respective JVM (Java Virtual Machine) version 15.
* After compiling `Main.java` and `Stream.java`, verify that the folder `out` is created, which will contain all the `class` files. 
* After the project is compiled, move to the directory where `solve.sh` is located
* Then type the following:

```
chmod x+ solve.sh
```

Then,

```
./solve.sh --method all -s --path-tester /path/of/stuff
```

As an example. This is will process a desired folder with the data and will utilize all 4 methods and save it on the `Documents` directory.

However, if you wish to try the stress tester, performed the following:

* While being in the same directory as `solve.sh` type:

```
chmod x+ stress.sh
```

Then, 

```
./stress.sh -- <> -- <> -- <> -- <>
```



## TODO 🗒
- [ ] Complete Optional Section

### NOTE
This branch merged Methods 1 and 2 (Alfa and Beta) as a single file as both utilize the same base loop

<p align="center"><a href="https://github.com/Axarva/dotfiles-2.0/blob/main/LICENSE"><img src="https://img.shields.io/badge/license-MIT-orange.svg?colorA=4c566a&colorB=88c0d0&style=for-the-badge&logo=mitsubishi"></a></p>

