package com.openclassrooms.magicgithub.ui.user_list

import android.graphics.Canvas
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.openclassrooms.magicgithub.R
import com.openclassrooms.magicgithub.model.User
import com.openclassrooms.magicgithub.utils.UserDiffCallback
import java.util.Collections

class UserListAdapter(  // FOR CALLBACK ---
    callback1: List<User>,
    private val callback: Listener
) : RecyclerView.Adapter<ListUserViewHolder>() {
    // FOR DATA ---
    private var users: List<User> = ArrayList()

    fun toggleUserActivation(position: Int) {
        val user = users[position]
        user.isActive = !user.isActive!!
        notifyItemChanged(position)
    }

    fun onItemMove(fromPosition: Int, toPosition: Int) {
        Collections.swap(users, fromPosition, toPosition)
        notifyItemMoved(fromPosition, toPosition)
    }

    interface Listener {
        fun onClickDelete(user: User)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListUserViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.item_list_user, parent, false)
        return ListUserViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListUserViewHolder, position: Int) {
        holder.bind(users[position], callback)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    // PUBLIC API ---
    fun updateList(newList: List<User>) {
        val diffResult = DiffUtil.calculateDiff(UserDiffCallback(newList, users))
        users = newList
        diffResult.dispatchUpdatesTo(this)
    }
}

class SwipeToToggleCallback(private val adapter: UserListAdapter) : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        return false
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        val position = viewHolder.adapterPosition
        adapter.toggleUserActivation(position)
    }

    override fun onChildDraw(
        c: Canvas,
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        dX: Float,
        dY: Float,
        actionState: Int,
        isCurrentlyActive: Boolean
    ) {
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
    }
}