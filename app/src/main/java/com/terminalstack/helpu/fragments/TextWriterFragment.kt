package com.terminalstack.helpu.fragments

import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.terminalstack.helpu.databinding.FragmentTextWriterBinding
import java.util.*


class TextWriterFragment : Fragment() {

    lateinit var binding:FragmentTextWriterBinding
    lateinit var textToSpeech: TextToSpeech
    lateinit var text:String
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTextWriterBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.speakbtn.setOnClickListener {
            textToSpeech = TextToSpeech(requireContext(),TextToSpeech.OnInitListener {
                if(it== TextToSpeech.SUCCESS){
                    textToSpeech.language = Locale.US
                    textToSpeech.setSpeechRate(1.0f)
                    textToSpeech.speak(binding.addrEdittext.text.toString(),TextToSpeech.QUEUE_ADD,null)
                }
            })
        }
        binding.deletebtn.setOnClickListener {
            text = binding.addrEdittext.text.toString()
            binding.addrEdittext.text.clear()
        }
        binding.undobtn.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}