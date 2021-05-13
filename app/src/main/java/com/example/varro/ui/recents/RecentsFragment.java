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

// This fragment contains the recents screen.
// it is not currently pulling from a list of recent calls. it is pulling from a hard-coded array of names
// To Do: implement a contact class to have information pulled from to be displayed in a popup. this also applied to the contacts screen

public class RecentsFragment extends Fragment {

    private RecentsViewModel recentsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        recentsViewModel =
                new ViewModelProvider(this).get(RecentsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_recents, container, false);
        final TextView textView = root.findViewById(R.id.text_recents);
        recentsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}