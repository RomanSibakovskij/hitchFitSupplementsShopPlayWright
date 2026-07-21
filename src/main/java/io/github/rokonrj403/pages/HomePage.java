package io.github.rokonrj403.pages;

import io.github.rokonrj403.pages.utilities.BasePage;

import com.microsoft.playwright.*;

import java.util.List;
import java.util.stream.*;

public class HomePage extends BasePage {

    //main
    //singular elements
    private final Locator homePageUpperImg;
    private final Locator homePageUpperImgTitle;
    private final Locator homePageUpperImgSubtext;
    private final Locator homePageUpperImgShopNowBtn;
    //best selling supplements section
    private final Locator homePageBestSupplementsSectionTitle;
    private final Locator homePageBestSupplementsSectionSubtext;
    private final Locator homePageBestSupplementsSecProductCardViewAllProdBtn;
    //list elements
    private final Locator homePageBestSupplementsSecProductCardImgElements;
    private final Locator homePageBestSupplementsSecProductCardRatingElements;
    private final Locator homePageBestSupplementsSecProductCardTitleElements;
    private final Locator homePageBestSupplementsSecProductCardUnitPriceElements;
    private final Locator homePageBestSupplementsSecProductCardChooseOptionsElements;
    //hitch fit supplements section
    private final Locator homePageHitchFitSupplementsSecTitle;
    private final Locator homePageHitchFitSupplementsSecSubtext;
    private final Locator homePageHitchFitSupplementsSecShopAllProductsBtn;
    //keep me updated section
    private final Locator homePageKeepMeUpdatedSecTitle;
    private final Locator homePageKeepMeUpdatedSecSubtext;
    private final Locator homePageKeepMeUpdatedSecEnterEmailInputField;
    private final Locator homePageKeepMeUpdatedSecSubscribeBtn;

    public HomePage(Page page) {
        super(page);

        //main
        //singular elements
        this.homePageUpperImg = page.locator("//div[@class='banner']/img");
        this.homePageUpperImgTitle = page.locator("//div[@class='banner-text']/h1");
        this.homePageUpperImgSubtext = page.locator("//div[@class='banner-text']/p");
        this.homePageUpperImgShopNowBtn = page.locator("//div[@class='banner-text']/a");
        //best selling supplements section
        //singular elements
        this.homePageBestSupplementsSectionTitle = page.locator("//div[@class='section']/h2");
        this.homePageBestSupplementsSectionSubtext = page.locator("//div[@class='section']/p[@class='sub']");
        this.homePageBestSupplementsSecProductCardViewAllProdBtn = page.locator("//div[@class='section']//a[@class='btn']");
        //list elements
        this.homePageBestSupplementsSecProductCardImgElements = page.locator("//div[@id='featuredGrid']//img");
        this.homePageBestSupplementsSecProductCardRatingElements = page.locator("//div[@class='product']/div[@class='rating']");
        this.homePageBestSupplementsSecProductCardTitleElements = page.locator("//div[@class='product']/h3");
        this.homePageBestSupplementsSecProductCardUnitPriceElements = page.locator("//div[@class='product']/p[@class='price']");
        this.homePageBestSupplementsSecProductCardChooseOptionsElements = page.locator("//div[@class='product']/a[@class='btn-outline']");
        //hitch fit supplements section
        //singular elements
        this.homePageHitchFitSupplementsSecTitle = page.locator("//div[@id='about']/h2");
        this.homePageHitchFitSupplementsSecSubtext = page.locator("//div[@id='about']/p");
        this.homePageHitchFitSupplementsSecShopAllProductsBtn = page.locator("//div[@id='about']/a");
        //keep me updated section
        //singular elements
        this.homePageKeepMeUpdatedSecTitle = page.locator("//div[@class='newsletter']/h2");
        this.homePageKeepMeUpdatedSecSubtext = page.locator("//div[@class='newsletter']/p");
        this.homePageKeepMeUpdatedSecEnterEmailInputField = page.locator("//div[@class='newsletter']//input[@id='emailBox']");
        this.homePageKeepMeUpdatedSecSubscribeBtn = page.locator("//div[@class='newsletter']//button[@type='submit']");
    }

    //click set "Choose options" button method
    public void clickSetChooseButton(int index){homePageBestSupplementsSecProductCardChooseOptionsElements.nth(index).click();}

    //home page text element getters
    //main
    //singular elements
    public String getHomePageUpperImgTitle(){return this.homePageUpperImgTitle.innerText();}
    public String getHomePageUpperImgSubtext(){return this.homePageUpperImgSubtext.innerText();}
    public String getHomePageUpperImgShopNowBtnText(){return this.homePageUpperImgShopNowBtn.innerText();}
    //bestselling supplements section
    //singular items
    public String getHomePageBestSellingSupplementsSecTitle(){return this.homePageBestSupplementsSectionTitle.innerText();}
    public String getHomePageBestSellingSupplementsSecSubtext(){return this.homePageBestSupplementsSectionSubtext.innerText();}
    public String getHomePageBestSellingSupplementsSecViewAllProductsBtnText(){return this.homePageBestSupplementsSecProductCardViewAllProdBtn.innerText();}
    //hitch fit supplements
    //singular elements
    public String getHomePageHitchFitSecTitle(){return this.homePageHitchFitSupplementsSecTitle.innerText();}
    public String getHomePageHitchFitSecSubtext(){return this.homePageHitchFitSupplementsSecSubtext.innerText();}
    public String getHomePageHitchFitSecShopAllProductsBtnText(){return this.homePageHitchFitSupplementsSecShopAllProductsBtn.innerText();}
    //keep me updated section
    //singular elements
    public String getHomePageKeepMeUpdatedSecTitle(){return this.homePageKeepMeUpdatedSecTitle.innerText();}
    public String getHomePageKeepMeUpdatedSecSubtext(){return this.homePageKeepMeUpdatedSecSubtext.innerText();}
    public String getHomePageKeepMeUpdatedSecSubscribeBtnText(){return this.homePageKeepMeUpdatedSecSubscribeBtn.innerText();}
    //list elements
    public List<String> getHomePageBestSellingSupplementsSecChooseOptionsBtnText(){
        int count = homePageBestSupplementsSecProductCardChooseOptionsElements.count();
        return IntStream.range(0, count)
                .mapToObj(i -> homePageBestSupplementsSecProductCardChooseOptionsElements.nth(i).innerText())
                .collect(Collectors.toList());
    }

