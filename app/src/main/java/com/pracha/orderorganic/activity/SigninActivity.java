package com.pracha.orderorganic.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.pracha.orderorganic.R;
import com.pracha.orderorganic.database.MySharedPreference;
import com.pracha.orderorganic.models.models.login.ForResetResponse;
import com.pracha.orderorganic.models.models.login.LoginSuccess;
import com.pracha.orderorganic.presenters.LoginDetailsPresenter;
import com.pracha.orderorganic.utils.ConnectionDetector;
import com.pracha.orderorganic.utils.Constants;
import com.pracha.orderorganic.utils.Utilities;
import com.pracha.orderorganic.views.LoginView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class SigninActivity extends BaseActivity implements LoginView{

    LoginDetailsPresenter loginDetailsPresenter;
    MySharedPreference mySharedPreference;

    @BindView(R.id.email)
    EditText editTextEmail;
    @BindView(R.id.password)
    EditText editTextPassword;
    @BindView(R.id.skipSignIn)
    TextView textViewSkipSignIn;
    @BindView(R.id.btn_signin)
    Button buttonSignIn;
    @BindView(R.id.tvClickHereSignIn)
    TextView textViewClickHere;
    @BindView(R.id.forgot_password)
    TextView textViewForgotPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        ButterKnife.bind(this);
        loginDetailsPresenter = new LoginDetailsPresenter();
        loginDetailsPresenter.attachView(this);
        mySharedPreference = new MySharedPreference(getApplicationContext());
    }

    @OnClick({R.id.skipSignIn,R.id.btn_signin,R.id.tvClickHereSignIn,R.id.forgot_password})
    public void onViewClicked(View view){
        switch (view.getId()){
            case R.id.skipSignIn:
                startActivity(new Intent(SigninActivity.this,MainActivity.class));
                break;
            case R.id.btn_signin:
                if(validateForm()){
                    if (ConnectionDetector.isConnectedToInternet(this)) {
                        showProgressIndicator(true);
                        loginDetailsPresenter.getLoginDetails(editTextEmail.getText().toString().trim(),editTextPassword.getText().toString().trim());
                    } else {
                        Utilities.showToastLong(Constants.NO_INTERNET_CONNECTION_TAG, this);
                    }
                }

                break;
            case R.id.tvClickHereSignIn:
                startActivity(new Intent(SigninActivity.this,SignUpActivity.class));
                break;
            case R.id.forgot_password:

                break;
        }
    }

    private Boolean validateForm() {
        Boolean valid = true;

        String username = editTextEmail.getText().toString();
        if (TextUtils.isEmpty(username)) {
            editTextEmail.setError("Enter Mobile Number");
            editTextEmail.requestFocus();
            valid = false;
        } else {
            editTextEmail.setError(null);
        }
        String password = editTextPassword.getText().toString();
        if (TextUtils.isEmpty(password)) {
            editTextPassword.setError("Enter Password");
            editTextPassword.requestFocus();
            valid = false;
        } else {
            editTextPassword.setError(null);
        }
        return valid;
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void showMessage(int stringId) {
        Utilities.showToastLong(getString(stringId),SigninActivity.this);
    }

    @Override
    public void showMessage(String message) {
        Utilities.showToastLong(message,SigninActivity.this);
    }

    @Override
    public void loginDetails(LoginSuccess loginSuccess) {
        if(loginSuccess!=null){
            if(loginSuccess.getStatus()==1){
                showMessage(loginSuccess.getMessage());
            } else {
                showMessage(loginSuccess.getMessage());
            }
        }
    }

    @Override
    public void registrationDetails(LoginSuccess registrationSuccess) {

    }

    @Override
    public void forgotPasswordDetails(ForResetResponse forResetResponse) {

    }

    @Override
    public void resetPasswordDetails(ForResetResponse forResetResponse) {

    }
}
