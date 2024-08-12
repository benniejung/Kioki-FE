package com.umc6th.kioki

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ExpandableListAdapter
import android.widget.ExpandableListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.umc6th.kioki.databinding.ActivityMainBinding


import java.util.zip.Inflater


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // 레이아웃 설정
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //setStartFragment()
        setStartActivity()
        setExpandableList() // drawerMenu 생성

    }
    // 처음 시작하는 프래그먼트 설정하는 함수
//    private fun setStartFragment() {
//        val homeFragment = HomeFragment() // 홈 프래그먼트 생성
//        supportFragmentManager.beginTransaction()
//            .replace(R.id.frame_layout, homeFragment)
//            .commit()
//    }
    private fun setStartActivity() {
        // ViewPager2에 어댑터 설정
        binding.mainUsersVp.adapter = PagerFragmentStateAdapter(this)

        // indicator3를 viewPager2에 연결
        binding.homeUsersIndicator.setViewPager(binding.mainUsersVp)

        // '자세히 보기' 누르면 HomeGroupfragment로 넘어가도록 설정
        binding.mainMoreBtn.setOnClickListener {
            val intent = Intent(this, GroupHomeActivity::class.java)
            startActivity(intent)
            Log.d("클릭", "자세히 보기 클릭")

        }



    }
    private fun setExpandableList() {
        val parentList = mutableListOf("공지사항", "계정관리", "문의하기", "고객센터") // 부모 리스트
        val childList = mutableListOf(
            mutableListOf(),
            mutableListOf("계정 편집", "알림 설정", "계정 탈퇴"),
            mutableListOf(),
            mutableListOf()
        )
        val expandableAdapter = MainExpandableListAdapter(this, parentList, childList)
        findViewById<ExpandableListView>(R.id.main_menu_el).setAdapter(expandableAdapter)

        findViewById<ExpandableListView>(R.id.main_menu_el).setOnGroupClickListener { parent, v, groupPosition, id ->
            /* todo : parent 클릭 이벤트 설정 */
            false
        }
        findViewById<ExpandableListView>(R.id.main_menu_el).setOnChildClickListener { parent, v, groupPosition, childPosition, id ->
            /* todo : child 클릭 이벤트 설정 */
            false
        }
    }

}