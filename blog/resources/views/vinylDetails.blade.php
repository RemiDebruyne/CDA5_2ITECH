<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://unpkg.com/@tailwindcss/browser@4"></script>
    <title>Document</title>
</head>
<body>
<img src="{{ $vinyl->coverImage }}" alt="" class="h-96 w-96">
<p >
    {{ $vinyl->title }} <br>
    {{ $vinyl->artist }} <br>
    {{ $vinyl->description }} <br>
    {{ $vinyl->releaseDate->format('d-m-Y') }} <br>
    {{ $vinyl->label }} <br>
</p>
</body>
</html>

