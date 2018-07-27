package com.pracha.orderorganic.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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

public class ForgotPasswordActivity extends BaseActivity implements LoginView {

    LoginDetailsPresenter loginDetailsPresenter;
    @BindView(R.id.email)
    EditText editTextEmail;
    @BindView(R.id.btn_forgot_password)
    Button buttonForgotPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        ButterKnife.bind(this);
        loginDetailsPresenter = new LoginDetailsPresenter();
        loginDetailsPresenter.attachView(this);
    }

    @OnClick({R.id.btn_forgot_password})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_forgot_password:
                if (validateForm()) {
                    if (ConnectionDetector.isConnectedToInternet(this)) {
                        showProgressIndicator(true);
                        loginDetailsPresenter.getForgotPassword(editTextEmail.getText().toString().trim());
                    } else {
                        Utilities.showToastLong(Constants.NO_INTERNET_CONNECTION_TAG, this);
                    }
                }
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
        return valid;
    }


    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void showMessage(int stringId) {
        Utilities.showToastLong(getString(stringId), ForgotPasswordActivity.this);
    }

    @Override
    public void showMessage(String message) {
        Utilities.showToastLong(message, ForgotPasswordActivity.this);
    }

    @Override
    public void loginDetails(LoginSuccess loginSuccess) {

    }

    @Override
    public void registrationDetails(LoginSuccess registrationSuccess) {

    }

    @Override
    public void forgotPasswordDetails(ForResetResponse forResetResponse) {
        if (forResetResponse != null) {
            if (forResetResponse.getStatus() == 1) {
                showMessage(forResetResponse.getMessage());
                Intent intent = new Intent(ForgotPasswordActivity.this, ResetPasswordActivity.class);
                intent.putExtra("cust_id", forResetResponse.getCustomerId());
                startActivity(intent);
            } else {
                showMessage(forResetResponse.getMessage());
            }
        }
    }

    @Override
    public void resetPasswordDetails(ForResetResponse forResetResponse) {

    }
}
