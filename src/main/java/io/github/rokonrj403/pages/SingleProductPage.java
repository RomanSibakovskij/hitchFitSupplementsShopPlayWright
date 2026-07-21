package io.github.rokonrj403.pages;

import io.github.rokonrj403.pages.utilities.BasePage;

import com.microsoft.playwright.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SingleProductPage extends BasePage {

    //main
    private final Locator singleProductPageMainImg;
    private final Locator singleProductPageTitle;
    private final Locator singleProductPageProdRating;
    private final Locator singleProductPageUnitPrice;
    private final Locator singleProductPageProdDescription;
    private final Locator singleProductPageFlavorSubtext;
    private final Locator singleProductPageQtySubtext;
    private final Locator singleProductPageQtyDecreaseBtn;
    private final Locator singleProductPageQtyInputField;
    private final Locator singleProductPageQtyIncreaseBtn;
    private final Locator singleProductPageAddToCartBtn;
    //list elements
    private final Locator singleProductPageFlavorBtnElements;
    private final Locator singleProductPageProdFeaturesElements;

    public SingleProductPage(Page page) {
        super(page);

        //main
        //singular elements
        this.singleProductPageMainImg = page.locator("//div[@class='product-image']/img");
        this.singleProductPageTitle = page.locator("//div[@class='product-info']/h1");
        this.singleProductPageProdRating = page.locator("//div[@class='product-info']/div[@class='rating-line']");
        this.singleProductPageUnitPrice = page.locator("//div[@class='product-info']/p[@class='price-big']");
        this.singleProductPageProdDescription = page.locator("//div[@class='product-info']/p[@class='desc']");
        this.singleProductPageFlavorSubtext = page.locator("//div[@class='product-info']/div[@class='option-block'][1]/p");
        this.singleProductPageQtySubtext = page.locator("//div[@class='product-info']/div[@class='option-block'][2]/p");
        this.singleProductPageQtyDecreaseBtn = page.locator("//div[@class='product-info']/div[@class='option-block'][2]/button[1]");
        this.singleProductPageQtyInputField = page.locator("//div[@class='product-info']/div[@class='option-block'][2]/input");
        this.singleProductPageQtyIncreaseBtn = page.locator("//div[@class='product-info']/div[@class='option-block'][2]/button[2]");
        this.singleProductPageAddToCartBtn = page.locator("//button[@class='add-cart-btn']");
        //list elements
        this.singleProductPageFlavorBtnElements = page.locator("//div[@class='product-info']/div[@class='option-block'][1]/button");
        this.singleProductPageProdFeaturesElements = page.locator("//div[@class='features']");
    }

    //click quantity decrease button method
    public void clickQtyDecreaseButton(int times){
        if (times < 0) {throw new IllegalArgumentException("Times must be 0 or greater.");} //validate that times can't be below 0
        for (int i = 0; i < times; i++) {
            singleProductPageQtyDecreaseBtn.click();
        }
    }
    //click quantity increase button method
    public void clickQtyIncreaseButton(int times){
        if (times < 0) {throw new IllegalArgumentException("Times must be 0 or greater.");} //validate that times can't be below 0
        for (int i = 0; i < times; i++) {
            singleProductPageQtyIncreaseBtn.click();
        }
    }

    //click "Add to cart" button method
    public void clickAddToCartButton(){singleProductPageAddToCartBtn.click(new Locator.ClickOptions().setForce(true));}

    //click set product flavor button method
    public void clickSetProductFlavorButton(int index){singleProductPageFlavorBtnElements.nth(index).click();}

    //single product page data getters
    //main
    //singular elements
    public String getSingleProductPageTitle(){return this.singleProductPageTitle.innerText();}
    public String getSingleProductPageProductRating(){return this.singleProductPageProdRating.innerText();}
    public String getSingleProductPageUnitPrice(){return this.singleProductPageUnitPrice.innerText();}
    public String getSingleProductPageProductQty(){return this.singleProductPageQtyInputField.inputValue();}
    public String getSingleProductPageProductDesc(){return this.singleProductPageProdDescription.innerText();}
    //list elements
    public List<String> getSingleProductPageProductFlavorBtnText(){
        int count = singleProductPageFlavorBtnElements.count();
        return IntStream.range(0, count)
                .mapToObj(i -> singleProductPageFlavorBtnElements.nth(i).innerText())
                .collect(Collectors.toList());
    }
    public List<String> getSingleProductPageProductFeaturesText(){
        int count = singleProductPageProdFeaturesElements.count();
        return IntStream.range(0, count)
                .mapToObj(i -> singleProductPageProdFeaturesElements.nth(i).innerText())
                .collect(Collectors.toList());
    }
    //single product page text element getters
    public String getSingleProductPageFlavorSubtext(){return this.singleProductPageFlavorSubtext.innerText();}
    public String getSingleProductPageQtySubtext(){return this.singleProductPageQtySubtext.innerText();}
    public String getSingleProductPageAddToCartBtnText(){return this.singleProductPageAddToCartBtn.innerText();}

    //single product page web element assert methods
    //main
    //singular elements
    public boolean isSingleProductPageMainImgVisible() {return this.singleProductPageMainImg.isVisible();}
    public boolean isSingleProductPageTitleVisible() {return this.singleProductPageTitle.isVisible();}
    public boolean isSingleProductPageProductRatingVisible() {return this.singleProductPageProdRating.isVisible();}
    public boolean isSingleProductPageUnitPriceVisible() {return this.singleProductPageUnitPrice.isVisible();}
    public boolean isSingleProductPageDescVisible() {return this.singleProductPageProdDescription.isVisible();}
    public boolean isSingleProductPageFlavorSubtextVisible() {return this.singleProductPageFlavorSubtext.isVisible();}
    public boolean isSingleProductPageQuantitySubtextVisible() {return this.singleProductPageQtySubtext.isVisible();}
    public boolean isSingleProductPageQtyDecreaseBtnVisible() {return this.singleProductPageQtyDecreaseBtn.isVisible();}
    public boolean isSingleProductPageQtyIncreaseBtnVisible() {return this.singleProductPageQtyIncreaseBtn.isVisible();}
    public boolean isSingleProductPageQtyInputFieldVisible() {return this.singleProductPageQtyInputField.isVisible();}
    public boolean isSingleProductPageAddToCartBtnVisible() {return this.singleProductPageAddToCartBtn.isVisible();}
    //list elements
    public boolean isSingleProductPageFeaturesBtnElementVisible() {
        int count = singleProductPageFlavorBtnElements.count();
        return IntStream.range(0, count)
                .allMatch(i -> singleProductPageFlavorBtnElements.nth(i).isVisible());
    }
    public boolean isSingleProductPageProductFeaturesElementVisible() {
        int count = singleProductPageProdFeaturesElements.count();
        return IntStream.range(0, count)
                .allMatch(i -> singleProductPageProdFeaturesElements.nth(i).isVisible());
    }
}
