package ru.fefu.helloworld

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class UsersFragment : Fragment() {
    private lateinit var recView: RecyclerView

    companion object {
        fun newInstance() = UsersFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_users_fr, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recView = view.findViewById(R.id.activityRV)
        recView.layoutManager = LinearLayoutManager(context)

        val items = listOf(
            ActivityItemUsers.Header("Сегодня"),
            UserActivitiesData.activities[0],
            UserActivitiesData.activities[1],
            ActivityItemUsers.Header("22 июня 2022 года"),
            UserActivitiesData.activities[2]
        )

        recView.adapter = UsersAdapter(items) { activityId ->
            val fragment = GlobalDetailsFragmentUsers.newInstance(activityId.toInt())
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .addToBackStack(null)
                .commit()
        }
    }
}