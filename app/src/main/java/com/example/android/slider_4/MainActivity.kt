package com.example.android.slider_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    var currentPage:Int=0
    var  NUM_PAGES:Int=5
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewpager.adapter=ViewPagerAdapter(this)
        dots.attachViewPager(viewpager)
        swipeViewPager()
    }
    fun swipeViewPager(){
        val handler = Handler()
        val update=Runnable(){
            if (currentPage == NUM_PAGES){
                currentPage=0
            }
            viewpager.setCurrentItem(currentPage++,true)
        }
        val swipTimer= Timer()
        swipTimer.schedule( object : TimerTask(){
            override fun run() {
                handler.post(update)
            }
        }
            ,500,3000)



    }
}
