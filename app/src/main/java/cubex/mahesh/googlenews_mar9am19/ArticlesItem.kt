package cubex.mahesh.googlenews_mar9am19

import com.google.gson.annotations.SerializedName

data class ArticlesItem(@SerializedName("urlToImage")
                        val urlToImage: String = "",
                        @SerializedName("description")
                        val description: String = "",
                        @SerializedName("title")
                        val title: String = "",
                        @SerializedName("url")
                        val url: String = "")