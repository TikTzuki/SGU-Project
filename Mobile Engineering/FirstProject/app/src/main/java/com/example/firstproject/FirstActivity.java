package com.example.firstproject;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FirstActivity extends AppCompatActivity {
    Button button = null;
    TextView textView = null;
    EditText editText =null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        button = (Button)findViewById(R.id.button1);
        textView = (TextView)findViewById(R.id.textView1);
        editText = (EditText)findViewById(R.id.editText1);
        final String name = editText.getText().toString();
        this.button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                textView.setText("Hello" + name + "Welcome to Javatutorial");
            }
        });
    }
    /*@Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
    }*/
}
