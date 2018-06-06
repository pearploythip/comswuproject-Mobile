package com.example.horoworld.project_horoworld;

import android.app.Activity;

import android.content.Intent;

import android.os.Bundle;

import android.view.View;
import android.view.View.OnClickListener;

import android.widget.Button;

import com.example.horoworld.project_horoworld.R;



public class Main_Horoworld extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__horoworld);

        Button praybtn = (Button) findViewById(R.id.btn_pray);
        praybtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);

            }
        });

        Button seamsibtn = (Button) findViewById(R.id.btn_seamsi);
        seamsibtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Seamsiactivity.class);
                startActivity(i);

            }
        });

    }

    }



