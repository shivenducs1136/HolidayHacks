package com.terminalstack.helpu.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import com.terminalstack.helpu.R


class CrutchFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view : View = inflater.inflate(R.layout.fragment_crutch, container, false)
        // val url :String = arguments?.getString("https://www.irctctourism.com/wheelchair").toString()
        view.findViewById<WebView>(R.id.webview).webViewClient = WebViewClient()
        view.findViewById<WebView>(R.id.webview).loadUrl("https://quali55care.com/product/underarm-crutches-on-rent")

        return view
    }


}