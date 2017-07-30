package br.com.lcruz.banners.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.List;

import br.com.lcruz.banners.R;
import br.com.lcruz.banners.adapter.BannerPageAdapter;
import br.com.lcruz.banners.interfaces.BannerListener;
import br.com.lcruz.banners.interfaces.CallbackResponse;
import br.com.lcruz.banners.manager.BannersManager;
import br.com.lcruz.banners.model.BannerItem;

public class BannerCarouselFragment extends Fragment {

    private static BannerListener mListener;
    private List<BannerItem> banners;
    private ViewPager viewPager;
    private LinearLayout bulletsLayout;

    public BannerCarouselFragment() {
        // Required empty public constructor
    }

    public static BannerCarouselFragment newInstance(BannerListener listener) {
        mListener = listener;
        return new BannerCarouselFragment();
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            int pos = viewPager.getCurrentItem();
            if(pos == (banners.size()-1)){
                viewPager.setCurrentItem(0, true);
            } else {
                pos++;
                viewPager.setCurrentItem(pos, true);
            }
            viewPager.postDelayed(runnable, 3000);
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View myView = inflater.inflate(R.layout.fragment_banners, container, false);

        viewPager = (ViewPager) myView.findViewById(R.id.lb_pages);
        bulletsLayout = (LinearLayout) myView.findViewById(R.id.lb_dots_layout);

        new BannersManager(getContext()).getBanners(new CallbackResponse<List<BannerItem>>() {
            @Override
            public void onSuccess(List<BannerItem> response) {
                banners = response;
                BannerPageAdapter pageAdapter = new BannerPageAdapter(getContext(),getFragmentManager(),banners,mListener);
                viewPager.setAdapter(pageAdapter);
                buildBullets();
                viewPager.postDelayed(runnable, 3000);
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position > 0){
                    bulletsLayout.getChildAt(position-1).setAlpha(0.5f);
                } else {
                    bulletsLayout.getChildAt(banners.size()-1).setAlpha(0.5f);
                }
                bulletsLayout.getChildAt(position).setAlpha(1f);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        return myView;
    }

    private void buildBullets(){
        for (int i = 0; i < banners.size(); i++) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            LinearLayout bullet = new LinearLayout(getContext());
            inflater.inflate(R.layout.lb_bullet_layout, bullet);
            bullet.setAlpha(0.5f);
            bulletsLayout.addView(bullet);
        }
        bulletsLayout.getChildAt(0).setAlpha(1f);
    }

}
