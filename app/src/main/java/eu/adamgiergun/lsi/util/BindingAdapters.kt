package eu.adamgiergun.lsi.util

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import eu.adamgiergun.lsi.R

@BindingAdapter("avatar_url")
fun ImageView.bindAvatar(avatarUrl: String?) {
    if (avatarUrl.isNullOrBlank()) {
        Glide.with(context).clear(this)
        setImageResource(R.drawable.ic_broken_image)
    } else {
        val avatarUri = avatarUrl.toUri().buildUpon().scheme("https").build()
        Glide.with(context)
            .load(avatarUri)
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.loading_animation)
                    .error(R.drawable.ic_broken_image)
            )
            .into(this)
    }
}