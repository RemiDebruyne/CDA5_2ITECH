@extends('layouts.app')

@section('title', 'Accueil')

@section('content')
    <p>Hello  {{$user->firstName.' '.$user->lastName}}</p>
@endsection()