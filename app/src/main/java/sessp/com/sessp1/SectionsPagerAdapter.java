package sessp.com.sessp1;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by renan on 20/11/2017.
 */

public class SectionsPagerAdapter extends FragmentPagerAdapter {

    PlaceholderFragment pf;

    public SectionsPagerAdapter(FragmentManager fm ) {
        super(fm);

    }

    @Override
    public Fragment getItem(int position) {

        return pf.newInstance(position + 1);
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 13;
    }

}
