package com.example.pantrypal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import java.util.ArrayList;

public class Soup extends AppCompatActivity {

    ArrayList<model> models = new ArrayList<>();
    int [] slike = {R.drawable.dalmatinska, R.drawable.gazpacho, R.drawable.harira, R.drawable.laksa, R.drawable.yayla_corbasi};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soup);

        RecyclerView recyclerView = findViewById(R.id.idRecycle);

        setupModel();

        recycleAdapter adapter = new recycleAdapter(this, models);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setupModel(){
        String[] nazivi = getResources().getStringArray(R.array.juhe);

        for (int i = 0; i < nazivi.length; i++){
            models.add(new model(nazivi[i], slike[i]));
        }
    }
}
