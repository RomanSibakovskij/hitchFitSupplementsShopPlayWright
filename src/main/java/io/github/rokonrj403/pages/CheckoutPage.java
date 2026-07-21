package io.github.rokonrj403.pages;

import io.github.rokonrj403.pages.utilities.BasePage;

import com.microsoft.playwright.*;
import io.github.rokonrj403.pages.utilities.TestDataGenerator;

import java.util.*;
import java.util.stream.*;

public class CheckoutPage extends BasePage {

    //main
    //singular elements
    private final Locator checkoutPageTitle;
    //delivery section
    private final Locator checkoutPageDeliverySecTitle;
    private final Locator checkoutPageDeliverySecFullNameSubtext;
    private final Locator checkoutPageDeliverySecFullNameInputField;
    private final Locator checkoutPageDeliverySecPhoneSubtext;
    private final Locator checkoutPageDeliverySecPhoneInputField;
    private final Locator checkoutPageDeliverySecEmailSubtext;
    private final Locator checkoutPageDeliverySecEmailInputField;
    private final Locator checkoutPageDeliverySecAddressSubtext;
    private final Locator checkoutPageDeliverySecAddressTextarea;
    private final Locator checkoutPageDeliverySecCitySubtext;
    private final Locator checkoutPageDeliverySecCityInputField;
    //payment method section
    //singular elements
    private final Locator checkoutPagePayMethodSecTitle;
    private final Locator checkoutPagePayMethodOrderNotesSubtext;
    private final Locator checkoutPagePayMethodOrderNotesTextArea;
    private final Locator checkoutPagePlaceOrderBtn;
    //list elements
    private final Locator checkoutPagePayMethodRadioBtnElements;
    private final Locator checkoutPagePayMethodSubtextElements;
    //order summary section
    //singular elements
    private final Locator checkoutPageOrderSummarySecTitle;
    private final Locator checkoutPageOrderSummarySubtotalSubtext;
    private final Locator checkoutPageOrderSummarySubtotalPrice;
    private final Locator checkoutPageOrderSummaryDeliverySubtext;
    private final Locator checkoutPageOrderSummaryDeliveryPrice;
    private final Locator checkoutPageOrderSummaryTotalSubtext;
    private final Locator checkoutPageOrderSummaryTotalPrice;
    private final Locator checkoutPageOrderSummaryEditLink;
    //list elements
    private final Locator checkoutPageOrderSummaryProductImgElements;
    private final Locator checkoutPageOrderSummaryProductNameElements;
    private final Locator checkoutPageOrderSummaryProductQtyElements;
    private final Locator checkoutPageOrderSummaryProductPriceElements;
    //fill in order success section (it's still checkout.html page)
    private final Locator checkoutPageOrderSuccessTickImg;
    private final Locator checkoutPageOrderSuccessMsgTitle;
    private final Locator checkoutPageOrderSuccessMsgSubtitle;
    private final Locator checkoutPageOrderNumberSubtext;
    private final Locator checkoutPageOrderNumber;
    private final Locator checkoutPageOrderTotalSubtext;
    private final Locator checkoutPageOrderTotal;
    private final Locator checkoutPageOrderPayMethodSubtext;
    private final Locator checkoutPageOrderPayMethod;
    private final Locator checkoutPageConfirmDeliveryText;
    private final Locator checkoutPageContinueShoppingBtn;

    //valid input data
    private String fullName;
    private String phone;
    private String email;
    private String address;
    private String city;

