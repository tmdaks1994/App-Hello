package com.human.edu;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

import core.AsyncResponse;
import core.PostResponseAsyncTask;

public class LoginActivity extends AppCompatActivity {
    Button btnLogin;
    EditText editTextID, editTextPassword;
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
        editTextID = findViewById(R.id.editTextID);
        editTextPassword = findViewById(R.id.editTextPassword);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //스프링으로 보낼 데이터를 해시맵 타입을 저장
                HashMap postDataParams = new HashMap();
                postDataParams.put("txtUsername",editTextID.getText().toString());
                postDataParams.put("txtPassword",editTextPassword.getText().toString());
                //스프링 앱주소 지정
                String requestUrl = "http://192.168.25.14:8080/android/login";
                //jsp의 Ajax와 같은 역할의 AsyncTask 클래스 사용
                PostResponseAsyncTask readTask = new PostResponseAsyncTask(LoginActivity.this, postDataParams, new AsyncResponse(){

                    @Override
                    public void processFinish(String output) {
                        Toast.makeText(LoginActivity.this, output+"디버그",Toast.LENGTH_SHORT).show();
                        String jsonString = output.substring(output.indexOf('{'),output.indexOf('}'));
                        if(!jsonString.equals("{}")){
                            Log.i("디버그",jsonString);
                        }else{
                            Toast.makeText(LoginActivity.this, "로그인 실패",Toast.LENGTH_LONG).show();
                        }
                    }
                });
                readTask.execute(requestUrl);
                /*
                //Intent는 안드로이드맵에서 액티비티간 데이터를 전송하는 클래스
                Intent mainIntent = new Intent(LoginActivity.this, MainActivity.class);
                mainIntent.putExtra("editTextId", editTextID.getText().toString());
                mainIntent.putExtra("editTextPassword", editTextPassword.getText().toString());
                startActivity(mainIntent);
                */
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