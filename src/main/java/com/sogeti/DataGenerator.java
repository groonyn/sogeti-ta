package com.sogeti;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * Provides class for data generation needs.
 *
 * @author <a href="mailto:groonyn@gmail.com">Nikolai Grunin</a>
 */
public class DataGenerator {
    private static final String ALPHABETS = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMBERS = "1234567890";
    private static final String SPECIAL_CHARACTERS = "_-.";
    private static final String EMAIL_TAIL = "@test.org";

    /**
     * Generates random String with specific length in random manner.
     *
     * @param length the length of string to be generated
     */
    public static String generateRandomString(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }

    /**
     * Generates random String of numbers with specific length in random manner.
     *
     * @param length the length of string to be generated
     */
    public static String generateRandomNumber(int length) {
        return RandomStringUtils.randomNumeric(length);
    }

    /**
     * Generates random String of email with specific length in random manner.
     *
     * @param length the length of string to be generated
     */
    public static String generateEmail(int length) {
        String allowedChars = ALPHABETS + NUMBERS + SPECIAL_CHARACTERS;
        String email;
        String temp = RandomStringUtils.random(length, allowedChars);
        email = temp.substring(0, temp.length() - 9) + EMAIL_TAIL;
        return email;
    }
}
