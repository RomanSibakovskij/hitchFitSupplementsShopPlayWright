package io.github.rokonrj403;

import io.github.rokonrj403.utilities.TestMethods;
import org.junit.jupiter.api.*;

public class CheckoutPageTest extends TestMethods{

    // Test 007 -> single product (Whey Protein Fusion Blend) check out test
    @Test
    @DisplayName("Test 007 - Single Home Page Product (Whey Protein Fusion Blend) Checkout Test")
    @Tag("Single_Product_Checkout")
    @Tag("Home_Page_Tests")
    @Tag("Valid_Tests")
    void singleHomepageProductCheckoutTest(){
        //add single product (Whey Protein Fusion Blend) to cart test
        addSetHomePageProductToCartTest(0, "WHEY PROTEIN FUSION BLEND", "", "No", "0", "BDT 6,000 each", "", "BDT 6,000", "FREE", "BDT 6,000");
        //add single product (Whey Protein Fusion Blend) to check out test
        addProductsToCheckoutTest("Whey Protein Fusion Blend", "", "Don't change");
        //single product (Whey Protein Fusion Blend) check out (with going back to cart) test
        validProductCheckoutTest("Whey Protein Fusion Blend", "",  "Cash", "Yes", "BDT 6,000", "", "BDT 6,000", "FREE", "BDT 6,000");
    }

    // Test 007a -> single product with multiple quantity (Creatine Mono hydrate) check out test
    @Test
    @DisplayName("Test 007a - Multiple Same Home Page Products (Creatine Mono hydrate) Checkout Test")
    @Tag("Multiple_Products_Checkout")
    @Tag("Home_Page_Tests")
    void multipleSameHomePageProductsToCheckoutTest(){
        //add single product with multiple quantity (Creatine Mono hydrate) to cart test
        addSetHomePageProductToCartTest(1, "CREATINE MONOHYDRATE", "", "Yes", "0", "BDT 4,200 each", "", "BDT 16,800", "FREE", "BDT 16,800");
        //add single product with multiple quantity (Creatine Mono hydrate) to check out test
        addProductsToCheckoutTest("Creatine Monohydrate", "", "Don't change");
        //multiple products (Creatine Mono hydrate) check out test
        validProductCheckoutTest("Creatine Monohydrate", "",  "bKash", "No", "BDT 16,800", "", "BDT 16,800", "FREE", "BDT 16,800");
    }

    // Test 007b -> single product (Mega Multivitamin, Amino + Hydration) check out test
    @Test
    @DisplayName("Test 007b - Multiple Home Page Products (Mega Multivitamin, Amino + Hydration) Checkout Test")
    @Tag("Multiple_Products_Checkout")
    @Tag("Home_Page_Tests")
    void multipleHomePageProductsToCheckoutTest(){
        //add multiple products (Mega Multivitamin, Amino + Hydration) to cart test
        addSetHomePageProductToCartTest(2, "MEGA MULTIVITAMIN", "AMINO + HYDRATION | BCAA & ELECTROLYTE FORMULA", "No", "1", "BDT 4,200 each", "BDT 6,000 each", "BDT 10,200", "FREE", "BDT 10,200");
        //add multiple products (Mega Multivitamin, Amino + Hydration) to check out test
        addProductsToCheckoutTest("Mega Multivitamin", "Amino + Hydration | BCAA & Electrolyte Formula", "Don't change");
        //multiple products (Mega Multivitamin, Amino + Hydration) check out test
        validProductCheckoutTest("Mega Multivitamin", "Amino + Hydration | BCAA & Electrolyte Formula",  "Nagad", "No", "BDT 4,200", "BDT 6,000", "BDT 10,200", "FREE", "BDT 10,200");
    }

    // Test 008 -> single product category product (Collagen Hydrolyzed Peptide) check out test
    @Test
    @DisplayName("Test 008 - Single Product Category Product (Collagen Hydrolyzed Peptide) Checkout Test")
    @Tag("Single_Product_Checkout")
    @Tag("Single_Product_Category_Page_Tests")
    void singleProductFromProductCatToCheckoutTest(){
        //add single product category product (Collagen Hydrolyzed Peptide) to cart test
        addSetProductFromSingleProdCatToCartTest("Shop All", 2, "COLLAGEN HYDROLYZED PEPTIDE", "", "No", "0","BDT 5,400 each", "","BDT 5,400", "FREE", "BDT 5,400");
        //add single product category product (Collagen Hydrolyzed Peptide) to check out test
        addProductsToCheckoutTest("Collagen Hydrolyzed Peptide", "", "Don't change");
        //single product (Collagen Hydrolyzed Peptide) check out test
        validProductCheckoutTest("Collagen Hydrolyzed Peptide", "",  "Nagad", "No", "BDT 5,400", "", "BDT 5,400", "FREE", "BDT 5,400");
    }

    // Test 008a -> single product category product with multiple quantity (Whey Isolate Protein Powder) check out test
    @Test
    @DisplayName("Test 008a - Multiple Same Single Product Category Products (Whey Isolate Protein Powder) Checkout Test")
    @Tag("Multiple_Products_Checkout")
    @Tag("Single_Product_Category_Page_Tests")
    void multipleSameProductsFromProductCatToCheckoutTest(){
        //add single product category product with multiple quantity (Whey Isolate Protein Powder) to cart test
        addSetProductFromSingleProdCatToCartTest("Proteins", 1, "WHEY ISOLATE PROTEIN POWDER", "", "Yes", "0","BDT 7,200 each", "","BDT 28,800", "FREE", "BDT 28,800");
        //add single product category product with multiple quantity (Whey Isolate Protein Powder) to check out test
        addProductsToCheckoutTest("Whey Isolate Protein Powder", "", "Don't change");
        //multiple products (Whey Isolate Protein Powder) check out test
        validProductCheckoutTest("Whey Isolate Protein Powder", "",  "bKash", "No", "BDT 28,800", "", "BDT 28,800", "FREE", "BDT 28,800");
    }

    // Test 008b -> multiple single product category products (Greens & Reds | Super Greens Powder, Pre Workout for Energy, Muscle & Strength) to check out test
    @Test
    @DisplayName("Test 008b - Multiple Single Product Category Products (Greens & Reds | Super Greens Powder, Pre Workout for Energy, Muscle & Strength) Checkout Test")
    @Tag("Multiple_Products_Checkout")
    @Tag("Single_Product_Category_Page_Tests")
    void multipleProductsFromProductCatToCheckoutTest(){
        //add multiple single product category products (Greens & Reds | Super Greens Powder, Pre Workout for Energy, Muscle & Strength) to cart test
        addSetProductFromSingleProdCatToCartTest("Daily Nutrition", 2, "GREENS & REDS | SUPER GREENS POWDER", "PRE WORKOUT FOR ENERGY, MUSCLE & STRENGTH", "No", "1","BDT 5,400 each", "BDT 6,000 each","BDT 11,400", "FREE", "BDT 11,400");
        //add multiple single product category products (Greens & Reds | Super Greens Powder, Pre Workout for Energy, Muscle & Strength) to check out test
        addProductsToCheckoutTest("Greens & Reds | Super Greens Powder", "Pre Workout for Energy, Muscle & Strength", "Don't change");
        //multiple single product category products (Greens & Reds | Super Greens Powder, Pre Workout for Energy, Muscle & Strength) check out test
        validProductCheckoutTest("Greens & Reds | Super Greens Powder", "Pre Workout for Energy, Muscle & Strength",  "Cash", "No", "BDT 5,400", "BDT 6,000", "BDT 11,400", "FREE", "BDT 11,400");
    }

}
