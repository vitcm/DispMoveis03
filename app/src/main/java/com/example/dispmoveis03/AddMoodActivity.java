package com.example.dispmoveis03;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class AddMoodActivity extends AppCompatActivity {

    private String currentMood = "";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_mood);

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        String currentDate = dateFormat.format(calendar.getTime());

        TextView dateTextView = findViewById(R.id.dateTextView);
        dateTextView.setText(currentDate);

        ImageView happyImageView = findViewById(R.id.ic_happy);
        ImageView neutralImageView = findViewById(R.id.ic_neutral);
        ImageView cryingImageView = findViewById(R.id.ic_crying);
        ImageView angryImageView = findViewById(R.id.ic_angry);
        ImageView tiredImageView = findViewById(R.id.ic_tired);

        happyImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                happyImageView.setBackgroundColor(Color.YELLOW);
                neutralImageView.setBackgroundColor(Color.TRANSPARENT);
                cryingImageView.setBackgroundColor(Color.TRANSPARENT);
                angryImageView.setBackgroundColor(Color.TRANSPARENT);
                tiredImageView.setBackgroundColor(Color.TRANSPARENT);
                currentMood = "ic_happy";
            }
        });

        neutralImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                happyImageView.setBackgroundColor(Color.TRANSPARENT);
                neutralImageView.setBackgroundColor(Color.YELLOW);
                cryingImageView.setBackgroundColor(Color.TRANSPARENT);
                angryImageView.setBackgroundColor(Color.TRANSPARENT);
                tiredImageView.setBackgroundColor(Color.TRANSPARENT);
                currentMood = "ic_neutral";
            }
        });

        cryingImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                happyImageView.setBackgroundColor(Color.TRANSPARENT);
                neutralImageView.setBackgroundColor(Color.TRANSPARENT);
                cryingImageView.setBackgroundColor(Color.YELLOW);
                angryImageView.setBackgroundColor(Color.TRANSPARENT);
                tiredImageView.setBackgroundColor(Color.TRANSPARENT);
                currentMood = "ic_crying";
            }
        });

        angryImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                happyImageView.setBackgroundColor(Color.TRANSPARENT);
                neutralImageView.setBackgroundColor(Color.TRANSPARENT);
                cryingImageView.setBackgroundColor(Color.TRANSPARENT);
                angryImageView.setBackgroundColor(Color.YELLOW);
                tiredImageView.setBackgroundColor(Color.TRANSPARENT);
                currentMood = "ic_angry";
            }
        });

        tiredImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                happyImageView.setBackgroundColor(Color.TRANSPARENT);
                neutralImageView.setBackgroundColor(Color.TRANSPARENT);
                cryingImageView.setBackgroundColor(Color.TRANSPARENT);
                angryImageView.setBackgroundColor(Color.TRANSPARENT);
                tiredImageView.setBackgroundColor(Color.YELLOW);
                currentMood = "ic_tired";
            }
        });

        Button addMoodButton = findViewById(R.id.addMoodButton);
        addMoodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddMoodActivity.this, MainActivity.class);
                intent.putExtra("selectedMood", currentMood);
                startActivity(intent);
            }
        });
    }
}