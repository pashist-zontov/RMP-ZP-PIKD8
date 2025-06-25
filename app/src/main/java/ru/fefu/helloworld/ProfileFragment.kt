package ru.fefu.helloworld

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class ProfileFragment : Fragment() {
    companion object {
        fun newInstance() = ProfileFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val layoutView = inflater.inflate(R.layout.profile_fr, container, false)
        val exitButton = layoutView.findViewById<Button>(R.id.exitButton)
        val saveButton = layoutView.findViewById<Button>(R.id.saveButton)
        val passButton = layoutView.findViewById<TextView>(R.id.passButton)

        saveButton.setOnClickListener {
            (requireActivity() as ActivityPageEmpty).apply {
                bottomNavMenu.selectedItemId = R.id.navigActives
                showFragment(SportsFragment.newInstance())
            }
        }

        exitButton.setOnClickListener {
            val intent = Intent(requireActivity(), ActivityPageMain::class.java)

            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

            startActivity(intent)
            requireActivity().finish()
        }
        return layoutView
    }
}
