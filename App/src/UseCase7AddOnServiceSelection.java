import java.util.*;

// Service class (Add-On)
class ServiceUC7 {
    String serviceName;
    double cost;

    public ServiceUC7(String serviceName, double cost) {
        this.serviceName = serviceName;
        this.cost = cost;
    }
}

// Main Class
public class UseCase7AddOnServiceSelection {

    public static void main(String[] args) {

        // Map: Reservation ID -> List of Services
        HashMap<String, List<ServiceUC7>> addOnServices = new HashMap<>();

        // Create some services
        ServiceUC7 wifi = new ServiceUC7("WiFi", 500);
        ServiceUC7 breakfast = new ServiceUC7("Breakfast", 300);
        ServiceUC7 pickup = new ServiceUC7("Airport Pickup", 1000);

        // Example reservation IDs (from UC6 concept)
        String res1 = "RES101";
        String res2 = "RES102";

        // Attach services to reservations
        addOnServices.put(res1, new ArrayList<>());
        addOnServices.get(res1).add(wifi);
        addOnServices.get(res1).add(breakfast);

        addOnServices.put(res2, new ArrayList<>());
        addOnServices.get(res2).add(pickup);

        // Display services and calculate cost
        System.out.println("===== ADD-ON SERVICES =====\n");

        for (String resId : addOnServices.keySet()) {

            System.out.println("Reservation ID: " + resId);

            double totalCost = 0;

            for (ServiceUC7 s : addOnServices.get(resId)) {
                System.out.println("Service: " + s.serviceName + " | Cost: ₹" + s.cost);
                totalCost += s.cost;
            }

            System.out.println("Total Add-On Cost: ₹" + totalCost + "\n");
        }

        System.out.println("===== END =====");
    }
}