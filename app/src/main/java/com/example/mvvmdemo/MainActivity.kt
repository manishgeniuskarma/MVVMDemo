package com.example.mvvmdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmdemo.api.QuoteService
import com.example.mvvmdemo.api.RetrofitHelper
import com.example.mvvmdemo.models.ResultAdapter
import com.example.mvvmdemo.repository.QuotesRepository
import com.example.mvvmdemo.viewmodel.MainViewModel
import com.example.mvvmdemo.viewmodel.MainViewModelFactory
import retrofit2.create

class MainActivity : AppCompatActivity() {
    lateinit var mainviewmodel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val quoteservice = RetrofitHelper.getInstance().create(QuoteService::class.java)

        val repository = QuotesRepository(quoteservice)

        mainviewmodel = ViewModelProvider(this,MainViewModelFactory(repository)).get(MainViewModel::class.java)

        mainviewmodel.quotes.observe(this, Observer {


            Log.d("manish",it.results.toString())

            val abc: RecyclerView = findViewById(R.id.resultlist)

            abc.adapter = ResultAdapter(this,it.results)
            abc.layoutManager = LinearLayoutManager(this)



        }

        )
    }
}