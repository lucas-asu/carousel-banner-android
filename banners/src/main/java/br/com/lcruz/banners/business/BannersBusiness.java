package br.com.lcruz.banners.business;

import android.content.Context;


import java.util.List;

import br.com.lcruz.banners.infrastructure.BannersUtil;
import br.com.lcruz.banners.interfaces.CallbackResponse;
import br.com.lcruz.banners.model.BannerItem;
import br.com.lcruz.banners.provider.BannersLocalProvider;
import br.com.lcruz.banners.provider.BannersRestProvider;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Lucas Cruz on 25/06/2017.
 */

public class BannersBusiness {

    private BannersRestProvider restProvider;
    private BannersLocalProvider localProvider;
    private Context context;

    public BannersBusiness(Context context) {
        restProvider = new BannersRestProvider();
        localProvider = new BannersLocalProvider();
        this.context = context;
    }

    public void getBanners(final CallbackResponse<List<BannerItem>> callback){
        if(BannersUtil.isNetworkAvailable(context)){
            restProvider.getBanners().enqueue(new Callback<List<BannerItem>>() {
                @Override
                public void onResponse(Call<List<BannerItem>> call, Response<List<BannerItem>> response) {
                    if(response.isSuccessful()){
                        callback.onSuccess(response.body());
                    } else {
                        callback.onSuccess(localProvider.getBanners());
                    }
                }

                @Override
                public void onFailure(Call<List<BannerItem>> call, Throwable t) {
                    callback.onFailure(t);
                    callback.onSuccess(localProvider.getBanners());
                }
            });
        } else {
            callback.onSuccess(localProvider.getBanners());
        }
    }
}
