package com.memebattle.megahack.core;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.memebattle.megahack.R;
import com.memebattle.megahack.main.activity.MainActivity;

import java.util.Map;

public class FCMService extends FirebaseMessagingService {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.i("code", "data " + remoteMessage.getData().toString());
        Map<String, String> data = remoteMessage.getData();
        String channel = data.get("title");
        String userId = data.get("id");
        String text = data.get("text");
        sendNotification(userId, channel, text);
    }

    private void sendNotification(String id, String channel, String text) {

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("id", id);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getService(this, 0, intent, 0);

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.icon)
                .setLargeIcon(BitmapFactory.decodeResource(this.getResources(), R.drawable.icon))
                .setContentTitle("MegaDataHack")
                .setContentText(text)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, notificationBuilder.build());
    }
}