package com.swpuiot.medias.data;

import android.content.Context;
import android.content.res.AssetManager;

import com.swpuiot.medias.entities.Sound;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by 羊荣毅_L on 2017/3/14.
 * 获得sound
 */
public class Resource {
    private static final String SOUNDS_FOLDER = "sample_sounds";
    private ArrayList<Sound> mRecycleViewListEntities = new ArrayList<>();
    private AssetManager mAssetManager;

    public Resource(Context context) {
        mAssetManager = context.getAssets();
    }

    public void LoadSound() {
        String[] soundName;
        try {
            soundName=mAssetManager.list(SOUNDS_FOLDER);
        } catch (IOException e) {
           return;
        }
        for (String fileName:soundName){
            String assaPath=SOUNDS_FOLDER +"/"+fileName;
            Sound sound=new Sound(assaPath);
            mRecycleViewListEntities.add(sound);
        }
    }

    public ArrayList<Sound> getRecycleViewListEntities() {
        return mRecycleViewListEntities;
    }

}
