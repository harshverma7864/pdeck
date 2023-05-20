package com.example.AiHub;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TextAnalyzer extends AppCompatActivity {


    private EditText analyzer;
    private Button analyze;

    private TextView twords, tspaces  , tletters, tcommas, tfullstops, tvowels;

    private static Integer words = 1, spaces = 0 , letters = 0 , commas = 0 , fullStops = 0,vowels=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_analyzer);
        analyzer = findViewById(R.id.analyzer);
        analyze = findViewById(R.id.analyze);
        twords = findViewById(R.id.tWords);
        tletters = findViewById(R.id.tLetters);
        tspaces = findViewById(R.id.tSpaces);
        tvowels = findViewById(R.id.tVowels);
        tcommas = findViewById(R.id.tCommas);
        tfullstops = findViewById(R.id.tfullStops);


        analyze.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = analyzer.getText().toString();
                String[] tokens = text.split("");

                for (String s:tokens){
                    if (s.equals(" "))
                    {
                        words++;
                        spaces++;
                        letters++;
                    } else if (s.equalsIgnoreCase("a") || s.equalsIgnoreCase("e") || s.equalsIgnoreCase("i") || s.equalsIgnoreCase("o") || s.equalsIgnoreCase("u")) {
                        vowels++;
                        letters++;
                    } else if (s.equals(",")) {
                        commas++;
                        letters++;
                    } else if (s.equals(".")) {
                        fullStops++;
                        letters++;
                    }else{
                        letters++;
                    }
                }

                twords.setText(words.toString());
                tspaces.setText(spaces.toString());
                tletters.setText(letters.toString());
                tfullstops.setText(fullStops.toString());
                tvowels.setText(vowels.toString());
                tcommas.setText(commas.toString());

            }
        });


    }
}