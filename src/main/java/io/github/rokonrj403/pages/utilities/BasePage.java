package io.github.rokonrj403.pages.utilities;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

import java.util.*;
import java.util.stream.*;

import org.slf4j.*;

public class BasePage {

    protected Page page;
    public static final Logger logger = LoggerFactory.getLogger(BasePage.class);

    public BasePage(Page page) {this.page = page;}

    //wait method for elements to load
    public void waitForPageLoad(int timeoutSeconds) {
        page.waitForLoadState(LoadState.NETWORKIDLE,
                new Page.WaitForLoadStateOptions().setTimeout(timeoutSeconds * 1000L));
    }

    /*

    //text element getters
    //click set link method
    public void clickSetLink(Locator locator, int index){locator.nth(index).click();}

    //extract set text method (singular elements)
    public String getSetLocatorInnerText(Locator locator){return locator.innerText();}

    //extract set text method (list elements)
    public List<String> getSetLocatorsInnerTexts(Locator locator){
        int count = locator.count();
        return IntStream.range(0, count)
                .mapToObj(i -> locator.nth(i).innerText())
                .collect(Collectors.toList());
    }

    //web element getters
    //singular elements
    public boolean isSingleElementVisible(Locator locator) {return locator.isVisible();}
    //list elements
    public boolean isListElementsVisible(Locator locator) {
        int count = locator.count();
        return IntStream.range(0, count)
                .allMatch(i -> locator.nth(i).isVisible());
    }

     */

}
