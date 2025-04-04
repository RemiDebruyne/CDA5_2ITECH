@extends('layouts.app')

@section('title', 'Contacts')

@section('content')
    <ul>
        @foreach ($users as $user)
            <li>{{ $user }}</li>
        @endforeach
    </ul>

@endsection