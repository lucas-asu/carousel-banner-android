package br.com.lcruz.banners.manager;

import android.content.Context;

import java.util.List;

import br.com.lcruz.banners.business.BannersBusiness;
import br.com.lcruz.banners.interfaces.CallbackResponse;
import br.com.lcruz.banners.model.BannerItem;

/**
 * Created by Lucas Cruz on 25/06/2017.
 */

public class BannersManager {

    private BannersBusiness business;

    public BannersManager(Context context){
        business = new BannersBusiness(context);
    }

    public void getBanners(final CallbackResponse<List<BannerItem>> callback){
        business.getBanners(callback);
    }


}
