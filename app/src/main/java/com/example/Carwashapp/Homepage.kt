package com.example.Carwashapp

import com.example.Carwashapp.CarSelectionActivity
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.MotionEvent
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatActivity

class Homepage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)

        val imageButton = findViewById<ImageButton>(R.id.navmenu)
        val dropDownMenu = PopupMenu(this, imageButton)
        val menuInflater = dropDownMenu.menuInflater
        menuInflater.inflate(R.menu.menu_main, dropDownMenu.menu)

        dropDownMenu.setOnMenuItemClickListener { item: MenuItem? ->
            when (item?.itemId) {
                R.id.menu_profile -> {
                    // Profil menü öğesi tıklandı
                    true
                }

                R.id.menu_my_cars -> {
                    // Araçlarım menü öğesi tıklandı
                    true
                }

                else -> false
            }
        }

        imageButton.setOnClickListener {
            dropDownMenu.show()
        }

        // Fare tıklamasını da desteklemek için
        imageButton.setOnTouchListener { _, event ->
            when (event.action) {
                MotionEvent.ACTION_UP -> {
                    dropDownMenu.show()
                    true
                }

                else -> false
            }
        }

        val anasyf1 = findViewById<LinearLayout>(R.id.anasyf1)
        anasyf1.setOnClickListener {
            val intent = Intent(this, com.example.Carwashapp.CarSelectionActivity::class.java)
            startActivity(intent)
        }


        val anasyf2 = findViewById<LinearLayout>(R.id.anasyf2)
        anasyf2.setOnClickListener {
            val intent = Intent(this, com.example.Carwashapp.CarSelectionActivity::class.java)
            startActivity(intent)
        }


        val anasyf3 = findViewById<LinearLayout>(R.id.anasyf3)
        anasyf3.setOnClickListener {
            val intent = Intent(this, com.example.Carwashapp.CarSelectionActivity::class.java)
            startActivity(intent)
        }

        val anasyf4 = findViewById<LinearLayout>(R.id.anasyf4)
        anasyf4.setOnClickListener {
            val intent = Intent(this, com.example.Carwashapp.CarSelectionActivity::class.java)
            startActivity(intent)
        }


    }
}
