<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://unpkg.com/@tailwindcss/browser@4"></script>
    <title>Document</title>
</head>

<body>
    <div class="md:flex">
        <div class="md:flex-shrink-0">
            <img class="rounded-lg md:w-56" src="{{ $vinyl->coverImage }}" alt="">
        </div>
        <div class="w-80     mt-4 md:mt-0 md:ml-6">
            <div class="uppercase tracking-wide text-sm text-indigo-600 font-bold">{{ $vinyl->title }} </div>
            <a href="#"
                class="block mt-1 text-lg leading-tight font-semibold text-gray-900 hover:underline">{{ $vinyl->artist }}</a>
            <p class="mt-2 text-gray-600">
                {{ $vinyl->description }} <br>
                Label : {{ $vinyl->label }} <br>
                Date de sortie : {{ $vinyl->releaseDate->format('d-m-Y') }}
            </p>
        </div>
    </div>
</body>

</html>