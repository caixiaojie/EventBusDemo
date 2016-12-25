package com.sky.sky.eventbusdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.sky.sky.eventbusdemo.event.FromMainToFirstEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * EventBus的使用步骤：
 * 1.定义事件(static class xx)
 * 2.使用注解声明接收者(订阅者)
 * 3.发布事件
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * Activity之间的传值
 */
public class MainActivity extends AppCompatActivity {

    //练习提交
    TextView textView;
    //第二次提交
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //注册EventBus事件总线
        EventBus.getDefault().register(this);
//        if (Build.VERSION.SDK_INT>=21) {
//            //更改状态栏的颜色
//            getWindow().setStatusBarColor(Color.RED);
//            //更改底部虚拟导航按键的颜色
//            getWindow().setNavigationBarColor(Color.RED);
//        }
    }

    public void btn1(View view) {

        startActivity(new Intent(this,FirstActivity.class));
        //finish();


    }
    //接收事件(订阅者)
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onFromMainToFirstEvent(FromMainToFirstEvent event){
        Log.e("=====","==onFromMainToFirstEvent====");
        Toast.makeText(this,event.getStr(),Toast.LENGTH_LONG).show();
    }

//    @Override
//    public void onStart() {
//        super.onStart();
//        Log.e("=====","==onStart====");
//
//    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("=====","==onStop====");
        //移除EventBus事件总线
        EventBus.getDefault().unregister(this);
    }




}
