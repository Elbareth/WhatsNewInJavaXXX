package org.example.services;

import javax.security.auth.Subject;
import javax.security.auth.callback.*;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;

public class JAASLoginModule implements LoginModule {
    private final static String USERNAME = "username";
    private final static String PASSWORD = "password";
    private CallbackHandler callbackHandler = null;

    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, ?> sharedState, Map<String, ?> options) {
        this.callbackHandler = callbackHandler;
    }

    @Override
    public boolean login() throws LoginException {
        Callback[] callbacks = new Callback[2];
        callbacks[0] = new NameCallback("Username: ");
        callbacks[1] = new PasswordCallback("Password: ", false);
        try {
            callbackHandler.handle(callbacks);
        } catch (IOException | UnsupportedCallbackException e) {
            e.printStackTrace();
        }
        String name = ((NameCallback)callbacks[0]).getName();
        String password = new String(((PasswordCallback)callbacks[1]).getPassword());
        return Objects.equals(name, USERNAME) && password.equals(PASSWORD);
    }

    @Override
    public boolean commit() throws LoginException {
        return false;
    }

    @Override
    public boolean abort() throws LoginException {
        return false;
    }

    @Override
    public boolean logout() throws LoginException {
        return false;
    }
}
