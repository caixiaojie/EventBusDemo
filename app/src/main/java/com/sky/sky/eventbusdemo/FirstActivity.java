package com.sky.sky.eventbusdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.sky.sky.eventbusdemo.bean.Student;
import com.sky.sky.eventbusdemo.event.FromMainToFirstEvent;
import com.sky.sky.eventbusdemo.event.FronFragmentToFirst;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

public class FirstActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        EventBus.getDefault().register(this);
        Log.e("=====", "==onCreate====");
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.content, new ContentFragment()).commit();
    }


    @Subscribe(threadMode = ThreadMode.POSTING)
    public void onFronFragmentToFirst(FronFragmentToFirst fronFragmentToFirst) {
        //接收事件
       // String name = fronFragmentToFirst.getStudent().getName();

        List<Student> list = fronFragmentToFirst.getStudents();
        for (int i = 0; i <list.size() ; i++) {
            Log.e("=====", "===id==="+list.get(i).getId());
            Log.e("=====", "===name==="+list.get(i).getName());
        }
    }




    public void btn1(View view) {
        //startActivity(new Intent(this,FirstActivity.class));
        FromMainToFirstEvent fromMainToFirstEvent = new FromMainToFirstEvent();
        fromMainToFirstEvent.setStr("我是main发过来的");
        //发布事件
        EventBus.getDefault().post(fromMainToFirstEvent);
        //finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
