package com.example.dispmoveis03;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_ADD_MOOD = 1001;
    TextView dateTextView;
    ImageView moodImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         dateTextView = findViewById(R.id.dateTextView);
         moodImageView = findViewById(R.id.moodImageView);

        Intent telaHumor = getIntent();
        String humor = telaHumor.getStringExtra("selectedMood");

        if(humor != null) {
            addMoodRecord(humor);
        }

        Button addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddMoodActivity.class);
                startActivity(intent);
            }
        });
    }

    // @Override
    // public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
    //    super.onActivityResult(requestCode, resultCode, data);
    //    if (requestCode == REQUEST_CODE_ADD_MOOD && resultCode == RESULT_OK) {
    //       if (data != null && data.hasExtra("selectedMood")) {
    //          String selectedMood = data.getStringExtra("selectedMood");
    //          addMoodRecord(selectedMood);
    //       }
    //    }
    //}

    private void addMoodRecord(String selectedMood) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault());
        String currentDate = dateFormat.format(calendar.getTime());

        dateTextView.setText(currentDate);
        switch (selectedMood) {
            case "ic_happy":
                moodImageView.setImageResource(R.drawable.ic_happy);
                break;
            case "ic_neutral":
                moodImageView.setImageResource(R.drawable.ic_neutral);
                break;
            case "ic_crying":
                moodImageView.setImageResource(R.drawable.ic_crying);
                break;
            case "ic_angry":
                moodImageView.setImageResource(R.drawable.ic_angry);
                break;
            case "ic_tired":
                moodImageView.setImageResource(R.drawable.ic_tired);
                break;
            default:
                break;
        }
    }
}
