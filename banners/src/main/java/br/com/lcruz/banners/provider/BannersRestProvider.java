package br.com.lcruz.banners.provider;

import java.util.List;

import br.com.lcruz.banners.infrastructure.RetrofitProvider;
import br.com.lcruz.banners.interfaces.BannerRestService;
import br.com.lcruz.banners.interfaces.CallbackResponse;
import br.com.lcruz.banners.model.BannerItem;
import retrofit2.Call;

/**
 * Created by Lucas Cruz on 25/06/2017.
 */

public class BannersRestProvider extends RetrofitProvider {

    private BannerRestService service;

    public BannersRestProvider() {
        super("http://192.168.25.103:8887/");
        service = retrofit.create(BannerRestService.class);
    }

    public Call<List<BannerItem>> getBanners(){
        return service.getBanners();
    }


}
