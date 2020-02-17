package com.example.nottes.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import com.example.nottes.R


class NewWordActivity : AppCompatActivity() {

    private lateinit var edtTotalPago: EditText
    private lateinit var edtPrecoLitro: EditText
    private lateinit var edtQtdLitros: EditText
    private lateinit var edtKmAtual: EditText
    private lateinit var edtTipoCombutivel : EditText
    private lateinit var swtTipoCombustivel: Switch
    private lateinit var edtGPS: EditText
    private lateinit var btnGPS: Button
    private lateinit var btnGravar : Button

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_word)

        initView()

        initListeners()

    }

    private fun initListeners(){

        //Botao Gravar Registro
        btnGravar.setOnClickListener {
            val replyIntent = Intent()
            if (TextUtils.isEmpty(edtTotalPago.text)) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                val word = edtTotalPago.text.toString()
                replyIntent.putExtra(EXTRA_REPLY, word)
                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()
        }

        //Botao Ler GPS
        btnGPS.setOnClickListener {

        }

        //Switch Tipo combustivel (0 -> Alcool  | 1 -> Gasolina)
        swtTipoCombustivel.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked){
                edtTipoCombutivel.setText("Alcool")
            } else{
                edtTipoCombutivel.setText("Gasolina")
            }
        }

    }


    private fun initView(){
        edtTotalPago = findViewById(R.id.edit_totalPago)
        edtPrecoLitro = findViewById(R.id.edit_precoLitro)
        edtQtdLitros = findViewById(R.id.edit_qtdLitros)
        edtKmAtual = findViewById(R.id.edit_kmAtual)
        edtTipoCombutivel = findViewById(R.id.edit_tipoCombustivel)
        swtTipoCombustivel = findViewById(R.id.swt_tipoCombustivel)
        edtGPS = findViewById(R.id.edit_gpsPosto)
        btnGPS = findViewById(R.id.btn_getGps)
        btnGravar = findViewById(R.id.button_save)

        //Set initial conditions
        edtTipoCombutivel.setText("Gasolina")

    }

    companion object {
        const val EXTRA_REPLY = "REPLY"
    }
}