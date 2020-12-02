package com.higher.login_register_home.Adapters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.higher.login_register_home.R;

import java.util.List;

public class OptionsAdapter extends RecyclerView.Adapter<OptionsAdapter.OptionViewHolder>
{

    private static String currentGuess;
    private Boolean answered;

    public void setCurrentGuess(String currentGuess) {
        OptionsAdapter.currentGuess = currentGuess;
    }

    public static  class OptionViewHolder extends RecyclerView.ViewHolder
    {
        public TextView txtOption;
        public CardView crdOption;

        public OptionViewHolder(@NonNull View itemView, final onOptionClickListener listener) {
            super(itemView);

            txtOption = itemView.findViewById(R.id.txtOptions);
            crdOption = itemView.findViewById(R.id.crdOption);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onOptionClick(position);
                        }
                        if (txtOption.getText().equals(currentGuess))
                        {
                            crdOption.setCardBackgroundColor(Color.parseColor("Green"));
                        }
                        else
                        {
                            crdOption.setCardBackgroundColor(Color.parseColor("#FFFFCC"));
                        }
                    }
                }
            });
        }
    }

    private List<String> levelList;

    private onOptionClickListener listener;
    public interface onOptionClickListener {
        void onOptionClick(int position);
    }

    public void setOnOptionsClickListener(onOptionClickListener listener) {
        this.listener = listener;
    }

    public OptionsAdapter(List<String> nLevelList) {
        levelList = nLevelList;
    }

    @NonNull
    @Override
    public OptionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_option, parent, false);
        OptionViewHolder oViewHolder = new OptionViewHolder(v, listener);
        return  oViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull OptionViewHolder holder, final int position)
    {
        String level = levelList.get(position);
        holder.txtOption.setText(level);
    }

    @Override
    public int getItemCount() {
        return levelList.size();
    }
}
