package com.example.dvdwebapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dvdwebapp.model.DVD;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DvdRecycleAdapter extends RecyclerView.Adapter<DvdRecycleAdapter.DvdViewHolder> {

    ArrayList<DVD> data;

    public static class DvdViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView textViewDvdTitle;
        public TextView textViewDvdGenre;

        public DvdViewHolder(View item) {
            super(item);
            textViewDvdTitle = item.findViewById(R.id.textViewDvdTitle);
            textViewDvdGenre = item.findViewById(R.id.textViewDvdGenre);
        }
    }

    public DvdRecycleAdapter(ArrayList<DVD> data) {
        this.data = data;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @NonNull
    @Override
    public DvdViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.dvd_rv_item, parent, false);

        return new DvdViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DvdViewHolder holder, int position) {
        holder.textViewDvdTitle.setText(data.get(position).getTitle());
        holder.textViewDvdGenre.setText(data.get(position).getGenre());
    }
}
