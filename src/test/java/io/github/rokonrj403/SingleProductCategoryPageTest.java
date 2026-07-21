package io.github.rokonrj403;

import io.github.rokonrj403.utilities.TestMethods;
import org.junit.jupiter.api.*;

public class SingleProductCategoryPageTest extends TestMethods {

    // Test 002 -> add single product category product (Collagen Hydrolyzed Peptide) to cart test
    @Test
    @DisplayName("Test 002 - Add Single Product Category Product (Collagen Hydrolyzed Peptide) To Cart Test")
    @Tag("Add_Single_Product_To_Cart")
    @Tag("Single_Product_Category_Page_Tests")
    void addSingleProductFromProductCatToCartTest(){
        addSetProductFromSingleProdCatToCartTest("Shop All", 2, "COLLAGEN HYDROLYZED PEPTIDE", "", "No", "0","BDT 5,400 each", "","BDT 5,400", "FREE", "BDT 5,400");
    }

    // Test 002a -> add single product category product with multiple quantity (Whey Isolate Protein Powder) to cart test
    @Test
    @DisplayName("Test 002a - Add Multiple Same Single Product Category Products (Whey Isolate Protein Powder) To Cart Test")
    @Tag("Add_Multiple_Products_To_Cart")
    @Tag("Single_Product_Category_Page_Tests")
    void addMultipleSameProductsFromProductCatToCartTest(){
        addSetProductFromSingleProdCatToCartTest("Proteins", 1, "WHEY ISOLATE PROTEIN POWDER", "", "Yes", "0","BDT 7,200 each", "","BDT 28,800", "FREE", "BDT 28,800");
    }

    // Test 002b -> add multiple single product category products (Greens & Reds | Super Greens Powder, Pre Workout for Energy, Muscle & Strength) to cart test
    @Test
    @DisplayName("Test 002b - Add Multiple Single Product Category Products (Greens & Reds | Super Greens Powder, Pre Workout for Energy, Muscle & Strength) To Cart Test")
    @Tag("Add_Multiple_Products_To_Cart")
    @Tag("Single_Product_Category_Page_Tests")
    void addMultipleProductsFromProductCatToCartTest(){
        addSetProductFromSingleProdCatToCartTest("Daily Nutrition", 2, "GREENS & REDS | SUPER GREENS POWDER", "PRE WORKOUT FOR ENERGY, MUSCLE & STRENGTH", "No", "1","BDT 5,400 each", "BDT 6,000 each","BDT 11,400", "FREE", "BDT 11,400");
    }

}
