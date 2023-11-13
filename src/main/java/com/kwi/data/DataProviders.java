package com.kwi.data;

import org.testng.annotations.DataProvider;

/**
 * DataProviders class provides data providers for different test scenarios.
 */
public class DataProviders {

    /**
     * Provides search data for testing.
     *
     * @return An array of search queries.
     */
    @DataProvider(name = "searchData")
    public Object[] getSearchData() {
        return new Object[]{"Core Java Books", "Selenium Books", "Data Structure Books"};
    }

    /**
     * Provides login credentials for testing.
     *
     * @return A 2D array containing pairs of usernames and passwords.
     */
    @DataProvider(name = "credentials")
    public Object[][] getCredentials() {
        return new Object[][]{{"testuser001", "testpass001"}, {"testuser002", "testpass002"}, {"testuser003", "testpass003"}};
    }
}
