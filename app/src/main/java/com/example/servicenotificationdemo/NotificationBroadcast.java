package com.example.servicenotificationdemo;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

public class NotificationBroadcast extends BroadcastReceiver {
    private static final String TAG = "NotificationBroadcast";


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive: ");
        show_Notification(context);
    }


    @TargetApi(Build.VERSION_CODES.O)
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void show_Notification(Context context) {

        Intent intent = new Intent(context, MainActivity.class);
        String CHANNEL_ID = "My Notification";

        NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, "name", NotificationManager.IMPORTANCE_LOW);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 1, intent, 0);

        Notification notification = new Notification.Builder(context, CHANNEL_ID)
                .setContentText("Có " + 2 + " ưng dụng mới.")
                .setContentTitle("App Store")
                .setContentIntent(pendingIntent)
                .addAction(R.drawable.ic_launcher_background, "Go to AppStore", pendingIntent)
                .setChannelId(CHANNEL_ID)
                .setSmallIcon(android.R.drawable.sym_action_chat)
                .build();

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.createNotificationChannel(notificationChannel);
        notificationManager.notify(1, notification);
    }
}
