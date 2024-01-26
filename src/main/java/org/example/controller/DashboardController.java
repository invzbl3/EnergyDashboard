package org.example.controller;

import org.example.entity.EnergyDashboard;
import org.example.service.EnergyDashboardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Create a controller to handle HTTP requests.
 * This controller will serve as the backend for the dashboard.
 */
@RestController
@RequestMapping("/energy")
public class DashboardController {

    private final EnergyDashboardService energyDashboardService;

    public DashboardController(EnergyDashboardService energyDashboardService) {
        this.energyDashboardService = energyDashboardService;
    }

    /**
     *
     * @param model
     * @return
     *
     * Keep the showDashboard method inside DashboardController as it deals with web-related concerns.
     * The EnergyDashboardService is responsible for encapsulating business logic and
     * interacting with the repository, while the repository (EnergyDashboardRepository) is focused on
     * data access and persistence.
     * <p>
     * Each layer has a specific responsibility in the application, and adhering to these principles helps
     * create a clean and maintainable codebase.
     */
    @GetMapping("/dashboard")
    public String showDashboard(Model model) {
        List<EnergyDashboard> energyDashboardList = energyDashboardService.getAllEnergyData();
        model.addAttribute("energyDashboardList", energyDashboardList);
        return "index"; // Assuming your HTML file is named index.html
    }

    @GetMapping("/byTimestampAfter")
    public ResponseEntity<List<EnergyDashboard>> getByTimestampAfter(@RequestParam("timestamp")
                                                                         LocalDateTime timestamp) {
        List<EnergyDashboard> result = energyDashboardService.getByTimestampAfter(timestamp);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/byTimestampBetween")
    public ResponseEntity<List<EnergyDashboard>> getByTimestampBetween(@RequestParam("start")
                                                                       LocalDateTime start,
                                                                       @RequestParam("end")
                                                                       LocalDateTime end) {
        List<EnergyDashboard> result = energyDashboardService.getByTimestampBetween(start, end);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/byEnergyValueGreaterThanEqual")
    public ResponseEntity<List<EnergyDashboard>> getByEnergyValueGreaterThanEqual(@RequestParam("minValue")
                                                                                      double minValue) {
        List<EnergyDashboard> result = energyDashboardService.getByEnergyValueGreaterThanEqual(minValue);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/byTimestampAndEnergyValue")
    public ResponseEntity<List<EnergyDashboard>> getByTimestampAndEnergyValue(@RequestParam("timestamp")
                                                                                  LocalDateTime timestamp,
                                                                              @RequestParam("energyValue")
                                                                              double energyValue) {
        List<EnergyDashboard> result = energyDashboardService.getByTimestampAndEnergyValue(timestamp, energyValue);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/byOrderByTimestampDesc")
    public ResponseEntity<List<EnergyDashboard>> getByOrderByTimestampDesc() {
        List<EnergyDashboard> result = energyDashboardService.getByOrderByTimestampDesc();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}