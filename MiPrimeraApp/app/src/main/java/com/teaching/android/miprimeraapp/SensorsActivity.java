package com.teaching.android.miprimeraapp;

import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.Arrays;
import java.util.Objects;

public class SensorsActivity extends AppCompatActivity {

    SensorManager sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
    Sensor mySensor;
    SensorEventListener myListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensors);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mySensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        if (mySensor != null) {
            Objects.requireNonNull(sensorManager).registerListener(myListener= new SensorEventListener() {
                @Override
                public void onSensorChanged(SensorEvent event) {
                    if (event.values[0] < mySensor.getMaximumRange()) {
                        Log.d("Sensors, ","Proximity: "+ Arrays.toString(event.values));
                        getWindow().getDecorView().setBackgroundColor(Color.RED);
                    } else {
                        Log.d("Sensors, ","Proximity: "+ Arrays.toString(event.values));
                        getWindow().getDecorView().setBackgroundColor(Color.GREEN);
                    }
                }

                @Override
                public void onAccuracyChanged(Sensor sensor, int accuracy) {
                }
            }, mySensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mySensor != null) {
            sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
            Objects.requireNonNull(sensorManager).unregisterListener(myListener,mySensor);
        }
    }
}
