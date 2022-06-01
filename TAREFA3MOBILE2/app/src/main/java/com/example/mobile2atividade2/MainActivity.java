package com.example.mobile2atividade2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener{

    Sensor accelerometer;
    SensorManager sensorManager;
    float sensorX;
    float sensorY;
    float sensorZ;



    @SuppressLint("ServiceCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener((SensorEventListener) this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);



    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        sensorX = event.values[0];
        sensorY = event.values[1];
        sensorZ = event.values[2];

        TextView tx = (TextView) findViewById(R.id.tX);
        TextView ty = (TextView) findViewById(R.id.tY);
        TextView tz = (TextView) findViewById(R.id.tZ);

        tx.setText("X: " + (sensorX));
        ty.setText("Y: " + (sensorY));
        tz.setText("Z: " + (sensorZ));


        TextView letraA = (TextView) findViewById(R.id.tv_letraA);

        int margem = 500;
        if(margem <= 1000){
            margem = (int) ((sensorX + 10)*70);
        }else{
            margem = 1000;
        }



        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.setMargins(margem, params.topMargin, params.rightMargin, params.bottomMargin);
        letraA.setLayoutParams(params);










    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}