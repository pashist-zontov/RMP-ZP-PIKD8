package ru.fefu.helloworld

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class GlobalDetailsFragmentUsers : Fragment() {

    companion object {
        private const val ARG_ACTIVITY_ID = "activity_id"

        fun newInstance(activityId: Int) = GlobalDetailsFragmentUsers().apply {
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
        return inflater.inflate(R.layout.sports_fragment_details_u, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val backButton = view.findViewById<Button>(R.id.imgBackarr)
        backButton.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        val activityId = arguments?.getInt(ARG_ACTIVITY_ID) ?: -1
        if (activityId == -1) return

        val activity = UserActivitiesData.activities.find { it.id == activityId }
        activity?.let { updateUI(view, it) }
    }

    private fun updateUI(view: View, activity: ActivityItemUsers.Activity) {
        view.findViewById<TextView>(R.id.typeText).text = activity.type
        view.findViewById<TextView>(R.id.distanceText).text = activity.distance
        view.findViewById<TextView>(R.id.durationText).text = activity.duration
        view.findViewById<TextView>(R.id.nameUser).text = activity.userName
    }
}