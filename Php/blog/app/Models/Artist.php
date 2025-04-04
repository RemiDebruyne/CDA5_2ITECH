<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\Relations\HasMany;

class Artist extends Model
{
    use HasFactory;

    protected $fillable = [
        'name', 'country' , 'birth_year',
    ];

    public function vinyl(): HasMany {
        return $this->hasMany(Vinyl::class);
    }
}
