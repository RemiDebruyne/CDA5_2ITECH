<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\Relations\BelongsTo;
use Illuminate\Database\Eloquent\Relations\HasOne;

class Comment extends Model
{
    use HasFactory;

    protected $fillable = [
        'content'
    ];

    public function user(): BelongsTo {
        return $this->belongsTo(User::class);
    }

    public function vinyl(): BelongsTo {
        return $this->belongsTo(Vinyl::class);
    }
}
