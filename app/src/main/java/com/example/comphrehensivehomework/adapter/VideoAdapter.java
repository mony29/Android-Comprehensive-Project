package com.example.comphrehensivehomework.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.comphrehensivehomework.R;
import com.example.comphrehensivehomework.model.Video;

import java.util.List;

public class VideoAdapter extends BaseAdapter {
    private Context context;
    private List<Video> videos;

    public VideoAdapter(Context context, List<Video> videos) {
        this.context = context;
        this.videos = videos;
    }

    @Override
    public int getCount() {
        if (videos == null) {
            return 0;
        }
        return videos.size();
    }

    @Override
    public Object getItem(int position) {
        return videos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.video_list_array, parent, false);
        }

        TextView textTitle = convertView.findViewById(R.id.title);
        TextView textAuthor = convertView.findViewById(R.id.author);
        ImageView imageView = convertView.findViewById(R.id.image);

        Video video = videos.get(position);

        imageView.setImageResource(Integer.parseInt(video.getThumbnailUrl()));
        textTitle.setText(video.getTitle());
        textAuthor.setText(video.getAuthor());

        // Use Glide or Picasso to load the thumbnail image
        // Glide.with(context).load(video.getThumbnailUrl()).into(thumbnailImageView);

        return convertView;
    }

    public void updateVideos(List<Video> videos) {
        this.videos.clear();
        this.videos.addAll(videos);
        notifyDataSetChanged();
    }
}
