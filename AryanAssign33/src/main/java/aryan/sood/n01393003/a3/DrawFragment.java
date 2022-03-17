//Aryan Sood
//N01393003
//CENG 258 RNA

package aryan.sood.n01393003.a3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DrawFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DrawFragment extends Fragment {
    private static final String TAG ="2";
    private PageViewModel pageViewModel;
    private View v;
    Button clear,update;
    Spinner size;
    Spinner color;
    private CanvasView customCanvas;
    public DrawFragment() {
        // Required empty public constructor
    }



    public static DrawFragment newInstance() {
        return new DrawFragment();
    }
    public void clearCanvas(View view){
        customCanvas.clearPath();
    }
    public void updatePen(View v){
        String penSize = (String)((TextView)size.getSelectedView()).getText();
        String penColor = (String)((TextView)color.getSelectedView()).getText();
        customCanvas.updateCanvas(penSize,penColor);
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = new ViewModelProvider(this).get(PageViewModel.class);
        pageViewModel.setIndex(TAG);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_draw, container, false);
        customCanvas = (CanvasView) v.findViewById(R.id.signature_canvas);
        clear = v.findViewById(R.id.aryan_Clear);
        update = v.findViewById(R.id.Aryan_update);
        size = (Spinner)v.findViewById(R.id.Aryan_size);
        color = (Spinner)v.findViewById(R.id.nAryan_color);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updatePen(v);
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearCanvas(v);
            }
        });

        // Inflate the layout for this fragment
        return v;
    }
}