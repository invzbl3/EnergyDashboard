package org.example.repository;

import org.example.entity.EnergyDashboard;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Create a repository interface that extends JpaRepository to interact with the database.
 */
public interface EnergyDashboardRepository extends JpaRepository<EnergyDashboard, Long> {

    // Custom queries can be added if needed

    /**
     * @param timestamp
     * @return
     *
     * This query retrieves all EnergyDashboard entries with a timestamp after the specified value.
     */
    List<EnergyDashboard> findByTimestampAfter(LocalDateTime timestamp);

    /**
     * @param start
     * @param end
     * @return
     *
     * This query retrieves all EnergyDashboard entries with timestamps between the specified start and
     * end values.
     */
    List<EnergyDashboard> findByTimestampBetween(LocalDateTime start, LocalDateTime end);

    /**
     * @param minValue
     * @return
     *
     * This query retrieves all EnergyDashboard entries with an energy value greater than or
     * equal to the specified minimum value.
     */
    List<EnergyDashboard> findByEnergyValueGreaterThanEqual(double minValue);

    /**
     * @param timestamp
     * @param energyValue
     * @return
     *
     * This query retrieves all EnergyDashboard entries with the specified timestamp and energy value.
     */
    List<EnergyDashboard> findByTimestampAndEnergyValue(LocalDateTime timestamp, double energyValue);

    /**
     * @return
     *
     * This query retrieves all EnergyDashboard entries ordered by timestamp in descending order.
     */
    List<EnergyDashboard> findByOrderByTimestampDesc();
}