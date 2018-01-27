package com.example.paulo.myapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.paulo.myapplication.web.UserService;

import java.io.IOException;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{

    private Button buttonLogin;
    private EditText email, password;
    private final String URL_API = "http://private-c9c06-helloandroid.apiary-mock.com";
    private String id, name;
    private ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("LIFECYCLE", "ON CREATE");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUi();

    }

    public void initUi(){
        this.buttonLogin = (Button) findViewById(R.id.btnLogin);
        this.email = (EditText) findViewById(R.id.email);
        this.password = (EditText) findViewById(R.id.password);

        this.buttonLogin.setOnClickListener(this);
    }

    private Boolean isEmailValid(EditText email){
        return email.getText().toString().equals("teste");
    }
    private Boolean isEmailInvalid(EditText email){
        return !email.getText().toString().equals("teste");
    }
    private Boolean isPasswordValid(EditText password){
        return password.getText().toString().equals("teste");
    }
    private Boolean isPasswordInvalid(EditText password){
        return !password.getText().toString().equals("teste");
    }

    private void logIn(){
    UserService userService = new UserService();
    userService.execute("example");
        //hideDialog();
        //startActivity(new Intent(this, LoggedActivity.class));
    }



    @Override
    public void onClick(View v) {
        //showDialog();
        if(isEmailValid(email) && isPasswordValid(password)){
            logIn();
        } else {
            hideDialog();
            if(isEmailInvalid(email)){
                email.setError("The account is incorrect");
            }
            if(isPasswordInvalid(password)){
                password.setError("The password is incorrect");
            }
        }
    }

    public void showDialog(){
        pd = new ProgressDialog(this);
        pd.setMessage("Loading");
        pd.show();
    }

    public void hideDialog(){
        pd.hide();
    }
}
