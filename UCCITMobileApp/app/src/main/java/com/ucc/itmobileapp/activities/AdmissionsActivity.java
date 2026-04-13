package com.ucc.itmobileapp.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.ucc.itmobileapp.R;
import com.ucc.itmobileapp.databinding.ActivityAdmissionsBinding;

public class AdmissionsActivity extends AppCompatActivity {

    private ActivityAdmissionsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAdmissionsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);
        binding.toolbar.setNavigationOnClickListener(v -> onBackPressed());

        // Apply Online button – opens UCC's application page
        binding.btnApplyOnline.setOnClickListener(v -> {
            String url = getString(R.string.ucc_application_url);
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(browserIntent);
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}
