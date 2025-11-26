package com.id.makanku.onboarding

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.id.makanku.onboarding.OnboardingAdapter
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator
import android.widget.Button
import android.widget.TextView
import com.id.makanku.MainActivity

class OnboardingActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var nextBtn: Button
    private lateinit var skipBtn: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        viewPager = findViewById(R.id.viewPager)
        nextBtn = findViewById(R.id.btnNext)
        skipBtn = findViewById(R.id.btnSkip)

        val adapter = OnboardingAdapter(this)
        viewPager.adapter = adapter

        val dots = findViewById<WormDotsIndicator>(R.id.dotsIndicator)
        dots.attachTo(viewPager)

        nextBtn.setOnClickListener {
            if (viewPager.currentItem < 2) {
                viewPager.currentItem += 1
            } else {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        }

        skipBtn.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}