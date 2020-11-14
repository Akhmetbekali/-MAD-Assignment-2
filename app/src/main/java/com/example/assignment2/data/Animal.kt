package com.example.assignment2.data

import androidx.recyclerview.widget.DiffUtil
import com.google.gson.annotations.SerializedName

data class Animal (
    @SerializedName("message")
    val link: List<String>,
    @SerializedName("status")
    val status: String
) {

    companion object {
        val DIFF_CALLBACK: DiffUtil.ItemCallback<String> =
            object : DiffUtil.ItemCallback<String>() {

                override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
                    return oldItem == newItem
                }

                override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
                    return oldItem == newItem
                }
            }
    }
}
