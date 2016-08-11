package com.example.vaith.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    static final int NOTIFICATION_ID = 0x123;
    NotificationManager nm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }

    public void send(View source)
    {
        Intent intent = new Intent(MainActivity.this, OtherActivity.class);
        PendingIntent pi =  PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
        Notification notify = new Notification.Builder(this)
                .setAutoCancel(true)
                .setTicker("有新消息")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("一条新通知")
                .setContentText("恭喜您，您加薪了，工资加20%！")
                .setDefaults(Notification.DEFAULT_SOUND)
                .setWhen(System.currentTimeMillis())
                .setContentIntent(pi).build();
        nm.notify(NOTIFICATION_ID, notify);
    }


}
