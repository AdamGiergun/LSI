package eu.adamgiergun.lsi.users.userdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import eu.adamgiergun.lsi.databinding.FragmentUserDetailsBinding

class UserDetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        FragmentUserDetailsBinding.inflate(inflater).run {
            val args: UserDetailsFragmentArgs by navArgs()
            this.user = args.user
            return root
        }
    }
}