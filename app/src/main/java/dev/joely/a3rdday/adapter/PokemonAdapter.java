package dev.joely.a3rdday.adapter;

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

    public PokemonAdapter(List<Pokemon> pokemonList) {
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

        // Set type image
        switch (pokemon.getType().toLowerCase()) {
            case "fire":
                holder.typeImageView.setImageResource(R.drawable.type_fire);
                break;
            case "water":
                holder.typeImageView.setImageResource(R.drawable.type_water);
                break;
            case "grass":
                holder.typeImageView.setImageResource(R.drawable.type_grass);
                break;
            default:
                holder.typeImageView.setImageResource(R.drawable.type_default);
                break;
        }

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), PokemonDetailsActivity.class);
            intent.putExtra("pokemon_id", pokemon.getId());
            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return pokemonList.size();
    }

    public static class PokemonViewHolder extends RecyclerView.ViewHolder {
        TextView pokemonNameTextView, pokemonTypeTextView;
        ImageView typeImageView;

        public PokemonViewHolder(@NonNull View itemView) {
            super(itemView);
            pokemonNameTextView = itemView.findViewById(R.id.pokemonNameTextView);
            pokemonTypeTextView = itemView.findViewById(R.id.pokemonTypeTextView);
            typeImageView = itemView.findViewById(R.id.typeImageView);
        }
    }
}
