package my.flagdownloader;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by pavelhunko on 09.06.2016
 */
public class CountriesAdapter extends RecyclerView.Adapter<CountryViewHolder> {
    private ArrayList<Country> mCountries;
    private Context mContext;

    public CountriesAdapter(ArrayList<Country> countries, Context context) {
        this.mCountries = countries;
        this.mContext = context;
    }

    @Override
    public CountryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.country_item, parent, false);
        CountryViewHolder countryViewHolder = new CountryViewHolder(itemView, mContext);
        return countryViewHolder;

    }

    @Override
    public void onBindViewHolder(CountryViewHolder holder, int position) {
        holder.bind(mCountries.get(position));
        holder.getBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mCountries.size();
    }
}
