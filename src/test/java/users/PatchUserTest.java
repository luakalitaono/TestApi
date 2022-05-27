package users;

import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static util.ApiAddress.ADDRESS;

public class PatchUserTest {

    @Test
    public void test_patch_user_email() {
        final ValidatableResponse response = given()
                .header("Content-Type", "application/json")
                .body("{ \"email\": \"testpatch@email.com\" }")
                .patch(ADDRESS + "/users/{id}", 2)
                .then();
        response.statusCode(200);
        response.body(
                "email", equalTo("testpatch@email.com"),
                "updatedAt", notNullValue()
        );
    }

    @Test
    public void test_patch_user_first_name() {
        final ValidatableResponse response = given()
                .header("Content-Type", "application/json")
                .body("{ \"first_name\": \"User3\" }")
                .patch(ADDRESS + "/users/{id}", 3)
                .then();
        response.statusCode(200);
        response.body(
                "first_name", equalTo("User3"),
                "updatedAt", notNullValue()
        );
    }

    @Test
    public void test_patch_user_last_name() {
        final ValidatableResponse response = given()
                .header("Content-Type", "application/json")
                .body("{ \"last_name\": \"Test4\" }")
                .patch(ADDRESS + "/users/{id}", 4)
                .then();
        response.statusCode(200);
        response.body(
                "last_name", equalTo("Test4"),
                "updatedAt", notNullValue()
        );
    }

    @Test
    public void test_patch_user_avatar() {
        final ValidatableResponse response = given()
                .header("Content-Type", "application/json")
                .body("{ \"avatar\": \"avatar/me/5\" }")
                .patch(ADDRESS + "/users/{id}", 5)
                .then();
        response.statusCode(200);
        response.body(
                "avatar", equalTo("avatar/me/5"),
                "updatedAt", notNullValue()
        );
    }

}
