package com.example.pdeck.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.pdeck.CardsInfo;
import com.example.pdeck.R;
import com.example.pdeck.models.Information;

import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {
    Context context;
    List<Information> informationList;

    public CardAdapter(Context context, List<Information> informationList) {
        this.context = context;
        this.informationList = informationList;
    }

    @NonNull
    @Override
    public CardAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.carditem, parent ,false);
        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull CardAdapter.ViewHolder holder, int position) {
        holder.location.setText(informationList.get(position).getLocation());
        holder.companyType.setText(informationList.get(position).getCompanytype());
        holder.companyName.setText(informationList.get(position).getCompanyName());
        holder.ctc.setText(informationList.get(position).getCtc().toString());
        holder.companyName.setText(informationList.get(position).getCompanyName());
        holder.roleOffered.setText(informationList.get(position).getRoleOffered());
        Glide.with(context).load(informationList.get(position).getLogo()).into(holder.logo);
        int id = position;

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, CardsInfo.class);
                intent.putExtra("cardId", String.valueOf(informationList.get(id).getId()));
                intent.putExtra("collegeName",informationList.get(id).getCollegeName() );
                intent.putExtra("companyName", informationList.get(id).getCompanyName());
                intent.putExtra("companytype", informationList.get(id).getCompanytype());
                intent.putExtra("roleOffered", informationList.get(id).getRoleOffered());
                intent.putExtra("ctc", String.valueOf(informationList.get(id).getCtc()));
                intent.putExtra("yearOfVisit", informationList.get(id).getYearOfVisit());
                intent.putExtra("logo", informationList.get(id).getLogo());
                intent.putExtra("noOfRounds",String.valueOf(informationList.get(id).getNoOfRounds()));
                intent.putExtra("techStack", informationList.get(id).getTechStack());
                intent.putExtra("location", informationList.get(id).getLocation());
                intent.putExtra("drivetype", informationList.get(id).getDriveType());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
          return informationList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView companyName  , companyType , roleOffered , location, ctc;

        CardView cardView;
        View parentView;
        ImageView logo;


        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            this.parentView = itemView;
            this.cardView = itemView.findViewById(R.id.cardItem);
            this.logo = itemView.findViewById(R.id.logo);
            this.companyName = itemView.findViewById(R.id.cname);
            this.companyType = itemView.findViewById(R.id.ctype);
            this.roleOffered = itemView.findViewById(R.id.role);
            this.ctc = itemView.findViewById(R.id.ctc);
            this.location = itemView.findViewById(R.id.location);


        }
    }

}