    public CheckoutPage(Page page) {
        super(page);

        //main
        //singular elements
        this.checkoutPageTitle = page.locator("//div[@id='checkoutMain']/h1");
        //delivery section
        this.checkoutPageDeliverySecTitle = page.locator("//form[@class='checkout-form']/h3[1]");
        this.checkoutPageDeliverySecFullNameSubtext = page.locator("//form[@class='checkout-form']/label[1]");
        this.checkoutPageDeliverySecFullNameInputField = page.locator("//input[@id='coName']");
        this.checkoutPageDeliverySecPhoneSubtext = page.locator("//form[@class='checkout-form']/label[2]");
        this.checkoutPageDeliverySecPhoneInputField = page.locator("//input[@id='coPhone']");
        this.checkoutPageDeliverySecEmailSubtext = page.locator("//form[@class='checkout-form']/label[3]");
        this.checkoutPageDeliverySecEmailInputField = page.locator("//input[@id='coEmail']");
        this.checkoutPageDeliverySecAddressSubtext = page.locator("//form[@class='checkout-form']/label[4]");
        this.checkoutPageDeliverySecAddressTextarea = page.locator("//textarea[@id='coAddress']");
        this.checkoutPageDeliverySecCitySubtext = page.locator("//form[@class='checkout-form']/label[5]");
        this.checkoutPageDeliverySecCityInputField = page.locator("//input[@id='coCity']");
        //payment method section
        //singular elements
        this.checkoutPagePayMethodSecTitle = page.locator("//form[@class='checkout-form']/h3[2]");
        this.checkoutPagePayMethodOrderNotesSubtext = page.locator("//label[@for='coNotes']");
        this.checkoutPagePayMethodOrderNotesTextArea = page.locator("//textarea[@id='coNotes']");
        this.checkoutPagePlaceOrderBtn = page.locator("//button[@class='add-cart-btn']");
        //list elements
        this.checkoutPagePayMethodRadioBtnElements = page.locator("//form[@class='checkout-form']/label[@class='pay-option']/input");
        this.checkoutPagePayMethodSubtextElements = page.locator("//form[@class='checkout-form']/label[@class='pay-option']");
        //order summary section
        //singular elements
        this.checkoutPageOrderSummarySecTitle = page.locator("//div[@class='cart-summary']/h3");
        this.checkoutPageOrderSummarySubtotalSubtext = page.locator("//div[@id='checkoutSummary']/div[@class='summary-line'][1]/span[1]");
        this.checkoutPageOrderSummarySubtotalPrice = page.locator("//div[@id='checkoutSummary']/div[@class='summary-line'][1]/span[2]");
        this.checkoutPageOrderSummaryDeliverySubtext = page.locator("//div[@id='checkoutSummary']/div[@class='summary-line'][2]/span[1]");
        this.checkoutPageOrderSummaryDeliveryPrice = page.locator("//div[@id='checkoutSummary']/div[@class='summary-line'][2]/span[2]");
        this.checkoutPageOrderSummaryTotalSubtext = page.locator("//div[@id='checkoutSummary']/div[@class='summary-line summary-total']/span[1]");
        this.checkoutPageOrderSummaryTotalPrice = page.locator("//div[@id='checkoutSummary']/div[@class='summary-line summary-total']/span[2]");
        this.checkoutPageOrderSummaryEditLink = page.locator("//a[@class='continue-link']");
        //list elements
        this.checkoutPageOrderSummaryProductImgElements = page.locator("//div[@class='co-line']/img");
        this.checkoutPageOrderSummaryProductNameElements = page.locator("//div[@class='co-line-info']/span[@class='co-line-name']");
        this.checkoutPageOrderSummaryProductQtyElements = page.locator("//div[@class='co-line-info']/span[@class='co-line-meta']");
        this.checkoutPageOrderSummaryProductPriceElements = page.locator("//span[@class='co-line-total']");
        //order success section
        this.checkoutPageOrderSuccessTickImg = page.locator("//div[@id='orderConfirm']/div[@class='confirm-check']");
        this.checkoutPageOrderSuccessMsgTitle = page.locator("//div[@id='orderConfirm']/h1");
        this.checkoutPageOrderSuccessMsgSubtitle = page.locator("//div[@id='orderConfirm']/p[@class='confirm-sub']");
        this.checkoutPageOrderNumberSubtext = page.locator("//div[@class='confirm-box']/div[@class='summary-line'][1]/span[1]");
        this.checkoutPageOrderNumber = page.locator("//div[@class='confirm-box']/div[@class='summary-line'][1]/span[2]");
        this.checkoutPageOrderTotalSubtext = page.locator("//div[@class='confirm-box']/div[@class='summary-line'][2]/span[1]");
        this.checkoutPageOrderTotal = page.locator("//div[@class='confirm-box']/div[@class='summary-line'][2]/span[2]");
        this.checkoutPageOrderPayMethodSubtext = page.locator("//div[@class='confirm-box']/div[@class='summary-line'][3]/span[1]");
        this.checkoutPageOrderPayMethod = page.locator("//div[@class='confirm-box']/div[@class='summary-line'][3]/span[2]");
        this.checkoutPageConfirmDeliveryText = page.locator("//p[@class='confirm-note']");
        this.checkoutPageContinueShoppingBtn = page.locator("//a[@class='btn']");

    }

