package io.github.rokonrj403.pages.utilities;

import com.microsoft.playwright.Page;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.*;

public class TestDataGenerator extends BasePage{

    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    //private static final String DIGITS = "0123456789";
    //private static final String SPECIAL = "!@#$%^&*()_+-=[]{}|;:,.<>?";

    private static final Random RANDOM = new SecureRandom();

    private static String storedFirstName;
    private static String storedLastName;
    //private static String emailAddress;
    //private static String password;
    //private static String storedReview;

    public TestDataGenerator(Page page) {super(page);}

    // first names array
    private static final String[] firstNames = {
            "Aiden", "Liam", "Noah", "Elijah", "Lucas", "Mason", "Ethan", "James", "Benjamin", "Jack",
            "Henry", "Alexander", "Jackson", "Sebastian", "Owen", "Matthew", "William", "Joseph", "Luke", "Daniel",
            "Logan", "David", "Samuel", "John", "Ryan", "Leo", "Nathan", "Isaac", "Joshua", "Caleb",
            "Olivia", "Emma", "Ava", "Sophia", "Isabella", "Mia", "Amelia", "Harper", "Evelyn", "Abigail",
            "Ella", "Avery", "Scarlett", "Grace", "Lily", "Chloe", "Zoey", "Penelope", "Hannah", "Aria",
            "Ellie", "Madison", "Nora", "Riley", "Lillian", "Paisley", "Aurora", "Addison", "Brooklyn", "Leah",
            "Savannah", "Sofia", "Lucy", "Victoria", "Willow", "Violet", "Zoe", "Stella", "Hazel", "Emilia",
            "Claire", "Bella", "Maya", "Elena", "Piper", "Ariana", "Ruby", "Madelyn", "Alice", "Skylar",
            "Hunter", "Andrew", "Connor", "Carter", "Eli", "Wyatt", "Dylan", "Grayson", "Landon", "Gabriel",
            "Jayden", "Anthony", "Christian", "Julian", "Aaron", "Dominic", "Adam", "Evan", "Nicholas", "Isaiah"
    };

    //last names array
    private static final String[] lastNames = {
            "Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller", "Wilson", "Moore", "Taylor",
            "Anderson", "Thomas", "Jackson", "White", "Harris", "Martin", "Thompson", "Garcia", "Martinez", "Robinson",
            "Clark", "Rodriguez", "Lewis", "Lee", "Walker", "Hall", "Allen", "Young", "King", "Wright",
            "Scott", "Torres", "Nguyen", "Hill", "Flores", "Green", "Adams", "Nelson", "Baker", "Gonzalez",
            "Carter", "Mitchell", "Perez", "Roberts", "Turner", "Phillips", "Campbell", "Parker", "Evans", "Edwards",
            "Collins", "Stewart", "Sanchez", "Morris", "Rogers", "Reed", "Cook", "Morgan", "Bell", "Murphy",
            "Bailey", "Rivera", "Cooper", "Richardson", "Cox", "Howard", "Ward", "Torres", "Peterson", "Gray",
            "Ramirez", "James", "Watson", "Brooks", "Kelly", "Sanders", "Price", "Bennett", "Wood", "Barnes",
            "Ross", "Henderson", "Coleman", "Jenkins", "Perry", "Powell", "Long", "Patterson", "Hughes", "Flores",
            "Washington", "Butler", "Simmons", "Foster", "Gonzales", "Bryant", "Alexander", "Russell", "Griffin", "Diaz",
            "Hayes", "Myers", "Ford", "Hamilton", "Graham", "Sullivan", "Wallace", "Woods", "Cole", "West",
            "Jordan", "Owens", "Reynolds", "Fisher", "Ellis", "Harrison", "Gibson", "McDonald", "Cruz", "Marshall"
    };

    // array of Illinois state cities
    private static final String[] ILLINOIS_CITIES = {
            "Chicago", "Aurora", "Naperville", "Joliet", "Rockford", "Springfield",
            "Elgin", "Peoria", "Champaign", "Waukegan", "Cicero", "Bloomington",
            "Arlington Heights", "Evanston", "Decatur", "Schaumburg", "Bolingbrook",
            "Palatine", "Skokie", "Des Plaines", "Orland Park", "Tinley Park",
            "Oak Lawn", "Berwyn", "Mount Prospect", "Normal", "Wheaton", "Hoffman Estates",
            "Oak Park", "Downers Grove", "Elmhurst", "Glenview", "DeKalb", "Lombard",
            "Moline", "Buffalo Grove", "Bartlett", "Urbana", "Crystal Lake", "Quincy",
            "Streamwood", "Carol Stream", "Romeoville", "Plainfield", "Hanover Park",
            "Carpentersville", "Wheeling", "Park Ridge", "Addison", "Calumet City"
    };

    //Illinois street types array
    private static final String[] STREET_TYPES = {"St.", "Ave.", "Blvd.", "Rd.", "Ln.", "Dr.", "Ct.", "Pl."};

