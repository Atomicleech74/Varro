package com.example.varro.ui.dial;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DialViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public DialViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dial fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}