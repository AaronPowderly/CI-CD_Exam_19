package ie.atu.cicd1_exam_19;


import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Vehicle")
public class VehicleController {
    List<Vehicle> myList = new ArrayList<>();


    private final VehicleService service;

    public VehicleController(VehicleService service)
    {
        this.service = service;
    }

    @PostMapping("/addVehicle")
    public Vehicle addVehicle(@RequestBody @Valid Vehicle vehicle) {
        myList.add(vehicle);
        return vehicle;
    }

    @GetMapping
    public ResponseEntity <List<Vehicle>> getAll()
    {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{reg}")
    public ResponseEntity<Vehicle> getOne(@PathVariable String reg)
    {
        Optional<Vehicle> maybe = service.findByReg(reg);
        if(maybe.isPresent()){
            return ResponseEntity.ok(maybe.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }


}
