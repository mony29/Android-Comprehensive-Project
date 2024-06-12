package com.example.comphrehensivehomework;

import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
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
//    private RecyclerView recyclerView;
//    private List<Video> videos;

    private ListView listView;
    private VideoAdapter adapter;

    @SuppressLint("WrongViewCast")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_video, container, false);
//        recyclerView = view.findViewById(R.id.list_view);
//        videos = new ArrayList<>();

        listView = view.findViewById(R.id.list_view);
        adapter = new VideoAdapter(getActivity(), new ArrayList<>());
        listView.setAdapter(adapter);

        fetchDataFromApi();

        return view;
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
//        String apiUrl = "http://apis.juhe.cn/fapig/douyin/billboard";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, apiUrl, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            List<Video> videos = parseVideo(response);
                            adapter.updateVideos(videos);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("VideoFragment", "Error fetching videos: " + error.getMessage());
                    }
                });

        RequestQueue queue = Volley.newRequestQueue(getActivity().getApplicationContext());
        queue.add(request);
    }

//    private void updateVideoList() {
//        VideoAdapter adapter = new VideoAdapter(getActivity(), videos);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//        recyclerView.setAdapter(adapter);
//    }

    private List<Video> parseVideo(JSONObject response) throws JSONException {
        List<Video> videos = new ArrayList<>();

        // Implement logic to parse the JSON response and extract video information (title, thumbnail URL, etc.)
        // This will likely involve iterating over a JSONArray and creating Video objects
        JSONArray jsonArray = response.getJSONArray("[0aad2489cbca5c6b891332bdb24d747c]");

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject videoJsonObject = jsonArray.getJSONObject(i);
            Video video = new Video();
            video.setTitle(videoJsonObject.getString("[title]"));
            video.setAuthor(videoJsonObject.getString("[author]"));
            // video.setThumbnailUrl(videoJsonObject.getString("[KEY_FOR_THUMBNAIL_URL]"));
            videos.add(video);
        }

        return videos;
    }

}