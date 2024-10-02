package com.smarttraffic.strategy;

public class HeavyTrafficStrategy implements TrafficManagementStrategy {
    @Override
    public void manageTraffic() {
        System.out.println("Managing heavy traffic flow. Adjusting traffic lights accordingly.");
    }
}
