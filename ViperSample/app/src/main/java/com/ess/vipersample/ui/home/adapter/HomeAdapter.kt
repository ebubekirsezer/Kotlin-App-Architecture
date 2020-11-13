package com.ess.vipersample.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ess.vipersample.R
import com.ess.vipersample.app.model.StarWarsCharacter

class HomeAdapter(
    private val characters: List<StarWarsCharacter>?,
    private var listener: (StarWarsCharacter?) -> Unit
) :
    RecyclerView.Adapter<HomeAdapter.CharacterHolder>() {

    class CharacterHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(character: StarWarsCharacter) {
            itemView.findViewById<TextView>(R.id.character_name).text = character.name
            itemView.findViewById<TextView>(R.id.character_birth_year).text = character.birth_year
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapter.CharacterHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.character_list_item, parent, false)

        return CharacterHolder(view)
    }

    override fun onBindViewHolder(holder: HomeAdapter.CharacterHolder, position: Int) {
        characters?.let {
            holder.bind(characters.get(position))
        }

        holder.itemView.setOnClickListener { listener(characters?.get(position)) }
    }

    override fun getItemCount(): Int = characters?.size ?: 0

}