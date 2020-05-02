cmake_minimum_required (VERSION 3.7)
project (crosscompile)

# The version number.
set (crosscompile_VERSION_MAJOR 1)
set (crosscompile_VERSION_MINOR 0)


if(UNIX AND NOT APPLE)
    set(LINUX TRUE)
endif()
include_directories("include/")

if(UNIX)
    message(STATUS ">>> Linux/OSx")
#    set(BUILD_SHARED_LIBS OFF)
    set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++17")
elseif(WIN32)
    message(STATUS ">>> Windows")
#   set(BUILD_SHARED_LIBS OFF)
    set(CMAKE_CXX_FLAGS_RELEASE "${CMAKE_CXX_FLAGS_RELEASE} /MT")
    set(CMAKE_CXX_FLAGS_DEBUG "${CMAKE_CXX_FLAGS_DEBUG} /MTd")
    add_compile_options("/std:c++17")
endif()

add_executable(c1_array src/c1_array.cpp)

add_executable(c1_vector src/c1_vector.cpp)

