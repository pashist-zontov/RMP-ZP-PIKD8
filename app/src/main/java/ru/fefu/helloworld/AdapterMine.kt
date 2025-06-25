package ru.fefu.helloworld

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterMine(private val items: List<ActItem>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val TYPE_HEADER = 0
        private const val TYPE_ACTIVITY = 1
    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is ActItem.Header -> TYPE_HEADER
            is ActItem.Act -> TYPE_ACTIVITY
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_HEADER -> HeaderViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.header_item, parent, false)
            )
            else -> ActivityViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.activity_object_mine, parent, false)
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val item = items[position]) {
            is ActItem.Header -> (holder as HeaderViewHolder).bind(item)
            is ActItem.Act -> (holder as ActivityViewHolder).bind(item)
        }
    }

    override fun getItemCount(): Int = items.size

    inner class HeaderViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val dateText: TextView = view.findViewById(R.id.someDay)

        fun bind(header: ActItem.Header) {
            dateText.text = header.date
        }
    }

    inner class ActivityViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val typeText: TextView = view.findViewById(R.id.typeText)
        private val distanceText: TextView = view.findViewById(R.id.distanceText)
        private val durationText: TextView = view.findViewById(R.id.durationText)
        private val lastTimeText: TextView = view.findViewById(R.id.lastTimeText)

        fun bind(activity: ActItem.Act) {
            typeText.text = activity.type
            distanceText.text = activity.distance
            durationText.text = activity.duration
            lastTimeText.text = activity.lastTime
        }
    }
}