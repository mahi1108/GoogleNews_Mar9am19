package cubex.mahesh.googlenews_mar9am19

import com.google.gson.annotations.SerializedName

data class Source(@SerializedName("name")
                  val name: String = "",
                  @SerializedName("id")
                  val id: String = "")