## When to use serial flow control
In order to execute a number of asynchronous tasks in sequence, you could use call-
backs, but if you have a significant number of tasks, you’ll have to organize them. If
you don’t, you’ll end up with messy code due to excessive callback nesting.

For more information about com-
munity add-ons for flow control, see the article “Virtual Panel: How to Survive
Asynchronous Programming in JavaScript” by Werner Schuster and Dio Syno-
dinos on InfoQ: http://mng.bz/wKnV.
