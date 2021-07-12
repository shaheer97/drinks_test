package com.example.drinksrecipes;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class ReminderBroadcast extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {


        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "notifyme")
                .setSmallIcon(R.drawable.ic_baseline_home_24)
                .setContentTitle("Recipes")
                .setContentText("Description")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);


        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(context);
        notificationManagerCompat.notify(200, builder.build());
    }
}

