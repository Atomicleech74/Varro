package com.example.varro.ui.contacts;

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

// this fragment models what a single contact looks like in the list

public class ContactUnitFragment extends Fragment {

    private ContactUnitViewModel contactUnitViewModel;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        contactUnitViewModel = new ViewModelProvider(this).get(ContactUnitViewModel.class);
        View root = inflater.inflate(R.layout.fragment_contact_unit, container, false);
        final TextView textView = root.findViewById(R.id.contact_name);
        contactUnitViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}