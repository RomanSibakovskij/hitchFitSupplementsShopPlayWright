package io.github.rokonrj403;

import io.github.rokonrj403.utilities.TestMethods;
import org.junit.jupiter.api.*;

public class CheckoutPageInvalidSingularInputTest extends TestMethods{

    // Test 009 -> invalid single product (Whey Protein Fusion Blend) check out test - no full name
    @Test
    @DisplayName("Test 009 - Invalid Single Home Page Product (Whey Protein Fusion Blend) Checkout Test - No Full Name")
    @Tag("Single_Product_Checkout")
    @Tag("Invalid_Checkout_Tests")
    @Tag("No_Singular_Input")
    void invalidSingleHomepageProductCheckoutNoFullNameTest(){
        //add single product (Whey Protein Fusion Blend) to cart test
        addSetHomePageProductToCartTest(0, "WHEY PROTEIN FUSION BLEND", "", "No", "0", "BDT 6,000 each", "", "BDT 6,000", "FREE", "BDT 6,000");
        //add single product (Whey Protein Fusion Blend) to check out test
        addProductsToCheckoutTest("Whey Protein Fusion Blend", "", "Don't change");
        //invalid single product (Whey Protein Fusion Blend) check out test - no full name
        invalidProductCheckoutNoFullNameTest("Whey Protein Fusion Blend", "",  "Cash", "BDT 6,000", "", "BDT 6,000", "FREE", "BDT 6,000");
    }

    // Test 009a -> invalid single product (Whey Protein Fusion Blend) check out test - no phone
    @Test
    @DisplayName("Test 009a - Invalid Single Home Page Product (Whey Protein Fusion Blend) Checkout Test - No Phone")
    @Tag("Single_Product_Checkout")
    @Tag("Invalid_Checkout_Tests")
    @Tag("No_Singular_Input")
    void invalidSingleHomepageProductCheckoutNoPhoneTest(){
        //add single product (Whey Protein Fusion Blend) to cart test
        addSetHomePageProductToCartTest(0, "WHEY PROTEIN FUSION BLEND", "", "No", "0", "BDT 6,000 each", "", "BDT 6,000", "FREE", "BDT 6,000");
        //add single product (Whey Protein Fusion Blend) to check out test
        addProductsToCheckoutTest("Whey Protein Fusion Blend", "", "Don't change");
        //invalid single product (Whey Protein Fusion Blend) check out test - no phone
        invalidProductCheckoutNoPhoneTest("Whey Protein Fusion Blend", "", "Cash", "BDT 6,000", "", "BDT 6,000", "FREE", "BDT 6,000");
    }

    // Test 009b -> invalid single product (Whey Protein Fusion Blend) check out test - no address
    @Test
    @DisplayName("Test 009b - Invalid Single Home Page Product (Whey Protein Fusion Blend) Checkout Test - No Address")
    @Tag("Single_Product_Checkout")
    @Tag("Invalid_Checkout_Tests")
    @Tag("No_Singular_Input")
    void invalidSingleHomepageProductCheckoutNoAddressTest(){
        //add single product (Whey Protein Fusion Blend) to cart test
        addSetHomePageProductToCartTest(0, "WHEY PROTEIN FUSION BLEND", "", "No", "0", "BDT 6,000 each", "", "BDT 6,000", "FREE", "BDT 6,000");
        //add single product (Whey Protein Fusion Blend) to check out test
        addProductsToCheckoutTest("Whey Protein Fusion Blend", "", "Don't change");
        //invalid single product (Whey Protein Fusion Blend) check out test - no address
        invalidProductCheckoutNoAddressTest("Whey Protein Fusion Blend", "", "Cash", "BDT 6,000", "", "BDT 6,000", "FREE", "BDT 6,000");
    }

