package com.example.heyfriend.login

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import  android.widget.LinearLayout
import com.example.heyfriend.MainActivity
import com.example.heyfriend.databinding.LoginBinding


class LoginActivity : AppCompatActivity() {
    lateinit var binding: LoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LoginBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        setActionBar()

        binding.loginTwitter.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
        binding.loginFb.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    private fun setActionBar(){
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.hide()
        window.setFlags(
            WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
            WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
        )
    }

//    override fun setupView(binding: LoginBinding) {
//        // binding.linearlayout.setBackgroundColor(Color.GREEN)
//
//        binding.loginTwitter.setOnClickListener {
//            startActivity(Intent(this, HomePageActivity::class.java))
//        }
//        binding.loginFb.setOnClickListener {
//            startActivity(Intent(this, HomePageActivity::class.java))
//        }
//    }
}