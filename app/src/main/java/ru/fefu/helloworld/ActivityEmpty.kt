package ru.fefu.helloworld

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView

class ActivityEmpty: AppCompatActivity() {
    internal lateinit var bottomNavig : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page_empty)

        bottomNavig = findViewById(R.id.bottomNavigation)

        if (savedInstanceState == null) {
            showFragment(SportsFragment.newInstance())
        }

        bottomNavig.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.navigActives -> {
                    showFragment(SportsFragment.newInstance())
                    true
                }

                R.id.navigProfile -> {
                    showFragment(MineFragment.newInstance())
                    true
                }
                else -> false
            }
        }
    }

    internal fun showFragment(fragment: Fragment) {
        supportFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment).commit()
    }

}