    //home page data element getters
    //list elements
    public List<String> getHomePageProductTitle(){
        int count = homePageBestSupplementsSecProductCardTitleElements.count();
        return IntStream.range(0, count)
                .mapToObj(i -> homePageBestSupplementsSecProductCardTitleElements.nth(i).innerText())
                .collect(Collectors.toList());
    }
    public List<String> getHomePageProductRating(){
        int count = homePageBestSupplementsSecProductCardRatingElements.count();
        return IntStream.range(0, count)
                .mapToObj(i -> homePageBestSupplementsSecProductCardRatingElements.nth(i).innerText())
                .collect(Collectors.toList());
    }
    public List<String> getHomePageProductUnitPrice(){
        int count = homePageBestSupplementsSecProductCardUnitPriceElements.count();
        return IntStream.range(0, count)
                .mapToObj(i -> homePageBestSupplementsSecProductCardUnitPriceElements.nth(i).innerText())
                .collect(Collectors.toList());
    }

    //home page web element assert methods
    //main
    //singular elements
    public boolean isHomePageUpperImgVisible() {return this.homePageUpperImg.isVisible();}
    public boolean isHomePageUpperImgTitleVisible() {return this.homePageUpperImgTitle.isVisible();}
    public boolean isHomePageUpperImgSubtextVisible() {return this.homePageUpperImgSubtext.isVisible();}
    public boolean isHomePageUpperImgShopNowBtnVisible() {return this.homePageUpperImgShopNowBtn.isVisible();}
    //best supplements
    //singular elements
    public boolean isHomePageBestSupplementsSectionTitleVisible() {return this.homePageBestSupplementsSectionTitle.isVisible();}
    public boolean isHomePageBestSupplementsSectionSubtextVisible() {return this.homePageBestSupplementsSectionSubtext.isVisible();}
    public boolean isHomePageBestSupplementsSecProductCardViewAllProductBtnVisible() {return this.homePageBestSupplementsSecProductCardViewAllProdBtn.isVisible();}
    //list elements
    public boolean isHomePageBestSupplementsSecProductCardImgElementVisible() {
        int count = homePageBestSupplementsSecProductCardImgElements.count();
        return IntStream.range(0, count)
                .allMatch(i -> homePageBestSupplementsSecProductCardImgElements.nth(i).isVisible());
    }
    public boolean isHomePageBestSupplementsSecProductCardRatingElementVisible() {
        int count = homePageBestSupplementsSecProductCardRatingElements.count();
        return IntStream.range(0, count)
                .allMatch(i -> homePageBestSupplementsSecProductCardRatingElements.nth(i).isVisible());
    }
    public boolean isHomePageBestSupplementsSecProductCardTitleElementVisible() {
        int count = homePageBestSupplementsSecProductCardTitleElements.count();
        return IntStream.range(0, count)
                .allMatch(i -> homePageBestSupplementsSecProductCardTitleElements.nth(i).isVisible());
    }
    public boolean isSHomePageBestSupplementsSecProductCardUnitPriceElementVisible() {
        int count = homePageBestSupplementsSecProductCardUnitPriceElements.count();
        return IntStream.range(0, count)
                .allMatch(i -> homePageBestSupplementsSecProductCardUnitPriceElements.nth(i).isVisible());
    }
    public boolean isHomePageBestSupplementsSecProductCardChooseOptionsElementVisible() {
        int count = homePageBestSupplementsSecProductCardChooseOptionsElements.count();
        return IntStream.range(0, count)
                .allMatch(i -> homePageBestSupplementsSecProductCardChooseOptionsElements.nth(i).isVisible());
    }
    //hitch fit supplements section
    //singular elements
    public boolean isHomePageHitchFitSupplementsTitleVisible() {return this.homePageHitchFitSupplementsSecTitle.isVisible();}
    public boolean isHomePageHitchFitSupplementsSubtextVisible() {return this.homePageHitchFitSupplementsSecSubtext.isVisible();}
    public boolean isHomePageHitchFitSupplementsSecShopAllProductsBtnVisible() {return this.homePageHitchFitSupplementsSecShopAllProductsBtn.isVisible();}
    //keep me updated section
    //singular elements
    public boolean isHomePageKeepMeUpdatedSecTitleVisible() {return this.homePageKeepMeUpdatedSecTitle.isVisible();}
    public boolean isHomePageKeepMeUpdatedSecSubtextVisible() {return this.homePageKeepMeUpdatedSecSubtext.isVisible();}
    public boolean isHomePageKeepMeUpdatedSecEnterEmailInputFieldVisible() {return this.homePageKeepMeUpdatedSecEnterEmailInputField.isVisible();}
    public boolean isHomePageHitchFitSupplementsSecSubscribeBtnVisible() {return this.homePageKeepMeUpdatedSecSubscribeBtn.isVisible();}

}