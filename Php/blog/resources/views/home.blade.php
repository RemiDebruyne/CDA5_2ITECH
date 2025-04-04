<x-layout>
  @foreach ($vinyls as $vinyl)
    <x-vinyl-card href="/vinyls/{{$vinyl->id}}" :vinyl="$vinyl"></x-vinyl-card>
  @endforeach     
</x-layout>
