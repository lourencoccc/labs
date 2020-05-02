#Connect

Connect is a framework that uses modular components called middleware to 
implement web application logic in a reusable manner.

Connect allows you to write your own middleware but also includes several 
common components that can be used in your applications for request logging, 
static file serving, request body parsing, and session managing, among others.
Connect serves as an abstraction layer for developers who want to build their 
own higherlevel web frameworks, because Connect can be easily expanded and built upon.

## How to works

When call GET/img/logo.png to do: 1, 2, 3, 4 (res.end()).
When call POST/user/save to do: 1, 2, 3, 4, 5 (res.end()).

Where:

1. **Dispatcher** receives request and passes it to the first middleware
2. Request is **logged** and passed to the next middleware using next()
3. Request **body is parsed** if any exists and then passed to the next 
middleware using next()
4. If request is for a **static** file, response is sent with that file
and next() is not called; otherwise, the request moves to the next middleware
5. Request is handled with a **custom middleware** and response is ended

## Connect and Express

Express extend connect

## How Connect middleware works

In Connect, a middleware component is a JavaScript function that by convention
accepts three arguments: 
1. a request object
2. a response object
3. an argument commonly named next, which is a callback function indicating 
that the component is done and the next middleware component can be executed.


