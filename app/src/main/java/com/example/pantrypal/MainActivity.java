package com.example.pantrypal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    Button btnSoup, btnPastry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSoup = findViewById(R.id.btnSoup);
        btnPastry = findViewById(R.id.btnPastry);

        btnSoup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRecipeActivity(Soup.class);
            }
        });

        btnPastry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRecipeActivity(Pastry.class);
            }
        });
    }
    private void openRecipeActivity(Class<?> recipeClass) {
        Intent intent = new Intent(MainActivity.this, recipeClass);
        startActivity(intent);
    }
}