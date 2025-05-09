package com.example.utspemogramanmobile1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText etUsername = findViewById(R.id.etUsername);
        EditText etPassword = findViewById(R.id.etPassword);
        Button btnLogin = findViewById(R.id.btnLogin);
        Button btnToRegister = findViewById(R.id.btnToRegister);

        // Login button click
        btnLogin.setOnClickListener(v -> {
            String username = etUsername.getText().toString();
            String password = etPassword.getText().toString();

            // Cek jika username atau password kosong
            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Username dan Password tidak boleh kosong", Toast.LENGTH_SHORT).show();
                return;
            }

            // Cek apakah username dan password cocok dengan data yang sudah disimpan
            SharedPreferences sharedPref = getSharedPreferences("UserPrefs", MODE_PRIVATE);
            String savedUsername = sharedPref.getString("username", null);
            String savedPassword = sharedPref.getString("password", null);

            // Jika username dan password tidak cocok, tampilkan toast
            if (savedUsername == null || savedPassword == null) {
                Toast.makeText(this, "Anda belum terdaftar, silakan daftar terlebih dahulu!", Toast.LENGTH_LONG).show();
                return;
            }

            // Jika username dan password cocok, login berhasil dan lanjut ke Dashboard
            if (username.equals(savedUsername) && password.equals(savedPassword)) {
                Toast.makeText(this, "Login berhasil", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, DashBoardActivity.class));
                finish(); // Mengakhiri LoginActivity agar tidak kembali ke layar login
            } else {
                Toast.makeText(this, "Username atau Password salah", Toast.LENGTH_SHORT).show();
            }
        });

        // Register button click
        btnToRegister.setOnClickListener(v -> {
            // Arahkan ke activity register jika belum terdaftar
            startActivity(new Intent(this, RegisterActivity.class));
        });
    }
}