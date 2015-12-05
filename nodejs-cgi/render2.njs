#!C:/Program Files/nodejs/node

console.log("Content-Type: text/html\n\n");

var express = require("express");
var path = require('path');
var app = express();

app.set('view engine', 'ejs');
app.set('views', path.join(__dirname, './views'));

app.render('show', { test: 'My App Two', add: 'Two'}, function(err, html) {
  console.log(html)
});


