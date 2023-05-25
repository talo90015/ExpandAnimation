package com.talo.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.LayoutTransition;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;

import com.talo.demo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.cvCard.setOnClickListener(v -> test());
        binding.cvCard.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);

    }


    private void test() {
        int showContent = (binding.tv.getVisibility() == View.GONE) ? View.VISIBLE : View.GONE;

        TransitionManager.beginDelayedTransition(binding.ll, new AutoTransition());
        binding.tv.setVisibility(showContent);
    }
}