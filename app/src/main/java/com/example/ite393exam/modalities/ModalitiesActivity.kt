package com.example.ite393exam.modalities

import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainer
import com.example.ite393exam.R
import com.example.ite393exam.helpers.BottomNavigationHelper
import com.google.android.material.bottomnavigation.BottomNavigationView

class ModalitiesActivity : AppCompatActivity() {
    lateinit var linearLayout: LinearLayout
    lateinit var bottomNavigationView: BottomNavigationView
    lateinit var flFragmentContainer: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modalities)

        // Bottom Navigation Bar DO NOT TOUCH
        bottomNavigationView = findViewById(R.id.bottomNavigationView)
        BottomNavigationHelper.setupBottomNavigation(this, bottomNavigationView)
        bottomNavigationView.selectedItemId = R.id.nav_modalities

        val btnFlex24 = findViewById<ImageButton>(R.id.btnFlex24)
        val btnFlexRemote = findViewById<ImageButton>(R.id.btnFlexRemote)

        linearLayout = findViewById<LinearLayout>(R.id.linearlayout)
        flFragmentContainer = findViewById(R.id.flFragmentContainer)


        // Fragment Initializations
        val flex24Fragment = Flex24Fragment()
//        val flexRemoteFragment = FlexRemoteFragment()

        btnFlex24.setOnClickListener {
            fragmentBeginTransaction(flex24Fragment)

        }

        btnFlexRemote.setOnClickListener {
            // Handle the click event for btnFlexRemote
        }


    }

    // Wrote this function to make my code more readable
    fun fragmentBeginTransaction(fragment: Fragment) {
        hideOtherComponents()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragmentContainer, fragment)
            addToBackStack(null)
            commit()  // to actually apply changes
        }
    }

    fun hideOtherComponents() {
        linearLayout.visibility = View.GONE
    }
}