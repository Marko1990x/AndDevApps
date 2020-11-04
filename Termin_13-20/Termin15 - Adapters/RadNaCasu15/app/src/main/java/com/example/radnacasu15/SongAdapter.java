package com.example.radnacasu15;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class SongAdapter extends BaseAdapter {

    private List<Song> songs;
    private Activity activity;

    public SongAdapter(List<Song> songs, Activity activity) { // konstruktor za ova dva parametra
        this.songs = songs;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return songs.size(); // ako je lista size ako je array onda lenght
    }

    @Override
    public Song getItem(int position) {
        return songs.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;  // zato sto nema id u pesmi modelu inace bi ovde vracali i to
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null){
            convertView = activity.getLayoutInflater().inflate(R.layout.song_single_item, null);
        }

        TextView tvName = convertView.findViewById(R.id.tvName);
        TextView tvAuthor = convertView.findViewById(R.id.tvAuthor);
        tvName.setText(songs.get(position).getName());
        tvAuthor.setText(songs.get(position).getAuthor());

        return convertView;
    }
}
