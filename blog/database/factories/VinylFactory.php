<?php

namespace Database\Factories;

use Illuminate\Database\Eloquent\Factories\Factory;
use App\Models\Artist;


/**
 * @extends \Illuminate\Database\Eloquent\Factories\Factory<\App\Models\Vinyl>
 */
class VinylFactory extends Factory
{
    private $albums = [
        "Abbey Road",
        "The Dark Side of the Moon",
        "Back in Black",
        "Thriller",
        "The Wall",
        "Rumours",
        "Hotel California",
        "Led Zeppelin IV",
        "Sticky Fingers",
        "The White Album",
        "A Night at the Opera",
        "Born to Run",
        "The Joshua Tree",
        "In the Wee Small Hours",
        "London Calling",
        "Exile on Main St.",
        "The Chronic",
        "Purple Rain",
        "The Velvet Underground & Nico",
        "Highway 61 Revisited",
        "The Rise and Fall of Ziggy Stardust and the Spiders from Mars",
        "Abbey Road",
        "Revolver",
        "The Suburbs",
        "Aqualung",
        "Nevermind",
        "Pet Sounds",
        "Blood on the Tracks",
        "OK Computer",
        "The Dark Side of the Moon",
        "Who's Next",
        "Rumours",
        "Led Zeppelin II",
        "The Joshua Tree",
        "The Miseducation of Lauryn Hill",
        "Back in Black",
        "Let It Bleed",
        "The Doors",
        "The Queen Is Dead",
        "Born in the U.S.A.",
        "Master of Puppets",
        "Graceland",
        "The Freewheelin' Bob Dylan",
        "21",
        "The College Dropout",
        "The Beatles (White Album)",
        "Tommy",
        "Innervisions",
        "Hounds of Love",
        "To Pimp a Butterfly",
        "Darkness on the Edge of Town",
        "Kind of Blue",
        "The Chronic",
        "Blue",
        "Channel Orange",
        "My Beautiful Dark Twisted Fantasy",
        "Electric Ladyland",
        "The Fame Monster",
        "Purple Rain",
        "Kid A",
        "Highway 61 Revisited",
        "Blackstar",
        "Reign in Blood",
        "Disintegration",
        "OutKast - Speakerboxxx/The Love Below",
        "Random Access Memories",
        "Lemonade",
        "Abbey Road",
        "Pet Sounds",
        "Fearless",
        "The Marshall Mathers LP",
        "Bridge Over Troubled Water",
        "The Piper at the Gates of Dawn",
        "The Rise and Fall of Ziggy Stardust and the Spiders from Mars",
        "The Stone Roses",
        "Californication",
        "Electric Warrior",
        "What’s Going On",
        "The Low End Theory",
        "The Bends",
        "OK Computer",
        "Bitches Brew",
        "Mellon Collie and the Infinite Sadness",
        "Sgt. Pepper’s Lonely Hearts Club Band",
        "London Calling",
        "The Velvet Underground & Nico",
        "Born to Die",
        "The Black Album",
        "Good Kid, M.A.A.D City",
        "Ten",
        "Dark Side of the Moon",
        "Innervisions",
        "Exile on Main St.",
        "Room on Fire",
        "Abbey Road",
        "The Battle of Los Angeles",
        "Bridge Over Troubled Water",
        "To Pimp a Butterfly"
    ];
    
    /**
     * Define the model's default state.
     *
     * @return array<string, mixed>
     */
    public function definition(): array
    {
        return [
            'title' => $this->albums[array_rand($this->albums)],
            'description' => fake()->text(),
            'release_year' => fake()->date('d-m-Y'),
            'label' => fake()->company(),
            'artist_id' => Artist::factory()->recycle(Artist::all())->create()
        ];
    }
}
