package com.example.comphrehensivehomework;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.comphrehensivehomework.adapter.LearningAdapter;
import com.example.comphrehensivehomework.model.LearningItem;

import java.util.ArrayList;
import java.util.List;

public class LearningFragment extends Fragment {
    private ListView listView;
    private List<LearningItem> list;
    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        // Please carefully of this 'R.layout.fragment_learning', R.id or R.layout
        @SuppressLint("ResourceType")
        View view = inflater.inflate(R.layout.fragment_learning, container, false);

        listView = view.findViewById(R.id.learningListView);

        list = new ArrayList<>();

        list.add(new LearningItem(R.drawable.education, "Android开发实践技术", "Content 1"));
        list.add(new LearningItem(R.drawable.law, "Java Web", "Content 2"));
        list.add(new LearningItem(R.drawable.bussiness, "Vue-JS 框架", "Content 3"));

        if (list.isEmpty()) {
            Toast.makeText(getActivity(), "No data", Toast.LENGTH_SHORT).show();
        }

        LearningAdapter adapter = new LearningAdapter(getActivity(), list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                LearningItem clickedItem = list.get(position);

                Toast.makeText(getActivity(), "Clicked on : " + clickedItem.getTitle(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getActivity(), LearningDetailActivity.class);

                intent.putExtra("title", clickedItem.getTitle());
                intent.putExtra("content", clickedItem.getContent());
                intent.putExtra("imageId", clickedItem.getImageId());

                startActivity(intent);
//                the below code is working
//                LearningDetailFragment detailFragment = new LearningDetailFragment();
//
//                Bundle bundle = new Bundle();
//                bundle.putString("title", clickedItem.getTitle());
//                bundle.putString("content", clickedItem.getContent());
//                bundle.putInt("imageId", clickedItem.getImageId());
//                detailFragment.setArguments(bundle);
//
//                FragmentTransaction transaction;
//                transaction = getActivity().getSupportFragmentManager().beginTransaction();
//                transaction.replace(R.id.fragment, detailFragment);
//                transaction.addToBackStack(null);
//                transaction.commit();
            }
        });

        return view;
    }
}