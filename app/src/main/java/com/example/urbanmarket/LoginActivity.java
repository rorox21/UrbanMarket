package com.example.urbanmarket;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    EditText correo,contraseña;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        auth = FirebaseAuth.getInstance();

        correo = findViewById(R.id.correo);
        contraseña = findViewById(R.id.contraseña);


    }

    public void IniciarSesion(View view) {

        String userCorreo = correo.getText().toString();
        String userContraseña = contraseña.getText().toString();

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

        auth.signInWithEmailAndPassword(userCorreo,userContraseña)
                        .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if (task.isSuccessful()){

                                    Toast.makeText(LoginActivity.this,"Se inicio sesion correctamente", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(LoginActivity.this,MainActivity.class));

                                }else {
                                    Toast.makeText(LoginActivity.this,"Error"+task.getException(), Toast.LENGTH_SHORT).show();
                                }

                            }
                        });

    }



    public void CrearCuenta(View view) {
        startActivity(new Intent(LoginActivity.this,RegistrarActivity.class));
    }
}