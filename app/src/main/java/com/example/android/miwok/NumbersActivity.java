package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.ObjectStreamException;
import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
//        assert getSupportActionBar() != null;   //null check
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final ArrayList<Word> Numbers_list = new ArrayList<Word>();

        Numbers_list.add(new Word("Lut:i", "One", R.drawable.number_one, R.raw.number_one));
        Numbers_list.add(new Word("’oṭi:ko", "Two", R.drawable.number_two, R.raw.number_two));
        Numbers_list.add(new Word("tolo:koshu", "Three", R.drawable.number_three, R.raw.number_three));
        Numbers_list.add(new Word("’oy:is:a", "Four", R.drawable.number_four, R.raw.number_four));
        Numbers_list.add(new Word("mash:ok:a", "Five", R.drawable.number_five, R.raw.number_five));
        Numbers_list.add(new Word("tem:ok:a", "Six", R.drawable.number_six, R.raw.number_six));
        Numbers_list.add(new Word("kenek:aku", "Seven", R.drawable.number_seven, R.raw.number_seven));
        Numbers_list.add(new Word("kaw:inṭa", "Eight", R.drawable.number_eight, R.raw.number_eight));
        Numbers_list.add(new Word("Wo'e", "Nine", R.drawable.number_nine, R.raw.number_nine));
        Numbers_list.add(new Word("na’a:cha", "Ten", R.drawable.number_ten, R.raw.number_ten));


        WordAdapter adapter = new WordAdapter(this, Numbers_list, Boolean.FALSE, "#FD8E09");
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
        Log.v("Verbos", "Before settingonItemClick");
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override

            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Word temp = Numbers_list.get(i);
                try {
                    if (mediaPlayer.isPlaying()) mediaPlayer.stop();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                mediaPlayer = MediaPlayer.create(NumbersActivity.this, temp.getPronunciation());
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


//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//                Object obj = parent.getItemAtPosition(position);
//
//                Word word = (Word) obj;
////                Button playPausePronunciation = findViewById(R.id.playPausePronunciation);
//
//            }
//        });

    }
    @Override
    public boolean onSupportNavigateUp () {
        finish();
        return true;
    }

}