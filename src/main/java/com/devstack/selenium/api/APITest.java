package com.devstack.selenium.api;

import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class APITest {

    private String token;

    @BeforeClass
    public void setup() {
        baseURI = "https://qa-library.zeoit.com/api/";

        String creds = "{\n" +
                "  \"email\": \"super@admin.com\",\n" +
                "  \"password\": \"password\"\n" +
                "}";

        token = given()
                .contentType(ContentType.JSON)
                .body(creds)
                .when()
                .post("auth/login")
                .then()
                .statusCode(200)
                .extract()
                .path("token");
    }

    @Test
    public void testLogin() {
        given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get("auth/me")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void testLoginToken() {
        System.out.println("Token: " + token);
    }

    @Test
    public void getUserDetails() {
        given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get("auth/me")
                .then()
                .statusCode(200)
                .body("data.email", org.hamcrest.Matchers.equalTo("super@admin.com"))
                .log().all();
    }
}