    //random first name picker method
    public static String getRandomFirstName() {
        if (storedFirstName == null) {
            Random random = new Random();
            storedFirstName = firstNames[random.nextInt(firstNames.length)];
        }
        return storedFirstName;
    }
    //random last name picker method
    public static String getRandomLastName() {
        if (storedLastName == null) {
            Random random = new Random();
            storedLastName = lastNames[random.nextInt(lastNames.length)];
        }
        return storedLastName;
    }

    //generate random string methods
    private static String generateRandomString(String characters, int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = RANDOM.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }

    private static String shuffleString(String string) {
        List<String> letters = Arrays.asList(string.split(""));
        Collections.shuffle(letters);
        return String.join("", letters);
    }


    //string generator methods
    //private static String generateRandomNumberString(int length) {return generateRandomString(DIGITS, length);}

    //private static String generateRandomSpecialString(int length) {return generateRandomString(SPECIAL, length);}

    //random email generator
    public static String generateRandomEmailAddress(int length) {
        String emailAddress = generateRandomString(UPPER + LOWER, length);
        char randomChar;
        Random rand = new Random();
        //generate random character that asserts uniqueness
        if (rand.nextBoolean()) {
            randomChar = (char) ('A' + rand.nextInt(26)); //uppercase A-Z
        } else {
            randomChar = (char) ('a' + rand.nextInt(26)); //lowercase a-z
        }
        return emailAddress + randomChar + "@example.com";
    }

    //random too short email generator
    public static String generateRandomTooShortEmailAddress(int length) {
        String emailAddress = generateRandomString(UPPER + LOWER, length);
        return emailAddress + "@z.com";
    }
    //random too long email generator
    public static String generateRandomTooLongEmailAddress(int length) {
        String emailAddress = generateRandomString(UPPER + LOWER, length);
        return emailAddress + "@esddsadwsdfghfafrujkuykmjnsfdasffdgjmyuhuyujhrgfsfdsgfgjukyyhggfsfdjgkyuoitrtweqeqwetryiydsfgjfgfsag.com";
    }

    //random phone number generator
    public static String generatePhoneNumber(int length) {
        if (length < 1) {throw new IllegalArgumentException("Phone number length must be at least 1.");}

        Random random = new Random();
        String phoneNumber = "";
        //generate the specified number of random digits
        for (int i = 0; i < length; i++) {
            phoneNumber += random.nextInt(10); //generate a random digit (0-9)
        }
        return phoneNumber;
    }

    //random password generator
    public static String generateRandomPassword() {
        String numbers = "0123456789";
//        String special = "!@#$%^&*()_+-=[]{}|;:,.<>?";

        //fixed password part
        String stokerPart = "Stoker";

        //random numeric sequence
        StringBuilder numericPart = new StringBuilder();
        numericPart.append(numbers.charAt(RANDOM.nextInt(numbers.length())));
        numericPart.append(numbers.charAt(RANDOM.nextInt(numbers.length())));
        numericPart.append(numbers.charAt(RANDOM.nextInt(numbers.length())));
        numericPart.append('_'); // Static underscore

        //shuffle the numeric part
        String shuffledNumericPart = shuffleString(numericPart.toString());

        //"Stoker" + shuffled numeric part
        StringBuilder password = new StringBuilder();
        password.append(stokerPart);
        password.append(shuffledNumericPart);

        return password.toString();
    }

    //generate a random address with a given length for the street name
    public static String generateRandomAddress(int length) {
        int streetNumber = RANDOM.nextInt(9999) + 1; // street number between 1 and 9999
        String streetName = generateRandomString("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz", length);
        String streetType = STREET_TYPES[RANDOM.nextInt(STREET_TYPES.length)];
        return streetNumber + " " + streetName + " " + streetType;
    }

    // cities rnd instance
    private static final Random rndIllinoisCities = new Random();

    // method to get a random city from the array
    public static String getRandomCity() {
        int index = rndIllinoisCities.nextInt(ILLINOIS_CITIES.length);
        return ILLINOIS_CITIES[index];
    }

    // generate random postal code for Illinois
    public static int getRandomPostalCode() {
        return 60000 + RANDOM.nextInt(30000);
    }

    public static String generateExpirationDate() {
        // Get current date
        LocalDate now = LocalDate.now();
        int currentYear = now.getYear();
        int currentMonth = now.getMonthValue();

        Random random = new Random();

        // Generate random month (1-12)
        int month = random.nextInt(12) + 1;

        // Generate random year (current year to current year + 10)
        int year = currentYear + random.nextInt(11);

        // If the generated year is the current year, make sure the month is not in the past
        if (year == currentYear && month < currentMonth) {
            month = currentMonth + random.nextInt(13 - currentMonth);
        }

        // Format as MM/YY
        return String.format("%02d/%02d", month, year % 100);
    }

    public static String generateCVV() {
        Random random = new Random();
        return String.format("%03d", random.nextInt(1000));
    }

}