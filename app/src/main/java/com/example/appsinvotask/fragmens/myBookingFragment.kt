package com.example.appsinvotask.fragmens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.appsinvotask.R
class myBookingFragment : Fragment() {  

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_booking, container, false)
    }

    companion object {
        fun newInstance(): myBookingFragment {
            return myBookingFragment()
        }
    }

}