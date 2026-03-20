import java.util.*;

// Reservation class
class ReservationUC6 {
    String guestName;
    String roomType;

    public ReservationUC6(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }
}

// Main Class
public class UseCase6RoomAllocationService {

    public static void main(String[] args) {

        // Queue (from UC5)
        Queue<ReservationUC6> bookingQueue = new LinkedList<>();
        bookingQueue.add(new ReservationUC6("Alice", "Single Room"));
        bookingQueue.add(new ReservationUC6("Bob", "Double Room"));
        bookingQueue.add(new ReservationUC6("Charlie", "Suite Room"));

        // Inventory (from UC3)
        HashMap<String, Integer> inventory = new HashMap<>();
        inventory.put("Single Room", 2);
        inventory.put("Double Room", 1);
        inventory.put("Suite Room", 1);

        // Allocation tracking
        HashMap<String, Set<String>> allocatedRooms = new HashMap<>();

        // Initialize sets
        allocatedRooms.put("Single Room", new HashSet<>());
        allocatedRooms.put("Double Room", new HashSet<>());
        allocatedRooms.put("Suite Room", new HashSet<>());

        System.out.println("===== ROOM ALLOCATION =====\n");

        // Process queue (FIFO)
        while (!bookingQueue.isEmpty()) {

            ReservationUC6 request = bookingQueue.poll();
            String roomType = request.roomType;

            int available = inventory.getOrDefault(roomType, 0);

            if (available > 0) {

                // Generate unique room ID
                String roomId = roomType.substring(0, 2).toUpperCase() + (available);

                // Ensure uniqueness using Set
                Set<String> assigned = allocatedRooms.get(roomType);

                if (!assigned.contains(roomId)) {

                    assigned.add(roomId);

                    // Update inventory
                    inventory.put(roomType, available - 1);

                    System.out.println("Booking Confirmed!");
                    System.out.println("Guest: " + request.guestName);
                    System.out.println("Room Type: " + roomType);
                    System.out.println("Room ID: " + roomId + "\n");

                } else {
                    System.out.println("Duplicate Room ID detected! Skipping...\n");
                }

            } else {
                System.out.println("No rooms available for " + request.guestName +
                        " (" + roomType + ")\n");
            }
        }

        System.out.println("===== FINAL INVENTORY =====");
        for (String type : inventory.keySet()) {
            System.out.println(type + " : " + inventory.get(type));
        }
    }
}