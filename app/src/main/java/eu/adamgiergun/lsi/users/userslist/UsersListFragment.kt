package eu.adamgiergun.lsi.users.userslist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import eu.adamgiergun.lsi.databinding.FragmentUsersListBinding

class UsersListFragment : Fragment() {

    private val usersListViewModel: UsersListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        FragmentUsersListBinding.inflate(inflater).run {
            viewModel = usersListViewModel
            return root
        }
    }
}