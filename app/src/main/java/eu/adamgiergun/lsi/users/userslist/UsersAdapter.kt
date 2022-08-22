package eu.adamgiergun.lsi.users.userslist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import eu.adamgiergun.lsi.databinding.UsersListItemBinding
import eu.adamgiergun.lsi.users.data.local.UserDB

class UsersAdapter(
    private val userListItemListener: UserListItemListener
) : ListAdapter<UserDB, UsersAdapter.ViewHolder>(DiffCallback) {

    class ViewHolder(private val binding: UsersListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(
            userDB: UserDB,
            userListItemListener: UserListItemListener
        ) {
            binding.apply {
                user = userDB
                listener = userListItemListener
                executePendingBindings()
            }
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater
                    .from(parent.context)
                val binding = UsersListItemBinding
                    .inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder.from(parent)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = getItem(position)
        holder.bind(user, userListItemListener)
    }
}

object DiffCallback : DiffUtil.ItemCallback<UserDB>() {

    override fun areItemsTheSame(oldItem: UserDB, newItem: UserDB): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: UserDB, newItem: UserDB): Boolean {
        return oldItem.id == newItem.id
    }
}