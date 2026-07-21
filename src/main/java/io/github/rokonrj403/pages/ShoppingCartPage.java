package io.github.rokonrj403.pages;

import io.github.rokonrj403.pages.utilities.BasePage;

import com.microsoft.playwright.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ShoppingCartPage extends BasePage {

    //main
    //singular elements
    private final Locator shopCartPageTitle;
    private final Locator shopCartPageOrderSummarySectionTitle;
    private final Locator shopCartPageOrderSummarySubtotalSubtext;
    private final Locator shopCartPageOrderSummarySubtotalPrice;
    private final Locator shopCartPageOrderSummaryDeliverySubtext;
    private final Locator shopCartPageOrderSummaryDeliveryPrice;
    private final Locator shopCartPageOrderSummaryTotalSubtext;
    private final Locator shopCartPageOrderSummaryTotalPrice;
    private final Locator shopCartPageOrderSummaryFreeDeliverySubtext;
    private final Locator shopCartPageOrderSummaryCheckoutBtn;
    private final Locator shopCartPageOrderSummaryContinueShopLink;
    private final Locator shopCartPageEmptyShopCartMsg;
    //list elements
    private final Locator shopCartPageProductImgElements;
    private final Locator shopCartPageProductTitleLinkElements;
    private final Locator shopCartPageProductFlavorElements;
    private final Locator shopCartPageProductUnitPriceElements;
    private final Locator shopCartPageProductRemoveBtnElements;
    private final Locator shopCartPageProductQtyDecreaseBtnElements;
    private final Locator shopCartPageProductQtyInputFieldElements;
    private final Locator shopCartPageProductQtyIncreaseBtnElements;
    private final Locator shopCartPageProductPriceElements;

    public ShoppingCartPage(Page page) {
        super(page);

        //main
        //singular elements
        this.shopCartPageTitle = page.locator("//div[@class='cart-page']/h1");
        this.shopCartPageOrderSummarySectionTitle = page.locator("//div[@id='cartSummary']/h3");
        this.shopCartPageOrderSummarySubtotalSubtext = page.locator("//div[@class='summary-line'][1]/span[1]");
        this.shopCartPageOrderSummarySubtotalPrice = page.locator("//div[@class='summary-line'][1]/span[@id='subtotalValue']");
        this.shopCartPageOrderSummaryDeliverySubtext = page.locator("//div[@class='summary-line'][2]/span[1]");
        this.shopCartPageOrderSummaryDeliveryPrice = page.locator("//div[@class='summary-line'][2]/span[@id='deliveryValue']");
        this.shopCartPageOrderSummaryTotalSubtext = page.locator("//div[@class='summary-line summary-total']/span[1]");
        this.shopCartPageOrderSummaryTotalPrice = page.locator("//div[@class='summary-line summary-total']/span[@id='totalValue']");
        this.shopCartPageOrderSummaryFreeDeliverySubtext = page.locator("//p[@class='summary-note']");
        this.shopCartPageOrderSummaryCheckoutBtn = page.locator("//button[@class='add-cart-btn']");
        this.shopCartPageOrderSummaryContinueShopLink = page.locator("//a[@class='continue-link']");
        this.shopCartPageEmptyShopCartMsg = page.locator("//div[@id='cartEmpty']/p");
        //list elements
        this.shopCartPageProductImgElements = page.locator("//div[@class='cart-row']/a/img");
        this.shopCartPageProductTitleLinkElements = page.locator("//div[@class='cart-row-info']/a");
        this.shopCartPageProductFlavorElements = page.locator("//p[@class='cart-flavor']");
        this.shopCartPageProductUnitPriceElements = page.locator("//p[@class='cart-unit']");
        this.shopCartPageProductRemoveBtnElements = page.locator("//button[@class='cart-remove']");
        this.shopCartPageProductPriceElements = page.locator("//div[@class='cart-line-total']");
        this.shopCartPageProductQtyDecreaseBtnElements = page.locator("//div[@class='cart-qty']/button[1]");
        this.shopCartPageProductQtyInputFieldElements = page.locator("//div[@class='cart-qty']/input");
        this.shopCartPageProductQtyIncreaseBtnElements = page.locator("//div[@class='cart-qty']/button[2]");

    }

    //click set qty decrease button method
    public void clickSetQtyDecreaseBtn(int times, int index){;
        for (int i = 0; i < times; i++) {
            shopCartPageProductQtyDecreaseBtnElements.nth(index).click();
        }
    }
    //click set qty increase button method
    public void clickSetQtyIncreaseBtn(int times, int index){
        for (int i = 0; i < times; i++) {
            shopCartPageProductQtyIncreaseBtnElements.nth(index).click();
        }
    }
    //click set product remove button method
    public void clickSetProductRemoveBtn(int index){shopCartPageProductRemoveBtnElements.nth(index).click();}
    //click "Checkout" button method
    public void clickCheckoutButton(){shopCartPageOrderSummaryCheckoutBtn.click();}

    //shopping cart page data getters
    //singular elements
    public String getShoppingCartOrderSummarySubtotalPrice(){return this.shopCartPageOrderSummarySubtotalPrice.innerText();}
    public String getShoppingCartPageOrderSummaryDeliveryPrice(){return this.shopCartPageOrderSummaryDeliveryPrice.innerText();}
    public String getShoppingCartPageOrderSummaryTotalPrice(){return this.shopCartPageOrderSummaryTotalPrice.innerText();}
    //list elements
    public List<String> getShoppingCartPageProductTitle(){
        int count = shopCartPageProductTitleLinkElements.count();
        return IntStream.range(0, count)
                .mapToObj(i -> shopCartPageProductTitleLinkElements.nth(i).innerText())
                .collect(Collectors.toList());
    }
    public List<String> getShoppingCartPageProductFlavor(){
        int count = shopCartPageProductFlavorElements.count();
        return IntStream.range(0, count)
                .mapToObj(i -> shopCartPageProductFlavorElements.nth(i).innerText())
                .collect(Collectors.toList());
    }
    public List<String> getShoppingCartPageProductUnitPrice(){
        int count = shopCartPageProductUnitPriceElements.count();
        return IntStream.range(0, count)
                .mapToObj(i -> shopCartPageProductUnitPriceElements.nth(i).innerText())
                .collect(Collectors.toList());
    }
    public List<String> getShoppingCartPageProductQty(){
        int count = shopCartPageProductQtyInputFieldElements.count();
        return IntStream.range(0, count)
                .mapToObj(i -> shopCartPageProductQtyInputFieldElements.nth(i).inputValue())
                .collect(Collectors.toList());
    }
    public List<String> getShoppingCartPageProductPrice(){
        int count = shopCartPageProductPriceElements.count();
        return IntStream.range(0, count)
                .mapToObj(i -> shopCartPageProductPriceElements.nth(i).innerText())
                .collect(Collectors.toList());
    }
    //shopping cart page text element getters
    //singular elements
    public String getShoppingCartPageTitle(){return this.shopCartPageTitle.innerText();}
    public String getShoppingCartPageOrderSummarySecTitle(){return this.shopCartPageOrderSummarySectionTitle.innerText();}
    public String getShoppingCartPageOrderSummarySubtotalSubtext(){return this.shopCartPageOrderSummarySubtotalSubtext.innerText();}
    public String getShoppingCartPageOrderSummaryDeliverySubtext(){return this.shopCartPageOrderSummaryDeliverySubtext.innerText();}
    public String getShoppingCartPageOrderSummaryTotalSubtext(){return this.shopCartPageOrderSummaryTotalSubtext.innerText();}
    public String getShoppingCartPageOrderSummaryFreeDeliverySubtext(){return this.shopCartPageOrderSummaryFreeDeliverySubtext.innerText();}
    public String getShoppingCartPageCheckoutBtnText(){return this.shopCartPageOrderSummaryCheckoutBtn.innerText();}
    public String getShoppingCartPageContinueShoppingLinkText(){return this.shopCartPageOrderSummaryContinueShopLink.innerText();}
    public String getShoppingCartPageEmptyCartMsg(){return this.shopCartPageEmptyShopCartMsg.innerText();}
    //table
    //list elements
    public List<String> getShoppingCartPageProductRemoveBtnText(){
        int count = shopCartPageProductRemoveBtnElements.count();
        return IntStream.range(0, count)
                .mapToObj(i -> shopCartPageProductRemoveBtnElements.nth(i).innerText())
                .collect(Collectors.toList());
    }

    //shopping cart page web element assert methods
    //main
    //singular elements
    public boolean isShoppingCartPageTitleVisible() {return this.shopCartPageTitle.isVisible();}
    public boolean isShoppingCartPageOrderSummarySecTitleVisible() {return this.shopCartPageOrderSummarySectionTitle.isVisible();}
    public boolean isShoppingCartPageOrderSummarySubtotalSubtextVisible() {return this.shopCartPageOrderSummarySubtotalSubtext.isVisible();}
    public boolean isShoppingCartPageOrderSummarySubtotalPriceVisible() {return this.shopCartPageOrderSummarySubtotalPrice.isVisible();}
    public boolean isShoppingCartPageOrderSummaryDeliverySubtextVisible() {return this.shopCartPageOrderSummaryDeliverySubtext.isVisible();}
    public boolean isShoppingCartPageOrderSummaryDeliveryPriceVisible() {return this.shopCartPageOrderSummaryDeliveryPrice.isVisible();}
    public boolean isShoppingCartPageOrderSummaryTotalSubtextVisible() {return this.shopCartPageOrderSummaryTotalSubtext.isVisible();}
    public boolean isShoppingCartPageOrderSummaryTotalPriceVisible() {return this.shopCartPageOrderSummaryTotalPrice.isVisible();}
    public boolean isShoppingCartPageOrderSummaryFreeDeliveryTextVisible() {return this.shopCartPageOrderSummaryFreeDeliverySubtext.isVisible();}
    public boolean isShoppingCartPageCheckoutBtnVisible() {return this.shopCartPageOrderSummaryCheckoutBtn.isVisible();}
    public boolean isShoppingCartPageContinueShoppingLinkVisible() {return this.shopCartPageOrderSummaryContinueShopLink.isVisible();}
    //shopping cart table
    //list elements
    public boolean isShoppingCartPageProductImgElementVisible() {
        int count = shopCartPageProductImgElements.count();
        return IntStream.range(0, count)
                .allMatch(i -> shopCartPageProductImgElements.nth(i).isVisible());
    }
    public boolean isShoppingCartPageProductFlavorElementVisible() {
        int count = shopCartPageProductFlavorElements.count();
        return IntStream.range(0, count)
                .allMatch(i -> shopCartPageProductFlavorElements.nth(i).isVisible());
    }
    public boolean isShoppingCartPageProductUnitPriceElementVisible() {
        int count = shopCartPageProductUnitPriceElements.count();
        return IntStream.range(0, count)
                .allMatch(i -> shopCartPageProductUnitPriceElements.nth(i).isVisible());
    }
    public boolean isShoppingCartPageProductRemoveBtnElementVisible() {
        int count = shopCartPageProductRemoveBtnElements.count();
        return IntStream.range(0, count)
                .allMatch(i -> shopCartPageProductRemoveBtnElements.nth(i).isVisible());
    }
    public boolean isShoppingCartPageProductQtyDecreaseBtnElementVisible() {
        int count = shopCartPageProductQtyDecreaseBtnElements.count();
        return IntStream.range(0, count)
                .allMatch(i -> shopCartPageProductQtyDecreaseBtnElements.nth(i).isVisible());
    }
    public boolean isShoppingCartPageProductQtyInputFieldElementVisible() {
        int count = shopCartPageProductQtyInputFieldElements.count();
        return IntStream.range(0, count)
                .allMatch(i -> shopCartPageProductQtyInputFieldElements.nth(i).isVisible());
    }
    public boolean isShoppingCartPageProductQtyIncreaseBtnElementVisible() {
        int count = shopCartPageProductQtyIncreaseBtnElements.count();
        return IntStream.range(0, count)
                .allMatch(i -> shopCartPageProductQtyIncreaseBtnElements.nth(i).isVisible());
    }
    public boolean isShoppingCartPageProductPriceElementVisible() {
        int count = shopCartPageProductPriceElements.count();
        return IntStream.range(0, count)
                .allMatch(i -> shopCartPageProductPriceElements.nth(i).isVisible());
    }
}