    // Test 009c -> invalid single product (Whey Protein Fusion Blend) check out test - no city
    @Test
    @DisplayName("Test 009c - Invalid Single Home Page Product (Whey Protein Fusion Blend) Checkout Test - No City")
    @Tag("Single_Product_Checkout")
    @Tag("Invalid_Checkout_Tests")
    @Tag("No_Singular_Input")
    void invalidSingleHomepageProductCheckoutNoCityTest(){
        //add single product (Whey Protein Fusion Blend) to cart test
        addSetHomePageProductToCartTest(0, "WHEY PROTEIN FUSION BLEND", "", "No", "0", "BDT 6,000 each", "", "BDT 6,000", "FREE", "BDT 6,000");
        //add single product (Whey Protein Fusion Blend) to check out test
        addProductsToCheckoutTest("Whey Protein Fusion Blend", "", "Don't change");
        //invalid single product (Whey Protein Fusion Blend) check out test - no city
        invalidProductCheckoutNoCityTest("Whey Protein Fusion Blend", "", "Cash", "BDT 6,000", "", "BDT 6,000", "FREE", "BDT 6,000");
    }

    // Test 009d -> invalid single product (Whey Protein Fusion Blend) check out test - too short full name (3 chars) (failed)
    @Test
    @DisplayName("Test 009d - Invalid Single Home Page Product (Whey Protein Fusion Blend) Checkout Test - Too Short Full Name")
    @Tag("Single_Product_Checkout")
    @Tag("Invalid_Checkout_Tests")
    @Tag("Too_Short_Singular_Input")
    void invalidSingleHomepageProductCheckoutTooShortFullNameTest(){
        //add single product (Whey Protein Fusion Blend) to cart test
        addSetHomePageProductToCartTest(0, "WHEY PROTEIN FUSION BLEND", "", "No", "0", "BDT 6,000 each", "", "BDT 6,000", "FREE", "BDT 6,000");
        //add single product (Whey Protein Fusion Blend) to check out test
        addProductsToCheckoutTest("Whey Protein Fusion Blend", "", "Don't change");
        //invalid single product (Whey Protein Fusion Blend) check out test - too short full name
        invalidProductCheckoutTooShortFullNameTest("Whey Protein Fusion Blend", "", "Cash", "BDT 6,000", "", "BDT 6,000", "FREE", "BDT 6,000");
    }

    // Test 009e -> invalid single product (Whey Protein Fusion Blend) check out test - too short phone (2 digits) (failed)
    @Test
    @DisplayName("Test 009e - Invalid Single Home Page Product (Whey Protein Fusion Blend) Checkout Test - Too Short Phone")
    @Tag("Single_Product_Checkout")
    @Tag("Invalid_Checkout_Tests")
    @Tag("Too_Short_Singular_Input")
    void invalidSingleHomepageProductCheckoutTooShortPhoneTest(){
        //add single product (Whey Protein Fusion Blend) to cart test
        addSetHomePageProductToCartTest(0, "WHEY PROTEIN FUSION BLEND", "", "No", "0", "BDT 6,000 each", "", "BDT 6,000", "FREE", "BDT 6,000");
        //add single product (Whey Protein Fusion Blend) to check out test
        addProductsToCheckoutTest("Whey Protein Fusion Blend", "", "Don't change");
        //invalid single product (Whey Protein Fusion Blend) check out test - too short phone
        invalidProductCheckoutTooShortPhoneTest("Whey Protein Fusion Blend", "", "Cash", "BDT 6,000", "", "BDT 6,000", "FREE", "BDT 6,000");
    }

