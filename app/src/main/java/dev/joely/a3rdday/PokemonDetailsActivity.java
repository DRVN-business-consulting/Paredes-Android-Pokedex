package dev.joely.a3rdday;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PokemonDetailsActivity extends AppCompatActivity {

    private TextView pokemonNameTextView, pokemonTypeTextView;
    private ImageView pokemonImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_details);

        pokemonNameTextView = findViewById(R.id.pokemonNameTextView);
        pokemonTypeTextView = findViewById(R.id.pokemonTypeTextView);
        pokemonImageView = findViewById(R.id.pokemonImageView);

        Intent intent = getIntent();
        int pokemonId = intent.getIntExtra("POKEMON_ID", -1);

        // Dummy data to simulate the details
        Pokemon pokemon = getPokemonById(pokemonId);

        if (pokemon != null) {
            pokemonNameTextView.setText(pokemon.getName());
            pokemonTypeTextView.setText(pokemon.getType());
            pokemonImageView.setImageResource(getImageResourceForPokemon(pokemon.getId()));

            // Set click listener for the image
            pokemonImageView.setOnClickListener(v -> finish()); // Close activity on click
        }
    }

    private Pokemon getPokemonById(int id) {
        // Dummy implementation; replace with actual data source retrieval
        switch (id) {
            case 1: return new Pokemon(1, "Pikachu", "Electric");
            case 2: return new Pokemon(2, "Charmander", "Fire");
            case 3: return new Pokemon(3, "Bulbasaur", "Grass");
            case 4: return new Pokemon(4, "Squirtle", "Water");
            default: return null;
        }
    }

    private int getImageResourceForPokemon(int id) {
        switch (id) {
            case 1:
                return R.drawable.img;
            case 2:
                return R.drawable.img_1;
            case 3:
                return R.drawable.img_2;
            default:
                return R.drawable.img; // Fallback image
        }
    }
}
