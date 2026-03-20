import java.util.*;

// Reservation class for UC8
class ReservationUC8 {
    String reservationId;
    String guestName;
    String roomType;

    public ReservationUC8(String reservationId, String guestName, String roomType) {
        this.reservationId = reservationId;
        this.guestName = guestName;
        this.roomType = roomType;
    }
}

// Main Class
public class UseCase8BookingHistoryReport {

    public static void main(String[] args) {

        // Booking history (List maintains order)
        List<ReservationUC8> bookingHistory = new ArrayList<>();

        // Adding confirmed bookings (simulating UC6 output)
        bookingHistory.add(new ReservationUC8("RES101", "Alice", "Single Room"));
        bookingHistory.add(new ReservationUC8("RES102", "Bob", "Double Room"));
        bookingHistory.add(new ReservationUC8("RES103", "Charlie", "Suite Room"));

        // Display booking history
        System.out.println("===== BOOKING HISTORY =====\n");

        for (ReservationUC8 r : bookingHistory) {
            System.out.println("Reservation ID: " + r.reservationId);
            System.out.println("Guest: " + r.guestName);
            System.out.println("Room Type: " + r.roomType + "\n");
        }

        // Generate simple report
        System.out.println("===== BOOKING REPORT =====");

        HashMap<String, Integer> report = new HashMap<>();

        for (ReservationUC8 r : bookingHistory) {
            report.put(r.roomType, report.getOrDefault(r.roomType, 0) + 1);
        }

        for (String roomType : report.keySet()) {
            System.out.println(roomType + " bookings: " + report.get(roomType));
        }

        System.out.println("\nTotal Bookings: " + bookingHistory.size());
    }
}