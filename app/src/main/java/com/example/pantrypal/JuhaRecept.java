package com.example.pantrypal;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class JuhaRecept extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juharecept);

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("recipe_name")) {
            String recipeName = intent.getStringExtra("recipe_name");
            int recipeImageResId = intent.getIntExtra("recipe_image", R.drawable.dalmatinska);

            ImageView ivRecipeImage = findViewById(R.id.ivRecipeImage);
            ivRecipeImage.setImageResource(recipeImageResId);

            TextView tvRecipeName = findViewById(R.id.tvRecipeName);
            tvRecipeName.setText(recipeName);

            String ingredients = getIngredientsForRecipe(recipeName);

            TextView tvIngredients = findViewById(R.id.tvIngredients);
            tvIngredients.setText("Ingredients:\n" + ingredients);
        }
    }

    private String getIngredientsForRecipe(String recipeName) {
        switch (recipeName) {
            case "Dalmatinska":
                return "1 lb chicken\n2 carrots\n2 celery stalks\n1 onion\n2 cloves garlic\nSalt and pepper\n8 cups chicken broth";
            case "Gazpacho":
                return "3 ripe tomatoes\n1 cucumber\n1 red bell pepper\n1 green bell pepper\n1 onion\n2 cloves garlic\n2 tbsp olive oil\n2 tbsp red wine vinegar\nSalt and pepper";
            case "Harira":
                return "1/2 lb lamb\n1 onion\n2 cloves garlic\n1/2 cup lentils\n1/4 cup rice\n1/4 cup chickpeas\n1/4 cup chopped tomatoes\n1/4 cup chopped cilantro\n1/4 cup chopped parsley\nSpices (cumin, paprika, turmeric)";
            case "Laksa":
                return "1 lb shrimp\n1 lb chicken\n2 cups coconut milk\n4 cups chicken broth\n1 onion\n2 cloves garlic\n1 tbsp curry powder\n1 tbsp chili paste\n1 tbsp fish sauce\n1 tsp sugar\nRice noodles\nBean sprouts\nLime wedges\nCilantro";
            case "Yayla Çorbası":
                return "1/2 cup rice\n4 cups chicken broth\n2 cups plain yogurt\n2 eggs\n2 tbsp flour\n1/4 cup chopped dill\nSalt and pepper";
            default:
                return "Unknown recipe";
        }
    }

}
