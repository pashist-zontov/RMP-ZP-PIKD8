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
        val exitBtn = layoutView.findViewById<Button>(R.id.exitButton)
        val saveBtn = layoutView.findViewById<Button>(R.id.saveButton)
        val changePassBtn = layoutView.findViewById<TextView>(R.id.passButton)

        saveBtn.setOnClickListener {
            (requireActivity() as ActivityPageEmpty).apply {
                bottomNavMenu.selectedItemId = R.id.navigActives
                showFragment(SportsFragment.newInstance())
            }
        }

        exitBtn.setOnClickListener {
            val intent = Intent(requireActivity(), ActivityPageMain::class.java)

            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

            startActivity(intent)
            requireActivity().finish()
        }

        changePassBtn.setOnClickListener {
            ChangePass()
        }
        return layoutView
    }

    private fun ChangePass() {
        requireActivity().supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainer, ChangePasswordFragment.newInstance())
            addToBackStack("profile_to_changepass")
            commit()
        }
    }
}
