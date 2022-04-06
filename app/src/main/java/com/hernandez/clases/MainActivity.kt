package com.hernandez.clases

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //log nos permite mostrar desde la consola un mensaje de debug
        //aparece en rojo al principio pero se soluciona con alt + enter
        //dentro del parentesis va la variable y el mensaje
        Log.d(TAG, "onCreate")
    }
//siempre usar el super
    override fun onStart() {
        super.onStart()
        Log.d(TAG,"onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart")
    }
    //declarar elementos estaticos de la clase
    companion object{
        //variables que no queremos que se instancien
        val TAG = MainActivity::class.simpleName   //guarda el valor de la clase MainActivity
    }

}