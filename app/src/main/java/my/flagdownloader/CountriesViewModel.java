package my.flagdownloader;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Created by pavelhunko on 10.06.2016
 */
public class CountriesViewModel {

    private CountriesManager mCountriesManager;
    private Context mContext;
    private RecyclerView mRecyclerViewCountries;
    private RecyclerView.LayoutManager mCountriesLayoutManager;

    public CountriesViewModel(Context context, RecyclerView recyclerViewCountries){
        this.mContext = context;
        this.mRecyclerViewCountries = recyclerViewCountries;
        mCountriesManager = new CountriesManager();
    }

    public void getCountriesList(){
        mCountriesManager.getCountriesList(this, mContext);
    }


    public void saveCountries(ArrayList<Country> countries){
        mCountriesLayoutManager = new LinearLayoutManager(mContext);
        CountriesAdapter countriesAdapter = new CountriesAdapter(countries, mContext);
        if (mRecyclerViewCountries != null) {
            mRecyclerViewCountries.setLayoutManager(new LinearLayoutManager(mContext));
            mRecyclerViewCountries.setAdapter(countriesAdapter);
        }
    }

}
