package com.example.myapplication.Subscription;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.myapplication.R;
import com.google.android.material.card.MaterialCardView;

import java.util.List;

public class SubsAdapter extends RecyclerView.Adapter<SubsAdapter.SubsAdapterViewHolder>{
    private List<subs_model> list;
    private ViewPager2 viewPager2;

    public SubsAdapter(List<subs_model> list, ViewPager2 viewPager2) {
        this.list = list;
        this.viewPager2 = viewPager2;
    }

    @NonNull
    @Override
    public SubsAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SubsAdapterViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.subs_item,
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull SubsAdapterViewHolder holder, int position) {
        holder.materialCardView.setBackgroundResource(list.get(position).getColorback());
        holder.view1.setBackgroundResource(list.get(position).getColorellipse());
        holder.view2.setBackgroundResource(list.get(position).getColorellipse());
        holder.view3.setBackgroundResource(list.get(position).getColorellipse());
        holder.name.setText(list.get(position).getName());
        holder.price.setText(list.get(position).getPrice());
        holder.tv1.setText(list.get(position).getFeature1());
        holder.tv2.setText(list.get(position).getFeature2());
        holder.tv3.setText(list.get(position).getFeature3());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class SubsAdapterViewHolder extends RecyclerView.ViewHolder{

        MaterialCardView materialCardView;
        View view1,view2,view3;
        TextView name,tv1,tv2,tv3,price;

        public SubsAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            materialCardView = itemView.findViewById(R.id.subs_main);
            view1 = itemView.findViewById(R.id.view1);
            view2 = itemView.findViewById(R.id.view2);
            view3 = itemView.findViewById(R.id.view3);
            name = itemView.findViewById(R.id.subs_name);
            price = itemView.findViewById(R.id.subs_price);
            tv1 = itemView.findViewById(R.id.feature1tv);
            tv2 = itemView.findViewById(R.id.feature2tv);
            tv3 = itemView.findViewById(R.id.feature3tv);
        }
    }
}
