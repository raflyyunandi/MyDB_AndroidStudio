package id.ac.unpas.mydb_173040028;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreenActivity extends AppCompatActivity {
    @Override
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Thread background = new Thread(){
            public void run(){
                try{
                    sleep(3000);
                    Intent intent = null;
                    SharedPreferences preferences = SplashScreenActivity.this.getSharedPreferences(Session.PREF_NAME,0);
                    try {
                        String id = preferences.getString("username", null);
                        Log.e("username", id);
                        intent = new Intent(SplashScreenActivity.this, MainActivity.class);
                    } catch (Exception e){
                        intent = new Intent(SplashScreenActivity.this, SignInActivity.class);
                    }
                    startActivity(intent);
                    finish();
                } catch (Exception e){

                }
            }
        };
        background.start();
    }
}
