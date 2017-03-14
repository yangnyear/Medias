package com.swpuiot.medias.data;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;

/**
 * Created by 羊荣毅_L on 2017/3/13.
 * 接受短信
 */
public class MessageReceiver extends BroadcastReceiver{
    private String address;
    private String content;

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle=intent.getExtras();
        Object [] pdus= (Object[]) bundle.get("pdus");
        SmsMessage[] messages=new SmsMessage[pdus.length];
        for (int i=0;i<messages.length;i++){
            messages[i]=SmsMessage.createFromPdu((byte[]) pdus[i]);
        }
        address=messages[0].getDisplayOriginatingAddress();
        for (SmsMessage message:messages){
            content+=message.getMessageBody();
        }
    }

    public String getAddress() {
        return address;
    }

    public String getContent() {
        return content;
    }
}
