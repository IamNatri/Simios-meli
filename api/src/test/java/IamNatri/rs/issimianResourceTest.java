package IamNatri.rs;

import org.junit.jupiter.api.Test;

import io.quarkus.logging.Log;
import io.quarkus.test.junit.QuarkusTest;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class issimianResourceTest {
    @Test
    void testVerticalValidation() {
        var requestBody = """
            {"dna":["ATGC","ATGC","ATGC","CCCC"]}
            """;

        isSimian(requestBody, 200);
    }

    private void isSimian(String requestBody, int expectedCode) {
        given().contentType("application/json")
                .body(requestBody)
                .when().post("/simian")
                .then()
                .statusCode(expectedCode);
    }

}
