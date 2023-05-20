package com.example.AiHub.fragments;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.browser.customtabs.CustomTabsIntent;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.AiHub.GptActivity;
import com.example.AiHub.ImageGenrator;
import com.example.AiHub.R;
import com.example.AiHub.SpeechRecogActivity;
import com.example.AiHub.TextAnalyzer;
import com.google.android.material.card.MaterialCardView;

public class HomeFragment extends Fragment  {

    private MaterialCardView onetool, chatGpt , objectDetection , textAnalyzer , speechToText, imageGenerator;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_home_fragment, null);

        Context context = getActivity().getApplicationContext();



        String url1 = "https://www.perplexity.ai/";


        onetool = root.findViewById(R.id.onetool);


        chatGpt = root.findViewById(R.id.chatgpt);
        textAnalyzer = root.findViewById(R.id.textanalyzer);
        speechToText = root.findViewById(R.id.speecttotext);
        imageGenerator = root.findViewById(R.id.imagegen);


        chatGpt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context , GptActivity.class);
                intent.addFlags(FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

        speechToText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context , SpeechRecogActivity.class);
                intent.addFlags(FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

        imageGenerator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context , ImageGenrator.class);
                intent.addFlags(FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

        textAnalyzer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context , TextAnalyzer.class);
                intent.addFlags(FLAG_ACTIVITY_NEW_TASK);

                context.startActivity(intent);
            }
        });

        onetool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomTabsIntent.Builder customIntent = new CustomTabsIntent.Builder();
                customIntent.setToolbarColor(ContextCompat.getColor(context, R.color.purple_200));
                openCustomTab( getActivity(), customIntent.build(), Uri.parse(url1));
            }
        });




        return root;


    }
    public static void openCustomTab(Activity activity, CustomTabsIntent customTabsIntent, Uri uri) {
        String packageName = "com.android.chrome";
        if (packageName != null) {
            customTabsIntent.intent.setPackage(packageName);
            customTabsIntent.launchUrl(activity, uri);
        } else {
            activity.startActivity(new Intent(Intent.ACTION_VIEW, uri));
        }
    }


}