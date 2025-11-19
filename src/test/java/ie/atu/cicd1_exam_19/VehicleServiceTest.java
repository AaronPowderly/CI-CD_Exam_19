package ie.atu.cicd1_exam_19;

import org.apache.catalina.Service;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class VehicleServiceTest {

    private VehicleService Service;

    @BeforeEach
    public void setup() {
        Service = new VehicleService();
    }

    @Test
    void createThenFindByReg(){
        Vehicle v = Vehicle.builder()
                .reg("15-T-23739")
                .driverName("Aaron")
                .Email("Aaron@atu.ie")
                .passengers(4)
                .build();
        Service.create(v);
        Optional<Vehicle> found = Service.findByReg("15-T-23739");
        assertTrue(found.isPresent());
        assertEquals("Aaron", found.get().getDriverName());
    }

    @Test
    void duplicate RegThrows()
    {
        Service.create (Vehicle.builder()
                .reg("12-A-42739")
                .driverName("Conor")
                .Email("Conor@atu.ie")
                .passengers(3)
                .build());
        assertThrows(IllegalArgumentException.class, ()-> Service.create(Vehicle.builder()
                .reg("12-A-42739")
                .driverName("Jack")
                .Email("Jack@atu.ie")
                .passengers(1)
                .build()
        ));
    }
    @Test
    void updateVehicle(){
        Vehicle v = Vehicle.builder()
                .driverName("Daniel")
                .Email("Daniel@atu.ie")
                .passengers(1)
                .build();
        Service.create(v);
        Vehicle updated = Vehicle.builder()
                .driverName("Daniel")
                .Email("Daniel@atu.ie")
                .passengers(1)
                .build();
        Service.update(updated);

        Optional<Vehicle> found = Service.findBydriverName("Daniel");
        assertTrue(found.isPresent());
        assertEquals("Daniel Updated", found.get().getDriverName());
        assertEquals("Daniel Updated @atu.ie", found.get().getEmail());
    }

}
