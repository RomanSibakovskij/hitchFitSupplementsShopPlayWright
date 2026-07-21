package io.github.rokonrj403;

import io.github.rokonrj403.utilities.TestMethods;
import org.junit.jupiter.api.*;

public class ShoppingCartPageTest extends TestMethods{

    // Test 003 -> add single product (Whey Protein Fusion Blend) to check out test
    @Test
    @DisplayName("Test 003 - Add Single Home Page Product (Whey Protein Fusion Blend) To Checkout Test")
    @Tag("Add_Single_Product_To_Checkout")
    @Tag("Home_Page_Tests")
    void addSingleHomepageProductToCheckoutTest(){
        //add single product (Whey Protein Fusion Blend) to cart test
        addSetHomePageProductToCartTest(0, "WHEY PROTEIN FUSION BLEND", "", "No", "0","BDT 6,000 each", "", "BDT 6,000", "FREE", "BDT 6,000");
        //add single product (Whey Protein Fusion Blend) to check out test
        addProductsToCheckoutTest("Whey Protein Fusion Blend", "", "Don't change");
    }

    // Test 003a -> add single product with multiple quantity (Creatine Mono hydrate) to check out test
    @Test
    @DisplayName("Test 003a - Add Multiple Same Home Page Products (Creatine Mono hydrate) To Cart Test")
    @Tag("Add_Multiple_Products_To_Checkout")
    @Tag("Home_Page_Tests")
    void addMultipleSameHomePageProductsToCheckoutTest(){
        //add single product with multiple quantity (Creatine Mono hydrate) to cart test
        addSetHomePageProductToCartTest(1, "CREATINE MONOHYDRATE", "", "Yes", "0","BDT 4,200 each", "", "BDT 4,200", "BDT 100", "BDT 4,300");
        //add single product with multiple quantity (Creatine Mono hydrate) to check out test
        addProductsToCheckoutTest("Creatine Monohydrate", "", "Don't change");
    }

    // Test 003b -> add single product (Mega Multivitamin, Amino + Hydration) to check out test
    @Test
    @DisplayName("Test 003b - Add Multiple Home Page Products (Mega Multivitamin, Amino + Hydration) To Checkout Test")
    @Tag("Add_Multiple_Products_To_Checkout")
    @Tag("Home_Page_Tests")
    void addMultipleHomePageProductsToCheckoutTest(){
        //add single product (Mega Multivitamin, Amino + Hydration) to cart test
        addSetHomePageProductToCartTest(2, "MEGA MULTIVITAMIN", "AMINO + HYDRATION | BCAA & ELECTROLYTE FORMULA", "No", "1","BDT 4,200 each", "BDT 6,000 each", "BDT 10,200", "FREE", "BDT 10,200");
        //add single product (Mega Multivitamin, Amino + Hydration) to check out test
        addProductsToCheckoutTest("Mega Multivitamin", "Amino + Hydration | BCAA & Electrolyte Formula", "Don't change");
    }

    // Test 004 -> add single product category product (Collagen Hydrolyzed Peptide) to check out test
    @Test
    @DisplayName("Test 004 - Add Single Product Category Product (Collagen Hydrolyzed Peptide) To Checkout Test")
    @Tag("Add_Single_Product_To_Checkout")
    @Tag("Single_Product_Category_Page_Tests")
    void addSingleProductFromProductCatToCheckoutTest(){
        //add single product category product (Collagen Hydrolyzed Peptide) to cart test
        addSetProductFromSingleProdCatToCartTest("Shop All", 2, "COLLAGEN HYDROLYZED PEPTIDE", "", "No", "0","BDT 5,400 each", "","BDT 5,400", "FREE", "BDT 5,400");
        //add single product category product (Collagen Hydrolyzed Peptide) to check out test
        addProductsToCheckoutTest("Collagen Hydrolyzed Peptide", "", "Don't change");
    }

    // Test 004a -> add single product category product with multiple quantity (Whey Isolate Protein Powder) to check out test
    @Test
    @DisplayName("Test 004a - Add Multiple Same Single Product Category Products (Whey Isolate Protein Powder) To Checkout Test")
    @Tag("Add_Multiple_Products_To_Checkout")
    @Tag("Single_Product_Category_Page_Tests")
    void addMultipleSameProductsFromProductCatToCheckoutTest(){
        //add single product category product with multiple quantity (Whey Isolate Protein Powder) to cart test
        addSetProductFromSingleProdCatToCartTest("Proteins", 1, "WHEY ISOLATE PROTEIN POWDER", "", "Yes", "0","BDT 7,200 each", "","BDT 7,200", "FREE", "BDT 7,200");
        //add single product category product with multiple quantity (Whey Isolate Protein Powder) to check out test
        addProductsToCheckoutTest("Whey Isolate Protein Powder", "", "Don't change");
    }

