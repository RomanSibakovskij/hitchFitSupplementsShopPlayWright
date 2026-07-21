# hitchFitSupplementsShopPlayWright

Simple Playwright test suite on basic user account creation, product addition to cart/checkout (checkout isn't implemented). The test suite captures screenshots at the end of test case run (for logging purposes).


#Tech Requirements:

1.Java JDK 8 or higher

2.Apache Maven

3.IntelliJ IDEA (or another IDE that supports Java and Maven)

4. JUnit5 5.1x

5. Playwright 1.59p

#Setup

1. Clone this repository into IntelliJ(or other IDE) workspace folder (or wherever the project can be launched by IDE)
2. Open the IDE and open the project folder
3. Navigate to the pom.xml file and install all required dependencies for the test run
4. Run the test suite on the IDE (or mvn test in-terminal)

## Test Case List

//add single/multiple homepage products to cart tests

1.	// Test 001 -> add single product (Whey Protein Product Blend) to cart test
2.  // Test 001a -> add single product with multiple quantity (Creatine Mono hydrate) to cart test
3.  // Test 001b -> add single product (Mega Multivitamin, Amino + Hydration) to cart test

//add single/multiple single product category product to cart test

1.	// Test 002 -> add single product category product (Collagen Hydrolyzed Peptide) to cart test
2.  // Test 002a -> add single product category product with multiple quantity (Whey Isolate Protein Powder) to cart test
3.  // Test 002b -> add multiple single product category products (Greens & Reds | Super Greens Powder, Pre Workout for Energy, Muscle & Strength) to cart test

//shopping cart tests

1.	// Test 003 -> add single product (Whey Protein Fusion Blend) to check out test
2.  // Test 003a -> add single product with multiple quantity (Creatine Mono hydrate) to check out test
3.  // Test 003b -> add single product (Mega Multivitamin, Amino + Hydration) to check out test
4.  // Test 004 -> add single product category product (Collagen Hydrolyzed Peptide) to check out test
5.  // Test 004a -> add single product category product with multiple quantity (Whey Isolate Protein Powder) to check out test
6.  // Test 004b -> add multiple single product category products (Greens & Reds | Super Greens Powder, Pre Workout for Energy, Muscle & Strength) to check out test
7.  // Test 005 -> change single product (Whey Protein Fusion Blend) in shopping cart test
8.  // Test 006 -> remove single product category product (Collagen Hydrolyzed Peptide) from shopping cart test
9.  // Test 006a -> remove set single product category product (Collagen Hydrolyzed Peptide) from shopping cart test

//checkout page tests

1.	// Test 007 -> single product (Whey Protein Fusion Blend) check out test
2.  // Test 007a -> single product with multiple quantity (Creatine Mono hydrate) check out test
3.  // Test 007b -> single product (Mega Multivitamin, Amino + Hydration) check out test
4.  // Test 008 -> single product category product (Collagen Hydrolyzed Peptide) check out test
5.  // Test 008a -> single product category product with multiple quantity (Whey Isolate Protein Powder) check out test
6.  // Test 008b -> multiple single product category products (Greens & Reds | Super Greens Powder, Pre Workout for Energy, Muscle & Strength) to check out test

//invalid product checkout tests

//no singular input(delivery details)

1.	// Test 009 -> invalid single product (Whey Protein Fusion Blend) check out test - no full name
2.	// Test 009a -> invalid single product (Whey Protein Fusion Blend) check out test - no phone
3.	// Test 009b -> invalid single product (Whey Protein Fusion Blend) check out test - no address
4.  // Test 009c -> invalid single product (Whey Protein Fusion Blend) check out test - no city

//too short singular input(delivery details)

1.	// Test 009d -> invalid single product (Whey Protein Fusion Blend) check out test - too short full name (3 chars) (failed)
2.	// Test 009e -> invalid single product (Whey Protein Fusion Blend) check out test - too short phone (2 digits) (failed)
3.	// Test 009f -> invalid single product (Whey Protein Fusion Blend) check out test - too short address (3 chars) (failed)
4.  // Test 009g -> invalid single product (Whey Protein Fusion Blend) check out test - too short city (2 chars) (failed)

//too long singular input(delivery details)

1.	// Test 009h -> invalid single product (Whey Protein Fusion Blend) check out test - too long full name (200 chars) (failed)
2.	// Test 009i -> invalid single product (Whey Protein Fusion Blend) check out test - too long phone (25 digits) (failed)
3.	// Test 009j -> invalid single product (Whey Protein Fusion Blend) check out test - too long address (100 chars) (failed)
4.  // Test 009k -> invalid single product (Whey Protein Fusion Blend) check out test - too long city (100 chars) (failed)

//invalid singular input format(delivery details)

1.	// Test 009l -> invalid single product (Whey Protein Fusion Blend) check out test - invalid full name format (special symbols only) (failed)
2.	// Test 009m -> invalid single product (Whey Protein Fusion Blend) check out test - invalid phone format (special symbols only) (failed)
3.	// Test 009n -> invalid single product (Whey Protein Fusion Blend) check out test - invalid address format (special symbols only) (failed)
4.	// Test 009o -> invalid single product (Whey Protein Fusion Blend) check out test - invalid city format (special symbols only) (failed)