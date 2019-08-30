package com.example.josycom.reciperecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    private ImageView imageView;
    private TextView textView;
    private Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        imageView = findViewById(R.id.recipe_image);
        textView = findViewById(R.id.recipe_details);
        //Gets the data that is sent to it from the Main Activity and displays it
        extras = getIntent().getExtras();
        if (extras != null){
            String details = extras.getString("details");
            int image = extras.getInt("image");
            textView.setText(details);
            imageView.setImageDrawable(getResources().getDrawable(image));
        }
    }
}
