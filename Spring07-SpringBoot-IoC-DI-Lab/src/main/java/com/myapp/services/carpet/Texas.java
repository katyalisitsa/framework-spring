package com.myapp.services.carpet;

import com.myapp.enums.City;
import com.myapp.interfaces.carpetPrices.Carpet;

public class Texas implements Carpet {
     private static final Map<City, BigDecimal> sqPriceForCity = new HashMap<>();

    static {
        sqPriceForCity.put(City.AUSTIN, new BigDecimal("2.92"));
        sqPriceForCity.put(City.DULLES, new BigDecimal("1.32"));
        sqPriceForCity.put(City.SAN_ANTONIO, new BigDecimal("2.65"));
    }

    @Override
    public BigDecimal getSqFtPrice(City city) {

        BigDecimal defaultValue = BigDecimal.ZERO;

        //Convert Map to Set objects
        //Optional incase value is null, or object in the memory doesn't exist
        Optional <Map.Entry<City, BigDecimal>> collect =  sqPriceForCity.entrySet().stream().filter(x -> x.getKey() == city).findFirst();

        return collect.isPresent() ? collect.get().getValue() : defaultValue;
    }
}
