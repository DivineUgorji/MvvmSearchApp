package xyz.divineugorji.mvvmsearchapp.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class UnsplashPhoto(
    val id: String,
    val description: String?,
    val urls: UnsplshPhotoUrls,
    val user: UnsplashUser,

    ) : Parcelable {
    @Parcelize
    data class UnsplshPhotoUrls(
        val raw: String,
        val full: String,
        val regular: String,
        val small: String,
        val thumb: String,
    ) : Parcelable {

    }

    @Parcelize
    data class UnsplashUser(
        val name: String,
        val username: String
    ) : Parcelable {
        val attributionUrl get() = "https://unsplash.com/$username?utm_source = ImageSearchApp&utm_medium=referral"
    }

}
