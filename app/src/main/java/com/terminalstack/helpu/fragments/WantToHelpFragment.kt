package com.terminalstack.helpu.fragments

import android.content.Intent
import android.os.Bundle
import android.service.controls.ControlsProviderService.TAG
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.razorpay.Checkout
import com.razorpay.PaymentData
import com.razorpay.PaymentResultWithDataListener
import com.terminalstack.helpu.MainActivity
import com.terminalstack.helpu.R
import com.terminalstack.helpu.databinding.FragmentWantToHelpBinding
import org.json.JSONObject
import java.lang.Exception


class WantToHelpFragment : Fragment() ,PaymentResultWithDataListener {
    private lateinit var binding: FragmentWantToHelpBinding
    lateinit var amountEdit: EditText
    private lateinit var payBtn:Button
    private lateinit var amount:String



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWantToHelpBinding.inflate(layoutInflater)
        return binding.root
        // Inflate the layout for this fragment
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        amountEdit=view.findViewById(R.id.amountEdit)
        payBtn=view.findViewById(R.id.payBtn)

        payBtn.setOnClickListener {
            amount=amountEdit.text.toString().trim()

            if(amount.isEmpty())
                return@setOnClickListener

            startPayment(amount.toInt())
            binding.amountEdit.text?.clear()


        }

    }

    private fun startPayment(toInt: Int) {
        val checkout=Checkout()
        checkout.setKeyID("rzp_test_3AuRUq8vpYjZEG")
        try {
            val options=JSONObject()
            options.put("name","HelpU CrowdFunding")
            options.put("description","Financially Helping the Unprivileged")
            options.put("image","https://cdn.razorpay.com/logos/J4aMpjoJsqnhRg_medium.png")

            options.put("theme.color","#eebaec")
            options.put("currency","INR")

            options.put("amount","${(amount.toInt()*100)}")

            options.put("prefill.email","terminalstack@gmail.com")
            options.put("prefill.contact","+918171301100")
            checkout.open(requireActivity(),options)


        }
        catch (e:Exception){
            Toast.makeText(context,"Error in Payment"+e.message,Toast.LENGTH_SHORT).show()
            e.printStackTrace()
        }


    }

    override fun onPaymentSuccess(p0: String?, p1: PaymentData?) {
        Toast.makeText(context, "Payment Success$p0", Toast.LENGTH_SHORT).show()
        var intent=Intent(context,HomeFragment::class.java)
        startActivity(intent)
    }

    override fun onPaymentError(p0: Int, p1: String?, p2: PaymentData?) {
       Log.d(TAG,"onPaymentError: $p0")
       Log.d(TAG,"onPaymentError: $p1")

        Toast.makeText(context, "Payment not successful$p0 $p1", Toast.LENGTH_SHORT).show()
        requireActivity().finish()

    }


}