package com.example.varro.ui.splash;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SplashViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SplashViewModel() {
        mText = new MutableLiveData<>();
//        mText.setValue("This is settings fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}