package com.example.programmercalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
//    -------------------------------------------------
class MainActivity : AppCompatActivity() {
    lateinit var binaryInput:EditText
    lateinit var hexaInput:EditText
    lateinit var decimalInput:EditText
    lateinit var octaInput:EditText
    lateinit var clearButton: Button
    lateinit var textWatcher: TextWatcher
    lateinit var value :String
    lateinit var onFocusChangeListener : View.OnFocusChangeListener
    var focusedViewId :Int=0
    private lateinit var converter : Converter
    //    -------------------------------------------------
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        converter=Converter()
        initViews()
        addCallback()
    }
//    ----------------------------------------------------------------------------------------------
    private fun initViews(){
        binaryInput =findViewById(R.id.binary)
        hexaInput =findViewById(R.id.hexa)
        decimalInput =findViewById(R.id.decimal)
        octaInput =findViewById(R.id.octa)
        clearButton =findViewById(R.id.clearButton)
            }
//    -------------------------------------------------
    private fun addCallback(){
        setOnClickClearButton()
        textWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                value = s.toString().trim()
                if (value.isNotEmpty()){
                    convertNumber()
                }else clearInputs()
            }
            override fun afterTextChanged(s: Editable?) {}
        }
        onFocusChangeListener = View.OnFocusChangeListener { view, hasFocus ->
            if (hasFocus) {
                focusedViewId = view.id
                findViewById<EditText>(focusedViewId).addTextChangedListener(textWatcher)
            }
            else findViewById<EditText>(focusedViewId).removeTextChangedListener(textWatcher)
        }
        decimalInput.setOnFocusChangeListener(onFocusChangeListener)
        binaryInput.setOnFocusChangeListener(onFocusChangeListener)
        octaInput.setOnFocusChangeListener(onFocusChangeListener)
        hexaInput.setOnFocusChangeListener(onFocusChangeListener)
    }
//    -------------------------------------------------
    private fun  convertNumber(){

        when(focusedViewId){
            R.id.decimal ->{
               binaryInput.setText(converter.convertDecimalToBinary(value))
               octaInput.setText(converter.convertDecimalToOcta(value))
               hexaInput.setText(converter.convertDecimalToHexa(value))
            }
            R.id.binary ->{
               decimalInput.setText(converter.convertBinaryToDecimal(value))
               octaInput.setText(converter.convertBinaryToOcta(value))
               hexaInput.setText(converter.convertBinaryToHexa(value))

            }
            R.id.octa ->{
               decimalInput.setText(converter.convertOctaToDecimal(value))
               binaryInput.setText(converter.convertOctaToBinary(value))
               hexaInput.setText(converter.convertOctaToHexa(value))
            }
            R.id.hexa ->{
               decimalInput.setText(converter.convertHexaToDecimal(value))
               binaryInput.setText(converter.convertHexaToBinary(value))
                octaInput.setText(converter.convertHexaToOcta(value))
   } } }
//    -------------------------------------------------
    private fun clearInputs(){
        binaryInput.text.clear()
        hexaInput.text.clear()
        decimalInput.text.clear()
        octaInput.text.clear()
    }
//    -------------------------------------------------
    private fun setOnClickClearButton(){
        clearButton.setOnClickListener {
            clearInputs()
        }
    }
}