    // Test 004b -> add multiple single product category products (Greens & Reds | Super Greens Powder, Pre Workout for Energy, Muscle & Strength) to check out test
    @Test
    @DisplayName("Test 004b - Add Multiple Single Product Category Products (Greens & Reds | Super Greens Powder, Pre Workout for Energy, Muscle & Strength) To Checkout Test")
    @Tag("Add_Multiple_Products_To_Checkout")
    @Tag("Single_Product_Category_Page_Tests")
    void addMultipleProductsFromProductCatToCheckoutTest(){
        //add multiple single product category products (Greens & Reds | Super Greens Powder, Pre Workout for Energy, Muscle & Strength) to cart test
        addSetProductFromSingleProdCatToCartTest("Daily Nutrition", 2, "GREENS & REDS | SUPER GREENS POWDER", "PRE WORKOUT FOR ENERGY, MUSCLE & STRENGTH", "No", "1","BDT 5,400 each", "BDT 6,000 each","BDT 11,400", "FREE", "BDT 11,400");
        //add multiple single product category products (Greens & Reds | Super Greens Powder, Pre Workout for Energy, Muscle & Strength) to check out test
        addProductsToCheckoutTest("Greens & Reds | Super Greens Powder", "Pre Workout for Energy, Muscle & Strength", "Don't change");
    }

    // Test 005 -> change single product (Whey Protein Fusion Blend) in shopping cart test
    @Test
    @DisplayName("Test 005 - Change Single Home Page Product (Whey Protein Fusion Blend) Qty In Shopping Cart For Checkout Test")
    @Tag("Change_Single_Product_Qty_In_Shop_Cart")
    @Tag("Home_Page_Tests")
    void changeSingleHomepageProductQtyInShopCartTest(){
        //add single product (Whey Protein Fusion Blend) to cart test
        addSetHomePageProductToCartTest(0, "WHEY PROTEIN FUSION BLEND", "", "No", "0","BDT 6,000 each", "", "BDT 6,000", "FREE", "BDT 6,000");
        //add single product (Whey Protein Fusion Blend) to check out test
        addProductsToCheckoutTest("Whey Protein Fusion Blend", "", "Change");
    }


    @Test
    @DisplayName("Test 006 - Remove Single Product Category Product (Collagen Hydrolyzed Peptide) From Shopping Cart Test")
    @Tag("Remove_Single_Product_From_Shop_Cart")
    @Tag("Single_Product_Category_Page_Tests")
    void removeSingleProductFromProductCatFromShopCartTest(){
        //add single product category product (Collagen Hydrolyzed Peptide) to cart test
        addSetProductFromSingleProdCatToCartTest("Shop All", 2, "COLLAGEN HYDROLYZED PEPTIDE", "", "No", "0","BDT 4,200 each", "", "BDT 5,400", "FREE", "BDT 5,400");
        //remove single product category product (Collagen Hydrolyzed Peptide) from shop cart test
        removeSingleProductFromShoppingCartTest("Collagen Hydrolyzed Peptide");
    }

    // Test 006a -> remove set single product category product (Collagen Hydrolyzed Peptide) from shopping cart test
    @Test
    @DisplayName("Test 006a - Remove Set Product (Collagen Hydrolyzed Peptide) From Shopping Cart Test")
    @Tag("Remove_Set_Product_From_Shop_Cart")
    @Tag("Single_Product_Category_Page_Tests")
    void removeSetProductFromProductCatFromShopCartTest(){
        //add multiple single product category products (Greens & Reds | Super Greens Powder, Pre Workout for Energy, Muscle & Strength) to cart test
        addSetProductFromSingleProdCatToCartTest("Daily Nutrition", 2, "GREENS & REDS | SUPER GREENS POWDER", "PRE WORKOUT FOR ENERGY, MUSCLE & STRENGTH", "No", "1","BDT 5,400 each", "BDT 6,000 each","BDT 11,400", "FREE", "BDT 11,400");
        //remove set single product category product (Pre Workout for Energy, Muscle & Strength) from shop cart test
        removeSetProductFromShoppingCartTest(1, "Greens & Reds | Super Greens Powder", "Pre Workout for Energy, Muscle & Strength");
    }

}
