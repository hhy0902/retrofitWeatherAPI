package org.techtown.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import org.techtown.retrofit.data.Item
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val url = "https://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty?serviceKey=JCrJa4%2F4eF07FKbnkSi7BDDUvnJXCE1CTiyt%2FfnxJ%2B7jewHaXTp5hrKQzOKdWYctQB%2B3a%2FHLuUHkTPq4hqrxvA%3D%3D&returnType=json&numOfRows=10&pageNo=1&sidoName=%EC%84%9C%EC%9A%B8&ver=1.0"
        val url2 = "https://api.openweathermap.org/data/2.5/weather?lat=37.4942&lon=127.0633&appid=3bbea22f826e4eef49dc445bd1114a75"
        val url3 = "http://api.openweathermap.org/data/2.5/air_pollution?lat=37.4942&lon=127.0633&appid=3bbea22f826e4eef49dc445bd1114a75"

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val retrofitService = retrofit.create(RetrofitService::class.java)

        retrofitService.getAirPollution().enqueue(object : Callback<Pollution> {
            override fun onResponse(call: Call<Pollution>, response: Response<Pollution>) {
                if (response.isSuccessful) {
                    val pollutionList = response.body()

                    Log.d("testt","${response.message()}")

                    Log.d("testt pollution","${pollutionList?.coord}")

                    pollutionList?.list?.forEach {
                    Log.d("testt pm10", "${it.components?.pm10}")

                    }
                }
            }

            override fun onFailure(call: Call<Pollution>, t: Throwable) {
                Log.d("testt","${t.message}")
            }

        })


//        retrofitService.getWeather().enqueue(object : Callback<Weather> {
//            override fun onResponse(call: Call<Weather>, response: Response<Weather>) {
//                if(response.isSuccessful) {
//                    val weather= response.body()
//
//                    Log.d("testt clouds", "${weather?.clouds?.all}")
//                    Log.d("testt name", "${weather?.name}")
//                }
//            }
//
//            override fun onFailure(call: Call<Weather>, t: Throwable) {
//                Log.d("testt","${t.message}")
//            }
//
//        })



//        retrofitService.getItem().enqueue(object : Callback<Item> {
//            override fun onResponse(call: Call<Item>, response: Response<Item>) {
//                if (response.isSuccessful) {
//                    val itemList = response.body()
//
//                    Log.d("testt","${itemList!!.pm10Value}")
//
//                }
//            }
//
//            override fun onFailure(call: Call<Item>, t: Throwable) {
//                Log.d("testt","${t.message}")
//            }
//
//        })

    }
}






































