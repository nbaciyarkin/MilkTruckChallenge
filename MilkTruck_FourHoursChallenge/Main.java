package MilkTruck_FourHoursChallenge;

public class Main {

    public static void main(String[] args) {
        Map map = new Map(new String[]{"A","B","C"}, new double[][]{{0.0,3.0,5.0}, {3.0,0.0,1.0}, {5.0,1.0,0}});
        CustomerBook customerList = new CustomerBook();
        customerList.addCustomer(new Customer("Ali", "A",20));
        customerList.addCustomer(new Customer("Ayşe", "A",30));
        customerList.addCustomer(new Customer("Berk", "B",10));
        customerList.addCustomer(new Customer("Can", "C",15));
        customerList.addCustomer(new Customer("Cemile", "C",35));
        customerList.addCustomer(new Customer("Ceyhun", "C",5));

        System.out.println("*********Random Truck*********");
        MilkTruck mtRandom = new RandomDelivery("RandomTruck","A");
        mtRandom.deliverMilk(customerList,map);

        System.out.println("******************");
        System.out.println("*********Nearest Truck*********");
        MilkTruck mtNearest = new NearestAddressFirst("Nearest Truck","B");
        mtNearest.deliverMilk(customerList,map);
    }
}
