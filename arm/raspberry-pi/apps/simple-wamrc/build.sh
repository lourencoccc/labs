#!/bin/sh

/opt/wasi-sdk/bin/clang -O3 -nostdlib \
    -z stack-size=8192 -Wl,--initial-memory=65536 \
    -Wl,--export=main -o test.wasm test.c \
    -Wl,--export=__heap_base,--export=__data_end \
    -Wl,--no-entry -Wl,--strip-all -Wl,--allow-undefined
