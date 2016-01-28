package com.shubham.alarmtest;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Shubham on 1/28/16.
 */
public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        // For our recurring task, we'll just display a message
        Toast.makeText(context, "I'm running", Toast.LENGTH_SHORT).show();
        PendingIntent contentIntent = PendingIntent.getActivity(context, 0,
                new Intent(context, AlarmReceiver.class), 0);

        Notification.Builder mBuilder =
                new Notification.Builder(context)
                        .setSmallIcon(android.R.drawable.stat_sys_download)
                        .setContentTitle("xyz")
                        .setContentText("It will contain dummy content");
        mBuilder.setContentIntent(contentIntent);
        mBuilder.setDefaults(Notification.DEFAULT_SOUND);
        mBuilder.setAutoCancel(true);
        NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(1, mBuilder.build());
    }
}
