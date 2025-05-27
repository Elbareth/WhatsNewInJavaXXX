package org.example.callbacks;

import javax.security.auth.callback.*;
import java.io.IOException;
import java.util.Scanner;

public class JAASCallbackHandler implements CallbackHandler {
    @Override
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        NameCallback nameCallback = null;
        PasswordCallback passwordCallback = null;
        for(int i = 0; i < callbacks.length; i++)
        {
            if(callbacks[i] instanceof NameCallback)
            {
                nameCallback = (NameCallback) callbacks[i];
                System.out.println(nameCallback.getPrompt());
                nameCallback.setName(String.valueOf(new Scanner(System.in)));
            }
            if(callbacks[i] instanceof PasswordCallback)
            {
                passwordCallback = (PasswordCallback) callbacks[i];
                System.out.println(passwordCallback.getPrompt());
                passwordCallback.setPassword(String.valueOf(new Scanner(System.in)).toCharArray());
            }
        }
    }
}
