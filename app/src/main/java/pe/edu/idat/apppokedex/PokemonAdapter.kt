package pe.edu.idat.apppokedex

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import pe.edu.idat.apppokedex.databinding.ItemPokemonBinding
import pe.edu.idat.apppokedex.retrofit.response.Pokemon

class PokemonAdapter:RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {

    private var listaPokemon = ArrayList<Pokemon>()

    inner class ViewHolder(val binding: ItemPokemonBinding)
        :RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val binding = ItemPokemonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return  ViewHolder(binding)
    }

    override fun getItemCount()= listaPokemon.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(listaPokemon[position]){
                binding.tvnompokemon.text = name
                Glide.with(itemView.context)
                    .load(url)
                    .into(binding.ivpokemon)
            }
        }
    }

    fun cargarPokemones(lista: List<Pokemon>){
        listaPokemon.addAll(lista)
        notifyDataSetChanged()
    }

}