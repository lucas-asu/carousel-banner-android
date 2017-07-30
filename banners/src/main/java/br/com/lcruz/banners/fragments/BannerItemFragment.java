package br.com.lcruz.banners.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import br.com.lcruz.banners.R;
import br.com.lcruz.banners.interfaces.BannerListener;
import br.com.lcruz.banners.model.BannerItem;


public class BannerItemFragment extends Fragment {

    private static final String BANNER_ITEM = "BANNER_ITEM";

    private BannerItem bannerItem;
    private View myView;
    private static BannerListener mListener;

    public static Fragment newInstance(Context constext,BannerItem item, BannerListener listener) {
        mListener = listener;
        Bundle args = new Bundle();
        args.putParcelable(BANNER_ITEM, item);
        return  Fragment.instantiate(constext, BannerItemFragment.class.getName(), args);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            bannerItem = getArguments().getParcelable(BANNER_ITEM);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_banner_item, container, false);

        ImageView img = (ImageView) myView.findViewById(R.id.lb_image);
        TextView title = (TextView) myView.findViewById(R.id.lb_title);
        TextView from = (TextView) myView.findViewById(R.id.lb_from);

        if(bannerItem.src != null) {
            Glide.with(this).load(bannerItem.src).into(img);
        } else {
            img.setImageResource(bannerItem.localSrc);
        }

        title.setText(bannerItem.title);

        from.setText(bannerItem.from);

        myView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onClick(bannerItem);
            }
        });

        return myView;
    }




}
