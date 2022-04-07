package com.hernandez.clases

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    //se crean variables
    //data
    private var scoreTeamA = 0
    private var scoreTeamB = 0
    //textviews
    //agregando para los score del equipo A
    private lateinit var teamAScoreTextView: TextView
    private lateinit var teamAAddButton: Button
    //agregando para los score del equipo B
    private lateinit var teamBScoreTextView: TextView
    private lateinit var teamBAddButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //log nos permite mostrar desde la consola un mensaje de debug
        //aparece en rojo al principio pero se soluciona con alt + enter
        //dentro del parentesis va la variable y el mensaje
        Log.d(TAG, "onCreate")
        //se pasa el bind
        bind()
        //se llama la funcion score
        setupScores()
        //se llama la funcion addListeners
        addListeners()
    }
    //se crean los listeners
    private fun addListeners(){
        //button del equipo A
        teamAAddButton.setOnClickListener{
            //suma uno
            scoreTeamA++
            //se llama la funcion updateScore y se pasan los argumentos
            updateVisualScore(teamAScoreTextView, scoreTeamA)
        }
        //button del equipo B
        teamBAddButton.setOnClickListener{
            scoreTeamB++
            updateVisualScore(teamBScoreTextView,scoreTeamB)
        }
    }
    //se crea la funcion updateScore para que el marcador vaya cambiando
    private fun updateVisualScore (view: TextView, score: Int){
        view.text = score.toString()
    }
    //se crea la funcion para colocar puntuajes
    private fun setupScores(){
        //se coloca el toString porque si se deja con 0 (teamSScoreTextView.text = 0) da error porque 0 no es string
       // teamAScoreTextView.text = scoreTeamA.toString()
       // teamBScoreTextView.text = scoreTeamB.toString()
        //NUEVA
        //se llama la funcion updateVisualScore
        updateVisualScore(teamAScoreTextView,scoreTeamA)
        updateVisualScore(teamBScoreTextView,scoreTeamB)
    }

    //usar el bind
    private fun bind(){
        //la variable del TextView del equipo A
        //de argumento se pasa el id del TextView donde se muestra la puntuacion del equipo A
        teamAScoreTextView = findViewById(R.id.score_team_a_text_view)
        //la variable del button del equipo A
        //de argumento se pasa el id del Button donde se suma la puntuacion del equipo A
        teamAAddButton = findViewById(R.id.action_add_one_team_a)
        //la variable del TextView del equipo B
        //de argumento se pasa el id del TextView donde se muestra la puntuacion del equipo B
        teamBScoreTextView = findViewById(R.id.score_team_b_text_view)
        //la variable del button del equipo B
        //de argumento se pasa el id del Button donde se suma la puntuacion del equipo B
        teamBAddButton = findViewById(R.id.action_add_one_team_b)
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