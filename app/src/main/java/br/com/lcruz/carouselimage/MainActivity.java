package br.com.lcruz.carouselimage;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import br.com.lcruz.banners.fragments.BannerCarouselFragment;
import br.com.lcruz.banners.interfaces.BannerListener;
import br.com.lcruz.banners.model.BannerItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BannerCarouselFragment carouselFragment = BannerCarouselFragment.newInstance(new BannerListener() {
            @Override
            public void onClick(BannerItem item) {
                Toast.makeText(MainActivity.this, "Banner clicked", Toast.LENGTH_SHORT).show();
            }
        });

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.app_container,carouselFragment).commit();

    }
}
