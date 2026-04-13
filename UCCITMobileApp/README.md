# UCC IT Mobile App
### University of the Commonwealth Caribbean – Department of Information Technology

---

## Group Members

| Name | Student ID |
|------|------------|
| [Member 1 Name] | [Student ID] |
| [Member 2 Name] | [Student ID] |

> **Replace the above with your actual names and student IDs before submission.**

---

## Project Overview

A multi-platform Android mobile application developed for the UCC Department of Information Technology. The app provides students and staff with easy access to departmental information, resources, and communications.

## Features

| Feature | Description |
|---------|-------------|
| 👥 Faculty/Staff Directory | View staff profiles with photo, phone, and email. Tap to call or email directly. |
| 📚 Courses | Browse 10 IT courses stored in a local Room (SQLite) database. Tap any course for full details. |
| 🎓 Admissions | View entry requirements, programmes offered, and documents needed. Includes a link to UCC's online application page. |
| 📱 Social Media | In-app WebView browser for UCC's Facebook, Twitter/X, and Instagram pages via tab navigation. |
| ✉ Email FAB | Floating Action Button on the home screen to compose an email directly to the Head of Department. |

---

## Tech Stack

- **Language:** Java
- **Min SDK:** 24 (Android 7.0)
- **Target SDK:** 34 (Android 14)
- **Database:** Room (SQLite) – stores 10 IT courses with code, name, credits, prerequisites, and description
- **UI:** Material Design 3 components (CardView, RecyclerView, TabLayout, ExtendedFAB, MaterialToolbar)
- **View Binding:** Enabled for all activities

---

## Project Structure

```
UCCITMobileApp/
├── app/src/main/
│   ├── java/com/ucc/itmobileapp/
│   │   ├── activities/
│   │   │   ├── SplashActivity.java
│   │   │   ├── MainActivity.java
│   │   │   ├── DirectoryActivity.java
│   │   │   ├── CoursesActivity.java
│   │   │   ├── CourseDetailActivity.java
│   │   │   ├── AdmissionsActivity.java
│   │   │   └── SocialMediaActivity.java
│   │   ├── adapters/
│   │   │   ├── StaffAdapter.java
│   │   │   └── CourseAdapter.java
│   │   ├── database/
│   │   │   ├── AppDatabase.java
│   │   │   └── CourseDao.java
│   │   └── models/
│   │       ├── Course.java
│   │       └── StaffMember.java
│   └── res/
│       ├── layout/         (7 layout XML files)
│       ├── values/         (colors, strings, themes, dimens)
│       └── drawable/       (vector icons, launcher assets)
```

---

## How to Open & Run in Android Studio

1. **Unzip** `uccit_mobile_app_duo#_S2026.zip`
2. Open **Android Studio** (Hedgehog 2023.1.1 or later recommended)
3. Select **File → Open** and navigate to the extracted `UCCITMobileApp/` folder
4. Wait for Gradle sync to complete (it will download dependencies automatically)
5. Connect an Android device or launch an emulator (API 24+)
6. Click **Run ▶** or press `Shift+F10`

> **Note:** Internet access is required on first run for Gradle to download the wrapper and dependencies.

---

## Academic Information

| Field | Details |
|-------|---------|
| Course Units | 3, 4, 5 & 6 |
| Assignment | UCC IT Mobile App |
| Academic Year | 2024–2025 |
| Lecturer | Otis Osbourne |
| Weight | 40% |
| Submission | Moodle + GitHub |
| Naming Convention | `uccit_mobile_app_duo#_S2026` |
