package com.ucc.itmobileapp.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.ucc.itmobileapp.models.Course;
import java.util.List;

@Dao
public interface CourseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Course> courses);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Course course);

    @Query("SELECT * FROM courses ORDER BY code ASC")
    List<Course> getAllCourses();

    @Query("SELECT * FROM courses WHERE code = :courseCode LIMIT 1")
    Course getCourseByCode(String courseCode);

    @Query("SELECT COUNT(*) FROM courses")
    int getCount();

    @Query("DELETE FROM courses")
    void deleteAll();
}
