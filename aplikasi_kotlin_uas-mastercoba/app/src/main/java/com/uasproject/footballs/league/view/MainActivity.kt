package com.uasproject.footballs.league.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.uasproject.footballs.Login.dashboard
import com.uasproject.footballs.R
import com.uasproject.footballs.favorite.view.FavoriteFragment
import com.uasproject.footballs.search.view.SearchFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_league.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnLogout.setOnClickListener{
            val sharedPreferences=getSharedPreferences("CEKLOGIN", Context.MODE_PRIVATE)
            val editor=sharedPreferences.edit()

            editor.putString("STATUS","0")
            editor.apply()

            startActivity(Intent(this@MainActivity,dashboard::class.java))
            finish()
        }



        supportActionBar?.elevation = 0f
        supportActionBar?.hide()

        bottom_nav.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.league -> {
                    loadLeagueFragment()
                }
                R.id.favorite -> {
                    loadFavoriteFragment()
                }
                R.id.search -> {
                    loadSearchFragment()
                }
            }
            true
        }
        bottom_nav.selectedItemId = R.id.league
    }

    private fun loadLeagueFragment() {
        supportFragmentManager
            .beginTransaction()
            .replace(
                R.id.container_main,
                LeagueFragment(), LeagueFragment::class.java.simpleName
            )
            .commit()
    }

    private fun loadFavoriteFragment() {
        supportFragmentManager
            .beginTransaction()
            .replace(
                R.id.container_main,
                FavoriteFragment(),
                FavoriteFragment::class.java.simpleName
            )
            .commit()
    }

    private fun loadSearchFragment() {
        supportFragmentManager
            .beginTransaction()
            .replace(
                R.id.container_main,
                SearchFragment(), SearchFragment::class.java.simpleName
            )
            .commit()
    }


}
