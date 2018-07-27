package com.pracha.orderorganic.views;

import com.pracha.orderorganic.models.models.login.ForResetResponse;
import com.pracha.orderorganic.models.models.login.LoginSuccess;

public interface LoginView extends BaseView {

    void showMessage(int stringId);

    void showMessage(String message);

    void loginDetails(LoginSuccess loginSuccess);

    void registrationDetails(LoginSuccess registrationSuccess);

    void forgotPasswordDetails(ForResetResponse forResetResponse);

    void resetPasswordDetails(ForResetResponse forResetResponse);
}
