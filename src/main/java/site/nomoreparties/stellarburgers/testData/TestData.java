package site.nomoreparties.stellarburgers.testData;

import org.apache.commons.lang3.RandomStringUtils;

public class TestData {
    private final String NAME_REAL = "Andrey";
    private final String EMAIL = String.format("%s@yandex.ru", RandomStringUtils.randomAlphanumeric(10));
    private final String EMAIL_REAL = "greenolls180885@yandex.ru";
    private final String PASSWORD_REAL = "180885";
    private final String PASSWORD = RandomStringUtils.randomAlphanumeric(6);
    private final String BUNS = "Булки";
    private final String SOUSE = "Соусы";
    private final String FILLING = "Начинки";

    public String getEMAIL() {
        return EMAIL;
    }
    public String getPASSWORD() {
        return PASSWORD;
    }
    public String getNAME_REAL() {
        return NAME_REAL;
    }
    public String getEMAIL_REAL() {
        return EMAIL_REAL;
    }
    public String getPASSWORD_REAL() {
        return PASSWORD_REAL;
    }
    public String generateRandomLengthString(int length) {
        return RandomStringUtils.randomAlphanumeric(length);
    }
    public String getBUNS() {
        return BUNS;
    }
    public String getSOUSE() {
        return SOUSE;
    }
    public String getFILLING() {
        return FILLING;
    }

}
