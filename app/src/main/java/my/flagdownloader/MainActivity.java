package my.flagdownloader;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    /*Создать новый проект с Basic Activity
Загрузить JSON со странами отсюда: https://cristiroma.github.io/countries/data/json/countries.json
Из этого json нужны только поля “name” и “flag_128”
Отобразить список стран на экране - слева флаг, справа имя страны (флаги можно загрузить по https://cristiroma.github.io/countries/data/flags/)
При желании можно использовать любые библиотеки*/


    private RecyclerView mCountriesRecyclerView;
    private CountriesViewModel mCountriesViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCountriesRecyclerView = (RecyclerView) findViewById(R.id.recycler_country_item);
        mCountriesViewModel = new CountriesViewModel(this, mCountriesRecyclerView);
        mCountriesViewModel.getCountriesList();

    }
}
