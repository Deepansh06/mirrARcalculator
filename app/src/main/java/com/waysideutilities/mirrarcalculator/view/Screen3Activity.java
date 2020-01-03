package com.waysideutilities.mirrarcalculator.view;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.text.TextUtils;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.waysideutilities.mirrarcalculator.R;
import com.waysideutilities.mirrarcalculator.data.DataSingletonForScreen2;
import com.waysideutilities.mirrarcalculator.databinding.ActivityScreen3Binding;
import com.waysideutilities.mirrarcalculator.model.Screen2;
import com.waysideutilities.mirrarcalculator.model.Screen3;
import com.waysideutilities.mirrarcalculator.viewmodel.Screen3ViewModel;

import java.util.List;
import java.util.Objects;

public class Screen3Activity extends AppCompatActivity
{
    private static final String GMAIL_PACKAGE_NAME = "com.google.android.gm";

    ActivityScreen3Binding binding;
    private Screen3ViewModel screen3ViewModel;

    private Screen2 screen2;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);


        screen3ViewModel = ViewModelProviders.of(this).get(Screen3ViewModel.class);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_screen_3);
        binding.setLifecycleOwner(this);
        binding.setScreen3ViewModel(screen3ViewModel);

        screen2 = DataSingletonForScreen2.getInstance().getScreen2();

        if(screen2 == null)
        {
            finish();
        }

        screen3ViewModel.getScreen3MutableLiveData().observe(this, new Observer<Screen3>()
        {
            @Override
            public void onChanged(@Nullable Screen3 screen3)
            {
                if (TextUtils.isEmpty(Objects.requireNonNull(screen3).getClient_name()))
                {
                    binding.etClientName.setError("Enter client Name");
                    binding.etClientName.requestFocus();
                }
                else if (TextUtils.isEmpty(Objects.requireNonNull(screen3).getBrand_name()))
                {
                    binding.etBrandName.setError("Enter Brand Name");
                    binding.etBrandName.requestFocus();
                }
                else if (TextUtils.isEmpty(Objects.requireNonNull(screen3).getEmail_id()))
                {
                    binding.etEmail.setError("Enter E-mail ID");
                    binding.etEmail.requestFocus();
                }
                else if (!screen3.isEmailValid())
                {
                    binding.etEmail.setError("Enter a Valid E-mail Address");
                    binding.etEmail.requestFocus();
                }
                else if (TextUtils.isEmpty(Objects.requireNonNull(screen3).getMobile_no()))
                {
                    binding.etMobile.setError("Enter mobile number");
                    binding.etMobile.requestFocus();
                }
                else if (!screen3.isMobileValid())
                {
                    binding.etMobile.setError("Enter 10 digit mobile number");
                    binding.etMobile.requestFocus();
                }
                else if (TextUtils.isEmpty(Objects.requireNonNull(screen3).getAddress()))
                {
                    binding.etAddress.setError("Enter address");
                    binding.etAddress.requestFocus();
                }
                else if (TextUtils.isEmpty(Objects.requireNonNull(screen3).getAdvance_payment_amount()))
                {
                    binding.etAdvancePaymentAmount.setError("Enter advance payment amount");
                    binding.etAdvancePaymentAmount.requestFocus();
                }
                else
                {
                    sendEmail(screen3,screen2);
                }
            }
        });
    }

    private void sendEmail(Screen3 screen3,Screen2 screen2)
    {
        try
        {

            String ipad="";
            String ipad_am="";
            String stand="";
            String stand_am="";
            String tv="";
            String tv_am="";
            String mac_mini="";
            String mac_mini_am="";
            String processed_images="";
            String processed_images_am="";
            String amount="";
            String tax="";
            String to_be_paid="";

            if(screen2.getIpad() != null)
            {
                ipad = screen2.getIpad();
                ipad_am = screen2.getIpad_am();
            }


            if(screen2.getStand() != null)
            {
                stand = screen2.getStand();
                stand_am = screen2.getStand_am();
            }

            if(screen2.getTv() != null)
            {
                tv = screen2 .getTv();
                tv_am = screen2.getTv_am();
            }

            if(screen2.getMac_mini() != null)
            {
                mac_mini = screen2.getMac_mini();
                mac_mini_am = screen2.getMac_mini_am();
            }

            if(screen2.getProcessed_images() != null)
            {
                processed_images = screen2.getProcessed_images();
                processed_images_am = screen2.getProcessed_images_am();
            }

            amount = screen2.getAmount();
            tax = screen2.getTax();
            to_be_paid = screen2.getTo_be_paid();
            String result = "Product Variable Selected Option Amount";
            if(ipad!=null)
            {
                result =result + "\n" + "iPad " + ipad + " Rs." + ipad_am;
            }
            if(stand!=null)
            {
                result =result + "\n" + "Stand " + stand + " Rs." + stand_am;
            }
            if(tv!=null)
            {
                result =result + "\n" + "TV " + tv + " Rs." + tv_am;
            }
            if(mac_mini!=null)
            {
                result =result + "\n" + "Mac Mini " + mac_mini + " Rs." + mac_mini_am;
            }
            if(processed_images!=null)
            {
                result =result + "\n" + "Processed Images " + processed_images + " Rs." + processed_images_am;
            }

            result = result + "\n" +"Total \t\t = Rs."+ amount;
            result = result + "\n" +"TAX \t\t = Rs."+ tax;
            result = result + "\n" +"To Be Paid \t\t = Rs."+ to_be_paid;


            String[] TO = {screen3.getEmail_id()};
            Intent emailIntent = new Intent(Intent.ACTION_SEND);
            emailIntent.setType("text/html");
            emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Order Confirmed");
            emailIntent.putExtra(Intent.EXTRA_TEXT, "This Email is an order confirmation message from StyleDotMe. Please find below the details:" +
                    "\nName : "+screen3.getClient_name()+
                    "\nMobile no : "+screen3.getMobile_no()+
                    "\nEmail id : "+screen3.getEmail_id()+
                    "\nAddress : "+screen3.getAddress()+
                    "\nBrand Name : "+screen3.getBrand_name()+
                    "\nAdvance Payment Amount : Rs."+screen3.getAdvance_payment_amount()+
                    "\nAdvance Payment Method : "+screen3.getAdvance_payment_method()+
                    "\nMessage : \n" + result );
            final PackageManager pm = this.getPackageManager();
            final List<ResolveInfo> matches = pm.queryIntentActivities(emailIntent, 0);
            String className = null;
            for (final ResolveInfo info : matches) {
                if (info.activityInfo.packageName.equals(GMAIL_PACKAGE_NAME)) {
                    className = info.activityInfo.name;
                    if (className != null && !className.isEmpty()) {
                        break;
                    }
                }
            }
            emailIntent.setClassName(GMAIL_PACKAGE_NAME, className);
            startActivity(emailIntent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
