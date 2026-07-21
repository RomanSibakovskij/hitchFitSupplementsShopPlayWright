package io.github.rokonrj403.page.data.loggers;

import com.microsoft.playwright.Page;
import io.github.rokonrj403.pages.*;

import org.slf4j.*;

public interface PageDataLoggers {

    Logger logger = LoggerFactory.getLogger(PageDataLoggers.class);

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //home page product count data logger method (same page is for different product categories)
    default void logHomePageProductData(Page page){
        HomePage homePage = new HomePage(page);

        System.out.println("Home page displayed product data: " + "\n");

        logger.info("Displayed home page product title(s): " + homePage.getHomePageProductTitle());
        logger.info("Displayed home page product rating(s): " + homePage.getHomePageProductRating());
        logger.info("Displayed home page product unit price(s): " + homePage.getHomePageProductUnitPrice());

        System.out.println("\n");

    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //single product page product count data logger method (same page is for different product categories)
    default void logSingleProductPageProductData(Page page){
        SingleProductPage singleProductPage = new SingleProductPage(page);

        System.out.println("Single product page displayed product data: " + "\n");

        logger.info("Displayed single product page product title(s): " + singleProductPage.getSingleProductPageTitle());
        logger.info("Displayed single product page product rating(s): " + singleProductPage.getSingleProductPageProductRating());
        logger.info("Displayed single product page product unit price(s): " + singleProductPage.getSingleProductPageUnitPrice());
        logger.info("Displayed single product page product description: " + singleProductPage.getSingleProductPageProductDesc());
        logger.info("Displayed single product page product quantity: " + singleProductPage.getSingleProductPageProductQty());
        logger.info("Displayed single product page product features: " + singleProductPage.getSingleProductPageProductFeaturesText());

        System.out.println("\n");

    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //single product category page product count data logger method (same page is for different product categories)
    default void logSingleProductCategoryPageProductData(Page page){
        SingleProductCategoryPage singleProductCategoryPage = new SingleProductCategoryPage(page);

        System.out.println("Single product category page displayed product data: " + "\n");

        logger.info("Displayed single product category page product title(s): " + singleProductCategoryPage.getSingleProductCategoryPageProductTitle());
        logger.info("Displayed single product category page product rating(s): " + singleProductCategoryPage.getSingleProductCategoryPageProductRating());
        logger.info("Displayed single product category page product unit price(s): " + singleProductCategoryPage.getSingleProductCategoryPageProductUnitPrice());

        System.out.println("\n");

    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //shopping cart page product count data logger method (same page is for different product categories)
    default void logShoppingCartPageProductData(Page page){
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(page);

        System.out.println("Shopping cart page displayed product data: " + "\n");

        logger.info("Displayed shopping cart page product title(s): " + shoppingCartPage.getShoppingCartPageProductTitle());
        logger.info("Displayed shopping cart page product flavor(s): " + shoppingCartPage.getShoppingCartPageProductFlavor());
        logger.info("Displayed shopping cart page product unit price(s): " + shoppingCartPage.getShoppingCartPageProductUnitPrice());
        logger.info("Displayed shopping cart page product quantity(ies): " + shoppingCartPage.getShoppingCartPageProductQty());
        logger.info("Displayed shopping cart page product price(s): " + shoppingCartPage.getShoppingCartPageProductPrice() + "\n");

        System.out.println("Shopping cart page displayed order summary data: " + "\n");

        logger.info("Displayed shopping cart page order summary subtotal price: " + shoppingCartPage.getShoppingCartOrderSummarySubtotalPrice());
        logger.info("Displayed shopping cart page order summary delivery price: " + shoppingCartPage.getShoppingCartPageOrderSummaryDeliveryPrice());
        logger.info("Displayed shopping cart page order summary total price: " + shoppingCartPage.getShoppingCartPageOrderSummaryTotalPrice());

        System.out.println("\n");

    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //checkout page product count data logger method (same page is for different product categories)
    default void logCheckoutPageProductData(Page page){
        CheckoutPage checkoutPage = new CheckoutPage(page);

        System.out.println("Checkout page displayed order summary table product data: " + "\n");

        logger.info("Displayed checkout page product title(s): " + checkoutPage.getCheckoutPageOrderSummaryProductName());
        logger.info("Displayed checkout page product quantity(ies): " + checkoutPage.getCheckoutPageOrderSummaryProductQty());
        logger.info("Displayed checkout page product price(s): " + checkoutPage.getCheckoutPageOrderSummaryProductPrice() + "\n");

        System.out.println("Checkout page displayed order summary data: " + "\n");

        logger.info("Displayed checkout page order summary subtotal price: " + checkoutPage.getCheckoutPageOrderSummarySubtotalPrice());
        logger.info("Displayed checkout page order summary delivery price: " + checkoutPage.getCheckoutPageOrderSummaryDeliveryPrice());
        logger.info("Displayed checkout page order summary total price: " + checkoutPage.getCheckoutPageOrderSummaryTotalPrice());

        System.out.println("\n");

    }

    //checkout page product count data logger method (same page is for different product categories)
    default void logCheckoutPageOrderSuccessData(Page page){
        CheckoutPage checkoutPage = new CheckoutPage(page);

        System.out.println("Checkout page displayed order success data: " + "\n");

        logger.info("Displayed checkout page order number: " + checkoutPage.getCheckoutPageOrderNumber());
        logger.info("Displayed checkout page order total price: " + checkoutPage.getCheckoutPageOrderTotal());
        logger.info("Displayed checkout page order payment method: " + checkoutPage.getCheckoutPageOrderPayMethod() + "\n");

        System.out.println("\n");

    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}
