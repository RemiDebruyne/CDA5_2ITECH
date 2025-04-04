@foreach ($jobs as $job )
    <p>{{ $job['title'] }} : {{ $job['salary']}}</p>
@endforeach

@foreach ($jobs2 as $job )
    <p>{{ $job['title'] }} : {{ $job['salary']}}</p>
@endforeach