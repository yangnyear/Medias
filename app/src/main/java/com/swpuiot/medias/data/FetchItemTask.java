package com.swpuiot.medias.data;

import android.os.AsyncTask;

import com.swpuiot.medias.entities.GalleryItem;

import java.util.List;

/**
 * Created by 羊荣毅_L on 2017/3/24.
 *
 */
public class FetchItemTask extends AsyncTask<Void,Void, List<GalleryItem>> {
    List<GalleryItem> mItems;
    @Override
    protected  List<GalleryItem> doInBackground(Void... params) {
//        try {
//            String result=new FlickrFetchr().getURLString("http://www.bignerdranch.com");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        return new FlickrFetchr().fetchItem();
    }

    @Override
    protected void onPostExecute(List<GalleryItem> items) {
        if (items!=null ){
            this.mItems=items;
        }
    }

    public List<GalleryItem> getItems() {
        return mItems;
    }

}
