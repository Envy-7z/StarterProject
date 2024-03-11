package com.wisnua.starterproject.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.wisnua.starterproject.databinding.ContentPagerBinding
import com.wisnua.starterproject.domain.model.SliderData

class ViewPagerAdapter(val context : Context, val sliderList : ArrayList<SliderData>
) : PagerAdapter() {
    override fun getCount(): Int {
        return sliderList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val layoutInflater: LayoutInflater = LayoutInflater.from(context)
        val binding: ContentPagerBinding = ContentPagerBinding.inflate(layoutInflater, container, false)

        val sliderData: SliderData = sliderList[position]
        binding.tvTitle.text = sliderData.title
        binding.tvSubTitle.text = sliderData.subTitle
        binding.ivLogo.setImageResource(sliderData.logo)

        container.addView(binding.root)
        return binding.root
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }


}
