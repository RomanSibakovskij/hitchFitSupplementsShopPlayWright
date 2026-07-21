package io.github.rokonrj403.utilities;

import com.microsoft.playwright.options.LoadState;
import io.github.rokonrj403.page.data.loggers.PageDataLoggers;
import io.github.rokonrj403.page.text.element.assertion.PageTextElementAsserts;
import io.github.rokonrj403.page.web.element.assertion.PageWebElementAsserts;
import io.github.rokonrj403.pages.*;
import io.github.rokonrj403.pages.utilities.*;

import java.nio.file.Paths;
import java.util.List;

import com.microsoft.playwright.Page;

import static org.junit.jupiter.api.Assertions.*;

public class TestMethods extends BaseTest implements PageWebElementAsserts, PageTextElementAsserts, PageDataLoggers {

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    //add set home page product to cart test method
    protected void addSetHomePageProductToCartTest(int idx, String productName, String secondProductName, String addProductQty, String addAnotherProduct, String firstProductPrice, String secondProductPrice, String subTotalPrice, String deliveryPrice, String totalPrice){
        BasePage basePage = new BasePage(page);
        GeneralPage generalPage = new GeneralPage(page);
        HomePage homePage = new HomePage(page);
        SingleProductPage singleProductPage = new SingleProductPage(page);
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(page);
        //wait for page to load
        basePage.waitForPageLoad(1600);
        //general page web element assert
        isGeneralPageWebElementVisible(page);
        //home page web element assert
        isHomePageWebElementVisible(page);
        //home page text element assert
        isHomePageTextElementAsExpected(page);
        //log home page product data
        logHomePageProductData(page);
        //capture screenshot of the single product page display
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("src/test/screenshots/Home Page/Home Page Display.png")).setFullPage(true));
        //click set product "Choose options" button
        homePage.clickSetChooseButton(idx);
        //wait for login page to load
        page.waitForTimeout(2500);
        //single product page web element assert
        isSingleProductPageWebElementVisible(page);
        //single product page text element assert
        isSingleProductPageTextElementAsExpected(page);
        //log single product page data
        logSingleProductPageProductData(page);
        //assert the user gets onto expected product page
        String actualProduct = singleProductPage.getSingleProductPageTitle();
        assertEquals(productName, actualProduct, "The single product page title doesn't match expectations");
        //capture screenshot of the single product page display
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("src/test/screenshots/Single Product Page/Single Product Page Display.png")).setFullPage(true));

        //add product quantity depending on the parameter
        switch(addProductQty){

            case "Yes":
                //click qty increase button
                singleProductPage.clickQtyIncreaseButton(3);
                break;

            case "No":
                break;

            default:
                throw new Error("Please input either 'Yes' or 'No'.");
        }

        //click "Add to Cart" button
        singleProductPage.clickAddToCartButton();
        //click "OK" prompt
        //page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("OK")).click();

        //add second product name if provided
        switch (addAnotherProduct){

            case "1":
                //click home page icon
                generalPage.clickHeaderHomePageIconLink();
                page.waitForLoadState(LoadState.LOAD);
                //click set product "Choose options" button (set as a static index, for now)
                homePage.clickSetChooseButton(idx + 1);
                //single product page web element assert
                isSingleProductPageWebElementVisible(page);
                //single product page text element assert
                isSingleProductPageTextElementAsExpected(page);
                //log single product page data
                logSingleProductPageProductData(page);
                //assert the user gets onto expected product page
                String actualSecondProduct = singleProductPage.getSingleProductPageTitle();
                assertEquals(secondProductName, actualSecondProduct, "The single product page title doesn't match expectations");
                //capture screenshot of the single product page display
                page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("src/test/screenshots/Single Product Page/Another Single Product Page Display.png")).setFullPage(true));
                //click "Add to Cart" button
                singleProductPage.clickAddToCartButton(); //fails to be clicked for some reason with valid selector
                //click "OK" prompt
                //page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("OK")).click();
                break;

            case "0":
                break;

            default:
                throw new Error("Please input either '1' or '0'.");
        }
        //click upper navbar "Cart" button
        generalPage.clickHeaderShopCartBtn();
        //wait for login page to load
        page.waitForLoadState(LoadState.LOAD);
        //capture screenshot of the shopping cart page display
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("src/test/screenshots/Shopping Cart Page/Shopping Cart Page Display.png")).setFullPage(true));
        //assert the shopping cart table contains the expected product unit price
        List<String> shopCartProductUnitPriceList = shoppingCartPage.getShoppingCartPageProductUnitPrice();
        assertEquals(firstProductPrice, shopCartProductUnitPriceList.getFirst(), "The product unit price in shopping cart doesn't match expectations. Expected: " + firstProductPrice );
        //assert the product price matches
        if(!secondProductName.isEmpty()){
            //assert the shopping cart table contains the other expected product unit price
            //List<String> shopCartProductUnitPriceList = shoppingCartPage.getShoppingCartPageProductTitle();
            assertTrue(shopCartProductUnitPriceList.contains(secondProductPrice), "The other expected product unit price in shopping cart doesn't match expectations. Expected: " + secondProductPrice );
        }
        //assert the shopping cart table contains the expected order subtotal price
        String shopCartProductSubtotalPrice = shoppingCartPage.getShoppingCartOrderSummarySubtotalPrice();
        assertEquals(subTotalPrice, shopCartProductSubtotalPrice, "The order subtotal price in shopping cart doesn't match expectations (shopping cart). Expected: " + shopCartProductSubtotalPrice );
        //assert the shopping cart table contains the expected order total price
        String shopCartProductDeliveryPrice = shoppingCartPage.getShoppingCartPageOrderSummaryDeliveryPrice();
        assertEquals(deliveryPrice, shopCartProductDeliveryPrice, "The order delivery price in shopping cart doesn't match expectations (shopping cart). Expected: " + shopCartProductSubtotalPrice );
        //assert the shopping cart table contains the expected order total price
        String shopCartProductTotalPrice = shoppingCartPage.getShoppingCartPageOrderSummaryTotalPrice();
        assertEquals(totalPrice, shopCartProductTotalPrice, "The order total price in shopping cart doesn't match expectations (shopping cart). Expected: " + shopCartProductSubtotalPrice );
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //add set home page product to cart test method
    protected void addSetProductFromSingleProdCatToCartTest(String productCat, int idx, String productName, String secondProductName, String addProductQty, String addAnotherProduct, String firstProductPrice, String secondProductPrice, String subTotalPrice, String deliveryPrice, String totalPrice){
        BasePage basePage = new BasePage(page);
        GeneralPage generalPage = new GeneralPage(page);
        SingleProductCategoryPage singleProductCategoryPage = new SingleProductCategoryPage(page);
        SingleProductPage singleProductPage = new SingleProductPage(page);
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(page);
        //wait for page to load
        basePage.waitForPageLoad(1600);
        //general page web element assert
        isGeneralPageWebElementVisible(page);
        //general page text element assert
        isGeneralPageTextElementAsExpected(page);
        //home page web element assert
        isHomePageWebElementVisible(page);
        //home page text element assert
        isHomePageTextElementAsExpected(page);
        //log home page product data
        logHomePageProductData(page);
        //capture screenshot of the single product page display
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("src/test/screenshots/Home Page/Home Page Display.png")).setFullPage(true));

        //click set product category link depending on the parameter
        switch(productCat){

            case "Shop All":
                //click "Shop all" upper navbar link
                generalPage.clickSetHeaderNavbarLink(0);
                page.waitForLoadState(LoadState.LOAD);
                break;

            case "Proteins":
                //click "Proteins" upper navbar link
                generalPage.clickSetHeaderNavbarLink(1);
                page.waitForLoadState(LoadState.LOAD);
                break;

            case "Stacks":
                //click "Stacks" upper navbar link
                generalPage.clickSetHeaderNavbarLink(2);
                page.waitForLoadState(LoadState.LOAD);
                break;

            case "Pre-Workouts":
                //click "Pre-Workouts" upper navbar link
                generalPage.clickSetHeaderNavbarLink(3);
                page.waitForLoadState(LoadState.LOAD);
                break;

            case "Daily Nutrition":
                //click "Daily Nutrition" upper navbar link
                generalPage.clickSetHeaderNavbarLink(4);
                page.waitForLoadState(LoadState.LOAD);
                break;

            default:
                throw new Error("Please input either 'Shop All', 'Proteins', 'Stacks', 'Pre-Workouts', 'Daily Nutrition'.");

        }

        //single product category web element assert
        isSingleProductCategoryPageWebElementVisible(page);
        //single product category page text element assert
        isSingleProductCategoryPageTextElementAsExpected(page);
        //log single product category page product data
        logSingleProductCategoryPageProductData(page);

        //click set product "Choose options" button
        singleProductCategoryPage.clickSetChooseButton(idx);
        //wait for login page to load
        page.waitForTimeout(2500);
        //single product page web element assert
        isSingleProductPageWebElementVisible(page);
        //single product page text element assert
        isSingleProductPageTextElementAsExpected(page);
        //log single product page data
        logSingleProductPageProductData(page);
        //assert the user gets onto expected product page
        String actualProduct = singleProductPage.getSingleProductPageTitle();
        assertEquals(productName, actualProduct, "The single product page title doesn't match expectations");
        //capture screenshot of the single product page display
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("src/test/screenshots/Single Product Category Page/Single Product Category Page Display.png")).setFullPage(true));

        //add product quantity depending on the parameter
        switch(addProductQty){

            case "Yes":
                //click qty increase button
                singleProductPage.clickQtyIncreaseButton(3);
                //assert the product quantity gets updated
                String singleProdPageQtyCount = singleProductPage.getSingleProductPageProductQty();
                assertEquals("4", singleProdPageQtyCount, "The product qty didn't get updated in single product page.Expected product count: 4, actual: " + singleProdPageQtyCount);
                break;

            case "No":
                break;

            default:
                throw new Error("Please input either 'Yes' or 'No'.");
        }

        //click "Add to Cart" button
        singleProductPage.clickAddToCartButton();
        //click "OK" prompt
        //page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("ADD TO CART")).click();

        //add second product name if provided
        switch (addAnotherProduct){

            case "1":
                //click home page icon
                generalPage.clickHeaderHomePageIconLink();
                page.waitForLoadState(LoadState.LOAD);
                //click "Shop all" upper navbar link (set as a static index, for now)
                generalPage.clickSetHeaderNavbarLink(0);
                page.waitForLoadState(LoadState.LOAD);
                //click set product "Choose options" button (set as a static index, for now)
                singleProductCategoryPage.clickSetChooseButton(idx + 1);
                //single product page web element assert
                isSingleProductPageWebElementVisible(page);
                //single product page text element assert
                isSingleProductPageTextElementAsExpected(page);
                //log single product page data
                logSingleProductPageProductData(page);
                //assert the user gets onto expected product page
                String actualSecondProduct = singleProductPage.getSingleProductPageTitle();
                assertEquals(secondProductName, actualSecondProduct, "The single product page title doesn't match expectations");
                //capture screenshot of the single product page display
                page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("src/test/screenshots/Single Product Page/Another Single Product Page Display.png")).setFullPage(true));
                //click "Add to Cart" button
                singleProductPage.clickAddToCartButton();
                //click "OK" prompt
                //page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("ADD TO CART")).click();
                break;

            case "0":
                break;

            default:
                throw new Error("Please input either '1' or '0'.");
        }
        //click upper navbar "Cart" button
        generalPage.clickHeaderShopCartBtn();
        //wait for login page to load
        page.waitForLoadState(LoadState.LOAD);
        //capture screenshot of the shopping cart page display
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("src/test/screenshots/Shopping Cart Page/Product(s) Has(Have) Been Added To Shopping Cart Test Result.png")).setFullPage(true));
        //assert the shopping cart table contains the expected product price
        List<String> shopCartProductUnitPriceList = shoppingCartPage.getShoppingCartPageProductUnitPrice();
        assertEquals(firstProductPrice, shopCartProductUnitPriceList.getFirst(), "The product unit price in shopping cart doesn't match expectations. Expected: " + firstProductPrice );
        //assert the product price matches
        if(!secondProductName.isEmpty()){
            //assert the shopping cart table contains the other expected product
            //List<String> shopCartProductUnitPriceList = shoppingCartPage.getShoppingCartPageProductTitle();
            assertTrue(shopCartProductUnitPriceList.contains(secondProductPrice), "The other expected product unit price in shopping cart doesn't match expectations. Expected: " + secondProductPrice );
        }
        //assert the shopping cart table contains the expected order subtotal price
        String shopCartProductSubtotalPrice = shoppingCartPage.getShoppingCartOrderSummarySubtotalPrice();
        assertEquals(subTotalPrice, shopCartProductSubtotalPrice, "The order subtotal price in shopping cart doesn't match expectations (shopping cart). Expected: " + shopCartProductSubtotalPrice );
        //assert the shopping cart table contains the expected order total price
        String shopCartProductDeliveryPrice = shoppingCartPage.getShoppingCartPageOrderSummaryDeliveryPrice();
        assertEquals(deliveryPrice, shopCartProductDeliveryPrice, "The order delivery price in shopping cart doesn't match expectations (shopping cart). Expected: " + shopCartProductSubtotalPrice );
        //assert the shopping cart table contains the expected order total price
        String shopCartProductTotalPrice = shoppingCartPage.getShoppingCartPageOrderSummaryTotalPrice();
        assertEquals(totalPrice, shopCartProductTotalPrice, "The order total price in shopping cart doesn't match expectations (shopping cart). Expected: " + shopCartProductSubtotalPrice );
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //add products to check out test method
    protected void addProductsToCheckoutTest(String productName, String secondProductName, String changeProductQty){
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(page);
        //general page web element assert
        isGeneralPageWebElementVisible(page);
        //general page text element assert
        isGeneralPageTextElementAsExpected(page);
        //shopping cart page web element assert
        isShoppingCartPageWebElementVisible(page);
        //shopping cart page text element assert
        isShoppingCartPageTextElementAsExpected(page);
        //log shopping cart page data
        logShoppingCartPageProductData(page);
        //capture screenshot of the shopping cart page display
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("src/test/screenshots/Shopping Cart Page/Shopping Cart Page Display.png")).setFullPage(true));
        //assert the shopping cart table contains the expected product
        List<String> shopCartProductTitleList = shoppingCartPage.getShoppingCartPageProductTitle();
        assertEquals(productName, shopCartProductTitleList.getFirst(), "The product name doesn't match expectations");
        //assert the product price matches
        if(!secondProductName.isEmpty()){
            //assert the shopping cart table contains the other expected product
            List<String> shopCartProductTitles = shoppingCartPage.getShoppingCartPageProductTitle();
            assertTrue(shopCartProductTitles.contains(secondProductName), "The other expected product isn't present in the list");
        }

        //change or don't change product qty in shopping cart depending on the passed parameter
        switch(changeProductQty){

            case "Change":
                //click set product quantity increase button
                shoppingCartPage.clickSetQtyIncreaseBtn(3, 0);
                //assert the product quantity has been updated
                List<String> firstShopCartProductQtyUpdatedList = shoppingCartPage.getShoppingCartPageProductQty();
                assertEquals("5", firstShopCartProductQtyUpdatedList.getFirst(), "The product qty didn't get updated.Expected product count: 5, actual: " + firstShopCartProductQtyUpdatedList.getFirst());
                //click set product quantity decrease button
                shoppingCartPage.clickSetQtyDecreaseBtn(2, 0);
                //assert the product quantity has been updated
                List<String> secondShopCartProductQtyUpdatedList = shoppingCartPage.getShoppingCartPageProductQty();
                assertEquals("3", secondShopCartProductQtyUpdatedList.getFirst(), "The product qty didn't get updated.Expected product count: 3, actual: " + secondShopCartProductQtyUpdatedList.getFirst());
                break;

            case "Don't change":
                break;

            default:
                throw new Error("Please input either 'Change' or 'Don't change'.");

        }

        //click "Checkout" button
        shoppingCartPage.clickCheckoutButton();
        page.waitForLoadState(LoadState.LOAD);
        //capture screenshot of the checkout page display
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("src/test/screenshots/Checkout Page/Product(s) Has(Have) Been Added To Checkout Test Result.png")).setFullPage(true));
    }

    //remove product from shopping cart page test method
    protected void removeSingleProductFromShoppingCartTest(String productName){
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(page);
        //general page web element assert
        isGeneralPageWebElementVisible(page);
        //general page text element assert
        isGeneralPageTextElementAsExpected(page);
        //shopping cart page web element assert
        isShoppingCartPageWebElementVisible(page);
        //shopping cart page text element assert
        isShoppingCartPageTextElementAsExpected(page);
        //assert the shopping cart table contains the expected product
        List<String> shopCartProductTitleList = shoppingCartPage.getShoppingCartPageProductTitle();
        assertEquals(productName, shopCartProductTitleList.getFirst(), "The product name doesn't match expectations");
        //click set product remove button
        shoppingCartPage.clickSetProductRemoveBtn(0);
        //assert the user gets an expected message
        String emptyShopCartMsg = shoppingCartPage.getShoppingCartPageEmptyCartMsg();
        assertEquals("Your cart is empty.", emptyShopCartMsg, "The empty shopping cart message doesn't match expectations. Expected: 'Your cart is empty.', actual: " + emptyShopCartMsg);
        //capture screenshot of the empty shopping cart display
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("src/test/screenshots/Remove Product From Shopping Cart/Product(s) Has(Have) Been Removed From Shopping Cart Test Result.png")).setFullPage(true));
    }

    //remove set product from shopping cart page test method
    protected void removeSetProductFromShoppingCartTest(int idx, String productName, String removedProductName){
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(page);
        //general page web element assert
        isGeneralPageWebElementVisible(page);
        //general page text element assert
        isGeneralPageTextElementAsExpected(page);
        //shopping cart page web element assert
        isShoppingCartPageWebElementVisible(page);
        //shopping cart page text element assert
        isShoppingCartPageTextElementAsExpected(page);
        //assert the shopping cart table contains the expected product
        List<String> shopCartProductTitleList = shoppingCartPage.getShoppingCartPageProductTitle();
        assertEquals(productName, shopCartProductTitleList.getFirst(), "The product name doesn't match expectations");
        if(!removedProductName.isEmpty()){
            //assert the shopping cart table contains the other expected product
            List<String> shopCartProductTitles = shoppingCartPage.getShoppingCartPageProductTitle();
            assertTrue(shopCartProductTitles.contains(removedProductName), "The other expected product isn't present in the list");
        }
        //click set product remove button
        shoppingCartPage.clickSetProductRemoveBtn(idx);
        //assert the user gets set product removed from the list
        List<String> shopCartProductNameList = shoppingCartPage.getShoppingCartPageProductTitle();
        assertFalse(shopCartProductNameList.contains(removedProductName), "The other product didn't get removed from shopping cart table.");
        //capture screenshot of the empty shopping cart display
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("src/test/screenshots/Remove Set Product From Shopping Cart/Set Product(s) Has(Have) Been Removed From Shopping Cart Test Result.png")).setFullPage(true));
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //valid product checkout test method
    protected void validProductCheckoutTest(String productName, String anotherProductName, String payMethod, String goBackToCart, String firstProductUnitPrice, String secondProductUnitPrice, String subTotalPrice, String deliveryPrice, String totalPrice){
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(page);
        CheckoutPage checkoutPage = new CheckoutPage(page);
        //general page web element assert
        isGeneralPageWebElementVisible(page);
        //general page text element assert
        isGeneralPageTextElementAsExpected(page);
        //checkout page web element assert
        isCheckoutPageWebElementVisible(page);
        //checkout page text element assert
        isCheckoutPageTextElementAsExpected(page);
        //log checkout page product data
        logCheckoutPageProductData(page);
        //assert the shopping cart table contains the expected product
        List<String> checkoutPageProductTitleList = checkoutPage.getCheckoutPageOrderSummaryProductName();
        assertEquals(productName, checkoutPageProductTitleList.getFirst(), "The product name doesn't match expectations");
        //assert the shopping cart table contains the expected product
        List<String> checkoutPageProductUnitPriceList = checkoutPage.getCheckoutPageOrderSummaryProductPrice();
        assertEquals(firstProductUnitPrice, checkoutPageProductUnitPriceList.getFirst(), "The product unit price doesn't match expectations");
        if(!anotherProductName.isEmpty()){
            //assert the shopping cart table contains the other expected product
            List<String> checkoutPageProductTitles = checkoutPage.getCheckoutPageOrderSummaryProductName();
            assertTrue(checkoutPageProductTitles.contains(anotherProductName), "The other expected product isn't present in the list");
            //assert the shopping cart table contains the other expected product
            List<String> checkoutPageProductUnitPrices = checkoutPage.getCheckoutPageOrderSummaryProductPrice();
            assertTrue(checkoutPageProductUnitPrices.contains(secondProductUnitPrice), "The other expected product unit price isn't present in the list");
        }
        //assert the shopping cart table contains the expected order subtotal price
        String checkoutPageOrderSubtotalPrice = checkoutPage.getCheckoutPageOrderSummarySubtotalPrice();
        assertEquals(subTotalPrice, checkoutPageOrderSubtotalPrice, "The order subtotal price in checkout page doesn't match expectations. Expected: " + checkoutPageOrderSubtotalPrice );
        //assert the shopping cart table contains the expected order total price
        String checkoutPageOrderDeliveryPrice = checkoutPage.getCheckoutPageOrderSummaryDeliveryPrice();
        assertEquals(deliveryPrice, checkoutPageOrderDeliveryPrice, "The order delivery price in checkout page doesn't match expectations. Expected: " + checkoutPageOrderSubtotalPrice );
        //assert the shopping cart table contains the expected order total price
        String checkoutPageOrderTotalPrice = checkoutPage.getCheckoutPageOrderSummaryTotalPrice();
        assertEquals(totalPrice, checkoutPageOrderTotalPrice, "The order total price in checkout page doesn't match expectations. Expected: " + checkoutPageOrderSubtotalPrice );

        //select set payment method
        switch(payMethod){

            case "Cash":
                //click "Cash on delivery" radio button
                checkoutPage.clickSetPayMethodRadioButton(0);
                break;

            case "bKash":
                //click "bKash" radio button
                checkoutPage.clickSetPayMethodRadioButton(1);
                break;

            case "Nagad":
                //click "Nagad" radio button
                checkoutPage.clickSetPayMethodRadioButton(2);
                break;

            default:
                throw new Error("Please input either 'Cash', 'bKash' or 'Nagad'.");
        }

        //go back to cart or don't
        switch(goBackToCart){

            case "Yes":
                //click "Edit cart" link
                checkoutPage.clickEditCartLink();
                page.waitForLoadState(LoadState.LOAD);
                //general page web element assert
                isGeneralPageWebElementVisible(page);
                //general page text element assert
                isGeneralPageTextElementAsExpected(page);
                //shopping cart page web element assert
                isShoppingCartPageWebElementVisible(page);
                //shopping cart page text element assert
                isShoppingCartPageTextElementAsExpected(page);
                //click "Checkout" button
                shoppingCartPage.clickCheckoutButton();
                page.waitForLoadState(LoadState.LOAD);
                //general page web element assert
                isGeneralPageWebElementVisible(page);
                //general page text element assert
                isGeneralPageTextElementAsExpected(page);
                //checkout page web element assert
                isCheckoutPageWebElementVisible(page);
                //checkout page text element assert
                isCheckoutPageTextElementAsExpected(page);
                //assert the shopping cart table contains the expected product
                List<String> checkoutPageProductTitleListAfterReturn = checkoutPage.getCheckoutPageOrderSummaryProductName();
                assertEquals(productName, checkoutPageProductTitleListAfterReturn.getFirst(), "The product name doesn't match expectations");
                //assert the shopping cart table contains the expected product
                List<String> checkoutPageProductUnitPriceListAfterReturn = checkoutPage.getCheckoutPageOrderSummaryProductPrice();
                assertEquals(firstProductUnitPrice, checkoutPageProductUnitPriceListAfterReturn.getFirst(), "The product unit price doesn't match expectations");
                if(!anotherProductName.isEmpty()){
                    //assert the shopping cart table contains the other expected product
                    List<String> checkoutPageProductTitles = checkoutPage.getCheckoutPageOrderSummaryProductName();
                    assertTrue(checkoutPageProductTitles.contains(anotherProductName), "The other expected product isn't present in the list");
                    //assert the shopping cart table contains the other expected product
                    List<String> checkoutPageProductUnitPrices = checkoutPage.getCheckoutPageOrderSummaryProductPrice();
                    assertTrue(checkoutPageProductUnitPrices.contains(secondProductUnitPrice), "The other expected product unit price isn't present in the list");
                }
                //assert the shopping cart table contains the expected order subtotal price
                assertEquals(subTotalPrice, checkoutPageOrderSubtotalPrice, "The order subtotal price in checkout page doesn't match expectations. Expected: " + checkoutPageOrderSubtotalPrice );
                //assert the shopping cart table contains the expected order total price
                assertEquals(deliveryPrice, checkoutPageOrderDeliveryPrice, "The order delivery price in checkout page doesn't match expectations. Expected: " + checkoutPageOrderSubtotalPrice );
                //assert the shopping cart table contains the expected order total price
                assertEquals(totalPrice, checkoutPageOrderTotalPrice, "The order total price in checkout page doesn't match expectations. Expected: " + checkoutPageOrderSubtotalPrice );

                break;

            case "No":
                break;

            default:
                throw new Error("Please input either 'Yes' or 'No'.");
        }
        //capture screenshot of the checkout page display
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("src/test/screenshots/Checkout Page/Checkout Page Display.png")).setFullPage(true));
        //valid delivery details input data getter
        checkoutPage.validCheckoutDeliveryInputDataGetter();
        //input valid full name into full name input field
        checkoutPage.inputFullNameIntoFullNameInputField();
        //input valid phone into phone input field
        checkoutPage.inputPhoneIntoPhoneInputField();
        //input valid email into email input field (it's optional)
        checkoutPage.inputEmailIntoEmailInputField();
        //input valid address into address input field
        checkoutPage.inputAddressIntoAddressTextarea();
        //input valid city into city input field
        checkoutPage.inputCityIntoCityInputField();
        //capture screenshot of the delivery details input display
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("src/test/screenshots/Checkout Page/Valid Checkout Delivery Details Input Display.png")).setFullPage(true));

        //click "Place order" button
        checkoutPage.clickPlaceOrderBtn();
        page.waitForTimeout(3000);
        //order success section web element assert
        isCheckoutPageOrderSuccessSectionWebElementVisible(page);
        //order success section text element assert
        isCheckoutPageOrderSuccessSecTextElementAsExpected(page);
        //log order success section data
        logCheckoutPageOrderSuccessData(page);
        //capture screenshot of the checkout page display
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("src/test/screenshots/Checkout Page/Successful Product Checkout Test Result.png")).setFullPage(true));
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //invalid product checkout test method - no delivery full name
    protected void invalidProductCheckoutNoFullNameTest(String productName, String anotherProductName, String payMethod, String firstProductUnitPrice, String secondProductUnitPrice, String subTotalPrice, String deliveryPrice, String totalPrice){
        CheckoutPage checkoutPage = new CheckoutPage(page);
        CheckoutPageInvalidSingularInput checkoutPageInvalidSingularInput = new CheckoutPageInvalidSingularInput(page);
        //general page web element assert
        isGeneralPageWebElementVisible(page);
        //general page text element assert
        isGeneralPageTextElementAsExpected(page);
        //checkout page web element assert
        isCheckoutPageWebElementVisible(page);
        //checkout page text element assert
        isCheckoutPageTextElementAsExpected(page);
        //log checkout page product data
        logCheckoutPageProductData(page);
        //assert the shopping cart table contains the expected product
        List<String> checkoutPageProductTitleList = checkoutPage.getCheckoutPageOrderSummaryProductName();
        assertEquals(productName, checkoutPageProductTitleList.getFirst(), "The product name doesn't match expectations");
        //assert the shopping cart table contains the expected product
        List<String> checkoutPageProductUnitPriceList = checkoutPage.getCheckoutPageOrderSummaryProductPrice();
        assertEquals(firstProductUnitPrice, checkoutPageProductUnitPriceList.getFirst(), "The product unit price doesn't match expectations");
        if(!anotherProductName.isEmpty()){
            //assert the shopping cart table contains the other expected product
            List<String> checkoutPageProductTitles = checkoutPage.getCheckoutPageOrderSummaryProductName();
            assertTrue(checkoutPageProductTitles.contains(anotherProductName), "The other expected product isn't present in the list");
            //assert the shopping cart table contains the other expected product
            List<String> checkoutPageProductUnitPrices = checkoutPage.getCheckoutPageOrderSummaryProductPrice();
            assertTrue(checkoutPageProductUnitPrices.contains(secondProductUnitPrice), "The other expected product unit price isn't present in the list");
        }
        //assert the shopping cart table contains the expected order subtotal price
        String checkoutPageOrderSubtotalPrice = checkoutPage.getCheckoutPageOrderSummarySubtotalPrice();
        assertEquals(subTotalPrice, checkoutPageOrderSubtotalPrice, "The order subtotal price in checkout page doesn't match expectations. Expected: " + checkoutPageOrderSubtotalPrice );
        //assert the shopping cart table contains the expected order total price
        String checkoutPageOrderDeliveryPrice = checkoutPage.getCheckoutPageOrderSummaryDeliveryPrice();
        assertEquals(deliveryPrice, checkoutPageOrderDeliveryPrice, "The order delivery price in checkout page doesn't match expectations. Expected: " + checkoutPageOrderSubtotalPrice );
        //assert the shopping cart table contains the expected order total price
        String checkoutPageOrderTotalPrice = checkoutPage.getCheckoutPageOrderSummaryTotalPrice();
        assertEquals(totalPrice, checkoutPageOrderTotalPrice, "The order total price in checkout page doesn't match expectations. Expected: " + checkoutPageOrderSubtotalPrice );

        //select set payment method
        switch(payMethod){

            case "Cash":
                //click "Cash on delivery" radio button
                checkoutPage.clickSetPayMethodRadioButton(0);
                break;

            case "bKash":
                //click "bKash" radio button
                checkoutPage.clickSetPayMethodRadioButton(1);
                break;

            case "Nagad":
                //click "Nagad" radio button
                checkoutPage.clickSetPayMethodRadioButton(2);
                break;

            default:
                throw new Error("Please input either 'Cash', 'bKash' or 'Nagad'.");
        }

        //capture screenshot of the checkout page display
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("src/test/screenshots/Checkout Page/Checkout Page Display.png")).setFullPage(true));
        //valid delivery details input data getter
        checkoutPageInvalidSingularInput.invalidCheckoutDeliveryNoFullNameDataGetter();
        //don't input valid full name into full name input field
        checkoutPageInvalidSingularInput.inputNoFullNameIntoFullNameInputField();
        //input valid phone into phone input field
        checkoutPageInvalidSingularInput.inputPhoneIntoPhoneInputField();
        //input valid address into address input field
        checkoutPageInvalidSingularInput.inputAddressIntoAddressTextarea();
        //input valid city into city input field
        checkoutPageInvalidSingularInput.inputCityIntoCityInputField();
        //capture screenshot of the invalid delivery details input display - no full name
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("src/test/screenshots/Invalid Checkout Page Tests/Invalid Checkout Delivery Details Input Display - No Delivery Full Name.png")).setFullPage(true));

        //click "Place order" button
        checkoutPage.clickPlaceOrderBtn();
        page.waitForTimeout(3000);
        //capture screenshot of the test result
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("src/test/screenshots/Invalid Checkout Page Test Results/Invalid Checkout Test Result - No Delivery Full Name Input.png")).setFullPage(true));
        //assert the user stays on the checkout page (since there's only React error displayed)
        boolean orderSuccessMsgTitleElem = checkoutPage.isCheckoutPageOrderSuccessMsgTitleVisible();
        if(orderSuccessMsgTitleElem){throw new Error("The checkout was successful without full name input, test has failed");}
    }

    //invalid product checkout test method - no delivery phone
    protected void invalidProductCheckoutNoPhoneTest(String productName, String anotherProductName, String payMethod, String firstProductUnitPrice, String secondProductUnitPrice, String subTotalPrice, String deliveryPrice, String totalPrice){
        CheckoutPage checkoutPage = new CheckoutPage(page);
        CheckoutPageInvalidSingularInput checkoutPageInvalidSingularInput = new CheckoutPageInvalidSingularInput(page);
        //general page web element assert
        isGeneralPageWebElementVisible(page);
        //general page text element assert
        isGeneralPageTextElementAsExpected(page);
        //checkout page web element assert
        isCheckoutPageWebElementVisible(page);
        //checkout page text element assert
        isCheckoutPageTextElementAsExpected(page);
        //log checkout page product data
        logCheckoutPageProductData(page);
        //assert the shopping cart table contains the expected product
        List<String> checkoutPageProductTitleList = checkoutPage.getCheckoutPageOrderSummaryProductName();
        assertEquals(productName, checkoutPageProductTitleList.getFirst(), "The product name doesn't match expectations");
        //assert the shopping cart table contains the expected product
        List<String> checkoutPageProductUnitPriceList = checkoutPage.getCheckoutPageOrderSummaryProductPrice();
        assertEquals(firstProductUnitPrice, checkoutPageProductUnitPriceList.getFirst(), "The product unit price doesn't match expectations");
        if(!anotherProductName.isEmpty()){
            //assert the shopping cart table contains the other expected product
            List<String> checkoutPageProductTitles = checkoutPage.getCheckoutPageOrderSummaryProductName();
            assertTrue(checkoutPageProductTitles.contains(anotherProductName), "The other expected product isn't present in the list");
            //assert the shopping cart table contains the other expected product
            List<String> checkoutPageProductUnitPrices = checkoutPage.getCheckoutPageOrderSummaryProductPrice();
            assertTrue(checkoutPageProductUnitPrices.contains(secondProductUnitPrice), "The other expected product unit price isn't present in the list");
        }
        //assert the shopping cart table contains the expected order subtotal price
        String checkoutPageOrderSubtotalPrice = checkoutPage.getCheckoutPageOrderSummarySubtotalPrice();
        assertEquals(subTotalPrice, checkoutPageOrderSubtotalPrice, "The order subtotal price in checkout page doesn't match expectations. Expected: " + checkoutPageOrderSubtotalPrice );
        //assert the shopping cart table contains the expected order total price
        String checkoutPageOrderDeliveryPrice = checkoutPage.getCheckoutPageOrderSummaryDeliveryPrice();
        assertEquals(deliveryPrice, checkoutPageOrderDeliveryPrice, "The order delivery price in checkout page doesn't match expectations. Expected: " + checkoutPageOrderSubtotalPrice );
        //assert the shopping cart table contains the expected order total price
        String checkoutPageOrderTotalPrice = checkoutPage.getCheckoutPageOrderSummaryTotalPrice();
        assertEquals(totalPrice, checkoutPageOrderTotalPrice, "The order total price in checkout page doesn't match expectations. Expected: " + checkoutPageOrderSubtotalPrice );

        //select set payment method
        switch(payMethod){

            case "Cash":
                //click "Cash on delivery" radio button
                checkoutPage.clickSetPayMethodRadioButton(0);
                break;

            case "bKash":
                //click "bKash" radio button
                checkoutPage.clickSetPayMethodRadioButton(1);
                break;

            case "Nagad":
                //click "Nagad" radio button
                checkoutPage.clickSetPayMethodRadioButton(2);
                break;

            default:
                throw new Error("Please input either 'Cash', 'bKash' or 'Nagad'.");
        }

        //capture screenshot of the checkout page display
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("src/test/screenshots/Checkout Page/Checkout Page Display.png")).setFullPage(true));
        //invalid delivery details input data getter - no phone
        checkoutPageInvalidSingularInput.invalidCheckoutDeliveryNoPhoneDataGetter();
        //input valid full name into full name input field
        checkoutPageInvalidSingularInput.inputFullNameIntoFullNameInputField();
        //don't input valid phone into phone input field
        checkoutPageInvalidSingularInput.inputNoPhoneIntoPhoneInputField();
        //input valid address into address input field
        checkoutPageInvalidSingularInput.inputAddressIntoAddressTextarea();
        //input valid city into city input field
        checkoutPageInvalidSingularInput.inputCityIntoCityInputField();
        //capture screenshot of the invalid delivery details input display - no phone
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("src/test/screenshots/Invalid Checkout Page Tests/Invalid Checkout Delivery Details Input Display - No Delivery Phone.png")).setFullPage(true));

        //click "Place order" button
        checkoutPage.clickPlaceOrderBtn();
        page.waitForTimeout(3000);
        //capture screenshot of the test result
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("src/test/screenshots/Invalid Checkout Page Test Results/Invalid Checkout Test Result - No Delivery Phone Input.png")).setFullPage(true));
        //assert the user stays on the checkout page (since there's only React error displayed)
        boolean orderSuccessMsgTitleElem = checkoutPage.isCheckoutPageOrderSuccessMsgTitleVisible();
        if(orderSuccessMsgTitleElem){throw new Error("The checkout was successful without phone input, test has failed");}
    }

    //invalid product checkout test method - no delivery address
    protected void invalidProductCheckoutNoAddressTest(String productName, String anotherProductName, String payMethod, String firstProductUnitPrice, String secondProductUnitPrice, String subTotalPrice, String deliveryPrice, String totalPrice){
        CheckoutPage checkoutPage = new CheckoutPage(page);
        CheckoutPageInvalidSingularInput checkoutPageInvalidSingularInput = new CheckoutPageInvalidSingularInput(page);
        //general page web element assert
        isGeneralPageWebElementVisible(page);
        //general page text element assert
        isGeneralPageTextElementAsExpected(page);
        //checkout page web element assert
        isCheckoutPageWebElementVisible(page);
        //checkout page text element assert
        isCheckoutPageTextElementAsExpected(page);
        //log checkout page product data
        logCheckoutPageProductData(page);
        //assert the shopping cart table contains the expected product
        List<String> checkoutPageProductTitleList = checkoutPage.getCheckoutPageOrderSummaryProductName();
        assertEquals(productName, checkoutPageProductTitleList.getFirst(), "The product name doesn't match expectations");
        //assert the shopping cart table contains the expected product
        List<String> checkoutPageProductUnitPriceList = checkoutPage.getCheckoutPageOrderSummaryProductPrice();
        assertEquals(firstProductUnitPrice, checkoutPageProductUnitPriceList.getFirst(), "The product unit price doesn't match expectations");
        if(!anotherProductName.isEmpty()){
            //assert the shopping cart table contains the other expected product
            List<String> checkoutPageProductTitles = checkoutPage.getCheckoutPageOrderSummaryProductName();
            assertTrue(checkoutPageProductTitles.contains(anotherProductName), "The other expected product isn't present in the list");
            //assert the shopping cart table contains the other expected product
            List<String> checkoutPageProductUnitPrices = checkoutPage.getCheckoutPageOrderSummaryProductPrice();
            assertTrue(checkoutPageProductUnitPrices.contains(secondProductUnitPrice), "The other expected product unit price isn't present in the list");
        }
        //assert the shopping cart table contains the expected order subtotal price
        String checkoutPageOrderSubtotalPrice = checkoutPage.getCheckoutPageOrderSummarySubtotalPrice();
        assertEquals(subTotalPrice, checkoutPageOrderSubtotalPrice, "The order subtotal price in checkout page doesn't match expectations. Expected: " + checkoutPageOrderSubtotalPrice );
        //assert the shopping cart table contains the expected order total price
        String checkoutPageOrderDeliveryPrice = checkoutPage.getCheckoutPageOrderSummaryDeliveryPrice();
        assertEquals(deliveryPrice, checkoutPageOrderDeliveryPrice, "The order delivery price in checkout page doesn't match expectations. Expected: " + checkoutPageOrderSubtotalPrice );
        //assert the shopping cart table contains the expected order total price
        String checkoutPageOrderTotalPrice = checkoutPage.getCheckoutPageOrderSummaryTotalPrice();
        assertEquals(totalPrice, checkoutPageOrderTotalPrice, "The order total price in checkout page doesn't match expectations. Expected: " + checkoutPageOrderSubtotalPrice );

        //select set payment method
        switch(payMethod){

            case "Cash":
                //click "Cash on delivery" radio button
                checkoutPage.clickSetPayMethodRadioButton(0);
                break;

            case "bKash":
                //click "bKash" radio button
                checkoutPage.clickSetPayMethodRadioButton(1);
                break;

            case "Nagad":
                //click "Nagad" radio button
                checkoutPage.clickSetPayMethodRadioButton(2);
                break;

            default:
                throw new Error("Please input either 'Cash', 'bKash' or 'Nagad'.");
        }

        //capture screenshot of the checkout page display
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("src/test/screenshots/Checkout Page/Checkout Page Display.png")).setFullPage(true));
        //invalid delivery details input data getter - no address
        checkoutPageInvalidSingularInput.invalidCheckoutDeliveryNoAddressDataGetter();
        //input valid full name into full name input field
        checkoutPageInvalidSingularInput.inputFullNameIntoFullNameInputField();
        //input valid phone into phone input field
        checkoutPageInvalidSingularInput.inputPhoneIntoPhoneInputField();
        //don't input valid address into address input field
        checkoutPageInvalidSingularInput.inputNoAddressIntoAddressTextarea();
        //input valid city into city input field
        checkoutPageInvalidSingularInput.inputCityIntoCityInputField();
        //capture screenshot of the invalid delivery details input display - no address
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("src/test/screenshots/Invalid Checkout Page Tests/Invalid Checkout Delivery Details Input Display - No Delivery Address.png")).setFullPage(true));

        //click "Place order" button
        checkoutPage.clickPlaceOrderBtn();
        page.waitForTimeout(3000);
        //capture screenshot of the test result
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("src/test/screenshots/Invalid Checkout Page Test Results/Invalid Checkout Test Result - No Delivery Address Input.png")).setFullPage(true));
        //assert the user stays on the checkout page (since there's only React error displayed)
        boolean orderSuccessMsgTitleElem = checkoutPage.isCheckoutPageOrderSuccessMsgTitleVisible();
        if(orderSuccessMsgTitleElem){throw new Error("The checkout was successful without address input, test has failed");}
    }

    //invalid product checkout test method - no delivery city
    protected void invalidProductCheckoutNoCityTest(String productName, String anotherProductName, String payMethod, String firstProductUnitPrice, String secondProductUnitPrice, String subTotalPrice, String deliveryPrice, String totalPrice){
        CheckoutPage checkoutPage = new CheckoutPage(page);
        CheckoutPageInvalidSingularInput checkoutPageInvalidSingularInput = new CheckoutPageInvalidSingularInput(page);
        //general page web element assert
        isGeneralPageWebElementVisible(page);
        //general page text element assert
        isGeneralPageTextElementAsExpected(page);
        //checkout page web element assert
        isCheckoutPageWebElementVisible(page);
        //checkout page text element assert
        isCheckoutPageTextElementAsExpected(page);
        //log checkout page product data
        logCheckoutPageProductData(page);
        //assert the shopping cart table contains the expected product
        List<String> checkoutPageProductTitleList = checkoutPage.getCheckoutPageOrderSummaryProductName();
        assertEquals(productName, checkoutPageProductTitleList.getFirst(), "The product name doesn't match expectations");
        //assert the shopping cart table contains the expected product
        List<String> checkoutPageProductUnitPriceList = checkoutPage.getCheckoutPageOrderSummaryProductPrice();
        assertEquals(firstProductUnitPrice, checkoutPageProductUnitPriceList.getFirst(), "The product unit price doesn't match expectations");
        if(!anotherProductName.isEmpty()){
            //assert the shopping cart table contains the other expected product
            List<String> checkoutPageProductTitles = checkoutPage.getCheckoutPageOrderSummaryProductName();
            assertTrue(checkoutPageProductTitles.contains(anotherProductName), "The other expected product isn't present in the list");
            //assert the shopping cart table contains the other expected product
            List<String> checkoutPageProductUnitPrices = checkoutPage.getCheckoutPageOrderSummaryProductPrice();
            assertTrue(checkoutPageProductUnitPrices.contains(secondProductUnitPrice), "The other expected product unit price isn't present in the list");
        }
        //assert the shopping cart table contains the expected order subtotal price
        String checkoutPageOrderSubtotalPrice = checkoutPage.getCheckoutPageOrderSummarySubtotalPrice();
        assertEquals(subTotalPrice, checkoutPageOrderSubtotalPrice, "The order subtotal price in checkout page doesn't match expectations. Expected: " + checkoutPageOrderSubtotalPrice );
        //assert the shopping cart table contains the expected order total price
        String checkoutPageOrderDeliveryPrice = checkoutPage.getCheckoutPageOrderSummaryDeliveryPrice();
        assertEquals(deliveryPrice, checkoutPageOrderDeliveryPrice, "The order delivery price in checkout page doesn't match expectations. Expected: " + checkoutPageOrderSubtotalPrice );
        //assert the shopping cart table contains the expected order total price
        String checkoutPageOrderTotalPrice = checkoutPage.getCheckoutPageOrderSummaryTotalPrice();
        assertEquals(totalPrice, checkoutPageOrderTotalPrice, "The order total price in checkout page doesn't match expectations. Expected: " + checkoutPageOrderSubtotalPrice );

        //select set payment method
        switch(payMethod){

            case "Cash":
                //click "Cash on delivery" radio button
                checkoutPage.clickSetPayMethodRadioButton(0);
                break;

            case "bKash":
                //click "bKash" radio button
                checkoutPage.clickSetPayMethodRadioButton(1);
                break;

            case "Nagad":
                //click "Nagad" radio button
                checkoutPage.clickSetPayMethodRadioButton(2);
                break;

            default:
                throw new Error("Please input either 'Cash', 'bKash' or 'Nagad'.");
        }

        //capture screenshot of the checkout page display
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("src/test/screenshots/Checkout Page/Checkout Page Display.png")).setFullPage(true));
        //invalid delivery details input data getter - no city
        checkoutPageInvalidSingularInput.invalidCheckoutDeliveryNoCityDataGetter();
        //input valid full name into full name input field
        checkoutPageInvalidSingularInput.inputFullNameIntoFullNameInputField();
        //input valid phone into phone input field
        checkoutPageInvalidSingularInput.inputPhoneIntoPhoneInputField();
        //input valid address into address input field
        checkoutPageInvalidSingularInput.inputAddressIntoAddressTextarea();
        //don't input valid city into city input field
        checkoutPageInvalidSingularInput.inputNoCityIntoCityInputField();
        //capture screenshot of the invalid delivery details input display - no city
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("src/test/screenshots/Invalid Checkout Page Tests/Invalid Checkout Delivery Details Input Display - No Delivery City.png")).setFullPage(true));

        //click "Place order" button
        checkoutPage.clickPlaceOrderBtn();
        page.waitForTimeout(3000);
        //capture screenshot of the test result
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("src/test/screenshots/Invalid Checkout Page Test Results/Invalid Checkout Test Result - No Delivery City Input.png")).setFullPage(true));
        //assert the user stays on the checkout page (since there's only React error displayed)
        boolean orderSuccessMsgTitleElem = checkoutPage.isCheckoutPageOrderSuccessMsgTitleVisible();
        if(orderSuccessMsgTitleElem){throw new Error("The checkout was successful without city input, test has failed");}
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //invalid product checkout test method - too short delivery full name (3 chars)
    protected void invalidProductCheckoutTooShortFullNameTest(String productName, String anotherProductName, String payMethod, String firstProductUnitPrice, String secondProductUnitPrice, String subTotalPrice, String deliveryPrice, String totalPrice){
        CheckoutPage checkoutPage = new CheckoutPage(page);
        CheckoutPageInvalidSingularInput checkoutPageInvalidSingularInput = new CheckoutPageInvalidSingularInput(page);
        //general page web element assert
        isGeneralPageWebElementVisible(page);
        //general page text element assert
        isGeneralPageTextElementAsExpected(page);
        //checkout page web element assert
        isCheckoutPageWebElementVisible(page);
        //checkout page text element assert
        isCheckoutPageTextElementAsExpected(page);
        //log checkout page product data
        logCheckoutPageProductData(page);
        //assert the shopping cart table contains the expected product
        List<String> checkoutPageProductTitleList = checkoutPage.getCheckoutPageOrderSummaryProductName();
        assertEquals(productName, checkoutPageProductTitleList.getFirst(), "The product name doesn't match expectations");
        //assert the shopping cart table contains the expected product
        List<String> checkoutPageProductUnitPriceList = checkoutPage.getCheckoutPageOrderSummaryProductPrice();
        assertEquals(firstProductUnitPrice, checkoutPageProductUnitPriceList.getFirst(), "The product unit price doesn't match expectations");
        if(!anotherProductName.isEmpty()){
            //assert the shopping cart table contains the other expected product
            List<String> checkoutPageProductTitles = checkoutPage.getCheckoutPageOrderSummaryProductName();
            assertTrue(checkoutPageProductTitles.contains(anotherProductName), "The other expected product isn't present in the list");
            //assert the shopping cart table contains the other expected product
            List<String> checkoutPageProductUnitPrices = checkoutPage.getCheckoutPageOrderSummaryProductPrice();
            assertTrue(checkoutPageProductUnitPrices.contains(secondProductUnitPrice), "The other expected product unit price isn't present in the list");
        }
        //assert the shopping cart table contains the expected order subtotal price
        String checkoutPageOrderSubtotalPrice = checkoutPage.getCheckoutPageOrderSummarySubtotalPrice();
        assertEquals(subTotalPrice, checkoutPageOrderSubtotalPrice, "The order subtotal price in checkout page doesn't match expectations. Expected: " + checkoutPageOrderSubtotalPrice );
        //assert the shopping cart table contains the expected order total price
        String checkoutPageOrderDeliveryPrice = checkoutPage.getCheckoutPageOrderSummaryDeliveryPrice();
        assertEquals(deliveryPrice, checkoutPageOrderDeliveryPrice, "The order delivery price in checkout page doesn't match expectations. Expected: " + checkoutPageOrderSubtotalPrice );
        //assert the shopping cart table contains the expected order total price
        String checkoutPageOrderTotalPrice = checkoutPage.getCheckoutPageOrderSummaryTotalPrice();
        assertEquals(totalPrice, checkoutPageOrderTotalPrice, "The order total price in checkout page doesn't match expectations. Expected: " + checkoutPageOrderSubtotalPrice );

        //select set payment method
        switch(payMethod){

            case "Cash":
                //click "Cash on delivery" radio button
                checkoutPage.clickSetPayMethodRadioButton(0);
                break;

            case "bKash":
                //click "bKash" radio button
                checkoutPage.clickSetPayMethodRadioButton(1);
                break;

            case "Nagad":
                //click "Nagad" radio button
                checkoutPage.clickSetPayMethodRadioButton(2);
                break;

            default:
                throw new Error("Please input either 'Cash', 'bKash' or 'Nagad'.");
        }

        //capture screenshot of the checkout page display
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("src/test/screenshots/Checkout Page/Checkout Page Display.png")).setFullPage(true));
        //invalid delivery details input data getter - too short delivery full name (3 chars)
        checkoutPageInvalidSingularInput.invalidCheckoutDeliveryTooShortFullNameDataGetter();
        //input too short full name into full name input field (3 chars)
        checkoutPageInvalidSingularInput.inputTooShortFullNameIntoFullNameInputField();
        //input valid phone into phone input field
        checkoutPageInvalidSingularInput.inputPhoneIntoPhoneInputField();
        //input valid address into address input field
        checkoutPageInvalidSingularInput.inputAddressIntoAddressTextarea();
        //input valid city into city input field
        checkoutPageInvalidSingularInput.inputCityIntoCityInputField();
        //capture screenshot of the invalid delivery details input display - too short full name
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("src/test/screenshots/Invalid Checkout Page Tests/Invalid Checkout Delivery Details Input Display - Too Short Delivery Full Name.png")).setFullPage(true));

        //click "Place order" button
        checkoutPage.clickPlaceOrderBtn();
        page.waitForTimeout(3000);
        //capture screenshot of the test result
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("src/test/screenshots/Invalid Checkout Page Test Results/Invalid Checkout Test Result - Too Short Delivery Full Name Input.png")).setFullPage(true));
        //assert the user stays on the checkout page, throw an error otherwise
        boolean orderSuccessMsgTitleElem = checkoutPage.isCheckoutPageOrderSuccessMsgTitleVisible();
        if(orderSuccessMsgTitleElem){throw new Error("The checkout was successful with too short full name input, test has failed");}
    }

    //invalid product checkout test method - too short delivery phone (2 digits)
    protected void invalidProductCheckoutTooShortPhoneTest(String productName, String anotherProductName, String payMethod, String firstProductUnitPrice, String secondProductUnitPrice, String subTotalPrice, String deliveryPrice, String totalPrice){
        CheckoutPage checkoutPage = new CheckoutPage(page);
        CheckoutPageInvalidSingularInput checkoutPageInvalidSingularInput = new CheckoutPageInvalidSingularInput(page);
        //general page web element assert
        isGeneralPageWebElementVisible(page);
        //general page text element assert
        isGeneralPageTextElementAsExpected(page);
        //checkout page web element assert
        isCheckoutPageWebElementVisible(page);
        //checkout page text element assert
        isCheckoutPageTextElementAsExpected(page);
        //log checkout page product data
        logCheckoutPageProductData(page);
        //assert the shopping cart table contains the expected product
        List<String> checkoutPageProductTitleList = checkoutPage.getCheckoutPageOrderSummaryProductName();
        assertEquals(productName, checkoutPageProductTitleList.getFirst(), "The product name doesn't match expectations");
        //assert the shopping cart table contains the expected product
        List<String> checkoutPageProductUnitPriceList = checkoutPage.getCheckoutPageOrderSummaryProductPrice();
        assertEquals(firstProductUnitPrice, checkoutPageProductUnitPriceList.getFirst(), "The product unit price doesn't match expectations");
        if(!anotherProductName.isEmpty()){
            //assert the shopping cart table contains the other expected product
            List<String> checkoutPageProductTitles = checkoutPage.getCheckoutPageOrderSummaryProductName();
            assertTrue(checkoutPageProductTitles.contains(anotherProductName), "The other expected product isn't present in the list");
            //assert the shopping cart table contains the other expected product
            List<String> checkoutPageProductUnitPrices = checkoutPage.getCheckoutPageOrderSummaryProductPrice();
            assertTrue(checkoutPageProductUnitPrices.contains(secondProductUnitPrice), "The other expected product unit price isn't present in the list");
        }
        //assert the shopping cart table contains the expected order subtotal price
        String checkoutPageOrderSubtotalPrice = checkoutPage.getCheckoutPageOrderSummarySubtotalPrice();
        assertEquals(subTotalPrice, checkoutPageOrderSubtotalPrice, "The order subtotal price in checkout page doesn't match expectations. Expected: " + checkoutPageOrderSubtotalPrice );
        //assert the shopping cart table contains the expected order total price
        String checkoutPageOrderDeliveryPrice = checkoutPage.getCheckoutPageOrderSummaryDeliveryPrice();
        assertEquals(deliveryPrice, checkoutPageOrderDeliveryPrice, "The order delivery price in checkout page doesn't match expectations. Expected: " + checkoutPageOrderSubtotalPrice );
        //assert the shopping cart table contains the expected order total price
        String checkoutPageOrderTotalPrice = checkoutPage.getCheckoutPageOrderSummaryTotalPrice();
        assertEquals(totalPrice, checkoutPageOrderTotalPrice, "The order total price in checkout page doesn't match expectations. Expected: " + checkoutPageOrderSubtotalPrice );

        //select set payment method
        switch(payMethod){

            case "Cash":
                //click "Cash on delivery" radio button
                checkoutPage.clickSetPayMethodRadioButton(0);
                break;

            case "bKash":
                //click "bKash" radio button
                checkoutPage.clickSetPayMethodRadioButton(1);
                break;

            case "Nagad":
                //click "Nagad" radio button
                checkoutPage.clickSetPayMethodRadioButton(2);
                break;

            default:
                throw new Error("Please input either 'Cash', 'bKash' or 'Nagad'.");
        }

        //capture screenshot of the checkout page display
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("src/test/screenshots/Checkout Page/Checkout Page Display.png")).setFullPage(true));
        //invalid delivery details input data getter - too short phone (2 digits)
        checkoutPageInvalidSingularInput.invalidCheckoutDeliveryTooShortPhoneDataGetter();
        //input valid full name into full name input field
        checkoutPageInvalidSingularInput.inputFullNameIntoFullNameInputField();
        //input too short phone into phone input field (2 digits)
        checkoutPageInvalidSingularInput.inputTooShortPhoneIntoPhoneInputField();
        //input valid address into address input field
        checkoutPageInvalidSingularInput.inputAddressIntoAddressTextarea();
        //input valid city into city input field
        checkoutPageInvalidSingularInput.inputCityIntoCityInputField();
        //capture screenshot of the invalid delivery details input display - too short phone
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("src/test/screenshots/Invalid Checkout Page Tests/Invalid Checkout Delivery Details Input Display - Too Short Delivery Phone.png")).setFullPage(true));

        //click "Place order" button
        checkoutPage.clickPlaceOrderBtn();
        page.waitForTimeout(3000);
        //capture screenshot of the test result
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("src/test/screenshots/Invalid Checkout Page Test Results/Invalid Checkout Test Result - Too Short Delivery Phone Input.png")).setFullPage(true));
        //assert the user stays on the checkout page - throw an error otherwise
        boolean orderSuccessMsgTitleElem = checkoutPage.isCheckoutPageOrderSuccessMsgTitleVisible();
        if(orderSuccessMsgTitleElem){throw new Error("The checkout was successful with too short phone input, test has failed");}
    }

    //invalid product checkout test method - too short delivery address (3 chars)
    protected void invalidProductCheckoutTooShortAddressTest(String productName, String anotherProductName, String payMethod, String firstProductUnitPrice, String secondProductUnitPrice, String subTotalPrice, String deliveryPrice, String totalPrice){
        CheckoutPage checkoutPage = new CheckoutPage(page);
        CheckoutPageInvalidSingularInput checkoutPageInvalidSingularInput = new CheckoutPageInvalidSingularInput(page);
        //general page web element assert
        isGeneralPageWebElementVisible(page);
        //general page text element assert
        isGeneralPageTextElementAsExpected(page);
        //checkout page web element assert
        isCheckoutPageWebElementVisible(page);
        //checkout page text element assert
        isCheckoutPageTextElementAsExpected(page);
        //log checkout page product data
        logCheckoutPageProductData(page);
        //assert the shopping cart table contains the expected product
        List<String> checkoutPageProductTitleList = checkoutPage.getCheckoutPageOrderSummaryProductName();
        assertEquals(productName, checkoutPageProductTitleList.getFirst(), "The product name doesn't match expectations");
        //assert the shopping cart table contains the expected product
        List<String> checkoutPageProductUnitPriceList = checkoutPage.getCheckoutPageOrderSummaryProductPrice();
        assertEquals(firstProductUnitPrice, checkoutPageProductUnitPriceList.getFirst(), "The product unit price doesn't match expectations");
        if(!anotherProductName.isEmpty()){
            //assert the shopping cart table contains the other expected product
            List<String> checkoutPageProductTitles = checkoutPage.getCheckoutPageOrderSummaryProductName();
            assertTrue(checkoutPageProductTitles.contains(anotherProductName), "The other expected product isn't present in the list");
            //assert the shopping cart table contains the other expected product
            List<String> checkoutPageProductUnitPrices = checkoutPage.getCheckoutPageOrderSummaryProductPrice();
            assertTrue(checkoutPageProductUnitPrices.contains(secondProductUnitPrice), "The other expected product unit price isn't present in the list");
        }
        //assert the shopping cart table contains the expected order subtotal price
        String checkoutPageOrderSubtotalPrice = checkoutPage.getCheckoutPageOrderSummarySubtotalPrice();
        assertEquals(subTotalPrice, checkoutPageOrderSubtotalPrice, "The order subtotal price in checkout page doesn't match expectations. Expected: " + checkoutPageOrderSubtotalPrice );
        //assert the shopping cart table contains the expected order total price
        String checkoutPageOrderDeliveryPrice = checkoutPage.getCheckoutPageOrderSummaryDeliveryPrice();
        assertEquals(deliveryPrice, checkoutPageOrderDeliveryPrice, "The order delivery price in checkout page doesn't match expectations. Expected: " + checkoutPageOrderSubtotalPrice );
        //assert the shopping cart table contains the expected order total price
        String checkoutPageOrderTotalPrice = checkoutPage.getCheckoutPageOrderSummaryTotalPrice();
        assertEquals(totalPrice, checkoutPageOrderTotalPrice, "The order total price in checkout page doesn't match expectations. Expected: " + checkoutPageOrderSubtotalPrice );

        //select set payment method
        switch(payMethod){

            case "Cash":
                //click "Cash on delivery" radio button
                checkoutPage.clickSetPayMethodRadioButton(0);
                break;

            case "bKash":
                //click "bKash" radio button
                checkoutPage.clickSetPayMethodRadioButton(1);
                break;

            case "Nagad":
                //click "Nagad" radio button
                checkoutPage.clickSetPayMethodRadioButton(2);
                break;

            default:
                throw new Error("Please input either 'Cash', 'bKash' or 'Nagad'.");
        }

        //capture screenshot of the checkout page display
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("src/test/screenshots/Checkout Page/Checkout Page Display.png")).setFullPage(true));
        //invalid delivery details input data getter - too short address (3 chars)
        checkoutPageInvalidSingularInput.invalidCheckoutDeliveryTooShortAddressDataGetter();
        //input valid full name into full name input field
        checkoutPageInvalidSingularInput.inputFullNameIntoFullNameInputField();
        //input valid phone into phone input field
        checkoutPageInvalidSingularInput.inputPhoneIntoPhoneInputField();
        //input too short address into address input field (3 chars)
        checkoutPageInvalidSingularInput.inputTooShortAddressIntoAddressTextarea();
        //input valid city into city input field
        checkoutPageInvalidSingularInput.inputCityIntoCityInputField();
        //capture screenshot of the invalid delivery details input display - too short address
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("src/test/screenshots/Invalid Checkout Page Tests/Invalid Checkout Delivery Details Input Display - Too Short Delivery Address.png")).setFullPage(true));

        //click "Place order" button
        checkoutPage.clickPlaceOrderBtn();
        page.waitForTimeout(3000);
        //capture screenshot of the test result
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("src/test/screenshots/Invalid Checkout Page Test Results/Invalid Checkout Test Result - Too Short Delivery Address Input.png")).setFullPage(true));
        //assert the user stays on the checkout page (since there's only React error displayed)
        boolean orderSuccessMsgTitleElem = checkoutPage.isCheckoutPageOrderSuccessMsgTitleVisible();
        if(orderSuccessMsgTitleElem){throw new Error("The checkout was successful with too short address input, test has failed");}
    }

    //invalid product checkout test method - too short delivery city (2 chars)
    protected void invalidProductCheckoutTooShortCityTest(String productName, String anotherProductName, String payMethod, String firstProductUnitPrice, String secondProductUnitPrice, String subTotalPrice, String deliveryPrice, String totalPrice){
        CheckoutPage checkoutPage = new CheckoutPage(page);
        CheckoutPageInvalidSingularInput checkoutPageInvalidSingularInput = new CheckoutPageInvalidSingularInput(page);
        //general page web element assert
        isGeneralPageWebElementVisible(page);
        //general page text element assert
        isGeneralPageTextElementAsExpected(page);
        //checkout page web element assert
        isCheckoutPageWebElementVisible(page);
        //checkout page text element assert
        isCheckoutPageTextElementAsExpected(page);
        //log checkout page product data
        logCheckoutPageProductData(page);
        //assert the shopping cart table contains the expected product
        List<String> checkoutPageProductTitleList = checkoutPage.getCheckoutPageOrderSummaryProductName();
        assertEquals(productName, checkoutPageProductTitleList.getFirst(), "The product name doesn't match expectations");
        //assert the shopping cart table contains the expected product
        List<String> checkoutPageProductUnitPriceList = checkoutPage.getCheckoutPageOrderSummaryProductPrice();
        assertEquals(firstProductUnitPrice, checkoutPageProductUnitPriceList.getFirst(), "The product unit price doesn't match expectations");
        if(!anotherProductName.isEmpty()){
            //assert the shopping cart table contains the other expected product
            List<String> checkoutPageProductTitles = checkoutPage.getCheckoutPageOrderSummaryProductName();
            assertTrue(checkoutPageProductTitles.contains(anotherProductName), "The other expected product isn't present in the list");
            //assert the shopping cart table contains the other expected product
            List<String> checkoutPageProductUnitPrices = checkoutPage.getCheckoutPageOrderSummaryProductPrice();
            assertTrue(checkoutPageProductUnitPrices.contains(secondProductUnitPrice), "The other expected product unit price isn't present in the list");
        }
        //assert the shopping cart table contains the expected order subtotal price
        String checkoutPageOrderSubtotalPrice = checkoutPage.getCheckoutPageOrderSummarySubtotalPrice();
        assertEquals(subTotalPrice, checkoutPageOrderSubtotalPrice, "The order subtotal price in checkout page doesn't match expectations. Expected: " + checkoutPageOrderSubtotalPrice );
        //assert the shopping cart table contains the expected order total price
        String checkoutPageOrderDeliveryPrice = checkoutPage.getCheckoutPageOrderSummaryDeliveryPrice();
        assertEquals(deliveryPrice, checkoutPageOrderDeliveryPrice, "The order delivery price in checkout page doesn't match expectations. Expected: " + checkoutPageOrderSubtotalPrice );
        //assert the shopping cart table contains the expected order total price
        String checkoutPageOrderTotalPrice = checkoutPage.getCheckoutPageOrderSummaryTotalPrice();
        assertEquals(totalPrice, checkoutPageOrderTotalPrice, "The order total price in checkout page doesn't match expectations. Expected: " + checkoutPageOrderSubtotalPrice );

        //select set payment method
        switch(payMethod){

            case "Cash":
                //click "Cash on delivery" radio button
                checkoutPage.clickSetPayMethodRadioButton(0);
                break;

            case "bKash":
                //click "bKash" radio button
                checkoutPage.clickSetPayMethodRadioButton(1);
                break;

            case "Nagad":
                //click "Nagad" radio button
                checkoutPage.clickSetPayMethodRadioButton(2);
                break;

            default:
                throw new Error("Please input either 'Cash', 'bKash' or 'Nagad'.");
        }

        //capture screenshot of the checkout page display
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("src/test/screenshots/Checkout Page/Checkout Page Display.png")).setFullPage(true));
        //invalid delivery details input data getter - too short city (2 chars)
        checkoutPageInvalidSingularInput.invalidCheckoutDeliveryTooShortCityDataGetter();
        //input valid full name into full name input field
        checkoutPageInvalidSingularInput.inputFullNameIntoFullNameInputField();
        //input valid phone into phone input field
        checkoutPageInvalidSingularInput.inputPhoneIntoPhoneInputField();
        //input valid address into address input field
        checkoutPageInvalidSingularInput.inputAddressIntoAddressTextarea();
        //input too short city into city input field (2 chars)
        checkoutPageInvalidSingularInput.inputTooShortCityIntoCityInputField();
        //capture screenshot of the invalid delivery details input display - too short city
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("src/test/screenshots/Invalid Checkout Page Tests/Invalid Checkout Delivery Details Input Display - Too Short Delivery City.png")).setFullPage(true));

        //click "Place order" button
        checkoutPage.clickPlaceOrderBtn();
        page.waitForTimeout(3000);
        //capture screenshot of the test result
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("src/test/screenshots/Invalid Checkout Page Test Results/Invalid Checkout Test Result - Too Short Delivery City Input.png")).setFullPage(true));
        //assert the user stays on the checkout page (since there's only React error displayed)
        boolean orderSuccessMsgTitleElem = checkoutPage.isCheckoutPageOrderSuccessMsgTitleVisible();
        if(orderSuccessMsgTitleElem){throw new Error("The checkout was successful with too short city input, test has failed");}
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //invalid product checkout test method - too long delivery full name (200 chars)
    protected void invalidProductCheckoutTooLongFullNameTest(String productName, String anotherProductName, String payMethod, String firstProductUnitPrice, String secondProductUnitPrice, String subTotalPrice, String deliveryPrice, String totalPrice){
        CheckoutPage checkoutPage = new CheckoutPage(page);
        CheckoutPageInvalidSingularInput checkoutPageInvalidSingularInput = new CheckoutPageInvalidSingularInput(page);
        //general page web element assert
        isGeneralPageWebElementVisible(page);
        //general page text element assert
        isGeneralPageTextElementAsExpected(page);
        //checkout page web element assert
        isCheckoutPageWebElementVisible(page);
        //checkout page text element assert
        isCheckoutPageTextElementAsExpected(page);
        //log checkout page product data
        logCheckoutPageProductData(page);
        //assert the shopping cart table contains the expected product
        List<String> checkoutPageProductTitleList = checkoutPage.getCheckoutPageOrderSummaryProductName();
        assertEquals(productName, checkoutPageProductTitleList.getFirst(), "The product name doesn't match expectations");
        //assert the shopping cart table contains the expected product
        List<String> checkoutPageProductUnitPriceList = checkoutPage.getCheckoutPageOrderSummaryProductPrice();
        assertEquals(firstProductUnitPrice, checkoutPageProductUnitPriceList.getFirst(), "The product unit price doesn't match expectations");
        if(!anotherProductName.isEmpty()){
            //assert the shopping cart table contains the other expected product
            List<String> checkoutPageProductTitles = checkoutPage.getCheckoutPageOrderSummaryProductName();
            assertTrue(checkoutPageProductTitles.contains(anotherProductName), "The other expected product isn't present in the list");
            //assert the shopping cart table contains the other expected product
            List<String> checkoutPageProductUnitPrices = checkoutPage.getCheckoutPageOrderSummaryProductPrice();
            assertTrue(checkoutPageProductUnitPrices.contains(secondProductUnitPrice), "The other expected product unit price isn't present in the list");
        }
        //assert the shopping cart table contains the expected order subtotal price
        String checkoutPageOrderSubtotalPrice = checkoutPage.getCheckoutPageOrderSummarySubtotalPrice();
        assertEquals(subTotalPrice, checkoutPageOrderSubtotalPrice, "The order subtotal price in checkout page doesn't match expectations. Expected: " + checkoutPageOrderSubtotalPrice );
        //assert the shopping cart table contains the expected order total price
        String checkoutPageOrderDeliveryPrice = checkoutPage.getCheckoutPageOrderSummaryDeliveryPrice();
        assertEquals(deliveryPrice, checkoutPageOrderDeliveryPrice, "The order delivery price in checkout page doesn't match expectations. Expected: " + checkoutPageOrderSubtotalPrice );
        //assert the shopping cart table contains the expected order total price
        String checkoutPageOrderTotalPrice = checkoutPage.getCheckoutPageOrderSummaryTotalPrice();
        assertEquals(totalPrice, checkoutPageOrderTotalPrice, "The order total price in checkout page doesn't match expectations. Expected: " + checkoutPageOrderSubtotalPrice );

        //select set payment method
        switch(payMethod){

            case "Cash":
                //click "Cash on delivery" radio button
                checkoutPage.clickSetPayMethodRadioButton(0);
                break;

            case "bKash":
                //click "bKash" radio button
                checkoutPage.clickSetPayMethodRadioButton(1);
                break;

            case "Nagad":
                //click "Nagad" radio button
                checkoutPage.clickSetPayMethodRadioButton(2);
                break;

            default:
                throw new Error("Please input either 'Cash', 'bKash' or 'Nagad'.");
        }

        //capture screenshot of the checkout page display
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("src/test/screenshots/Checkout Page/Checkout Page Display.png")).setFullPage(true));
        //invalid delivery details input data getter - too long delivery full name (200 chars)
        checkoutPageInvalidSingularInput.invalidCheckoutDeliveryTooLongFullNameDataGetter();
        //input too long full name into full name input field (200 chars)
        checkoutPageInvalidSingularInput.inputTooLongFullNameIntoFullNameInputField();
        //input valid phone into phone input field
        checkoutPageInvalidSingularInput.inputPhoneIntoPhoneInputField();
        //input valid address into address input field
        checkoutPageInvalidSingularInput.inputAddressIntoAddressTextarea();
        //input valid city into city input field
        checkoutPageInvalidSingularInput.inputCityIntoCityInputField();
        //capture screenshot of the invalid delivery details input display - too long full name
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("src/test/screenshots/Invalid Checkout Page Tests/Invalid Checkout Delivery Details Input Display - Too Long Delivery Full Name.png")).setFullPage(true));

        //click "Place order" button
        checkoutPage.clickPlaceOrderBtn();
        page.waitForTimeout(3000);
        //capture screenshot of the test result
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("src/test/screenshots/Invalid Checkout Page Test Results/Invalid Checkout Test Result - Too Long Delivery Full Name Input.png")).setFullPage(true));
        //assert the user stays on the checkout page, throw an error otherwise
        boolean orderSuccessMsgTitleElem = checkoutPage.isCheckoutPageOrderSuccessMsgTitleVisible();
        if(orderSuccessMsgTitleElem){throw new Error("The checkout was successful with too long full name input, test has failed");}
    }

    //invalid product checkout test method - too long delivery phone (25 digits)
    protected void invalidProductCheckoutTooLongPhoneTest(String productName, String anotherProductName, String payMethod, String firstProductUnitPrice, String secondProductUnitPrice, String subTotalPrice, String deliveryPrice, String totalPrice){
        CheckoutPage checkoutPage = new CheckoutPage(page);
        CheckoutPageInvalidSingularInput checkoutPageInvalidSingularInput = new CheckoutPageInvalidSingularInput(page);
        //general page web element assert
        isGeneralPageWebElementVisible(page);
        //general page text element assert
        isGeneralPageTextElementAsExpected(page);
        //checkout page web element assert
        isCheckoutPageWebElementVisible(page);
        //checkout page text element assert
        isCheckoutPageTextElementAsExpected(page);
        //log checkout page product data
        logCheckoutPageProductData(page);
        //assert the shopping cart table contains the expected product
        List<String> checkoutPageProductTitleList = checkoutPage.getCheckoutPageOrderSummaryProductName();
        assertEquals(productName, checkoutPageProductTitleList.getFirst(), "The product name doesn't match expectations");
        //assert the shopping cart table contains the expected product
        List<String> checkoutPageProductUnitPriceList = checkoutPage.getCheckoutPageOrderSummaryProductPrice();
        assertEquals(firstProductUnitPrice, checkoutPageProductUnitPriceList.getFirst(), "The product unit price doesn't match expectations");
        if(!anotherProductName.isEmpty()){
            //assert the shopping cart table contains the other expected product
            List<String> checkoutPageProductTitles = checkoutPage.getCheckoutPageOrderSummaryProductName();
            assertTrue(checkoutPageProductTitles.contains(anotherProductName), "The other expected product isn't present in the list");
            //assert the shopping cart table contains the other expected product
            List<String> checkoutPageProductUnitPrices = checkoutPage.getCheckoutPageOrderSummaryProductPrice();
            assertTrue(checkoutPageProductUnitPrices.contains(secondProductUnitPrice), "The other expected product unit price isn't present in the list");
        }
        //assert the shopping cart table contains the expected order subtotal price
        String checkoutPageOrderSubtotalPrice = checkoutPage.getCheckoutPageOrderSummarySubtotalPrice();
        assertEquals(subTotalPrice, checkoutPageOrderSubtotalPrice, "The order subtotal price in checkout page doesn't match expectations. Expected: " + checkoutPageOrderSubtotalPrice );
        //assert the shopping cart table contains the expected order total price
        String checkoutPageOrderDeliveryPrice = checkoutPage.getCheckoutPageOrderSummaryDeliveryPrice();
        assertEquals(deliveryPrice, checkoutPageOrderDeliveryPrice, "The order delivery price in checkout page doesn't match expectations. Expected: " + checkoutPageOrderSubtotalPrice );
        //assert the shopping cart table contains the expected order total price
        String checkoutPageOrderTotalPrice = checkoutPage.getCheckoutPageOrderSummaryTotalPrice();
        assertEquals(totalPrice, checkoutPageOrderTotalPrice, "The order total price in checkout page doesn't match expectations. Expected: " + checkoutPageOrderSubtotalPrice );

        //select set payment method
        switch(payMethod){

            case "Cash":
                //click "Cash on delivery" radio button
                checkoutPage.clickSetPayMethodRadioButton(0);
                break;

            case "bKash":
                //click "bKash" radio button
                checkoutPage.clickSetPayMethodRadioButton(1);
                break;

            case "Nagad":
                //click "Nagad" radio button
                checkoutPage.clickSetPayMethodRadioButton(2);
                break;

            default:
                throw new Error("Please input either 'Cash', 'bKash' or 'Nagad'.");
        }

        //capture screenshot of the checkout page display
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("src/test/screenshots/Checkout Page/Checkout Page Display.png")).setFullPage(true));
        //invalid delivery details input data getter - too long phone (25 digits)
        checkoutPageInvalidSingularInput.invalidCheckoutDeliveryTooLongPhoneDataGetter();
        //input valid full name into full name input field
        checkoutPageInvalidSingularInput.inputFullNameIntoFullNameInputField();
        //input too long phone into phone input field (25 digits)
        checkoutPageInvalidSingularInput.inputTooLongPhoneIntoPhoneInputField();
        //input valid address into address input field
        checkoutPageInvalidSingularInput.inputAddressIntoAddressTextarea();
        //input valid city into city input field
        checkoutPageInvalidSingularInput.inputCityIntoCityInputField();
        //capture screenshot of the invalid delivery details input display - too long phone
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("src/test/screenshots/Invalid Checkout Page Tests/Invalid Checkout Delivery Details Input Display - Too Long Delivery Phone.png")).setFullPage(true));

        //click "Place order" button
        checkoutPage.clickPlaceOrderBtn();
        page.waitForTimeout(3000);
        //capture screenshot of the test result
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("src/test/screenshots/Invalid Checkout Page Test Results/Invalid Checkout Test Result - Too Long Delivery Phone Input.png")).setFullPage(true));
        //assert the user stays on the checkout page - throw an error otherwise
        boolean orderSuccessMsgTitleElem = checkoutPage.isCheckoutPageOrderSuccessMsgTitleVisible();
        if(orderSuccessMsgTitleElem){throw new Error("The checkout was successful with too long phone input, test has failed");}
    }

    //invalid product checkout test method - too long delivery address (100 chars)
    protected void invalidProductCheckoutTooLongAddressTest(String productName, String anotherProductName, String payMethod, String firstProductUnitPrice, String secondProductUnitPrice, String subTotalPrice, String deliveryPrice, String totalPrice){
        CheckoutPage checkoutPage = new CheckoutPage(page);
        CheckoutPageInvalidSingularInput checkoutPageInvalidSingularInput = new CheckoutPageInvalidSingularInput(page);
        //general page web element assert
        isGeneralPageWebElementVisible(page);
        //general page text element assert
        isGeneralPageTextElementAsExpected(page);
        //checkout page web element assert
        isCheckoutPageWebElementVisible(page);
        //checkout page text element assert
        isCheckoutPageTextElementAsExpected(page);
        //log checkout page product data
        logCheckoutPageProductData(page);
        //assert the shopping cart table contains the expected product
        List<String> checkoutPageProductTitleList = checkoutPage.getCheckoutPageOrderSummaryProductName();
        assertEquals(productName, checkoutPageProductTitleList.getFirst(), "The product name doesn't match expectations");
        //assert the shopping cart table contains the expected product
        List<String> checkoutPageProductUnitPriceList = checkoutPage.getCheckoutPageOrderSummaryProductPrice();
        assertEquals(firstProductUnitPrice, checkoutPageProductUnitPriceList.getFirst(), "The product unit price doesn't match expectations");
        if(!anotherProductName.isEmpty()){
            //assert the shopping cart table contains the other expected product
            List<String> checkoutPageProductTitles = checkoutPage.getCheckoutPageOrderSummaryProductName();
            assertTrue(checkoutPageProductTitles.contains(anotherProductName), "The other expected product isn't present in the list");
            //assert the shopping cart table contains the other expected product
            List<String> checkoutPageProductUnitPrices = checkoutPage.getCheckoutPageOrderSummaryProductPrice();
            assertTrue(checkoutPageProductUnitPrices.contains(secondProductUnitPrice), "The other expected product unit price isn't present in the list");
        }
        //assert the shopping cart table contains the expected order subtotal price
        String checkoutPageOrderSubtotalPrice = checkoutPage.getCheckoutPageOrderSummarySubtotalPrice();
        assertEquals(subTotalPrice, checkoutPageOrderSubtotalPrice, "The order subtotal price in checkout page doesn't match expectations. Expected: " + checkoutPageOrderSubtotalPrice );
        //assert the shopping cart table contains the expected order total price
        String checkoutPageOrderDeliveryPrice = checkoutPage.getCheckoutPageOrderSummaryDeliveryPrice();
        assertEquals(deliveryPrice, checkoutPageOrderDeliveryPrice, "The order delivery price in checkout page doesn't match expectations. Expected: " + checkoutPageOrderSubtotalPrice );
        //assert the shopping cart table contains the expected order total price
        String checkoutPageOrderTotalPrice = checkoutPage.getCheckoutPageOrderSummaryTotalPrice();
        assertEquals(totalPrice, checkoutPageOrderTotalPrice, "The order total price in checkout page doesn't match expectations. Expected: " + checkoutPageOrderSubtotalPrice );

        //select set payment method
        switch(payMethod){

            case "Cash":
                //click "Cash on delivery" radio button
                checkoutPage.clickSetPayMethodRadioButton(0);
                break;

            case "bKash":
                //click "bKash" radio button
                checkoutPage.clickSetPayMethodRadioButton(1);
                break;

            case "Nagad":
                //click "Nagad" radio button
                checkoutPage.clickSetPayMethodRadioButton(2);
                break;

            default:
                throw new Error("Please input either 'Cash', 'bKash' or 'Nagad'.");
        }

        //capture screenshot of the checkout page display
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("src/test/screenshots/Checkout Page/Checkout Page Display.png")).setFullPage(true));
        //invalid delivery details input data getter - too long address (100 chars)
        checkoutPageInvalidSingularInput.invalidCheckoutDeliveryTooLongAddressDataGetter();
        //input valid full name into full name input field
        checkoutPageInvalidSingularInput.inputFullNameIntoFullNameInputField();
        //input valid phone into phone input field
        checkoutPageInvalidSingularInput.inputPhoneIntoPhoneInputField();
        //input too long address into address input field (100 chars)
        checkoutPageInvalidSingularInput.inputTooLongAddressIntoAddressTextarea();
        //input valid city into city input field
        checkoutPageInvalidSingularInput.inputCityIntoCityInputField();
        //capture screenshot of the invalid delivery details input display - too long address
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("src/test/screenshots/Invalid Checkout Page Tests/Invalid Checkout Delivery Details Input Display - Too Long Delivery Address.png")).setFullPage(true));

        //click "Place order" button
        checkoutPage.clickPlaceOrderBtn();
        page.waitForTimeout(3000);
        //capture screenshot of the test result
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("src/test/screenshots/Invalid Checkout Page Test Results/Invalid Checkout Test Result - Too Long Delivery Address Input.png")).setFullPage(true));
        //assert the user stays on the checkout page (since there's only React error displayed)
        boolean orderSuccessMsgTitleElem = checkoutPage.isCheckoutPageOrderSuccessMsgTitleVisible();
        if(orderSuccessMsgTitleElem){throw new Error("The checkout was successful with too long address input, test has failed");}
    }

    //invalid product checkout test method - too long delivery city (100 chars)
    protected void invalidProductCheckoutTooLongCityTest(String productName, String anotherProductName, String payMethod, String firstProductUnitPrice, String secondProductUnitPrice, String subTotalPrice, String deliveryPrice, String totalPrice){
        CheckoutPage checkoutPage = new CheckoutPage(page);
        CheckoutPageInvalidSingularInput checkoutPageInvalidSingularInput = new CheckoutPageInvalidSingularInput(page);
        //general page web element assert
        isGeneralPageWebElementVisible(page);
        //general page text element assert
        isGeneralPageTextElementAsExpected(page);
        //checkout page web element assert
        isCheckoutPageWebElementVisible(page);
        //checkout page text element assert
        isCheckoutPageTextElementAsExpected(page);
        //log checkout page product data
        logCheckoutPageProductData(page);
        //assert the shopping cart table contains the expected product
        List<String> checkoutPageProductTitleList = checkoutPage.getCheckoutPageOrderSummaryProductName();
        assertEquals(productName, checkoutPageProductTitleList.getFirst(), "The product name doesn't match expectations");
        //assert the shopping cart table contains the expected product
        List<String> checkoutPageProductUnitPriceList = checkoutPage.getCheckoutPageOrderSummaryProductPrice();
        assertEquals(firstProductUnitPrice, checkoutPageProductUnitPriceList.getFirst(), "The product unit price doesn't match expectations");
        if(!anotherProductName.isEmpty()){
            //assert the shopping cart table contains the other expected product
            List<String> checkoutPageProductTitles = checkoutPage.getCheckoutPageOrderSummaryProductName();
            assertTrue(checkoutPageProductTitles.contains(anotherProductName), "The other expected product isn't present in the list");
            //assert the shopping cart table contains the other expected product
            List<String> checkoutPageProductUnitPrices = checkoutPage.getCheckoutPageOrderSummaryProductPrice();
            assertTrue(checkoutPageProductUnitPrices.contains(secondProductUnitPrice), "The other expected product unit price isn't present in the list");
        }
        //assert the shopping cart table contains the expected order subtotal price
        String checkoutPageOrderSubtotalPrice = checkoutPage.getCheckoutPageOrderSummarySubtotalPrice();
        assertEquals(subTotalPrice, checkoutPageOrderSubtotalPrice, "The order subtotal price in checkout page doesn't match expectations. Expected: " + checkoutPageOrderSubtotalPrice );
        //assert the shopping cart table contains the expected order total price
        String checkoutPageOrderDeliveryPrice = checkoutPage.getCheckoutPageOrderSummaryDeliveryPrice();
        assertEquals(deliveryPrice, checkoutPageOrderDeliveryPrice, "The order delivery price in checkout page doesn't match expectations. Expected: " + checkoutPageOrderSubtotalPrice );
        //assert the shopping cart table contains the expected order total price
        String checkoutPageOrderTotalPrice = checkoutPage.getCheckoutPageOrderSummaryTotalPrice();
        assertEquals(totalPrice, checkoutPageOrderTotalPrice, "The order total price in checkout page doesn't match expectations. Expected: " + checkoutPageOrderSubtotalPrice );

        //select set payment method
        switch(payMethod){

            case "Cash":
                //click "Cash on delivery" radio button
                checkoutPage.clickSetPayMethodRadioButton(0);
                break;

            case "bKash":
                //click "bKash" radio button
                checkoutPage.clickSetPayMethodRadioButton(1);
                break;

            case "Nagad":
                //click "Nagad" radio button
                checkoutPage.clickSetPayMethodRadioButton(2);
                break;

            default:
                throw new Error("Please input either 'Cash', 'bKash' or 'Nagad'.");
        }

        //capture screenshot of the checkout page display
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("src/test/screenshots/Checkout Page/Checkout Page Display.png")).setFullPage(true));
        //invalid delivery details input data getter - too long city (100 chars)
        checkoutPageInvalidSingularInput.invalidCheckoutDeliveryTooLongCityDataGetter();
        //input valid full name into full name input field
        checkoutPageInvalidSingularInput.inputFullNameIntoFullNameInputField();
        //input valid phone into phone input field
        checkoutPageInvalidSingularInput.inputPhoneIntoPhoneInputField();
        //input valid address into address input field
        checkoutPageInvalidSingularInput.inputAddressIntoAddressTextarea();
        //input too long city into city input field (100 chars)
        checkoutPageInvalidSingularInput.inputTooLongCityIntoCityInputField();
        //capture screenshot of the invalid delivery details input display - too long city
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("src/test/screenshots/Invalid Checkout Page Tests/Invalid Checkout Delivery Details Input Display - Too Long Delivery City.png")).setFullPage(true));

        //click "Place order" button
        checkoutPage.clickPlaceOrderBtn();
        page.waitForTimeout(3000);
        //capture screenshot of the test result
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("src/test/screenshots/Invalid Checkout Page Test Results/Invalid Checkout Test Result - Too Long Delivery City Input.png")).setFullPage(true));
        //assert the user stays on the checkout page (since there's only React error displayed)
        boolean orderSuccessMsgTitleElem = checkoutPage.isCheckoutPageOrderSuccessMsgTitleVisible();
        if(orderSuccessMsgTitleElem){throw new Error("The checkout was successful with too long city input, test has failed");}
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//invalid product checkout test method - invalid delivery full name format (special symbols only)
protected void invalidProductCheckoutInvalidFullNameFormatTest(String productName, String anotherProductName, String payMethod, String firstProductUnitPrice, String secondProductUnitPrice, String subTotalPrice, String deliveryPrice, String totalPrice){
    CheckoutPage checkoutPage = new CheckoutPage(page);
    CheckoutPageInvalidSingularInput checkoutPageInvalidSingularInput = new CheckoutPageInvalidSingularInput(page);
    //general page web element assert
    isGeneralPageWebElementVisible(page);
    //general page text element assert
    isGeneralPageTextElementAsExpected(page);
    //checkout page web element assert
    isCheckoutPageWebElementVisible(page);
    //checkout page text element assert
    isCheckoutPageTextElementAsExpected(page);
    //log checkout page product data
    logCheckoutPageProductData(page);
    //assert the shopping cart table contains the expected product
    List<String> checkoutPageProductTitleList = checkoutPage.getCheckoutPageOrderSummaryProductName();
    assertEquals(productName, checkoutPageProductTitleList.getFirst(), "The product name doesn't match expectations");
    //assert the shopping cart table contains the expected product
    List<String> checkoutPageProductUnitPriceList = checkoutPage.getCheckoutPageOrderSummaryProductPrice();
    assertEquals(firstProductUnitPrice, checkoutPageProductUnitPriceList.getFirst(), "The product unit price doesn't match expectations");
    if(!anotherProductName.isEmpty()){
        //assert the shopping cart table contains the other expected product
        List<String> checkoutPageProductTitles = checkoutPage.getCheckoutPageOrderSummaryProductName();
        assertTrue(checkoutPageProductTitles.contains(anotherProductName), "The other expected product isn't present in the list");
        //assert the shopping cart table contains the other expected product
        List<String> checkoutPageProductUnitPrices = checkoutPage.getCheckoutPageOrderSummaryProductPrice();
        assertTrue(checkoutPageProductUnitPrices.contains(secondProductUnitPrice), "The other expected product unit price isn't present in the list");
    }
    //assert the shopping cart table contains the expected order subtotal price
    String checkoutPageOrderSubtotalPrice = checkoutPage.getCheckoutPageOrderSummarySubtotalPrice();
    assertEquals(subTotalPrice, checkoutPageOrderSubtotalPrice, "The order subtotal price in checkout page doesn't match expectations. Expected: " + checkoutPageOrderSubtotalPrice );
    //assert the shopping cart table contains the expected order total price
    String checkoutPageOrderDeliveryPrice = checkoutPage.getCheckoutPageOrderSummaryDeliveryPrice();
    assertEquals(deliveryPrice, checkoutPageOrderDeliveryPrice, "The order delivery price in checkout page doesn't match expectations. Expected: " + checkoutPageOrderSubtotalPrice );
    //assert the shopping cart table contains the expected order total price
    String checkoutPageOrderTotalPrice = checkoutPage.getCheckoutPageOrderSummaryTotalPrice();
    assertEquals(totalPrice, checkoutPageOrderTotalPrice, "The order total price in checkout page doesn't match expectations. Expected: " + checkoutPageOrderSubtotalPrice );

    //select set payment method
    switch(payMethod){

        case "Cash":
            //click "Cash on delivery" radio button
            checkoutPage.clickSetPayMethodRadioButton(0);
            break;

        case "bKash":
            //click "bKash" radio button
            checkoutPage.clickSetPayMethodRadioButton(1);
            break;

        case "Nagad":
            //click "Nagad" radio button
            checkoutPage.clickSetPayMethodRadioButton(2);
            break;

        default:
            throw new Error("Please input either 'Cash', 'bKash' or 'Nagad'.");
    }

    //capture screenshot of the checkout page display
    page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("src/test/screenshots/Checkout Page/Checkout Page Display.png")).setFullPage(true));
    //invalid delivery details input data getter - invalid delivery full name format (special symbols only)
    checkoutPageInvalidSingularInput.invalidCheckoutDeliveryInvalidFullNameFormatDataGetter();
    //input invalid full name format into full name input field (special symbols only)
    checkoutPageInvalidSingularInput.inputInvalidFullNameFormatIntoFullNameInputField();
    //input valid phone into phone input field
    checkoutPageInvalidSingularInput.inputPhoneIntoPhoneInputField();
    //input valid address into address input field
    checkoutPageInvalidSingularInput.inputAddressIntoAddressTextarea();
    //input valid city into city input field
    checkoutPageInvalidSingularInput.inputCityIntoCityInputField();
    //capture screenshot of the invalid delivery details input display - invalid full name format
    page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("src/test/screenshots/Invalid Checkout Page Tests/Invalid Checkout Delivery Details Input Display - Invalid Delivery Full Name Format.png")).setFullPage(true));

    //click "Place order" button
    checkoutPage.clickPlaceOrderBtn();
    page.waitForTimeout(3000);
    //capture screenshot of the test result
    page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("src/test/screenshots/Invalid Checkout Page Test Results/Invalid Checkout Test Result - Invalid Delivery Full Name Format Input.png")).setFullPage(true));
    //assert the user stays on the checkout page, throw an error otherwise
    boolean orderSuccessMsgTitleElem = checkoutPage.isCheckoutPageOrderSuccessMsgTitleVisible();
    if(orderSuccessMsgTitleElem){throw new Error("The checkout was successful with invalid full name format input (special symbols only), test has failed");}
}

    //invalid product checkout test method - invalid delivery phone format (special symbols only)
    protected void invalidProductCheckoutInvalidPhoneFormatTest(String productName, String anotherProductName, String payMethod, String firstProductUnitPrice, String secondProductUnitPrice, String subTotalPrice, String deliveryPrice, String totalPrice){
        CheckoutPage checkoutPage = new CheckoutPage(page);
        CheckoutPageInvalidSingularInput checkoutPageInvalidSingularInput = new CheckoutPageInvalidSingularInput(page);
        //general page web element assert
        isGeneralPageWebElementVisible(page);
        //general page text element assert
        isGeneralPageTextElementAsExpected(page);
        //checkout page web element assert
        isCheckoutPageWebElementVisible(page);
        //checkout page text element assert
        isCheckoutPageTextElementAsExpected(page);
        //log checkout page product data
        logCheckoutPageProductData(page);
        //assert the shopping cart table contains the expected product
        List<String> checkoutPageProductTitleList = checkoutPage.getCheckoutPageOrderSummaryProductName();
        assertEquals(productName, checkoutPageProductTitleList.getFirst(), "The product name doesn't match expectations");
        //assert the shopping cart table contains the expected product
        List<String> checkoutPageProductUnitPriceList = checkoutPage.getCheckoutPageOrderSummaryProductPrice();
        assertEquals(firstProductUnitPrice, checkoutPageProductUnitPriceList.getFirst(), "The product unit price doesn't match expectations");
        if(!anotherProductName.isEmpty()){
            //assert the shopping cart table contains the other expected product
            List<String> checkoutPageProductTitles = checkoutPage.getCheckoutPageOrderSummaryProductName();
            assertTrue(checkoutPageProductTitles.contains(anotherProductName), "The other expected product isn't present in the list");
            //assert the shopping cart table contains the other expected product
            List<String> checkoutPageProductUnitPrices = checkoutPage.getCheckoutPageOrderSummaryProductPrice();
            assertTrue(checkoutPageProductUnitPrices.contains(secondProductUnitPrice), "The other expected product unit price isn't present in the list");
        }
        //assert the shopping cart table contains the expected order subtotal price
        String checkoutPageOrderSubtotalPrice = checkoutPage.getCheckoutPageOrderSummarySubtotalPrice();
        assertEquals(subTotalPrice, checkoutPageOrderSubtotalPrice, "The order subtotal price in checkout page doesn't match expectations. Expected: " + checkoutPageOrderSubtotalPrice );
        //assert the shopping cart table contains the expected order total price
        String checkoutPageOrderDeliveryPrice = checkoutPage.getCheckoutPageOrderSummaryDeliveryPrice();
        assertEquals(deliveryPrice, checkoutPageOrderDeliveryPrice, "The order delivery price in checkout page doesn't match expectations. Expected: " + checkoutPageOrderSubtotalPrice );
        //assert the shopping cart table contains the expected order total price
        String checkoutPageOrderTotalPrice = checkoutPage.getCheckoutPageOrderSummaryTotalPrice();
        assertEquals(totalPrice, checkoutPageOrderTotalPrice, "The order total price in checkout page doesn't match expectations. Expected: " + checkoutPageOrderSubtotalPrice );

        //select set payment method
        switch(payMethod){

            case "Cash":
                //click "Cash on delivery" radio button
                checkoutPage.clickSetPayMethodRadioButton(0);
                break;

            case "bKash":
                //click "bKash" radio button
                checkoutPage.clickSetPayMethodRadioButton(1);
                break;

            case "Nagad":
                //click "Nagad" radio button
                checkoutPage.clickSetPayMethodRadioButton(2);
                break;

            default:
                throw new Error("Please input either 'Cash', 'bKash' or 'Nagad'.");
        }

        //capture screenshot of the checkout page display
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("src/test/screenshots/Checkout Page/Checkout Page Display.png")).setFullPage(true));
        //invalid delivery details input data getter - invalid phone format (special symbols only)
        checkoutPageInvalidSingularInput.invalidCheckoutDeliveryInvalidPhoneFormatDataGetter();
        //input valid full name into full name input field
        checkoutPageInvalidSingularInput.inputFullNameIntoFullNameInputField();
        //input invalid phone format into phone input field (special symbols only)
        checkoutPageInvalidSingularInput.inputInvalidPhoneFormatIntoPhoneInputField();
        //input valid address into address input field
        checkoutPageInvalidSingularInput.inputAddressIntoAddressTextarea();
        //input valid city into city input field
        checkoutPageInvalidSingularInput.inputCityIntoCityInputField();
        //capture screenshot of the invalid delivery details input display - invalid phone format
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("src/test/screenshots/Invalid Checkout Page Tests/Invalid Checkout Delivery Details Input Display - Invalid Delivery Phone Format.png")).setFullPage(true));

        //click "Place order" button
        checkoutPage.clickPlaceOrderBtn();
        page.waitForTimeout(3000);
        //capture screenshot of the test result
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("src/test/screenshots/Invalid Checkout Page Test Results/Invalid Checkout Test Result - Invalid Delivery Phone Input Format.png")).setFullPage(true));
        //assert the user stays on the checkout page - throw an error otherwise
        boolean orderSuccessMsgTitleElem = checkoutPage.isCheckoutPageOrderSuccessMsgTitleVisible();
        if(orderSuccessMsgTitleElem){throw new Error("The checkout was successful with invalid phone format input (special symbols only), test has failed");}
    }

    //invalid product checkout test method - invalid delivery address format (special symbols only)
    protected void invalidProductCheckoutInvalidAddressFormatTest(String productName, String anotherProductName, String payMethod, String firstProductUnitPrice, String secondProductUnitPrice, String subTotalPrice, String deliveryPrice, String totalPrice){
        CheckoutPage checkoutPage = new CheckoutPage(page);
        CheckoutPageInvalidSingularInput checkoutPageInvalidSingularInput = new CheckoutPageInvalidSingularInput(page);
        //general page web element assert
        isGeneralPageWebElementVisible(page);
        //general page text element assert
        isGeneralPageTextElementAsExpected(page);
        //checkout page web element assert
        isCheckoutPageWebElementVisible(page);
        //checkout page text element assert
        isCheckoutPageTextElementAsExpected(page);
        //log checkout page product data
        logCheckoutPageProductData(page);
        //assert the shopping cart table contains the expected product
        List<String> checkoutPageProductTitleList = checkoutPage.getCheckoutPageOrderSummaryProductName();
        assertEquals(productName, checkoutPageProductTitleList.getFirst(), "The product name doesn't match expectations");
        //assert the shopping cart table contains the expected product
        List<String> checkoutPageProductUnitPriceList = checkoutPage.getCheckoutPageOrderSummaryProductPrice();
        assertEquals(firstProductUnitPrice, checkoutPageProductUnitPriceList.getFirst(), "The product unit price doesn't match expectations");
        if(!anotherProductName.isEmpty()){
            //assert the shopping cart table contains the other expected product
            List<String> checkoutPageProductTitles = checkoutPage.getCheckoutPageOrderSummaryProductName();
            assertTrue(checkoutPageProductTitles.contains(anotherProductName), "The other expected product isn't present in the list");
            //assert the shopping cart table contains the other expected product
            List<String> checkoutPageProductUnitPrices = checkoutPage.getCheckoutPageOrderSummaryProductPrice();
            assertTrue(checkoutPageProductUnitPrices.contains(secondProductUnitPrice), "The other expected product unit price isn't present in the list");
        }
        //assert the shopping cart table contains the expected order subtotal price
        String checkoutPageOrderSubtotalPrice = checkoutPage.getCheckoutPageOrderSummarySubtotalPrice();
        assertEquals(subTotalPrice, checkoutPageOrderSubtotalPrice, "The order subtotal price in checkout page doesn't match expectations. Expected: " + checkoutPageOrderSubtotalPrice );
        //assert the shopping cart table contains the expected order total price
        String checkoutPageOrderDeliveryPrice = checkoutPage.getCheckoutPageOrderSummaryDeliveryPrice();
        assertEquals(deliveryPrice, checkoutPageOrderDeliveryPrice, "The order delivery price in checkout page doesn't match expectations. Expected: " + checkoutPageOrderSubtotalPrice );
        //assert the shopping cart table contains the expected order total price
        String checkoutPageOrderTotalPrice = checkoutPage.getCheckoutPageOrderSummaryTotalPrice();
        assertEquals(totalPrice, checkoutPageOrderTotalPrice, "The order total price in checkout page doesn't match expectations. Expected: " + checkoutPageOrderSubtotalPrice );

        //select set payment method
        switch(payMethod){

            case "Cash":
                //click "Cash on delivery" radio button
                checkoutPage.clickSetPayMethodRadioButton(0);
                break;

            case "bKash":
                //click "bKash" radio button
                checkoutPage.clickSetPayMethodRadioButton(1);
                break;

            case "Nagad":
                //click "Nagad" radio button
                checkoutPage.clickSetPayMethodRadioButton(2);
                break;

            default:
                throw new Error("Please input either 'Cash', 'bKash' or 'Nagad'.");
        }

        //capture screenshot of the checkout page display
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("src/test/screenshots/Checkout Page/Checkout Page Display.png")).setFullPage(true));
        //invalid delivery details input data getter - invalid address format (special symbols only)
        checkoutPageInvalidSingularInput.invalidCheckoutDeliveryInvalidAddressFormatDataGetter();
        //input valid full name into full name input field
        checkoutPageInvalidSingularInput.inputFullNameIntoFullNameInputField();
        //input valid phone into phone input field
        checkoutPageInvalidSingularInput.inputPhoneIntoPhoneInputField();
        //input invalid address format into address input field (special symbols only)
        checkoutPageInvalidSingularInput.inputInvalidAddressFormatIntoAddressTextarea();
        //input valid city into city input field
        checkoutPageInvalidSingularInput.inputCityIntoCityInputField();
        //capture screenshot of the invalid delivery details input display - invalid address format
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("src/test/screenshots/Invalid Checkout Page Tests/Invalid Checkout Delivery Details Input Display - Invalid Delivery Address Format.png")).setFullPage(true));

        //click "Place order" button
        checkoutPage.clickPlaceOrderBtn();
        page.waitForTimeout(3000);
        //capture screenshot of the test result
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("src/test/screenshots/Invalid Checkout Page Test Results/Invalid Checkout Test Result - Invalid Delivery Address Input Format.png")).setFullPage(true));
        //assert the user stays on the checkout page (since there's only React error displayed)
        boolean orderSuccessMsgTitleElem = checkoutPage.isCheckoutPageOrderSuccessMsgTitleVisible();
        if(orderSuccessMsgTitleElem){throw new Error("The checkout was successful with invalid address format input (special symbols only), test has failed");}
    }

    //invalid product checkout test method - invalid delivery city format (special symbols only)
    protected void invalidProductCheckoutInvalidCityFormatTest(String productName, String anotherProductName, String payMethod, String firstProductUnitPrice, String secondProductUnitPrice, String subTotalPrice, String deliveryPrice, String totalPrice){
        CheckoutPage checkoutPage = new CheckoutPage(page);
        CheckoutPageInvalidSingularInput checkoutPageInvalidSingularInput = new CheckoutPageInvalidSingularInput(page);
        //general page web element assert
        isGeneralPageWebElementVisible(page);
        //general page text element assert
        isGeneralPageTextElementAsExpected(page);
        //checkout page web element assert
        isCheckoutPageWebElementVisible(page);
        //checkout page text element assert
        isCheckoutPageTextElementAsExpected(page);
        //log checkout page product data
        logCheckoutPageProductData(page);
        //assert the shopping cart table contains the expected product
        List<String> checkoutPageProductTitleList = checkoutPage.getCheckoutPageOrderSummaryProductName();
        assertEquals(productName, checkoutPageProductTitleList.getFirst(), "The product name doesn't match expectations");
        //assert the shopping cart table contains the expected product
        List<String> checkoutPageProductUnitPriceList = checkoutPage.getCheckoutPageOrderSummaryProductPrice();
        assertEquals(firstProductUnitPrice, checkoutPageProductUnitPriceList.getFirst(), "The product unit price doesn't match expectations");
        if(!anotherProductName.isEmpty()){
            //assert the shopping cart table contains the other expected product
            List<String> checkoutPageProductTitles = checkoutPage.getCheckoutPageOrderSummaryProductName();
            assertTrue(checkoutPageProductTitles.contains(anotherProductName), "The other expected product isn't present in the list");
            //assert the shopping cart table contains the other expected product
            List<String> checkoutPageProductUnitPrices = checkoutPage.getCheckoutPageOrderSummaryProductPrice();
            assertTrue(checkoutPageProductUnitPrices.contains(secondProductUnitPrice), "The other expected product unit price isn't present in the list");
        }
        //assert the shopping cart table contains the expected order subtotal price
        String checkoutPageOrderSubtotalPrice = checkoutPage.getCheckoutPageOrderSummarySubtotalPrice();
        assertEquals(subTotalPrice, checkoutPageOrderSubtotalPrice, "The order subtotal price in checkout page doesn't match expectations. Expected: " + checkoutPageOrderSubtotalPrice );
        //assert the shopping cart table contains the expected order total price
        String checkoutPageOrderDeliveryPrice = checkoutPage.getCheckoutPageOrderSummaryDeliveryPrice();
        assertEquals(deliveryPrice, checkoutPageOrderDeliveryPrice, "The order delivery price in checkout page doesn't match expectations. Expected: " + checkoutPageOrderSubtotalPrice );
        //assert the shopping cart table contains the expected order total price
        String checkoutPageOrderTotalPrice = checkoutPage.getCheckoutPageOrderSummaryTotalPrice();
        assertEquals(totalPrice, checkoutPageOrderTotalPrice, "The order total price in checkout page doesn't match expectations. Expected: " + checkoutPageOrderSubtotalPrice );

        //select set payment method
        switch(payMethod){

            case "Cash":
                //click "Cash on delivery" radio button
                checkoutPage.clickSetPayMethodRadioButton(0);
                break;

            case "bKash":
                //click "bKash" radio button
                checkoutPage.clickSetPayMethodRadioButton(1);
                break;

            case "Nagad":
                //click "Nagad" radio button
                checkoutPage.clickSetPayMethodRadioButton(2);
                break;

            default:
                throw new Error("Please input either 'Cash', 'bKash' or 'Nagad'.");
        }

        //capture screenshot of the checkout page display
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("src/test/screenshots/Checkout Page/Checkout Page Display.png")).setFullPage(true));
        //invalid delivery details input data getter - invalid city format (special symbols only)
        checkoutPageInvalidSingularInput.invalidCheckoutDeliveryInvalidCityFormatDataGetter();
        //input valid full name into full name input field
        checkoutPageInvalidSingularInput.inputFullNameIntoFullNameInputField();
        //input valid phone into phone input field
        checkoutPageInvalidSingularInput.inputPhoneIntoPhoneInputField();
        //input valid address into address input field
        checkoutPageInvalidSingularInput.inputAddressIntoAddressTextarea();
        //input invalid city format into city input field (special symbols only)
        checkoutPageInvalidSingularInput.inputInvalidCityFormatIntoCityInputField();
        //capture screenshot of the invalid delivery details input display - invalid city format
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("src/test/screenshots/Invalid Checkout Page Tests/Invalid Checkout Delivery Details Input Display - Invalid Delivery City Format.png")).setFullPage(true));

        //click "Place order" button
        checkoutPage.clickPlaceOrderBtn();
        page.waitForTimeout(3000);
        //capture screenshot of the test result
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("src/test/screenshots/Invalid Checkout Page Test Results/Invalid Checkout Test Result - Invalid Delivery City Input Format.png")).setFullPage(true));
        //assert the user stays on the checkout page (since there's only React error displayed)
        boolean orderSuccessMsgTitleElem = checkoutPage.isCheckoutPageOrderSuccessMsgTitleVisible();
        if(orderSuccessMsgTitleElem){throw new Error("The checkout was successful with invalid city format input (special symbols only), test has failed");}
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


}