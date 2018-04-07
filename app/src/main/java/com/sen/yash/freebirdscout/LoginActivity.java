package com.sen.yash.freebirdscout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Button btn_login,btn_register;
    EditText txt_email, txt_pwd;

    UserDBHandler userDBHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        userDBHandler = new UserDBHandler(this.getApplicationContext(), null, null, 1);
        fillScreen();

        txt_email = findViewById(R.id.email);
        txt_pwd = findViewById(R.id.password);
        btn_login = findViewById(R.id.email_sign_in_button);
        btn_register = findViewById(R.id.email_register_button);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str_email = txt_email.getText().toString();
                String str_pwd = txt_pwd.getText().toString();

                if(str_email.length()==0)
                    Toast.makeText(LoginActivity.this, "Enter email-ID", Toast.LENGTH_SHORT).show();
                else if(str_pwd.length()==0)
                    Toast.makeText(LoginActivity.this, "Enter password", Toast.LENGTH_SHORT).show();
                else{
                    boolean is_success = userDBHandler.checkEntry(str_email);

                    Log.d("mytag","value: "+is_success);

                    if(is_success){
                        Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    }
                    else
                        Toast.makeText(LoginActivity.this, "It seems you haven't registered yet!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putBundle("userDB", UserDBHandler);
                Intent intent = new Intent(LoginActivity.this,Register.class);
                startActivity(intent);
            }
        });
    }

    private void fillScreen(){
        TextView screen = findViewById(R.id.text_screen);
        screen.setText(userDBHandler.databaseToString());
    }
}
