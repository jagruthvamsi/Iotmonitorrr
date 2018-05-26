package com.example.rsrahul.loginuserdata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {

    Button loginUser;
    EditText userMail, Userpass;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginUser = findViewById(R.id.button2);
        userMail = findViewById(R.id.mail);
        Userpass = findViewById(R.id.pass);

        ref = FirebaseDatabase.getInstance().getReference("user");


        loginUser.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {


                ref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot ds : dataSnapshot.getChildren()) {
                            UserData udata = ds.getValue(UserData.class);


                            String UserMail = userMail.getText().toString();
                            String userPass = Userpass.getText().toString();

                            String email = udata.getEmail();
                            String pass = udata.getPassword();
                            if (!TextUtils.isEmpty(UserMail) && !TextUtils.isEmpty(userPass)) {
                                if (UserMail.equals(email) && userPass.equals(pass)) {
                                   Intent in=new Intent(getApplicationContext(),AfterLogin.class);
                                   in.putExtra("user",UserMail);
                                   startActivity(in);



                                } else {
                                   // Toast.makeText(getApplicationContext(), "either email or password is wrong", Toast.LENGTH_LONG).show();
                                }


                            } else {
                             // Toast.makeText(getApplicationContext(), "all fields are manadatory", Toast.LENGTH_LONG).show();
                            }
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });


            }


        });
    }
}
