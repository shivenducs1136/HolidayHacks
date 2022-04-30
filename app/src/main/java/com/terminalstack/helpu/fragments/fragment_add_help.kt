package com.terminalstack.helpu.fragments

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.terminalstack.helpu.Helpdesk_Model
import com.terminalstack.helpu.R
import com.terminalstack.helpu.databinding.FragmentAddHelpBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [fragment_add_help.newInstance] factory method to
 * create an instance of this fragment.
 */
class fragment_add_help : Fragment() {
    private lateinit var binding:FragmentAddHelpBinding

    lateinit var grievanceTitle:EditText
    lateinit var grievanceDesc:EditText
    lateinit var pushGrievance:Button

    lateinit var helpDbref:DatabaseReference


    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddHelpBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        grievanceTitle=view.findViewById(R.id.grievanceTitle)
        grievanceDesc=view.findViewById(R.id.grievanceDescription)
        pushGrievance=view.findViewById(R.id.sendHelp)

        pushGrievance.setOnClickListener {

            insertGrievance()

        }

        helpDbref=FirebaseDatabase.getInstance().reference.child("Help")


    }

    private fun insertGrievance() {
       var Title:String=grievanceTitle.text.toString()
        var Description=grievanceDesc.text.toString()

        var model:Helpdesk_Model= Helpdesk_Model(Title,Description)
        if(TextUtils.isEmpty(Title) || TextUtils.isEmpty(Description))
        {
            Toast.makeText(context, "Please Enter all the necessary details", Toast.LENGTH_SHORT).show()
            return
        }

        else{
            helpDbref.push().setValue(model)
            grievanceTitle.setText("")
            grievanceDesc.setText("")
            Toast.makeText(context, "Thanks for Registering in our HelpDesk portal....A Volunteer will contact you as soon as possible", Toast.LENGTH_SHORT).show()
        }
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment fragment_add_help.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            fragment_add_help().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}