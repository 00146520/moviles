package com.hernandez.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class GreetingFragment : Fragment() {
    //para colocar este codigo de forma automatica, solo escribir override oncreateview y luego la primera opcion
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       return inflater.inflate(R.layout.fragment_greeting,container,false)
    }
}