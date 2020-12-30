package com.example.scrollgallery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.profile.*

class profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile)
        init()
    }
    private fun init(){
        Glide.with(this)
            .load("https://i.redd.it/v0caqchbtn741.jpg")
            .placeholder(R.mipmap.profilepic)
            .error(R.mipmap.profilepic)
            .into(profilePicture);

        Glide.with(this)
            .load("https://wallpapercave.com/wp/wp2646303.jpg")
            .placeholder(R.mipmap.nophoto)
            .error(R.mipmap.nophoto)
            .into(coverPicture);
    }
}