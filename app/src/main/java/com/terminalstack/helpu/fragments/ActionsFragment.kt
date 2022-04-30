package com.terminalstack.helpu.fragments

import android.os.Bundle
import android.speech.tts.TextToSpeech
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.terminalstack.helpu.R
import com.terminalstack.helpu.databinding.FragmentActionsBinding
import java.util.*

class ActionsFragment : Fragment() {
    lateinit var binding:FragmentActionsBinding
    lateinit var textToSpeech: TextToSpeech

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentActionsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.c1.setOnClickListener {
            textToSpeech = TextToSpeech(requireContext(), TextToSpeech.OnInitListener {
                if(it== TextToSpeech.SUCCESS){
                    textToSpeech.language = Locale.US
                    textToSpeech.setSpeechRate(1.0f)
                    textToSpeech.speak("I need Water",
                        TextToSpeech.QUEUE_ADD,null)
                }
            })
        }
        binding.c2.setOnClickListener {
            textToSpeech = TextToSpeech(requireContext(), TextToSpeech.OnInitListener {
                if(it== TextToSpeech.SUCCESS){
                    textToSpeech.language = Locale.US
                    textToSpeech.setSpeechRate(1.0f)
                    textToSpeech.speak("I need Food",
                        TextToSpeech.QUEUE_ADD,null)
                }
            })
        }
        binding.c3.setOnClickListener {
            textToSpeech = TextToSpeech(requireContext(), TextToSpeech.OnInitListener {
                if(it== TextToSpeech.SUCCESS){
                    textToSpeech.language = Locale.US
                    textToSpeech.setSpeechRate(1.0f)
                    textToSpeech.speak("Go Outside",
                        TextToSpeech.QUEUE_ADD,null)
                }
            })
        }
        binding.c4.setOnClickListener {
            textToSpeech = TextToSpeech(requireContext(), TextToSpeech.OnInitListener {
                if(it== TextToSpeech.SUCCESS){
                    textToSpeech.language = Locale.US
                    textToSpeech.setSpeechRate(1.0f)
                    textToSpeech.speak("I Like That",
                        TextToSpeech.QUEUE_ADD,null)
                }
            })
        }
        binding.c5.setOnClickListener {
            textToSpeech = TextToSpeech(requireContext(), TextToSpeech.OnInitListener {
                if(it== TextToSpeech.SUCCESS){
                    textToSpeech.language = Locale.US
                    textToSpeech.setSpeechRate(1.0f)
                    textToSpeech.speak("I want that",
                        TextToSpeech.QUEUE_ADD,null)
                }
            })
        }
        binding.c6.setOnClickListener {
            textToSpeech = TextToSpeech(requireContext(), TextToSpeech.OnInitListener {
                if(it== TextToSpeech.SUCCESS){
                    textToSpeech.language = Locale.US
                    textToSpeech.setSpeechRate(1.0f)
                    textToSpeech.speak("Wonderful! ",
                        TextToSpeech.QUEUE_ADD,null)
                }
            })
        }
        binding.c7.setOnClickListener {
            textToSpeech = TextToSpeech(requireContext(), TextToSpeech.OnInitListener {
                if(it== TextToSpeech.SUCCESS){
                    textToSpeech.language = Locale.US
                    textToSpeech.setSpeechRate(1.0f)
                    textToSpeech.speak("Please Help",
                        TextToSpeech.QUEUE_ADD,null)
                }
            })
        }
        binding.c8.setOnClickListener {
            textToSpeech = TextToSpeech(requireContext(), TextToSpeech.OnInitListener {
                if(it== TextToSpeech.SUCCESS){
                    textToSpeech.language = Locale.US
                    textToSpeech.setSpeechRate(1.0f)
                    textToSpeech.speak("Please Go",
                        TextToSpeech.QUEUE_ADD,null)
                }
            })
        }
        binding.c9.setOnClickListener {
            textToSpeech = TextToSpeech(requireContext(), TextToSpeech.OnInitListener {
                if(it== TextToSpeech.SUCCESS){
                    textToSpeech.language = Locale.US
                    textToSpeech.setSpeechRate(1.0f)
                    textToSpeech.speak("Wanna Sleep ",
                        TextToSpeech.QUEUE_ADD,null)
                }
            })
        }
        binding.c10.setOnClickListener {
            textToSpeech = TextToSpeech(requireContext(), TextToSpeech.OnInitListener {
                if(it== TextToSpeech.SUCCESS){
                    textToSpeech.language = Locale.US
                    textToSpeech.setSpeechRate(1.0f)
                    textToSpeech.speak("Don't Disturb",
                        TextToSpeech.QUEUE_ADD,null)
                }
            })
        }
        binding.c11.setOnClickListener {
            textToSpeech = TextToSpeech(requireContext(), TextToSpeech.OnInitListener {
                if(it== TextToSpeech.SUCCESS){
                    textToSpeech.language = Locale.US
                    textToSpeech.setSpeechRate(1.0f)
                    textToSpeech.speak("I am Hungry",
                        TextToSpeech.QUEUE_ADD,null)
                }
            })
        }
        binding.c12.setOnClickListener {
            textToSpeech = TextToSpeech(requireContext(), TextToSpeech.OnInitListener {
                if(it== TextToSpeech.SUCCESS){
                    textToSpeech.language = Locale.US
                    textToSpeech.setSpeechRate(1.0f)
                    textToSpeech.speak("Hello !",
                        TextToSpeech.QUEUE_ADD,null)
                }
            })
        }
    }
}