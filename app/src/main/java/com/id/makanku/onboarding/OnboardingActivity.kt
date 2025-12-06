package com.id.makanku.onboarding

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.id.makanku.R
import com.id.makanku.LoginRegister.LoginActivity


class OnboardingActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var btnNext: Button
    private lateinit var btnSkip: TextView
    private lateinit var dotsLayout: LinearLayout

    private val totalPages = 4  // splash + 4 onboarding pages
    private var currentPage = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        viewPager = findViewById(R.id.viewPagerOnboard)
        btnNext = findViewById(R.id.btnNext)
        btnSkip = findViewById(R.id.btnSkip)
        dotsLayout = findViewById(R.id.dotsIndicator)

        viewPager.adapter = OnboardingAdapter(this)

        setupIndicators()
        setCurrentIndicator(0)

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                currentPage = position
                setCurrentIndicator(position)

                if (position == totalPages - 1) {
                    btnNext.text = "Mulai"
                    btnSkip.text = ""
                } else {
                    btnNext.text = "Next"
                    btnSkip.text = "Skip"
                }
            }
        })

        btnNext.setOnClickListener {
            if (currentPage < totalPages - 1) {
                viewPager.currentItem = currentPage + 1
            } else {
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }
        }

        btnSkip.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }

//    dots indicator
    private fun setupIndicators() {
        val indicators = Array(totalPages) { TextView(this) }

        val params = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        ).apply { setMargins(8, 0, 8, 0) }

        indicators.forEach {
            it.text = "●"
            it.textSize = 14f
            it.layoutParams = params
            it.setTextColor(ContextCompat.getColor(this, R.color.gray))
            dotsLayout.addView(it)
        }
    }

    private fun setCurrentIndicator(index: Int) {
        val childCount = dotsLayout.childCount
        for (i in 0 until childCount) {
            val textView = dotsLayout.getChildAt(i) as TextView
            textView.setTextColor(
                if (i == index)
                    ContextCompat.getColor(this, R.color.green)
                else
                    ContextCompat.getColor(this, R.color.gray)
            )
        }
    }
}
