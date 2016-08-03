package com.dz.witmoon.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.dz.witmoon.demo.bean.User;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //1.Gson
        User user = new User();
        user.setUserName("fuxj");
        user.setSex("女");
        user.setAge("27");

        //将Java对象转换成对应的JSON表示
        String userJSON = new Gson().toJson(user);

        TextView tvToJson = (TextView) findViewById(R.id.tv_to_json);

        if (tvToJson != null && !userJSON.equals("")) {
            tvToJson.setText(userJSON);
        }

        //将JSON字符串转换成一个等效的Java对象
        User user1 = new Gson().fromJson(userJSON, User.class);

        TextView tvToUser = (TextView) findViewById(R.id.tv_to_user);
        if (tvToUser != null && !user1.toString().equals("")) {
            tvToUser.setText(user1.toString());
        }

        //2.视频播放
        Button btPlay = (Button) findViewById(R.id.bt_play);

        if (btPlay != null) {
            btPlay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent().setClass(MainActivity.this, PlayActivity.class));
                }
            });
        }
    }
}
