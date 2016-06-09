package my.flagdownloader;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.android.volley.toolbox.NetworkImageView;

import my.flagdownloader.databinding.CountryItemBinding;

/**
 * Created by pavelhunko on 09.06.2016
 */
public class CountryViewHolder extends RecyclerView.ViewHolder {
    private NetworkImageView mImage;
    private CountryItemBinding mCountryBinding;

    public CountryViewHolder(View itemView, Context context) {
        super(itemView);
        mCountryBinding = CountryItemBinding.bind(itemView);
        mImage = (NetworkImageView) itemView.findViewById(R.id.country_item_flag);
    }

    public void bind(final Country country) {
        mCountryBinding.setCountry(country);
        mImage.setImageUrl(BuildConfig.HOSTNAME_FLAGS + country.getFlag(), VolleySingleton.getInstance(FlagDownloaderApp.getInstance().getApplicationContext()).getImageLoader());
    }

    public CountryItemBinding getBinding() {
        return mCountryBinding;
    }


}
