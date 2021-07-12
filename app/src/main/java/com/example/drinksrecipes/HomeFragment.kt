package com.example.drinksrecipes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeFragment : Fragment() {
    var name: String = ""
    var name1: String = ""


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val request = ServiceBuilder.buildService(NetworkApi::class.java)
        val call = request.getAllPosts(name = name)

        call.enqueue(object : Callback<Recipes> {
            override fun onFailure(call: Call<Recipes>, t: Throwable) {
            }

            override fun onResponse(call: Call<Recipes>, response: Response<Recipes>) {
                if (response.isSuccessful) {
                    rv_main.apply {
                        setHasFixedSize(true)
                        layoutManager = LinearLayoutManager(activity)
                        adapter = RecyclerAdapter(response.body()!!.drinks)
                    }
                }

            }

        })



        if (by_name != null)
            by_name.setOnClickListener {

            }
        if (by_alphabet != null)
            by_alphabet.setOnClickListener {


                val request1 = ServiceBuilder.buildService(NetworkApi2::class.java)
                val call1 = request1.getAllPosts(name = name1)

                call1.enqueue(object : Callback<Recipes> {
                    override fun onFailure(call: Call<Recipes>, t: Throwable) {
                    }

                    override fun onResponse(call: Call<Recipes>, response: Response<Recipes>) {
                        if (response.isSuccessful) {
                            rv_main.apply {
                                setHasFixedSize(true)
                                layoutManager = LinearLayoutManager(activity)
                                adapter = RecyclerAdapter(response.body()!!.drinks)
                            }
                        }

                    }

                })


            }




        return inflater.inflate(R.layout.fragment_home, container, false)
    }


}