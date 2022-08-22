package eu.adamgiergun.lsi.users.userslist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import eu.adamgiergun.lsi.databinding.FragmentUsersListBinding

class UsersListFragment : Fragment() {

    private val usersListViewModel: UsersListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentUsersListBinding.inflate(inflater).let { binding ->
        val usersAdapter = UsersAdapter(
            UserListItemListener { user ->
                findNavController().navigate(
                    UsersListFragmentDirections
                        .actionUsersListFragmentToUserDetailsFragment(user)
                )
            }
        )

        binding.usersRecycler.adapter = usersAdapter

        usersListViewModel.usersList.observe(viewLifecycleOwner) { usersList ->
            if (!usersList.isNullOrEmpty())
                usersAdapter.submitList(usersList)
        }

        binding.root
    }
}