package io.github.rokonrj403.pages;

import io.github.rokonrj403.pages.utilities.BasePage;

import com.microsoft.playwright.*;
import io.github.rokonrj403.pages.utilities.TestDataGenerator;

public class CheckoutPageInvalidSingularInput extends BasePage {

    //relevant web elements
    private final Locator checkoutPageDeliverySecFullNameInputField;
    private final Locator checkoutPageDeliverySecPhoneInputField;
    private final Locator checkoutPageDeliverySecAddressTextarea;
    private final Locator checkoutPageDeliverySecCityInputField;

    //valid input data(for remaining inputs)
    private String fullName;
    private String phone;
    private String email;
    private String address;
    private String city;

    //invalid singular input - no singular input
    private String noFullName;
    private String noPhone;
    private String noAddress;
    private String noCity;

    //invalid singular input - too short singular input
    private String tooShortFullName;
    private String tooShortPhone;
    private String tooShortAddress;
    private String tooShortCity;

    //invalid singular input - too long singular input
    private String tooLongFullName;
    private String tooLongPhone;
    private String tooLongAddress;
    private String tooLongCity;

    //invalid singular input - invalid singular input (special symbols only)
    private String invalidFullNameFormat;
    private String invalidPhoneFormat;
    private String invalidAddressFormat;
    private String invalidCityFormat;

    public CheckoutPageInvalidSingularInput(Page page) {
        super(page);

        this.checkoutPageDeliverySecFullNameInputField = page.locator("//input[@id='coName']");
        this.checkoutPageDeliverySecPhoneInputField = page.locator("//input[@id='coPhone']");
        this.checkoutPageDeliverySecAddressTextarea = page.locator("//textarea[@id='coAddress']");
        this.checkoutPageDeliverySecCityInputField = page.locator("//input[@id='coCity']");

    }

    //invalid checkout delivery input data getter - no full name
    public void invalidCheckoutDeliveryNoFullNameDataGetter(){

        noFullName = "";
        phone = TestDataGenerator.generatePhoneNumber(6);
        address = TestDataGenerator.generateRandomAddress(5);
        city = TestDataGenerator.getRandomCity();

        System.out.println("Invalid generated checkout delivery input data (no full name): " + "\n");

        logger.info("No full name : " + noFullName);
        logger.info("Valid generated checkout delivery phone (no full name): " + phone);
        logger.info("Valid generated checkout delivery address (no full name): " + address);
        logger.info("Valid generated checkout delivery city (no full name): " + city);

        System.out.println("\n");

    }

    //invalid checkout delivery input data getter - no phone
    public void invalidCheckoutDeliveryNoPhoneDataGetter(){

        fullName = TestDataGenerator.getRandomFirstName() + " " + TestDataGenerator.getRandomLastName();
        noPhone = "";
        address = TestDataGenerator.generateRandomAddress(5);
        city = TestDataGenerator.getRandomCity();

        System.out.println("Invalid generated checkout delivery input data (no phone): " + "\n");

        logger.info("Valid generated checkout delivery full name (no phone): " + fullName);
        logger.info("No phone : " + noPhone);
        logger.info("Valid generated checkout delivery address (no phone): " + address);
        logger.info("Valid generated checkout delivery city (no phone): " + city);

        System.out.println("\n");

    }

    //invalid checkout delivery input data getter - no address
    public void invalidCheckoutDeliveryNoAddressDataGetter(){

        fullName = TestDataGenerator.getRandomFirstName() + " " + TestDataGenerator.getRandomLastName();
        phone = TestDataGenerator.generatePhoneNumber(6);
        noAddress = "";
        city = TestDataGenerator.getRandomCity();

        System.out.println("Invalid generated checkout delivery input data (no address): " + "\n");

        logger.info("Valid generated checkout delivery full name (no address): " + fullName);
        logger.info("Valid generated checkout delivery phone (no address): " + phone);
        logger.info("No address : " + noAddress);
        logger.info("Valid generated checkout delivery city (no address): " + city);

        System.out.println("\n");

    }

    //invalid checkout delivery input data getter - no city
    public void invalidCheckoutDeliveryNoCityDataGetter(){

        fullName = TestDataGenerator.getRandomFirstName() + " " + TestDataGenerator.getRandomLastName();
        phone = TestDataGenerator.generatePhoneNumber(6);
        address = TestDataGenerator.generateRandomAddress(5);
        noCity = "";

        System.out.println("Invalid generated checkout delivery input data (no city): " + "\n");

        logger.info("Valid generated checkout delivery full name (no city): " + fullName);
        logger.info("Valid generated checkout delivery phone (no city): " + phone);
        logger.info("Valid generated checkout delivery address (no city): " + address);
        logger.info("No city : " + noCity);

        System.out.println("\n");

    }

