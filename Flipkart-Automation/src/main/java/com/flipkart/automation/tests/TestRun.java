package com.flipkart.automation.tests;

import com.flipkart.automation.base.BaseTest;
import com.flipkart.automation.pages.HomePage;
import com.flipkart.automation.pages.ProductPage;
import com.flipkart.automation.pages.SearchPage;

public class TestRun extends BaseTest {

    public static void main(String[] args) throws InterruptedException {

        BaseTest base = new BaseTest();

        try {

            base.setup();

            HomePage home = new HomePage(driver);
            SearchPage search = new SearchPage(driver);

            home.closeLoginPopup();
            home.searchProduct("Bluetooth Speakers");

            Thread.sleep(5000);

            search.applyFilters();
            search.selectFourStarRating();
            search.sortByPrice();

            Thread.sleep(3000);

            search.openFirstProduct();
            search.switchToNewTab();

            Thread.sleep(5000);

            ProductPage productPage = new ProductPage(driver);
            productPage.handleProduct();

           

        } catch (Exception e) {

            System.out.println(e);

        } finally {

            driver.quit();
           
        }
    }
}