    //valid checkout delivery input data getter
    public void validCheckoutDeliveryInputDataGetter(){

        fullName = TestDataGenerator.getRandomFirstName() + " " + TestDataGenerator.getRandomLastName();
        phone = TestDataGenerator.generatePhoneNumber(6);
        email = TestDataGenerator.generateRandomEmailAddress(10);
        address = TestDataGenerator.generateRandomAddress(5);
        city = TestDataGenerator.getRandomCity();

        System.out.println("Valid generated checkout delivery input data: " + "\n");

        logger.info("Valid generated checkout delivery full name : " + fullName);
        logger.info("Valid generated checkout delivery phone : " + phone);
        logger.info("Valid generated checkout delivery email : " + email);
        logger.info("Valid generated checkout delivery address : " + address);
        logger.info("Valid generated checkout delivery city : " + city);

        System.out.println("\n");

    }

    //valid input data methods
    public void inputFullNameIntoFullNameInputField(){checkoutPageDeliverySecFullNameInputField.fill(fullName);}
    public void inputPhoneIntoPhoneInputField(){checkoutPageDeliverySecPhoneInputField.fill(phone);}
    public void inputEmailIntoEmailInputField(){checkoutPageDeliverySecEmailInputField.fill(email);}
    public void inputAddressIntoAddressTextarea(){checkoutPageDeliverySecAddressTextarea.fill(address);}
    public void inputCityIntoCityInputField(){checkoutPageDeliverySecCityInputField.fill(city);}


    //click set payment method radio button method
    public void clickSetPayMethodRadioButton(int index){checkoutPagePayMethodRadioBtnElements.nth(index).click();}

    //click "Edit cart" link method
    public void clickEditCartLink(){checkoutPageOrderSummaryEditLink.click();}
    //click "Place order" button method
    public void clickPlaceOrderBtn(){checkoutPagePlaceOrderBtn.click();}

    //checkout page data getters
    //singular elements
    public String getCheckoutPageOrderSummarySubtotalPrice(){return this.checkoutPageOrderSummarySubtotalPrice.innerText();}
    public String getCheckoutPageOrderSummaryDeliveryPrice(){return this.checkoutPageOrderSummaryDeliveryPrice.innerText();}
    public String getCheckoutPageOrderSummaryTotalPrice(){return this.checkoutPageOrderSummaryTotalPrice.innerText();}
    //list elements
    public List<String> getCheckoutPageOrderSummaryProductName(){
        int count = checkoutPageOrderSummaryProductNameElements.count();
        return IntStream.range(0, count)
                .mapToObj(i -> checkoutPageOrderSummaryProductNameElements.nth(i).innerText())
                .collect(Collectors.toList());
    }
    public List<String> getCheckoutPageOrderSummaryProductQty(){
        int count = checkoutPageOrderSummaryProductQtyElements.count();
        return IntStream.range(0, count)
                .mapToObj(i -> checkoutPageOrderSummaryProductQtyElements.nth(i).innerText())
                .collect(Collectors.toList());
    }
    public List<String> getCheckoutPageOrderSummaryProductPrice(){
        int count = checkoutPageOrderSummaryProductPriceElements.count();
        return IntStream.range(0, count)
                .mapToObj(i -> checkoutPageOrderSummaryProductPriceElements.nth(i).innerText())
                .collect(Collectors.toList());
    }
    //order success section
    //singular elements
    public String getCheckoutPageOrderNumber(){return this.checkoutPageOrderNumber.innerText();}
    public String getCheckoutPageOrderTotal(){return this.checkoutPageOrderTotal.innerText();}
    public String getCheckoutPageOrderPayMethod(){return this.checkoutPageOrderPayMethod.innerText();}