    //invalid checkout delivery input data getter - too short full name (3 chars)
    public void invalidCheckoutDeliveryTooShortFullNameDataGetter(){

        tooShortFullName = "D S";
        phone = TestDataGenerator.generatePhoneNumber(6);
        address = TestDataGenerator.generateRandomAddress(5);
        city = TestDataGenerator.getRandomCity();

        System.out.println("Invalid generated checkout delivery input data (too short full name): " + "\n");

        logger.info("Too short full name : " + tooShortFullName);
        logger.info("Valid generated checkout delivery phone (too short full name): " + phone);
        logger.info("Valid generated checkout delivery address (too short full name): " + address);
        logger.info("Valid generated checkout delivery city (too short full name): " + city);

        System.out.println("\n");

    }

    //invalid checkout delivery input data getter - too short phone (2 digits)
    public void invalidCheckoutDeliveryTooShortPhoneDataGetter(){

        fullName = TestDataGenerator.getRandomFirstName() + " " + TestDataGenerator.getRandomLastName();
        tooShortPhone = "54";
        address = TestDataGenerator.generateRandomAddress(5);
        city = TestDataGenerator.getRandomCity();

        System.out.println("Invalid generated checkout delivery input data (too short phone): " + "\n");

        logger.info("Valid generated checkout delivery full name (too short phone): " + fullName);
        logger.info("Too short phone : " + tooShortPhone);
        logger.info("Valid generated checkout delivery address (too short phone): " + address);
        logger.info("Valid generated checkout delivery city (too short phone): " + city);

        System.out.println("\n");

    }

    //invalid checkout delivery input data getter - too short address (3 chars)
    public void invalidCheckoutDeliveryTooShortAddressDataGetter(){

        fullName = TestDataGenerator.getRandomFirstName() + " " + TestDataGenerator.getRandomLastName();
        phone = TestDataGenerator.generatePhoneNumber(6);
        tooShortAddress = "3Dg";
        city = TestDataGenerator.getRandomCity();

        System.out.println("Invalid generated checkout delivery input data (too short address): " + "\n");

        logger.info("Valid generated checkout delivery full name (too short address): " + fullName);
        logger.info("Valid generated checkout delivery phone (too short address): " + phone);
        logger.info("Too short address : " + tooShortAddress);
        logger.info("Valid generated checkout delivery city (too short address): " + city);

        System.out.println("\n");

    }

    //invalid checkout delivery input data getter - too short city (2 chars)
    public void invalidCheckoutDeliveryTooShortCityDataGetter(){

        fullName = TestDataGenerator.getRandomFirstName() + " " + TestDataGenerator.getRandomLastName();
        phone = TestDataGenerator.generatePhoneNumber(6);
        address = TestDataGenerator.generateRandomAddress(5);
        tooShortCity = "Cf";

        System.out.println("Invalid generated checkout delivery input data (too short city): " + "\n");

        logger.info("Valid generated checkout delivery full name (too short city): " + fullName);
        logger.info("Valid generated checkout delivery phone (too short city): " + phone);
        logger.info("Valid generated checkout delivery address (too short city): " + address);
        logger.info("Too short city : " + tooShortCity);

        System.out.println("\n");

    }

    //invalid checkout delivery input data getter - too long full name (200 chars)
    public void invalidCheckoutDeliveryTooLongFullNameDataGetter(){

        tooLongFullName = "Dbnhfghfghfghfghfghfghfghfghvbcvxcbvfghfhjftytryrtyhgffdghgfhjgfjgfhjghjghjghjghjghjghjghjghjghjghj Sfhfghjghfhvcgfhgjytiuioooplklkhjgghgfbcbvcxbvfdfghfdgewrwqrqerwtryfgdgfdhfghjfghbcvfdgfdhgfghfghftg";
        phone = TestDataGenerator.generatePhoneNumber(6);
        address = TestDataGenerator.generateRandomAddress(5);
        city = TestDataGenerator.getRandomCity();

        System.out.println("Invalid generated checkout delivery input data (too long full name): " + "\n");

        logger.info("Too long full name : " + tooLongFullName);
        logger.info("Valid generated checkout delivery phone (too long full name): " + phone);
        logger.info("Valid generated checkout delivery address (too long full name): " + address);
        logger.info("Valid generated checkout delivery city (too long full name): " + city);

        System.out.println("\n");

    }

