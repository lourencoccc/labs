# CMakeList.txt : CMake project for procpp, include source and define
# project specific logic here.
#
cmake_minimum_required (VERSION 3.8)

# Add source to this project's executable.
add_executable (procpp "procpp.cpp" "procpp.h")
add_executable(arrays_chars "arrays_chars.cpp")


# TODO: Add tests and install targets if needed.
