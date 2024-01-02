import java.util.HashSet;

public class Destination {
    private String name;
    private HashSet<Activity> activities;

    public Destination(String name) {
        this.name = name;
    }

    public Destination(String name, HashSet<Activity> activities) {
        this.name = name;
        this.activities = activities;
    }

    public void addActivity(Activity activity) {
        this.activities.add(activity);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashSet<Activity> getActivities() {
        return activities;
    }

    public void setActivities(HashSet<Activity> activities) {
        this.activities = activities;
    }

    public void printDestinationAndActivityDetails() {
        System.out.println("Destination Name: " + this.name);

        for (Activity activity: this.activities) {
            activity.printActivityDetails();
        }
    }

    public void removeActivity(Activity activity) {
        activities.remove(activity);
    }
}
