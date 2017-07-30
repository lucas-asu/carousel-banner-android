package br.com.lcruz.banners.interfaces;

import java.util.List;

import br.com.lcruz.banners.model.BannerItem;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Lucas Cruz on 25/06/2017.
 */

public interface BannerRestService {

    @GET("banners.json")
    Call<List<BannerItem>> getBanners();
}
