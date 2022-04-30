package com.terminalstack.helpu.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import com.terminalstack.helpu.R
import com.terminalstack.helpu.databinding.FragmentMinistryOfDisabledWebViewBinding


class MinistryOfDisabledWebViewFragment : Fragment() {

    lateinit var binding: FragmentMinistryOfDisabledWebViewBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMinistryOfDisabledWebViewBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var myWebView = binding.webview

        myWebView.loadUrl("https://www.disabilityaffairs.gov.in/content/")
        myWebView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(viewx: WebView, urlx: String): Boolean {
                viewx.loadUrl(urlx)
                return false
            }
        }
    }
}