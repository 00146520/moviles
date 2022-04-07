package com.hernandez.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity(), SumFragment.onActionListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //agregando el gestor de fragmentos
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        //agregando un fragmento
        val fragment = SumFragment.newInstance(2,5)

        fragmentTransaction.add(R.id.FrameLayout_fragment,fragment).commit()


    }
//haciendo notificacion
    override fun onActionClick(result: Int) {
        Toast.makeText(this, "El resultado es $result", Toast.LENGTH_SHORT).show()
    }
}