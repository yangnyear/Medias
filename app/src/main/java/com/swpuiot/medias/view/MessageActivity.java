package com.swpuiot.medias.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.swpuiot.medias.R;
import com.swpuiot.medias.presenter.MessageHolder;

public class MessageActivity extends AppCompatActivity implements View.OnClickListener,MessageHolder.view{
    private TextView messageSender;
    private TextView messageConten;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        inite();
    }
   public void inite(){
        messageSender= (TextView) findViewById(R.id.tt_messagesender);
       messageConten= (TextView) findViewById(R.id.tt_messagecontent);
   }

    @Override
    public void onClick(View v) {

    }
}
