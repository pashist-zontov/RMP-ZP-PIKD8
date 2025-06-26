package ru.fefu.helloworld

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import java.util.*
import kotlin.io.walk
import kotlin.random.Random
import kotlin.run

class ChoiceFragment : Fragment() {
    private lateinit var adapter: SportsTypeAdapter
    private var selectedSport: String? = null
    private lateinit var viewModel: ViewModelActivity

    companion object {
        fun newInstance(): ChoiceFragment {
            return ChoiceFragment()
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

        val sportsList = listOf(
            SportsTypeAdapter.spItem("Велосипед", R.drawable.bike),
            SportsTypeAdapter.spItem("Бег", R.drawable.run),
            SportsTypeAdapter.spItem("Шаг", R.drawable.walk)
        )

        adapter = SportsTypeAdapter(sportsList).apply {
            noChosenItem = { sport ->
                selectedSport = sport
            }
        }

        val recView = view.findViewById<RecyclerView>(R.id.sportsType)
        recView.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.HORIZONTAL,
            false
        )
        recView.adapter = adapter

        view.findViewById<MaterialButton>(R.id.startButton).setOnClickListener {
            selectedSport?.let { spType ->
                val actType = when (spType) {
                    "Бег" -> EntityActivity.ActType.RUNNING
                    "Шаг" -> EntityActivity.ActType.WALKING
                    "Велосипед" -> EntityActivity.ActType.BIKING
                    else -> EntityActivity.ActType.WALKING
                }

                val startTime = Date()
                // Берётся рандомное время окончания управжнения в диапазоне 30-150 минут
                val endTime = Date(startTime.time + (30 + Random.Default.nextInt(120)) * 60000)
                val distance =
                    Random.nextDouble(1.0, 20.0) // Аналогично для пройденной дистанции в км

                val action = EntityActivity(
                    spType = actType,
                    startTime = startTime,
                    endTime = endTime,
                    distance = distance
                )

                viewModel.insert(action)

                parentFragmentManager.beginTransaction()
                    .replace(
                        R.id.activChooser,
                        BeginFragment.newInstance(
                            spType,
                            distance,
                            startTime.time,
                            endTime.time
                        )
                    )
                    .addToBackStack(null)
                    .commit()
            } ?: Toast.makeText(
                requireContext(),
                "Выберите тип активности",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}