package com.example.pantrypal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.MediaPlayer;
import android.os.Bundle;
import java.util.ArrayList;

public class Pastry extends AppCompatActivity {

    ArrayList<model> models = new ArrayList<>();
    int [] slike = {R.drawable.muffini, R.drawable.tuljci, R.drawable.ledeni_vjetar, R.drawable.cupavci, R.drawable.madarica};
    MediaPlayer likeSound, disSound, favSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pastry);

        RecyclerView recyclerView = findViewById(R.id.idRecycle);

        setupModel();

        recycleAdapter adapter = new recycleAdapter(this, models);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        likeSound = MediaPlayer.create(this, R.raw.likesound);
        disSound = MediaPlayer.create(this, R.raw.dissound);
        favSound = MediaPlayer.create(this, R.raw.favsound);
    }

    private void setupModel(){
        String[] nazivi = getResources().getStringArray(R.array.kolaci);

        for (int i = 0; i < nazivi.length; i++){
            models.add(new model(nazivi[i], slike[i]));
        }
    }
}