    // Test 009f -> invalid single product (Whey Protein Fusion Blend) check out test - too short address (3 chars) (failed)
    @Test
    @DisplayName("Test 009f - Invalid Single Home Page Product (Whey Protein Fusion Blend) Checkout Test - Too Short Address")
    @Tag("Single_Product_Checkout")
    @Tag("Invalid_Checkout_Tests")
    @Tag("Too_Short_Singular_Input")
    void invalidSingleHomepageProductCheckoutTooShortAddressTest(){
        //add single product (Whey Protein Fusion Blend) to cart test
        addSetHomePageProductToCartTest(0, "WHEY PROTEIN FUSION BLEND", "", "No", "0", "BDT 6,000 each", "", "BDT 6,000", "FREE", "BDT 6,000");
        //add single product (Whey Protein Fusion Blend) to check out test
        addProductsToCheckoutTest("Whey Protein Fusion Blend", "", "Don't change");
        //invalid single product (Whey Protein Fusion Blend) check out test - too short address
        invalidProductCheckoutTooShortAddressTest("Whey Protein Fusion Blend", "", "Cash", "BDT 6,000", "", "BDT 6,000", "FREE", "BDT 6,000");
    }

    // Test 009g -> invalid single product (Whey Protein Fusion Blend) check out test - too short city (2 chars) (failed)
    @Test
    @DisplayName("Test 009g - Invalid Single Home Page Product (Whey Protein Fusion Blend) Checkout Test - Too Short City")
    @Tag("Single_Product_Checkout")
    @Tag("Invalid_Checkout_Tests")
    @Tag("Too_Short_Singular_Input")
    void invalidSingleHomepageProductCheckoutTooShortCityTest(){
        //add single product (Whey Protein Fusion Blend) to cart test
        addSetHomePageProductToCartTest(0, "WHEY PROTEIN FUSION BLEND", "", "No", "0", "BDT 6,000 each", "", "BDT 6,000", "FREE", "BDT 6,000");
        //add single product (Whey Protein Fusion Blend) to check out test
        addProductsToCheckoutTest("Whey Protein Fusion Blend", "", "Don't change");
        //invalid single product (Whey Protein Fusion Blend) check out test - too short city
        invalidProductCheckoutTooShortCityTest("Whey Protein Fusion Blend", "", "Cash", "BDT 6,000", "", "BDT 6,000", "FREE", "BDT 6,000");
    }

    // Test 009h -> invalid single product (Whey Protein Fusion Blend) check out test - too long full name (200 chars) (failed)
    @Test
    @DisplayName("Test 009h - Invalid Single Home Page Product (Whey Protein Fusion Blend) Checkout Test - Too Long Full Name")
    @Tag("Single_Product_Checkout")
    @Tag("Invalid_Checkout_Tests")
    @Tag("Too_Long_Singular_Input")
    void invalidSingleHomepageProductCheckoutTooLongFullNameTest(){
        //add single product (Whey Protein Fusion Blend) to cart test
        addSetHomePageProductToCartTest(0, "WHEY PROTEIN FUSION BLEND", "", "No", "0", "BDT 6,000 each", "", "BDT 6,000", "FREE", "BDT 6,000");
        //add single product (Whey Protein Fusion Blend) to check out test
        addProductsToCheckoutTest("Whey Protein Fusion Blend", "", "Don't change");
        //invalid single product (Whey Protein Fusion Blend) check out test - too long full name
        invalidProductCheckoutTooLongFullNameTest("Whey Protein Fusion Blend", "", "Cash", "BDT 6,000", "", "BDT 6,000", "FREE", "BDT 6,000");
    }

    // Test 009i -> invalid single product (Whey Protein Fusion Blend) check out test - too long phone (25 digits) (failed)
    @Test
    @DisplayName("Test 009e - Invalid Single Home Page Product (Whey Protein Fusion Blend) Checkout Test - Too Long Phone")
    @Tag("Single_Product_Checkout")
    @Tag("Invalid_Checkout_Tests")
    @Tag("Too_Long_Singular_Input")
    void invalidSingleHomepageProductCheckoutTooLongPhoneTest(){
        //add single product (Whey Protein Fusion Blend) to cart test
        addSetHomePageProductToCartTest(0, "WHEY PROTEIN FUSION BLEND", "", "No", "0", "BDT 6,000 each", "", "BDT 6,000", "FREE", "BDT 6,000");
        //add single product (Whey Protein Fusion Blend) to check out test
        addProductsToCheckoutTest("Whey Protein Fusion Blend", "", "Don't change");
        //invalid single product (Whey Protein Fusion Blend) check out test - too long phone
        invalidProductCheckoutTooLongPhoneTest("Whey Protein Fusion Blend", "", "Cash", "BDT 6,000", "", "BDT 6,000", "FREE", "BDT 6,000");
    }

