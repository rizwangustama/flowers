package com.dicoding.myflowers2

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class detail_flower : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_flower)

        val tvSetName: TextView = findViewById(R.id.tv_item_name)
        val imgSetPhoto: ImageView = findViewById(R.id.img_item_photo)
        val tvSetIden: TextView = findViewById(R.id.tv_set_identity)
        val tvOverview: TextView = findViewById(R.id.tv_set_overview)
        val tvSpesies: TextView = findViewById(R.id.tv_item_spesies)

        val tNama = intent.getStringExtra(EXTRA_NAME)
        val tImg = intent.getStringExtra(EXTRA_PHOTO)
        val tIden = intent.getStringExtra(EXTRA_IDENTITY)
        val tOverview = intent.getStringExtra(EXTRA_OVERVIEW)
        val tSpesies = intent.getStringExtra(EXTRA_SPESIES)

        tvSetName.text = tNama
        Glide.with(this)
                .load(tImg)
                .apply(RequestOptions())
                .into(imgSetPhoto)
        tvSetIden.text = tIden
        tvOverview.text = tOverview
        tvSpesies.text = tSpesies
    }

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_PHOTO = "extra_photo"
        const val EXTRA_IDENTITY = "extra_identity"
        const val EXTRA_OVERVIEW = "extra_overview"
        const val EXTRA_SPESIES = "extra_spesies"

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}