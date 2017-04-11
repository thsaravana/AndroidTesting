package com.samples.androidtesting.login;

import android.support.annotation.NonNull;

interface LoginContract {

    interface View {
        void launchWelcomeScreen();

        void showErrorWhenNameIsEmpty();

        void showErrorWhenEmailIsEmpty();
    }

    interface Presenter {
        void login(@NonNull String name, @NonNull String email);
    }
}
