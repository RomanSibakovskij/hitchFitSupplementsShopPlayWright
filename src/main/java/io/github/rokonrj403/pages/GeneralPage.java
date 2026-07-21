package io.github.rokonrj403.pages;

import io.github.rokonrj403.pages.utilities.BasePage;

import com.microsoft.playwright.*;

import java.util.*;
import java.util.stream.*;

public class GeneralPage extends BasePage {

    //general page web elements (elements all pages have)
    //header
    //singular elements
    private final Locator headerShoppingCartButton;
    private final Locator headerTrustedText;
    private final Locator headerHomePageIconLink;
    //list elements
    private final Locator headerNavbarLinkElements;
    //main
    //singular elements
    private final Locator mainBreadcrumbElements;
    //footer
    private final Locator footerHitchFitIcon;
    private final Locator footerHitchFitSubtext;
    //shop section
    private final Locator footerShopSectionTitle;
    //list elements
    private final Locator footerShopSectionLinkElements;
    //company section
    private final Locator footerCompanySectionTitle;
    //list elements
    private final Locator footerCompanyLinkElements;
    //support section
    private final Locator footerSupportSectionTitle;
    //list elements
    private final Locator footerSupportLinkElements;
    //copyright section
    private final Locator footerCopyrightText;

    public GeneralPage(Page page) {
        super(page);

        //header
        //singular elements
        headerShoppingCartButton = page.locator("//div[@class='cart']/a");
        headerTrustedText = page.locator("//div[@class='topbar']");
        headerHomePageIconLink = page.locator("//div[@class='logo']/a");
        //list elements
        headerNavbarLinkElements = page.locator("//div[@class='menu']/a");
        //main
        //singular elements
        mainBreadcrumbElements = page.locator("//div[@class='breadcrumb']/a");
        //footer
        footerHitchFitIcon = page.locator("//div[@class='footer']//img[@class='footer-logo']");
        footerHitchFitSubtext = page.locator("//div[@class='footer']/div[1]//p");
        //explore section
        footerShopSectionTitle = page.locator("//div[@class='footer']/div[2]/h4");
        //list elements
        footerShopSectionLinkElements = page.locator("//div[@class='footer']/div[2]/a");
        //helpful links section
        footerCompanySectionTitle = page.locator("//div[@class='footer']/div[3]/h4");
        //list elements
        footerCompanyLinkElements = page.locator("//div[@class='footer']/div[3]/a");
        //get in touch section
        footerSupportSectionTitle = page.locator("//div[@class='footer']/div[4]/h4");
        //socials(list elements)
        footerSupportLinkElements = page.locator("//div[@class='footer']/div[4]/a");
        //copyright section
        footerCopyrightText = page.locator("//div[@class='copyright']");
    }


    //click header home page icon link method
    public void clickHeaderHomePageIconLink(){headerHomePageIconLink.click();}

    //click header navbar link method
    public void clickSetHeaderNavbarLink(int index){headerNavbarLinkElements.nth(index).click();}

    //click header "Cart" button method
    public void clickHeaderShopCartBtn(){headerShoppingCartButton.click();}

    //general page text element getters
    //header
    //singular elements
    public String getHeaderTrustedText(){return headerTrustedText.innerText();}
    //list elements
    public List<String> getHeaderNavbarLinkText(){
        int count = headerNavbarLinkElements.count();
        return IntStream.range(0, count)
                .mapToObj(i -> headerNavbarLinkElements.nth(i).innerText())
                .collect(Collectors.toList());
    }
    //footer
    public String getFooterHitchFitSubtext(){return footerHitchFitSubtext.innerText();}
    //shop section
    public String getFooterShopSectionTitle(){return footerShopSectionTitle.innerText();}
    //list elements
    public List<String> getFooterShopSectionLinkText(){
        int count = footerShopSectionLinkElements.count();
        return IntStream.range(0, count)
                .mapToObj(i -> footerShopSectionLinkElements.nth(i).innerText())
                .collect(Collectors.toList());
    }
    //company section
    public String getFooterCompanySectionTitle(){return footerCompanySectionTitle.innerText();}
    //list elements
    public List<String> getFooterCompanyLinkText(){
        int count = footerCompanyLinkElements.count();
        return IntStream.range(0, count)
                .mapToObj(i -> footerCompanyLinkElements.nth(i).innerText())
                .collect(Collectors.toList());
    }
    //support section
    public String getFooterSupportSectionTitle(){return footerSupportSectionTitle.innerText();}
    //list elements
    public List<String> getFooterSupportLinkText(){
        int count = footerSupportLinkElements.count();
        return IntStream.range(0, count)
                .mapToObj(i -> footerSupportLinkElements.nth(i).innerText())
                .collect(Collectors.toList());
    }
    //copyright section
    public String getFooterCopyrightText(){return footerCopyrightText.innerText();}

    //general page web element assert methods
    public boolean isHeaderHomePageIconLinkVisible() {return headerHomePageIconLink.isVisible();}
    //list elements
    public boolean isHeaderNavbarLinkElementsVisible() {
        int count = headerNavbarLinkElements.count();
        return IntStream.range(0, count)
                .allMatch(i -> headerNavbarLinkElements.nth(i).isVisible());
    }
    //main
    //singular elements
    public boolean isSingleElementVisible() {return headerShoppingCartButton.isVisible();}
    //list elements
    public boolean isHeaderBreadcrumbElementsVisible() {
        int count = mainBreadcrumbElements.count();
        return IntStream.range(0, count)
                .allMatch(i -> mainBreadcrumbElements.nth(i).isVisible());
    }
    //footer
    public boolean isFooterHitchFitIconVisible() {return footerHitchFitIcon.isVisible();}
    public boolean isFooterHitchFitSubtextVisible() {return footerHitchFitSubtext.isVisible();}
    //shop section
    public boolean isFooterShopSectionTitleVisible() {return footerShopSectionTitle.isVisible();}
    //list elements
    public boolean isFooterShopSectionLinkElementsVisible() {
        int count = footerShopSectionLinkElements.count();
        return IntStream.range(0, count)
                .allMatch(i -> footerShopSectionLinkElements.nth(i).isVisible());
    }
    //company section
    public boolean isFooterCompanySectionTitleVisible() {return footerCompanySectionTitle.isVisible();}
    //list elements
    public boolean isFooterCompanySectionLinkElementsVisible() {
        int count = footerCompanyLinkElements.count();
        return IntStream.range(0, count)
                .allMatch(i -> footerCompanyLinkElements.nth(i).isVisible());
    }
    //support section
    public boolean isFooterSupportSectionTitleVisible() {return footerSupportSectionTitle.isVisible();}
    //socials (list elements)
    public boolean isFooterSupportLinkElementsVisible() {
        int count = footerSupportLinkElements.count();
        return IntStream.range(0, count)
                .allMatch(i -> footerSupportLinkElements.nth(i).isVisible());
    }
    //copyright section
    public boolean isFooterCopyrightTextVisible() {return footerCopyrightText.isVisible();}

}
