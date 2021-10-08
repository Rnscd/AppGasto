package com.renansn.appgastochacara;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

private EditText Distancia, Preco, Autonomia;
private TextView Resultado;
private Button btnCalculo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resultado = (TextView) findViewById(R.id.txtResultado);
        Distancia = (EditText) findViewById(R.id.edtDistancia);
        Preco = (EditText) findViewById(R.id.edtPreco);
        Autonomia = (EditText) findViewById(R.id.edtAutonomia);
    }

    public void CalcularPreco(View view) {
        String quilometragem = Distancia.getText().toString();
        String preco = Preco.getText().toString();
        String autonomia = Autonomia.getText().toString();
        {
            Boolean camposValida = this.validarCampos(quilometragem, preco, autonomia);
                if (camposValida)
                {
                    this.calcularPercurso(quilometragem, preco, autonomia);
                }else
                {
                    Resultado.setText("Preencha todo os campos");
                }


        }

    }
    //Calculo do percuso

    //Metodo para validar campos
    public void calcularPercurso (String cQuilometragem, String cPreco, String cAutonomia)
    {
        Double Distancia = Double.parseDouble(cQuilometragem);
        Double Preco = Double.parseDouble(cPreco);
        Double Autonomia = Double.parseDouble(cAutonomia);

        //Realiza calculo

            Double resultado = Double.parseDouble
                    (String.valueOf((Distancia*Preco)/Autonomia));
            Resultado.setText(resultado.toString());
            limparCampos();
    }

    public Boolean validarCampos(String vQuilometragem, String vPreco, String vAutonomia)
    {
        Boolean camposValidados =true;
        if (vQuilometragem==null || vPreco==null) {
            camposValidados=false;
        } else if (vQuilometragem == null || vAutonomia==null)
        {
            camposValidados=false;
        }
        return camposValidados;

    }
    //Metodo para limpar os campos preenchidos
    public void limparCampos ()
    {
        Distancia.setText("");
        Preco.setText("");
        Autonomia.setText("");
    }
}