package com.example.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.navigation.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button1.setOnClickListener {
            val name = binding.name.text.toString()
            val surname = binding.surname.text.toString()
            val gpa = binding.gpa.text.toString().toFloat()
            navigateToProfile(name, surname, gpa)
        }

        binding.button1.setOnLongClickListener {
            binding.name.text.clear()
            binding.surname.text.clear()
            binding.gpa.text.clear()
            true
        }

        binding.button2.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToListFragment()
            findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun navigateToProfile(name: String, surname: String, gpa: Float) {
        val action = HomeFragmentDirections.actionHomeFragmentToProfileFragment(name, surname, gpa)
        findNavController().navigate(action)
    }
}
