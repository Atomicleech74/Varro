package com.example.varro.ui.recents;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.varro.R;

public class RecentUnitFragment extends Fragment {

    private RecentUnitViewModel recentUnitViewModel;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        recentUnitViewModel = new ViewModelProvider(this).get(RecentUnitViewModel.class);
        View root = inflater.inflate(R.layout.fragment_recent_unit, container, false);
        final TextView nameTextView = root.findViewById(R.id.recent_name);
        recentUnitViewModel.getName().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                nameTextView.setText(s);
            }
        });
        final TextView timeTextView = root.findViewById(R.id.recent_time);
        recentUnitViewModel.getTime().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                timeTextView.setText(s);
            }
        });
        return root;
    }
}