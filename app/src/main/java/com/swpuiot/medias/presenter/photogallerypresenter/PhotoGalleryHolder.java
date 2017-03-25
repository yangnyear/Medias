package com.swpuiot.medias.presenter.photogallerypresenter;

import com.swpuiot.medias.recycleviewadapter.photogallery.PhotoGalleryRecycleViewAdapter;

/**
 * Created by 羊荣毅_L on 2017/3/23.
 */
public interface PhotoGalleryHolder {
    interface view {
        void setRecycViewAdapter(PhotoGalleryRecycleViewAdapter adapter);
    }

    interface presenter {
        void setRecycViewAdapter();
    }
}
