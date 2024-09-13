package dev.joely.a3rdday;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import dev.joely.a3rdday.R;
import dev.joely.a3rdday.adapter.PokemonAdapter;

public class PokemonListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_list);

        RecyclerView pokemonRecyclerView = findViewById(R.id.pokemonRecyclerView);
        pokemonRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Pokemon> pokemonList = new ArrayList<>();
        pokemonList.add(new Pokemon("Pikachu", "Electric"));
        pokemonList.add(new Pokemon("Charmander", "Fire"));
        pokemonList.add(new Pokemon("Bulbasaur", "Grass"));
        pokemonList.add(new Pokemon("Squirtle", "Water"));
        pokemonList.add(new Pokemon("Eevee", "Normal"));

        PokemonAdapter pokemonAdapter = new PokemonAdapter(pokemonList);
        pokemonRecyclerView.setAdapter(pokemonAdapter);
    }
}