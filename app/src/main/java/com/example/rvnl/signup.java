package com.example.rvnl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signup extends AppCompatActivity {

    EditText Name,Email,Pass;
    Button   REGbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Name = findViewById(R.id.name);
        Email= findViewById(R.id.email);
        Pass = findViewById(R.id.pass);
        REGbtn= findViewById(R.id.b1);

        // Register Button OnClickListner
        REGbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=Name.getText().toString();
                String email=Email.getText().toString();
                String password=Pass.getText().toString();


                // Function for validateinfo and pass all parameter

                boolean check = Validateinfo(name,email,password);
                if(check==true)
                {
                    Intent intent = new Intent(signup.this, home.class);
                    startActivity(intent);
                    finish();
                    Toast.makeText(getApplicationContext(),"REGISTERD",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"INVALID",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Validateinfo function
    private Boolean Validateinfo(String name,String email,String password)
    {
        if(name.length()==0)
        {
            Name.requestFocus();
            Name.setError("Field cannot be empty");
            return false;
        }
        else if (!name.matches("[a-z A-Z]+"))
        {
            Name.requestFocus();
            Name.setError("Enter only alphabetical character");
            return false;

        }
        else if(email.length()==0)
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

//    public void signup2(View v){
//        Intent intent = new Intent(this, home.class);
//        startActivity(intent);
//        finish();
//    }

    public void signin1(View v)
    {
        Intent intent = new Intent(this, login.class);
        startActivity(intent);
        finish();
    }
}