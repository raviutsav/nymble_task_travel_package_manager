import java.util.HashSet;
public class Passenger {
    private String name;
    private String passengerID;
    private double balance;
    private double discount;
    private PassengerType passengerType;

    private HashSet<Activity> signedUpActivities;

    public Passenger(String name, String passengerID, double balance, double discount, PassengerType passengerType) {
        this.name = name;
        this.passengerID = passengerID;
        this.balance = balance;

        if(passengerType == PassengerType.GOLD) { this.discount = 0.1; }
        if(passengerType == PassengerType.PREMIUM) { this.discount = 1; }
        if(passengerType == PassengerType.STANDARD) { this.discount = 0; }

        this.passengerType = passengerType;
    }

    public boolean signUpForActivity(Activity activity) {
        if(signedUpActivities.contains(activity)) {
            System.out.println("Already Signed up for this activity.");
            return true;
        }
        else {
            double discountedPriceOfTheActivity = activity.getEffectivePriceForTheActivity(this);
            if(discountedPriceOfTheActivity <= this.balance && activity.getNumberOfPeopleSigned() + 1 <= activity.getPassengerCapacity()) {
                activity.incrementPassengerCountByOne();
                this.balance -= discountedPriceOfTheActivity;
                this.signedUpActivities.add(activity);
                return true;
            } else {
                return false;
            }
        }
    }

    public void signOutForActivity(Activity activity) {
        if(!signedUpActivities.contains(activity)) {
            System.out.println("Already Signed out for this activity.");
        } else {
            signedUpActivities.remove(activity);
            activity.decrementPassengerCountByOne();
            this.addMoney(activity.getEffectivePriceForTheActivity(this));
            System.out.println("Signed out for this activity. And activity money has been added to the balance");
        }
    }

    public void addMoney(double moneyToAdd) {
        this.balance += moneyToAdd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassengerID() {
        return passengerID;
    }

    public void setPassengerID(String passengerID) {
        this.passengerID = passengerID;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public PassengerType getPassengerType() {
        return passengerType;
    }

    public void setPassengerType(PassengerType passengerType) {
        this.passengerType = passengerType;
    }

    public void printPassengerDetails() {
        System.out.println("\n");
        System.out.println("Passenger Name: " + this.name);
        System.out.println("Passenger number: " + this.passengerID);
    }

    public void printBalanceLeft() {
        if(passengerType == PassengerType.PREMIUM) {
            System.out.println("PREMIUM membership");
        }
        else {
            System.out.println("Balance: " + this.getBalance());
        }
    }
    public void printPassengerDetailsWithActivities() {
        this.printPassengerDetails();
        this.printBalanceLeft();
        for (Activity signedUpActivity: signedUpActivities) {
            signedUpActivity.printActivityDetails();
            System.out.println(signedUpActivity.getEffectivePriceForTheActivity(this));
            System.out.println("\n");
        }
    }
}
