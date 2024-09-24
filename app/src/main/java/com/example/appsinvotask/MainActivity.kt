package com.example.appsinvotask

import android.animation.ValueAnimator
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.AnimationUtils
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.appsinvotask.databinding.ActivityMainBinding
import com.example.appsinvotask.fragmens.HomeFragment
import com.example.appsinvotask.fragmens.MyQrFragment
import com.example.appsinvotask.fragmens.ProfileFragment
import com.example.appsinvotask.fragmens.ScanQRFragment
import com.example.appsinvotask.fragmens.myBookingFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupBottomNavigation()
        if (savedInstanceState == null) {

//            binding.customBottomBar.selectedItemId = R.id.Home
//                loadHomeFragment()
        }
    }

    private fun moveCircleToPosition(position: Int,image:Int) {
        val itemWidth = binding.customBottomBar.width / binding.customBottomBar.menu.size()
        val targetX = itemWidth * position + (itemWidth / 2) - (binding.circleIndicator.width / 2)
        Glide.with(this).load(image).into(binding.idicatorImage)
        // Animate circle's movement
        ValueAnimator.ofFloat(binding.circleIndicator.x, targetX.toFloat()).apply {
            duration = 300 // animation duration in milliseconds
            addUpdateListener { animation ->
                binding.circleIndicator.x = animation.animatedValue as Float
            }
            start()
        }
    }

    fun setupBottomNavigation() {
         val mBottomNavigationView = findViewById<View>(R.id.customBottomBar) as BottomNavigationView
        mBottomNavigationView?.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.Home -> {
                    loadHomeFragment()
                    moveCircleToPosition(2,R.drawable.vector_smart_object)
                    true
                }
                R.id.MyBooking -> {
                    moveCircleToPosition(0,R.drawable.booking)
                    loadMyBookingFragment()
                    true
                }
                R.id.MyQR -> {
                    moveCircleToPosition(3,R.drawable.group_3)
                    loadMyQRFragment()
                    true
                }
                R.id.ScanQr -> {
                    moveCircleToPosition(1,R.drawable.layer_16)
                    loadScanQrFragment()
                    true
                }
                R.id.Profile -> {
                    moveCircleToPosition(4,R.drawable.group_10)
                    loadProfileFragment()
                    true
                }
                else -> false
            }
        }
    }


    fun loadHomeFragment() {
        val fragment = HomeFragment.newInstance()
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.MainFrameLayout, fragment)
        ft.commit()
    }

    fun loadMyQRFragment() {
        val fragment = MyQrFragment.newInstance()
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.MainFrameLayout, fragment)
        ft.commit()
    }

    private fun loadScanQrFragment() {
        val fragment = ScanQRFragment.newInstance()
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.MainFrameLayout, fragment)
        ft.commit()
    }

    private fun loadProfileFragment() {
        val fragment = ProfileFragment.newInstance()
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.MainFrameLayout, fragment)
        ft.commit()
    }

    private fun loadMyBookingFragment() {
        val fragment = myBookingFragment.newInstance()
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.MainFrameLayout, fragment)
        ft.commit()
    }
}