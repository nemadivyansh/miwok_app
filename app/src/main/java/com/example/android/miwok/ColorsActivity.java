package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> colorsList = new ArrayList<Word>();
        colorsList.add(new Word("weṭeṭṭi", "Red", R.drawable.color_red, R.raw.color_red));
        colorsList.add(new Word("chokokki", "Green", R.drawable.color_green, R.raw.color_green));
        colorsList.add(new Word("ṭakaakki", "Brown", R.drawable.color_brown, R.raw.color_brown));
        colorsList.add(new Word("ṭopoppi", "Gray", R.drawable.color_gray, R.raw.color_gray));
        colorsList.add(new Word("kululli", "Black", R.drawable.color_black, R.raw.color_black));
        colorsList.add(new Word("kelelli", "White", R.drawable.color_white, R.raw.color_white));
        colorsList.add(new Word("ṭopiisә", "Dusty Yellow", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        colorsList.add(new Word("chiwiiṭә", "Mustard Yellow", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));


        WordAdapter adapter = new WordAdapter(this, colorsList, Boolean.FALSE, "#8800A0");

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Word temp = colorsList.get(i);
                try {
                    if (mediaPlayer.isPlaying()) mediaPlayer.stop();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                mediaPlayer = MediaPlayer.create(ColorsActivity.this, temp.getPronunciation());
                Log.v("Verbos", "Entered on item click");
                if (!mediaPlayer.isPlaying()) {
                    mediaPlayer.start();
                    Vibrator v = (Vibrator) getSystemService(VIBRATOR_SERVICE);
                    v.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE));

//                    playPausePronunciation.setBackgroundResource(android.R.drawable.ic_media_pause);
                } else {
                    mediaPlayer.pause();
//                    playPausePronunciation.setBackgroundResource(android.R.drawable.ic_media_play);
                }
            }
        });


    }
    @Override
    public boolean onSupportNavigateUp () {
        finish();
        return true;
    }
}