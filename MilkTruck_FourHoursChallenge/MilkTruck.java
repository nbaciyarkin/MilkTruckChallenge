package MilkTruck_FourHoursChallenge;

import java.util.ArrayList;

public  abstract class MilkTruck {

    private String name;

    private  double  currentMilk;

    private  String  currentAddress;

    private  double distanceTraveled;

    private static  double TotalDistanceTraveled;

    private static  double TruckCapacity = 100.00;

    private static  double TotalMilkDelivered ;

    public MilkTruck(String name, String currentAddress) {
        this.name = name;
        this.currentAddress = currentAddress;
        this.currentMilk = MilkTruck.TruckCapacity;
        this.distanceTraveled =0;
        System.out.println(" “ The truck- " + name + " started delivery at  " + currentAddress );
    }
    public boolean visitAddress(CustomerBook  customerBook, Map map, String address) {
        ArrayList<Customer> customerAtGivenAddress = customerBook.getCustomerAt(address);
        int totalMilkDemaned = 0;
        boolean isCurrentMilkEnough = true;
        for(Customer customer : customerAtGivenAddress) {
            totalMilkDemaned += customer.getDemandOfMilk();
        }
        if (currentMilk < totalMilkDemaned) {
            isCurrentMilkEnough = false;
        }
        for (Customer customer: customerAtGivenAddress) {
            if (currentMilk != 0) {
                System.out.println("The address"  + address + " is visited. Distance Traveled: " + map.distanceBetween(currentAddress, address));
                if (customer.getDemandOfMilk() > currentMilk) {
                    System.out.println(" Customer " + customer.getName() + " is delivered. Delivered Milk: " + (customer.getDemandOfMilk() - currentMilk) + ". Current Milk in the Truck: " + 0 );
                    currentMilk = 0;
                }
                else {
                    currentMilk = currentMilk - customer.getDemandOfMilk();
                    System.out.println(" Customer " + customer.getName() + " is delivered. Delivered Milk: " + customer.getDemandOfMilk() + ". Current Milk in the Truck: " + currentMilk );
                }
            }
        }
        this.distanceTraveled  += map.distanceBetween(currentAddress, address);
        this.currentAddress = address;
        return isCurrentMilkEnough;
    }

    public abstract void deliverMilk(CustomerBook customerBook, Map map);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCurrentMilk() {
        return currentMilk;
    }

    public void setCurrentMilk(double currentMilk) {
        this.currentMilk = currentMilk;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(String currentAddress) {
        this.currentAddress = currentAddress;
    }

    public double getDistanceTraveled() {
        return distanceTraveled;
    }

    public void setDistanceTraveled(double distanceTraveled) {
        this.distanceTraveled = distanceTraveled;
    }

    public static double getTotalDistanceTraveled() {
        return TotalDistanceTraveled;
    }

    public static void setTotalDistanceTraveled(double totalDistanceTraveled) {
        TotalDistanceTraveled = totalDistanceTraveled;
    }

    public static double getTruckCapacity() {
        return TruckCapacity;
    }

    public static void setTruckCapacity(double truckCapacity) {
        TruckCapacity = truckCapacity;
    }

    public static double getTotalMilkDelivered() {
        return TotalMilkDelivered;
    }

    public static void setTotalMilkDelivered(double totalMilkDelivered) {
        TotalMilkDelivered = totalMilkDelivered;
    }
}

