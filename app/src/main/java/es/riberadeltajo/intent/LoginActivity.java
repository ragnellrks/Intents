package es.riberadeltajo.intent;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    ActivityResultLauncher<Intent> miLanzadorSeleccionaActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.d("HOLA", "ONcreate");
        Button b = findViewById(R.id.button2);

        miLanzadorSeleccionaActivity = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult o) {
                //aqui devuelven los resultados.
                Log.d("Ribera del Tajo", "Me han devuelto resultados");
                TextView prov = findViewById(R.id.prov);
                prov.setText("La provincia seleccionada es: "+o.getData().getExtras().get("ciudad_elegida"));
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentProv = new Intent(getApplicationContext(), SeleccionProvinciaActivity.class);
                miLanzadorSeleccionaActivity.launch(intentProv);

            }

        });
    }





    @Override
    protected void onStart() {
        super.onStart();
        Log.d("HOLA", "ONstart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("HOLA", "ONresume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("HOLA", "ONpause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("HOLA", "ONrestart");
    }

    @Override
    protected void onDestroy() {
        Log.d("HOLA", "ONdestroy");
        super.onDestroy();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("HOLA", "ONstop");
    }
}