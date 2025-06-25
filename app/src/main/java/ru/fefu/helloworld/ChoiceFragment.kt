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
            parentFragmentManager.beginTransaction()
        }
    }
}