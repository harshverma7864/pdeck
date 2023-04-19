package com.example.pdeck.adapter;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.pdeck.R;
import com.example.pdeck.RoundsInformation;
import com.example.pdeck.models.Rounds;
import java.util.List;

public class RoundAdapter extends RecyclerView.Adapter<RoundAdapter.ViewHolder> {
    Context context;
    List<Rounds> roundInfoList;

    public RoundAdapter(Context context, List<Rounds> roundInfoList) {
        this.context = context;
        this.roundInfoList = roundInfoList;
    }

    @NonNull
    @Override
    public RoundAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.round_item, parent ,false);
        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull RoundAdapter.ViewHolder holder, int position) {
        holder.roundNo.setText(String.valueOf(roundInfoList.get(position).getId()));
        holder.roundType.setText(roundInfoList.get(position).getRoundName());
        int ide = position;
        holder.parentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, RoundsInformation.class);
                intent.putExtra("roundId" , String.valueOf(roundInfoList.get(ide).getId()));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return roundInfoList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView roundNo  , roundType ;

        CardView cardView;
        View parentView;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.parentView = itemView;
            this.cardView = itemView.findViewById(R.id.cardView);
            this.roundNo = itemView.findViewById(R.id.roundno);
            this.roundType = itemView.findViewById(R.id.roundtype);
        }
    }

}
