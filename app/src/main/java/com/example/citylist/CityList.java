package com.example.citylist;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * This is a class that keeps track of a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if that city does not exist
     * @param city
     *      This is the city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This returns a sorted list of cities
     * @return
     *      Return the sorted list of cities
     */
    public List<City> getCities() {
        List<City> cityList = cities;
        Collections.sort(cityList);
        return cityList;
    }

    /**
     * This returns a sorted list of cities sorted by province
     * @param parameter a parameter used to overload the function
     * @return Return the sorted list of cities by province
     */
    public List<City> getCities(int parameter) {
        List<City> cityList = cities;
        Collections.sort(cityList, new Comparator<City>() {
            @Override
            public int compare(City city, City t1) {
                return city.getProvinceName().compareTo(t1.getProvinceName());
            }
        });
        return cityList;
    }

    /**
     * deletes an existing city from the list
     * @param city the object to be deleted
     */
    public void delete(City city){
        if(!cities.contains(city)){
            throw new IllegalArgumentException();
        }
        else{
            cities.remove(city);
        }
    }

    /**
     * counts the total number of objects in the list
     * @return number of objects
     */
    public int count(){
        return cities.size();
    }
}
