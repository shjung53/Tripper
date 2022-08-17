package com.example.tripper.ui.main.myInfo

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tripper.databinding.ActivityProfileEditBinding

class ProfileEditActivity: AppCompatActivity() {
    private val binding = ActivityProfileEditBinding.inflate(layoutInflater)
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        setContentView(binding.root)



    }

}