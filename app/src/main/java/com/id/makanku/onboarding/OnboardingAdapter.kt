package com.id.makanku.onboarding

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.id.makanku.onboarding.fragments.*

class OnboardingAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    private val fragments = listOf(
        Onboard1Fragment(),
        Onboard2Fragment(),
        Onboard3Fragment(),
        Onboard4Fragment()

    )

    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment = fragments[position]
}
