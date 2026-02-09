package com.example.secondlesson;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {

    private final MutableLiveData<Integer> counter = new MutableLiveData<>(0);

    public LiveData<Integer> getCounter() {
        return counter;
    }

    public void increaseBy3(){
        counter.setValue(counter.getValue() + 3);
    }

    public void decreaseBy5(){
        counter.setValue(counter.getValue() - 5);
    }
}
