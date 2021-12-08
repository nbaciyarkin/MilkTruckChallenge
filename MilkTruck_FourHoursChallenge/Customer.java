package MilkTruck_FourHoursChallenge;

public class Customer {
    private String name;
    private String adress;
    private  double demandOfMilk;

    public Customer(String name, String adress, double demandOfMilk) {
        this.name = name;
        this.adress = adress;
        this.demandOfMilk = demandOfMilk;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public double getDemandOfMilk() {
        return demandOfMilk;
    }

    public void setDemandOfMilk(double demandOfMilk) {
        this.demandOfMilk = demandOfMilk;
    }

    @Override
    public String toString() {
        return "Customer{" + "name='" + name + "' - " + " adress= " + adress + " - " + "[ dailydemand= " + demandOfMilk + "'] }";
    }
}
