package com.swpuiot.medias.entities;

/**
 * Created by 羊荣毅_L  on 2017/3/24
 * .
 */
public class GalleryItem {
    private String mCaption;
    private String mId;
    private String mUrll;

    public String getCaption() {
        return mCaption;
    }

    public void setCaption(String caption) {
        mCaption = caption;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getUrll() {
        return mUrll;
    }

    public void setUrll(String urll) {
        mUrll = urll;
    }

    @Override
    public String toString() {
        return mCaption;
    }
}
