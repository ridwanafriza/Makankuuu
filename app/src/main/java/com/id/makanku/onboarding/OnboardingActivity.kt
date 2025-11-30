package com.id.makanku.onboarding


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.id.makanku.onboarding.OnboardingAdapter
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator
import android.widget.Button
import android.widget.TextView
import com.id.makanku.R
import com.id.makanku.LoginRegister.LoginActivity

class OnboardingActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        viewPager = findViewById(R.id.viewPager)
        val nextBtn = findViewById<Button>(R.id.nextButton)
        val skipBtn = findViewById<TextView>(R.id.skipButton)
        val dots = findViewById<WormDotsIndicator>(R.id.dots_indicator)

        val adapter = OnboardingAdapter(this)
        viewPager.adapter = adapter
        dots.setViewPager2(viewPager) // untuk versi dotsindicator 4.3

        nextBtn.setOnClickListener {
            if (viewPager.currentItem < adapter.itemCount - 1) {
                viewPager.currentItem = viewPager.currentItem + 1
            } else {
                // selesai onboarding -> ganti ke activity utama (LoginActivity / MainActivity)
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }
        }

        skipBtn.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}