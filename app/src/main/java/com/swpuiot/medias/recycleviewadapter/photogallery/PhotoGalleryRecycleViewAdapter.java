package com.swpuiot.medias.recycleviewadapter.photogallery;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.swpuiot.medias.R;
import com.swpuiot.medias.clicklistener.MyItemClickListener;
import com.swpuiot.medias.clicklistener.MyItemLongClickListener;
import com.swpuiot.medias.entities.GalleryItem;

import java.util.List;

/**
 * Created by 羊荣毅_L on 2017/3/23.
 */
public class PhotoGalleryRecycleViewAdapter extends RecyclerView.Adapter<PhotoGalleryRecycleViewHolder> {
    private Context mContext;
    private LayoutInflater mInflater;
    private MyItemClickListener mClickListener;
    private MyItemLongClickListener mLongClickListener;
    private List<GalleryItem> items;

    public PhotoGalleryRecycleViewAdapter(Context context, List<GalleryItem> items) {
        mContext = context;
        this.items = items;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public PhotoGalleryRecycleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.list_item_photo, parent, false);
        PhotoGalleryRecycleViewHolder viewHolder = new PhotoGalleryRecycleViewHolder(itemView, mClickListener, mLongClickListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(PhotoGalleryRecycleViewHolder holder, int position) {
        holder.mImageView.setImageURI(Uri.parse(items.get(position).getUrll()));
    }

    @Override
    public int getItemCount() {
        return items.size();
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
 