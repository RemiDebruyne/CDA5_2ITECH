<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>

<body>
    <nav>
        <ul>
            <li><a href="http://exercice.test/">Home</a></li>
            <li><a href="http://exercice.test/about">About</a></li>
            <li><a href="http://exercice.test/contact">Contact</a></li>
        </ul>
    </nav>
    <h1>
        @yield('title')
    </h1>
    <section>
        @yield('content')
    </section>
</body>

</html>
