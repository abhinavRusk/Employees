package com.example.employees

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import retrofit2.Retrofit
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create


class MainActivity : AppCompatActivity() {

    private lateinit var newRecyclerView: RecyclerView



    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("create","activity created")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        newRecyclerView = findViewById(R.id.RecyclerView)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)
        val retrofitBuilder = Retrofit.Builder().baseUrl("https://reqres.in/api/").addConverterFactory(GsonConverterFactory.create()).build()
            .create(Api::class.java)
        val RetroData = retrofitBuilder.GetData()

        RetroData.enqueue(object :Callback<Contacts>
        {
            override fun onResponse(
                call: Call<Contacts>,
                response: Response<Contacts>
            ) {
                Toast.makeText(this@MainActivity,"successful",Toast.LENGTH_LONG).show()
                val contacts: Contacts? = response.body()

                val adapter = RecyclerAdapter(response.body()!!.contacts,this@MainActivity)
                newRecyclerView.adapter=adapter

            }

            override fun onFailure(call: Call<Contacts>, t: Throwable) {
               Toast.makeText(this@MainActivity,"Failed: "+t.message.toString(),Toast.LENGTH_LONG).show()

            }


        })
  Log.d("by","by")
//        RetroData.enqueue(object :Callback<ContactsItem>
//    {
//        override fun onResponse(
//            call: Call<ContactsItem>,
//            response: Response<ContactsItem>
//        ) {
//            Toast.makeText(this@MainActivity,"successful",Toast.LENGTH_LONG).show()
//            val textView: TextView = findViewById(R.id.textView)
//            textView.text= response.body()?.first_name ?: "abhi"
//        }
//
//        override fun onFailure(call: Call<ContactsItem>, t: Throwable) {
//            Toast.makeText(this@MainActivity,"Failed: "+t.message.toString(),Toast.LENGTH_LONG).show()
//            val textview: TextView = findViewById(R.id.textView)
//            textview.text = t.message.toString()
//        }
//
//
//    })



    }
//
//    private fun GetData()
//    {
//
//
//
//            val retrofitBuilder = Retrofit.Builder().baseUrl("https://dummy.restapiexample.com/").addConverterFactory(GsonConverterFactory.create()).build()
//                .create(Api::class.java)
//            val RetroData = retrofitBuilder.GetData()
//            RetroData.enqueue(object :Callback<List<Details>>
//            {
//                override fun onResponse(
//                    call: Call<List<Details>>,
//                    response: Response<List<Details>>
//                ) {
//                    data = response.body()!!
//
//                }
//
//                override fun onFailure(call: Call<List<Details>>, t: Throwable) {
//
//                }
//            })
//
//    }
}
