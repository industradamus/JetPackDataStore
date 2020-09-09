package com.example.jetpackdatasource

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.user_item.view.*

/**
 * @author s.buvaka
 */
class UserAdapter : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    var items: List<User> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(user: User) {
            with(itemView) {
                nameText.text = user.name
                lastNameText.text = user.lastName
                ageText.text = user.age.toString()
                root.setCardBackgroundColor(if (user.isActive) Color.GREEN else Color.RED)
            }
        }
    }
}
