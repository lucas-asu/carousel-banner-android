package br.com.lcruz.banners.interfaces;

/**
 * Created by Lucas Cruz on 25/06/2017.
 */

public interface CallbackResponse<T> {

    void onSuccess(T response);

    void onFailure(Throwable t);

}
