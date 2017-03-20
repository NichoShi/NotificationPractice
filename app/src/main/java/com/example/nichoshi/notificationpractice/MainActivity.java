package com.example.nichoshi.notificationpractice;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button sendBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendBtn = (Button) findViewById(R.id.sendBtn);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,NotificationActivity.class);
                PendingIntent pendingIntent =  PendingIntent.getActivity(MainActivity.this,0,intent,PendingIntent.FLAG_CANCEL_CURRENT);
                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                Notification notification = new Notification.Builder(MainActivity.this)
                                                .setContentTitle("Content title")
                                                .setContentText("Content text")
                                                .setTicker("Ticker text")
                                                .setWhen(System.currentTimeMillis())
                                                .setContentIntent(pendingIntent)
                                                .setSmallIcon(R.mipmap.ic_launcher).build();
                long[] vibrates = {0,1000,0,1000};
                notification.vibrate = vibrates;
                notification.ledARGB = Color.GREEN;
                notification.ledOnMS = 1000;
                notification.ledOffMS = 1000;
                notification.flags = Notification.FLAG_SHOW_LIGHTS;

                notificationManager.notify(1,notification);
            }
        });
    }
}
