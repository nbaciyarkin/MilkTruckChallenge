package MilkTruck_FourHoursChallenge;

import java.util.Random;

public class NearestAddressFirst extends MilkTruck {

    public NearestAddressFirst(String name, String currentAddress) {
        super(name, currentAddress);
    }

    @Override
    public void deliverMilk(CustomerBook customerBook, Map map) {
//Assumption Milk does not given address where started it should get visit from another address.
        boolean [] visitedAddresses = new boolean[map.getAddresses().length];
        boolean isAllAddressesVisited = false;
        double minDistance = Double.MAX_VALUE;
        int minIndex = 0;
        for (int i = 0; i < map.getAddresses().length; i++) {
            visitedAddresses[i] = false;
        }
        Random random = new Random();
        while (isAllAddressesVisited == false) {
            if (this.getCurrentMilk() != 0) {
                //int randomAddressIndex = random.nextInt(map.getAddresses().length);
                for (int k = 0; k < visitedAddresses.length; k++) {
                    if (map.getDistances()[map.findAddress(this.getCurrentAddress())][k] <= minDistance && visitedAddresses[k] == false) {
                        minDistance = map.getDistances()[map.findAddress(this.getCurrentAddress())][k];
                        minIndex = k;
                    }
                }
                if (visitedAddresses[minIndex] == false) {
                    this.visitAddress(customerBook, map, map.getAddresses()[minIndex]);
                    visitedAddresses[minIndex] = true;
                }
                isAllAddressesVisited = true;
                for (int j = 0; j < visitedAddresses.length; j++) {
                    if (visitedAddresses[j] == false) {
                        isAllAddressesVisited = false;
                    }
                }
                minDistance = Double.MAX_VALUE;
            }
            else {
                break;
            }
        }
    }
}
