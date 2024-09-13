package dev.joely.a3rdday.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import dev.joely.a3rdday.Pokemon;
import dev.joely.a3rdday.PokemonDetailsActivity;
import dev.joely.a3rdday.R;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder> {

    private final List<Pokemon> pokemonList;
    private final Context context;

    public PokemonAdapter(Context context, List<Pokemon> pokemonList) {
        this.context = context;
        this.pokemonList = pokemonList;
    }

    @NonNull
    @Override
    public PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pokemon_item, parent, false);
        return new PokemonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonViewHolder holder, int position) {
        Pokemon pokemon = pokemonList.get(position);
        holder.pokemonNameTextView.setText(pokemon.getName());
        holder.pokemonTypeTextView.setText(pokemon.getType());
        holder.pokemonImageView.setImageResource(getImageResourceForPokemon(pokemon.getId())); // Set image based on Pokemon ID
        holder.typeImageView.setImageResource(getImageResourceForType(pokemon.getType())); // Set type image

        // Set click listener
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, PokemonDetailsActivity.class);
            intent.putExtra("POKEMON_ID", pokemon.getId()); // Pass the correct Pokémon ID
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return pokemonList.size();
    }

    public static class PokemonViewHolder extends RecyclerView.ViewHolder {
        TextView pokemonNameTextView, pokemonTypeTextView;
        ImageView pokemonImageView;
        ImageView typeImageView; // Add this for type image

        public PokemonViewHolder(@NonNull View itemView) {
            super(itemView);
            pokemonNameTextView = itemView.findViewById(R.id.pokemonNameTextView);
            pokemonTypeTextView = itemView.findViewById(R.id.pokemonTypeTextView);
            pokemonImageView = itemView.findViewById(R.id.pokemonImageView);
            typeImageView = itemView.findViewById(R.id.typeImageView); // Initialize this
        }
    }

    // Method to get image resource based on Pokémon ID (assuming ID is used for Pokémon images)
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

    // Method to get image resource based on Pokémon type
    private int getImageResourceForType(String type) {
        switch (type) {
            case "Fire":
                return R.drawable.type_fire;
            case "Water":
                return R.drawable.type_water;
            case "Grass":
                return R.drawable.type_grass;
            default:
                return R.drawable.type_default;
        }
    }
}
