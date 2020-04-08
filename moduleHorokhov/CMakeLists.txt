cmake_minimum_required(VERSION 3.15)
project(moduleHorokhov)

set(CMAKE_CXX_STANDARD 14)

add_executable(moduleHorokhov main.cpp task1/Matrix.cpp task1/Matrix.h task2/FindLST.cpp task2/FindLST.h)