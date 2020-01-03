package com.waysideutilities.mirrarcalculator.data;

import com.waysideutilities.mirrarcalculator.model.Screen2;

public class DataSingletonForScreen2
{
    private Screen2 screen2;
    private static DataSingletonForScreen2 instance;

    public static DataSingletonForScreen2 getInstance()
    {
        if(instance==null)
        {
            instance = new DataSingletonForScreen2();
        }
        return instance;
    }

    public Screen2 getScreen2()
    {
        return screen2;
    }

    public void setScreen2(Screen2 screen2)
    {
        this.screen2 = screen2;
    }

    public void clear()
    {
        instance = null;
    }
}
