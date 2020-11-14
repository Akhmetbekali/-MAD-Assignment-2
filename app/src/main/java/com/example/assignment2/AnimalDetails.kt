package com.example.assignment2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_animal_details.*

class AnimalDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val data = intent.getStringExtra("data")
        setContentView(R.layout.activity_animal_details)
        Glide.with(this).load(data).into(imageView)
        close.setOnClickListener {
            this.finish()
        }
    }
}