package ~/Desktop/GoogleNews_Mar9am19/app

import com.google.gson.annotations.SerializedName

data class Articles(@SerializedName("articles")
                    val articles: List<ArticlesItem>?)