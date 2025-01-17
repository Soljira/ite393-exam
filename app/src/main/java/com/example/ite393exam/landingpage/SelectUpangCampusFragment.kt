package com.example.ite393exam.landingpage

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.example.ite393exam.ProfileActivity
import com.example.ite393exam.R
import com.example.ite393exam.modalities.UrdanetaCampus

/**
 * A simple [Fragment] subclass.
 * Use the [SelectUpangCampusFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SelectUpangCampusFragment : Fragment(R.layout.fragment_select_upang_campus) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view,(savedInstanceState))

        val cardUpangUrdaneta = view.findViewById<CardView>(R.id.cardUpangUrdaneta)
        val cardUpangDagupan = view.findViewById<CardView>(R.id.cardUpangDagupan)

        cardUpangUrdaneta.setOnClickListener {
            startActivity(Intent(requireContext(), ProfileActivity::class.java))
            parentFragmentManager.beginTransaction().remove(this).commit()
            activity?.finish()  // dismisses the current activity (which is SchoolSelection.kt) after pressing this button (yay memory optimization)
        }

        cardUpangDagupan.setOnClickListener {
            Toast.makeText(
                requireContext(),
                "Not yet available!",
                Toast.LENGTH_SHORT)
                .show()
        }
    }
}