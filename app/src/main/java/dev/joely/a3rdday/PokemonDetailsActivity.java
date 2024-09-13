package dev.joely.a3rdday;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class PokemonDetailsActivity extends AppCompatActivity {

    private TextView pokemonNameTextView;
    private TextView pokemonTypeTextView;
    private ImageView pokemonImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_details);

        pokemonNameTextView = findViewById(R.id.pokemonNameTextView);
        pokemonTypeTextView = findViewById(R.id.pokemonTypeTextView);
        pokemonImageView = findViewById(R.id.pokemonImageView);

        int pokemonId = getIntent().getIntExtra("pokemon_id", -1);
        // Fetch Pokémon details based on ID
        Pokemon pokemon = getPokemonById(pokemonId);

        if (pokemon != null) {
            pokemonNameTextView.setText(pokemon.getName());
            pokemonTypeTextView.setText(pokemon.getType());
            // Set image based on type
            switch (pokemon.getType().toLowerCase()) {
                case "fire":
                    pokemonImageView.setImageResource(R.drawable.type_fire);
                    break;
                case "water":
                    pokemonImageView.setImageResource(R.drawable.type_water);
                    break;
                case "grass":
                    pokemonImageView.setImageResource(R.drawable.type_grass);
                    break;
                default:
                    pokemonImageView.setImageResource(R.drawable.type_default);
                    break;
            }
        }
    }

    private Pokemon getPokemonById(int id) {
        // Fetch Pokémon from a list or database
        // For simplicity, use a hardcoded list here
        List<Pokemon> pokemonList = getPokemonList();
        for (Pokemon pokemon : pokemonList) {
            if (pokemon.getId() == id) {
                return pokemon;
            }
        }
        return null;
    }

    private List<Pokemon> getPokemonList() {
        List<Pokemon> pokemonList = new ArrayList<>();
        pokemonList.add(new Pokemon(1, "Pikachu", "Electric"));
        pokemonList.add(new Pokemon(2, "Charmander", "Fire"));
        pokemonList.add(new Pokemon(3, "Bulbasaur", "Grass"));
        pokemonList.add(new Pokemon(4, "Squirtle", "Water"));
        pokemonList.add(new Pokemon(5, "Eevee", "Normal"));
        return pokemonList;
    }
}
