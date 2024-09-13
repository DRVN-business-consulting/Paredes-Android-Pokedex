package dev.joely.a3rdday;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PokemonDetailsActivity extends AppCompatActivity {

    private TextView pokemonNameTextView, pokemonTypeTextView, pokemonDetailsTextView;
    private ImageView pokemonImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_details);

        pokemonNameTextView = findViewById(R.id.pokemonNameTextView);
        pokemonTypeTextView = findViewById(R.id.pokemonTypeTextView);
        pokemonDetailsTextView = findViewById(R.id.pokemonDetailsTextView);
        pokemonImageView = findViewById(R.id.pokemonImageView);

        Intent intent = getIntent();
        int pokemonId = intent.getIntExtra("POKEMON_ID", -1);

        // Dummy data to simulate the details
        Pokemon pokemon = getPokemonById(pokemonId);

        if (pokemon != null) {
            pokemonNameTextView.setText(pokemon.getName());
            pokemonTypeTextView.setText(pokemon.getType());
            pokemonImageView.setImageResource(getImageResourceForPokemon(pokemon.getId()));

            // Set placeholder details text
            pokemonDetailsTextView.setText(getPokemonDetails(pokemonId));

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

    private String getPokemonDetails(int id) {
        // Provide detailed information based on Pokemon ID
        switch (id) {
            case 1: return "Pikachu is an Electric-type Pokémon. It is known for its yellow fur and ability to generate electricity.";
            case 2: return "Charmander is a Fire-type Pokémon. It has a flame on its tail and is known for its fiery personality.";
            case 3: return "Bulbasaur is a Grass/Poison-type Pokémon. It has a plant bulb on its back that grows into a large flower.";
            case 4: return "Squirtle is a Water-type Pokémon. It has a shell and is known for its water-based attacks.";
            default: return "No details available.";
        }
    }
}
