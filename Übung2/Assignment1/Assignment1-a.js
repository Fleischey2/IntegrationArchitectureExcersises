//Object Creation can be done by

// - using object initializers for example:
const object = {
    attribute = value
};

// - using a constructor function for example:
function person(name) {
    this.name = name;
}

// - using the Object.create() method for example(using the const object from above):
const object1 = Object.create(object);

//Functions and Callback Handler
//A function ist simply provided like that (important is the use of the "function" keyword):
function myFunction(param) {
    return param;
}
//Callbacks are handled by creating a function and passing it in the parameters:
function fetchData(callbackfunction) {
    //fetching data...
    callbackfunction(fetchedData)
}
//and use the function like that:
fetchData(function (fetchedData) {
    console.log(fetchedData)
})
//The term "Pyramid of Doom" is used because when you want to for example call the api and after that call the api again
//but with the result of the first api all and so on you get structures like this (pseudocode):
const fetchData = function(param, callback) {
    database.getData((error, data) => {
      if(error) {
        callback(error)
      } else {
        database.getDataWithParam(data, (error, data) => {
            if(error) {
                callback(error)
            } else {
                callback(data)
            }
        })
      }
    })
}
//Promise solves the problem of the callback hell and is used like that:
const promise = promiseFunction();
//and instead of the structure above you use .then and just append what should be executed then:
const promise2 = promise.then(callback);

//async declares that a function is asynchronous and the await term is used inside a function
//to use wait for results after continuing the following functions based on the promise functionality, for example
async function myFunction() {
    return "test";
}
//is similar to:
function myFunction() {
    return Promise.resolve("test");
}
//and the await functionality is used like this:
async function myFunction() {
    await "test";
    //other functions
}
//and is similar to:
function myyFunction() {
    return Promise.resolve("test").then(() => undefined);
}

//To create a REST-based interface with Express.js you need to install express like:
npm install express
//and use it like:
import express from 'express';

const app = express();
//to create a simple GET and POST:
app.get('/getData', (req, res) => {
    return res.send('Callback message');
});

app.post('/postData', (req, res) => {
    return res.send('Callback message');
});

//implementation of the managePersonal interface as REST can be seen in "ManagePersonalRest/routes/index.js"

//to consume a REST-based interface with Axios you also need to install it:
npm install axios

//and to perform a get request for example:
const api_url = 'localhost/api/getData';
axios.get(api_url).then(function (response) {
    console.log(response.data);
}).catch(function (error) {
    console.log(error)
})

//to use cookies with Express.js you yet again have to install a cookie-parser:
npm install cookie-parser

//and use it in app like that (modifying the get from above):
var cookieParser = require('cookie-parser');
app.use(cookieParser());

app.get('/getData', function(req, res) => {
    res.cookie('name', 'express').send('cookie set');
});

//and check/read the cookie you can use:
console.log(document.cookie); //and it will print out "name = express" in the console

//to delete a cookie you can use:
res.clearCookie('express') //inside a get or post api function


//a module implementing the calculation of the bonus salary of a salesman
//see file "computeSocialPerformance.js"


//To implement the Observer Pattern using RxJS you first have to install RxJS:
npm install rxjs

//and the implementation looks like that:
const { Subject } = require('rxjs');

const observable = new Subject();

const observer1 = {
    next: (data) => console.log(`Observer 1 received data: ${data}`),
};

observable.subscribe(observer1);
observable.next('test')

/**
Definition of "Asynchrony":
In a program that runs code line after line, waiting for one line of code to be finished before executing the next, asynchrony helps by
executing code in the background, while the rest of the code can finish. To utilize asynchrony in Javascript code, there are classees like
Callback functions, Promises and async/await.

Source: https://www.freecodecamp.org/news/asynchronous-javascript/
**/

/**
Definition of "Parallelism":
Parallelism is used when a system implements "Multiprocessing". The technique parallelism executes tasks at the same time by using processors
that are added to the system. Each CPU functions independently and unlike threads allocates unique memory to each process or task.

Source: https://medium.com/sessionstack-blog/how-javascript-works-parallelism-vs-concurrency-in-javascript-whats-the-difference-99fc3602b9f5
**/

/**
Definition of "Concurrency":
Concurrency is another efficiency "tool" like Parallelism, but instead of using processors which perform the different tasks, Concurrency or "Multithreading"
uses a single process, a shared memory and resources, to run tasks with different threads. Basically Concurrency splits up tasks to perform on different
threads therefore reducing the time the tasks take to be executed.

Source: https://medium.com/sessionstack-blog/how-javascript-works-parallelism-vs-concurrency-in-javascript-whats-the-difference-99fc3602b9f5
**/

