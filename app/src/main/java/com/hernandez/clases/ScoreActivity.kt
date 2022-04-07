package com.hernandez.clases

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ScoreActivity : AppCompatActivity() {
    private var scoreTeamA = 0
    private var scoreTeamB = 0

    //declarando elementos necesarios
    //marcadores
    private lateinit var scoreTeamATextView: TextView
    private lateinit var scoreTeamBTextView: TextView
    //status
    private lateinit var statusTeamA:TextView
    private lateinit var statusTeamB:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)
        bind()
        //preguntar si se ha mandado un intent
        intent?.let { intent ->
            scoreTeamA = intent.getIntExtra(MainActivity.KEY_SCORE_TEAM_A, 0)
            scoreTeamB = intent.getIntExtra(MainActivity.KEY_SCORE_TEAM_B, 0)
        }
        fillScoreBoard()
    }
    //declarando el bind
    private fun bind() {
        //encontrando los marcadores
        scoreTeamATextView = findViewById(R.id.score_team_a_text_view)
        scoreTeamBTextView = findViewById(R.id.score_team_b_text_view)
        //encontrando los status
        statusTeamA = findViewById(R.id.status_team_a_text_view)
        statusTeamB = findViewById(R.id.status_team_b_text_view)
    }
    private fun fillScoreBoard(){
        scoreTeamATextView.text = scoreTeamA.toString()
        scoreTeamBTextView.text = scoreTeamB.toString()
        if(scoreTeamA == scoreTeamB){
            statusTeamB.text = getString(R.string.text_winner)
            statusTeamA.text = getString(R.string.text_winner)
        } else if(scoreTeamA > scoreTeamB){
            statusTeamA.text = getString(R.string.text_winner)
            statusTeamB.text = getString(R.string.text_loser)
        }else{
            statusTeamA.text = getString(R.string.text_loser)
            statusTeamB.text = getString(R.string.text_winner)
        }
    }
}