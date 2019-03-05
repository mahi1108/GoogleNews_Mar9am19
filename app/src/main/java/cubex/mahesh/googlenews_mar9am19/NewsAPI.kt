package cubex.mahesh.googlenews_mar9am19

import retrofit2.Call
import retrofit2.http.GET

interface NewsAPI {

    @GET("v2/top-headlines?sources=techcrunch&apiKey=82773fb0809146908a57291680edf7ec")
    fun  getNews( ):Call<Articles>
}