    //invalid checkout delivery input data getter - too long phone (25 digits)
    public void invalidCheckoutDeliveryTooLongPhoneDataGetter(){

        fullName = TestDataGenerator.getRandomFirstName() + " " + TestDataGenerator.getRandomLastName();
        tooLongPhone = TestDataGenerator.generatePhoneNumber(20);
        address = TestDataGenerator.generateRandomAddress(5);
        city = TestDataGenerator.getRandomCity();

        System.out.println("Invalid generated checkout delivery input data (too long phone): " + "\n");

        logger.info("Valid generated checkout delivery full name (too long phone): " + fullName);
        logger.info("Too long phone : " + tooLongPhone);
        logger.info("Valid generated checkout delivery address (too long phone): " + address);
        logger.info("Valid generated checkout delivery city (too long phone): " + city);

        System.out.println("\n");

    }

    //invalid checkout delivery input data getter - too long address (100 chars)
    public void invalidCheckoutDeliveryTooLongAddressDataGetter(){

        fullName = TestDataGenerator.getRandomFirstName() + " " + TestDataGenerator.getRandomLastName();
        phone = TestDataGenerator.generatePhoneNumber(8);
        tooLongAddress = TestDataGenerator.generateRandomAddress(94);
        city = TestDataGenerator.getRandomCity();

        System.out.println("Invalid generated checkout delivery input data (too long address): " + "\n");

        logger.info("Valid generated checkout delivery full name (too long address): " + fullName);
        logger.info("Valid generated checkout delivery phone (too long address): " + phone);
        logger.info("Too long address : " + tooLongAddress);
        logger.info("Valid generated checkout delivery city (too long address): " + city);

        System.out.println("\n");

    }

    //invalid checkout delivery input data getter - too long city (100 chars)
    public void invalidCheckoutDeliveryTooLongCityDataGetter(){

        fullName = TestDataGenerator.getRandomFirstName() + " " + TestDataGenerator.getRandomLastName();
        phone = TestDataGenerator.generatePhoneNumber(6);
        address = TestDataGenerator.generateRandomAddress(5);
        tooLongCity = "Dbnhfghfghfghfghfghfghfghfghvbcvxcbvfghfhjftytryrtyhgffdghgfhjgfjgfhjghjghjghjghjghjghjghjghjghjghjf";

        System.out.println("Invalid generated checkout delivery input data (too long city): " + "\n");

        logger.info("Valid generated checkout delivery full name (too long city): " + fullName);
        logger.info("Valid generated checkout delivery phone (too long city): " + phone);
        logger.info("Valid generated checkout delivery address (too long city): " + address);
        logger.info("Too long city : " + tooLongCity);

        System.out.println("\n");

    }

    //invalid checkout delivery input data getter - invalid full name format (special symbols only)
    public void invalidCheckoutDeliveryInvalidFullNameFormatDataGetter(){

        invalidFullNameFormat = "@#%$$#@ $#$%^$#";
        phone = TestDataGenerator.generatePhoneNumber(6);
        address = TestDataGenerator.generateRandomAddress(5);
        city = TestDataGenerator.getRandomCity();

        System.out.println("Invalid generated checkout delivery input data (invalid full name format): " + "\n");

        logger.info("Invalid full name format : " + invalidFullNameFormat);
        logger.info("Valid generated checkout delivery phone (invalid full name format): " + phone);
        logger.info("Valid generated checkout delivery address (invalid full name format): " + address);
        logger.info("Valid generated checkout delivery city (invalid full name format): " + city);

        System.out.println("\n");

    }

    //invalid checkout delivery input data getter - invalid phone format (special symbols only)
    public void invalidCheckoutDeliveryInvalidPhoneFormatDataGetter(){

        fullName = TestDataGenerator.getRandomFirstName() + " " + TestDataGenerator.getRandomLastName();
        invalidPhoneFormat = "$#%^$%";
        address = TestDataGenerator.generateRandomAddress(5);
        city = TestDataGenerator.getRandomCity();

        System.out.println("Invalid generated checkout delivery input data (invalid phone format): " + "\n");

        logger.info("Valid generated checkout delivery full name (invalid phone format): " + fullName);
        logger.info("Invalid phone format : " + invalidPhoneFormat);
        logger.info("Valid generated checkout delivery address (invalid phone format): " + address);
        logger.info("Valid generated checkout delivery city (invalid phone format): " + city);

        System.out.println("\n");

    }

