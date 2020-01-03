package com.waysideutilities.mirrarcalculator.view;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.waysideutilities.mirrarcalculator.R;
import com.waysideutilities.mirrarcalculator.data.DataSingletonForScreen1;
import com.waysideutilities.mirrarcalculator.databinding.ActivityScreen1Binding;
import com.waysideutilities.mirrarcalculator.model.Screen1;
import com.waysideutilities.mirrarcalculator.viewmodel.Screen1ViewModel;

import java.util.Objects;

public class Screen1Activity extends AppCompatActivity
{
    ActivityScreen1Binding binding;
    private Screen1ViewModel screen1ViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        screen1ViewModel = ViewModelProviders.of(this).get(Screen1ViewModel.class);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_screen_1);
        binding.setLifecycleOwner(this);
        binding.setScreen1ViewModel(screen1ViewModel);

        screen1ViewModel.getScreen1().observe(this, new Observer<Screen1>()
        {
            @Override
            public void onChanged(@Nullable Screen1 screen1)
            {
                if (TextUtils.isEmpty(Objects.requireNonNull(screen1).getIpad()) &&
                        TextUtils.isEmpty(Objects.requireNonNull(screen1).getStand()) &&
                        TextUtils.isEmpty(Objects.requireNonNull(screen1).getTv()) &&
                        TextUtils.isEmpty(Objects.requireNonNull(screen1).getMac_mini()) &&
                        TextUtils.isEmpty(Objects.requireNonNull(screen1).getProcessed_images()))
                {
                    Toast.makeText(Screen1Activity.this,"Please choose any option",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    DataSingletonForScreen1.getInstance().setScreen1(screen1);
                    startActivity(new Intent(Screen1Activity.this,Screen2Activity.class));
                }
            }
        });
    }
}
