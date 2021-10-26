package com.herokuapp.restfulbooker;

import java.util.List;

import org.junit.Test;
import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetBookingIdsTest {

    @Test
    public void getBookingIdsWithoutFilterTest() {
        // Get response with booking ids
        Response response = RestAssured.get("https://restful-booker.herokuapp.com/booking");
        response.print();
        // Verify response 200
        Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200, but is not");
        // Verify at least 1 booking id in response
        List<Integer> bookingIds = response.jsonPath().getList("bookingid");
        Assert.assertFalse(bookingIds.isEmpty(), "List of bookingIds is empty, but shouldn't be");

    }

}
