package com.example.varro.ui.contacts;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ContactUnitViewModel extends ViewModel {

    static String[] names = {"Carl Wheezer", "John Cena", "Hasala Senpathy Gallolu Kankanamalage", "Dave"};
    static int count = 0;

    private MutableLiveData<String> nameText;

    public ContactUnitViewModel() {
        nameText = new MutableLiveData<>();
        if(names[count].length() > 20)
            nameText.setValue(names[count].substring(0,20) + "...");
        else
            nameText.setValue(names[count]);
        count++;
        if(count == names.length)
            count = 0;

    }

    public LiveData<String> getText() {
        return nameText;
    }
}