<?php

use Illuminate\Support\Facades\Route;
use App\Models\job; 

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

Route::Get('/jobs', function(){
    return view('jobs', [
        'jobs'=> Job::all(), 
        'jobs2' => Job::GetAll()]);
});