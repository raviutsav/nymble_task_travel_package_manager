public class Activity {
    private String name;
    private String description;
    private double cost;
    private int passengerCapacity;
    private int numberOfPeopleSigned = 0;
    private Destination destination;
    public int getNumberOfPeopleSigned() {
        return this.numberOfPeopleSigned;
    }

    public Destination getDestination() {
        return this.destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public void setNumberOfPeopleSigned(int numberOfPeopleSigned) {
        this.numberOfPeopleSigned = numberOfPeopleSigned;
    }

    public void incrementPassengerCountByOne() {
        this.numberOfPeopleSigned++;
    }
    public void decrementPassengerCountByOne() {
        this.numberOfPeopleSigned--;
    }

    public Activity(String name, String description, double cost, int passengerCapacity, Destination destination) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.passengerCapacity = passengerCapacity;
        this.destination = destination;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public int getAvailableSeat() {
        return this.passengerCapacity - this.numberOfPeopleSigned;
    }
    public double getEffectivePriceForTheActivity(Passenger passenger) {
        return (1 - passenger.getDiscount()) * (this.getCost());
    }
    public void printActivityDetails() {
        System.out.println("\n");
        System.out.println("Activity Name: " + this.name);
        System.out.println("Activity Name: " + this.cost);
        System.out.println("Activity Name: " + this.passengerCapacity);
        System.out.println("Activity Name: " + this.description);
        System.out.println("Destination: " + this.destination);
        System.out.println("Spaces left: " + this.getAvailableSeat());
    }
}
