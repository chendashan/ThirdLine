package com.example.thirdline.part11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.thirdline.databinding.ActivityRetrofitTestBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class RetrofitTestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityRetrofitTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btRequestData.setOnClickListener {
            //使用Retrofit.Builder来构建一个Retrofit对象
            val retrofit = Retrofit.Builder()
                    //指定所有请求的根路径
                .baseUrl("http://10.0.2.2/")
                    //指定解析数据时所使用的转换库
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            //调用create()方法，传入具体Service接口的Class类型，创建一个该接口的动态代理对象
            val appService = retrofit.create(AppService::class.java)
            //调用接口里的方法返回一个Call<T>对象，在调用这个对象的enqueue()方法就会进行网络请求了
            //enqueue()传入Callback接口的实现
            appService.getAppData().enqueue(object : Callback<List<App>> {
                override fun onResponse(call: Call<List<App>>, response: Response<List<App>>) {
                    //调用response.body()方法将会得到解析后的对象
                    val list = response.body()
                    if (list != null) {
                        for (app in list) {
                            Log.d("RetrofitTestActivity", "id: ${app.id}, name: ${app.name}, version: ${app.version}")
                        }
                    }
                }

                override fun onFailure(call: Call<List<App>>, t: Throwable) {
                    t.printStackTrace()
                }

            })

        }
    }

    suspend fun <T> Call<T>.await(): T {
        return suspendCoroutine { continuation ->
            enqueue(object : Callback<T> {
                override fun onResponse(call: Call<T>, response: Response<T>) {
                    val body = response.body()
                    if (body != null)
                        continuation.resume(body)
                }

                override fun onFailure(call: Call<T>, t: Throwable) {
                    continuation.resumeWithException(t)
                }

            })
        }
    }

    suspend fun getAppdata() {
        try {
            val appList = ServiceCreator.create<AppService>().getAppData().await()
        } catch (e: Exception) {
            //对异常处理
        }
    }
}