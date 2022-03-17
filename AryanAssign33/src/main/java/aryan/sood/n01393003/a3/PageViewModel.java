//Aryan Sood
//N01393003
//CENG 258 RNA

package aryan.sood.n01393003.a3;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

public class PageViewModel extends ViewModel {

    private MutableLiveData<String> mIndex = new MutableLiveData<>();
    private LiveData<String> mText = Transformations.map(mIndex, new Function<String, String>() {
        @Override
        public String apply(String input) {
            return "Section " + input;
        }
    });

    public void setIndex(String index) {
        mIndex.setValue(index);
    }

    public LiveData<String> getText() {
        return mText;
    }
}