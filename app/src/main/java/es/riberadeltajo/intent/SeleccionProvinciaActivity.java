package es.riberadeltajo.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SeleccionProvinciaActivity extends AppCompatActivity {
    public final int RESULTADO_SELECCION_PROVINCIA = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion_provincia);
        ListView lstProv = findViewById(R.id.lstProvincia);

        String[] misProvincias = new String[]{"Guadalajara", "Toledo", "Albacete", "Ciudad Real", "Cuenca"};

        ArrayAdapter<String> miAdaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, misProvincias);

        lstProv.setAdapter(miAdaptador);

        lstProv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent resultado = new Intent();
                resultado.putExtra("ciudad_elegida", misProvincias[position]);
                resultado.putExtra("posicion_ciudad_elegida", position);
                setResult(RESULTADO_SELECCION_PROVINCIA, resultado);
                finish();
            }
        });

    }
}