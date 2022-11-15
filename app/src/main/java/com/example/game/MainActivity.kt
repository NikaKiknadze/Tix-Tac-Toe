package com.example.game

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener{
    private lateinit var Button1: Button
    private lateinit var Button2: Button
    private lateinit var Button3: Button
    private lateinit var Button4: Button
    private lateinit var Button5: Button
    private lateinit var Button6: Button
    private lateinit var Button7: Button
    private lateinit var Button8: Button
    private lateinit var Button9: Button

    var activePlayer = 1

    private var firstPlayer = ArrayList<Int>()
    private var secondPlayer = ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }
    private fun init(){
        Button1 = findViewById(R.id.Button1)
        Button2 = findViewById(R.id.Button2)
        Button3 = findViewById(R.id.Button3)
        Button4 = findViewById(R.id.Button4)
        Button5 = findViewById(R.id.Button5)
        Button6 = findViewById(R.id.Button6)
        Button7 = findViewById(R.id.Button7)
        Button8 = findViewById(R.id.Button8)
        Button9 = findViewById(R.id.Button9)

        Button1.setOnClickListener(this)
        Button2.setOnClickListener(this)
        Button3.setOnClickListener(this)
        Button4.setOnClickListener(this)
        Button5.setOnClickListener(this)
        Button6.setOnClickListener(this)
        Button7.setOnClickListener(this)
        Button8.setOnClickListener(this)
        Button9.setOnClickListener(this)
    }
    override fun onClick(clickedView: View?) {

            var buttonNumber = 0

            if (clickedView is Button) {

                when (clickedView.id) {
                R.id.Button1 -> buttonNumber = 1
                R.id.Button2 -> buttonNumber = 2
                R.id.Button3 -> buttonNumber = 3
                R.id.Button4 -> buttonNumber = 4
                R.id.Button5 -> buttonNumber = 5
                R.id.Button6 -> buttonNumber = 6
                R.id.Button7 -> buttonNumber = 7
                R.id.Button8 -> buttonNumber = 8
                R.id.Button9 -> buttonNumber = 9
            }
        }

        if (buttonNumber != 0) {
            playGame(buttonNumber, clickedView as Button)
        }

    }
    private fun playGame(buttonNumber: Int, clickedView: Button) {

        if (activePlayer == 1){
            clickedView.text = "X"
            clickedView.setBackgroundColor(Color.GREEN)
            activePlayer = 2
            firstPlayer.add(buttonNumber)
        }else if (activePlayer == 2){
            clickedView.text = "0"
            clickedView.setBackgroundColor(Color.RED)
            activePlayer = 1
            secondPlayer.add(buttonNumber)
        }
        clickedView.isEnabled = false
        check()
    }
    private fun check() {
        var winnerPlayer = 0
        if (firstPlayer.contains(1) && firstPlayer.contains(2) && firstPlayer.contains(3)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(2) && secondPlayer.contains(3)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(4) && firstPlayer.contains(5) && firstPlayer.contains(6)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(4) && secondPlayer.contains(5) && secondPlayer.contains(6)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(7) && firstPlayer.contains(8) && firstPlayer.contains(9)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(7) && secondPlayer.contains(8) && secondPlayer.contains(9)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(1) && firstPlayer.contains(4) && firstPlayer.contains(7)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(4) && secondPlayer.contains(7)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(2) && firstPlayer.contains(5) && firstPlayer.contains(8)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(2) && secondPlayer.contains(5) && secondPlayer.contains(8)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(3) && firstPlayer.contains(6) && firstPlayer.contains(9)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(3) && secondPlayer.contains(6) && secondPlayer.contains(9)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(1) && firstPlayer.contains(5) && firstPlayer.contains(9)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(5) && secondPlayer.contains(9)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(3) && firstPlayer.contains(5) && firstPlayer.contains(7)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(3) && secondPlayer.contains(5) && secondPlayer.contains(7)) {
            winnerPlayer = 2
        }
        if (winnerPlayer == 1){
            Toast.makeText(applicationContext, "X won", Toast.LENGTH_SHORT).show()
        }else if (winnerPlayer == 2){
            Toast.makeText(applicationContext, "0 won", Toast.LENGTH_SHORT).show()
        }
    }
}