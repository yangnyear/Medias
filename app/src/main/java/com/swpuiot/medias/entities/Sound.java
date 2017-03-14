package com.swpuiot.medias.entities;

/**
 * Created by 羊荣毅_L on 2017/3/14.
 */
public class Sound {
    private String soundPath;
    private String soundName;
    private Integer mSoundId;

    public Integer getSoundId() {
        return mSoundId;
    }

    public void setSoundId(Integer soundId) {
        mSoundId = soundId;
    }

    public Sound(String soundPath) {
        this.soundPath = soundPath;
        String[] components=soundPath.split("/");
        String fileName=components[components.length-1];
        soundName=fileName.replace(".wav","");
    }

    public String getSoundPath() {
        return soundPath;
    }

    public String getSoundName() {
        return soundName;
    }
}
