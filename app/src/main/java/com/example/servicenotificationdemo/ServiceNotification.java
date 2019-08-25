package com.example.servicenotificationdemo;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import java.util.Calendar;

public class ServiceNotification extends Service {

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("Server Start", "........");
        intent = new Intent();

        //intent này set action SyncUngDung đã được khai báo trong AndroidManifest
        intent.setAction("SyncUngDung");
        sendBroadcast(intent);

        Calendar calendar = Calendar.getInstance();
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        PendingIntent pendingUngdung = PendingIntent.getBroadcast(getBaseContext(), 10, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        // set sau bao lâu thì check 1 lần ở đây anh để 5000 =5s
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), 5000, pendingUngdung);

        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
