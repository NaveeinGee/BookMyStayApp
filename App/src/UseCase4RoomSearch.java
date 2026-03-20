import java.util.*;

public class UseCase4RoomSearch {

    public static void main(String[] args) {

        // Inventory (Centralized)
        HashMap<String, Integer> inventory = new HashMap<>();
        inventory.put("Single Room", 5);
        inventory.put("Double Room", 0);
        inventory.put("Suite Room", 2);

        // Room Details (Domain Info)
        HashMap<String, String> roomDetails = new HashMap<>();
        roomDetails.put("Single Room", "Beds: 1, Price: ₹2000");
        roomDetails.put("Double Room", "Beds: 2, Price: ₹3500");
        roomDetails.put("Suite Room", "Beds: 3, Price: ₹6000");

        // Search (READ ONLY)
        System.out.println("===== AVAILABLE ROOMS =====\n");

        for (String roomType : inventory.keySet()) {

            int available = inventory.get(roomType);

            // Show only available rooms
            if (available > 0) {
                System.out.println("Room Type: " + roomType);
                System.out.println(roomDetails.get(roomType));
                System.out.println("Available: " + available + "\n");
            }
        }

        System.out.println("===== END =====");
    }
}