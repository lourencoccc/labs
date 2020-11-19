
#------------------------------------------------------------------------------
# This makefile configure the  application build for all supported platforms 
#
# Use: make [TARGET] [PLATFORM-OVERRIDES]
#
# Build Targets:
#      This build file support HOST and RPI platform.
# 
# Platform Overrides:
#      No overrides is applied.
#
#------------------------------------------------------------------------------

# Include common sources
# General Source files
SOURCES = ./src/main.c \
	./src/mycalc.c \

# General include paths
INCLUDES = -I ./include

BUILD_DIR = ./build
SRC_DIR = ./src
TOOLCHAIN_RPI = /home/joaolourenco/toolchain/raspberrypi/tools/arm-bcm2708/gcc-linaro-arm-linux-gnueabihf-raspbian
TOOLCHAIN_WASI = /home/joaolourenco/toolchain/wasi/wasi-sdk-11.0

$(shell mkdir -p $(BUILD_DIR))

ifeq ($(VERBOSE),1)
  VBFLAGS = -DVERBOSE
endif

# The base name target
TARGET = hello.out

ifeq ($(PLATFORM),RPI)
  CC = $(TOOLCHAIN_RPI)/bin/arm-linux-gnueabihf-gcc
  LD = $(TOOLCHAIN_RPI)/bin/arm-linux-gnueabihf-ld
  LDFLAGS = -Wl,-O0,-Map=$(BUILD_DIR)/$(TARGET).map
  CFLAGS = -std=c99 -Wall -Werror -g -MD
endif

ifeq ($(PLATFORM),WASI)
  TARGET = hello.wasm
  CC = $(TOOLCHAIN_WASI)/bin/clang
  LD = $(TOOLCHAIN_WASI)/bin/wasm-ld
  LDFLAGS = -Wl,-O0
  CFLAGS = --sysroot=$(TOOLCHAIN_WASI)/share/wasi-sysroot -std=c99 -Wall -Werror -g -MD
endif

ifeq ($(PLATFORM),HOST)
  CC = gcc
  LD = ld
  CFLAGS = -std=c99 -Wall -Werror -g -MD $(VBFLAGS)
  LDFLAGS = -Wl,-O0,-Map=$(BUILD_DIR)/$(TARGET).map
endif

# Create object files for each .c file
OBJS = $(SOURCES:.c=.o)

# Generate the object file for all c-source files (but do not link) 
# by specifying the object file you want to compile.
%.o : %.c
	$(CC) -c $^ $(CFLAGS) $(INCLUDES) -o $@

.PHONY: compile-all
compile-all: $(SOURCES)
	$(CC) -c $^ $(CFLAGS) $(INCLUDES)

.PHONY: build
build: all

.PHONY: all
all: $(TARGET)

$(TARGET): $(SOURCES)
	$(CC) $(CFLAGS) $(LDFLAGS) $(INCLUDES) -o $(BUILD_DIR)/$@ $^ > $(BUILD_DIR)/$*.d;

.PHONY: clean
clean:
	rm -fr $(BUILD_DIR) \
	rm -f ./src/*.d

