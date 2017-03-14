package com.swpuiot.medias.presenter;

import android.content.Context;
import android.content.IntentFilter;

import com.swpuiot.medias.data.MessageReceiver;

/**
 * Created by 羊荣毅_L on 2017/3/13.
 */
public class MessagePresenter implements MessageHolder.presenter {
    private MessageHolder.view mView;
    private Context mContext;
    private MessageReceiver mReceiver;
    private IntentFilter receiveFiler;

    public MessagePresenter(Context context) {
        mContext = context;
        mView = (MessageHolder.view) context;
        mReceiver = new MessageReceiver();
        receiveFiler=new IntentFilter();
        receiveFiler.addAction("android.provider.Telephony.SMS.RECEIVED");
       mView.mRegisterReceiver(mReceiver, receiveFiler);
    }

    @Override
    public void acceptMessageAddress() {
        String address = mReceiver.getAddress();
        mView.setAddress(address);
    }

    @Override
    public void acceptMessageContent() {
        String content = mReceiver.getContent();
        mView.setContent(content);

    }

    @Override
    public void mUnRegisterReceiver() {
        mView.mUnRegisterReceiver(mReceiver);
    }
}
