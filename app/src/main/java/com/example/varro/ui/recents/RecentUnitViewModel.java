package com.example.varro.ui.recents;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RecentUnitViewModel extends ViewModel {

    static String[] names = {"Carl Wheezer", "Dave", "Hasala Senpathy Gallolu Kankanamalage", "John Cena"};
    static String[] times = {"8:19 AM", "Yesterday", "Thursday", "Nov 10"};
    static int count = 0;

    private MutableLiveData<String> nameText;
    private MutableLiveData<String> timeText;

    public RecentUnitViewModel() {
        nameText = new MutableLiveData<>();
        timeText = new MutableLiveData<>();
        if(names[count].length() > 20)
            nameText.setValue(names[count].substring(0,20) + "...");
        else
            nameText.setValue(names[count]);

        timeText.setValue(times[count]);
        count++;
        if(count == names.length)
            count = 0;

    }

    public LiveData<String> getName() {
        return nameText;
    }
    public LiveData<String> getTime() {
        return timeText;
    }
}