    //checkout page text element getters
    //singular elements
    public String getCheckoutPageTitle(){return this.checkoutPageTitle.innerText();}
    public String getCheckoutPagePlaceOrderBtnText(){return this.checkoutPagePlaceOrderBtn.innerText();}
    //delivery section
    //singular elements
    public String getCheckoutPageDeliverySecTitle(){return this.checkoutPageDeliverySecTitle.innerText();}
    public String getCheckoutPageDeliverySecFullNameSubtext(){return this.checkoutPageDeliverySecFullNameSubtext.innerText();}
    public String getCheckoutPageDeliverySecPhoneSubtext(){return this.checkoutPageDeliverySecPhoneSubtext.innerText();}
    public String getCheckoutPageDeliverySecEmailSubtext(){return this.checkoutPageDeliverySecEmailSubtext.innerText();}
    public String getCheckoutPageDeliverySecAddressSubtext(){return this.checkoutPageDeliverySecAddressSubtext.innerText();}
    public String getCheckoutPageDeliverySecCitySubtext(){return this.checkoutPageDeliverySecCitySubtext.innerText();}
    //payment method section
    //singular elements
    public String getCheckoutPagePayMethodSecTitle(){return this.checkoutPagePayMethodSecTitle.innerText();}
    public String getCheckoutPagePayMethodSecOrderNotesSubtext(){return this.checkoutPagePayMethodOrderNotesSubtext.innerText();}
    //list elements
    public List<String> getCheckoutPagePayMethodRadioBtnText(){
        return checkoutPagePayMethodSubtextElements.allInnerTexts().stream().map(String::trim).toList(); //used to trim out spaces in front of the string too
    }
    //order summary section
    //singular elements
    public String getCheckoutPageOrderSummarySecTitle(){return this.checkoutPageOrderSummarySecTitle.innerText();}
    public String getCheckoutPageOrderSummarySecSubtotalSubtext(){return this.checkoutPageOrderSummarySubtotalSubtext.innerText();}
    public String getCheckoutPageOrderSummarySecDeliverySubtext(){return this.checkoutPageOrderSummaryDeliverySubtext.innerText();}
    public String getCheckoutPageOrderSummarySecTotalSubtext(){return this.checkoutPageOrderSummaryTotalSubtext.innerText();}
    public String getCheckoutPageOrderSummarySecEditLinkText(){return this.checkoutPageOrderSummaryEditLink.innerText();}
    //order success section
    //singular elements
    public String getCheckoutPageOrderSuccessMsgTitle(){return this.checkoutPageOrderSuccessMsgTitle.innerText();}
    public String getCheckoutPageOrderSuccessMsgSubtitle(){return this.checkoutPageOrderSuccessMsgSubtitle.innerText();}
    public String getCheckoutPageOrderNumberSubtext(){return this.checkoutPageOrderNumberSubtext.innerText();}
    public String getCheckoutPageOrderTotalSubtext(){return this.checkoutPageOrderTotalSubtext.innerText();}
    public String getCheckoutPageOrderPayMethodSubtext(){return this.checkoutPageOrderPayMethodSubtext.innerText();}
    public String getCheckoutPageConfirmDeliveryText(){return this.checkoutPageConfirmDeliveryText.innerText();}
    public String getCheckoutPageContinueShoppingBtnText(){return this.checkoutPageContinueShoppingBtn.innerText();}

