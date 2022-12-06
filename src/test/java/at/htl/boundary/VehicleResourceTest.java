package at.htl.boundary;

import at.htl.entity.MyColor;
import at.htl.entity.Vehicle;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class VehicleResourceTest {

    @Test
    public void createVehicle() {
        var vehicle = new Vehicle("Ford", MyColor.BLACK, LocalDate.now(),"Mustang");
        Response response = given()
                .header("Content-Type", "application/json")
                .body(vehicle)
                .when()
                .post("/vehicle")
                .then()
                .extract()
                .response();
        assertThat(response.statusCode()).isEqualTo(HttpStatus.SC_CREATED);
    }

}