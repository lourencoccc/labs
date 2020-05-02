#Histogram

Application for generate histogram from opencv

##Objective

This project is a example about how to implement a native lib C++ and how to use
in java project.

##Architecture

histogram
  |- histo-lib-cpp
    |- hidtocv //cpp source, generate histogram
    |- histocvtest //cpp test source
  |- histo-lib-java // integration java lib
  |- histo-app-java // java app


##Build on Windows

        makdir build
        cd build
        cmake ..
        cmake --build

##Build on Mac

        makdir build
        cd build
        cmake ..
        cmake --build

##Build on Linux


javah -classpath .\histocv-lib-java\build\classes\main -o .\histocv-lib-cpp\histocv\HistoOpenCv.h org.histocv.lib.HistoOpenCv


https://blog.kitware.com/create-dlls-on-windows-without-declspec-using-new-cmake-export-all-feature/


https://cmake.org/cmake/help/v3.5/manual/cmake.1.html#command-line-tool-mode
