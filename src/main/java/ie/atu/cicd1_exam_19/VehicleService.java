package ie.atu.cicd1_exam_19;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {

    public final List<Vehicle> store = new ArrayList<>();

    public List<Vehicle> findAll() { return new ArrayList<>(store); }

    public Optional<Vehicle> findByReg(String reg)
    {
        for(Vehicle v : store){
            if(v.getReg().equals(reg)){
                return Optional.of(v);
            }
        }
        return Optional.empty();
    }
}
