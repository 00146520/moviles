package com.hernandez.clases

import android.content.Intent
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
    //agregando la variable para el boton guardar
    private lateinit var saveButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //log nos permite mostrar desde la consola un mensaje de debug
        //aparece en rojo al principio pero se soluciona con alt + enter
        //dentro del parentesis va la variable y el mensaje
        Log.d(TAG, "onCreate")
        //se pregunta si el bundle existe (datos guardados)
        //savedInstanceState?.let{ bundle ->
        //scoreTeamA = bundle.getInt(KEY_SCORE_TEAM_A,0)
        //scoreTeamB = bundle.getInt(KEY_SCORE_TEAM_B,0)
        //} se corta y pega en setupScores

        //se pasa el bind
        bind()
        //se llama la funcion score
        setupScores(savedInstanceState)
        //se llama la funcion addListeners
        addListeners()
    }
    //crear nueva funcion para ayudar que los datos se guarden incluso cambiando orientacion
    //se utiliza el onSaveInstanceState con un parametro
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_SCORE_TEAM_A, scoreTeamA)
        outState.putInt(KEY_SCORE_TEAM_B, scoreTeamB)
    }

    //se crean los listeners
    private fun addListeners(){
        //button del equipo A
        teamAAddButton.setOnClickListener{
            //suma uno
            scoreTeamA=scoreTeamA+1
            //se llama la funcion updateScore y se pasan los argumentos
            updateVisualScore(teamAScoreTextView, scoreTeamA)
        }
        //button del equipo B
        teamBAddButton.setOnClickListener{
            scoreTeamB++
            updateVisualScore(teamBScoreTextView,scoreTeamB)
        }
        //funcionalidad del boton guardar
        saveButton.setOnClickListener{
            onSave()
        }
    }
    //se crea una funcion para guardar los resultados
    private fun onSave(){
        //se hace el enlace para poder pasar al ScoreActivity
        val intent = Intent(this,ScoreActivity::class.java)
        //se crea un Intent.putExtra para pasar los datos al otro activity
        intent.putExtra(KEY_SCORE_TEAM_A,scoreTeamA)
        intent.putExtra(KEY_SCORE_TEAM_B,scoreTeamB)
        startActivity(intent)
    }

    //se crea la funcion updateScore para que el marcador vaya cambiando
    private fun updateVisualScore (view: TextView, score: Int){
        view.text = score.toString()
    }
    //se crea la funcion para colocar puntuajes
    private fun setupScores(savedInstanceState: Bundle?) {
        savedInstanceState?.let{ bundle ->
            scoreTeamA = bundle.getInt(KEY_SCORE_TEAM_A,0)
            scoreTeamB = bundle.getInt(KEY_SCORE_TEAM_B,0)
        }
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
        //variable que va encontrar el boton save
        saveButton = findViewById(R.id.action_save)
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
        //declarando key
        //private const val KEY_SCORE_TEAM_A = "ScoreTeamA"
        //private const val KEY_SCORE_TEAM_B = "ScoreTeamB"
        //se quita el private para que esos datos sean visibles en el ScoreActivity
        const val KEY_SCORE_TEAM_A = "ScoreTeamA"
        const val KEY_SCORE_TEAM_B = "ScoreTeamB"
    }

}