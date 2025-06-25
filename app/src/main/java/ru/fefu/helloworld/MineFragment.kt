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
    private lateinit var activRec: RecyclerView

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

        activRec = view.findViewById(R.id.activityRV)
        activRec.layoutManager = LinearLayoutManager(context)

        val items = listOf(
            ActItem.Header("Сегодня"),
            ActItem.Act(1, "Бег", "5.2 км", "30 минут", "2 часа назад"),
            ActItem.Act(2, "Велоспорт", "15.7 км", "45 минут", "1 час назад"),
            ActItem.Header("Вчера"),
            ActItem.Act(3, "Плавание", "1.2 км", "25 минут", "Вчера в 18:30")
        )

        activRec.adapter = AdapterMine(items)
    }


}