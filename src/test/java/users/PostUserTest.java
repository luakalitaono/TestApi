package users;

import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import models.User;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static util.ApiAddress.ADDRESS;

public class PostUserTest {

    @Test
    public void test_post_user () {
        User user = new User(0, "user1@email.com", "User1", "Test1", "avatar/me/1");
        final RequestSpecification request = given()
            .header("Content-Type", "application/json")
            .body(user);

        final ValidatableResponse response = request
            .post(ADDRESS + "/users")
            .then();

        request.log().body();
        response.log().body();
        response.statusCode(201);
        response.body(
            "id", notNullValue(),
            "email", equalTo(user.getEmail()),
            "firstName", equalTo(user.getFirstName()),
            "lastName", equalTo(user.getLastName()),
            "avatar", equalTo(user.getAvatar()),
            "createdAt", notNullValue()
        );
    }

}
