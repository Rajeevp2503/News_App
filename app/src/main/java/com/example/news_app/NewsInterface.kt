package com.example.news_app

import android.graphics.pdf.PdfDocument.Page
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query


// https://newsapi.org/v2/top-headlines?country=in&apiKey=cf65c2ad83c04f11980f309b79924273
// https://newsapi.org/v2/top-headlines?country=in&apiKey=cf65c2ad83c04f11980f309b79924273
// https://newsapi.org/v2/top-headlines?country=in&page=1&apiKey=cf65c2ad83c04f11980f309b79924273

const val BASE_URL= "https://newsapi.org/"
const  val API_KEY = "cf65c2ad83c04f11980f309b79924273"

interface NewsInterface {

    @GET("/v2/top-headlines?apikey=$API_KEY")
    fun getHeadlines(@Query("country") country : String, @Query("page") Page:Int) : Call<News>


}

//singleton class in kotlin jsut like

object NewsService{
    val newsInstance :NewsInterface
    init {
        val retrofit  = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        newsInstance = retrofit.create()
    }
}