package com.example.varro.ui.dial;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DialViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public DialViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Enter a phone # or email");
    }

    public LiveData<String> getText() {
        return mText;
    }
}