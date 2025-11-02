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
        addDriver("Lewis", "Hamilton", "Mercedes", 44, 39, "https://upload.wikimedia.org/wikipedia/commons/thumb/1/18/Lewis_Hamilton_2016_Malaysia_2.jpg/220px-Lewis_Hamilton_2016_Malaysia_2.jpg", 103, 192, 103, 2007);
        addDriver("Max", "Verstappen", "Red Bull", 1, 26, "https://upload.wikimedia.org/wikipedia/commons/7/75/Max_Verstappen_2017_Malaysia_3.jpg", 53, 120, 43, 2015);
        addDriver("Sebastian", "Vettel", "Retired", 5, 36, "https://upload.wikimedia.org/wikipedia/commons/b/b3/Sebastian_Vettel_2017_Malaysia_2.jpg", 53, 122, 57, 2007);
        addDriver("Fernando", "Alonso", "Aston Martin", 14, 42, "https://upload.wikimedia.org/wikipedia/commons/thumb/2/2b/Alonso_2016.jpg/220px-Alonso_2016.jpg", 32, 98, 22, 2001);
        addDriver("Kimi", "Räikkönen", "Retired", 7, 44, "https://upload.wikimedia.org/wikipedia/commons/4/4d/Kimi_Raikkonen_cropped.jpg", 21, 103, 18, 2001);
        addDriver("Charles", "Leclerc", "Ferrari", 16, 26, "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a3/Charles-Leclerc_%28cropped%29.jpg/640px-Charles-Leclerc_%28cropped%29.jpg", 7, 28, 15, 2018);
        addDriver("Lando", "Norris", "McLaren", 4, 24, "https://upload.wikimedia.org/wikipedia/commons/thumb/7/70/2024-08-25_Motorsport%2C_Formel_1%2C_Großer_Preis_der_Niederlande_2024_STP_4016_by_Stepro_%28cropped%29.jpg/640px-2024-08-25_Motorsport%2C_Formel_1%2C_Großer_Preis_der_Niederlande_2024_STP_4016_by_Stepro_%28cropped%29.jpg", 1, 12, 0, 2019);
        addDriver("Daniel", "Ricciardo", "RB", 3, 34, "https://upload.wikimedia.org/wikipedia/commons/thumb/7/78/Daniel_Ricciardo%2C_British_GP_2022_%2852381435327%29_%28cropped%29.jpg/640px-Daniel_Ricciardo%2C_British_GP_2022_%2852381435327%29_%28cropped%29.jpg", 8, 32, 3, 2011);
        addDriver("Sergio", "Pérez", "Red Bull", 11, 34, "https://upload.wikimedia.org/wikipedia/commons/4/42/Sergio_Pérez_2021_US_GP_driver_parade_%28cropped%29.jpg", 4, 60, 1, 2011);
        addDriver("Valtteri", "Bottas", "Sauber", 77, 34, "https://upload.wikimedia.org/wikipedia/commons/3/36/F12019_Schloss_Gabelhofen_%2820%29_%28cropped%29.jpg", 10, 60, 20, 2013);
    }

    private void addDriver(String firstName, String lastName, String team, int number, int age, String headshotUrl,
                           int wins, int podiums, int poles, int startYear) {
        String displayName = firstName + " " + lastName;
        drivers.put(displayName.trim().toLowerCase(),
                new Driver(firstName, lastName, team, number, age, headshotUrl, wins, podiums, poles, makeAchievements(displayName, startYear)));
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

    public Optional<Driver> findByName(String lastName) {
        if (lastName == null) return Optional.empty();
        return drivers.values().stream()
                .filter(d -> d.getLastName().equalsIgnoreCase(lastName.trim()))
                .findFirst();
    }

    public Collection<Driver> findAll() {
        return Collections.unmodifiableCollection(drivers.values());
    }

    // Return un liste des drivers avec:
    // FirstName
    // LastName
    // Age
    // Team
    // Number
    // Wins
    // Podiums
    // Poles
    // HeadshotUrl
    // Dans un JSON
    public List<Map<String, Object>> findAllDriverInformation() {
        List<Map<String, Object>> infos = new ArrayList<>();
        for (Driver d : drivers.values()) {
            Map<String, Object> info = new HashMap<>();
            info.put("firstName", d.getFirstName());
            info.put("lastName", d.getLastName());
            info.put("age", d.getAge());
            info.put("team", d.getTeam());
            info.put("number", d.getNumber());
            info.put("wins", d.getWins());
            info.put("podiums", d.getPodiums());
            info.put("poles", d.getPoles());
            info.put("headshotUrl", d.getHeadshotUrl());
            infos.add(info);
        }
        return infos;
    }

}
