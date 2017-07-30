package br.com.lcruz.banners.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.List;

import br.com.lcruz.banners.fragments.BannerItemFragment;
import br.com.lcruz.banners.interfaces.BannerListener;
import br.com.lcruz.banners.model.BannerItem;

/**
 * Created by Lucas Cruz on 27/07/2017.
 */

public class BannerPageAdapter extends FragmentStatePagerAdapter  {

    private Context context;
    private List<BannerItem> banners;
    private static BannerListener mListener;

    public BannerPageAdapter(Context context, FragmentManager fm, List<BannerItem> banners, BannerListener listener) {
        super(fm);
        this.context = context;
        this.banners = banners;
        mListener = listener;
    }

    @Override
    public Fragment getItem(int position) {
        return BannerItemFragment.newInstance(context,banners.get(position), mListener);
    }

    @Override
    public int getCount() {
        return banners.size();
    }

}
