package my.flagdownloader;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

/**
 * Created by pavelhunko on 10.06.2016
 */
public class CountriesManager {
    private CountriesViewModel mCountriesViewModel;

    // Normally, request  is being done in separate Request class,
    // but for the sake of such a small task staying small,
    // let's just make request and process the response right here.


    public void getCountriesList(CountriesViewModel countriesViewModel, Context context) {
        this.mCountriesViewModel = countriesViewModel;
        StringRequest stringRequest = new StringRequest(Request.Method.GET, BuildConfig.HOSTNAME, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                parseNetworkResponse(response);
                mCountriesViewModel.saveCountries(parseNetworkResponse(response));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        VolleySingleton.getInstance(context).getRequestQueue().add(stringRequest);
    }

    private ArrayList<Country> parseNetworkResponse(String jsonResponse) {
        Gson gson = new Gson();
        ArrayList<Country> countriesResponse = gson.fromJson(jsonResponse, new TypeToken<ArrayList<Country>>() {
        }.getType());
        return countriesResponse;
    }
}
