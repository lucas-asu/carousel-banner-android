package br.com.lcruz.banners.provider;


import java.util.ArrayList;
import java.util.List;

import br.com.lcruz.banners.R;
import br.com.lcruz.banners.interfaces.CallbackResponse;
import br.com.lcruz.banners.model.BannerItem;

/**
 * Created by Lucas Cruz on 25/06/2017.
 */

public class BannersLocalProvider {


    public List<BannerItem> getBanners(){
        List<BannerItem> banners =new ArrayList<>();
        banners.add(new BannerItem(R.drawable.deadpool));
        return banners;
    }
}
