package com.qashar.turkeyscholiership;


import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;


import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.qashar.turkeyscholiership.Activity.ReciveActivity;

import java.util.Map;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        String title = remoteMessage.getNotification().getTitle();
        String body = remoteMessage.getNotification().getBody();
        Map<String, String> extraData = remoteMessage.getData();
        sendNotification(title,body);
    }

    public void sendNotification(String title,String body) {

        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(this, "TAC")
                        .setContentTitle(title)
                        .setContentText(body)
                        .setSmallIcon(R.drawable.ic_launcher_background);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 10, new Intent(getApplicationContext(), ReciveActivity.class), PendingIntent.FLAG_UPDATE_CURRENT);

        notificationBuilder.setContentIntent(pendingIntent);
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        int idd =  (int) System.currentTimeMillis();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("TAC","demo",NotificationManager.IMPORTANCE_HIGH);
            notificationManager.createNotificationChannel(channel);
        }
        notificationManager.notify(idd,notificationBuilder.build());


    }
}
