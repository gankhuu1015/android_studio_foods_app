package com.example.orderfood_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.orderfood_app.Common.Common;
import com.example.orderfood_app.model.Users;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

public class SignIn extends AppCompatActivity {
    EditText edtPhone,edtPassword;
    Button btnSignIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        edtPassword = (MaterialEditText)findViewById(R.id.edtPassword);
        edtPhone = (MaterialEditText)findViewById(R.id.edtPhone);
        btnSignIn = (Button)findViewById(R.id.btnSignIn);

        // database buyu firebase холбох
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("Users");

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog mDiadlog = new ProgressDialog(SignIn.this);
                mDiadlog.setMessage("Түр хүлээнэ үү....");
                mDiadlog.show();

                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        if(snapshot.child(edtPhone.getText().toString()).exists())
                        {
                            // user Хүстэгтээс хэрэглэгчийн мэдээлэл авах
                             mDiadlog.dismiss();
                            Users user = snapshot.child(edtPhone.getText().toString()).getValue(Users.class);
                            if (user.getPassword().equals(edtPassword.getText().toString())) {
                                {
                                    Intent homeIntent = new Intent(SignIn.this,Home.class);
                                    Common.currentUser = user;
                                    startActivity(homeIntent);
                                    finish();
                                }
                              /*  Toast.makeText(SignIn.this, "амжилттай нэвтрэх", Toast.LENGTH_SHORT).show();*/
                            } else {
                                Toast.makeText(SignIn.this, "Нууц үг буруу байна ! ! ! !", Toast.LENGTH_SHORT).show();
                            }
                    }
                        else
                        {
                            mDiadlog.dismiss();
                            Toast.makeText(SignIn.this, "хэрэглэгчийн мэдээлэл алга", Toast.LENGTH_SHORT).show();
                        }

                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
    }
}