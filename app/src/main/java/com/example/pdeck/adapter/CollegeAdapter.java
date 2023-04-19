package com.example.pdeck.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.pdeck.R;
import com.example.pdeck.models.CollegeInfo;
import com.example.pdeck.models.Information;

import java.util.ArrayList;
import java.util.List;

public class CollegeAdapter extends RecyclerView.Adapter<CollegeAdapter.ViewHolder> {
    Context context;
    List<CollegeInfo> collegeList;

    public CollegeAdapter(Context context, List<CollegeInfo> collegeList) {
        this.context = context;
        this.collegeList = collegeList;
    }

    @NonNull
    @Override
    public CollegeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.college_cards, parent ,false);
        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull CollegeAdapter.ViewHolder holder, int position) {
        holder.location.setText(collegeList.get(position).getLocation());
        holder.collegeName.setText(collegeList.get(position).getCollegeName());
        Glide.with(context).load(collegeList.get(position).getImgUrl()).into(holder.colImg);


//        holder.cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                Intent intent = new Intent(context, CardsInfo.class);
////                intent.putExtra("cardId", String.valueOf(collegeList.get(id).getId()));
////                intent.putExtra("collegeName",collegeList.get(id).getCollegeName() );
////                intent.putExtra("companyName", collegeList.get(id).getCompanyName());
////                intent.putExtra("companytype", collegeList.get(id).getCompanytype());
////                intent.putExtra("roleOffered", collegeList.get(id).getRoleOffered());
////                intent.putExtra("ctc", String.valueOf(collegeList.get(id).getCtc()));
////                intent.putExtra("yearOfVisit", informationList.get(id).getYearOfVisit());
////                intent.putExtra("logo", informationList.get(id).getLogo());
////                intent.putExtra("noOfRounds",String.valueOf(informationList.get(id).getNoOfRounds()));
////                intent.putExtra("techStack", informationList.get(id).getTechStack());
////                intent.putExtra("location", informationList.get(id).getLocation());
////                intent.putExtra("drivetype", informationList.get(id).getDriveType());
////                context.startActivity(intent);
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return collegeList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView collegeName  , location ;

        CardView cardView;
        View parentView;
        ImageView colImg;


        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            this.parentView = itemView;
            this.cardView = itemView.findViewById(R.id.cardItem);
            this.colImg = itemView.findViewById(R.id.colImg);
            this.collegeName = itemView.findViewById(R.id.collegeName);
            this.location = itemView.findViewById(R.id.location);


        }
    }

}
