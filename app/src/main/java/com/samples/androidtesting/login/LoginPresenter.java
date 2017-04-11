package com.samples.androidtesting.login;

import android.support.annotation.NonNull;

class LoginPresenter implements LoginContract.Presenter {

    private LoginContract.View view;

    LoginPresenter(LoginContract.View view) {
        this.view = view;
    }

    @Override
    public void login(@NonNull String name, @NonNull String email) {
        if (name.isEmpty()) {
            view.showErrorWhenNameIsEmpty();
        } else if (email.isEmpty()) {
            view.showErrorWhenEmailIsEmpty();
        } else {
            view.launchWelcomeScreen();
        }
    }
}
