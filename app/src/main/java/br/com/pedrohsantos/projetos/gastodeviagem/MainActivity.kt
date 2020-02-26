package br.com.pedrohsantos.projetos.gastodeviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        val id = view.id
        if(id == R.id.buttonCalculate){
            calculate()
        }
    }

    private fun calculate() {
        try{
            if(validationOK()){
                val distance = editDistance.text.toString().toFloat()
                val price = editPrice.text.toString().toFloat()
                val autonomy = editAutonomy.text.toString().toFloat()

                val result = (distance * price) / autonomy
                textTotalValue.text = "R$ ${"%2f".format(result)}"
            }else{
                Toast.makeText(this, getString(R.string.preencha_todos_os_campos), Toast.LENGTH_LONG).show()
            }
        }catch (numberFormatException: NumberFormatException){
            Toast.makeText(this, getString(R.string.por_favor_informe_valores_validos), Toast.LENGTH_LONG).show()
        }

    }

    private fun validationOK(): Boolean{
        return (!editDistance.text.isNullOrEmpty() && !editPrice.text.isNullOrEmpty() && !editAutonomy.text.isNullOrEmpty())
    }

}
