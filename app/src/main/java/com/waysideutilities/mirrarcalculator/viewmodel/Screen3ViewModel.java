package com.waysideutilities.mirrarcalculator.viewmodel;

import android.view.View;
import android.widget.AdapterView;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.waysideutilities.mirrarcalculator.model.Screen3;

public class Screen3ViewModel extends ViewModel
{
    public MutableLiveData<String> ClientName = new MutableLiveData<>();
    public MutableLiveData<String> BrandName = new MutableLiveData<>();
    public MutableLiveData<String> EmailAddress = new MutableLiveData<>();
    public MutableLiveData<String> Mobile = new MutableLiveData<>();
    public MutableLiveData<String> Address = new MutableLiveData<>();
    public MutableLiveData<String> PaymentAmount = new MutableLiveData<>();

    private MutableLiveData<Screen3> screen3MutableLiveData;

    private String person_name = null;
    private String payment_method = null;

    public MutableLiveData<Screen3> getScreen3MutableLiveData()
    {
        if (screen3MutableLiveData == null)
        {
            screen3MutableLiveData = new MutableLiveData<>();
        }
        return screen3MutableLiveData;
    }

    public void onClick(View view)
    {
        Screen3 screen3 = new Screen3(person_name,ClientName.getValue(),BrandName.getValue(),EmailAddress.getValue(),
                Mobile.getValue(), Address.getValue(),PaymentAmount.getValue(),payment_method);
        screen3MutableLiveData.setValue(screen3);
    }

    public void onSelectPerson(AdapterView<?> parent, View view, int pos, long id)
    {
        person_name = parent.getSelectedItem().toString();
    }

    public void onSelectPayment(AdapterView<?> parent, View view, int pos, long id)
    {
        payment_method = parent.getSelectedItem().toString();
    }

}