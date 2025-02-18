<?php

use App\Models\Vinyl;
use Illuminate\Support\Facades\Route;

Route::get('/', function () {
    return view('home', ['vinyls' => Vinyl::GetAll()]);
});

Route::get('/vinyls/{id}', function ($id) {
    return view('vinylDetails', ['vinyl' => Vinyl::Find($id)]);
}); 