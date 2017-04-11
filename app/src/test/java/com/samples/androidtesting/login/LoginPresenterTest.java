package com.samples.androidtesting.login;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@RunWith(PowerMockRunner.class)
public class LoginPresenterTest {

    @Mock
    private LoginContract.View view;
    private LoginContract.Presenter presenter;

    @Before
    public void initialize() {
        MockitoAnnotations.initMocks(this);
        presenter = new LoginPresenter(view);
    }

    @Test
    public void testLoginWhenNameIsEmpty_showError() {
        presenter.login("", "support@sample.com");

        verify(view).showErrorWhenNameIsEmpty();
        verify(view, never()).launchWelcomeScreen();
    }

    @Test
    public void testLoginWhenEmailIsEmpty_showError() {
        presenter.login("Sample", "");

        verify(view).showErrorWhenEmailIsEmpty();
        verify(view, never()).launchWelcomeScreen();
    }

    @Test
    public void testLoginWhenNameAndEmailAreFilled_launchWelcomeScreen() {
        presenter.login("Sample", "support@sample.com");

        verify(view).launchWelcomeScreen();
    }
}