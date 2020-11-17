package com.example.varro.ui.dial;

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

public class DialFragment extends Fragment {

    private DialViewModel dialViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dialViewModel =
                new ViewModelProvider(this).get(DialViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dial, container, false);
        final TextView textView = root.findViewById(R.id.phone_number_field);
        dialViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}