<?php

use Illuminate\Support\Facades\Route;

// Route::get('/', function () {
//     return view('welcome');
// });

Route::get('/', function () {
    $user = (object) [
        'firstName' => 'jean',
        'lastName' => 'bon',
    ];

    return view('home', [
        'user' => $user
    ]);
});

Route::get('/contact', function () {
    $users = ['jean', 'pierre','paul'];

    return view('contact', ['users' => $users]);
});


Route::get('/about', function () {
    return view('about');
});