package com.nmp.materialdesign

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.nmp.materialdesign.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val fragments: ArrayList<Fragment> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fragments.add(HomeFragment())
        fragments.add(PlaylistFragment())
        fragments.add(ProfileFragment())
        //Log.d("ARRAY", fragments.size.toString())

        binding.bottomNav.setOnItemSelectedListener {
            binding.viewPager.currentItem = when(it.itemId) {
                R.id.itemHome -> 0
                R.id.itemPlaylist -> 1
                R.id.itemProfile -> 2
                else -> 0 // default to home
            }
            true
        }

        binding.viewPager.adapter = MyAdapter(this, fragments)

        binding.viewPager.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                binding.bottomNav.selectedItemId = binding.bottomNav.menu.getItem(position).itemId
                // Or: binding.bottomNav.selectedItemId = binding.bottomNav.menu[position].itemId
            }
        })

    }
}