@props(['vinyl'])

<div class="group relative">
        <img src="{{ $vinyl->coverImage }}"
            alt="Front of men&#039;s Basic Tee in black."
            class="aspect-square w-full rounded-md bg-gray-200 object-cover group-hover:opacity-75 lg:aspect-auto lg:h-80">
        <div class="mt-4 flex justify-between">
            <div>
                <h3 class="text-sm text-gray-700">
                    <a {{ $attributes }}>
                        <span aria-hidden="true" class="absolute inset-0"></span>
                        {{ $vinyl->title }}
                    </a>
                </h3>
                <p class="mt-1 text-sm text-gray-500">{{ $vinyl->artist }}</p>
            </div>
            <p class="text-sm font-medium text-gray-900">{{$vinyl->releaseDate->format('d-m-Y') }}</p>
            </div>
</div>