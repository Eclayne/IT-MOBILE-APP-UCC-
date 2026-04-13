package com.ucc.itmobileapp.models;

public class StaffMember {
    private String name;
    private String title;
    private String phone;
    private String email;
    private int avatarResId;

    public StaffMember(String name, String title, String phone, String email, int avatarResId) {
        this.name = name;
        this.title = title;
        this.phone = phone;
        this.email = email;
        this.avatarResId = avatarResId;
    }

    public String getName() { return name; }
    public String getTitle() { return title; }
    public String getPhone() { return phone; }
    public String getEmail() { return email; }
    public int getAvatarResId() { return avatarResId; }
}
