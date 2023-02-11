package com.example.android.miwok;

import android.content.ClipData;
import android.content.res.Resources;
import android.media.Image;
import android.widget.ImageView;

import androidx.annotation.IdRes;

public class Word {
    private String miwok_Word;
    private String default_Word;
    private int imageId;
    private int pronunciationId;

    public String getMiwok_Word()
    {
        return this.miwok_Word;
    }
    public int getImageId() {
        return this.imageId;
    }
    public String getDefault_Word()
    {
        return this.default_Word;
    }
    public int getPronunciation()
    {
        return this.pronunciationId;
    }

    Word(String miwok_Word, String default_Word, int imageId, int pronunciationId)
    {
        this.miwok_Word = miwok_Word;
        this.default_Word = default_Word;
        this.imageId = imageId;
        this.pronunciationId = pronunciationId;
    }
    Word(String miwok_Word, String default_Word)
    {
        this.miwok_Word = miwok_Word;
        this.default_Word = default_Word;
    }


}

