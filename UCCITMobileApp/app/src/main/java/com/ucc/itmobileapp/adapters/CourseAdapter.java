package com.ucc.itmobileapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.chip.Chip;
import com.ucc.itmobileapp.R;
import com.ucc.itmobileapp.activities.CourseDetailActivity;
import com.ucc.itmobileapp.models.Course;
import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder> {

    private final Context context;
    private final List<Course> courseList;

    public CourseAdapter(Context context, List<Course> courseList) {
        this.context = context;
        this.courseList = courseList;
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_course, parent, false);
        return new CourseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {
        Course course = courseList.get(position);

        holder.chipCode.setText(course.getCode());
        holder.chipCredits.setText(course.getCredits() + " Credits");
        holder.tvCourseName.setText(course.getName());
        holder.tvCourseDesc.setText(course.getDescription());
        holder.tvPrerequisites.setText("Prerequisites: " + course.getPrerequisites());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, CourseDetailActivity.class);
            intent.putExtra(CourseDetailActivity.EXTRA_COURSE_CODE, course.getCode());
            intent.putExtra(CourseDetailActivity.EXTRA_COURSE_NAME, course.getName());
            intent.putExtra(CourseDetailActivity.EXTRA_CREDITS, course.getCredits());
            intent.putExtra(CourseDetailActivity.EXTRA_PREREQUISITES, course.getPrerequisites());
            intent.putExtra(CourseDetailActivity.EXTRA_DESCRIPTION, course.getDescription());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return courseList.size();
    }

    static class CourseViewHolder extends RecyclerView.ViewHolder {
        Chip chipCode, chipCredits;
        TextView tvCourseName, tvCourseDesc, tvPrerequisites;

        CourseViewHolder(@NonNull View itemView) {
            super(itemView);
            chipCode = itemView.findViewById(R.id.chipCode);
            chipCredits = itemView.findViewById(R.id.chipCredits);
            tvCourseName = itemView.findViewById(R.id.tvCourseName);
            tvCourseDesc = itemView.findViewById(R.id.tvCourseDesc);
            tvPrerequisites = itemView.findViewById(R.id.tvPrerequisites);
        }
    }
}
