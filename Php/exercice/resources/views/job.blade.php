<x-layout>
  <x-slot:title>Job</x-slot:title>

    <h2>{{ $job['title'] }}</h2>
    <p>
      Salaire par année: {{ $job['salary'] }}
    </p>
</x-layout>