package com.example.pdeck.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.pdeck.R;
import com.example.pdeck.models.RoundInfo;
import java.util.List;

public class RoundInfoAdapter extends RecyclerView.Adapter<RoundInfoAdapter.ViewHolder> {
    Context context;
    List<RoundInfo> roundInformationList;

    public RoundInfoAdapter(Context context, List<RoundInfo> roundInformationList) {
        this.context = context;
        this.roundInformationList = roundInformationList;
    }

    @NonNull
    @Override
    public RoundInfoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.questionitem, parent ,false);
        return new ViewHolder(listItem);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RoundInfoAdapter.ViewHolder holder, int position) {
            holder.postedBy.setText("Posted By : "+roundInformationList.get(position).getPostedBy());
            holder.postedOn.setText("Posted On : "+roundInformationList.get(position).getPostedOn());
            holder.difficulty.setText("Difficulty : " + roundInformationList.get(position).getDifficulty());
            holder.question.setText(roundInformationList.get(position).getQuestion());
            holder.answer.setText(roundInformationList.get(position).getAnswer());

    }

    @Override
    public int getItemCount() {
        return roundInformationList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView difficulty  , question, answer , postedBy , postedOn ;
        CardView cardView;
        View parentView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.parentView = itemView;
            this.question = itemView.findViewById(R.id.question);
            this.difficulty = itemView.findViewById(R.id.difficulty);
            this.answer = itemView.findViewById(R.id.ans);
            this.postedBy = itemView.findViewById(R.id.postedby);
            this.postedOn = itemView.findViewById(R.id.postedon);
        }
    }

}
