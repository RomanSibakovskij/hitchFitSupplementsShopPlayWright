package io.github.rokonrj403.page.web.element.assertion;

import com.microsoft.playwright.Page;
import io.github.rokonrj403.pages.*;
import io.github.rokonrj403.pages.utilities.BasePage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public interface PageWebElementAsserts {

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //general page web element assert test method (elements all pages have)
    default void isGeneralPageWebElementVisible(Page page) {
        BasePage basePage = new BasePage(page);
        GeneralPage generalPage = new GeneralPage(page);
        //header
        //assert header homepage icon link is displayed
        assertTrue(generalPage.isHeaderHomePageIconLinkVisible(), "The header home page icon link isn't visible."); //generalPage.isHeaderHomePageIconLinkVisible()
        //list elements
        //assert header navbar links are displayed
        assertTrue(generalPage.isHeaderNavbarLinkElementsVisible(), "The header navbar links aren't visible.");
        //singular elements
        //assert header homepage shopping cart button is displayed
        assertTrue(generalPage.isSingleElementVisible(), "The header shopping cart button isn't visible.");

        //footer
        //assert footer hitch fit icon is displayed
        assertTrue(generalPage.isFooterHitchFitIconVisible(), "The footer hitch fit icon isn't visible.");
        //assert footer hitch fit subtext is displayed
        assertTrue(generalPage.isFooterHitchFitSubtextVisible(), "The footer hitch fit subtext isn't visible.");
        //shop section
        //assert footer shop section title is displayed
        assertTrue(generalPage.isFooterShopSectionTitleVisible(), "The footer shop section title isn't visible.");
        //list elements
        //assert footer shop section links are displayed
        assertTrue(generalPage.isFooterShopSectionLinkElementsVisible(), "The footer shop section links aren't visible.");
        //company section
        //assert footer company section title is displayed
        assertTrue(generalPage.isFooterCompanySectionTitleVisible(), "The footer company section title isn't visible.");
        //list elements
        //assert footer company section links are displayed
        assertTrue(generalPage.isFooterCompanySectionLinkElementsVisible(), "The footer company section links aren't visible.");
        //support section
        //assert footer support section title is displayed
        assertTrue(generalPage.isFooterSupportSectionTitleVisible(), "The footer get in touch section title isn't visible.");
        //list elements
        //assert footer support section links are displayed
        assertTrue(generalPage.isFooterSupportLinkElementsVisible(), "The footer support section links aren't visible.");
        //copyright section
        //assert footer copyright text is displayed
        assertTrue(generalPage.isFooterCopyrightTextVisible(), "The footer copyright text isn't visible.");
    }


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    //home page web element assert test method
    default void isHomePageWebElementVisible(Page page) {
        HomePage homePage = new HomePage(page);
        //main
        //singular elements
        //assert the home page upper image is displayed
        assertTrue(homePage.isHomePageUpperImgVisible(), "The home page upper image isn't visible.");
        //assert the home page upper image title is displayed
        assertTrue(homePage.isHomePageUpperImgTitleVisible(), "The home page upper image title isn't visible.");
        //assert the home page upper image subtext is displayed
        assertTrue(homePage.isHomePageUpperImgSubtextVisible(), "The home page upper image subtext isn't visible.");
        //assert the home page upper image 'Shop now' button is displayed
        assertTrue(homePage.isHomePageUpperImgShopNowBtnVisible(), "The home page upper image 'Shop now' button isn't visible.");
        //best supplements section
        //singular elements
        //assert the home page best supplements section title is displayed
        assertTrue(homePage.isHomePageBestSupplementsSectionTitleVisible(), "The home page best supplements section title isn't visible.");
        //assert the home page best supplements section subtext is displayed
        assertTrue(homePage.isHomePageBestSupplementsSectionSubtextVisible(), "The home page best supplements section subtext isn't visible.");
        //assert the home page best supplements section 'View all products' button is displayed
        assertTrue(homePage.isHomePageBestSupplementsSecProductCardViewAllProductBtnVisible(), "The home page best supplements section 'View all products' button isn't visible.");
        //list elements
        //assert the home page category buttons are displayed (as a list)
        assertTrue(homePage.isHomePageBestSupplementsSecProductCardImgElementVisible(), "The home page best supplements section product card images aren't visible.");
        //assert the home page product card images are displayed (as a list)
        assertTrue(homePage.isHomePageBestSupplementsSecProductCardRatingElementVisible(), "The home page best supplements section product card images aren't visible.");
        //assert the home page product card ratings are displayed (as a list)
        assertTrue(homePage.isHomePageBestSupplementsSecProductCardTitleElementVisible(), "The home page best supplements section product card titles aren't visible.");
        //assert the home page product card product titles are displayed (as a list)
        assertTrue(homePage.isSHomePageBestSupplementsSecProductCardUnitPriceElementVisible(), "The home page best supplements section product card unit prices aren't visible.");
        //assert the home page product card item prices are displayed (as a list)
        assertTrue(homePage.isHomePageBestSupplementsSecProductCardChooseOptionsElementVisible(), "The home page best supplements section product card 'Choose options' buttons aren't visible.");
        //hitch fit section
        //singular elements
        //assert the home page hitch fit section title is displayed
        assertTrue(homePage.isHomePageHitchFitSupplementsTitleVisible(), "The home page hitch fit section title isn't visible.");
        //assert the home page hitch fit section subtext is displayed
        assertTrue(homePage.isHomePageHitchFitSupplementsSubtextVisible(), "The home page hitch fit section subtext isn't visible.");
        //assert the home page hitch fit section 'Shop all products' button is displayed
        assertTrue(homePage.isHomePageHitchFitSupplementsSecShopAllProductsBtnVisible(), "The home page hitch fit section 'Shop all products' button isn't visible.");
        //keep me updated section
        //singular elements
        //assert the home page keep me updated section title is displayed
        assertTrue(homePage.isHomePageKeepMeUpdatedSecTitleVisible(), "The home page keep me updated section title isn't visible.");
        //assert the home page keep me updated section subtext is displayed
        assertTrue(homePage.isHomePageKeepMeUpdatedSecSubtextVisible(), "The home page keep me updated section subtext isn't visible.");
        //assert the home page keep me updated section email input field is displayed
        assertTrue(homePage.isHomePageKeepMeUpdatedSecEnterEmailInputFieldVisible(), "The home page keep me updated section email input field isn't visible.");
        //assert the home page keep me updated section 'Subscribe' button is displayed
        assertTrue(homePage.isHomePageHitchFitSupplementsSecSubscribeBtnVisible(), "The home page keep me updated section 'Subscribe' button isn't visible.");
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    //single product page web element assert test method
    default void isSingleProductPageWebElementVisible(Page page) {
        SingleProductPage singleProductPage = new SingleProductPage(page);
        //assert the single product page product main image is visible
        assertTrue(singleProductPage.isSingleProductPageMainImgVisible(), "The single product page product main image isn't visible.");
        //assert the single product page product title is visible
        assertTrue(singleProductPage.isSingleProductPageTitleVisible(), "The single product page product title isn't visible.");
        //assert the single product page product rating is visible
        assertTrue(singleProductPage.isSingleProductPageProductRatingVisible(), "The single product page product rating isn't visible.");
        //assert the single product page product unit price is visible
        assertTrue(singleProductPage.isSingleProductPageUnitPriceVisible(), "The single product page product unit price isn't visible.");
        //assert the single product page product description is visible
        assertTrue(singleProductPage.isSingleProductPageDescVisible(), "The single product page product description isn't visible.");
        //assert the single product page product flavor subtext is visible
        assertTrue(singleProductPage.isSingleProductPageFlavorSubtextVisible(), "The single product page product flavor subtext isn't visible.");
        //assert the single product page product quantity subtext is visible
        assertTrue(singleProductPage.isSingleProductPageQuantitySubtextVisible(), "The single product page product quantity subtext isn't visible.");
        //assert the single product page product quantity decrease button is visible
        assertTrue(singleProductPage.isSingleProductPageQtyDecreaseBtnVisible(), "The single product page product quantity decrease button isn't visible.");
        //assert the single product page product quantity input field is visible
        assertTrue(singleProductPage.isSingleProductPageQtyInputFieldVisible(), "The single product page product quantity input field isn't visible.");
        //assert the single product page product quantity increase button is visible
        assertTrue(singleProductPage.isSingleProductPageQtyIncreaseBtnVisible(), "The single product page product quantity increase button isn't visible.");
        //assert the single product page "Add to cart" button is visible
        assertTrue(singleProductPage.isSingleProductPageAddToCartBtnVisible(), "The single product page 'Add to cart' button isn't visible.");
        //list elements
        //assert the single product page feature buttons are visible (as a list)
        assertTrue(singleProductPage.isSingleProductPageFeaturesBtnElementVisible(), "The single product page feature buttons aren't visible.");
        //assert the single product page product features are visible (as a list)
        assertTrue(singleProductPage.isSingleProductPageProductFeaturesElementVisible(), "The single product page product features aren't visible.");
    }



///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //single product category page web element test assert method
    default void  isSingleProductCategoryPageWebElementVisible(Page page){
       SingleProductCategoryPage singleProductCategoryPage = new SingleProductCategoryPage(page);
        //assert the single product category page title is visible
        assertTrue(singleProductCategoryPage.isSingleProductCategoryPageTitleVisible(), "The single product category page title isn't visible.");
        //assert the single product category page subtext is visible
        assertTrue(singleProductCategoryPage.isSingleProductCategoryPageSubtextVisible(), "The single product category page subtext isn't visible.");
        //list elements
        //assert the single product category page category buttons are visible (as a list)
        assertTrue(singleProductCategoryPage.isSingleProductCategoryPageCategoryBtnElementsVisible(), "The single product category page category buttons aren't visible.");
        //assert the single product category page product card images are visible (as a list)
        assertTrue(singleProductCategoryPage.isSingleProductCategoryPageProductCardImgElementsVisible(), "The single product category page product card images aren't visible.");
        //assert the single product category page product card ratings are visible (as a list)
        assertTrue(singleProductCategoryPage.isSingleProductCategoryPageProductCardRatingElementsVisible(), "The single product category page product card ratings aren't visible.");
        //assert the single product category page product card titles are visible (as a list)
        assertTrue(singleProductCategoryPage.isSingleProductCategoryPageProductCardTitleElementsVisible(), "The single product category page product card titles aren't visible.");
        //assert the single product category page product card unit prices are visible (as a list)
        assertTrue(singleProductCategoryPage.isSingleProductCategoryPageProductCardPriceElementsVisible(), "The single product category page product card unit prices aren't visible.");
        //assert the single product category page product card 'Choose options' buttons are visible (as a list)
        assertTrue(singleProductCategoryPage.isSingleProductCategoryPageProductCardChooseOptionBtnElementsVisible(), "The single product category page product card 'Choose options' buttons aren't visible.");
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //shopping cart page web element test assert method
    default void  isShoppingCartPageWebElementVisible(Page page){
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(page);
        //assert the shopping cart page title is visible
        assertTrue(shoppingCartPage.isShoppingCartPageTitleVisible(), "The shopping cart page title isn't visible.");
        //assert the shopping cart page order summary section title is visible
        assertTrue(shoppingCartPage.isShoppingCartPageOrderSummarySecTitleVisible(), "The shopping cart page order summary section title isn't visible.");
        //assert the shopping cart page order summary subtotal subtext is visible
        assertTrue(shoppingCartPage.isShoppingCartPageOrderSummarySubtotalSubtextVisible(), "The shopping cart page order summary section subtotal subtext isn't visible.");
        //assert the shopping cart page order summary subtotal price is visible
        assertTrue(shoppingCartPage.isShoppingCartPageOrderSummarySubtotalPriceVisible(), "The shopping cart page order summary subtotal price isn't visible.");
        //assert the shopping cart page order summary delivery subtext is visible
        assertTrue(shoppingCartPage.isShoppingCartPageOrderSummaryDeliverySubtextVisible(), "The shopping cart page order summary delivery subtext isn't visible.");
        //assert the shopping cart page order summary delivery price is visible
        assertTrue(shoppingCartPage.isShoppingCartPageOrderSummaryDeliveryPriceVisible(), "The shopping cart page order summary delivery price isn't visible.");
        //assert the shopping cart page order summary total subtext is visible
        assertTrue(shoppingCartPage.isShoppingCartPageOrderSummaryTotalSubtextVisible(), "The shopping cart page order summary total subtext isn't visible.");
        //assert the shopping cart page order summary total price is visible
        assertTrue(shoppingCartPage.isShoppingCartPageOrderSummaryTotalPriceVisible(), "The shopping cart page order summary total price isn't visible.");
        //assert the shopping cart page order summary free delivery subtext is visible
        assertTrue(shoppingCartPage.isShoppingCartPageOrderSummaryFreeDeliveryTextVisible(), "The shopping cart page order summary free delivery subtext isn't visible.");
        //assert the shopping cart page checkout button is visible
        assertTrue(shoppingCartPage.isShoppingCartPageCheckoutBtnVisible(), "The shopping cart page checkout button isn't visible.");
        //assert the shopping cart page 'Continue shopping' link is visible
        assertTrue(shoppingCartPage.isShoppingCartPageContinueShoppingLinkVisible(), "The shopping cart page 'Continue shopping' link isn't visible.");
        //table
        //list elements
        //assert the shopping cart page product images are visible (as a list)
        assertTrue(shoppingCartPage.isShoppingCartPageProductImgElementVisible(), "The shopping cart page category product images aren't visible.");
        //assert the shopping cart page product flavors are visible (as a list)
        assertTrue(shoppingCartPage.isShoppingCartPageProductFlavorElementVisible(), "The shopping cart page product flavors aren't visible.");
        //assert the shopping cart page product unit prices are visible (as a list)
        assertTrue(shoppingCartPage.isShoppingCartPageProductUnitPriceElementVisible(), "The shopping cart page product unit prices aren't visible.");
        //assert the shopping cart page product remove buttons are visible (as a list)
        assertTrue(shoppingCartPage.isShoppingCartPageProductRemoveBtnElementVisible(), "The shopping cart page product remove buttons aren't visible.");
        //assert the shopping cart page product qty decrease buttons are visible (as a list)
        assertTrue(shoppingCartPage.isShoppingCartPageProductQtyDecreaseBtnElementVisible(), "The shopping cart page product qty decrease buttons aren't visible.");
        //assert the shopping cart page product qty input fields are visible (as a list)
        assertTrue(shoppingCartPage.isShoppingCartPageProductQtyInputFieldElementVisible(), "The shopping cart page product qty input fields aren't visible.");
        //assert the shopping cart page product qty increase buttons are visible (as a list)
        assertTrue(shoppingCartPage.isShoppingCartPageProductQtyIncreaseBtnElementVisible(), "The shopping cart page product qty increase buttons aren't visible.");
        //assert the shopping cart page product prices are visible (as a list)
        assertTrue(shoppingCartPage.isShoppingCartPageProductPriceElementVisible(), "The shopping cart page product prices aren't visible.");
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //checkout page web element assert test method
    default void isCheckoutPageWebElementVisible(Page page) {
        CheckoutPage checkoutPage = new CheckoutPage(page);
        //assert the checkout page title is visible
        assertTrue(checkoutPage.isCheckoutPageTitleVisible(), "The checkout page title isn't visible.");
        //assert the checkout page place order button is visible
        assertTrue(checkoutPage.isCheckoutPagePlaceOrderBtnVisible(), "The checkout page place order button isn't visible.");
        //delivery details section
        //singular elements
        //assert the checkout page delivery details section title is visible
        assertTrue(checkoutPage.isCheckoutPageDeliveryDetailsSectionTitleVisible(), "The checkout page delivery details section title isn't visible.");
        //input form
        //assert the checkout page full name subtext is visible
        assertTrue(checkoutPage.isCheckoutPageDeliveryDetailsSecFullNameSubtextVisible(), "The checkout page full name subtext isn't visible.");
        //assert the checkout page full name input field is visible
        assertTrue(checkoutPage.isCheckoutPageDeliveryDetailsSecFullNameInputFieldVisible(), "The checkout page full name input field isn't visible.");
        //assert the checkout page email subtext is visible
        assertTrue(checkoutPage.isCheckoutPageDeliveryDetailsSecEmailSubtextVisible(), "The checkout page email subtext isn't visible.");
        //assert the checkout page email input field is visible
        assertTrue(checkoutPage.isCheckoutPageDeliveryDetailsSecEmailInputFieldVisible(), "The checkout page email input field isn't visible.");
        //assert the checkout page phone subtext is visible
        assertTrue(checkoutPage.isCheckoutPageDeliveryDetailsSecPhoneSubtextVisible(), "The checkout page phone subtext isn't visible.");
        //assert the checkout page phone input field is visible
        assertTrue(checkoutPage.isCheckoutPageDeliveryDetailsSecPhoneInputFieldVisible(), "The checkout page phone input field isn't visible.");
        //assert the checkout page address subtext is visible
        assertTrue(checkoutPage.isCheckoutPageDeliveryDetailsSecAddressSubtextVisible(), "The checkout page address subtext isn't visible.");
        //assert the checkout page address text area is visible
        assertTrue(checkoutPage.isCheckoutPageDeliveryDetailsSecAddressTextareaVisible(), "The checkout page address textarea isn't visible.");
        //assert the checkout page city subtext is visible
        assertTrue(checkoutPage.isCheckoutPageDeliveryDetailsSecCitySubtextVisible(), "The checkout page city subtext isn't visible.");
        //assert the checkout page city text area is visible
        assertTrue(checkoutPage.isCheckoutPageDeliveryDetailsSecCityInputFieldVisible(), "The checkout page city text area isn't visible.");
        //payment method section
        //singular elements
        //assert the payment method section title is visible
        assertTrue(checkoutPage.isCheckoutPagePayMethodSecTitleVisible(), "The checkout page payment method section title isn't visible.");
        //assert the payment method order notes subtext is visible
        assertTrue(checkoutPage.isCheckoutPagePayMethodSecOrderNotesSubtextVisible(), "The checkout page payment method section order notes subtext isn't visible.");
        //assert the payment method section order notes textarea is visible
        assertTrue(checkoutPage.isCheckoutPagePayMethodSecOrderNotesTextareaVisible(), "The checkout page payment method section order notes textarea isn't visible.");
        //list elements
        //assert the checkout page payment method radio button subtexts are visible (as a list)
        assertTrue(checkoutPage.isCheckoutPagePayMethodSecRadioBtnSubtextElementVisible(), "The checkout page payment method radio button subtexts aren't visible.");
        //assert the checkout page payment method radio buttons are visible (as a list)
        assertTrue(checkoutPage.isCheckoutPagePayMethodSecRadioBtnElementVisible(), "The checkout page payment method radio buttons aren't visible.");
        //order summary section
        //singular elements
        //assert the checkout page order summary section title is visible
        assertTrue(checkoutPage.isCheckoutPageOrderSummarySectionTitleVisible(), "The checkout page order summary section title isn't visible.");
        //assert the checkout page order summary subtotal subtext is visible
        assertTrue(checkoutPage.isCheckoutPageOrderSummarySecSubtotalSubtextVisible(), "The checkout page order summary subtotal subtext isn't visible.");
        //assert the checkout page order summary subtotal price is visible
        assertTrue(checkoutPage.isCheckoutPageOrderSummarySecSubtotalPriceVisible(), "The checkout page order summary subtotal price isn't visible.");
        //assert the checkout page order summary delivery subtext is visible
        assertTrue(checkoutPage.isCheckoutPageOrderSummarySecDeliverySubtextVisible(), "The checkout page order summary delivery subtext isn't visible.");
        //assert the checkout page order summary delivery price is visible
        assertTrue(checkoutPage.isCheckoutPageOrderSummarySecDeliveryPriceVisible(), "The checkout page order summary delivery price isn't visible.");
        //assert the checkout page order summary total subtext is visible
        assertTrue(checkoutPage.isCheckoutPageOrderSummarySecTotalSubtextVisible(), "The checkout page order summary total subtext isn't visible.");
        //assert the checkout page order summary total price is visible
        assertTrue(checkoutPage.isCheckoutPageOrderSummarySecTotalPriceVisible(), "The checkout page order summary total price isn't visible.");
        //assert the checkout page order summary "Edit cart" link is visible
        assertTrue(checkoutPage.isCheckoutPageOrderSummaryEditCartLinkVisible(), "The checkout page order summary 'Edit cart' link isn't visible.");
        //list elements
        //assert the checkout page order summary product images are visible (as a list)
        assertTrue(checkoutPage.isCheckoutPageOrderSummaryProductImgElementVisible(), "The checkout page order summary product images aren't visible.");
        //assert the checkout page order summary product names are visible (as a list)
        assertTrue(checkoutPage.isCheckoutPageOrderSummaryProductNameElementVisible(), "The checkout page order summary product names aren't visible.");
        //assert the checkout page order summary product quantities are visible (as a list)
        assertTrue(checkoutPage.isCheckoutPageOrderSummaryProductQtyElementVisible(), "The checkout page order summary product quantities aren't visible.");
        //assert the checkout page order summary product prices are visible (as a list)
        assertTrue(checkoutPage.isCheckoutPageOrderSummaryProductPriceElementVisible(), "The checkout page order summary product prices aren't visible.");
    }

    //checkout page (order success section) web element assert test method
    default void isCheckoutPageOrderSuccessSectionWebElementVisible(Page page) {
        CheckoutPage checkoutPage = new CheckoutPage(page);
        //assert the checkout page (order success section) tick image is visible
        assertTrue(checkoutPage.isCheckoutPageOrderSuccessTickImgVisible(), "The checkout page (order success section) tick image isn't visible.");
        //assert the checkout page order success message title is visible
        assertTrue(checkoutPage.isCheckoutPageOrderSuccessMsgTitleVisible(), "The checkout page order success message title isn't visible.");
        //assert the checkout page order success message subtitle is visible
        assertTrue(checkoutPage.isCheckoutPageOrderSuccessMsgSubtitleVisible(), "The checkout page order success message subtitle isn't visible.");
        //assert the checkout page order number subtext is visible
        assertTrue(checkoutPage.isCheckoutPageOrderNumberSubtextVisible(), "The checkout page order number subtext isn't visible.");
        //assert the checkout page order number is visible
        assertTrue(checkoutPage.isCheckoutPageOrderNumberVisible(), "The checkout page order number isn't visible.");
        //assert the checkout page order total subtext is visible
        assertTrue(checkoutPage.isCheckoutPageOrderTotalSubtextVisible(), "The checkout page order total subtext isn't visible.");
        //assert the checkout page order total price is visible
        assertTrue(checkoutPage.isCheckoutPageOrderTotalVisible(), "The checkout page order total price isn't visible.");
        //assert the checkout page order pay method subtext is visible
        assertTrue(checkoutPage.isCheckoutPageOrderPayMethodSubtextVisible(), "The checkout page order pay method subtext isn't visible.");
        //assert the checkout page order pay method is visible
        assertTrue(checkoutPage.isCheckoutPageOrderPayMethodVisible(), "The checkout page order pay method isn't visible.");
        //assert the checkout page confirm delivery text is visible
        assertTrue(checkoutPage.isCheckoutPageConfirmDeliveryTextVisible(), "The checkout page confirm delivery text isn't visible.");
        //assert the checkout page continue shopping button is visible
        assertTrue(checkoutPage.isCheckoutPageContinueShoppingBtnVisible(), "The checkout page continue shopping button isn't visible.");
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}


