package com.example.mobileapplication;

import android.content.Intent;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.biometric.BiometricPrompt;
import java.util.concurrent.Executor;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.VibrationEffect;
import android.view.View;
import android.os.Vibrator;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.biometric.BiometricPrompt;

public class Login_Activity extends AppCompatActivity {
    MediaPlayer sucess_sound;
    static String enteredUsername;
    static int mainBalance;
    DBHelper dbHelper = new DBHelper(Login_Activity.this);
    private ImageView fingerprintIcon;
    private TextView fingerprintText;
    private Executor executor;
    private BiometricPrompt biometricPrompt;
    private BiometricPrompt.PromptInfo promptInfo;
    Button btn;
    ImageView login;
    public static EditText username, password_field;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btn = findViewById(R.id.login);
        username = findViewById(R.id.username);
        password_field= findViewById(R.id.password_toggle);

        sucess_sound=MediaPlayer.create(Login_Activity.this ,R.raw.success_sound);



//        boolean status = dbHelper.adduser("mostafa" , "12345" , 8000);
//
//        if(status){
//            Toast.makeText(Login_Activity.this , "the user is inserted" , Toast.LENGTH_SHORT).show();
//        } else {
//           Toast.makeText(Login_Activity.this , "the user is not inserted please try again" , Toast.LENGTH_SHORT).show();
//}



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor = dbHelper.getuser(username.getText().toString());

                if (username.getText().toString().isEmpty() || password_field.getText().toString().isEmpty()){
                    Toast.makeText(Login_Activity.this , "The username or/and password/are incorrect" , Toast.LENGTH_SHORT).show();

                }

               else if(cursor.getCount() == 0){
                    Vibrator v1 = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    sucess_sound.start();
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        v1.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE));
                        // Toast.makeText(MainActivity.this , "the user name is empty please try again" , Toast.LENGTH_SHORT).show();
                    } else {

                        v1.vibrate(500);
                    }
                    Toast.makeText(Login_Activity.this , "the user name or/and password is/are incorrect" , Toast.LENGTH_SHORT).show();
                } else {

                    while(cursor.moveToNext()){
                        if(cursor.getString(1).equals(password_field.getText().toString())){

                            Toast.makeText(Login_Activity.this , "Welcome " + username.getText().toString() , Toast.LENGTH_SHORT).show();
                            sucess_sound.start();
                            enteredUsername = username.getText().toString();
                            mainBalance = cursor.getInt(2);
                            Intent intent = new Intent(Login_Activity.this , homepage.class);
                            startActivity(intent);

//                            Intent i = new Intent(Login_Activity.this, homepage.class);
//                            i.putExtra("user_name", username.getText().toString());
//                            startActivity(i);



                        }

                }
            }}
        });



        fingerprintIcon = findViewById(R.id.fingerprintIcon);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            executor = getMainExecutor();
        }

        biometricPrompt = new BiometricPrompt(this, executor, new BiometricPrompt.AuthenticationCallback() {
            @Override
            public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
                Toast.makeText(Login_Activity.this, "Authentication error: " + errString, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
                Toast.makeText(Login_Activity.this, "Authentication succeeded!", Toast.LENGTH_SHORT).show();
                navigateToMainActivity2(); // Navigate to MainActivity2 after successful authentication
            }

            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
                Toast.makeText(Login_Activity.this, "Authentication failed", Toast.LENGTH_SHORT).show();
            }
        });

        promptInfo = new BiometricPrompt.PromptInfo.Builder()
                .setTitle("Fingerprint Authentication")
                .setSubtitle("Please place your finger on the sensor")
                .setNegativeButtonText("Cancel")
                .build();

        fingerprintIcon.setOnClickListener(v -> showBiometricPrompt());


    }


    private void showBiometricPrompt() {
        biometricPrompt.authenticate(promptInfo);
    }

    private void navigateToMainActivity2() {
        Intent i = new Intent(Login_Activity.this, homepage.class);
        i.putExtra("user_name", username.getText().toString());
        startActivity(i);
    }



}