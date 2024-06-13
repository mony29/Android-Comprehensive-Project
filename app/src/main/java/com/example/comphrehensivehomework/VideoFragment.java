package com.example.comphrehensivehomework;

import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.comphrehensivehomework.adapter.VideoAdapter;
import com.example.comphrehensivehomework.model.Video;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VideoFragment extends Fragment {
    private List<Video> videos;
    private ListView listView;
    private VideoAdapter adapter;

    @SuppressLint("WrongViewCast")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_video, container, false);

        videos = new ArrayList<>();
        listView = view.findViewById(R.id.list_view);
        adapter = new VideoAdapter(getActivity(), videos);
        listView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        fetchDataFromApi();
    }

    private void fetchDataFromApi() {

//        String apiKey = "0aad2489cbca5c6b891332bdb24d747c";
//        String apiUrl = "http://apis.juhe.cn/fapig/douyin/billboard" + apiKey;
//        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, apiUrl, null,
//                response -> {
//                    try {
//                        JSONArray array = response.getJSONArray("res");
//                        for(int i=0; i<array.length(); i++){
//                            JSONObject object = array.getJSONObject(i);
//
//                            Video video = new Video();
//
//                            video.setTitle(object.getString("title"));
//                            video.setAuthor(object.getString("author"));
//
//                            videos.add(video);
//                        }
//                        updateVideoList();
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//                },
//                error -> {
//                    // Handle API request error
//                    Log.e("API", "Error fetching video data", error);
//                });
//        RequestQueue queue = Volley.newRequestQueue(getActivity());
//        queue.add(request);

        String apiKey = "0aad2489cbca5c6b891332bdb24d747c";
        String apiUrl = "http://apis.juhe.cn/fapig/douyin/billboard" + apiKey;

        StringRequest request = new StringRequest(Request.Method.GET, apiUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("videos");

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject videoObject = jsonArray.getJSONObject(i);
                        Video video = new Video();
                        video.setAuthor(videoObject.getString("author"));
                        video.setTitle(videoObject.getString("title"));
                        video.setThumbnailUrl(videoObject.getString("thumbnail"));
                        video.setVideoUrl(videoObject.getString("url"));
                        videos.add(video);
                    }
                    adapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(), "Error fetching videos", Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        queue.add(request);
    }
//    private List<Video> parseVideo(JSONObject response) throws JSONException {
//        List<Video> videos = new ArrayList<>();
//
//        // Implement logic to parse the JSON response and extract video information (title, thumbnail URL, etc.)
//        // This will likely involve iterating over a JSONArray and creating Video objects
//        JSONArray jsonArray = response.getJSONArray("[0aad2489cbca5c6b891332bdb24d747c]");
//
//        for (int i = 0; i < jsonArray.length(); i++) {
//            JSONObject videoJsonObject = jsonArray.getJSONObject(i);
//            Video video = new Video();
//            video.setTitle(videoJsonObject.getString("[title]"));
//            video.setAuthor(videoJsonObject.getString("[author]"));
//            // video.setThumbnailUrl(videoJsonObject.getString("[KEY_FOR_THUMBNAIL_URL]"));
//            videos.add(video);
//        }
//
//        return videos;
//    }

}