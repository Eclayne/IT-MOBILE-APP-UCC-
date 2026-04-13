package com.ucc.itmobileapp.activities;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.ucc.itmobileapp.databinding.ActivityCourseDetailBinding;

public class CourseDetailActivity extends AppCompatActivity {

    public static final String EXTRA_COURSE_CODE = "extra_course_code";
    public static final String EXTRA_COURSE_NAME = "extra_course_name";
    public static final String EXTRA_CREDITS = "extra_credits";
    public static final String EXTRA_PREREQUISITES = "extra_prerequisites";
    public static final String EXTRA_DESCRIPTION = "extra_description";

    private ActivityCourseDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCourseDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);
        binding.toolbar.setNavigationOnClickListener(v -> onBackPressed());

        // Retrieve extras
        String code = getIntent().getStringExtra(EXTRA_COURSE_CODE);
        String name = getIntent().getStringExtra(EXTRA_COURSE_NAME);
        int credits = getIntent().getIntExtra(EXTRA_CREDITS, 0);
        String prerequisites = getIntent().getStringExtra(EXTRA_PREREQUISITES);
        String description = getIntent().getStringExtra(EXTRA_DESCRIPTION);

        // Populate views
        binding.chipCode.setText(code);
        binding.chipCredits.setText(credits + " Credits");
        binding.tvCourseName.setText(name);
        binding.tvDescription.setText(description);
        binding.tvPrerequisites.setText(
            (prerequisites == null || prerequisites.isEmpty() || prerequisites.equalsIgnoreCase("None"))
                ? "None"
                : prerequisites
        );

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(code);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}
