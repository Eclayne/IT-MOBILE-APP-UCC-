package com.ucc.itmobileapp.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.ucc.itmobileapp.R;
import com.ucc.itmobileapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Faculty/Staff Directory
        binding.cardDirectory.setOnClickListener(v -> {
            startActivity(new Intent(this, DirectoryActivity.class));
            overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        });

        // Courses
        binding.cardCourses.setOnClickListener(v -> {
            startActivity(new Intent(this, CoursesActivity.class));
            overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        });

        // Admissions
        binding.cardAdmissions.setOnClickListener(v -> {
            startActivity(new Intent(this, AdmissionsActivity.class));
            overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        });

        // Social Media
        binding.cardSocialMedia.setOnClickListener(v -> {
            startActivity(new Intent(this, SocialMediaActivity.class));
            overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        });

        // Email FAB -> Email the HOD
        binding.fabEmail.setOnClickListener(v -> {
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
            emailIntent.setData(Uri.parse("mailto:" + getString(R.string.hod_email)));
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Student Inquiry – UCC IT Department");
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Dear Head of Department,\n\n");
            try {
                startActivity(emailIntent);
            } catch (android.content.ActivityNotFoundException ex) {
                // No email app found
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}
