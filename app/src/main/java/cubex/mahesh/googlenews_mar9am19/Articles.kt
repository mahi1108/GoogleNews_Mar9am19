package cubex.mahesh.googlenews_mar9am19

import com.google.gson.annotations.SerializedName

data class Articles(@SerializedName("articles")
                    val articles: List<ArticlesItem>?)