    // Test 009j -> invalid single product (Whey Protein Fusion Blend) check out test - too long address (100 chars) (failed)
    @Test
    @DisplayName("Test 009j - Invalid Single Home Page Product (Whey Protein Fusion Blend) Checkout Test - Too Long Address")
    @Tag("Single_Product_Checkout")
    @Tag("Invalid_Checkout_Tests")
    @Tag("Too_Long_Singular_Input")
    void invalidSingleHomepageProductCheckoutTooLongAddressTest(){
        //add single product (Whey Protein Fusion Blend) to cart test
        addSetHomePageProductToCartTest(0, "WHEY PROTEIN FUSION BLEND", "", "No", "0", "BDT 6,000 each", "", "BDT 6,000", "FREE", "BDT 6,000");
        //add single product (Whey Protein Fusion Blend) to check out test
        addProductsToCheckoutTest("Whey Protein Fusion Blend", "", "Don't change");
        //invalid single product (Whey Protein Fusion Blend) check out test - too long address
        invalidProductCheckoutTooLongAddressTest("Whey Protein Fusion Blend", "", "Cash", "BDT 6,000", "", "BDT 6,000", "FREE", "BDT 6,000");
    }

    // Test 009k -> invalid single product (Whey Protein Fusion Blend) check out test - too long city (100 chars) (failed)
    @Test
    @DisplayName("Test 009g - Invalid Single Home Page Product (Whey Protein Fusion Blend) Checkout Test - Too Long City")
    @Tag("Single_Product_Checkout")
    @Tag("Invalid_Checkout_Tests")
    @Tag("Too_Long_Singular_Input")
    void invalidSingleHomepageProductCheckoutTooLongCityTest(){
        //add single product (Whey Protein Fusion Blend) to cart test
        addSetHomePageProductToCartTest(0, "WHEY PROTEIN FUSION BLEND", "", "No", "0", "BDT 6,000 each", "", "BDT 6,000", "FREE", "BDT 6,000");
        //add single product (Whey Protein Fusion Blend) to check out test
        addProductsToCheckoutTest("Whey Protein Fusion Blend", "", "Don't change");
        //invalid single product (Whey Protein Fusion Blend) check out test - too long city
        invalidProductCheckoutTooLongCityTest("Whey Protein Fusion Blend", "", "Cash", "BDT 6,000", "", "BDT 6,000", "FREE", "BDT 6,000");
    }

    // Test 009l -> invalid single product (Whey Protein Fusion Blend) check out test - invalid full name format (special symbols only) (failed)
    @Test
    @DisplayName("Test 009l - Invalid Single Home Page Product (Whey Protein Fusion Blend) Checkout Test - Invalid Full Name Format")
    @Tag("Single_Product_Checkout")
    @Tag("Invalid_Checkout_Tests")
    @Tag("Invalid_Singular_Input")
    void invalidSingleHomepageProductCheckoutInvalidFullNameFormatTest(){
        //add single product (Whey Protein Fusion Blend) to cart test
        addSetHomePageProductToCartTest(0, "WHEY PROTEIN FUSION BLEND", "", "No", "0", "BDT 6,000 each", "", "BDT 6,000", "FREE", "BDT 6,000");
        //add single product (Whey Protein Fusion Blend) to check out test
        addProductsToCheckoutTest("Whey Protein Fusion Blend", "", "Don't change");
        //invalid single product (Whey Protein Fusion Blend) check out test - invalid full name format
        invalidProductCheckoutInvalidFullNameFormatTest("Whey Protein Fusion Blend", "", "Cash", "BDT 6,000", "", "BDT 6,000", "FREE", "BDT 6,000");
    }

