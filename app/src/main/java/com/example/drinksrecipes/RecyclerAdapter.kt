package com.example.drinksrecipes

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.main_screen_item.view.*


class RecyclerAdapter(val postList: List<Drinks>) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {


        fun bind(data: Drinks) {

            name.text = data.strDrink
            desc.text = data.strInstructions
        }

        var name: TextView
        var desc: TextView


        init {
            name = view.tv_drink
            desc = view.tv_desc
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.main_screen_item, parent, false)

        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {

        return postList.size

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.itemView.setOnClickListener {

            val model = postList.get(position)
            var title: String = model.strDrink
            var descp: String = model.strInstructions
            val bundle = Bundle()
            bundle.putString("title", title)
            bundle.putString("desc", descp)

            val myFragment = FavouritesFragment()
            myFragment.arguments = bundle


        }


        return holder.bind(postList[position])


    }


}

