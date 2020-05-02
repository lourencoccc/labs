
cmake_minimum_required(VERSION 3.5.0)
project(Histocv)

include (GenerateExportHeader)

set(CMAKE_MACOSX_RPATH 1)

find_package(OpenCV REQUIRED)
find_package(JNI REQUIRED)

include_directories(${JNI_INCLUDE_DIRS})

#CMAKE_HOME_DIRECTORY=C:/Users/joao_lourenco/Lab/lab-cpp/histocv/histocv-lib-cpp/histocv
#PROJECT_SOURCE_DIR
#CMAKE_HOST_SYSTEM_NAME Linux, Windows, or Darwin

#CMAKE_VS_PLATFORM_NAME Win32 or x64
#CMAKE_VS_PLATFORM_NAME=x64

#CMAKE_GENERATOR=Visual Studio 12 2013
#CMAKE_GENERATOR=Visual Studio 12 2013 Win64

#CMAKE_VS_PLATFORM_TOOLSET=v120

set(HCV_INSTALL_DIR "${CMAKE_HOME_DIRECTORY}/install/${CMAKE_HOST_SYSTEM_NAME}")
set(WIN FALSE)
set(MAC FALSE)

if("${CMAKE_HOST_SYSTEM_NAME}" STREQUAL "Windows")
    set(HCV_INSTALL_DIR "${HCV_INSTALL_DIR}/${CMAKE_VS_PLATFORM_NAME}")
    set(CMAKE_WINDOWS_EXPORT_ALL_SYMBOLS TRUE)
    set(DBUILD_SHARED_LIBS TRUE)
    set(WIN TRUE)
    message(STATUS "Configure Windows install dir")
elseif("${CMAKE_HOST_SYSTEM_NAME}" STREQUAL "Darwin")
    set(MAC TRUE)
    message(STATUS "Configure Darwin install dir")
endif()

if(${CMAKE_BUILD_TYPE})
    set(HCV_INSTALL_DIR "${HCV_INSTALL_DIR}/${CMAKE_BUILD_TYPE}")
endif()

file(REMOVE_RECURSE ${HCV_INSTALL_DIR})
file(MAKE_DIRECTORY ${HCV_INSTALL_DIR})

set(HCV_INSTALL_DIR_BIN "${HCV_INSTALL_DIR}/bin")
file(MAKE_DIRECTORY ${HCV_INSTALL_DIR_BIN})
set(HCV_INSTALL_DIR_JAVA "${HCV_INSTALL_DIR}/java")
file(MAKE_DIRECTORY ${HCV_INSTALL_DIR_JAVA})

if(WIN)
    set(HCV_INSTALL_DIR_LIB "${HCV_INSTALL_DIR}/lib")
    file(MAKE_DIRECTORY ${HCV_INSTALL_DIR_LIB})
    set(HCV_INSTALL_DIR_STATICLIB "${HCV_INSTALL_DIR}/staticlib")
    file(MAKE_DIRECTORY ${HCV_INSTALL_DIR_STATICLIB})
endif()


#message(STATUS "PROJECT_SOURCE_DIR ${PROJECT_SOURCE_DIR}")

#file(MAKE_DIRECTORY ${directory})

#CMAKE_BINARY_DIR

#if(${CMAKE_HOST_SYSTEM_NAME} EQUAL "Windows")

#endif(${CMAKE_HOST_SYSTEM_NAME} EQUAL "Windows")

#message(STATUS "-- PROJECT_BINARY_DIR ${PROJECT_BINARY_DIR}")
#message(STATUS "-- BINARY_DIR ${BINARY_DIR}")

#get_cmake_property(_variableNames VARIABLES)
#foreach (_variableName ${_variableNames})
#    message(STATUS "${_variableName}=${${_variableName}}")
#endforeach()


add_library(histocv SHARED histocv.cpp)
if(WIN)
    generate_export_header(histocv)
endif()
#add_library(histocvstatic STATIC  histocv.cpp)
add_library(histocvjava SHARED histocv.cpp HistoOpenCv.cpp)
target_link_libraries( histocv ${OpenCV_LIBS} )
target_link_libraries( histocvjava ${OpenCV_LIBS} )

if(WIN)
    add_custom_command(TARGET histocv POST_BUILD
        COMMAND ${CMAKE_COMMAND} -E copy ${CMAKE_BINARY_DIR}/${CMAKE_BUILD_TYPE}/histocv.dll ${HCV_INSTALL_DIR_BIN}
        COMMAND ${CMAKE_COMMAND} -E copy ${CMAKE_BINARY_DIR}/${CMAKE_BUILD_TYPE}/histocv.pdb ${HCV_INSTALL_DIR_LIB}
        COMMAND ${CMAKE_COMMAND} -E copy ${CMAKE_BINARY_DIR}/${CMAKE_BUILD_TYPE}/histocv.lib ${HCV_INSTALL_DIR_LIB}
    )
    add_custom_command(TARGET histocvjava POST_BUILD
        COMMAND ${CMAKE_COMMAND} -E copy ${CMAKE_BINARY_DIR}/Debug/histocvjava.dll ${HCV_INSTALL_DIR_JAVA}
    )
elseif(MAC)
    add_custom_command(TARGET histocv POST_BUILD
      COMMAND ${CMAKE_COMMAND} -E copy ${CMAKE_BINARY_DIR}/libhistocv.dylib ${HCV_INSTALL_DIR_BIN}
    )
    add_custom_command(TARGET histocvjava POST_BUILD
      COMMAND ${CMAKE_COMMAND} -E copy ${CMAKE_BINARY_DIR}/libhistocvjava.dylib ${HCV_INSTALL_DIR_JAVA}
    )
endif()


#install(TARGETS histocv DESTINATION lib)
#install(FILES histocv.h DESTINATION include)

#install(TARGETS histocvjava DESTINATION lib)
#install(FILES histocv.h HistoOpenCv.h DESTINATION include)
