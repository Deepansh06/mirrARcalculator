package com.waysideutilities.mirrarcalculator.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.waysideutilities.mirrarcalculator.R;
import com.waysideutilities.mirrarcalculator.data.DataSingletonForScreen1;
import com.waysideutilities.mirrarcalculator.data.DataSingletonForScreen2;
import com.waysideutilities.mirrarcalculator.databinding.ActivityScreen2Binding;
import com.waysideutilities.mirrarcalculator.model.Screen1;
import com.waysideutilities.mirrarcalculator.model.Screen2;

public class Screen2Activity extends AppCompatActivity
{
    private ActivityScreen2Binding binding;
    private Screen1 screen1;

    private int ipad=0;
    private int stand=0;
    private int tv=0;
    private int mac_mini=0;
    private int processed_images=0;

    private static int total=0;
    private static int tax=0;
    private static int to_be_paid=0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_screen_2);
        screen1 = DataSingletonForScreen1.getInstance().getScreen1();

        if(screen1 == null)
        {
            finish();
        }
        if(screen1.getIpad() == null)
        {
            binding.llIpad.setVisibility(View.GONE);
        }
        else
        {
            binding.llIpad.setVisibility(View.VISIBLE);
            binding.txtIpadOption.setText(screen1.getIpad());

            if(screen1.getIpad().equals("9.7\""))
            {
                ipad=28000;
                binding.txtIpadAmount.setText("Rs."+ipad);
            }
            if(screen1.getIpad().equals("10.2\""))
            {
                ipad=30000;
                binding.txtIpadAmount.setText("Rs."+ipad);
            }
            if(screen1.getIpad().equals("10.5\""))
            {
                ipad=55000;
                binding.txtIpadAmount.setText("Rs."+ipad);
            }
            if(screen1.getIpad().equals("11\""))
            {
                ipad=68000;
                binding.txtIpadAmount.setText("Rs."+ipad);
            }
            if(screen1.getIpad().equals("12.9\""))
            {
                ipad=90000;
                binding.txtIpadAmount.setText("Rs."+ipad);
            }
        }

        if(screen1.getStand() == null)
        {
            binding.llStand.setVisibility(View.GONE);
        }
        else
        {
            binding.llStand.setVisibility(View.VISIBLE);
            binding.txtStandOption.setText(screen1.getStand());
            if(screen1.getStand().equals("Table Top"))
            {
                stand=6000;
                binding.txtStandAmount.setText("Rs."+stand);
            }
            if(screen1.getStand().equals("5\" Kiosk"))
            {
                stand=10000;
                binding.txtStandAmount.setText("Rs."+stand);
            }
        }

        if(screen1.getTv() == null)
        {
            binding.llTv.setVisibility(View.GONE);
        }
        else
        {
            binding.llTv.setVisibility(View.VISIBLE);
            binding.txtTvOption.setText(screen1.getTv());

            if(screen1.getTv().equals("Mi 50\""))
            {
                tv=30000;
                binding.txtTvAmount.setText("Rs."+tv);
            }
            if(screen1.getTv().equals("Samsung 43\""))
            {
                tv=40000;
                binding.txtTvAmount.setText("Rs."+tv);
            }
        }

        if(screen1.getMac_mini() == null)
        {
            binding.llMacMini.setVisibility(View.GONE);
        }
        else
        {
            binding.llMacMini.setVisibility(View.VISIBLE);
            binding.txtMacMiniOption.setText(screen1.getMac_mini());
            if(screen1.getMac_mini().equals("38000"))
            {
                mac_mini=38000;
                binding.txtMacMiniAmount.setText("Rs."+mac_mini);
            }
            if(screen1.getMac_mini().equals("70000"))
            {
                mac_mini=70000;
                binding.txtMacMiniAmount.setText("Rs."+mac_mini);
            }
        }

        if(screen1.getProcessed_images() == null || screen1.getProcessed_images().isEmpty())
        {
            binding.llProcessedImages.setVisibility(View.GONE);
        }
        else
        {
            binding.llProcessedImages.setVisibility(View.VISIBLE);
            binding.txtProcessedImagesOption.setText(screen1.getProcessed_images());
            processed_images = Integer.parseInt(screen1.getProcessed_images())*150;
            binding.txtProcessedImagesAmount.setText("Rs."+processed_images);
        }

        total = ipad+stand+tv+mac_mini+processed_images;
        binding.txtTotal.setText("Rs."+total);

        tax = total*18/100;
        binding.txtTax.setText("Rs."+tax);

        to_be_paid = total+tax;
        binding.txtToBePaid.setText("Rs."+to_be_paid);

        binding.buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataSingletonForScreen2.getInstance().setScreen2(new Screen2(screen1.getIpad(),ipad+"",
                        screen1.getStand(),stand+"",screen1.getTv(),tv+"",
                        screen1.getMac_mini(),mac_mini+"",
                        screen1.getProcessed_images(),processed_images+"",
                        total+"",tax+"",to_be_paid+""));

                startActivity(new Intent(Screen2Activity.this,Screen3Activity.class));
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        DataSingletonForScreen1.getInstance().setScreen1(null);
        DataSingletonForScreen1.getInstance().clear();
    }
}
