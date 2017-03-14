package com.swpuiot.medias.data;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;

import com.swpuiot.medias.entities.Sound;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by 羊荣毅_L on 2017/3/14.
 * 获得sound
 */
public class Resource {
    private static final String SOUNDS_FOLDER = "sample_sounds";
    private static final int MAX_SOUNDS = 5;
    private ArrayList<Sound> mRecycleViewListEntities = new ArrayList<>();
    private AssetManager mAssetManager;
    private SoundPool mSoundPool;

    public Resource(Context context) {
        mAssetManager = context.getAssets();
        mSoundPool = new SoundPool(MAX_SOUNDS, AudioManager.STREAM_MUSIC, 0);
        LoadSound();
    }

    public void LoadSound() {
        String[] soundName;
        try {
            soundName = mAssetManager.list(SOUNDS_FOLDER);
        } catch (IOException e) {
            return;
        }
        for (String fileName : soundName) {
            try {
                String assaPath = SOUNDS_FOLDER + "/" + fileName;
                Sound sound = new Sound(assaPath);
                load(sound);
                mRecycleViewListEntities.add(sound);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    private void load(Sound sound) throws IOException {
        AssetFileDescriptor afd = mAssetManager.openFd(sound.getSoundPath());
        int soundId = mSoundPool.load(afd, 1);
        sound.setSoundId(soundId);
    }

    public void playSounds(Sound sound) {
        Integer soundId = sound.getSoundId();
        if (soundId==null){
            return;
        }
        mSoundPool.play(soundId,1.0f,1.0f,1,1,1.0f);
    }

    public ArrayList<Sound> getRecycleViewListEntities() {
        return mRecycleViewListEntities;
    }
    public void release(){
        mSoundPool.release();
    }

}
