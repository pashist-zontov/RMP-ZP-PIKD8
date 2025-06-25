package ru.fefu.helloworld

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class FragmentSportsDetails : Fragment() {

    companion object {
        private const val ARG_ACTIVITY_ID = "activity_id"

        fun newInstance(activityId: Int) = FragmentSportsDetails().apply {
            arguments = Bundle().apply {
                putInt(ARG_ACTIVITY_ID, activityId)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val layoutView = inflater.inflate(R.layout.sports_fragment_details, container, false)
        val backButton = layoutView.findViewById<Button>(R.id.imgBackarr)

        backButton.setOnClickListener {
            parentFragmentManager.popBackStack()
        }


        return layoutView
    }

}