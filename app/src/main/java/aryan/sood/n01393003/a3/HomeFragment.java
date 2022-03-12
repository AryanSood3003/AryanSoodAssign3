package aryan.sood.n01393003.a3;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import androidx.fragment.app.Fragment;


public class HomeFragment extends Fragment  {
    int i=0;
    private EditText pass;
    public HomeFragment() {
    }

    public static HomeFragment newInstance()
    {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.fragment_home, container, false);
        int images[] = {R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4};
        ImageButton image = (ImageButton) view.findViewById(R.id.Aryan_img);
            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    pass =  (EditText) view.findViewById(R.id.Aryan_ed);
                    String text = pass.getText().toString();
                    image.setImageResource(images[i]);
                    i++;
                    if (i == 4)
                        i = 0;
                    Bundle result = new Bundle();
                    result.putString("bundleKey", text);
                    getParentFragmentManager().setFragmentResult("requestKey", result);
                }
            });
        return view;
    }
}

