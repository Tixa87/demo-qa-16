package pages.components;

import java.util.Random;

public class RandomGenerator {
    public static String randomUserGender() {
        String[] gender = {"Other", "Male", "Female"};
        String random = (gender[new Random().nextInt(gender.length)]);
        return random;
    }

    public static String randomUserSub() {
        String[] subject = {"Math", "Biology", "Geography"};
        String random = (subject[new Random().nextInt(subject.length)]);
        return random;
    }

    public static String randomUserHobby() {
        String[] hobby = {"Sports", "Reading", "Music"};
        String random = (hobby[new Random().nextInt(hobby.length)]);
        return random;
    }

    public static String randomBirthMonth() {
        String[] month = {"January", "February", "March", "April", "May", "June"};
        String random = (month[new Random().nextInt(month.length)]);
        return random;
    }

}
