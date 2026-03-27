import java.util.*;

class RoomInventory {
    private Map<String, Integer> roomAvailability = new HashMap<>();

    public void addRoomType(String roomType, int count) {
        roomAvailability.put(roomType, count);
    }

    public void incrementRoom(String roomType) {
        roomAvailability.put(roomType, roomAvailability.getOrDefault(roomType, 0) + 1);
    }

    public int getAvailableRooms(String roomType) {
        return roomAvailability.getOrDefault(roomType, 0);
    }
}

class CancellationService {

    private Stack<String> rollbackStack = new Stack<>();
    private Map<String, String> reservationMap = new HashMap<>();

    public void registerBooking(String reservationId, String roomType) {
        reservationMap.put(reservationId, roomType);
    }

    public void cancelBooking(String reservationId, RoomInventory inventory) {

        if (!reservationMap.containsKey(reservationId)) {
            System.out.println("Invalid or already cancelled booking.");
            return;
        }

        String roomType = reservationMap.get(reservationId);

        // LIFO rollback
        rollbackStack.push(reservationId);

        // Restore inventory
        inventory.incrementRoom(roomType);

        // Remove booking
        reservationMap.remove(reservationId);

        System.out.println("Booking cancelled: " + reservationId);
    }

    public void showRollbackHistory() {
        System.out.println("\nRollback History (LIFO):");

        if (rollbackStack.isEmpty()) {
            System.out.println("No cancellations.");
            return;
        }

        for (int i = rollbackStack.size() - 1; i >= 0; i--) {
            System.out.println(rollbackStack.get(i));
        }
    }
}

public class BookMyStayApp {
    public static void main(String[] args) {

        RoomInventory inventory = new RoomInventory();
        inventory.addRoomType("Single", 5);

        CancellationService service = new CancellationService();

        service.registerBooking("B101", "Single");

        service.cancelBooking("B101", inventory);
        service.showRollbackHistory();

        System.out.println("Available Rooms: " + inventory.getAvailableRooms("Single"));
    }
}