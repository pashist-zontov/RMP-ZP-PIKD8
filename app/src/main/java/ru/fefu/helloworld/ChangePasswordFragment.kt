package ru.fefu.helloworld

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class ChangePasswordFragment : Fragment() {
    companion object {
        fun newInstance() = ChangePasswordFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val layoutView = inflater.inflate(R.layout.change_password_fr, container, false)
        val backBtn = layoutView.findViewById<Button>(R.id.imgBackarr)
        val saveBtn = layoutView.findViewById<Button>(R.id.saveButton)

        backBtn.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        saveBtn.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
        return layoutView
    }
}