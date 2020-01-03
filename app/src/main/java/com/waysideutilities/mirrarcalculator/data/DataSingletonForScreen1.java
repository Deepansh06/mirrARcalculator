package com.waysideutilities.mirrarcalculator.data;

import com.waysideutilities.mirrarcalculator.model.Screen1;

public class DataSingletonForScreen1
{
    private Screen1 screen1;
    private static DataSingletonForScreen1 instance;

    public static DataSingletonForScreen1 getInstance()
    {
        if(instance==null)
        {
            instance = new DataSingletonForScreen1();
        }
        return instance;
    }

    public Screen1 getScreen1()
    {
        return screen1;
    }

    public void setScreen1(Screen1 screen1)
    {
        this.screen1 = screen1;
    }

    public void clear()
    {
        instance = null;
    }
}
