package firebaseapp.com.radnacasu20.ui.myActors;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import firebaseapp.com.radnacasu20.model.Actors;

public class MyActorViewModel extends ViewModel {
    // TODO: Implement the ViewModel



    private MutableLiveData<String> mText;

    public MyActorViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Actors fragment");

    }

    public LiveData<String> getText() {
        return mText;
    }
}