package program1;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

enum Season {
    SPRING, SUMMER, AUTUMN, WINTER
}
enum Activity {
    HIKING, SWIMMING, SKIING, PUMPKIN_CARVING
}
public class SeasonalActivityOrganizer {
    
    private Map<Season, EnumSet<Activity>> activitiesBySeason;
    public SeasonalActivityOrganizer() {
        activitiesBySeason = new HashMap<>();
        for (Season season : Season.values()) {
            activitiesBySeason.put(season, EnumSet.noneOf(Activity.class));
        }
    }
    public Set<Activity> getActivitiesForSeason(Season season) {
        return activitiesBySeason.get(season);
    }
    public Set<Activity> addActivityForSeason(Activity activity, Season season) {
        if (activitiesBySeason.containsKey(season)) {
            activitiesBySeason.get(season).add(activity);
            return activitiesBySeason.get(season);
        } else {
            System.out.println("Unknown season: " + season);
            return null;
        }
    }
    public Set<Activity> removeActivityFromAllSeasons(Activity activity) {
        for (Season season : Season.values()) {
            activitiesBySeason.get(season).remove(activity);
        }
        return getAllActivities();
    }
   
    public Set<Activity> getAllActivities() {
        EnumSet<Activity> allActivities = EnumSet.noneOf(Activity.class);
        for (Season season : Season.values()) {
            allActivities.addAll(activitiesBySeason.get(season));
        }
        return allActivities;
    }
  
    public static void main(String[] args) {
        SeasonalActivityOrganizer organizer = new SeasonalActivityOrganizer();

        // Adding activities for different seasons
        organizer.addActivityForSeason(Activity.HIKING, Season.SPRING);
        organizer.addActivityForSeason(Activity.SWIMMING, Season.SUMMER);
        organizer.addActivityForSeason(Activity.SKIING, Season.WINTER);

        // Getting all activities
        System.out.println("All activities: " + organizer.getAllActivities());

        // Getting activities for specific seasons
        System.out.println("Activities for SPRING: " + organizer.getActivitiesForSeason(Season.SPRING));
        System.out.println("Activities for SUMMER: " + organizer.getActivitiesForSeason(Season.SUMMER));
        System.out.println("Activities for WINTER: " + organizer.getActivitiesForSeason(Season.WINTER));

        // Removing an activity from all seasons
        organizer.removeActivityFromAllSeasons(Activity.HIKING);
        System.out.println("Activities for SPRING after removing HIKING: " + organizer.getActivitiesForSeason(Season.SPRING));
    }
}
