package io.github.rokonrj403.utilities;

import org.junit.jupiter.api.*;
import com.microsoft.playwright.*;

public class BaseTest {

    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;

    @BeforeEach
    void setUp() {
        playwright = Playwright.create();

        browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(true) //true for CI; false for in-browser run
                .setArgs(java.util.List.of("--disable-search-engine-choice-screen")));

        context = browser.newContext(new Browser.NewContextOptions()
                .setViewportSize(1920, 1080)); // like maximize

        page = context.newPage();
        page.navigate("https://rokonrj403.github.io/hitchfit-supplements-bd/index.html");
    }

    @AfterEach
    void tearDown() {
        if (context != null) context.close();
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
    }

}