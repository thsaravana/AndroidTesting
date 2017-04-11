package com.samples.androidtesting.login;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.samples.androidtesting.R;
import com.samples.androidtesting.WelcomeActivity;

public class LoginFragment extends Fragment implements LoginContract.View, View.OnClickListener {

    private LoginContract.Presenter presenter;
    private EditText name;
    private EditText email;
    private Button loginButton;

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        presenter = new LoginPresenter(this);

        final View view = getView();
        if (view != null) {
            initializeViews(view);
            setListeners();
        }
    }

    private void initializeViews(@NonNull View view) {
        name = (EditText) view.findViewById(R.id.name);
        email = (EditText) view.findViewById(R.id.email);
        loginButton = (Button) view.findViewById(R.id.login);
    }

    private void setListeners() {
        loginButton.setOnClickListener(this);
    }

    @Override
    public void launchWelcomeScreen() {
        final Intent intent = new Intent(getActivity(), WelcomeActivity.class);
        startActivity(intent);
    }

    @Override
    public void showErrorWhenNameIsEmpty() {
        showError("Name is empty");
    }

    private void showError(@NonNull String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showErrorWhenEmailIsEmpty() {
        showError("Email is empty");
    }

    @Override
    public void onClick(View v) {
        final int id = v.getId();
        if (id == R.id.login) {
            presenter.login(name.getText().toString(), email.getText().toString());
        }
    }
}
