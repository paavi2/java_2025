package be.restapis.urbanladder;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;
import java.util.Map;

public class TestUrbanLadderAPIs {

    @Test
    public void testUrbanLadderOrdersAPI() {
        // Setup base URI
        RestAssured.baseURI = "https://www.urbanladder.com";
        
        // Make API call with all required headers and parameters
        Response response = RestAssured.given()
            .queryParam("token", "107fd0a0fc914faa981c90588cf7fe6dbd8cdd5578c83386")
            .queryParam("mode", "minimal")
            .header("accept", "application/json, text/javascript, */*; q=0.01")
            .header("accept-language", "en-US,en;q=0.9")
            .header("if-none-match", "W/\"845b53c66e18aa62a8f0d39a5ac7f9b2\"")
            .header("priority", "u=1, i")
            .header("referer", "https://www.urbanladder.com/")
            .header("sec-ch-ua", "\"Not;A=Brand\";v=\"99\", \"Brave\";v=\"139\", \"Chromium\";v=\"139\"")
            .header("sec-ch-ua-mobile", "?0")
            .header("sec-ch-ua-platform", "\"macOS\"")
            .header("sec-fetch-dest", "empty")
            .header("sec-fetch-mode", "cors")
            .header("sec-fetch-site", "same-origin")
            .header("sec-gpc", "1")
            .header("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/139.0.0.0 Safari/537.36")
            .header("x-csrf-token", "17MP6GGbDbt7kVT5POaOVMMHgSF8oyKGlRJSv1q3qmcgvvowttHdtcVginig7zi2GZVFOfKm+7c7M9CkCbrY4Q==")
            .header("x-requested-with", "XMLHttpRequest")
            .cookie("guest_token", "BAhJIhtUbkNqNDNGRmhsVnYzUWVJakFVSThnBjoGRUY%3D--d7b664f131815b6aa7ebf10846723c45754cc9b8")
            .cookie("api_key", "107fd0a0fc914faa981c90588cf7fe6dbd8cdd5578c83386")
            .cookie("ul_auth", "popup_close")
            .cookie("experiment_mattress_listing_page", "new")
            .cookie("source_details", "%7B%22referer%22%3A%22https%3A%2F%2Fwww.urbanladder.com%2Fproducts%2Fsearch%3Futf8%3D%25E2%259C%2593%26keywords%3Dsofa%2Bcum%2Bbed%22%2C%22traffic_source%22%3A%22NA%22%2C%22landing_page%22%3A%7B%22type%22%3A%22home%22%2C%22category_id%22%3A%22NA%22%2C%22product_id%22%3A%22NA%22%2C%22url%22%3A%22https%3A%2F%2Funicorn_server%2F%22%2C%22referer%22%3A%22https%3A%2F%2Fwww.urbanladder.com%2Fproducts%2Fsearch%3Futf8%3D%25E2%259C%2593%26keywords%3Dsofa%2Bcum%2Bbed%22%2C%22source%22%3A%22NA%22%7D%2C%22logged_in%22%3Afalse%7D")
            .cookie("_csrf_token", "rAV8Zvf9%2FHQGd0S2wmucFD%2Fxvy7UjS%2BEQ%2BDhZOwvAt9bCIm%2BILcseriGmjdeYir25WN7NlqI9rXtwWN%2FvyJwWQ%3D%3D")
            .cookie("_hercules_session", "aUdBcGFQSVVSVVh4cjlsbHJPV2sybDVYWEpLbk91YS9XUWJUNm1EazluK0V3dk1sZVU4SnNUY3lXekNZTGFXdllMV0dvTnk3d2VEVUhqVFV5RU55WEJ6KyttRnlnblhVcTBURlRxTlNaWGE1OU5JZEY1UnJrVkQ3blg5cDBodFR4SnFZMDY3d0E0N0NuTDBObjMwaERtN0tQbkFybTFCeTVVcy9mRUJQY3YycE12NkJ4UnRpeFloR1dZaU1vVWFOUWJ0YnJDanZMWXQ5MnUrcWhmTVR0VGtwM1RtdGt3ejMrUFNsVm5qR21UczNod1AxNFk0b2NkVUlneUVCclZOTHcrR3I3d0w0bkpkeG9xMGlEM1oyZURlbFJIRWFlMDZHMGF2cncvL3Flb1ZqTUpaWCtaSU9ZOHUrODIrb0N5L0ktLStHbmJIYWdrSUdMc0pxdy9UZ0sxQVE9PQ%3D%3D--6c2d731b688c2dc0e1fd1e6b352614cea95e6a7d")
            .when()
            .get("/api/orders/current");
        
        // Print response details for debugging
        System.out.println("Response Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());
        
        // Validate response status
        Assert.assertEquals(response.getStatusCode(), 200, "API request failed with status code: " + response.getStatusCode());
        
        // Extract response as JSON
        Map<String, Object> responseBody = response.jsonPath().getMap("$");
        
        // Get data object from response
        Map<String, Object> dataObject = (Map<String, Object>) responseBody.get("data");
        Assert.assertNotNull(dataObject, "data object is missing in response");
        
        // Validation 1: Verify total_quantity is not zero
        Object totalQuantityObj = dataObject.get("total_quantity");
        Assert.assertNotNull(totalQuantityObj, "total_quantity field is missing in response");
        
        Integer totalQuantity;
        if (totalQuantityObj instanceof String) {
            totalQuantity = Integer.parseInt((String) totalQuantityObj);
        } else if (totalQuantityObj instanceof Integer) {
            totalQuantity = (Integer) totalQuantityObj;
        } else {
            throw new AssertionError("total_quantity field is not a valid integer: " + totalQuantityObj);
        }
        
        Assert.assertNotEquals(totalQuantity, Integer.valueOf(0), "total_quantity should not be zero");
        System.out.println("✓ Validation passed: total_quantity = " + totalQuantity + " (not zero)");
        
        // Validation 2: Get ID of last line_items array in data object
        List<Map<String, Object>> lineItems = (List<Map<String, Object>>) dataObject.get("line_items");
        Assert.assertNotNull(lineItems, "line_items array is missing in data object");
        Assert.assertFalse(lineItems.isEmpty(), "line_items array is empty in data object");
        
        // Get the ID of the last line_item
        Map<String, Object> lastLineItem = lineItems.get(lineItems.size() - 1);
        Object lastLineItemId = lastLineItem.get("id");
        Assert.assertNotNull(lastLineItemId, "id field is missing in the last line_item");
        
        System.out.println("✓ Successfully extracted ID of last line_items: " + lastLineItemId);
        System.out.println("✓ Total line_items: " + lineItems.size());
        
        // Additional logging for verification
        System.out.println("\n=== API Test Summary ===");
        System.out.println("API Endpoint: /api/orders/current");
        System.out.println("Total Quantity: " + totalQuantity);
        System.out.println("Last Line Item ID: " + lastLineItemId);
        System.out.println("Total Line Items: " + lineItems.size());
        System.out.println("Response Status: " + response.getStatusCode());
        System.out.println("✓ All validations passed successfully!");
    }
}
