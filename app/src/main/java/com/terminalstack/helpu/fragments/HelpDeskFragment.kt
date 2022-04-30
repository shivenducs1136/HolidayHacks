package com.terminalstack.helpu.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import com.terminalstack.helpu.GrievanceShowAdapter
import com.terminalstack.helpu.Helpdesk_Model
import com.terminalstack.helpu.R
import com.terminalstack.helpu.databinding.FragmentHelpDeskBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class HelpDeskFragment : Fragment() {

    lateinit var recyclerView:RecyclerView
    lateinit var reference:DatabaseReference
    lateinit var grievanceBtn:ImageView
    private lateinit var binding: FragmentHelpDeskBinding
    lateinit var grievanceShowAdapter: GrievanceShowAdapter
    lateinit var list: ArrayList<Helpdesk_Model>



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHelpDeskBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView=view.findViewById(R.id.HelpDeskRecyclerView)
        reference=FirebaseDatabase.getInstance().getReference("Help")
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(context)

        list= ArrayList()
        grievanceShowAdapter = GrievanceShowAdapter(context, list)
        recyclerView.adapter = grievanceShowAdapter
        reference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (dataSnapshot in snapshot.children) {
                    val helpdesk_model: Helpdesk_Model? = dataSnapshot.getValue(
                        Helpdesk_Model::class.java
                    )
                    list.add(helpdesk_model!!)

                }
                    grievanceShowAdapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {}
        })


        // Inflate the layout for this fragment


        // Inflate the layout for this fragment
    }





}


