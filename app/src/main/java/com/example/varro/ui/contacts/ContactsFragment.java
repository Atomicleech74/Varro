package com.example.varro.ui.contacts;

import android.Manifest;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.varro.MainActivity;
import com.example.varro.R;

import static android.content.pm.PackageManager.PERMISSION_GRANTED;

public class ContactsFragment extends Fragment {

    private ContactsViewModel contactsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        contactsViewModel =
                new ViewModelProvider(this).get(ContactsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_contacts, container, false);
        ListView l1 = (ListView)root.findViewById(R.id.contacts_list2);
//        if(l1 != null)
//            Log.println(Log.INFO, null, "FOUND IT!");
        return root;
    }
}