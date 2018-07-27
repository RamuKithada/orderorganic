package com.pracha.orderorganic.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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


public class SignUpActivity extends BaseActivity implements LoginView {

    LoginDetailsPresenter loginDetailsPresenter;
    MySharedPreference mySharedPreference;

    @BindView(R.id.user_name)
    EditText editTextEmail;
    @BindView(R.id.password)
    EditText editTextPassword;
    @BindView(R.id.skipSingup)
    TextView textViewSkipSignIn;
    @BindView(R.id.btnRegister)
    Button buttonSignUP;
    @BindView(R.id.tvClickHereSignUp)
    TextView textViewClickHere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);
        loginDetailsPresenter = new LoginDetailsPresenter();
        loginDetailsPresenter.attachView(this);
        mySharedPreference = new MySharedPreference(getApplicationContext());
    }


    @OnClick({R.id.skipSingup, R.id.btnRegister, R.id.tvClickHereSignUp})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.skipSingup:
                startActivity(new Intent(SignUpActivity.this, MainActivity.class));
                break;
            case R.id.btnRegister:
                if (validateForm()) {
                    if (ConnectionDetector.isConnectedToInternet(this)) {
                        showProgressIndicator(true);
                        loginDetailsPresenter.getRegistrationDetails(editTextEmail.getText().toString().trim(), editTextPassword.getText().toString().trim());
                    } else {
                        Utilities.showToastLong(Constants.NO_INTERNET_CONNECTION_TAG, this);
                    }
                }

                break;
            case R.id.tvClickHereSignUp:
                startActivity(new Intent(SignUpActivity.this, SigninActivity.class));
                break;
        }
    }

    private Boolean validateForm() {
        Boolean valid = true;

        String username = editTextEmail.getText().toString();
        if (TextUtils.isEmpty(username)) {
            editTextEmail.setError("Enter Email or Mobile Number");
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
        Utilities.showToastLong(getString(stringId), SignUpActivity.this);
    }

    @Override
    public void showMessage(String message) {
        Utilities.showToastLong(message, SignUpActivity.this);
    }

    @Override
    public void loginDetails(LoginSuccess loginSuccess) {

    }

    @Override
    public void registrationDetails(LoginSuccess registrationSuccess) {
        if (registrationSuccess != null) {
            if (registrationSuccess.getStatus() == 1) {
                showMessage(registrationSuccess.getMessage());
                startActivity(new Intent(SignUpActivity.this,SigninActivity.class));
            } else {
                showMessage(registrationSuccess.getMessage());
            }
        }
    }

    @Override
    public void forgotPasswordDetails(ForResetResponse forResetResponse) {

    }

    @Override
    public void resetPasswordDetails(ForResetResponse forResetResponse) {

    }
}
