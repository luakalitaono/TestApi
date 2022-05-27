package users;

import io.restassured.response.ValidatableResponse;
import models.User;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.*;
import static util.Responses.EXPECTED_USERS_PAGE_1;
import static util.ApiAddress.ADDRESS;
import static util.TestVerifyUtil.verifyUser;

public class GetSingleUserTest {

    @Test
    public void test_get_single_user () {
        final User expected = EXPECTED_USERS_PAGE_1.get(1);
        final ValidatableResponse response = when()
            .get(ADDRESS + "/users/{id}", 2)
            .then();
        response.log().body();
        response.statusCode(200);
        verifyUser(response,"data.", expected);
    }

    @Test
    public void test_get_single_user_not_found () {
        final ValidatableResponse response = when()
            .get(ADDRESS + "/users/{id}", 23)
            .then();
        response.statusCode(404);
        response.body("isEmpty()", is(true));
    }


}
