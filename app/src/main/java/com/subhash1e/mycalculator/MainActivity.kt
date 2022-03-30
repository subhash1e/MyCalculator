package com.subhash1e.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.widget.EditText
import android.widget.ScrollView
import org.w3c.dom.Text
import java.lang.StringBuilder
import javax.script.ScriptEngine
import javax.script.ScriptEngineManager
import javax.script.ScriptException

class MainActivity : AppCompatActivity() {
    lateinit var button1: android.widget.Button
    lateinit var button2: android.widget.Button
    lateinit var button3: android.widget.Button
    lateinit var button4: android.widget.Button
    lateinit var button5: android.widget.Button
    lateinit var button6: android.widget.Button
    lateinit var button7: android.widget.Button
    lateinit var button8: android.widget.Button
    lateinit var button9: android.widget.Button

    lateinit var button0: android.widget.Button
    lateinit var button00: android.widget.Button
    lateinit var buttonPoint: android.widget.Button

    lateinit var buttonDiv: android.widget.Button
    lateinit var buttonMul: android.widget.Button
    lateinit var buttonSum: android.widget.Button
    lateinit var buttonSub: android.widget.Button
    lateinit var buttonPerc: android.widget.Button
    lateinit var buttonEqual: android.widget.Button

    lateinit var buttonBack: android.widget.Button
    lateinit var buttonClear: android.widget.Button

    //////////////////
    lateinit var inputText: EditText
    lateinit var resultText: EditText
    var check = 0

    override fun onCreate(savedInstanceState: Bundle?) {


        ///////////////////

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        //////////////////
        button0 = findViewById(R.id.btn0)
        button00 = findViewById(R.id.btn00)
        button1 = findViewById(R.id.btn1)
        button2 = findViewById(R.id.btn2)
        button3 = findViewById(R.id.btn3)
        button4 = findViewById(R.id.btn4)
        button5 = findViewById(R.id.btn5)
        button6 = findViewById(R.id.btn6)
        button7 = findViewById(R.id.btn7)
        button8 = findViewById(R.id.btn8)
        button9 = findViewById(R.id.btn9)
        buttonPoint= findViewById(R.id.btnPoint)

        buttonPerc = findViewById(R.id.btnPerc)
        buttonClear = findViewById(R.id.btnC)
        buttonDiv = findViewById(R.id.btnDiv)
        buttonMul = findViewById(R.id.btnMul)
        buttonSub= findViewById(R.id.btnMin)
        buttonSum= findViewById(R.id.btnSum)
        buttonEqual = findViewById(R.id.btnEqual)
        buttonBack = findViewById(R.id.btnBack)


        inputText = findViewById(R.id.ip)
        resultText = findViewById(R.id.result)


        /////////////////////////

        inputText.movementMethod = ScrollingMovementMethod()
        inputText.isActivated
        inputText.isPressed

        //////////////////////

        var text:String

        button00.setOnClickListener{
            text = inputText.text.toString() + "00"
            inputText.setText(text)
            result(text)
        }

        button0.setOnClickListener{
            text = inputText.text.toString() + "0"
            inputText.setText(text)
            result(text)
        }
        button1.setOnClickListener{
            text = inputText.text.toString() + "1"
            inputText.setText(text)
            result(text)
        }
        button2.setOnClickListener{
            text = inputText.text.toString() + "2"
            inputText.setText(text)
            result(text)
        }
        button3.setOnClickListener{
            text = inputText.text.toString() + "3"
            inputText.setText(text)
            result(text)
        }
        button4.setOnClickListener{
            text = inputText.text.toString() + "4"
            inputText.setText(text)
            result(text)
        }
        button5.setOnClickListener{
            text = inputText.text.toString() + "5"
            inputText.setText(text)
            result(text)
        }
        button6.setOnClickListener{
            text = inputText.text.toString() + "6"
            inputText.setText(text)
            result(text)
        }
        button7.setOnClickListener{
            text = inputText.text.toString() + "7"
            inputText.setText(text)
            result(text)
        }
        button8.setOnClickListener{
            text = inputText.text.toString() + "8"
            inputText.setText(text)
            result(text)
        }
        button9.setOnClickListener{
            text = inputText.text.toString() + "9"
            inputText.setText(text)
            result(text)
        }
        buttonPoint.setOnClickListener{
            text = inputText.text.toString() + "."
            inputText.setText(text)
            result(text)
        }
        /////////////////////////////

        buttonSum.setOnClickListener{
            text = inputText.text.toString() + "+"
            inputText.setText(text)
            check+=1
        }

        buttonSub.setOnClickListener{
            text = inputText.text.toString() + "-"
            inputText.setText(text)
            check+=1
        }

        buttonMul.setOnClickListener{
            text = inputText.text.toString() + "*"
            inputText.setText(text)
            check+=1
        }

        buttonDiv.setOnClickListener{
            text = inputText.text.toString() + "/"
            inputText.setText(text)
            check+=1
        }

        buttonPerc.setOnClickListener{
            text = inputText.text.toString() + "%"
            inputText.setText(text)
            check+=1
        }
        ///////////////////////////////

        buttonEqual.setOnClickListener{
            text = resultText.text.toString()
            inputText.setText(text)
            resultText.text = null
        }
        buttonClear.setOnClickListener{

            inputText.text = null
            resultText.text = null
        }
        buttonBack.setOnClickListener{

            var backSpace: String? = null

           if(inputText.text.length>0){
               val stringBuilder: StringBuilder = StringBuilder(inputText.text)
               val find = inputText.text.toString()
               val find2 = find.last() // last char of inputText
               if (find2 == '+' || find2 == '*' || find2 == '-' || find2 == '%' || find2 == '/'){
                   check--
               }

               stringBuilder.deleteCharAt(inputText.text.length-1)
               backSpace=stringBuilder.toString()
               inputText.setText(backSpace)
               if(backSpace.length>0)
               result(backSpace)
           }else{
               println("empty")
           }
        }

    }

    private fun result(text: String) {
        val engine:ScriptEngine = ScriptEngineManager().getEngineByName("rhino")



        try {
            lateinit var result:Any
            if (text.length>0){ result= engine.eval(text)}
            var main = result.toString()
            if (check ==0){
                resultText.text = null
            }else{
                resultText.setText(main)
            }
        }catch ( e:ScriptException
        ){
            Log.d("Tag","Error")

        }

    }
}