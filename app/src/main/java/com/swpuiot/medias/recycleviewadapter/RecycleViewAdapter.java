package com.swpuiot.medias.recycleviewadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.swpuiot.medias.R;
import com.swpuiot.medias.clicklistener.MyItemClickListener;
import com.swpuiot.medias.clicklistener.MyItemLongClickListener;
import com.swpuiot.medias.entities.Sound;

import java.util.ArrayList;

/**
 * Created by 羊荣毅_L on 2017/3/14.
 */
public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewHolder> {
    private Context mContext;
    private LayoutInflater mInflater;
    private MyItemClickListener mClickListener;
    private MyItemLongClickListener mLongClickListener;
    private ArrayList<Sound> mRecycleViewListEntities;

    public RecycleViewAdapter(Context context, ArrayList<Sound> recycleViewListEntities) {
        mContext = context;
        mRecycleViewListEntities = recycleViewListEntities;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public RecycleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.list_item_sound, parent, false);
        RecycleViewHolder viewHolder = new RecycleViewHolder(itemView, mClickListener, mLongClickListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecycleViewHolder holder, int position) {
        holder.mSoundName.setText(mRecycleViewListEntities.get(position).getSoundName());
    }

    @Override
    public int getItemCount() {
        return mRecycleViewListEntities.size();
    }
    //暴露给Recycleview设置点击事件
    public void setClickListener(MyItemClickListener clickListener) {
        mClickListener = clickListener;
    }

    //暴露给Recycleview设置长按点击事件
    public void setLongClickListener(MyItemLongClickListener longClickListener) {
        mLongClickListener = longClickListener;
    }
}
