package com.piyonakajima.telepasee.telepasee;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    SensorManager mSensorManager;
    String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        List<Sensor> sensors = mSensorManager.getSensorList(Sensor.TYPE_ACCELEROMETER);

        // regist Event Listener
        if (sensors.size() > 0) {
            Sensor s = sensors.get(0);
            mSensorManager.registerListener(this, s, SensorManager.SENSOR_DELAY_UI);
        }

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        Log.v(TAG, sensorEvent.values[0] +"," +  sensorEvent.values[1] +"" + sensorEvent.values[2]);

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
