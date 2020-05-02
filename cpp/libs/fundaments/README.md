
#Notes

Most importatnt C++ standard libraries:
* vector
* string
* thread
* mutex
* unique_ptr
* fstream
* regex
* complex
* map
* ostream
* Matrix
* MOtor_controller
* Orc_warrior


Suggestion for Java Programmers

1. Don't simply mimic Java Style in C++; tha is ooftean seriously suboptimal for
booth maintainability and performance
2. Use the C++ abstraction mechanisms (e.g, classes and templates): don't fall
back to a c style if programming out of false feeling of familiarity.
3. Use the C++ standard library as a teacher  of new techniques and
programing styles.
4. Don't immediately invent a unique base for all of your classes (an Object class).
Typically, you can do better without it for many/most classes.
5. Minimize the use of reference and pointer variables: use local and member variables.
6. Remember: a variable is never implicitly a refrence.
7. Think of pointers as C++’s equivalent to Java references (C++ references are more limited; there is no reseating of C++ references).
8. A function is not virtual by default. Not ev ery class is meant for inheritance.
9. Use abstract classes as interfaces to class hierarchies; avoid ‘‘brittle base classes,’’ that is, base classes with data members.
10. Use scoped resource management (‘‘Resource Acquisition Is Initialization’’; RAII) whenev er possible.
11. Use a constructor to establish a class invariant (and throw an exception if it can’t).
12. If a cleanup action is needed when an object is deleted (e.g., goes out of scope), use a destructor for that. Don’t imitate ﬁnally (doing so is more ad hoc and in the longer run far more work than relying on destructors).
13. Avoid ‘‘naked’’ new and delete; instead, use containers (e.g., vector, string, and map) and handle classes (e.g., lock and unique_ptr).
14. Use freestanding functions (nonmember functions) to minimize coupling (e.g., see the standard algorithms), and use namespaces (§2.4.2, Chapter 14) to limit the scope of freestanding functions.
15. Don’t use exception speciﬁcations (except noexcept; §13.5.1.1).
16. A C++ nested class does not have access to an object of the enclosing class.
17. C++ offers only the most minimal run-time reﬂection: dynamic_cast and typeid (Chapter 22). Rely more on compile-time facilities (e.g., compile-time polymorphism; Chapter 27, Chapter 28).
