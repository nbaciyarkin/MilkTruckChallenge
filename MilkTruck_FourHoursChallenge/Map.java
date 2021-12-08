package MilkTruck_FourHoursChallenge;

import java.util.ArrayList;

public class Map {

    private String [] addresses;

    private double [] [] distances;

    public Map(String[] addresses, double[][] distances) {
        this.addresses = addresses;
        this.distances = distances;
    }

    public int findAddress(String address){
        int i = 0;
        for(String arrayAddress: this.addresses) {
            if(arrayAddress.equals(address))
                return i;
            i++;
        }
        return -1;
    }

    public double distanceBetween(String address, String address2){
       int index1 = findAddress(address);
       int index2 = findAddress(address2);
       if (index1 == -1 || index2 == -1 ) {
           return -1;
       }
       return distances[index1] [index2];
    }

    public ArrayList<String> getAddressesAsList() {
        ArrayList<String> addresses = new ArrayList<>();
        for (String address : this.addresses){
            addresses.add(address);
        }
        return addresses ;
    }

    public String[] getAddresses() {
        return addresses;
    }

    public void setAddresses(String[] addresses) {
        this.addresses = addresses;
    }

    public double[][] getDistances() {
        return distances;
    }

    public void setDistances(double[][] distances) {
        this.distances = distances;
    }
}
