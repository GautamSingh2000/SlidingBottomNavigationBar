package com.example.appsinvotask.fragmens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.appsinvotask.R
import com.example.appsinvotask.adapter.singleTab_adapter
import com.example.appsinvotask.databinding.FragmentHomeBinding
import com.example.appsinvotask.model.single_tab

class HomeFragment : Fragment() {  
    lateinit var binding : FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)

        val list : ArrayList<single_tab> = arrayListOf(
            single_tab(R.drawable.saloon,"Saloon"),
            single_tab(R.drawable.ic_retail,"Retail"),
            single_tab(R.drawable.mall,"Mall"),
            single_tab(R.drawable.vector_smart_object_1_2,"GYM"),
            single_tab(R.drawable.vector_smart_object_copy_3,"Restraunt"),
            single_tab(R.drawable.vector_smart_object_4,"Grocery"),
            single_tab(R.drawable.saloon,"Saloon"),
            single_tab(R.drawable.ic_retail,"Retail"),
            single_tab(R.drawable.mall,"Mall"),
        )

        binding.rv.adapter = singleTab_adapter(this.requireContext(),list)

        return binding.root
    }

    companion object {
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }

}