#Effective JavaScript - SUmary

##Item 1: Know Which JavaScript You Are Using
ES5 introduced another versioning consideration with its strict mode.
This feature allows you to opt in to a restricted version of JavaScript
that disallows some of the more problematic or error-prone features
of the full language.Strict mode is enabled in a
program by adding a special string constant at the very beginning of
the program:

        "use strict";

**Things to Remember:**

* Decide which versions of JavaScript your application supports.
* Be sure that any JavaScript features you use are supported by all
environments where your application runs.
* Always test strict code in environments that perform the strict-
mode checks.
* Beware of concatenating scripts that differ in their expectations
about strict mode.

##Item 2: Understand JavaScript’s Floating-Point Numbers

All numbers in javaScript are double-precission floating-point number, that is,
the 64-bit encoding by IEEE 754 standard - commonly know as "doubles".

Keep in mind double represent intgers with 53 bit of precision. All of the
intgers from -9.007.199.254.740.992 (-2^53) to (2^53).


        0.1 * 1.9; //0.19
        -99 + 100; //1
        21 - 12.3; //8.7
        2.5 / 5; //0.5
        21 % 8; //5

**The bitwise arithmetic:**

        8 | 1; //9 in 32 bits
        //details:
        (8).toString(2); // "1000"
        (1).toString(2); // "0001"
        (9).toString(2); // "1001"
    
**Floating-point numbers:**

        (0.1 + 0.2) + 0.3; // 0.6000000000000001
        0.1 + (0.2 + 0.3); // 0.6

**Things to Remember:**

* JavaScript numbers are double-precision floating-point numbers.
* Integers in JavaScript are just a subset of doubles rather than a
separate datatype.
* Bitwise operators treat numbers as if they were 32-bit signed integers.
* Be aware of limitations of precisions in floating-point arithmetic.

##Item 3: Beware of Implicit Coercions

TODO continue to read on page 9
