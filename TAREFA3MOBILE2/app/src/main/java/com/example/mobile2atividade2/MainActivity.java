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
import android.widget.Button;
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
    Button bt_tiro;
    TextView tv_tiro;
    Boolean tiroAndamento = false;
    int topMarginTiro = 1200;


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


        TextView letraA = (TextView) findViewById(R.id.tv_letraA);

        int margem = 200;
        if(margem <= 400){
            margem = (int) ((sensorX + 10)*40);
        }else{
            margem = 400;
        }



        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.setMargins(margem, params.topMargin, params.rightMargin, params.bottomMargin);
        letraA.setLayoutParams(params);

        LinearLayout.LayoutParams paramsTiro = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        paramsTiro.setMargins(margem, topMarginTiro, paramsTiro.rightMargin, paramsTiro.bottomMargin);


        bt_tiro = findViewById(R.id.bt_tiro);
        bt_tiro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_tiro = findViewById(R.id.tv_tiro);
                if(tiroAndamento == false) {
                    tv_tiro.setText("||");
                    tv_tiro.setLayoutParams(paramsTiro);
                    tiroAndamento = true;
                    while(topMarginTiro > 0 && tiroAndamento == true){
                        topMarginTiro--;
                        
                    }
                }else{
                    tv_tiro.setText(" ");
                    tiroAndamento = false;
                }
            }
        });







    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}