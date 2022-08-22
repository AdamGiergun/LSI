package eu.adamgiergun.lsi.users.userslist

import eu.adamgiergun.lsi.users.data.local.User

class UserListItemListener (val clickListener: (user: User) -> Unit) {
    fun onClick(user: User) = clickListener(user)
}