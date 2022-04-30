package com.terminalstack.helpu.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.terminalstack.helpu.MainActivity
import com.terminalstack.helpu.R
import com.terminalstack.helpu.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private lateinit var binding : FragmentHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.help.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_fragment_add_help)
        }
        binding.bankscard.setOnClickListener{
            findNavController().navigate(R.id.action_homeFragment_to_banksFragment)
        }
        binding.hospitalscard.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_hospitalsFragment)
        }
        binding.restaurantcard.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_restroFragment)
        }
        binding.toiletcard.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_toiletsFragment)
        }
        binding.mallcard.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_mallsFragment)
        }
        binding.library.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_libraryFragment)
        }
        binding.donatecard.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_wantToHelpFragment)
        }
        binding.wheely.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_wheelchairFragment)
        }
        binding.crutchy.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_crutchFragment)
        }
        binding.helpuuu.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_helperFragment)
        }
        binding.goiExplore.setOnClickListener {
//            findNavController().navigate(R)
        }
        binding.textToSpeech.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_textWriterFragment)
        }
        binding.actionsTextToSpeech.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_actionsFragment)
        }
        binding.locatenow.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_fragment_maps)
        }
        binding.menuy.setOnClickListener(View.OnClickListener {
            (activity as MainActivity).openNavDrawer()
        })
        binding.notificationbellllll.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_helpDeskFragment)
        }

        binding.goiExplore.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_ministryOfDisabledWebViewFragment)
        }
    }
}