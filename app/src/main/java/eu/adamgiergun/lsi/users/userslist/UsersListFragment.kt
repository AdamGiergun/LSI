package eu.adamgiergun.lsi.users.userslist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import eu.adamgiergun.lsi.databinding.FragmentUsersListBinding

class UsersListFragment : Fragment() {

    private val usersListViewModel: UsersListViewModel by viewModels()

    private var usersAdapter: UsersAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        FragmentUsersListBinding.inflate(inflater).run {

            usersListViewModel.usersList.observe(viewLifecycleOwner) { usersList ->
                usersList?.let {
                    if (usersAdapter == null) {
                        if (usersList.isNotEmpty()) {
                            usersRecycler.adapter = UsersAdapter(
                                usersList,
                                UserListItemListener { user ->
                                    findNavController().navigate(
                                        UsersListFragmentDirections.actionUsersListFragmentToUserDetailsFragment(
                                            user
                                        )
                                    )
                                }
                            )
                        }
                    } else {
                        usersAdapter?.submitList(usersList)
                    }
                }
            }

            return root
        }
    }
}