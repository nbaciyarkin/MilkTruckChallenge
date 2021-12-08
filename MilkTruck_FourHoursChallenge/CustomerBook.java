package MilkTruck_FourHoursChallenge;

import java.util.ArrayList;

public class CustomerBook {

    private ArrayList<Customer> customers;

    public CustomerBook() {
        this.customers = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public ArrayList<Customer> getCustomerAt(String address){
        ArrayList<Customer> customersInGivenAdress = new ArrayList<>();
        for(Customer customer: this.customers){
            if(customer.getAdress().equals(address)){
                customersInGivenAdress.add(customer);
            }
        }
        return customersInGivenAdress;
    }

    @Override
    public String toString() {
        return "CustomerBook{" +
                "customers=" + customers +
                '}';
    }
}
