package com.example.android.miwok;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.media.Image;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {
    Boolean IsPhraseClass;
    String color;
    MediaPlayer mediaPlayer;
    Button playPausePronunciation;

    public WordAdapter(Activity context, ArrayList<Word> numbers_list, Boolean IsPhraseClass, String color)
    {

        super(context, 0, numbers_list);
        this.IsPhraseClass = IsPhraseClass;
        this.color = color;

    }
    @NonNull
    @Override


    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null)
        {
            listItemView = LayoutInflater.from(getContext()).inflate(

                    R.layout.listview_layout, parent, false);
        }


        Word currentItemPosition = getItem(position);
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_word);
        miwokTextView.setText(currentItemPosition.getMiwok_Word());

        listItemView.setBackgroundColor(Color.parseColor(color));
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.english_word);
        defaultTextView.setText(currentItemPosition.getDefault_Word());


        if(IsPhraseClass == Boolean.FALSE){
            ImageView reference_img = (ImageView) listItemView.findViewById(R.id.reference_image);
            reference_img.setImageResource(currentItemPosition.getImageId());
        }
        else{
            ImageView reference_img = listItemView.findViewById(R.id.reference_image);
            reference_img.setVisibility(View.GONE);
        }


//        playPausePronunciation.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                mediaPlayer = MediaPlayer.create(getContext().getApplicationContext(), currentItemPosition.getPronunciation());
//
//            }



        return listItemView;

    }
}
