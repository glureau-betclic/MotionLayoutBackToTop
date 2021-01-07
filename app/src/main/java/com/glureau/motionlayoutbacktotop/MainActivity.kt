package com.glureau.motionlayoutbacktotop

import android.os.Bundle
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.setPadding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

/**
 * Basic activity that feeds a RecyclerView with some dummy data.
 * No magic here, see XML for more details.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rv = findViewById<RecyclerView>(R.id.recycler_view)
        rv.adapter = DummyAdapter().apply { submitList((1..100).toList()) }
    }
}

class DummyViewHolder(itemView: TextView) : RecyclerView.ViewHolder(itemView)

class DummyAdapter : ListAdapter<Int, DummyViewHolder>(DiffCallback) {
    object DiffCallback : DiffUtil.ItemCallback<Int>() {
        override fun areItemsTheSame(oldItem: Int, newItem: Int): Boolean = oldItem == newItem

        override fun areContentsTheSame(oldItem: Int, newItem: Int): Boolean = oldItem == newItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DummyViewHolder {
        return DummyViewHolder(
            TextView(parent.context).also {
                it.setPadding(50)
            }
        )
    }

    override fun onBindViewHolder(holder: DummyViewHolder, position: Int) {
        (holder.itemView as TextView).text = "Item #${position + 1}"
    }
}