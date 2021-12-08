package MilkTruck_FourHoursChallenge;

import java.util.Random;

public class RandomDelivery extends MilkTruck {

    public RandomDelivery(String name, String currentAddress) {
        super(name, currentAddress);
    }

    @Override
    public void deliverMilk(CustomerBook customerBook, Map map) {
        //Assumption Milk does not given address where started it should get visit from another address.
        boolean [] visitedAddresses = new boolean[map.getAddresses().length];
        boolean isAllAddressesVisited = false;
        for (int i = 0; i < map.getAddresses().length; i++) {
            visitedAddresses[i] = false;
        }
        Random random = new Random();
        while (isAllAddressesVisited == false) {
            if (this.getCurrentMilk() != 0) {
                int randomAddressIndex = random.nextInt(map.getAddresses().length);
                if (visitedAddresses[randomAddressIndex] == false) {
                    this.visitAddress(customerBook, map, map.getAddresses()[randomAddressIndex]);
                    visitedAddresses[randomAddressIndex] = true;

                }
                isAllAddressesVisited = true;
                for (int j = 0; j < visitedAddresses.length; j++) {
                    if (visitedAddresses[j] == false) {
                        isAllAddressesVisited = false;
                    }
                }
            }
            else {
                break;
            }
        }
    }
}
