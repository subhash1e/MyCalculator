# MyCalculator
Simple Calculator Using Kotlin XML

SEE RELEASES:]


# This is result fun for calculating expression

`````````````````````````````````````````````````````````````````````````````````````````````````````
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
    
    
   ``


# ScreenShot


![Screenshot1](https://user-images.githubusercontent.com/85139394/160836028-39dedb64-b5a2-4e9e-b842-c63197825395.jpg)


