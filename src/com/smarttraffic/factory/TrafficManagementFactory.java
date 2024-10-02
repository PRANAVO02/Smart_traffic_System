package com.smarttraffic.factory;

import com.smarttraffic.strategy.*;

public class TrafficManagementFactory {

    public TrafficManagementStrategy getStrategy(String trafficCondition) {
        switch (trafficCondition.toLowerCase()) {
            case "heavy":
                return new HeavyTrafficStrategy();
            case "emergency":
                return new EmergencyTrafficStrategy();
            default:
                return new NormalTrafficStrategy();
        }
    }
}
