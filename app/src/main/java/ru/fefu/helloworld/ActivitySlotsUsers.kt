package ru.fefu.helloworld

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ActivitySlotsUsers : Fragment() {
    private lateinit var RecView : RecyclerView

    companion object { fun newInstance() = ActivitySlotsUsers() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_users_fr, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        RecView = view.findViewById(R.id.activityRV)
        RecView.layoutManager = LinearLayoutManager(context)

//        val items = listOf(
//            // Упорядоченная информация о проведённой активности, записанной в трекер
//        )
    }
}