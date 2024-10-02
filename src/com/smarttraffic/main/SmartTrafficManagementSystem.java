package com.smarttraffic.main;

import com.smarttraffic.singleton.TrafficControlManager;
import com.smarttraffic.strategy.*;
import com.smarttraffic.factory.TrafficManagementFactory;
import com.smarttraffic.adapter.ExternalTrafficSensor;
import com.smarttraffic.adapter.TrafficSensorAdapter;

import java.util.Scanner;

public class SmartTrafficManagementSystem {
    public static void main(String[] args) {
        // Singleton instance of TrafficControlManager
        TrafficControlManager manager = TrafficControlManager.getInstance();
        manager.manageTraffic();

        // Factory and strategy setup
        TrafficControlSystem controlSystem = new TrafficControlSystem();
        TrafficManagementFactory factory = new TrafficManagementFactory();

        // Scanner for dynamic input from the user
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter the current traffic condition (normal, heavy, emergency) or 'exit' to quit:");
            String userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase("exit")) {
                System.out.println("Exiting the Smart Traffic Management System...");
                break;
            }

            // Use Adapter to adapt user input as if it's from an external system
            ExternalTrafficSensor externalSensor = new ExternalTrafficSensor(userInput);
            TrafficSensorAdapter sensorAdapter = new TrafficSensorAdapter(externalSensor);

            // Get the formatted traffic data from the adapter
            String trafficCondition = sensorAdapter.getFormattedTrafficData();

            // Set and execute the appropriate strategy based on user input
            TrafficManagementStrategy strategy = factory.getStrategy(trafficCondition);
            controlSystem.setStrategy(strategy);

            // Execute traffic management based on the strategy
            controlSystem.executeStrategy();

            System.out.println();  // Print a new line for clarity
        }

        scanner.close();
    }
}
