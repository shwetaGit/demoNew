package com.app.server.businessservice.appinsight;
import com.app.shared.appinsight.CountryQ;
import java.util.List;

public interface CountryQBzService {

    public List<CountryQ> executeQueryCountryQ(String countryName1) throws Exception;
}
