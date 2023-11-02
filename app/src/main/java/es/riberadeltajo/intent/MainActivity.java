package es.riberadeltajo.intent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    public final int CAPTURA_FOTO = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Intent Implicito
        ImageButton btnCamara=findViewById(R.id.btnCamara);
        btnCamara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent foto = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(foto, CAPTURA_FOTO);
            }
        });

        //Intent Explicito
        Button b = findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrancaActividadLogin();
            }
        });

        Log.d("HOLA", "ONCREATE");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==CAPTURA_FOTO){
            ImageView imagenCamara = findViewById(R.id.imagenCamara);
            Bitmap miImagen = (Bitmap) data.getExtras().get("data");
            imagenCamara.setImageBitmap(miImagen);
        }
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

    private void arrancaActividadLogin() {
        //1*: Crear un objeto Intent (i) con la clase a Instanciar
        Intent intentLogin = new Intent(this, LoginActivity.class);

        //2*: Arrancar la actividad
        startActivity(intentLogin);
    }
}