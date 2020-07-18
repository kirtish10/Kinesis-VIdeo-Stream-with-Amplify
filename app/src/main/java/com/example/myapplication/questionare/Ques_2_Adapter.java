package com.example.myapplication.questionare;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

public class Ques_2_Adapter extends RecyclerView.Adapter<Ques_2_Adapter.MyViewHolder> {

    private LayoutInflater inflater;
    private ArrayList<Model> dataModelArrayList;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int pos, MaterialCardView materialCardView);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    public Ques_2_Adapter(Context ctx, ArrayList<Model> dataModelArrayList){

        inflater = LayoutInflater.from(ctx);
        this.dataModelArrayList = dataModelArrayList;
    }

    @Override
    public Ques_2_Adapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.ques_2_item_layout, parent, false);
        MyViewHolder holder = new MyViewHolder(view,mListener);

        return holder;
    }

    @Override
    public void onBindViewHolder(Ques_2_Adapter.MyViewHolder holder, int position) {

        holder.text.setText(dataModelArrayList.get(position).getTitle());
        holder.imageView.setImageResource(dataModelArrayList.get(position).getImage());
        holder.materialCardView.setStrokeWidth(dataModelArrayList.get(position).getBack());
    }

    @Override
    public int getItemCount() {
        return dataModelArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView text;
        ImageView imageView;
        MaterialCardView materialCardView;

        public MyViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);

            text = itemView.findViewById(R.id.namaha22_text);
            imageView = itemView.findViewById(R.id.namaha22_image);
            materialCardView = itemView.findViewById(R.id.back_view);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null){
                        int p = getAdapterPosition();
                        if (p != RecyclerView.NO_POSITION){
                            listener.onItemClick(p,materialCardView);
                        }
                    }
                }
            });
        }

    }
}
