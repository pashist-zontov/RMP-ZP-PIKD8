package ru.fefu.helloworld

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton
import java.util.concurrent.TimeUnit

class BeginFragment : Fragment() {
    companion object {
        private const val ARG_SPORT_TYPE = "sport_type"
        private const val ARG_DISTANCE = "distance"
        private const val ARG_START_TIME = "start_time"
        private const val ARG_END_TIME = "end_time"

        fun newInstance(
            sportType: String,
            distance: Double,
            startTime: Long,
            endTime: Long
        ) = BeginFragment().apply {
            arguments = Bundle().apply {
                putString(ARG_SPORT_TYPE, sportType)
                putDouble(ARG_DISTANCE, distance)
                putLong(ARG_START_TIME, startTime)
                putLong(ARG_END_TIME, endTime)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.act_choice_fr, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sportType = arguments?.getString(ARG_SPORT_TYPE) ?: ""
        val distance = arguments?.getDouble(ARG_DISTANCE) ?: 0.0
        val startTime = arguments?.getLong(ARG_START_TIME) ?: 0L
        val endTime = arguments?.getLong(ARG_END_TIME) ?: 0L

        val duration = ConvertDuration(endTime - startTime)
        val formattedDistance = String.format("%.1f км", distance)

        view.findViewById<TextView>(R.id.typeText).text = sportType
        view.findViewById<TextView>(R.id.distanceText).text = formattedDistance
        view.findViewById<TextView>(R.id.timeText).text = duration

        view.findViewById<MaterialButton>(R.id.finishButton).setOnClickListener {
            val intent = Intent(requireActivity(), ActivityPageEmpty::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            }
            startActivity(intent)
            requireActivity().finish()
        }
    }

    private fun ConvertDuration(durationMs: Long): String {
        val milsTime = TimeUnit.MILLISECONDS
        return String.format("%02d:%02d:%02d", milsTime.toHours(durationMs), milsTime.toMinutes(durationMs) % 60, milsTime.toSeconds((durationMs) % 60))
    }
}