package ru.fefu.helloworld

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class SportsFragment: Fragment() {
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout

    companion object{
        fun newInstance() = SportsFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_sportsbar_fr, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewPager = view.findViewById(R.id.ViewPager2)
        tabLayout = view.findViewById(R.id.TabLayout)

        val letsBegin = view.findViewById<FloatingActionButton>(R.id.letsBegin)

        setView()

//        letsBegin.setOnClickListener {
//        }
    }

    private fun setView() {
        val adapter = AdapterSports(this)
        adapter.addFrag(MineFragment.newInstance(), "Мои")
        adapter.addFrag(UsersFragment.newInstance(), "Пользователей")

        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = adapter.getTitle(position)
        }.attach()
    }
}