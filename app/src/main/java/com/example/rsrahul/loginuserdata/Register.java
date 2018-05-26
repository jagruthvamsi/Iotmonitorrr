package com.example.rsrahul.loginuserdata;

import android.*;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Register extends AppCompatActivity  {


    TextView username,email,password,age;
    DatabaseReference ref;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);




        ref = FirebaseDatabase.getInstance().getReference("user");
        submit=findViewById(R.id.submit);

        username=findViewById(R.id.username);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        age=findViewById(R.id.age);





        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                addData();

            }
        });
    }

    public void addData(){

        String UserName=username.getText().toString();
        String age1= age.getText().toString();
        String mail=email.getText().toString();
        String Pass= password.getText().toString();

        UserData data1=new UserData();
        data1.setEmail(mail);
        data1.setPassword(Pass);



        if(!TextUtils.isEmpty(UserName) && !TextUtils.isEmpty(age1) && !TextUtils.isEmpty(mail) && !TextUtils.isEmpty(Pass)){

            String id=ref.push().getKey();
            UserData data= new UserData(id,UserName,age1,mail,Pass);
            ref.child(id).setValue(data);

            Toast.makeText(getApplicationContext(),"Data added Successfully",Toast.LENGTH_LONG).show();

            username.setText("");
            age.setText("");
            email.setText("");
            password.setText("");


            startActivity(new Intent(getApplicationContext(),MainActivity.class));
        }
        else {
            Toast.makeText(getApplicationContext(),"All fields are manadatory",Toast.LENGTH_LONG).show();
        }

    }


}
