/**
* NOT A FRAMEWORK. React is a library more similar to jQuery than Angular or other full front-end frameworks.
* A significant portion of code written in React is actually just JavaScript code
* React is designed to be separated from the DOM for the most part

* EX:
*/

import React from 'react'
import ReactDOM from 'react-dom'

ReactDOM.render(
    <h1>Hello, world!</h1>, // <- This is NOT HTML, rather it is some syntatic sugar (JSX) to help write HTML in React.
    document.getElementById('root')
)

/**
 * Check out Fetch.js, a library for making AJAX calls.
 * Check out Yarn, a JS dependency manager
 * Check out Babel, a JS transcompiler for ES6 to older JS versions.
 */