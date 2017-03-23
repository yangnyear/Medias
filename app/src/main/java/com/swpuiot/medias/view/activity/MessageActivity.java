package com.swpuiot.medias.view.activity;

import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.swpuiot.medias.R;
import com.swpuiot.medias.data.MessageReceiver;
import com.swpuiot.medias.presenter.messageactivitypresenter.MessageHolder;
import com.swpuiot.medias.presenter.messageactivitypresenter.MessagePresenter;

public class MessageActivity extends AppCompatActivity implements View.OnClickListener, MessageHolder.view {
    private TextView messageSender;
    private TextView messageConten;
    private MessageHolder.presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_message);
        inite();
        mPresenter.acceptMessageAddress();
        mPresenter.acceptMessageContent();


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.mUnRegisterReceiver();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }

    public void inite() {
        setSupportActionBar((Toolbar) findViewById(R.id.tb_message));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        messageSender = (TextView) findViewById(R.id.tt_messagesender);
        messageConten = (TextView) findViewById(R.id.tt_messagecontent);
        mPresenter = new MessagePresenter(this);
    }

    @Override
    public void onClick(View v) {

    }


    @Override
    public void setAddress(String address) {
        messageSender.setText(address);
    }

    @Override
    public void setContent(String content) {
        messageConten.setText(content);
    }

    @Override
    public void mRegisterReceiver(MessageReceiver messageReceiver, IntentFilter receiverFiler) {
        registerReceiver(messageReceiver, receiverFiler);
    }

    @Override
    public void mUnRegisterReceiver(MessageReceiver messageReceiver) {
        unregisterReceiver(messageReceiver);
    }


}
