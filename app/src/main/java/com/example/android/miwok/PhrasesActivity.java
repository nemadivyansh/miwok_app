package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.app.Service;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final ArrayList<Word> phrasesList = new ArrayList<Word>();
        phrasesList.add(new Word("minto wuksus", "Where are you going?", 0, R.raw.phrase_where_are_you_going));
        phrasesList.add(new Word("tinnә oyaase'nә", "What is your name?", 0, R.raw.phrase_what_is_your_name));
        phrasesList.add(new Word("oyaaset...", "My name is...", 0, R.raw.phrase_my_name_is));
        phrasesList.add(new Word("michәksәs?", "How are you feeling?", 0, R.raw.phrase_how_are_you_feeling));
        phrasesList.add(new Word("kuchi achit", "I’m feeling good.", 0, R.raw.phrase_im_feeling_good));
        phrasesList.add(new Word("әәnәs'aa?", "Are you coming?", 0, R.raw.phrase_are_you_coming));
        phrasesList.add(new Word("hәә’ әәnәm", "Yes, I’m coming.", 0, R.raw.phrase_yes_im_coming));
        phrasesList.add(new Word("әәnәm", "I’m coming.", 0, R.raw.phrase_im_coming));
        phrasesList.add(new Word("yoowutis", "Let’s go.", 0, R.raw.phrase_lets_go));
        phrasesList.add(new Word("әnni'nem", "Come here.", 0, R.raw.phrase_come_here));


        WordAdapter adapter = new WordAdapter(this, phrasesList, Boolean.TRUE, "#16AFCA");

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Word temp = phrasesList.get(i);
                try {
                    if (mediaPlayer.isPlaying()) mediaPlayer.stop();
                } catch (Exception e) {
                    e.printStackTrace();
                    }
                mediaPlayer = MediaPlayer.create(PhrasesActivity.this, temp.getPronunciation());
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
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}