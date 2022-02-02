package com.robertocursoandroid.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

     private TextInputEditText  editPrecoAlcool, editPrecoGasolna;
     private TextView  textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrecoAlcool  = findViewById(R.id.editPrecoAlcool);
        editPrecoGasolna = findViewById(R.id.editPreçoGasolina);

        textResultado    = findViewById(R.id.textResultado);


    }

    public void calcularPreco(View view){
        // recuperar preços digitados

        String precoAlcool = editPrecoAlcool.getText().toString();
        String precoGasolina = editPrecoGasolna.getText().toString();

        // validar campos digitados
        Boolean camposValidados = validarCampo(precoAlcool, precoGasolina);

        if(camposValidados){
            // convertendo string para numeros
            Double valorAlcool = Double.parseDouble(precoAlcool);
            Double valorGasolina = Double.parseDouble(precoGasolina);

            // fazer calculo de menor preço
              Double resultado = valorAlcool / valorGasolina;

                if(resultado >= 0.7){
                    textResultado.setText("É melhor utilizar gasolina!");
                }else{
                    textResultado.setText("É melhor utilizar Alcool!");
                }


          /*  if(valorAlcool / valorGasolina >= 0.7){
                textResultado.setText("É melhor utilizar gasolina!");
            }else if(valorAlcool / valorGasolina <= 0.7){
                textResultado.setText("É melhor utilizar Alcool!");
            }

           */

        }else{
            textResultado.setText("Precisa preencher os preços primeiro!");
        }

    }

    public Boolean validarCampo(String pAlcool, String pGasolina){

        Boolean camposValidados = true;


          if(pAlcool == null || pAlcool.equals("")){
              camposValidados = false;


          }else if(pGasolina == null || pGasolina.equals("")){
              camposValidados = false;

          }

        return  camposValidados;
    }
}
