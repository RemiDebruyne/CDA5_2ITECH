<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use DateTime;
use Arr;
use Illuminate\Database\Eloquent\Relations\BelongsTo;
use Illuminate\Database\Eloquent\Relations\HasMany;

class Vinyl extends Model
{

    use HasFactory;

    protected $fillable = ['title', 'release_year', 'label', 'description'];

    public int $id;
    public string $title;
    public string $description;
    public string $label;
    public string $artist;
    public DateTime $releaseDate;
    public string $coverImage;

    // public function __construct(
    //     int $id,
    //     string $title,
    //     string $description,
    //     string $label,
    //     string $artist,
    //     DateTime $releaseDate,
    //     string $coverImage
    // ) {
    //     $this->id = $id;
    //     $this->title = $title;
    //     $this->description = $description;
    //     $this->label = $label;
    //     $this->artist = $artist;
    //     $this->releaseDate = $releaseDate;
    //     $this->coverImage = $coverImage;
    // }

    public function artist(): BelongsTo {
        return $this->belongsTo(Artist::class);
    }

    public function comment() : HasMany {
        return $this->hasMany(Comment::class);
    }
}
