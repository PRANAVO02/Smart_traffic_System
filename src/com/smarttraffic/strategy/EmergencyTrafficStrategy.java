package com.smarttraffic.strategy;

public class EmergencyTrafficStrategy implements TrafficManagementStrategy {
    @Override
    public void manageTraffic() {
        System.out.println("Managing emergency traffic. Clearing routes for emergency vehicles.");
    }
}
