package de.hsos;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class GreetingResourceTest {


    // Check Init Data
    @Test
    public void testGet() {

        String expected = "[{\"id\":\"1\",\"ingredients\":[{\"name\":\"Ice Cubes\",\"quantity\":3},{\"name\":\"Gin\",\"quantity\":1},{\"name\":\"Tonic Water\",\"quantity\":1},{\"name\":\"Lemon\",\"quantity\":1}],\"name\":\"Gin Tonic\"},{\"id\":\"2\",\"ingredients\":[{\"name\":\"Ice Cubes\",\"quantity\":2},{\"name\":\"Soda\",\"quantity\":1},{\"name\":\"Woodruff\",\"quantity\":1}],\"name\":\"Thirst Zapper\"},{\"id\":\"3\",\"ingredients\":[{\"name\":\"Orange\",\"quantity\":2},{\"name\":\"Soda\",\"quantity\":1},{\"name\":\"Pineapple Juice\",\"quantity\":1}],\"name\":\"Carl Wheezer\"}]";

        given()
                .when().get("/mocktails")
                .then()
                .statusCode(200)
                .body(is(expected));
    }

    // Check init Entry 1
    @Test
    public void testGet1() {

        String expected = "{\"id\":\"1\",\"ingredients\":[{\"name\":\"Ice Cubes\",\"quantity\":3},{\"name\":\"Gin\",\"quantity\":1},{\"name\":\"Tonic Water\",\"quantity\":1},{\"name\":\"Lemon\",\"quantity\":1}],\"name\":\"Gin Tonic\"}";

        given()
                .when().get("/mocktails/1")
                .then()
                .statusCode(200)
                .body(is(expected));
    }

    @Test
    public void testGet2() {

        String expected = "{\"id\":\"2\",\"ingredients\":[{\"name\":\"Ice Cubes\",\"quantity\":2},{\"name\":\"Soda\",\"quantity\":1},{\"name\":\"Woodruff\",\"quantity\":1}],\"name\":\"Thirst Zapper\"}";

        given()
                .when().get("/mocktails/2")
                .then()
                .statusCode(200)
                .body(is(expected));

    }

    @Test
    public void testGet3() {
        String expected = "{\"id\":\"3\",\"ingredients\":[{\"name\":\"Orange\",\"quantity\":2},{\"name\":\"Soda\",\"quantity\":1},{\"name\":\"Pineapple Juice\",\"quantity\":1}],\"name\":\"Carl Wheezer\"}";

        given()
                .when().get("/mocktails/3")
                .then()
                .statusCode(200)
                .body(is(expected));
    }

    @Test
    public void deleteMocktail() {

        // Delete Entry
        given()
                .when()
                .delete("/mocktails/2")
                .then()
                .statusCode(204) //Source: https://stackoverflow.com/questions/2342579/http-status-code-for-update-and-delete#:~:text=For%20a%20DELETE%20request%3A%20HTTP,but%20not%20fully%20applied%20yet.
                .body(is(""));

        // Check if Deleted Body is Empty
        given()
                .when()
                .get("/mocktails/2")
                .then()
                .statusCode(200) // 200 OK
                .body(is(""));

    }

    /**
     * Fragen wie man Add prueft?
     */
    @Test
    public void addMocktail() {
        String query = "mocktails?mocktailName=Test&mocktailId=10";
        String expected = "{\"id\":\"10\",\"ingredients\":[],\"name\":\"Test\"}";

        given()
                .contentType("application/json").body(expected)
                .when()
                .post(query)
                .then()
                .statusCode(200) // 200 = created
                .body(is(expected));
    }

    @Test
    public void deleteIngredient() {
        String query = "mocktails?id=1&index=1";
        String expected = "{\"id\":\"1\",\"ingredients\":[{\"name\":\"Ice Cubes\",\"quantity\":3},{\"name\":\"Tonic Water\",\"quantity\":1},{\"name\":\"Lemon\",\"quantity\":1}],\"name\":\"Gin Tonic\"}";

        given()
                .when()
                .delete(query)
                .then()
                .statusCode(204)
                .body(is(""));


        given()
                .when()
                .get("/mocktails/1")
                .then()
                .statusCode(200)
                .body(is(expected));
    }

    // Fragen wie man das fixt....
    @Test
    public void updateMocktail() {
        String query = "mocktails/1?newName=neuerName";
        String expected = "{\"id\":\"1\",\"ingredients\":[{\"name\":\"Ice Cubes\",\"quantity\":3},{\"name\":\"Gin\",\"quantity\":1},{\"name\":\"Tonic Water\",\"quantity\":1},{\"name\":\"Lemon\",\"quantity\":1}],\"name\":\"neuerName\"}";
        
        given()
                .when()
                .put(query)
                .then()
                .statusCode(200)
                .body(is(expected));
    }


}