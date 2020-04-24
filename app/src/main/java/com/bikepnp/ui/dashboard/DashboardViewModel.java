package com.bikepnp.ui.dashboard;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DashboardViewModel extends ViewModel {
    private MutableLiveData<String> mText = new MutableLiveData();

    public DashboardViewModel() {
        this.mText.setValue("No current items for rent");
    }

    public LiveData<String> getText() {
        return (LiveData<String>)this.mText;
    }
}