    //checkout page web element assert methods
    public boolean isCheckoutPageTitleVisible() {return this.checkoutPageTitle.isVisible();}
    public boolean isCheckoutPagePlaceOrderBtnVisible() {return this.checkoutPagePlaceOrderBtn.isVisible();}
    //delivery details section
    //singular elements
    public boolean isCheckoutPageDeliveryDetailsSectionTitleVisible() {return this.checkoutPageDeliverySecTitle.isVisible();}
    public boolean isCheckoutPageDeliveryDetailsSecFullNameSubtextVisible() {return this.checkoutPageDeliverySecFullNameSubtext.isVisible();}
    public boolean isCheckoutPageDeliveryDetailsSecFullNameInputFieldVisible() {return this.checkoutPageDeliverySecFullNameInputField.isVisible();}
    public boolean isCheckoutPageDeliveryDetailsSecPhoneSubtextVisible() {return this.checkoutPageDeliverySecPhoneSubtext.isVisible();}
    public boolean isCheckoutPageDeliveryDetailsSecPhoneInputFieldVisible() {return this.checkoutPageDeliverySecPhoneInputField.isVisible();}
    public boolean isCheckoutPageDeliveryDetailsSecEmailSubtextVisible() {return this.checkoutPageDeliverySecEmailSubtext.isVisible();}
    public boolean isCheckoutPageDeliveryDetailsSecEmailInputFieldVisible() {return this.checkoutPageDeliverySecEmailInputField.isVisible();}
    public boolean isCheckoutPageDeliveryDetailsSecAddressSubtextVisible() {return this.checkoutPageDeliverySecAddressSubtext.isVisible();}
    public boolean isCheckoutPageDeliveryDetailsSecAddressTextareaVisible() {return this.checkoutPageDeliverySecAddressTextarea.isVisible();}
    public boolean isCheckoutPageDeliveryDetailsSecCitySubtextVisible() {return this.checkoutPageDeliverySecCitySubtext.isVisible();}
    public boolean isCheckoutPageDeliveryDetailsSecCityInputFieldVisible() {return this.checkoutPageDeliverySecCityInputField.isVisible();}
    //payment method section
    //singular elements
    public boolean isCheckoutPagePayMethodSecTitleVisible() {return this.checkoutPagePayMethodSecTitle.isVisible();}
    public boolean isCheckoutPagePayMethodSecOrderNotesSubtextVisible() {return this.checkoutPagePayMethodOrderNotesSubtext.isVisible();}
    public boolean isCheckoutPagePayMethodSecOrderNotesTextareaVisible() {return this.checkoutPagePayMethodOrderNotesTextArea.isVisible();}
    //list elements
    public boolean isCheckoutPagePayMethodSecRadioBtnSubtextElementVisible() {
        int count = checkoutPagePayMethodSubtextElements.count();
        return IntStream.range(0, count)
                .allMatch(i -> checkoutPagePayMethodSubtextElements.nth(i).isVisible());
    }
    public boolean isCheckoutPagePayMethodSecRadioBtnElementVisible() {
        int count = checkoutPagePayMethodRadioBtnElements.count();
        return IntStream.range(0, count)
                .allMatch(i -> checkoutPagePayMethodRadioBtnElements.nth(i).isVisible());
    }
    //order summary section
    //singular elements
    public boolean isCheckoutPageOrderSummarySectionTitleVisible() {return this.checkoutPageOrderSummarySecTitle.isVisible();}
    public boolean isCheckoutPageOrderSummarySecSubtotalSubtextVisible() {return this.checkoutPageOrderSummarySubtotalSubtext.isVisible();}
    public boolean isCheckoutPageOrderSummarySecSubtotalPriceVisible() {return this.checkoutPageOrderSummarySubtotalPrice.isVisible();}
    public boolean isCheckoutPageOrderSummarySecDeliverySubtextVisible() {return this.checkoutPageOrderSummaryDeliverySubtext.isVisible();}
    public boolean isCheckoutPageOrderSummarySecDeliveryPriceVisible() {return this.checkoutPageOrderSummaryDeliveryPrice.isVisible();}
    public boolean isCheckoutPageOrderSummarySecTotalSubtextVisible() {return this.checkoutPageOrderSummaryTotalSubtext.isVisible();}
    public boolean isCheckoutPageOrderSummarySecTotalPriceVisible() {return this.checkoutPageOrderSummaryTotalPrice.isVisible();}
    public boolean isCheckoutPageOrderSummaryEditCartLinkVisible() {return this.checkoutPageOrderSummaryEditLink.isVisible();}
    //list elements
    public boolean isCheckoutPageOrderSummaryProductImgElementVisible() {
        int count = checkoutPageOrderSummaryProductImgElements.count();
        return IntStream.range(0, count)
                .allMatch(i -> checkoutPageOrderSummaryProductImgElements.nth(i).isVisible());
    }
    public boolean isCheckoutPageOrderSummaryProductNameElementVisible() {
        int count = checkoutPageOrderSummaryProductNameElements.count();
        return IntStream.range(0, count)
                .allMatch(i -> checkoutPageOrderSummaryProductNameElements.nth(i).isVisible());
    }
    public boolean isCheckoutPageOrderSummaryProductQtyElementVisible() {
        int count = checkoutPageOrderSummaryProductQtyElements.count();
        return IntStream.range(0, count)
                .allMatch(i -> checkoutPageOrderSummaryProductQtyElements.nth(i).isVisible());
    }
    public boolean isCheckoutPageOrderSummaryProductPriceElementVisible() {
        int count = checkoutPageOrderSummaryProductPriceElements.count();
        return IntStream.range(0, count)
                .allMatch(i -> checkoutPageOrderSummaryProductPriceElements.nth(i).isVisible());
    }
    //order success section
    //singular elements
    public boolean isCheckoutPageOrderSuccessTickImgVisible() {return this.checkoutPageOrderSuccessTickImg.isVisible();}
    public boolean isCheckoutPageOrderSuccessMsgTitleVisible() {return this.checkoutPageOrderSuccessMsgTitle.isVisible();}
    public boolean isCheckoutPageOrderSuccessMsgSubtitleVisible() {return this.checkoutPageOrderSuccessMsgSubtitle.isVisible();}
    public boolean isCheckoutPageOrderNumberSubtextVisible() {return this.checkoutPageOrderNumberSubtext.isVisible();}
    public boolean isCheckoutPageOrderNumberVisible() {return this.checkoutPageOrderNumber.isVisible();}
    public boolean isCheckoutPageOrderTotalSubtextVisible() {return this.checkoutPageOrderTotalSubtext.isVisible();}
    public boolean isCheckoutPageOrderTotalVisible() {return this.checkoutPageOrderTotal.isVisible();}
    public boolean isCheckoutPageOrderPayMethodSubtextVisible() {return this.checkoutPageOrderPayMethodSubtext.isVisible();}
    public boolean isCheckoutPageOrderPayMethodVisible() {return this.checkoutPageOrderPayMethod.isVisible();}
    public boolean isCheckoutPageConfirmDeliveryTextVisible() {return this.checkoutPageConfirmDeliveryText.isVisible();}
    public boolean isCheckoutPageContinueShoppingBtnVisible() {return this.checkoutPageContinueShoppingBtn.isVisible();}
}
