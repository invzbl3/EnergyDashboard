package org.example.controller;

import org.example.entity.EnergyDashboard;
import org.example.service.EnergyDashboardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

/**
 * Create a controller to handle HTTP requests.
 * This controller will serve as the backend for the dashboard.
 */
@Controller
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
     *
     * Each layer has a specific responsibility in the application, and adhering to these principles helps
     * create a clean and maintainable codebase.
     */
    @GetMapping("/dashboard")
    public String showDashboard(Model model) {
        List<EnergyDashboard> energyDashboardList = energyDashboardService.getAllEnergyData();
        model.addAttribute("energyDashboardList", energyDashboardList);
        return "dashboard";
    }
}