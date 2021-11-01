package com.sudiptacseseu.courselistfragment.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import com.sudiptacseseu.courselistfragment.R;
import com.sudiptacseseu.courselistfragment.model.Course;

public class CourseArrayAdapter extends ArrayAdapter<Course>{
    private Context context;
    private List<Course> courses;

    public CourseArrayAdapter(@NonNull Context context, @LayoutRes int resource, List<Course> courses) {
        super(context, resource, courses);
        this.context = context;
        this.courses = courses;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Course course = courses.get(position);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        @SuppressLint("ViewHolder") View view = inflater.inflate(R.layout.course_listitem, null);

        ImageView imageView = view.findViewById(R.id.courseImageViewId);
        imageView.setImageResource(course.getImageResourceId(context));

        TextView textView = view.findViewById(R.id.courseNameTextViewId);
        textView.setText(course.getCourseName());

        return view;
    }
}
