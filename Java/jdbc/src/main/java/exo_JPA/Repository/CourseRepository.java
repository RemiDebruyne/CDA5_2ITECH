package exo_JPA.Repository;

import exo_JPA.Entity.Course;

public class CourseRepository extends BaseRepository<Course>{
    @Override
    protected Class defineRepositoryType() {
        return Course.class;
    }
}
