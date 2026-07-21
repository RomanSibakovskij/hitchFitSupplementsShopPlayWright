package io.github.rokonrj403;

import io.github.rokonrj403.utilities.TestMethods;
import org.junit.jupiter.api.*;

public class HomePageTest extends TestMethods{

    // Test 001 -> add single product (Whey Protein Product Blend) to cart test
    @Test
    @DisplayName("Test 001 - Add Single Home Page Product (Whey Protein Product Blend) To Cart Test")
    @Tag("Add_Single_Product_To_Cart")
    @Tag("Home_Page_Tests")
    void addSingleHomepageProductToCartTest(){
        addSetHomePageProductToCartTest(0, "WHEY PROTEIN FUSION BLEND", "", "No", "0","BDT 6,000 each", "", "BDT 6,000", "FREE", "BDT 6,000");
    }

    // Test 001a -> add single product with multiple quantity (Creatine Mono hydrate) to cart test
    @Test
    @DisplayName("Test 001a - Add Multiple Same Home Page Products (Creatine Mono hydrate) To Cart Test")
    @Tag("Add_Multiple_Products_To_Cart")
    @Tag("Home_Page_Tests")
    void addMultipleSameHomePageProductsToCartTest(){
        addSetHomePageProductToCartTest(1, "CREATINE MONOHYDRATE", "", "Yes", "0","BDT 4,200 each", "", "BDT 16,800", "FREE", "BDT 16,800");
    }

    // Test 001b -> add single product (Mega Multivitamin, Amino + Hydration) to cart test
    @Test
    @DisplayName("Test 001b - Add Multiple Home Page Products (Mega Multivitamin, Amino + Hydration) To Cart Test")
    @Tag("Add_Multiple_Products_To_Cart")
    @Tag("Home_Page_Tests")
    void addMultipleHomePageProductsToCartTest(){
        addSetHomePageProductToCartTest(2, "MEGA MULTIVITAMIN", "AMINO + HYDRATION | BCAA & ELECTROLYTE FORMULA", "No", "1","BDT 4,200 each", "BDT 6,000 each", "BDT 10,200", "FREE", "BDT 10,200");
    }

}