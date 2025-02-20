<?php

namespace Database\Factories;

use Illuminate\Database\Eloquent\Factories\Factory;
use App\Models\User;
use App\Models\Vinyl;

/**
 * @extends \Illuminate\Database\Eloquent\Factories\Factory<\App\Models\Comment>
 */
class CommentFactory extends Factory
{
    /**
     * Define the model's default state.
     *
     * @return array<string, mixed>
     */
    public function definition(): array
    {
        return [
            'content' => fake()->text(),
            'user_id' => User::factory()->recycle(User::factory()->create())->create(),
            'vinyl' => Vinyl::factory()->recycle(Vinyl::factory()->create())->create(),
        ];
    }
}
