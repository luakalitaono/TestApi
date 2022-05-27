package users;

import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.*;
import static util.Responses.EXPECTED_USERS_PAGE_1;
import static util.Responses.EXPECTED_USERS_PAGE_2;
import static util.ApiAddress.ADDRESS;
import static util.TestVerifyUtil.verifyUser;

public class GetUsersListTest {

    @Test
    public void test_get_users_list_in_page1() {
        final ValidatableResponse response = when()
            .get(ADDRESS + "/users?page={page}", 1)
            .then();
        response.log().body();
        response.statusCode(200);
        response.body("page", equalTo(1));
        response.body("per_page", equalTo(EXPECTED_USERS_PAGE_1.size()));
        response.body("total", equalTo(12));
        response.body("total_pages", equalTo(2));

        for (int i = 0; i < EXPECTED_USERS_PAGE_1.size(); i++) {
            verifyUser(response, "data[" + i + "].", EXPECTED_USERS_PAGE_1.get(i));
        }
    }

    @Test
    public void test_get_users_list_in_page2() {
        final ValidatableResponse response = when()
            .get(ADDRESS + "/users?page={page}", 2)
            .then();
        response.log().body();
        response.statusCode(200);
        response.body("page", equalTo(2));
        response.body("per_page", equalTo(EXPECTED_USERS_PAGE_2.size()));
        response.body("total", equalTo(12));
        response.body("total_pages", equalTo(2));

        for (int i = 0; i < EXPECTED_USERS_PAGE_2.size(); i++) {
            verifyUser(response, "data[" + i + "].", EXPECTED_USERS_PAGE_2.get(i));
        }
    }

    @Test
    public void test_get_users_list_in_page3() {
        final ValidatableResponse response = when()
            .get(ADDRESS + "/users?page={page}", 3)
            .then();
        response.log().body();
        response.statusCode(200);
        response.body("page", equalTo(3));
        response.body("data", is(empty()));
    }

}
