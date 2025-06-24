package ru.fefu.helloworld

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class AdapterSports(fragmentActivity: SportsFragment) : FragmentStateAdapter(fragmentActivity) {
    private val frags = mutableListOf<Fragment>()
    private val titles =mutableListOf<String>()

    fun addFrag(fragment: Fragment, title: String) {
        frags.add(fragment)
        titles.add(title)
    }

    fun getTitle(position: Int): String {
        return titles[position]
    }

    override fun createFragment(position: Int): Fragment = frags[position]
    override fun getItemCount(): Int = frags.size
}