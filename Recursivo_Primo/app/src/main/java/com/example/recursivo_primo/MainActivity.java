package com.example.recursivo_primo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnRevisar;
    EditText txtNumero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        conectar();
        btnRevisar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.valueOf(txtNumero.getText().toString());
                int divisores = primo(a, 1, 0);

                if (divisores == 2){
                    Toast.makeText(getApplicationContext(), "ES PRIMO", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(), "NO ES PRIMO", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void conectar() {
        btnRevisar = findViewById(R.id.btnRevisar);
        txtNumero = findViewById(R.id.txtNumero);
    }

    int primo(int n, int i, int s) {
        if (n == i) {
            return s+1;
        } else if (n % i == 0) {
            s += 1;
            return primo(n, i + 1, s);
        } else {
            return primo(n, i + 1, s);
        }


    }
}

