package com.sudiptacseseu.courselistfragment.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

import java.util.List;

import com.sudiptacseseu.courselistfragment.R;
import com.sudiptacseseu.courselistfragment.util.ScreenUtility;
import com.sudiptacseseu.courselistfragment.model.Course;
import com.sudiptacseseu.courselistfragment.adapter.CourseArrayAdapter;
import com.sudiptacseseu.courselistfragment.data.CourseData;

public class CourseListFragment extends ListFragment {
    List<Course> courses = new CourseData().courseList();
    private Callbacks activity;
    private CourseArrayAdapter adapter;

    public CourseListFragment(){
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ScreenUtility screenUtility = new ScreenUtility(getActivity());

        Log.d("WIDTH", String.valueOf(screenUtility.getDpWidth()));

        adapter = new CourseArrayAdapter(getActivity(),
                R.layout.course_listitem, courses);

        for (Course course: courses) {
            Log.d("Courses =", course.getCourseName());
        }

        setListAdapter(adapter);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.course_list_fragment, container, false);

        return view;
    }

    public interface Callbacks {
         void onItemSelected(Course course, int position);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Course course = courses.get(position);
        this.activity.onItemSelected(course, position );

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.activity = (Callbacks) context;
    }
}
