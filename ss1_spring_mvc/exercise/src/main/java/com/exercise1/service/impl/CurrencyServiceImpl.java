package com.exercise1.service.impl;

import com.exercise1.service.ICurrencyService;
import org.springframework.stereotype.Service;

@Service
public class CurrencyServiceImpl implements ICurrencyService {
    @Override
    public Double convertVNDToUSD(double vnd) {
        return vnd *23000;
    }

    @Override
    public Double convertUSDToVND(double usd) {
        return usd/23000;
    }
}
