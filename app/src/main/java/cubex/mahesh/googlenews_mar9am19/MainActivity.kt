package cubex.mahesh.googlenews_mar9am19

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.indiview.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var r = Retrofit.Builder().
            baseUrl("https://newsapi.org/").
            addConverterFactory(GsonConverterFactory.create()).
            build()
        var api:NewsAPI = r.create(NewsAPI::class.java)
        var call:Call<Articles> = api.getNews()
        call.enqueue(object:Callback<Articles>{
            override fun onResponse(call: Call<Articles>,
                                    response: Response<Articles>) {
            var acls:Articles? =     response.body()
            var articles:List<ArticlesItem>? = acls?.articles
            lview.adapter = object:BaseAdapter()
            {
                override fun getCount(): Int = articles!!.size

                override fun getItem(p0: Int): Any = 0

                override fun getItemId(p0: Int): Long = 0

                override fun getView(pos: Int, p1: View?,
                                     p2: ViewGroup?): View {

                    var lInflater = LayoutInflater.from(this@MainActivity)
                    var v:View = lInflater.inflate(R.layout.indiview,null)

                    v.tv1.text = articles?.get(pos)?.title
                    v.tv_desc.text = articles?.get(pos)?.description
                    Glide.with(this@MainActivity).
                        load(articles?.get(pos)?.urlToImage).into(v.iview)

                    return v
                }
            }

            }
            override fun onFailure(call: Call<Articles>, t: Throwable) {
            }
        })

    }
}
