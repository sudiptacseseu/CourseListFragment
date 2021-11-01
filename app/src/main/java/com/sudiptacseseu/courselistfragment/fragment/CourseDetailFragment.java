package com.sudiptacseseu.courselistfragment.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.sudiptacseseu.courselistfragment.R;
import com.sudiptacseseu.courselistfragment.model.Course;
import com.sudiptacseseu.courselistfragment.data.CourseData;

import java.text.MessageFormat;

public class CourseDetailFragment extends Fragment {
    Course course;

    //Required no-args constructor
    public CourseDetailFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getArguments();
        if (bundle != null && bundle.containsKey("course_id")) {
            int position = bundle.getInt("course_id");

            course = new CourseData().courseList().get(position);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.course_detail_fragment, container, false);
        if (course != null) {
            TextView courseName = view.findViewById(R.id.courseNameTextView);
            courseName.setText(course.getCourseName());

            ImageView courseImage = view.findViewById(R.id.coureImageView);
            courseImage.setImageResource(course.getImageResourceId(getActivity()));

            TextView courseDescription = view.findViewById(R.id.courseDescriptionTextView);
            courseDescription.setText(MessageFormat.format("Description: This is {0}", course.getCourseName()));
        }

        return view;
    }
}
