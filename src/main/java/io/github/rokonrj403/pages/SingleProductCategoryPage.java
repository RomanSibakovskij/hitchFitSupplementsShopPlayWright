package io.github.rokonrj403.pages;

import io.github.rokonrj403.pages.utilities.BasePage;

import com.microsoft.playwright.*;

import java.util.*;
import java.util.stream.*;

public class SingleProductCategoryPage extends BasePage{

    //main
    //singular elements
    private final Locator singleProductCategoryPageTitle;
    private final Locator singleProductCategoryPageSubtext;
    //list elements
    private final Locator singleProductCategoryPageCategoryBtnElements;
    private final Locator singleProductCategoryPageProductCardImgElements;
    private final Locator singleProductCategoryPageProductCardRatingElements;
    private final Locator singleProductCategoryPageProductCardTitleElements;
    private final Locator singleProductCategoryPageProductCardPriceElements;
    private final Locator singleProductCategoryPageProductCardChooseOptionsBtnElements;

    public SingleProductCategoryPage(Page page) {
        super(page);

        //main
        //singular elements
        this.singleProductCategoryPageTitle = page.locator("//div[@class='section']/h2");
        this.singleProductCategoryPageSubtext = page.locator("//div[@class='section']/p[@class='sub']");
        //list elements
        this.singleProductCategoryPageCategoryBtnElements = page.locator("//div[@class='filters']/button");
        this.singleProductCategoryPageProductCardImgElements = page.locator("//div[@id='shopGrid']//img");
        this.singleProductCategoryPageProductCardRatingElements = page.locator("//div[@class='products']//div[@class='rating']");
        this.singleProductCategoryPageProductCardTitleElements = page.locator("//div[@class='products']//h3");
        this.singleProductCategoryPageProductCardPriceElements = page.locator("//div[@class='products']//p[@class='price']");
        this.singleProductCategoryPageProductCardChooseOptionsBtnElements = page.locator("//div[@class='products']//a[@class='btn-outline']");

    }

    //click set "Choose options" button method
    public void clickSetChooseButton(int index){singleProductCategoryPageProductCardChooseOptionsBtnElements.nth(index).click();}

    //single product category page data element getters
    //main
    //list elements
    public List<String> getSingleProductCategoryPageProductTitle(){
        int count = singleProductCategoryPageProductCardTitleElements.count();
        return IntStream.range(0, count)
                .mapToObj(i -> singleProductCategoryPageProductCardTitleElements.nth(i).innerText())
                .collect(Collectors.toList());
    }
    public List<String> getSingleProductCategoryPageProductRating(){
        int count = singleProductCategoryPageProductCardRatingElements.count();
        return IntStream.range(0, count)
                .mapToObj(i -> singleProductCategoryPageProductCardRatingElements.nth(i).innerText())
                .collect(Collectors.toList());
    }
    public List<String> getSingleProductCategoryPageProductUnitPrice(){
        int count = singleProductCategoryPageProductCardPriceElements.count();
        return IntStream.range(0, count)
                .mapToObj(i -> singleProductCategoryPageProductCardPriceElements.nth(i).innerText())
                .collect(Collectors.toList());
    }

    //single product category page text element getters
    //main
    public String getSingleProductCategoryPageTitle(){return singleProductCategoryPageTitle.innerText();}
    //shop section
    public String getSingleProductCategoryPageSubtext(){return singleProductCategoryPageSubtext.innerText();}
    //list elements
    public List<String> getSingleProductCategoryPageCategoryBtnText(){
        int count = singleProductCategoryPageCategoryBtnElements.count();
        return IntStream.range(0, count)
                .mapToObj(i -> singleProductCategoryPageCategoryBtnElements.nth(i).innerText())
                .collect(Collectors.toList());
    }
    public List<String> getSingleProductCategoryPageProductCardChooseOptionBtnText(){
        int count = singleProductCategoryPageProductCardChooseOptionsBtnElements.count();
        return IntStream.range(0, count)
                .mapToObj(i -> singleProductCategoryPageProductCardChooseOptionsBtnElements.nth(i).innerText())
                .collect(Collectors.toList());
    }

    //single product category page web element assert methods
    public boolean isSingleProductCategoryPageTitleVisible() {return this.singleProductCategoryPageTitle.isVisible();}
    public boolean isSingleProductCategoryPageSubtextVisible() {return this.singleProductCategoryPageSubtext.isVisible();}
    //list elements
    public boolean isSingleProductCategoryPageCategoryBtnElementsVisible() {
        int count = singleProductCategoryPageCategoryBtnElements.count();
        return IntStream.range(0, count)
                .allMatch(i -> singleProductCategoryPageCategoryBtnElements.nth(i).isVisible());
    }
    public boolean isSingleProductCategoryPageProductCardImgElementsVisible() {
        int count = singleProductCategoryPageProductCardImgElements.count();
        return IntStream.range(0, count)
                .allMatch(i -> singleProductCategoryPageProductCardImgElements.nth(i).isVisible());
    }
    public boolean isSingleProductCategoryPageProductCardRatingElementsVisible() {
        int count = singleProductCategoryPageProductCardRatingElements.count();
        return IntStream.range(0, count)
                .allMatch(i -> singleProductCategoryPageProductCardRatingElements.nth(i).isVisible());
    }
    public boolean isSingleProductCategoryPageProductCardTitleElementsVisible() {
        int count = singleProductCategoryPageProductCardTitleElements.count();
        return IntStream.range(0, count)
                .allMatch(i -> singleProductCategoryPageProductCardTitleElements.nth(i).isVisible());
    }
    public boolean isSingleProductCategoryPageProductCardPriceElementsVisible() {
        int count = singleProductCategoryPageProductCardPriceElements.count();
        return IntStream.range(0, count)
                .allMatch(i -> singleProductCategoryPageProductCardPriceElements.nth(i).isVisible());
    }
    public boolean isSingleProductCategoryPageProductCardChooseOptionBtnElementsVisible() {
        int count = singleProductCategoryPageProductCardChooseOptionsBtnElements.count();
        return IntStream.range(0, count)
                .allMatch(i -> singleProductCategoryPageProductCardChooseOptionsBtnElements.nth(i).isVisible());
    }

}
