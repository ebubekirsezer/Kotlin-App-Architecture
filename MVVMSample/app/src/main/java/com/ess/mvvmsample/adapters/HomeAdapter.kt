package com.ess.mvvmsample.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ess.mvvmsample.data.model.StarWarsCharacter
import com.ess.mvvmsample.databinding.CharacterListItemBinding

class HomeAdapter(
    val clickListener: CharacterClickListener,
    private val characterList: List<StarWarsCharacter>
) : RecyclerView.Adapter<HomeAdapter.RowHolder>() {


    class RowHolder private constructor(val binding: CharacterListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: StarWarsCharacter, clickListener: CharacterClickListener) {
            binding.character = item
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }

        companion object{
            fun from(parent: ViewGroup): RowHolder{
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = CharacterListItemBinding.inflate(layoutInflater, parent, false)
                return RowHolder(binding)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
        return RowHolder.from(parent)
    }

    override fun onBindViewHolder(holder: RowHolder, position: Int) {
        val characterItem = characterList.get(position)
        holder.bind(characterItem,clickListener)
    }

    override fun getItemCount(): Int = characterList.size
}

class CharacterClickListener(val clickListener: (myCharacter: StarWarsCharacter) -> Unit) {
    fun onClick(character: StarWarsCharacter) = clickListener(character)
}
