package io.github.rokonrj403.page.text.element.assertion;

import com.microsoft.playwright.Page;
import io.github.rokonrj403.pages.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public interface PageTextElementAsserts {

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //general page text element asserts
    default void isGeneralPageTextElementAsExpected(Page page) {
        GeneralPage generalPage = new GeneralPage(page);
        //header
        //assert the header upper bar text matches expectations
        assertEquals("Trusted by 20,000+ Clients Worldwide | Free Delivery over BDT 5000", generalPage.getHeaderTrustedText(), "The general page header trusted text doesn't match expectations.");
        //list elements
        //assert the general page upper navbar link texts are as expected (as a list)
        List<String> generalPageUpperNavbarLinkTexts = Arrays.asList("SHOP ALL", "PROTEINS", "STACKS", "PRE-WORKOUTS", "DAILY NUTRITION", "ABOUT");
        List<String> actualGeneralPageUpperNavbarLinkTexts = generalPage.getHeaderNavbarLinkText();
        assertEquals(generalPageUpperNavbarLinkTexts, actualGeneralPageUpperNavbarLinkTexts, "The general page upper navbar link texts don't match expectations.");
        //footer
        //assert the general page footer hitch fit subtext matches expectations
        assertEquals("Hitch Fit is more than physical transformation. It is about strengthening the body, mind and spirit.", generalPage.getFooterHitchFitSubtext(), "The general page footer hitch fit subtext doesn't match expectations.");
        //shop section
        //assert the general page footer shop section title matches expectations
        assertEquals("SHOP", generalPage.getFooterShopSectionTitle(), "The general page footer shop section title doesn't match expectations.");
        //list elements
        //assert the general page footer shop section link texts are as expected (as a list)
        List<String> generalPageFooterShopLinkTexts = Arrays.asList("Shop All", "Proteins", "Stacks", "Pre-Workouts", "Daily Nutrition");
        List<String> actualGeneralPageFooterShopLinkTexts = generalPage.getFooterShopSectionLinkText();
        assertEquals(generalPageFooterShopLinkTexts, actualGeneralPageFooterShopLinkTexts, "The general page footer shop section link texts don't match expectations.");
        //company section
        //assert the general page footer company section title matches expectations
        assertEquals("COMPANY", generalPage.getFooterCompanySectionTitle(), "The general page footer company section title doesn't match expectations.");
        //list elements
        //assert the general page footer company section link texts are as expected (as a list)
        List<String> generalPageFooterCompanyLinkTexts = Arrays.asList("About Hitch Fit", "Contact Us", "Fitness Hub");
        List<String> actualGeneralPageFooterCompanyLinkTexts = generalPage.getFooterCompanyLinkText();
        assertEquals(generalPageFooterCompanyLinkTexts, actualGeneralPageFooterCompanyLinkTexts, "The general page footer company section link texts don't match expectations.");
        //support section
        //assert the general page footer support section title matches expectations
        assertEquals("SUPPORT", generalPage.getFooterSupportSectionTitle(), "The general page footer support section title doesn't match expectations.");
        //list elements
        //assert the general page footer support section link texts are as expected (as a list)
        List<String> generalPageFooterSupportLinkTexts = Arrays.asList("Return Policy", "Terms of Service", "Privacy Policy");
        List<String> actualGeneralPageFooterSupportLinkTexts = generalPage.getFooterSupportLinkText();
        assertEquals(generalPageFooterSupportLinkTexts, actualGeneralPageFooterSupportLinkTexts, "The general page footer support section link texts don't match expectations.");
        //copyright section
        //assert the general page footer copyright text matches expectations
        assertEquals("© 2026 Hitch Fit Supplements BD - All Rights Reserved", generalPage.getFooterCopyrightText(), "The general page footer copyright text doesn't match expectations.");
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //home page text element asserts
    default void isHomePageTextElementAsExpected(Page page) {
        HomePage homePage = new HomePage(page);
        //main
        //assert the home page upper image title matches expectations
        assertEquals("TRAIN HARD, BURN SMARTER", homePage.getHomePageUpperImgTitle(), "The home page upper image title doesn't match expectations.");
        //assert the home page upper image subtext matches expectations
        assertEquals("Complete Weight Loss Stack for Fat Loss, Energy and Recovery", homePage.getHomePageUpperImgSubtext(), "The home page upper image subtext doesn't match expectations.");
        //assert the home page upper image 'Shop Now' button text matches expectations
        assertEquals("SHOP NOW", homePage.getHomePageUpperImgShopNowBtnText(), "The home page upper image 'Shop Now' button text doesn't match expectations.");
        //bestselling supplements section
        //singular elements
        //assert the home page bestselling supplements section title matches expectations
        assertEquals("BEST SELLING SUPPLEMENTS", homePage.getHomePageBestSellingSupplementsSecTitle(), "The home page bestselling supplements section title doesn't match expectations.");
        //assert the home page bestselling supplements section subtext matches expectations
        assertEquals("Top-rated formulas trusted by athletes", homePage.getHomePageBestSellingSupplementsSecSubtext(), "The home page bestselling supplements section subtext doesn't match expectations.");
        //assert the home page bestselling supplements section 'View all products' button text matches expectations
        assertEquals("VIEW ALL PRODUCTS", homePage.getHomePageBestSellingSupplementsSecViewAllProductsBtnText(), "The home page bestselling supplements section 'View All Products' button text doesn't match expectations.");
        //list elements
        //assert the home page bestselling supplements section "Choose Options" button texts are as expected (as a list)
        List<String> actualHomePageChooseOptionsBtnTexts = homePage.getHomePageBestSellingSupplementsSecChooseOptionsBtnText();
        for (String btnText : actualHomePageChooseOptionsBtnTexts) {
            assertEquals("CHOOSE OPTIONS", btnText, "The home page product card 'Choose options' button texts don't match expectations.");
        }
        //hitch fit supplements section
        //singular elements
        //assert the home page hitch fit supplements section title matches expectations
        assertEquals("WHY HITCH FIT SUPPLEMENTS?", homePage.getHomePageHitchFitSecTitle(), "The home page hitch fit supplements section title doesn't match expectations.");
        //assert the home page hitch fit supplements section subtext matches expectations
        assertEquals("At Hitch Fit, supplements are more than ingredients in a bottle. They are a foundation for transformation. Every formula is made with clean, premium ingredients and tested for purity. From elite athletes to everyday people, our supplements support muscle growth, fat loss, energy and total body health.", homePage.getHomePageHitchFitSecSubtext(), "The home page hitch fit supplements section subtext doesn't match expectations.");
        //assert the home page hitch fit supplements section 'Shop all products' button text matches expectations
        assertEquals("SHOP ALL PRODUCTS", homePage.getHomePageHitchFitSecShopAllProductsBtnText(), "The home page hitch fit supplements section 'Shop All Products' button text doesn't match expectations.");
        //keep me updated section
        //singular elements
        //assert the home page keep me updated section title matches expectations
        assertEquals("KEEP ME UPDATED", homePage.getHomePageKeepMeUpdatedSecTitle(), "The home page keep me updated section title doesn't match expectations.");
        //assert the home page keep me updated section subtext matches expectations
        assertEquals("Join 20,000+ people who have transformed their bodies with Hitch Fit", homePage.getHomePageKeepMeUpdatedSecSubtext(), "The home page keep me updated section subtext doesn't match expectations.");
        //assert the home page keep me updated section 'Shop all products' button text matches expectations
        assertEquals("SUBSCRIBE", homePage.getHomePageKeepMeUpdatedSecSubscribeBtnText(), "The home page keep me updated section 'Subscribe' button text doesn't match expectations.");

    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //single product page text element asserts
    default void isSingleProductPageTextElementAsExpected(Page page) {
        SingleProductPage singleProductPage = new SingleProductPage(page);
        //main
        //assert the single product page flavor subtext matches expectations
        assertEquals("FLAVOR:", singleProductPage.getSingleProductPageFlavorSubtext(), "The single product page flavor subtext doesn't match expectations.");
        //assert the single product page quantity subtext matches expectations
        assertEquals("QUANTITY:", singleProductPage.getSingleProductPageQtySubtext(), "The single product page quantity subtext doesn't match expectations.");
        //assert the single product page "Add to cart" button text matches expectations
        assertEquals("ADD TO CART", singleProductPage.getSingleProductPageAddToCartBtnText(), "The single product page 'Add to cart' button text doesn't match expectations.");
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //single product category page text element asserts
    default void isSingleProductCategoryPageTextElementAsExpected(Page page) {
        SingleProductCategoryPage singleProductCategoryPage = new SingleProductCategoryPage(page);
        //main
        //assert the single product category page title matches expectations
        assertEquals("SHOP ALL SUPPLEMENTS", singleProductCategoryPage.getSingleProductCategoryPageTitle(), "The single product category page title doesn't match expectations.");
        //assert the single product category page subtext matches expectations
        assertEquals("Clean, premium formulas for every goal", singleProductCategoryPage.getSingleProductCategoryPageSubtext(), "The single product category page subtext doesn't match expectations.");
        //list elements
        //assert the single product category page category button texts are as expected (as a list)
        List<String> singleProductCategoryPageCategoryBtnTexts = Arrays.asList("ALL", "PROTEINS", "PRE-WORKOUTS & MORE", "DAILY NUTRITION", "STACKS");
        List<String> actualSingleProductCategoryPageCategoryBtnTexts = singleProductCategoryPage.getSingleProductCategoryPageCategoryBtnText();
        assertEquals(singleProductCategoryPageCategoryBtnTexts, actualSingleProductCategoryPageCategoryBtnTexts, "The single product category page category button texts don't match expectations.");
        //assert the single product category page product card "Choose options" button texts are as expected (as a list)
        List<String> actualSingleProductCategoryPageChooseOptionsBtnTexts = singleProductCategoryPage.getSingleProductCategoryPageProductCardChooseOptionBtnText();
        for (String btnText : actualSingleProductCategoryPageChooseOptionsBtnTexts) {
            assertEquals("CHOOSE OPTIONS", btnText, "The single product category page product card 'Choose options' button texts don't match expectations.");
        }
    }


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //shopping cart page text element asserts
    default void isShoppingCartPageTextElementAsExpected(Page page) {
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(page);
        //main
        //assert the shopping cart page title matches expectations
        assertEquals("YOUR CART", shoppingCartPage.getShoppingCartPageTitle(), "The shopping cart page title doesn't match expectations.");
        //assert the shopping cart page order summary section title matches expectations
        assertEquals("ORDER SUMMARY", shoppingCartPage.getShoppingCartPageOrderSummarySecTitle(), "The shopping cart page order summary section title doesn't match expectations.");
        //assert the shopping cart page order summary subtotal subtext matches expectations
        assertEquals("Subtotal", shoppingCartPage.getShoppingCartPageOrderSummarySubtotalSubtext(), "The shopping cart page order summary subtotal subtext doesn't match expectations.");
        //assert the shopping cart page order summary delivery subtext matches expectations
        assertEquals("Delivery", shoppingCartPage.getShoppingCartPageOrderSummaryDeliverySubtext(), "The shopping cart page order summary delivery subtext doesn't match expectations.");
        //assert the shopping cart page order summary total subtext matches expectations
        assertEquals("Total", shoppingCartPage.getShoppingCartPageOrderSummaryTotalSubtext(), "The shopping cart page order summary total subtext doesn't match expectations.");
        //assert the shopping cart page order summary free delivery text matches expectations
        assertEquals("Free delivery on orders over BDT 5,000", shoppingCartPage.getShoppingCartPageOrderSummaryFreeDeliverySubtext(), "The shopping cart page order summary free delivery text doesn't match expectations.");
        //assert the shopping cart page checkout button text matches expectations
        assertEquals("CHECKOUT", shoppingCartPage.getShoppingCartPageCheckoutBtnText(), "The shopping cart page checkout button text doesn't match expectations.");
        //assert the shopping cart page continue shopping link text matches expectations
        assertEquals("CONTINUE SHOPPING", shoppingCartPage.getShoppingCartPageContinueShoppingLinkText(), "The shopping cart page continue shopping link text doesn't match expectations.");

        //table
        //list elements
        //assert the shopping cart page product "Remove" button texts are as expected (as a list)
        List<String> actualShoppingPageProductRemoveBtnTexts = shoppingCartPage.getShoppingCartPageProductRemoveBtnText();
        for (String btnText : actualShoppingPageProductRemoveBtnTexts) {
            assertEquals("REMOVE", btnText, "The shopping cart page product 'Remove' button texts don't match expectations.");
        }
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //checkout page text element asserts
    default void isCheckoutPageTextElementAsExpected(Page page) {
        CheckoutPage checkoutPage = new CheckoutPage(page);
        //main
        //assert the checkout page title matches expectations
        assertEquals("CHECKOUT", checkoutPage.getCheckoutPageTitle(), "The checkout page title doesn't match expectations.");
        //assert the checkout page place order button text matches expectations
        assertEquals("PLACE ORDER", checkoutPage.getCheckoutPagePlaceOrderBtnText(), "The checkout page place order button text doesn't match expectations.");

        //delivery details section
        //singular elements
        //assert the checkout page delivery details section title matches expectations
        assertEquals("DELIVERY DETAILS", checkoutPage.getCheckoutPageDeliverySecTitle(), "The checkout page delivery details section title doesn't match expectations.");
        //assert the checkout page delivery details full name subtext matches expectations
        assertEquals("Full Name *", checkoutPage.getCheckoutPageDeliverySecFullNameSubtext(), "The checkout page delivery details full name subtext doesn't match expectations.");
        //assert the checkout page delivery details phone subtext matches expectations
        assertEquals("Phone Number *", checkoutPage.getCheckoutPageDeliverySecPhoneSubtext(), "The checkout page delivery details phone subtext doesn't match expectations.");
        //assert the checkout page delivery details email subtext matches expectations
        assertEquals("Email", checkoutPage.getCheckoutPageDeliverySecEmailSubtext(), "The checkout page delivery details email subtext doesn't match expectations.");
        //assert the checkout page delivery details address subtext matches expectations
        assertEquals("Delivery Address *", checkoutPage.getCheckoutPageDeliverySecAddressSubtext(), "The checkout page delivery details address subtext doesn't match expectations.");
        //assert the checkout page delivery details city subtext matches expectations
        assertEquals("City / District *", checkoutPage.getCheckoutPageDeliverySecCitySubtext(), "The checkout page delivery details city subtext doesn't match expectations.");
        //payment method section
        //assert the checkout page payment method section email subtext matches expectations
        assertEquals("PAYMENT METHOD", checkoutPage.getCheckoutPagePayMethodSecTitle(), "The checkout page payment method section title doesn't match expectations.");
        //assert the checkout page payment method order notes subtext matches expectations
        assertEquals("Order Notes", checkoutPage.getCheckoutPagePayMethodSecOrderNotesSubtext(), "The checkout page payment method order notes subtext doesn't match expectations.");
        //list elements
        //assert the checkout page payment method radio button texts are as expected (as a list)
        List<String> checkoutPagePayMethodRadioBtnTexts = Arrays.asList("Cash on Delivery","bKash","Nagad");
        List<String> actualCheckoutPagePayMethodRadioBtnTexts = checkoutPage.getCheckoutPagePayMethodRadioBtnText();
        assertEquals(checkoutPagePayMethodRadioBtnTexts, actualCheckoutPagePayMethodRadioBtnTexts, "The checkout page radio button texts don't match expectations.");
        //order summary section
        //singular elements
        //assert the checkout page order summary section title matches expectations
        assertEquals("ORDER SUMMARY", checkoutPage.getCheckoutPageOrderSummarySecTitle(), "The checkout page order summary section title doesn't match expectations.");
        //assert the checkout page order summary subtotal subtext matches expectations
        assertEquals("Subtotal", checkoutPage.getCheckoutPageOrderSummarySecSubtotalSubtext(), "The checkout page order summary subtotal subtext doesn't match expectations.");
        //assert the checkout page order summary delivery subtext matches expectations
        assertEquals("Delivery", checkoutPage.getCheckoutPageOrderSummarySecDeliverySubtext(), "The checkout page order summary delivery subtext doesn't match expectations.");
        //assert the checkout page order summary total subtext matches expectations
        assertEquals("Total", checkoutPage.getCheckoutPageOrderSummarySecTotalSubtext(), "The checkout page order summary total subtext doesn't match expectations.");
        //assert the checkout page order summary 'Edit cart' link text matches expectations
        assertEquals("EDIT CART", checkoutPage.getCheckoutPageOrderSummarySecEditLinkText(), "The checkout page order summary 'Edit cart' link text doesn't match expectations.");
    }

    //checkout page (order success section) text element asserts
    default void isCheckoutPageOrderSuccessSecTextElementAsExpected(Page page) {
        CheckoutPage checkoutPage = new CheckoutPage(page);
        //assert the checkout page order success message title matches expectations
        assertEquals("THANK YOU FOR YOUR ORDER!", checkoutPage.getCheckoutPageOrderSuccessMsgTitle(), "The checkout page order success message title doesn't match expectations.");
        //assert the checkout page order success message subtitle matches expectations
        assertEquals("Your order has been placed successfully.", checkoutPage.getCheckoutPageOrderSuccessMsgSubtitle(), "The checkout page order success message subtitle doesn't match expectations.");
        //assert the checkout page order number subtext matches expectations
        assertEquals("Order Number", checkoutPage.getCheckoutPageOrderNumberSubtext(), "The checkout page order number subtext doesn't match expectations.");
        //assert the checkout page order total subtext matches expectations
        assertEquals("Total", checkoutPage.getCheckoutPageOrderTotalSubtext(), "The checkout page order total subtext doesn't match expectations.");
        //assert the checkout page order pay method subtext matches expectations
        assertEquals("Payment", checkoutPage.getCheckoutPageOrderPayMethodSubtext(), "The checkout page order pay method subtext doesn't match expectations.");
        //assert the checkout page order confirm delivery text matches expectations
        assertEquals("We will call you shortly to confirm delivery. Free delivery on orders over BDT 5,000.", checkoutPage.getCheckoutPageConfirmDeliveryText(), "The checkout page order confirm delivery text doesn't match expectations.");
        //assert the checkout page continue shopping button text matches expectations
        assertEquals("CONTINUE SHOPPING", checkoutPage.getCheckoutPageContinueShoppingBtnText(), "The checkout page continue shopping button text doesn't match expectations.");
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}
