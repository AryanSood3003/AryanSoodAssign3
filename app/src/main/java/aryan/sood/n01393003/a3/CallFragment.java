package aryan.sood.n01393003.a3;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import com.google.android.material.snackbar.Snackbar;

import org.jetbrains.annotations.NotNull;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CallFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CallFragment extends Fragment {
    private String result;
    public final int REQUEST_PHONE_CALL = 1;
    View view;
    Intent intent;
    public CallFragment() {
        // Required empty public constructor
    }


    public static CallFragment newInstance() {
        CallFragment fragment = new CallFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       view  = inflater.inflate(R.layout.fragment_call, container, false);
        Button buttonN = (Button) view.findViewById(R.id.Aryan_call);
        buttonN.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
               call();
            }
        });
        getParentFragmentManager().setFragmentResultListener("requestKey", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle bundle) {
                result = bundle.getString("bundleKey");
                TextView tv = (TextView)view.findViewById(R.id.Aryan_pass);
                tv.setText(result);
            }
        });
        return view;
    }

    private void call() {
        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
            String phone = getString(R.string.contact_number);
            intent = new Intent(Intent.ACTION_CALL, Uri.fromParts("tel", phone, null));
            startActivity(intent);
        } else {
            requestPermissions( new String[]{Manifest.permission.CALL_PHONE},
                    REQUEST_PHONE_CALL);
        }
    }

@Override
    public void onRequestPermissionsResult(int requestCode, @NotNull String[] permissions, @NotNull int[] grantResults) {
        ConstraintLayout text = view.findViewById(R.id.constraintLayout);
        Snackbar snackbar;
        if (requestCode == REQUEST_PHONE_CALL && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            snackbar = Snackbar
                    .make(text, R.string.pg, Snackbar.LENGTH_LONG);
        } else  {
            snackbar = Snackbar
                    .make(text, R.string.pd, Snackbar.LENGTH_LONG);
        }
        snackbar.show();
    }

}