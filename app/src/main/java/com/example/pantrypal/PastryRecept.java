package com.example.pantrypal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class PastryRecept extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pastry_recept);

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
            case "Muffini":
                return "1 cup all-purpose flour\n1/2 cup granulated sugar\n1/2 cup milk\n1/4 cup vegetable oil\n1 egg\n1 1/2 teaspoons baking powder\n1/2 teaspoon salt\n1/2 teaspoon vanilla extract\n1/2 cup chocolate chips";
            case "Tuljci":
                return "3 cups all-purpose flour\n1 cup warm water\n1 tablespoon active dry yeast\n1 teaspoon sugar\n1 teaspoon salt\n2 tablespoons olive oil\n2 tablespoons chopped fresh parsley\n2 cloves garlic, minced\n1 teaspoon dried oregano\n1/4 teaspoon black pepper";
            case "Ledeni vjetar":
                return "2 cups all-purpose flour\n1 cup granulated sugar\n1 cup unsalted butter, softened\n2 large eggs\n1 teaspoon vanilla extract\n1 teaspoon baking powder\n1/2 teaspoon salt\n1/2 cup chopped walnuts\n1/2 cup chopped maraschino cherries\nPowdered sugar, for dusting";
            case "Čupavci":
                return "1 1/2 cups all-purpose flour\n1/2 cup unsweetened cocoa powder\n1 teaspoon baking powder\n1/4 teaspoon salt\n1/2 cup unsalted butter, softened\n1 cup granulated sugar\n2 large eggs\n1 teaspoon vanilla extract\n1 cup sweetened shredded coconut\n1/2 cup chopped walnuts\n1/2 cup heavy cream\n1/2 cup granulated sugar\n1/2 teaspoon vanilla extract\n1/2 cup dark chocolate chips";
            case "Mađarica":
                return "1 cup all-purpose flour\n1 cup granulated sugar\n1/2 cup unsweetened cocoa powder\n1/2 teaspoon baking soda\n1/4 teaspoon salt\n3 large eggs\n1/2 cup unsalted butter, melted\n1/2 cup milk\n1 teaspoon vanilla extract\n1/2 cup sour cream";
            default:
                return "Unknown recipe";
        }
    }

}
