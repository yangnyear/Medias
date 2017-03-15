package com.swpuiot.medias.view;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.RemoteViews;
import android.widget.Toast;

import com.swpuiot.medias.R;
import com.swpuiot.medias.presenter.mainactivitypresenter.MainHolder;
import com.swpuiot.medias.presenter.mainactivitypresenter.MainPresenter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, MainHolder.view {
    private MainHolder.presenter mPresenter;

    private Button noticeButton;
    private Button myNotificationButton;
    private Button messageButton;
    private Button beatBoxButton;
    private Button DragAndDrawButton;

    private NotificationManager mNotificationManager;
    private Notification mNotification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        inite();
        //监听按钮点击事件
        noticeButton.setOnClickListener(this);
        myNotificationButton.setOnClickListener(this);
        messageButton.setOnClickListener(this);
        beatBoxButton.setOnClickListener(this);
        DragAndDrawButton.setOnClickListener(this);
    }

    public void inite() {
        mPresenter = new MainPresenter(this);
        setSupportActionBar((Toolbar) findViewById(R.id.tb_main));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        noticeButton = (Button) findViewById(R.id.bt_notice);
        myNotificationButton = (Button) findViewById(R.id.bt_mynotification);
        messageButton = (Button) findViewById(R.id.bt_sendmessage);
        beatBoxButton= (Button) findViewById(R.id.bt_beatbox);
        DragAndDrawButton= (Button) findViewById(R.id.bt_draganddraw);

        mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.bt_notice:
                mPresenter.sendNotice();
                break;
            case R.id.bt_mynotification:
                mPresenter.sendMyNotice();
                break;
            case R.id.bt_sendmessage:
               intent = new Intent(MainActivity.this, MessageActivity.class);
                mPresenter.startActivity(intent);
                break;
            case R.id.bt_beatbox:
                intent=new Intent(MainActivity.this,BeatBoxActivity.class);
                mPresenter.startActivity(intent);
                break;
            case R.id.bt_draganddraw:
                intent=new Intent(MainActivity.this,DragAndDrawActivity.class);
                mPresenter.startActivity(intent);
        }
    }

    @Override
    public void sendNotification() {

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, new Intent(this, MainActivity.class), 0);
        mNotification = new Notification.Builder(this)
                .setSmallIcon(R.drawable.ic_launcher)
                .setTicker("TickerText:" + "您有新短消息，请注意查收！")
                .setContentTitle("Notification Title")
                .setContentText("This is the notification message")
                .setContentIntent(pendingIntent).setNumber(1).build();
        mNotification.flags |= Notification.FLAG_AUTO_CANCEL;
        mNotificationManager.notify(1, mNotification);
        Toast.makeText(MainActivity.this, "keyong", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void sendMyNotification() {
        mNotification = new Notification();
        mNotification.icon = R.drawable.ic_launcher;
        mNotification.tickerText = "您有新短消息，请注意查收！";
        mNotification.when = System.currentTimeMillis();
        mNotification.flags = Notification.FLAG_NO_CLEAR;// 不能够自动清除
        RemoteViews rv = new RemoteViews(getPackageName(), R.layout.notification_item);
        rv.setTextViewText(R.id.tt_notification, "hello wrold!");
        mNotification.contentView = rv;
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, intent, 0);
        mNotification.contentIntent = contentIntent;
        mNotification.flags |= Notification.FLAG_AUTO_CANCEL;
        mNotificationManager.notify(1, mNotification);
    }

    @Override
    public void mStartActivity(Intent intent) {
        startActivity(intent);
    }

}
