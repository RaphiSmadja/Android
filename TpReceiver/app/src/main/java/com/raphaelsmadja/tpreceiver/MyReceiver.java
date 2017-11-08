package com.raphaelsmadja.tpreceiver;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Received : " + intent.getAction(), Toast.LENGTH_SHORT).show();

        PendingIntent activityLauncher = PendingIntent.getActivity(context,0,
                new Intent(context,MainActivity.class), PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder notifBuilder = new NotificationCompat.Builder(context);
        Notification notification = notifBuilder.setContentTitle("Received Notif")
                .setContentIntent(activityLauncher)
                .setContentText(intent.getAction()).setSmallIcon(R.mipmap.ic_launcher_round)
                .setAutoCancel(true).build();
        NotificationManager notificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(1,notification);
    }
}
