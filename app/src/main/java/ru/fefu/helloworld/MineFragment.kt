package ru.fefu.helloworld

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.*

class MineFragment : Fragment() {
    private lateinit var actRec: RecyclerView
    private lateinit var viewModel: ViewModelActivity

    companion object {
        fun newInstance() = MineFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_mine_fr, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val database = ApplicationDB.getDatabase(requireContext())
        val repository = Repository(database.DaoDatabase())
        viewModel = ViewModelProvider(this,
            ViewModelActivity.Factory(repository))[ViewModelActivity::class.java]

        actRec = view.findViewById(R.id.activityRV)
        actRec.layoutManager = LinearLayoutManager(context)

        // Форматирование "Моих" данных об активностях
        viewModel.allActions.observe(viewLifecycleOwner) { actions ->
            val items = mutableListOf<ActivityItem>()
            val dateSFormat = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
            val timeSFormat = SimpleDateFormat("HH:mm", Locale.getDefault())

            val groupedActions = actions.groupBy {
                dateSFormat.format(it.startTime)
            }

            groupedActions.forEach { (date, actionsForDate) ->
                items.add(ActivityItem.Header(date))
                actionsForDate.forEach { action ->
                    val duration = (action.endTime.time - action.startTime.time) / 60000
                    val hours = duration / 60
                    val minutes = duration % 60

                    items.add(ActivityItem.Activity(
                        id = action.id,
                        type = when (action.spType) {
                            EntityActivity.ActType.RUNNING -> "Бег"
                            EntityActivity.ActType.BIKING -> "Велосипед"
                            EntityActivity.ActType.WALKING -> "Шаг"
                        },
                        distance = String.format("%.2f км", action.distance),
                        duration = if (hours > 0) {
                            "$hours ч. ${minutes} мин."
                        } else {
                            "$minutes мин."
                        },
                        timeAgo = timeSFormat.format(action.startTime)
                    ))
                }
            }

            actRec.adapter = MineAdapter(items) { actId ->
                val fragment = GlobalDetailsFragment.newInstance(actId)
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, fragment)
                    .addToBackStack(null)
                    .commit()
            }
        }
    }
}