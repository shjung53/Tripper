package com.example.tripper.ui.main

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tripper.R
import com.example.tripper.`object`.MainViewModel
import com.example.tripper.databinding.ActivityMainBinding
import com.example.tripper.ui.main.home.BlockFragment
import com.example.tripper.ui.main.home.HomeFragment
import com.example.tripper.ui.main.schedule.CalendarActivity

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    val mainViewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(binding.root)




//        메인화면 내비게이션
        binding.mainBnv.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.homeFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, HomeFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }

                R.id.mapActivity -> {
//                    val intent = Intent(this, MapActivity::class.java)
//                    startActivity(intent)
//                    현재 미구현상태로 block처리
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, BlockFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }

                R.id.calendarActivity -> {
                    val intent = Intent(this, CalendarActivity::class.java)
                    startActivity(intent)
                }

//                R.id.myInfoFragment -> {
//                    supportFragmentManager.beginTransaction()
//                        .replace(R.id.main_frm, MyInfoFragment())
//                        .commitAllowingStateLoss()
//                    return@setOnItemSelectedListener true
//                }

            }
            false
        }
        binding.mainBnv.selectedItemId = R.id.homeFragment
    }

//    fun fragmentToFragment(fragment: Fragment){
//        supportFragmentManager.beginTransaction()
//            .replace(R.id.main_frm, fragment)
//            .addToBackStack(null)
//            .commitAllowingStateLoss()
//    }

}
