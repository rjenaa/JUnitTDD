import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MileageTest {
    private Mileage milage;

    @BeforeAll
    void beforeAll() {
        milage  = new Mileage();
    }

    @ParameterizedTest
    @Disabled
    @ValueSource(strings = { "1; e; Mike; false; 349", "2; b; John; true; 278",  "3; e; Mike; false; 319", "4; p; John; true; 817", "5; e; Mike; false; 623", "6; e; John; true; 978"})
    void checkGivenPoints( Flight flight) {
        for (Passenger passenger: flight.getPassengersSet()) {
            milage.addMilage(passenger, flight.getDistance());
        }
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/flights_information.csv")
    void checkGivenPointsWithCsvInput( Flight flight) {
        for (Passenger passenger: flight.getPassengersSet()) {
            milage.addMilage(passenger, flight.getDistance());
        }
    }

    @AfterAll
    void afterAll() {
        milage.calculateGivenPoints();
        assertEquals(64, milage.getPassengersPointsMap().get(new Passenger("Mike", false)).intValue());
        assertEquals(207, milage.getPassengersPointsMap().get(new Passenger("John", true)).intValue());
        System.out.println(milage.getPassengersPointsMap());
    }
}
