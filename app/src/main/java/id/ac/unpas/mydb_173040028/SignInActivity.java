package id.ac.unpas.mydb_173040028;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignInActivity extends AppCompatActivity {
    EditText us;
    EditText pass;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        us = (EditText) findViewById(R.id.username);
        pass = (EditText) findViewById(R.id.password);

        findViewById(R.id.btnSignIn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = us.getText().toString().trim();
                String pas = pass.getText().toString().trim();
                if(user.equalsIgnoreCase("admin") && pas.equalsIgnoreCase("admin")){
                    Session.createSignInSession(SignInActivity.this, user);
                    startActivity(new Intent(new Intent(SignInActivity.this, MainActivity.class)));
                    finish();
                } else {
                    Toast.makeText(SignInActivity.this, "User Invalid", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
