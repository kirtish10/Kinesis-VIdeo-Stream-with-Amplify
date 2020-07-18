package com.example.myapplication.Courses;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;

import java.util.ArrayList;

public class CourseAdapter extends RecyclerView.Adapter <CourseAdapter.CourseAdapterViewHolder>{
    private LayoutInflater layoutInflater;
    private ArrayList<CourseModel> list;
    private OnItemClickListener mListener;
    private ProgressBar progressBar;

    public CourseAdapter(Context context, ArrayList<CourseModel> list,ProgressBar progressBar) {
        layoutInflater = LayoutInflater.from(context);
        this.list = list;
        this.progressBar = progressBar;
    }

    public interface OnItemClickListener {
        void onItemClick(int pos);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    @NonNull
    @Override
    public CourseAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.course_layout, parent, false);
        CourseAdapterViewHolder holder = new CourseAdapterViewHolder(view,mListener);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CourseAdapterViewHolder holder, int position) {
        holder.textView.setText(list.get(position).getCourse_name());
        Glide.with(layoutInflater.getContext())
                .load(list.get(position).getCourse_image())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class CourseAdapterViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;

        public CourseAdapterViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);

            textView = itemView.findViewById(R.id.name);
            imageView = itemView.findViewById(R.id.back);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null){
                        int p = getAdapterPosition();
                        if (p != RecyclerView.NO_POSITION){
                            listener.onItemClick(p);
                        }
                    }
                }
            });
        }
    }
}

