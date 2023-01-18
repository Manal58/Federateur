package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.model.NewRelease;

import java.util.ArrayList;
import java.util.List;

public class NewReleaseRecyclerAdapter extends RecyclerView.Adapter<NewReleaseRecyclerAdapter.NewReleaseViewHolder> {
    private Context context;


    public NewReleaseRecyclerAdapter(Context context, List<NewRelease> newReleaseList){
        this.context=context;
        this.newReleaseList=newReleaseList;
    }
    private List<NewRelease>newReleaseList=new ArrayList<>();

    public void setFilteredList(List<NewRelease>filteredList){
        this.newReleaseList=filteredList;
        notifyDataSetChanged();

    }
    @Override
    public NewReleaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater=LayoutInflater.from(context);
        view=inflater.inflate(R.layout.new_release_recycler_items,parent,false);
        final NewReleaseViewHolder viewHolder=new NewReleaseViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder( NewReleaseViewHolder holder, int position) {

        holder.name.setText(newReleaseList.get(position).getName());
        Glide.with(context).load(newReleaseList.get(position).getImageurl()).into(holder.itemImage);

    }

    @Override
    public int getItemCount() {
        return newReleaseList.size() ;
    }


    public static class NewReleaseViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView itemImage;
        TextView name;
        LinearLayout linearLayout_new_release;


        public NewReleaseViewHolder(@NonNull View itemView){
            super(itemView);
            linearLayout_new_release=itemView.findViewById(R.id.new_release);
            itemImage=itemView.findViewById(R.id.imageView);
            name=itemView.findViewById(R.id.textView);

       }

        @Override
        public void onClick(View view) {

        }
    }


}
