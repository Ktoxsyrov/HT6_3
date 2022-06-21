package com.example.ht6_3

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.ht6_3.databinding.FragmentOneBinding
import com.example.ht6_3.FrViewModel
import kotlinx.coroutines.*


class FragmentOne : Fragment() {
    lateinit var binding: FragmentOneBinding
    lateinit var viewModel: FrViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOneBinding.inflate(layoutInflater)
        viewModel =ViewModelProvider(requireActivity()).get(FrViewModel::class.java)

        return binding.root
    }

    var value: Int? = null
    @SuppressLint("SetTextI18n")
    override fun onStart() {
        super.onStart()
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.numbers.collect {
                value = it
                if (value == -1)
                    binding.pi.text = ""
                else
                    binding.pi.text = "${binding.pi.text}$value"
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = FragmentOne()
    }
}