//Aryan Sood
//N01393003
//CENG 258 RNA

package aryan.sood.n01393003.a3;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class AryanActivity extends AppCompatActivity implements TabLayoutMediator.TabConfigurationStrategy {
    private ViewPager2 viewPager2;
    private TabLayout tabLayout;
    ArrayList<String> titles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager2 = findViewById(R.id.Aryan_viewPager2);
        tabLayout = findViewById(R.id.Aryan_tabLayout);
        setViewPagerAdapter();

        titles = new ArrayList<String>();
        titles.add(getString(R.string.home_string));
        titles.add(getString(R.string.draw));
        titles.add(getString(R.string.call));
        titles.add(getString(R.string.animate));

        new TabLayoutMediator(tabLayout, viewPager2, this).attach();

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_brush);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_call);
        tabLayout.getTabAt(3).setIcon(R.drawable.ic_play);
    }

    public void setViewPagerAdapter() {
        ViewPager2Adapter viewPager2Adapter = new ViewPager2Adapter(this);

        ArrayList<Fragment> fragmentList = new ArrayList<>();

        fragmentList.add(new PasswordFragment());
        fragmentList.add(new DrawFragment());
        fragmentList.add(new CallFragment());
        fragmentList.add(new AnimateFragment());
        viewPager2Adapter.setData(fragmentList);
        viewPager2.setAdapter(viewPager2Adapter);
        viewPager2.setUserInputEnabled(false);
    }

    @Override
    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
        tab.setText(titles.get(position));
    }
    public void onBackPressed() {

        AlertDialog.Builder builder = new AlertDialog.Builder(AryanActivity.this);
        builder.setTitle(R.string.app_name);
        builder.setMessage(R.string.extemsg)
                .setCancelable(false)
                .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finishAffinity();
                        System.exit(0);
                    }
                }
                )
                .setIcon(R.drawable.alert)
                .setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    }
                });
        builder.show();
    }
}