    //invalid checkout delivery input data getter - invalid address format (special symbols only)
    public void invalidCheckoutDeliveryInvalidAddressFormatDataGetter(){

        fullName = TestDataGenerator.getRandomFirstName() + " " + TestDataGenerator.getRandomLastName();
        phone = TestDataGenerator.generatePhoneNumber(8);
        invalidAddressFormat = "$#%^%&%^&";
        city = TestDataGenerator.getRandomCity();

        System.out.println("Invalid generated checkout delivery input data (invalid address format): " + "\n");

        logger.info("Valid generated checkout delivery full name (invalid address format): " + fullName);
        logger.info("Valid generated checkout delivery phone (invalid address format): " + phone);
        logger.info("Invalid address format : " + invalidAddressFormat);
        logger.info("Valid generated checkout delivery city (invalid address format): " + city);

        System.out.println("\n");

    }

    //invalid checkout delivery input data getter - invalid city format (special symbols only)
    public void invalidCheckoutDeliveryInvalidCityFormatDataGetter(){

        fullName = TestDataGenerator.getRandomFirstName() + " " + TestDataGenerator.getRandomLastName();
        phone = TestDataGenerator.generatePhoneNumber(6);
        address = TestDataGenerator.generateRandomAddress(5);
        invalidCityFormat = "#%$$%^%";

        System.out.println("Invalid generated checkout delivery input data (invalid city format): " + "\n");

        logger.info("Valid generated checkout delivery full name (invalid city format): " + fullName);
        logger.info("Valid generated checkout delivery phone (invalid city format): " + phone);
        logger.info("Valid generated checkout delivery address (invalid city format): " + address);
        logger.info("Invalid city format : " + invalidCityFormat);

        System.out.println("\n");

    }

    //invalid input data methods - no singular input
    public void inputNoFullNameIntoFullNameInputField(){checkoutPageDeliverySecFullNameInputField.fill(noFullName);}
    public void inputNoPhoneIntoPhoneInputField(){checkoutPageDeliverySecPhoneInputField.fill(noPhone);}
    public void inputNoAddressIntoAddressTextarea(){checkoutPageDeliverySecAddressTextarea.fill(noAddress);}
    public void inputNoCityIntoCityInputField(){checkoutPageDeliverySecCityInputField.fill(noCity);}

    //valid input data methods - too short singular input
    public void inputTooShortFullNameIntoFullNameInputField(){checkoutPageDeliverySecFullNameInputField.fill(tooShortFullName);}
    public void inputTooShortPhoneIntoPhoneInputField(){checkoutPageDeliverySecPhoneInputField.fill(tooShortPhone);}
    public void inputTooShortAddressIntoAddressTextarea(){checkoutPageDeliverySecAddressTextarea.fill(tooShortAddress);}
    public void inputTooShortCityIntoCityInputField(){checkoutPageDeliverySecCityInputField.fill(tooShortCity);}

    //valid input data methods - too long singular input
    public void inputTooLongFullNameIntoFullNameInputField(){checkoutPageDeliverySecFullNameInputField.fill(tooLongFullName);}
    public void inputTooLongPhoneIntoPhoneInputField(){checkoutPageDeliverySecPhoneInputField.fill(tooLongPhone);}
    public void inputTooLongAddressIntoAddressTextarea(){checkoutPageDeliverySecAddressTextarea.fill(tooLongAddress);}
    public void inputTooLongCityIntoCityInputField(){checkoutPageDeliverySecCityInputField.fill(tooLongCity);}

    //valid input data methods - invalid singular input
    public void inputInvalidFullNameFormatIntoFullNameInputField(){checkoutPageDeliverySecFullNameInputField.fill(invalidFullNameFormat);}
    public void inputInvalidPhoneFormatIntoPhoneInputField(){checkoutPageDeliverySecPhoneInputField.fill(invalidPhoneFormat);}
    public void inputInvalidAddressFormatIntoAddressTextarea(){checkoutPageDeliverySecAddressTextarea.fill(invalidAddressFormat);}
    public void inputInvalidCityFormatIntoCityInputField(){checkoutPageDeliverySecCityInputField.fill(invalidCityFormat);}

    //valid input data methods (for remaining input)
    public void inputFullNameIntoFullNameInputField(){checkoutPageDeliverySecFullNameInputField.fill(fullName);}
    public void inputPhoneIntoPhoneInputField(){checkoutPageDeliverySecPhoneInputField.fill(phone);}
    public void inputAddressIntoAddressTextarea(){checkoutPageDeliverySecAddressTextarea.fill(address);}
    public void inputCityIntoCityInputField(){checkoutPageDeliverySecCityInputField.fill(city);}

}