package com.ucc.itmobileapp.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;

@Entity(tableName = "courses")
public class Course {

    @PrimaryKey
    @NonNull
    private String code;

    private String name;
    private int credits;
    private String prerequisites;
    private String description;

    public Course(@NonNull String code, String name, int credits, String prerequisites, String description) {
        this.code = code;
        this.name = name;
        this.credits = credits;
        this.prerequisites = prerequisites;
        this.description = description;
    }

    @NonNull
    public String getCode() { return code; }
    public String getName() { return name; }
    public int getCredits() { return credits; }
    public String getPrerequisites() { return prerequisites; }
    public String getDescription() { return description; }

    public void setCode(@NonNull String code) { this.code = code; }
    public void setName(String name) { this.name = name; }
    public void setCredits(int credits) { this.credits = credits; }
    public void setPrerequisites(String prerequisites) { this.prerequisites = prerequisites; }
    public void setDescription(String description) { this.description = description; }
}
