package com.ucc.itmobileapp.database;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.ucc.itmobileapp.models.Course;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Course.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static volatile AppDatabase INSTANCE;
    public static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(4);

    public abstract CourseDao courseDao();

    public static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            AppDatabase.class,
                            "ucc_it_database"
                    )
                    .addCallback(sRoomDatabaseCallback)
                    .build();
                }
            }
        }
        return INSTANCE;
    }

    private static final RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            databaseWriteExecutor.execute(() -> {
                CourseDao dao = INSTANCE.courseDao();
                if (dao.getCount() == 0) {
                    dao.insertAll(getSeedCourses());
                }
            });
        }
    };

    private static List<Course> getSeedCourses() {
        return Arrays.asList(
            new Course(
                "IT1001",
                "Introduction to Information Technology",
                3,
                "None",
                "An introductory survey of Information Technology covering hardware, software, networking, " +
                "internet fundamentals, and social/ethical aspects of computing. Students will develop basic " +
                "computer literacy and an understanding of how IT impacts modern society."
            ),
            new Course(
                "IT1101",
                "Programming Fundamentals",
                3,
                "IT1001",
                "Introduces students to structured programming using Java. Topics include variables, data types, " +
                "control structures, arrays, methods, and basic object-oriented concepts. Emphasis is placed on " +
                "problem-solving and algorithm development."
            ),
            new Course(
                "IT2101",
                "Object-Oriented Programming",
                3,
                "IT1101",
                "A comprehensive study of object-oriented programming paradigms using Java. Topics include " +
                "classes, inheritance, polymorphism, encapsulation, interfaces, exception handling, " +
                "and file I/O. Students will design and implement full OOP applications."
            ),
            new Course(
                "IT2201",
                "Database Management Systems",
                3,
                "IT1101",
                "Introduces the concepts and principles of relational database design and management. " +
                "Topics include entity-relationship modeling, normalization, SQL (DDL, DML, DCL), " +
                "transactions, and an introduction to NoSQL databases."
            ),
            new Course(
                "IT2301",
                "Computer Networks",
                3,
                "IT1001",
                "A study of data communications and computer networking concepts including the OSI model, " +
                "TCP/IP protocols, LAN/WAN technologies, routing, switching, subnetting, and wireless " +
                "networking. Practical lab sessions reinforce theoretical concepts."
            ),
            new Course(
                "IT2401",
                "Web Development I",
                3,
                "IT1101",
                "Covers the fundamentals of web development using HTML5, CSS3, and JavaScript. Students " +
                "will build responsive, accessible websites applying modern design principles and best " +
                "practices. Introduction to version control with Git is included."
            ),
            new Course(
                "IT3101",
                "Software Engineering",
                3,
                "IT2101",
                "An examination of the software development lifecycle (SDLC), software design patterns, " +
                "UML modeling, agile methodologies, testing strategies, and project management. Students " +
                "complete a team-based software development project."
            ),
            new Course(
                "IT3201",
                "Mobile Application Development",
                3,
                "IT2101",
                "Focuses on the design and development of native Android applications using Java and Android " +
                "Studio. Topics include Activities, Intents, Fragments, RecyclerView, Room Database, " +
                "Material Design, and publishing to the Google Play Store."
            ),
            new Course(
                "IT3301",
                "Cybersecurity Fundamentals",
                3,
                "IT2301",
                "Introduces core cybersecurity concepts including threats, vulnerabilities, cryptography, " +
                "firewalls, intrusion detection, ethical hacking, and security policies. Students gain " +
                "practical experience with security tools and techniques."
            ),
            new Course(
                "IT4101",
                "Capstone Project",
                6,
                "IT3101, IT3201 or IT3301",
                "A final-year integrative project where students apply knowledge and skills acquired " +
                "throughout the programme to design, develop, and present a substantial IT solution " +
                "addressing a real-world problem. Includes a formal presentation and written report."
            )
        );
    }
}
