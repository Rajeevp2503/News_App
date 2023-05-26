package com.example.news_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.AdapterListUpdateCallback
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.news_app.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback


class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

   //  val songs : List<String> = listOf("hello", "abcde","dance", "chil","jinda haina na", "chalegi android development/","hello", "abcde","dance", "chil","jinda haina na", "chalegi android development/","hello", "abcde","dance", "chil","jinda haina na", "chalegi android development/")
        getNews()

        }

    private fun getNews(){
        val news =NewsService.newsInstance.getHeadlines("in",1)
        news.enqueue(object: retrofit2.Callback<News> {
            override fun onFailure(call: Call<News>, t: Throwable) {

        
            }

            override fun onResponse(call: Call<News>, response: Response<News>) {
                val news = response.body()
                if(news!=null){
                    Log.d("cheezycode",news.toString())

                    binding.newsList.adapter = MyAdpater(this@MainActivity,news.articles)
                    binding.newsList.layoutManager = LinearLayoutManager(this@MainActivity)

                }
            }
        })
    }

}