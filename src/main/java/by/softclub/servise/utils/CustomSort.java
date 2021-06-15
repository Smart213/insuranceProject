package by.softclub.servise.utils;

import by.softclub.entity.AbstractInsurance;

import java.util.List;
import java.util.stream.Collectors;

public class CustomSort {

    public static List<AbstractInsurance> sortedByInterval(final List<AbstractInsurance> listIn, int from, int to) {
        return listIn.stream()
                .filter(obj -> obj.getInterestRate() >= from)
                .filter(obj -> obj.getInterestRate() <= to)
                .collect(Collectors.toList());
    }
}
