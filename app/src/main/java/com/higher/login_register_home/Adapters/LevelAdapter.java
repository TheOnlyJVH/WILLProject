package com.higher.login_register_home.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.higher.login_register_home.R;

import java.util.ArrayList;

public class LevelAdapter extends RecyclerView.Adapter<LevelAdapter.LevelViewHolder> {

    public static  class LevelViewHolder extends RecyclerView.ViewHolder
    {
        public TextView txtLevelNumber;

        public LevelViewHolder(@NonNull View itemView, final onLevelClickListener listener) {
            super(itemView);

            txtLevelNumber = itemView.findViewById(R.id.txtLevel);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onLevelClick(position);
                        }
                    }
                }
            });
        }
    }

    private ArrayList<String> levelList;

    private onLevelClickListener listener;

    public interface onLevelClickListener {
        void onLevelClick(int position);
    }

    public void setOnLevelClickListener(onLevelClickListener listener) {
        this.listener = listener;
    }

    public LevelAdapter(ArrayList<String> nLevelList) {
        levelList = nLevelList;
    }

    @NonNull
    @Override
    public LevelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_menu, parent, false);
        LevelViewHolder lViewHolder = new LevelViewHolder(v, listener);
        return  lViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull LevelViewHolder holder, int position)
    {
        String level = levelList.get(position);
        holder.txtLevelNumber.setText(level);
    }

    @Override
    public int getItemCount() {
        return levelList.size();
    }
}
