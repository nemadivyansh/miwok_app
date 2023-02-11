package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final ArrayList<Word> family_list = new ArrayList<>();

        family_list.add(new Word("әpә", "Father", R.drawable.family_father, R.raw.family_father));
        family_list.add(new Word("әṭa", "Mother", R.drawable.family_mother, R.raw.family_mother));
        family_list.add(new Word("angsi", "Son", R.drawable.family_son, R.raw.family_son));
        family_list.add(new Word("tune", "Daughter", R.drawable.family_daughter, R.raw.family_daughter));
        family_list.add(new Word("taachi", "Older Brother", R.drawable.family_older_brother, R.raw.family_older_brother));
        family_list.add(new Word("chalitti", "Younger Brother", R.drawable.family_younger_brother, R.raw.family_younger_brother));
        family_list.add(new Word("teṭe", "Older Sister", R.drawable.family_older_sister, R.raw.family_older_sister));
        family_list.add(new Word("kolliti", "Younger Sister", R.drawable.family_younger_sister, R.raw.family_younger_sister));
        family_list.add(new Word("ama", "Grandmother", R.drawable.family_grandmother, R.raw.family_grandmother));
        family_list.add(new Word("paapa", "Grandfather", R.drawable.family_grandfather, R.raw.family_grandfather));

        WordAdapter adapter = new WordAdapter(this, family_list, Boolean.FALSE, "#379237");

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Word temp = family_list.get(i);
                try {
                    if (mediaPlayer.isPlaying()) mediaPlayer.stop();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                mediaPlayer = MediaPlayer.create(FamilyActivity.this, temp.getPronunciation());
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