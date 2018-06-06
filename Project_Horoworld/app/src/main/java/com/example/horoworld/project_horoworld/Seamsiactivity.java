package com.example.horoworld.project_horoworld;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by pearploy on 4/25/2017 AD.
 */

public class Seamsiactivity extends Activity {

    private SensorManager sm;
    private float acelVal; //current acce value & gravity.
    private float acelLast; //last acce value & gravity.
    private float shake; //acce value differ from gravity.
    Button showbtn;
    Random randomNumberGen;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seamsi);

        sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sm.registerListener(sensorListener, sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);

        acelVal = SensorManager.GRAVITY_EARTH;
        acelLast = SensorManager.GRAVITY_EARTH;
        shake = 0.00f;

        showbtn = (Button) findViewById(R.id.btn_shake);
        randomNumberGen = new Random();
        txt = (TextView) findViewById(R.id.result);
        showbtnController();

    }

    public void  showbtnController(){
        showbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Random number between 1-8. Lower limit = inclusive; upper limit = exclusive
                randomFortuneGenerator(randomNumberGen.nextInt(9 - 1) + 1);
            }
        });
    }

    public void randomFortuneGenerator(int randomInt){
        switch(randomInt)
        {
            case 1 :
                txt.setText(R.string.outcome_1);
                break;
            case 2 :
                txt.setText(R.string.outcome_2);
                break;
            case 3 :
                txt.setText(R.string.outcome_3);
                break;
            case 4 :
                txt.setText(R.string.outcome_4);
                break;
            case 5 :
                txt.setText(R.string.outcome_5);
                break;
            case 6 :
                txt.setText(R.string.outcome_6);
                break;
            case 7 :
                txt.setText(R.string.outcome_7);
                break;
            case 8 :
                txt.setText(R.string.outcome_8);
                break;
            default :
                txt.setText(R.string.outcome_blank);
        }
    }

    private final SensorEventListener sensorListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {

            float x = sensorEvent.values[0];
            float y = sensorEvent.values[1];
            float z = sensorEvent.values[2];

            acelLast = acelVal;
            acelVal = (float) Math.sqrt((double) (x * x + y * y + z * z));
            float delta = acelVal - acelLast;
            shake = shake * 0.9f + delta;

            if (shake > 12) {
                Toast.makeText(getApplicationContext(), "DO NOT SHAKE ME", Toast.LENGTH_SHORT).show();
                randomFortuneGenerator(randomNumberGen.nextInt(9 - 1) + 1);
            }

        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {

        }


    };



}