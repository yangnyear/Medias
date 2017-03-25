package com.swpuiot.medias.presenter.photogallerypresenter;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.swpuiot.medias.clicklistener.MyItemClickListener;
import com.swpuiot.medias.clicklistener.MyItemLongClickListener;
import com.swpuiot.medias.data.FetchItemTask;
import com.swpuiot.medias.entities.GalleryItem;
import com.swpuiot.medias.recycleviewadapter.photogallery.PhotoGalleryRecycleViewAdapter;

import java.util.List;

/**
 * Created by 羊荣毅_L on 2017/3/23.
 */
public class PhotoGalleryPresenter implements PhotoGalleryHolder.presenter ,MyItemLongClickListener,MyItemClickListener {
    private Context mContext;
    private PhotoGalleryHolder.view mView;
    private List<GalleryItem> items;
    private FetchItemTask mFetchItemTask;


    public PhotoGalleryPresenter(Context context) {
        mContext = context;
        mView = (PhotoGalleryHolder.view) context;
    }

    @Override
    public void setRecycViewAdapter() {
        mFetchItemTask=new FetchItemTask();
        mFetchItemTask.execute();
        items = mFetchItemTask.getItems();
        if (items==null){
            Toast.makeText(mContext,"items is null",Toast.LENGTH_SHORT).show();
            return;
        }
        PhotoGalleryRecycleViewAdapter adapter = new PhotoGalleryRecycleViewAdapter(mContext, items);
        mView.setRecycViewAdapter(adapter);
        adapter.setClickListener(this);
        adapter.setLongClickListener(this);
    }

    @Override
    public void onItemClick(View view, int position) {

    }

    @Override
    public void onItemLongClick(View view, int position) {

    }
}
