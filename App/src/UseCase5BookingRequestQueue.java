import java.util.*;

// Reservation class (represents booking request)
class Reservation {
    private String guestName;
    private String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }

    public void display() {
        System.out.println("Guest: " + guestName + ", Room Type: " + roomType);
    }
}

// Main Class
public class UseCase5BookingRequestQueue {

    public static void main(String[] args) {

        // Queue for booking requests (FIFO)
        Queue<Reservation> bookingQueue = new LinkedList<>();

        // Adding booking requests (First Come First Served)
        bookingQueue.add(new Reservation("Alice", "Single Room"));
        bookingQueue.add(new Reservation("Bob", "Double Room"));
        bookingQueue.add(new Reservation("Charlie", "Suite Room"));
        bookingQueue.add(new Reservation("David", "Single Room"));

        // Display queue (no processing, only intake)
        System.out.println("===== BOOKING REQUEST QUEUE =====\n");

        for (Reservation r : bookingQueue) {
            r.display();
        }

        System.out.println("\nRequests are stored in arrival order (FIFO)");
        System.out.println("No allocation done yet.");
    }
}