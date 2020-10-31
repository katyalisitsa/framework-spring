package com.myapp.interfaces.carpetPrices;

import com.myapp.enums.City;

import java.math.BigDecimal;

public interface Carpet {

    BigDecimal getSqFtPrice(City city);
}
