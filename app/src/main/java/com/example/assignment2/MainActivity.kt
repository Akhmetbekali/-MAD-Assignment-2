package com.example.assignment2

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import com.example.assignment2.data.Animal
import com.example.assignment2.data.Client
import com.example.assignment2.presentation.adapters.AnimalAdapter
import com.example.assignment2.presentation.adapters.OnAnimalItemClickListener
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.find
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity(), OnAnimalItemClickListener {
    lateinit var client: Client

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        client = Client()

        val layoutManager = GridLayoutManager(this, 2)
        val adapter = AnimalAdapter(this)


        recycler_view.adapter = adapter
        recycler_view.layoutManager = layoutManager
        recycler_view.itemAnimator = DefaultItemAnimator()


        find.setOnClickListener {
            val breed = input.text.toString()
            if (!breed.isBlank()) {
                client.animalImageService.getRandomImageByBreed(breed)
                    .enqueue(object : Callback<Animal> {
                        override fun onFailure(call: Call<Animal>, t: Throwable) {
                            Toast.makeText(this@MainActivity, "Error!", Toast.LENGTH_SHORT).show()
                        }

                        override fun onResponse(call: Call<Animal>, response: Response<Animal>) {
                            if (response.body() === null) {
                                Toast.makeText(
                                    this@MainActivity,
                                    "No such breed",
                                    Toast.LENGTH_SHORT
                                ).show()
                            } else {
                                adapter.submitList(response.body()?.link)
                            }
                        }
                    })
            } else {
                Toast.makeText(this, "Empty breed", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCellClickListener(data: String) {
        val intent = Intent()
        intent.setClassName(this, "com.example.assignment2.AnimalDetails")
        intent.putExtra("data", data)
        startActivity(intent)
    }
}