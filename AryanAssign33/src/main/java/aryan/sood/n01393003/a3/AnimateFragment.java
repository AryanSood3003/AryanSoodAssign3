//Aryan Sood
//N01393003
//CENG 258 RNA

package aryan.sood.n01393003.a3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;


public class AnimateFragment extends Fragment {
    private View view;
    private ImageView imageView;
    public AnimateFragment() {
        // Required empty public constructor
    }

    public static AnimateFragment newInstance() {
        AnimateFragment fragment = new AnimateFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view  = inflater.inflate(R.layout.fragment_animate, container, false);
      imageView = (ImageView) view.findViewById(R.id.Aryan_Merc);
        final Button startBtn = (Button) view.findViewById(R.id.Aryan_Start);
        final Button stopBtn = (Button) view.findViewById(R.id.Aryan_Stop);

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performAnimation(R.anim.move);
            }
        });

        stopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.clearAnimation();
            }
        });

        return view;
    }


    public void performAnimation(int animationResourseID){
        imageView.setVisibility(View.VISIBLE);
        Animation an = AnimationUtils.loadAnimation(getContext(), animationResourseID);
        an.setAnimationListener(new MyAnimationListener());
        imageView.startAnimation(an);
    }

class MyAnimationListener implements Animation.AnimationListener{

    public void onAnimationStart(Animation animation){
    }

    @Override
    public void onAnimationEnd(Animation animation) {
    }
    @Override
    public void onAnimationRepeat(Animation animation) {

    }

}

}