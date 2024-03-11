package com.wisnua.starterproject.presentation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.wisnua.starterproject.R
import com.wisnua.starterproject.databinding.ActivitySliderBinding
import com.wisnua.starterproject.domain.model.SliderData
import com.wisnua.starterproject.presentation.adapter.ViewPagerAdapter

class SliderActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySliderBinding
    private lateinit var sliderAdapter: ViewPagerAdapter
    private lateinit var sliderList:ArrayList<SliderData>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySliderBinding.inflate(layoutInflater)
        setContentView(binding.root)


        sliderList = ArrayList()
        sliderList.add(SliderData(R.drawable.coffe, "Lets meet our summer coffe drinks","title our test pranala"))
        sliderList.add(SliderData(R.drawable.coffe, "Lets meet our summer coffe drinks","title our test pranala"))
        sliderList.add(SliderData(R.drawable.coffe, "Lets meet our summer coffe drinks", "title our test pranala"))

        sliderAdapter = ViewPagerAdapter(this,sliderList)

        binding.viewPager.adapter = sliderAdapter

        binding.viewPager.addOnPageChangeListener(viewListener)

        binding.btnStar.setOnClickListener {
            startActivity(Intent(this@SliderActivity,PrimeActivity::class.java))
        }
    }

    private val viewListener = object : ViewPager.OnPageChangeListener {
        override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

        override fun onPageSelected(position: Int) {
            // Update text view text color based on position
            binding.idTVSlideOne.setTextColor(getColor(R.color.black))
            binding.idTVSlideTwo.setTextColor(getColor(R.color.black))
            binding.idTVSlideThree.setTextColor(getColor(R.color.black))

            when (position) {
                0 -> binding.idTVSlideOne.setTextColor(getColor(R.color.white))
                1 -> binding.idTVSlideTwo.setTextColor(getColor(R.color.white))
                2 -> binding.idTVSlideThree.setTextColor(getColor(R.color.white))
            }
        }

        override fun onPageScrollStateChanged(state: Int) {}
    }

}