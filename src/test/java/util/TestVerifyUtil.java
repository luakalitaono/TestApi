package util;

import io.restassured.response.ValidatableResponse;
import models.User;

import static org.hamcrest.Matchers.equalTo;

public final class TestVerifyUtil {


    public static void verifyUser(ValidatableResponse response, String prefix, User user) {
        response.body(
            prefix + "id", equalTo(user.getId()),
            prefix + "email", equalTo(user.getEmail()),
            prefix + "first_name", equalTo(user.getFirstName()),
            prefix + "last_name", equalTo(user.getLastName()),
            prefix + "avatar", equalTo(user.getAvatar())
        );
    }

}
