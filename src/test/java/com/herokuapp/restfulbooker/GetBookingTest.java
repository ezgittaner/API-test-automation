package com.herokuapp.restfulbooker;

import org.junit.Test;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetBookingTest {
    

    @Test
    public void getBookingTest() {
        // Get response with booking ids
        Response response = RestAssured.get("https://restful-booker.herokuapp.com/booking/2");
        response.print();
        // Verify response 200
        Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200, but is not");
        // Verify all fields
        SoftAssert softAssert = new SoftAssert();

        String actualFirstName = response.jsonPath().getString("firstname");
        softAssert.assertEquals(actualFirstName, "Jim", "first name is not expected");
        String actuaLastName = response.jsonPath().getString("lastname");
        softAssert.assertEquals(actuaLastName, "Jone", "last name is not expected");

        int price = response.jsonPath().getInt("totalprice");
        softAssert.assertEquals(price, 473, "price is not expected");

        boolean depositPay = response.jsonPath().getBoolean("depositpaid");
        softAssert.assertFalse(depositPay, "deposit is not expected");

        softAssert.assertAll();
        

    }
}
