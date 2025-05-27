package org.example.services;

import org.example.callbacks.JAASCallbackHandler;

import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;

public class JAASService
{
    public void run() throws LoginException {
        //We set the information, where the file with permission properties exist
        System.setProperty("java.security.auth.login.config", "jaas.config");
        LoginContext loginContext = new LoginContext("NAME_OF_PERMISSION", new JAASCallbackHandler());
        //The user log in
        loginContext.login();
        //Then the user can log out
        loginContext.logout();
    }
}
