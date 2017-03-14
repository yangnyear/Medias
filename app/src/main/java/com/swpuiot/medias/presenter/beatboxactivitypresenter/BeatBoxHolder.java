package com.swpuiot.medias.presenter.beatboxactivitypresenter;

import com.swpuiot.medias.recycleviewadapter.RecycleViewAdapter;

/**
 * Created by 羊荣毅_L on 2017/3/14.
 */
public interface BeatBoxHolder {
    interface view{
        void setRecycViewAdapter(RecycleViewAdapter recycViewAdapter);
    }
    interface presenter{
        void setRecycViewAdapter();
    }
}
