package com.zxp.myviewinject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @ViewInject(ViewId=R.id.tv_show)
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     //   tv=(TextView)findViewById(R.id.tv_show);
         ViewInjectParse.Parse(this);
         tv.setText("看到我就是注解成功！！！！");
    }
}
