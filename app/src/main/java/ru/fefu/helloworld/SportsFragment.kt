package ru.fefu.helloworld

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator

class SportsFragment : Fragment() {
    private lateinit var viewPager: ViewPager2

    companion object {
        fun newInstance() = SportsFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
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
        setupViewPager()

        // Убираем стандартный TabLayout, так как будем использовать меню
        view.findViewById<View>(R.id.TabLayout).visibility = View.GONE
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.activity_empty_comps, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.navigActives -> {
                viewPager.currentItem = 0
                return true
            }
            R.id.navigProfile -> {
                viewPager.currentItem = 1
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setupViewPager() {
        val adapter = AdapterSports(this)
        adapter.addFrag(MineFragment.newInstance(), "Мои")
        adapter.addFrag(UsersFragment.newInstance(), "Пользователей")

        viewPager.adapter = adapter

        // Обновляем заголовок ActionBar при переключении вкладок
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                (activity as? AppCompatActivity)?.supportActionBar?.title = adapter.getTitle(position)
            }
        })
    }
}