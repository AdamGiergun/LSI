package eu.adamgiergun.lsi.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso
import eu.adamgiergun.lsi.R

@BindingAdapter("avatar_url")
fun ImageView.bindAvatar(avatarUrl: String?) {
    if (avatarUrl.isNullOrBlank()) {
        setImageResource(R.drawable.ic_broken_image)
    } else {
        Picasso
            .get()
            .load(avatarUrl)
            .into(this)
    }
}