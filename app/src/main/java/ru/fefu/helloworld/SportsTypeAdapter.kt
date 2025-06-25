package ru.fefu.helloworld

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SportsTypeAdapter (private val spItems: List<spItem>):
    RecyclerView.Adapter<SportsTypeAdapter.viewHolder>() {

    data class spItem(
        val name: String,
        val iconId: Int
    )

    var noChosenItem: ((String) -> Unit)? = null

    private var selectedPos = RecyclerView.NO_POSITION

    inner class viewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val typeName: TextView = itemView.findViewById(R.id.typeText)
        private val spIcon: ImageView = itemView.findViewById(R.id.sportIcon)
        private val rootView: View = itemView.findViewById(R.id.rootView)

        fun conn(item: spItem, position: Int) {
            typeName.text = item.name
            spIcon.setImageResource(item.iconId)
            rootView.isSelected = position == selectedPos

            itemView.setOnClickListener {
                UpdToNewSelection(position)
                noChosenItem?.invoke(item.name)
            }
        }

        private fun UpdToNewSelection(newPos: Int) {
            var prev = selectedPos
            selectedPos = newPos
            notifyItemChanged(prev)
            notifyItemChanged(selectedPos)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_activ_type, parent, false)
        return viewHolder(view)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.conn(spItems[position], position)
    }

    override fun getItemCount(): Int = spItems.size
}