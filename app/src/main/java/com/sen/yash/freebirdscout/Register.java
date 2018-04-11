package com.sen.yash.freebirdscout;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sen.yash.freebirdscout.Databases.UserDBHandler;

public class Register extends AppCompatActivity {

    EditText txt_email,txt_pwd,txt_confirmpwd, txt_name;
    Button btn_register;

    UserDBHandler userDBHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            userDBHandler = (UserDBHandler) bundle.get("userDB");
        }

        txt_email = (EditText)findViewById(R.id.email);
        txt_pwd = (EditText)findViewById(R.id.password);
        txt_confirmpwd = (EditText)findViewById(R.id.confirm_password);
        txt_name = (EditText)findViewById(R.id.name);
        btn_register = (Button)findViewById(R.id.email_register_button);

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str_email = txt_email.getText().toString();
                String str_pwd = txt_pwd.getText().toString();
                String str_confirmpwd = txt_confirmpwd.getText().toString();
                String str_name = txt_name.getText().toString();

                if(!str_pwd.equals(str_confirmpwd)){
                    Toast.makeText(Register.this, "Please enter equal passwords", Toast.LENGTH_SHORT).show();
                    txt_confirmpwd.setText("");
                }
                else{
                    Toast.makeText(Register.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                    Bundle bundle = new Bundle();
                    bundle.putString("email",str_email);
                    bundle.putString("pwd",str_pwd);
                    bundle.putString("name",str_name);
                    Intent intent = new Intent(Register.this,LoginActivity.class);
                    intent.putExtra("yash",bundle);
                    startActivity(intent);
                }
            }
        });

    }
}

