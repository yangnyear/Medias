package com.swpuiot.medias.recycleviewadapter.photogallery;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.swpuiot.medias.clicklistener.MyItemClickListener;
import com.swpuiot.medias.clicklistener.MyItemLongClickListener;

/**
 * Created by 羊荣毅_L on 2017/3/23.
 */
public class PhotoGalleryRecycleViewAdapter extends RecyclerView.Adapter<PhotoGalleryRecycleViewHolder>{
    private Context mContext;
    private LayoutInflater mInflater;
    private MyItemClickListener mClickListener;
    private MyItemLongClickListener mLongClickListener;
    @Override
    public PhotoGalleryRecycleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(PhotoGalleryRecycleViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
