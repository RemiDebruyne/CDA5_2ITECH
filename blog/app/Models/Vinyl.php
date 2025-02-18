<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;
use DateTime;
use Arr;

class Vinyl extends Model
{
    public int $id;
    public string $title;
    public string $description;
    public string $label;
    public string $artist;
    public DateTime $releaseDate;
    public string $coverImage;

    public function __construct(
        int $id,
        string $title,
        string $description,
        string $label,
        string $artist,
        DateTime $releaseDate,
        string $coverImage
    ) {
        $this->id = $id;
        $this->title = $title;
        $this->description = $description;
        $this->label = $label;
        $this->artist = $artist;
        $this->releaseDate = $releaseDate;
        $this->coverImage = $coverImage;
    }

    public static function GetAll(): array{
        return [
            new Vinyl(
                1,
                "Abbey Road",
                "Le dernier album studio des Beatles, considéré comme l'un des meilleurs de tous les temps.",
                "Apple Records",
                "The Beatles",
                new DateTime("1969-09-26"),
                "https://upload.wikimedia.org/wikipedia/en/4/42/Beatles_-_Abbey_Road.jpg"
            ),
            new Vinyl(
                2,
                "Back in Black",
                "L'album emblématique d'AC/DC, qui marque le retour du groupe après la mort de Bon Scott.",
                "Atlantic Records",
                "AC/DC",
                new DateTime("1980-07-25"),
                "https://upload.wikimedia.org/wikipedia/commons/9/92/ACDC_Back_in_Black.png"
            ),
            new Vinyl(
                3,
                "The Dark Side of the Moon",
                "L'album concept de Pink Floyd, l'un des plus influents de l'histoire du rock.",
                "Harvest Records",
                "Pink Floyd",
                new DateTime("1973-03-01"),
                "https://upload.wikimedia.org/wikipedia/en/3/3b/Dark_Side_of_the_Moon.png"
            ),
            new Vinyl(
                4,
                "Thriller",
                "L'album iconique de Michael Jackson, le plus vendu de tous les temps.",
                "Epic Records",
                "Michael Jackson",
                new DateTime("1982-11-30"),
                "https://cdn-images.dzcdn.net/images/cover/544862aa5be45bc82ad4ab1a14daf63a/500x500.jpg"
            ),
            new Vinyl(
                5,
                "The Wall",
                "Un autre album concept de Pink Floyd, abordant des thèmes de l'isolement et de la guerre.",
                "Harvest Records",
                "Pink Floyd",
                new DateTime("1979-11-30"),
                "https://pure-music.co.uk/wp-content/uploads/2019/11/the-wall-album-cover-355x321.jpg.webp"
            )
        ];   
    }

    
    public static function Find($id): Vinyl{
        return Arr::first(Vinyl::GetAll(), fn($vinyl) => $vinyl->id == $id);
    }
}
