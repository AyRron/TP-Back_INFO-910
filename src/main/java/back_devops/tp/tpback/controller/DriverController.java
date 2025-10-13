package back_devops.tp.tpback.controller;

import back_devops.tp.tpback.model.Driver;
import back_devops.tp.tpback.service.DriverService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/drivers")
public class DriverController {
    private final DriverService service;

    public DriverController(DriverService service) {
        this.service = service;
    }

    @GetMapping("/{name}")
    public ResponseEntity<Driver> getDriver(@PathVariable String name) {
        return service.findByName(name)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("Service is up and running");

    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<Driver>> getAllDrivers() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/list")
    public ResponseEntity<List<Map<String, Object>>> getAllDriverInformation() {
        return ResponseEntity.ok(service.findAllDriverInformation());
    }
}