    // Test 009m -> invalid single product (Whey Protein Fusion Blend) check out test - invalid phone format (special symbols only) (failed)
    @Test
    @DisplayName("Test 009m - Invalid Single Home Page Product (Whey Protein Fusion Blend) Checkout Test - Invalid Phone Format")
    @Tag("Single_Product_Checkout")
    @Tag("Invalid_Checkout_Tests")
    @Tag("Invalid_Singular_Input")
    void invalidSingleHomepageProductCheckoutInvalidPhoneFormatTest(){
        //add single product (Whey Protein Fusion Blend) to cart test
        addSetHomePageProductToCartTest(0, "WHEY PROTEIN FUSION BLEND", "", "No", "0", "BDT 6,000 each", "", "BDT 6,000", "FREE", "BDT 6,000");
        //add single product (Whey Protein Fusion Blend) to check out test
        addProductsToCheckoutTest("Whey Protein Fusion Blend", "", "Don't change");
        //invalid single product (Whey Protein Fusion Blend) check out test - invalid phone format
        invalidProductCheckoutInvalidPhoneFormatTest("Whey Protein Fusion Blend", "", "Cash", "BDT 6,000", "", "BDT 6,000", "FREE", "BDT 6,000");
    }

    // Test 009n -> invalid single product (Whey Protein Fusion Blend) check out test - invalid address format (special symbols only) (failed)
    @Test
    @DisplayName("Test 009n - Invalid Single Home Page Product (Whey Protein Fusion Blend) Checkout Test - Invalid Address Format")
    @Tag("Single_Product_Checkout")
    @Tag("Invalid_Checkout_Tests")
    @Tag("Invalid_Singular_Input")
    void invalidSingleHomepageProductCheckoutInvalidAddressFormatTest(){
        //add single product (Whey Protein Fusion Blend) to cart test
        addSetHomePageProductToCartTest(0, "WHEY PROTEIN FUSION BLEND", "", "No", "0", "BDT 6,000 each", "", "BDT 6,000", "FREE", "BDT 6,000");
        //add single product (Whey Protein Fusion Blend) to check out test
        addProductsToCheckoutTest("Whey Protein Fusion Blend", "", "Don't change");
        //invalid single product (Whey Protein Fusion Blend) check out test - invalid address format
        invalidProductCheckoutInvalidAddressFormatTest("Whey Protein Fusion Blend", "", "Cash", "BDT 6,000", "", "BDT 6,000", "FREE", "BDT 6,000");
    }

    // Test 009o -> invalid single product (Whey Protein Fusion Blend) check out test - invalid city format (special symbols only) (failed)
    @Test
    @DisplayName("Test 009o - Invalid Single Home Page Product (Whey Protein Fusion Blend) Checkout Test - Invalid City Format")
    @Tag("Single_Product_Checkout")
    @Tag("Invalid_Checkout_Tests")
    @Tag("Invalid_Singular_Input")
    void invalidSingleHomepageProductCheckoutInvalidCityFormatTest(){
        //add single product (Whey Protein Fusion Blend) to cart test
        addSetHomePageProductToCartTest(0, "WHEY PROTEIN FUSION BLEND", "", "No", "0", "BDT 6,000 each", "", "BDT 6,000", "FREE", "BDT 6,000");
        //add single product (Whey Protein Fusion Blend) to check out test
        addProductsToCheckoutTest("Whey Protein Fusion Blend", "", "Don't change");
        //invalid single product (Whey Protein Fusion Blend) check out test - invalid city format
        invalidProductCheckoutInvalidCityFormatTest("Whey Protein Fusion Blend", "", "Cash", "BDT 6,000", "", "BDT 6,000", "FREE", "BDT 6,000");
    }

}
