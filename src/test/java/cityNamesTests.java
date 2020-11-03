import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.http.ContentType;
import org.junit.*;


public class cityNamesTests {

    @Test
    public void beverlyHillsTest(){
        given().
        when().
                get("http://zippopotam.us/us/90210").
        then().
                assertThat().
                body("places[0].'place name'",equalTo ("Beverly Hills")).
                and().statusCode(200).
                and().contentType(ContentType.JSON);

    }

    @Test
    public void pretoriaTest(){
        given().
        when().
            get("https://zippopotam.us/ZA/0002").
        then().
                assertThat().
                body("places[0].'place name'",equalTo ("Pretoria")).
                and().statusCode(200).
                and().contentType(ContentType.JSON);

    }


    @Test
    public void saintPierreAndMiquelonTest(){
        given().
        when().
                get("http://api.zippopotam.us/PM/97500").
        then().
                assertThat().
                body("places[0].'place name'",equalTo ("Miquelon")).
                and().
                body("places[1].'place name'",equalTo ("Saint-Pierre")).
                and().statusCode(200).
                and().contentType(ContentType.JSON);


    }

}
