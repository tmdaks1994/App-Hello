package com.human.edu;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnTel, btnLogout;
    TextView textViewWelcome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //이 문구가 있어야 출력 가능, 화면 렌더링

        Intent intent = new Intent(this.getIntent());
        String userId = intent.getStringExtra("editTextId");
        String userPw = intent.getStringExtra("editTextPassword");
        textViewWelcome = findViewById(R.id.textViewWelcome);
        textViewWelcome.setText(userId+"님 환영합니다!");

        btnLogout = findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(loginIntent);
                finish();
            }
        });
        btnTel = findViewById(R.id.btnTel);
        btnTel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this,"전화 걸기",Toast.LENGTH_LONG).show();
                Intent telIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:010-1111-1111"));
                startActivity(telIntent);
                finish();
                System.exit(0);
            }
        });

    }

    public void goToNaver(View view) {
        //디버그 작동확인,
        //Toast.makeText(getApplicationContext(),"네이버로 이동",Toast.LENGTH_LONG).show();
        Intent naverIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://naver.com"));
        startActivity(naverIntent);
    }
}