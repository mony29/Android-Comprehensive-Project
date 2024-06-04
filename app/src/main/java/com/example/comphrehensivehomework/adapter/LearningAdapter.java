package com.example.comphrehensivehomework.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.comphrehensivehomework.R;
import com.example.comphrehensivehomework.model.LearningItem;

import java.util.List;

public class LearningAdapter extends BaseAdapter {
    private Context context;
    private List<LearningItem> items;

    public LearningAdapter(Context context, List<LearningItem> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        if (items == null) {
            return 0;
        }
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.learning_list_item, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.imageView);
        TextView textTitle = convertView.findViewById(R.id.textViewTitle);
        TextView textContent = convertView.findViewById(R.id.textViewContent);

        LearningItem item = items.get(position);

        imageView.setImageResource(item.getImageId());
        textTitle.setText(item.getTitle());
        textContent.setText(item.getContent());

        return convertView;
//        ViewHolder viewHolder;
//
//        if (convertView == null) {
//            viewHolder = new ViewHolder();
//            LayoutInflater inflater = LayoutInflater.from(context);
//            convertView = inflater.inflate(R.layout.fragment_learning, null, true);
//            viewHolder.imageView = convertView.findViewById(R.id.imageView);
//            viewHolder.textTitle = convertView.findViewById(R.id.textViewTitle);
//            viewHolder.textContent = convertView.findViewById(R.id.textViewContent);
//            convertView.setTag(viewHolder);
//        } else {
//            viewHolder = (ViewHolder) convertView.getTag();
//        }
//
//        LearningItem learningDetail = learningDetails.get(position);
//
//        if (learningDetail != null) {
//            int learningImageId = learningDetail.getImageId();
//            String learningTitle = learningDetail.getTitle();
//            String learningContent = learningDetail.getContent();
//
//            // Add log statements before setting views
//            Log.d("LearningAdapter", "ImageId: " + learningImageId);
//            Log.d("LearningAdapter", "Title: " + learningTitle);
//            Log.d("LearningAdapter", "Content: " + learningContent);
//
//            viewHolder.imageView.setImageResource(learningImageId);
//            viewHolder.textTitle.setText(learningTitle);
//            viewHolder.textContent.setText(learningContent);
//
//        } else {
//            // Handle case where image is not available (optional: set default image)
//            Log.w("LearningAdapter", "Learning Adapter is null at : "+ position );
//        }
//
//        return convertView;
    }

//    class ViewHolder {
//        private ImageView imageView;
//        private TextView textTitle;
//        private TextView textContent;
//    }

}
