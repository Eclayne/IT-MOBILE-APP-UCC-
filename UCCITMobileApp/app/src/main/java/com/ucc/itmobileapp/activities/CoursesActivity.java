package com.ucc.itmobileapp.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.ucc.itmobileapp.adapters.CourseAdapter;
import com.ucc.itmobileapp.database.AppDatabase;
import com.ucc.itmobileapp.databinding.ActivityCoursesBinding;
import com.ucc.itmobileapp.models.Course;
import java.util.List;

public class CoursesActivity extends AppCompatActivity {

    private ActivityCoursesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCoursesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);
        binding.toolbar.setNavigationOnClickListener(v -> onBackPressed());

        binding.recyclerViewCourses.setLayoutManager(new LinearLayoutManager(this));

        // Load courses from Room database on background thread
        AppDatabase.databaseWriteExecutor.execute(() -> {
            AppDatabase db = AppDatabase.getDatabase(this);
            List<Course> courses = db.courseDao().getAllCourses();

            runOnUiThread(() -> {
                CourseAdapter adapter = new CourseAdapter(this, courses);
                binding.recyclerViewCourses.setAdapter(adapter);
            });
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}
