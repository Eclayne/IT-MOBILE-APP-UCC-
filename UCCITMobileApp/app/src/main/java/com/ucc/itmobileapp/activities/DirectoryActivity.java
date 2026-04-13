package com.ucc.itmobileapp.activities;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.ucc.itmobileapp.R;
import com.ucc.itmobileapp.adapters.StaffAdapter;
import com.ucc.itmobileapp.databinding.ActivityDirectoryBinding;
import com.ucc.itmobileapp.models.StaffMember;
import java.util.ArrayList;
import java.util.List;

public class DirectoryActivity extends AppCompatActivity {

    private ActivityDirectoryBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDirectoryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);
        binding.toolbar.setNavigationOnClickListener(v -> onBackPressed());

        List<StaffMember> staffList = buildStaffList();
        StaffAdapter adapter = new StaffAdapter(this, staffList);

        binding.recyclerViewDirectory.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerViewDirectory.setAdapter(adapter);
    }

    private List<StaffMember> buildStaffList() {
        List<StaffMember> list = new ArrayList<>();

        list.add(new StaffMember(
            "Dr. Marcus A. Williams",
            "Head of Department – IT",
            "+1 (876) 920-6871",
            "m.williams@ucc.edu.jm",
            0
        ));
        list.add(new StaffMember(
            "Prof. Sandra J. Brown",
            "Senior Lecturer – Software Engineering",
            "+1 (876) 920-6872",
            "s.brown@ucc.edu.jm",
            0
        ));
        list.add(new StaffMember(
            "Mr. Otis A. Osbourne",
            "Lecturer – Mobile Application Development",
            "+1 (876) 920-6873",
            "o.osbourne@ucc.edu.jm",
            0
        ));
        list.add(new StaffMember(
            "Ms. Keisha D. Thompson",
            "Lecturer – Database Systems",
            "+1 (876) 920-6874",
            "k.thompson@ucc.edu.jm",
            0
        ));
        list.add(new StaffMember(
            "Mr. Devon C. Clarke",
            "Lecturer – Computer Networks & Cybersecurity",
            "+1 (876) 920-6875",
            "d.clarke@ucc.edu.jm",
            0
        ));
        list.add(new StaffMember(
            "Ms. Tricia M. Reid",
            "Lecturer – Web Development",
            "+1 (876) 920-6876",
            "t.reid@ucc.edu.jm",
            0
        ));
        list.add(new StaffMember(
            "Mr. Paul A. Henry",
            "Lab Technician",
            "+1 (876) 920-6877",
            "p.henry@ucc.edu.jm",
            0
        ));
        list.add(new StaffMember(
            "Ms. Nadine R. Campbell",
            "Departmental Secretary",
            "+1 (876) 920-6878",
            "n.campbell@ucc.edu.jm",
            0
        ));

        return list;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}
