import java.util.*;

// Custom Exception
class InvalidBookingException extends Exception {
    public InvalidBookingException(String message) {
        super(message);
    }
}

// Main Class
public class UseCase9ErrorHandlingValidation {

    // Validate booking
    public static void validateBooking(String roomType, int available)
            throws InvalidBookingException {

        // Check valid room type
        if (!roomType.equals("Single Room") &&
                !roomType.equals("Double Room") &&
                !roomType.equals("Suite Room")) {
            throw new InvalidBookingException("Invalid Room Type!");
        }

        // Check availability
        if (available <= 0) {
            throw new InvalidBookingException("No rooms available!");
        }
    }

    public static void main(String[] args) {

        // Inventory
        HashMap<String, Integer> inventory = new HashMap<>();
        inventory.put("Single Room", 2);
        inventory.put("Double Room", 0); // unavailable
        inventory.put("Suite Room", 1);

        // Test inputs
        String[] testRequests = {
                "Single Room",
                "Double Room",
                "Luxury Room"   // invalid type
        };

        System.out.println("===== VALIDATION RESULTS =====\n");

        for (String roomType : testRequests) {

            try {
                int available = inventory.getOrDefault(roomType, -1);

                // Validate before processing
                validateBooking(roomType, available);

                // If valid
                System.out.println("Booking allowed for: " + roomType);

            } catch (InvalidBookingException e) {

                // Graceful error handling
                System.out.println("Error for [" + roomType + "]: " + e.getMessage());
            }
        }

        System.out.println("\nSystem continues running safely.");
    }
}