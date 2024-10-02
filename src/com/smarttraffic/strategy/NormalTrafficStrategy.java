package com.smarttraffic.strategy;

public class NormalTrafficStrategy implements TrafficManagementStrategy {
    @Override
    public void manageTraffic() {
        System.out.println("Managing normal traffic flow. Optimizing traffic lights.");
    }
}
