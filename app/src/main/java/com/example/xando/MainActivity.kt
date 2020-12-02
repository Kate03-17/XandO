package com.example.xando

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var Button1: Button
    private lateinit var Button2: Button
    private lateinit var Button3: Button
    private lateinit var Button4: Button
    private lateinit var Button5: Button
    private lateinit var Button6: Button
    private lateinit var Button7: Button
    private lateinit var Button8: Button
    private lateinit var Button9: Button
    private lateinit var resetButton: Button

    var winnerPlayer = 0

    private var activePlayer = 1

    private var firstPlayer = ArrayList<Int>()
    private var secondPlayer = ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {

        Button1 = findViewById(R.id.Button1)
        Button2 = findViewById(R.id.Button2)
        Button3 = findViewById(R.id.Button3)
        Button4 = findViewById(R.id.Button4)
        Button5 = findViewById(R.id.Button5)
        Button6 = findViewById(R.id.Button6)
        Button7 = findViewById(R.id.Button7)
        Button8 = findViewById(R.id.Button8)
        Button9 = findViewById(R.id.Button9)
        resetButton = findViewById(R.id.resetButton)

        Button1.setOnClickListener(this)
        Button2.setOnClickListener(this)
        Button3.setOnClickListener(this)
        Button4.setOnClickListener(this)
        Button5.setOnClickListener(this)
        Button6.setOnClickListener(this)
        Button7.setOnClickListener(this)
        Button8.setOnClickListener(this)
        Button9.setOnClickListener(this)

        resetButton.setOnClickListener(this)
    }

    override fun onClick(clickedView: View?) {
        if(clickedView is Button) {
            var buttonNumber = 0

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


            if (buttonNumber != 0) {
                playGame(clickedView, buttonNumber)



            }

            if( clickedView.id == R.id.resetButton){

                winnerPlayer = 0
                Button1.text = ""
                Button2.setBackgroundColor(Color.BLUE)
                Button2.text = ""
                Button3.setBackgroundColor(Color.BLUE)
                Button3.text = ""
                Button3.setBackgroundColor(Color.BLUE)
                Button4.text = ""
                Button4.setBackgroundColor(Color.BLUE)
                Button5.text = ""
                Button5.setBackgroundColor(Color.BLUE)
                Button6.text = ""
                Button6.setBackgroundColor(Color.BLUE)
                Button7.text = ""
                Button7.setBackgroundColor(Color.BLUE)
                Button8.text = ""
                Button8.setBackgroundColor(Color.BLUE)
                Button9.text = ""
                Button9.setBackgroundColor(Color.BLUE)
                enableButtons()


            }


        }




    }

    private fun playGame(clickedView: Button, ButtonNumber: Int) {
        if (activePlayer == 1) {
            clickedView.text = "X"
            clickedView.setBackgroundColor(Color.RED)
            firstPlayer.add(ButtonNumber)
            activePlayer = 2

        }else {
            clickedView.text = "O"
            clickedView.setBackgroundColor(Color.YELLOW)
            secondPlayer.add(ButtonNumber)
            activePlayer = 1
        }
        clickedView.isEnabled = false
        check()
    }

    private fun check(){

//        var winnerPlayer = 0




        if(firstPlayer.contains(1) && firstPlayer.contains(2) && firstPlayer.contains(3)){
            winnerPlayer = 1
        }
        if(secondPlayer.contains(1) && secondPlayer.contains(2) && secondPlayer.contains(3)){
            winnerPlayer = 2
        }
        if(firstPlayer.contains(4) && firstPlayer.contains(5) && firstPlayer.contains(6)){
            winnerPlayer = 1
        }
        if(secondPlayer.contains(4) && secondPlayer.contains(5) && secondPlayer.contains(6)){
            winnerPlayer = 2
        }
        if(firstPlayer.contains(7) && firstPlayer.contains(8) && firstPlayer.contains(9)){
            winnerPlayer = 1
        }
        if(secondPlayer.contains(7) && secondPlayer.contains(8) && secondPlayer.contains(9)){
            winnerPlayer = 2
        }
        if(firstPlayer.contains(1) && firstPlayer.contains(4) && firstPlayer.contains(7)){
            winnerPlayer = 1
        }
        if(secondPlayer.contains(1) && secondPlayer.contains(4) && secondPlayer.contains(7)){
            winnerPlayer = 2
        }
        if(firstPlayer.contains(2) && firstPlayer.contains(5) && firstPlayer.contains(8)){
            winnerPlayer = 1
        }
        if(secondPlayer.contains(2) && secondPlayer.contains(5) && secondPlayer.contains(8)){
            winnerPlayer = 2
        }
        if(firstPlayer.contains(3) && firstPlayer.contains(6) && firstPlayer.contains(9)){
            winnerPlayer = 1
        }
        if(secondPlayer.contains(3) && secondPlayer.contains(6) && secondPlayer.contains(9)){
            winnerPlayer = 2
        }
        if(firstPlayer.contains(1) && firstPlayer.contains(5) && firstPlayer.contains(9)){
            winnerPlayer = 1
        }
        if(secondPlayer.contains(1) && secondPlayer.contains(5) && secondPlayer.contains(9)){
            winnerPlayer = 2
        }
        if(firstPlayer.contains(3) && firstPlayer.contains(5) && firstPlayer.contains(7)){
            winnerPlayer = 1
        }
        if(secondPlayer.contains(3) && secondPlayer.contains(5) && secondPlayer.contains(7)){
            winnerPlayer = 2
        }
        if(((firstPlayer.count() == 5 && secondPlayer.count() == 4) || (firstPlayer.count() == 4 && secondPlayer.count() == 5)) && winnerPlayer == 0){
            Toast.makeText(this, "It's a tie!", Toast.LENGTH_LONG).show()
            disableButtons()
        }

        if(winnerPlayer != 0){
            if(winnerPlayer == 1){
                Toast.makeText(this, "X wins", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Y wins", Toast.LENGTH_LONG).show()
            }
            disableButtons()
        }

    }
    private fun disableButtons(){

        Button1.isEnabled = false
        Button2.isEnabled = false
        Button3.isEnabled = false
        Button4.isEnabled = false
        Button5.isEnabled = false
        Button6.isEnabled = false
        Button7.isEnabled = false
        Button8.isEnabled = false
        Button9.isEnabled = false

    }

    private fun enableButtons(){

        Button1.isEnabled = true
        Button2.isEnabled = true
        Button3.isEnabled = true
        Button4.isEnabled = true
        Button5.isEnabled = true
        Button6.isEnabled = true
        Button7.isEnabled = true
        Button8.isEnabled = true
        Button9.isEnabled = true

    }



}