package com.seek.simpleeventmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements EventManager.EventListener {

    @Bind(R.id.text_main)
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewAPT.init(this);
        EventManager.getDefualt().register(this);
    }

    public void jump(View view){
        startActivity(new Intent(this,Main2Activity.class));
    }

    @Override
    public void onEvent(String tag, Object data) {
        String text = (String) data;
        textView.setText(text);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventManager.getDefualt().unRegister(this);
    }
}
