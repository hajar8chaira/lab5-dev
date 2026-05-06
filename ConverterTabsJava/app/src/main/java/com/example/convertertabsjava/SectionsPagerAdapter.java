package com.example.convertertabsjava;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class SectionsPagerAdapter extends FragmentStateAdapter {

    public SectionsPagerAdapter(@NonNull FragmentActivity fa) {
        super(fa);
    }

    @NonNull
    @Override
    public Fragment createFragment(int index) {
        // 0 pour le premier onglet, 1 pour le second
        return (index == 0) ? new FragmentTemperature() : new FragmentDistance();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
