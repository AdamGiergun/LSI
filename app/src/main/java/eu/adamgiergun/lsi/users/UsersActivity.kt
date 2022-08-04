package eu.adamgiergun.lsi.users

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import eu.adamgiergun.lsi.R
import eu.adamgiergun.lsi.databinding.ActivityUsersBinding
import eu.adamgiergun.lsi.users.data.local.LocalDB

class UsersActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityUsersBinding.inflate(layoutInflater).run {
            setContentView(root)
        }
    }
}