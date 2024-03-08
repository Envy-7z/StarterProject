package com.wisnua.begginingproject.domain.model
import com.google.gson.annotations.Expose
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Parcelize
data class NewsResponse(
    @SerializedName("articles")
    @Expose
    var articles: List<Article> ,
    @SerializedName("status")
    @Expose
    var status: String? = null,
    @SerializedName("totalResults")
    @Expose
    var totalResults: Int? = null
) : Parcelable

@Parcelize
data class Article(
    @SerializedName("author")
    @Expose
    var author: String? = null,
    @SerializedName("content")
    @Expose
    var content: String? = null,
    @SerializedName("description")
    @Expose
    var description: String? = null,
    @SerializedName("publishedAt")
    @Expose
    var publishedAt: String? = null,
    @SerializedName("source")
    @Expose
    var source: Source? = null,
    @SerializedName("title")
    @Expose
    var title: String? = null,
    @SerializedName("url")
    @Expose
    var url: String? = null,
    @SerializedName("urlToImage")
    @Expose
    var urlToImage: String? = null
) : Parcelable

@Parcelize
data class Source(
    @SerializedName("id")
    @Expose
    var id: String? = null,
    @SerializedName("name")
    @Expose
    var name: String? = null
) : Parcelable