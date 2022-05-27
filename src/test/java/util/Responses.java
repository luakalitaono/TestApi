package util;

import models.User;

import java.util.Arrays;
import java.util.List;

public final class Responses {

    public static final List<User> EXPECTED_USERS_PAGE_1 = Arrays.asList(
        new User(1, "george.bluth@reqres.in", "George", "Bluth","https://reqres.in/img/faces/1-image.jpg"),
        new User(2, "janet.weaver@reqres.in", "Janet", "Weaver","https://reqres.in/img/faces/2-image.jpg"),
        new User(3, "emma.wong@reqres.in", "Emma", "Wong", "https://reqres.in/img/faces/3-image.jpg"),
        new User(4, "eve.holt@reqres.in", "Eve", "Holt", "https://reqres.in/img/faces/4-image.jpg"),
        new User(5, "charles.morris@reqres.in", "Charles", "Morris", "https://reqres.in/img/faces/5-image.jpg"),
        new User(6, "tracey.ramos@reqres.in", "Tracey", "Ramos", "https://reqres.in/img/faces/6-image.jpg")
    );

    public static final List<User> EXPECTED_USERS_PAGE_2 = Arrays.asList(
        new User(7, "michael.lawson@reqres.in", "Michael", "Lawson","https://reqres.in/img/faces/7-image.jpg"),
        new User(8, "lindsay.ferguson@reqres.in", "Lindsay", "Ferguson","https://reqres.in/img/faces/8-image.jpg"),
        new User(9, "tobias.funke@reqres.in", "Tobias", "Funke", "https://reqres.in/img/faces/9-image.jpg"),
        new User(10, "byron.fields@reqres.in", "Byron", "Fields", "https://reqres.in/img/faces/10-image.jpg"),
        new User(11, "george.edwards@reqres.in", "George", "Edwards", "https://reqres.in/img/faces/11-image.jpg"),
        new User(12, "rachel.howell@reqres.in", "Rachel", "Howell", "https://reqres.in/img/faces/12-image.jpg")
    );

}
