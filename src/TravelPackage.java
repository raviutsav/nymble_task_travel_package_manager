import java.util.HashSet;

public class TravelPackage {
    private String name;
    private int passengerCapacity;
    HashSet<Destination> destinations = new HashSet<>();
    HashSet<Passenger> passengers = new HashSet<>();

    public TravelPackage(String name, int passengerCapacity) {
        this.name = name;
        this.passengerCapacity = passengerCapacity;
    }

    public TravelPackage(String name, int passengerCapacity, HashSet<Destination> destinations) {
        this.name = name;
        this.passengerCapacity = passengerCapacity;
        this.destinations = destinations;
    }

    public TravelPackage(String name, int passengerCapacity, HashSet<Destination> destinations, HashSet<Passenger> passengers) {
        this.name = name;
        this.passengerCapacity = passengerCapacity;
        this.destinations = destinations;
        this.passengers = passengers;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPassengerCapacity() {
        return this.passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public HashSet<Destination> getDestinations() {
        return this.destinations;
    }

    public void setDestinations(HashSet<Destination> destinations) {
        this.destinations = destinations;
    }

    public HashSet<Passenger> getPassengers() {
        return this.passengers;
    }

    public void setPassengers(HashSet<Passenger> passengers) {
        this.passengers = passengers;
    }

    public boolean addPassenger(Passenger passenger) {
        if(this.passengers.contains(passenger)) { return true; }
        else {
            if((this.passengers.size() + 1) <= (this.passengerCapacity)) {
                this.passengerCapacity++;
                this.passengers.add(passenger);
                return true;
            }
            return false;
        }
    }

    public boolean addDestination(Destination destination) {
        this.destinations.add(destination);
        return true;
    }

    public boolean removePassenger(Passenger passenger) {
        passengers.remove(passenger);
        return true;
    }

    public boolean removeDestination(Destination destination) {
        destinations.remove(destination);
        return true;
    }

    public void printItinerary() {
        System.out.println("Travel Package Name : " + this.name);
        System.out.println("\n");

        int serialNumber = 1;
        for(Destination destination: this.destinations) {
            System.out.print(serialNumber + " ");
            destination.printDestinationAndActivityDetails();
            serialNumber++;
        }
    }

    public void printPassengerList() {
        System.out.println("Travel Package Name : " + this.name);
        System.out.println("Passenger Capacity : " + this.passengerCapacity);
        System.out.println("Number of passenger currently enrolled : " + this.passengers.size());

        int serialNumber = 1;
        for(Passenger passenger: passengers) {
            System.out.print(serialNumber + " ");
            passenger.printPassengerDetails();
            serialNumber++;
        }
    }

    public void availableActivities() {
        for(Destination destination: destinations) {
            System.out.println(destination.getName());

            int counter = 0;
            for(Activity activity: destination.getActivities()) {
                if(activity.getPassengerCapacity() > activity.getNumberOfPeopleSigned()) {
                    counter++;
                    System.out.println(counter + ": ");
                }
            }
            if(counter == 0) {
                System.out.println("No available activities at this destination.");
            }
        }
    }
}
