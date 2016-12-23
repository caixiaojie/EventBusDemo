package com.sky.sky.eventbusdemo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sky.sky.eventbusdemo.bean.Student;
import com.sky.sky.eventbusdemo.event.FronFragmentToFirst;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContentFragment extends Fragment {


    public ContentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_content, container, false);
        view.findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Student student =new Student();
//                student.setId(1);
//                student.setName("fdgdf");
//                FronFragmentToFirst fronFragmentToFirst =new FronFragmentToFirst(student);

                FronFragmentToFirst fronFragmentToFirst =new FronFragmentToFirst();
                List<Student> list =new ArrayList<Student>();
                for (int i = 0; i <10 ; i++) {
                    Student student =new Student();
                    student.setId(i);
                    student.setName("fdgdf==="+i);
                    list.add(student);
                }
                fronFragmentToFirst.setStudents(list);

                //发送事件对象
                EventBus.getDefault().post(fronFragmentToFirst);
            }
        });
        return view;
    }

}

