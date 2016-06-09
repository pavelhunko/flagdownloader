package my.flagdownloader;

import com.google.gson.annotations.SerializedName;

/**
 * Created by pavelhunko on 09.06.2016
 */
public class Country {

    private String name;
    @SerializedName("flag_128")
    private String flag;

    public String getFlag() {
        return flag;
    }

    public String getName() {
        return name;
    }
}
