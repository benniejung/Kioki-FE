package com.umc6th.kioki.tutorial.tutorial

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.umc6th.kioki.R
import com.umc6th.kioki.databinding.ActivityTakeInOrOutTutorialBinding
import com.umc6th.kioki.utils.TextPrefs

class TakeInOrOutTutorialActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTakeInOrOutTutorialBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_take_in_or_out_tutorial)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.tutorialCloseButton.setOnClickListener {
            finish()
        }
        if (TextPrefs(this).getTextSize()) {
            binding.apply {
                text1.textSize = 20f
            }
        }
    }
}