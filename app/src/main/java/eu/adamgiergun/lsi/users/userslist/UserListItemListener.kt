package eu.adamgiergun.lsi.users.userslist

import eu.adamgiergun.lsi.users.data.local.UserDB

class UserListItemListener (val clickListener: (userDB: UserDB) -> Unit) {
    fun onClick(userDB: UserDB) = clickListener(userDB)
}