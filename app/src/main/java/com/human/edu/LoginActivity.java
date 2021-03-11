package com.human.edu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    Button btnLogin;

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(LoginActivity.this,"oncDestroy상태",Toast.LENGTH_LONG).show();
    }
    @Override
    public void onStop() {
        super.onStop();
        Toast.makeText(LoginActivity.this,"oncStop상태",Toast.LENGTH_LONG).show();
    }
    @Override
    public void onPause() {
        super.onPause();
        Toast.makeText(LoginActivity.this,"oncPause상태",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onResume() {
        super.onResume();
        Toast.makeText(LoginActivity.this,"oncResume상태",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onStart() {
        super.onStart();
        Toast.makeText(LoginActivity.this,"oncStart상태",Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Toast.makeText(LoginActivity.this,"onCreate상태",Toast.LENGTH_LONG).show();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editTextID, editTextPassword;
                editTextID = findViewById(R.id.editTextID);
                editTextPassword = findViewById(R.id.editTextPassword);
                Intent mainIntent = new Intent(LoginActivity.this, MainActivity.class);
                mainIntent.putExtra("editTextId", editTextID.getText().toString());
                mainIntent.putExtra("editTextPassword", editTextPassword.getText().toString());
                startActivity(mainIntent);
            }
        });
    }

    //login.xml에서 onclick 속성을 gotomain이라고 지정했을때 사용가능
    public void gotoMain(View view) {
        EditText editTextID, editTextPassword;
        editTextID = findViewById(R.id.editTextID);
        editTextPassword = findViewById(R.id.editTextPassword);
        //Toast.makeText(LoginActivity.this, "로그인 성공!" + editTextID.getText(), Toast.LENGTH_LONG).show();
        //로그인 버튼 클릭
        Intent mainIntent = new Intent(LoginActivity.this, MainActivity.class);
        mainIntent.putExtra("editTextID", editTextID.getText().toString());
        mainIntent.putExtra("editTextPassword", editTextPassword.getText().toString());
        startActivity(mainIntent); //편지봉투 Intent를 개봉 = 화면불러오기
        finish(); //로그인 화면 종료
    }
}