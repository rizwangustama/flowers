package com.dicoding.myflowers2

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class about : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        var actionBar = supportActionBar
        actionBar!!.title = "About"
        actionBar.setDisplayHomeAsUpEnabled(true)

        val imgMe : ImageView = findViewById(R.id.about_image)

        val tImg = "https://www.dicoding.com/images/small/avatar/201909271639453bf31eb18fe90d9174ed702c5cfeaedf.jpg"

        Glide.with(this)
            .load(tImg)
            .apply(RequestOptions())
            .into(imgMe)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}