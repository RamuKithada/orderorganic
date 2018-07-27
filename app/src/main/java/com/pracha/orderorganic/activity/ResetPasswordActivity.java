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

public class ResetPasswordActivity extends BaseActivity implements LoginView {

    LoginDetailsPresenter loginDetailsPresenter;
    @BindView(R.id.otp)
    EditText editOtp;
    @BindView(R.id.new_password)
    EditText editNewPassword;
    @BindView(R.id.confirm_password)
    EditText editConPassword;
    @BindView(R.id.btn_forgot_password)
    Button buttonForgotPass;
    @BindView(R.id.resend_otp)
    TextView resend_otp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        ButterKnife.bind(this);
        loginDetailsPresenter = new LoginDetailsPresenter();
        loginDetailsPresenter.attachView(this);
    }


    @OnClick({R.id.btn_reset_password})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_reset_password:
                if (validateForm()) {
                    if (ConnectionDetector.isConnectedToInternet(this)) {
                        showProgressIndicator(true);
                        String cust_id = getIntent().getStringExtra("cust_id");
                        loginDetailsPresenter.getResetPassword(cust_id,resend_otp.getText().toString().trim(),editConPassword.getText().toString().trim());
                    } else {
                        Utilities.showToastLong(Constants.NO_INTERNET_CONNECTION_TAG, this);
                    }
                }
                break;

        }
    }


    private Boolean validateForm() {
        Boolean valid = true;

        String username = editNewPassword.getText().toString();
        if (TextUtils.isEmpty(username)) {
            editNewPassword.setError("Enter New Password");
            editNewPassword.requestFocus();
            valid = false;
        } else {
            editNewPassword.setError(null);
        }
        String password = editConPassword.getText().toString();
        if (TextUtils.isEmpty(password)) {
            editConPassword.setError("Enter Confirm Password");
            editConPassword.requestFocus();
            valid = false;
        } else {
            editConPassword.setError(null);
        }
        String otp = editOtp.getText().toString();
        if (TextUtils.isEmpty(otp)) {
            editOtp.setError("Enter Confirm Password");
            editOtp.requestFocus();
            valid = false;
        } else {
            editOtp.setError(null);
        }

        if(!username.equals(password)){
            showMessage("Password Not Macth");
            valid = false;
        }
        return valid;
    }
    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void showMessage(int stringId) {
        Utilities.showToastLong(getString(stringId),ResetPasswordActivity.this);
    }

    @Override
    public void showMessage(String message) {
        Utilities.showToastLong(message,ResetPasswordActivity.this);
    }

    @Override
    public void loginDetails(LoginSuccess loginSuccess) {

    }

    @Override
    public void registrationDetails(LoginSuccess registrationSuccess) {

    }

    @Override
    public void forgotPasswordDetails(ForResetResponse forResetResponse) {

    }

    @Override
    public void resetPasswordDetails(ForResetResponse forResetResponse) {
        if(forResetResponse!=null){
            if(forResetResponse.getStatus()==1){
                showMessage(forResetResponse.getMessage());
                startActivity(new Intent(ResetPasswordActivity.this,SigninActivity.class));
                finish();
            } else {
                showMessage(forResetResponse.getMessage());
            }
        }
    }
}
