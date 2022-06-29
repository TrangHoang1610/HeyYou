package com.example.heyfriend

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.heyfriend.fragment.*
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setActionBar()
        setContentView(R.layout.activity_main)
        val navigation = findViewById<View>(R.id.navigation) as BottomNavigationView
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
    private val mOnNavigationItemSelectedListener =
            BottomNavigationView.OnNavigationItemSelectedListener { item ->
                val fragment: Fragment
                when (item.itemId) {
                    R.id.menu_drawer -> {
                        fragment = MenuFragment()
                        loadFragment(fragment)
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.menu_map -> {
                        fragment = MapFragment()
                        loadFragment(fragment)
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.menu_chat -> {
                        fragment = ChatFragment()
                        loadFragment(fragment)
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.menu_icon -> {
                        fragment = ImageFragment()
                        loadFragment(fragment)
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.menu_setting -> {
                        fragment = SettingFragment()
                        loadFragment(fragment)
                        return@OnNavigationItemSelectedListener true
                    }
                }
                false
            }
    private fun loadFragment(fragment: Fragment) {
        // load fragment
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    private fun setActionBar() {
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.hide()
        window.setFlags(
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
        )
    }

}