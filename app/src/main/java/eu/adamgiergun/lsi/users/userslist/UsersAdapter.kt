package eu.adamgiergun.lsi.users.userslist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import eu.adamgiergun.lsi.databinding.UsersListItemBinding
import eu.adamgiergun.lsi.users.data.local.User

class UsersAdapter(
    private val userListItemListener: UserListItemListener
) : ListAdapter<User, UsersAdapter.ViewHolder>(DiffCallback) {

    class ViewHolder(private val binding: UsersListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(
            user: User,
            userListItemListener: UserListItemListener
        ) {
            binding.apply {
                this.user = user
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

object DiffCallback : DiffUtil.ItemCallback<User>() {

    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem.id == newItem.id
    }
}