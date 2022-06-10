package com.example.actividad05_aplicacin_android_spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText cajaNumero, cajaResultado;
    Spinner spinerTemperatura1, spinerTemperatura2;
    ConvensorTemperaturas c1 = new ConvensorTemperaturas();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cajaNumero = findViewById(R.id.caja_numero);
        cajaResultado = findViewById(R.id.caja_resultado);

        spinerTemperatura1 = findViewById(R.id.spiner_temperatura_1);
        spinerTemperatura1.setOnItemSelectedListener(this);
        spinerTemperatura2 = findViewById(R.id.spiner_temperatura_2);
        spinerTemperatura2.setOnItemSelectedListener(this);

        String  temperaturas[] = {"centigrados","fahrenhet", "rankine", "kelvin"};

        ArrayAdapter adaptador1 = new ArrayAdapter(this, android.R.layout.simple_list_item_1, temperaturas);
        spinerTemperatura2.setAdapter(adaptador1);
        spinerTemperatura1.setAdapter(adaptador1);

        spinerTemperatura2.setSelection(1);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //Log.i("MSJ=>", spinerTemperatura1.getSelectedItem().toString());
        int sel1 = spinerTemperatura1.getSelectedItemPosition();
        int sel2 = spinerTemperatura2.getSelectedItemPosition();

        try{
            if(sel1 == sel2){
                cajaResultado.setText(cajaNumero.getText().toString());
            }
            else if(sel1 == 0 && sel2 ==1){
                cajaResultado.setText(String.valueOf(c1.deCelFah(Double.parseDouble(cajaNumero.getText().toString()))));
            } else if (sel1 == 0 && sel2 ==2){
                cajaResultado.setText(String.valueOf(c1.deCelRank(Double.parseDouble(cajaNumero.getText().toString()))));
            } else if (sel1 == 0 && sel2 ==3){
                cajaResultado.setText(String.valueOf(c1.deCelKel(Double.parseDouble(cajaNumero.getText().toString()))));
            } else if (sel1 == 1 && sel2 ==0){
                cajaResultado.setText(String.valueOf(c1.deFahCel(Double.parseDouble(cajaNumero.getText().toString()))));
            } else if (sel1 == 1 && sel2 ==2){
                cajaResultado.setText(String.valueOf(c1.deFahRank(Double.parseDouble(cajaNumero.getText().toString()))));
            } else if (sel1 == 1 && sel2 ==3){
                cajaResultado.setText(String.valueOf(c1.deFahKel(Double.parseDouble(cajaNumero.getText().toString()))));
            } else if (sel1 == 2 && sel2 ==0){
                cajaResultado.setText(String.valueOf(c1.deRankCel(Double.parseDouble(cajaNumero.getText().toString()))));
            } else if (sel1 == 2 && sel2 ==1){
                cajaResultado.setText(String.valueOf(c1.deRankFah(Double.parseDouble(cajaNumero.getText().toString()))));
            } else if (sel1 == 2 && sel2 ==3){
                cajaResultado.setText(String.valueOf(c1.deRankKel(Double.parseDouble(cajaNumero.getText().toString()))));
            } else if (sel1 == 3 && sel2 ==0){
                cajaResultado.setText(String.valueOf(c1.deKelCel(Double.parseDouble(cajaNumero.getText().toString()))));
            } else if (sel1 == 3 && sel2 ==1){
                cajaResultado.setText(String.valueOf(c1.deKelFah(Double.parseDouble(cajaNumero.getText().toString()))));
            } else if (sel1 == 3 && sel2 ==2){
                cajaResultado.setText(String.valueOf(c1.deKelRank(Double.parseDouble(cajaNumero.getText().toString()))));
            }
        } catch (Exception e){
            cajaResultado.setText("");
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}

class ConvensorTemperaturas {

    public double deCelFah (double c){
        return Math.round((c * 9/5 + 32)*100.0)/100.0;
    }

    public double deCelKel (double c){
        return Math.round((c + 273.15)*100.0)/100.0;
    }

    public double deCelRank (double c){
        return Math.round((c * 9/5 + 491.67)*100.0)/100.0;
    }

    //=================================

    public double deFahCel (double f){
        return Math.round(((f - 32) * 5/9)*100.0)/100.0;
    }

    public double deFahKel (double f){
        return Math.round(((f - 32) * 5/9 + 273.15)*100.0)/100.0;
    }

    public double deFahRank (double f){
        return Math.round((f + 459.67)*100.0)/100.0;
    }

    //=================================

    public double deKelCel (double k){
        return Math.round((k - 273.15)*100.0)/100.0;
    }

    public double deKelFah (double k){
        return Math.round(((k - 273.15) * 9/5 + 32 )*100.0)/100.0;
    }

    public double deKelRank (double k){
        return Math.round((k * 1.8)*100.0)/100.0;
    }

    //=================================

    public double deRankCel (double r){
        return Math.round(((r - 491.67) * 5/9)*100.0)/100.0;
    }

    public double deRankFah (double r){
        return Math.round((r - 459.67)*100.0)/100.0;
    }

    public double deRankKel (double r){
        return Math.round((r * 5/9)*100.0)/100.0;
    }

}

