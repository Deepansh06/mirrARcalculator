package com.waysideutilities.mirrarcalculator.viewmodel;

import android.view.View;
import android.widget.SeekBar;

import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.waysideutilities.mirrarcalculator.model.Screen1;

public class Screen1ViewModel extends ViewModel
{
    public MutableLiveData<String> total_amount = new MutableLiveData<>();

    public MutableLiveData<Boolean> cb_9_7 = new MutableLiveData<>();
    public MutableLiveData<Boolean> cb_10_2 = new MutableLiveData<>();
    public MutableLiveData<Boolean> cb_10_5 = new MutableLiveData<>();
    public MutableLiveData<Boolean> cb_11 = new MutableLiveData<>();
    public MutableLiveData<Boolean> cb_12_9 = new MutableLiveData<>();

    public MutableLiveData<Boolean> cb_table = new MutableLiveData<>();
    public MutableLiveData<Boolean> cb_kiosk = new MutableLiveData<>();

    public MutableLiveData<Boolean> cb_mi = new MutableLiveData<>();
    public MutableLiveData<Boolean> cb_samsung = new MutableLiveData<>();

    public MutableLiveData<Boolean> cb_38000 = new MutableLiveData<>();
    public MutableLiveData<Boolean> cb_70000 = new MutableLiveData<>();

    public ObservableField<String> seekBarValue = new ObservableField<>("");

    private MutableLiveData<Screen1> screen1MutableLiveData;

    private String ipad = null;
    private String stand = null;
    private String tv = null;
    private String mac_mini = null;
    private String seek_bar_val = null;

    private int total = 0;
    private int ipad_am = 0;
    private int stand_am = 0;
    private int tv_am = 0;
    private int mac_mini_am = 0;
    private int seek_bar_am = 0;

    public MutableLiveData<Screen1> getScreen1()
    {
        if (screen1MutableLiveData == null)
        {
            screen1MutableLiveData = new MutableLiveData<>();
        }
        return screen1MutableLiveData;
    }

    public void onClick(View view)
    {
        Screen1 screen1 = new Screen1(ipad,stand,tv,mac_mini,seek_bar_val);
        screen1MutableLiveData.setValue(screen1);
    }

    public void onClickCB_9_7()
    {
        cb_10_2.setValue(false);
        cb_10_5.setValue(false);
        cb_11.setValue(false);
        cb_12_9.setValue(false);
        ipad = "9.7\"";
        ipad_am = 28000;

        total = ipad_am+stand_am+tv_am+mac_mini_am+seek_bar_am;
        total_amount.setValue("Rs."+total);

    }
    public void onClickCB_10_2()
    {
        cb_9_7.setValue(false);
        cb_10_5.setValue(false);
        cb_11.setValue(false);
        cb_12_9.setValue(false);
        ipad = "10.2\"";
        ipad_am = 30000;
        total = ipad_am+stand_am+tv_am+mac_mini_am+seek_bar_am;
        total_amount.setValue("Rs."+total);
    }
    public void onClickCB_10_5()
    {
        cb_9_7.setValue(false);
        cb_10_2.setValue(false);
        cb_11.setValue(false);
        cb_12_9.setValue(false);
        ipad = "10.5\"";
        ipad_am = 55000;
        total = ipad_am+stand_am+tv_am+mac_mini_am+seek_bar_am;
        total_amount.setValue("Rs."+total);
    }
    public void onClickCB_11()
    {
        cb_9_7.setValue(false);
        cb_10_2.setValue(false);
        cb_10_5.setValue(false);
        cb_12_9.setValue(false);
        ipad = "11\"";
        ipad_am = 68000;
        total = ipad_am+stand_am+tv_am+mac_mini_am+seek_bar_am;
        total_amount.setValue("Rs."+total);
    }
    public void onClickCB_12_9()
    {
        cb_9_7.setValue(false);
        cb_10_2.setValue(false);
        cb_10_5.setValue(false);
        cb_11.setValue(false);
        ipad = "12.9\"";
        ipad_am = 90000;
        total = ipad_am+stand_am+tv_am+mac_mini_am+seek_bar_am;
        total_amount.setValue("Rs."+total);
    }

    public void onClickCB_Table()
    {
        cb_kiosk.setValue(false);
        stand = "Table Top";
        stand_am = 6000;
        total = ipad_am+stand_am+tv_am+mac_mini_am+seek_bar_am;
        total_amount.setValue("Rs."+total);
    }
    public void onClickCB_Kiosk()
    {
        cb_table.setValue(false);
        stand = "5\" Kiosk";
        stand_am = 10000;
        total = ipad_am+stand_am+tv_am+mac_mini_am+seek_bar_am;
        total_amount.setValue("Rs."+total);
    }

    public void onClickCB_Mi()
    {
        cb_samsung.setValue(false);
        tv = "Mi 50\"";
        tv_am = 30000;
        total = ipad_am+stand_am+tv_am+mac_mini_am+seek_bar_am;
        total_amount.setValue("Rs."+total);
    }
    public void onClickCB_Samsung()
    {
        cb_mi.setValue(false);
        tv = "Samsung 43\"";
        tv_am = 40000;
        total = ipad_am+stand_am+tv_am+mac_mini_am+seek_bar_am;
        total_amount.setValue("Rs."+total);
    }

    public void onClickCB_38000()
    {
        cb_70000.setValue(false);
        mac_mini = "38000";
        mac_mini_am = 38000;
        total = ipad_am+stand_am+tv_am+mac_mini_am+seek_bar_am;
        total_amount.setValue("Rs."+total);
    }
    public void onClickCB_70000()
    {
        cb_38000.setValue(false);
        mac_mini = "70000";
        mac_mini_am = 70000;
        total = ipad_am+stand_am+tv_am+mac_mini_am+seek_bar_am;
        total_amount.setValue("Rs."+total);
    }

    public void onValueChanged(SeekBar seekBar, int progresValue, boolean b)
    {
        seekBarValue.set(progresValue + "");
        seek_bar_val = seekBarValue.get();
        seek_bar_am = 150*Integer.parseInt(seek_bar_val);
        total = ipad_am+stand_am+tv_am+mac_mini_am+seek_bar_am;
        total_amount.setValue("Rs."+total);
    }
}