package com.example.urbanmarket;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegistrarActivity extends AppCompatActivity {

    EditText nombre,correo,contraseña;
    private FirebaseAuth auth;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);


        auth = FirebaseAuth.getInstance();

        if (auth.getCurrentUser() != null){

            startActivity(new Intent(RegistrarActivity.this, MainActivity.class));
            finish();
        }

        nombre = findViewById(R.id.nombre);
        correo = findViewById(R.id.correo);
        contraseña = findViewById(R.id.contraseña);

        sharedPreferences = getSharedPreferences("IncorporacionScreen",MODE_PRIVATE);

        boolean primeravez = sharedPreferences.getBoolean("primeravez",true);

        if (primeravez){

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("primeravez",false);
            editor.commit();

            Intent intent = new Intent(RegistrarActivity.this,IncorporacionActivity.class);
            startActivity(intent);
            finish();
        }

    }

    public void Registrarse(View view) {

        String userNombre = nombre.getText().toString();
        String userCorreo = correo.getText().toString();
        String userContraseña = contraseña.getText().toString();


        if (TextUtils.isEmpty(userNombre)){

            Toast.makeText(this,"Inserte Nombre!", Toast.LENGTH_SHORT).show();
            return;

        }

        if (TextUtils.isEmpty(userCorreo)){

            Toast.makeText(this,"Inserte Correo!", Toast.LENGTH_SHORT).show();
            return;

        }

        if (TextUtils.isEmpty(userContraseña)){

            Toast.makeText(this,"Inserte Contraseña!", Toast.LENGTH_SHORT).show();
            return;

        }

        if (userContraseña.length() <6){

            Toast.makeText(this,"Minimo 6 caracteres !", Toast.LENGTH_SHORT).show();
            return;

        }

        auth.createUserWithEmailAndPassword(userCorreo,userContraseña)
                        .addOnCompleteListener(RegistrarActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if (task.isSuccessful()){
                                    Toast.makeText(RegistrarActivity.this,"Registro Completado",Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(RegistrarActivity.this, MainActivity.class));
                                } else {
                                    Toast.makeText(RegistrarActivity.this,"Registro Fallido"+ task.getException(),Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

        //startActivity(new Intent(RegistrarActivity.this, MainActivity.class));
    }

    public void iniciarsesion(View view) {
        startActivity(new Intent(RegistrarActivity.this, LoginActivity.class));
    }
}