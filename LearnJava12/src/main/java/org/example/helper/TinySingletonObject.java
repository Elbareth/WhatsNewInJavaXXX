package org.example.helper;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class TinySingletonObject implements Serializable {

    private static TinySingletonObject singleton;

    private TinySingletonObject()
    {
        System.out.println(hashCode());
    }

    public static TinySingletonObject getInstance()
    {
        if(singleton == null)
        {
            singleton = new TinySingletonObject();
        }
        return singleton;
    }

    //We have to write this method to makes sure we have the same object - it's singleton!!!
    protected Object readResolve() throws ObjectStreamException
    {
        return getInstance();
    }

}
