package com.example.rvnl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {

    EditText Email,Pass;
    Button Loginbtn;
    CheckBox checkbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Email= findViewById(R.id.email);
        Pass = findViewById(R.id.pass);
        Loginbtn =findViewById(R.id.b1);
        checkbtn=findViewById(R.id.checkbtn);

        // CheckBox function to show and hide the password
        checkbtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    Pass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
                else
                {
                    Pass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });

        // Login Button OnClickListner
        Loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=Email.getText().toString();
                String password=Pass.getText().toString();

                // Function for validateinfo and pass all parameter

               boolean check = Validateinfo(email,password);
               if(check==true)
               {
                   Intent intent = new Intent(login.this, home.class);
                   startActivity(intent);
                   finish();
                   Toast.makeText(getApplicationContext(),"LOGIN",Toast.LENGTH_SHORT).show();
               }
               else
               {
                   Toast.makeText(getApplicationContext(),"INVALID",Toast.LENGTH_SHORT).show();
               }

            }
        });
    }

    // Validateinfo function
    private Boolean Validateinfo(String email,String password)
    {
        if(email.length()==0)
        {
            Email.requestFocus();
            Email.setError("Field cannot be empty");
            return false;
        }
        else if (!email.matches("[a-zA-Z0-9_-]+@[a-z]+\\.+[a-z]+"))
        {

            Email.requestFocus();
            Email.setError("Enter valid email");
            return false;

        }
        else if(password.length()<8)
        {
            Pass.requestFocus();
            Pass.setError("Minimum 8 character required");
            return false;
        }
        else {
            return true;
        }
    }



//    public void sign(View v){
//      Intent intent = new Intent(this, home.class);
//      startActivity(intent);
//      finish();
//    }
    public void signup1(View v){
        Intent intent = new Intent(this, signup.class);
        startActivity(intent);
        finish();
    }
}