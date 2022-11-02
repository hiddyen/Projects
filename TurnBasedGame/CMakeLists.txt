cmake_minimum_required(VERSION 3.21.1)
project(PJC)

set(CMAKE_CXX_STANDARD 20)

add_executable(PJC main.cpp Pokemon.cpp SpecialPower.cpp Pokemon.hpp SpecialPower.hpp)
