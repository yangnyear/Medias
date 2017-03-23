package com.swpuiot.medias.recycleviewadapter.photogallery;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.swpuiot.medias.R;
import com.swpuiot.medias.clicklistener.MyItemClickListener;
import com.swpuiot.medias.clicklistener.MyItemLongClickListener;

/**
 * Created by 羊荣毅_L on 2017/3/23.
 */
public class PhotoGalleryRecycleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{
    public ImageView mImageView;
    public MyItemClickListener mClickListener;
    public MyItemLongClickListener mLongClickListener;
    public PhotoGalleryRecycleViewHolder(View itemView, MyItemClickListener mClickListener, MyItemLongClickListener mLongClickListener) {
        super(itemView);
        mImageView= (ImageView) itemView.findViewById(R.id.im_photorecycleview);
        this.mClickListener = mClickListener;
        this.mLongClickListener = mLongClickListener;
        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (itemView!=null){
            mClickListener.onItemClick(v, getPosition());
        }
    }

    @Override
    public boolean onLongClick(View v) {
        if (itemView!=null){
            mLongClickListener.onItemLongClick(v,getPosition());
        }
        return true;
    }
}
