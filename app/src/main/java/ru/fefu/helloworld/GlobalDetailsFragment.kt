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
import org.w3c.dom.Text
import java.text.SimpleDateFormat
import java.util.*


class GlobalDetailsFragment : Fragment() {
    private lateinit var viewModel: ViewModelActivity

    companion object {
        private const val ARG_ACTIVITY_ID = "activity_id"

        fun newInstance(activityId: Int) = GlobalDetailsFragment().apply {
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

        val database = ApplicationDB.getDatabase(requireContext())
        val repository = Repository(database.DaoDatabase())
        viewModel = ViewModelProvider(this, ViewModelActivity.Factory(repository))
            .get(ViewModelActivity::class.java)

        return layoutView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val activityId = arguments?.getInt(ru.fefu.helloworld.GlobalDetailsFragment.Companion.ARG_ACTIVITY_ID) ?: -1
        if (activityId == -1) return

        lifecycleScope.launch {
            val activity = viewModel.getActionById(activityId)
            activity?.let { updateUI(view, activity) }
        }
    }

    private fun updateUI(view: View, activity: EntityActivity) {
        val dateSFormat = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())

        val duration = (activity.endTime.time - activity.startTime.time) / 60000
        val hours = duration / 60
        val minutes = duration % 60

        view.findViewById<TextView>(R.id.typeText).text = when (activity.spType) {
            EntityActivity.ActType.BIKING -> "Велосипед"
            EntityActivity.ActType.RUNNING -> "Бег"
            EntityActivity.ActType.WALKING -> "Шаг"
        }

        view.findViewById<TextView>(R.id.distanceText).text = String.format("%.3f км.",activity.distance)
        view.findViewById<TextView>(R.id.lastTimeText).text = dateSFormat.format(activity.startTime)
        view.findViewById<TextView>(R.id.durationText).text =
            if (hours > 0) {
                "$hours ч. ${minutes} мин."
            } else {
                "$minutes мин."
            }
    }

}