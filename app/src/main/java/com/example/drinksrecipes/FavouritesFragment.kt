package com.example.drinksrecipes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_favourites.*


class FavouritesFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val name = this.requireArguments().getString("title").toString()
        val desc = this.requireArguments().getString("desc").toString()

        tv_drink.text = name
        tv_desc.text = desc

        return inflater.inflate(R.layout.fragment_favourites, container, false)
    }


}