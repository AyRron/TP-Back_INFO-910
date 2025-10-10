// java
package back_devops.tp.tpback.service;

import org.springframework.stereotype.Service;
import back_devops.tp.tpback.model.Driver;
import back_devops.tp.tpback.model.Achievement;

import java.util.*;

@Service
public class DriverService {
    private final Map<String, Driver> drivers = new HashMap<>();

    public DriverService() {
        seedData();
    }

    private void seedData() {
        addDriver("Lewis Hamilton", 103, 192, 103, 2007);
        addDriver("Max Verstappen", 53, 120, 43, 2015);
        addDriver("Sebastian Vettel", 53, 122, 57, 2007);
        addDriver("Fernando Alonso", 32, 98, 22, 2001);
        addDriver("Kimi Räikkönen", 21, 103, 18, 2001);
        addDriver("Charles Leclerc", 7, 28, 15, 2018);
        addDriver("Lando Norris", 1, 12, 0, 2019);
        addDriver("Daniel Ricciardo", 8, 32, 3, 2011);
        addDriver("Sergio Pérez", 4, 60, 1, 2011);
        addDriver("Valtteri Bottas", 10, 60, 20, 2013);
    }

    private void addDriver(String displayName, int wins, int podiums, int poles, int startYear) {
        drivers.put(displayName.trim().toLowerCase(),
                new Driver(displayName, wins, podiums, poles, makeAchievements(displayName, startYear)));
    }

    private List<Achievement> makeAchievements(String driver, int startYear) {
        String[] gps = {
                "Australian GP", "Bahrain GP", "Chinese GP", "Spanish GP", "Monaco GP",
                "Canadian GP", "British GP", "Belgian GP", "Italian GP", "Singapore GP",
                "Japanese GP", "United States GP", "Mexican GP", "Brazilian GP", "Abu Dhabi GP"
        };

        List<Achievement> list = new ArrayList<>(gps.length);
        for (int i = 0; i < gps.length; i++) {
            int year = startYear + (i % 7);
            String type;
            switch (i % 4) {
                case 0: type = "Win"; break;
                case 1: type = "Podium"; break;
                case 2: type = "Pole"; break;
                default: type = "Fastest Lap"; break;
            }
            String desc = String.format("%s au %s - %s (%d)", driver, gps[i], type, year);
            list.add(new Achievement(year, gps[i], type, desc));
        }
        return list;
    }

    public Optional<Driver> findByName(String name) {
        if (name == null) return Optional.empty();
        return Optional.ofNullable(drivers.get(name.trim().toLowerCase()));
    }

    public Collection<Driver> findAll() {
        return Collections.unmodifiableCollection(drivers.values());
    }
}
