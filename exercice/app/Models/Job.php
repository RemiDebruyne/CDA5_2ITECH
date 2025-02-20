<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use Illuminate\Support\Arr;

class Job extends Model
{
    use HasFactory;
    protected $table = "job_listing";

    protected $fillable = ["title", "salary","employer_id"];

    public int $id;
    public string $title;
    public int $salary;

    public static function GetAll(){
        return [
            [
                'id' => 1,
                'title' => 'teacher',
                'salary' => '30 000',
            ],
            [
                'id' => 2,
                'title' => 'scientist',
                'salary' => '40 000',
            ],
            [
                'id' => 3,
                'title' => 'developer',
                'salary' => '50 000',
            ],
        ];
    }

    // public static function find($id){
    //     $job = Arr::first(Job::GetAll(), fn($job) => $job['id'] == $id);

    //     if (!$job){
    //         abort(404);
    //     }

    //     return $job;
    // }
}
