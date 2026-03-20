public class BookMyStayApp {
    public static void main(String[] args){

                Long userId = 1L;
                Long propertyId = 101L;
                String checkInDate = "2026-04-01";
                String checkOutDate = "2026-04-05";

                // Step 1: Check user
                if (userId == null) {
                    System.out.println("User not logged in");
                    return;
                }

                // Step 2: Validate dates
                if (checkInDate.compareTo(checkOutDate) >= 0) {
                    System.out.println("Invalid dates");
                    return;
                }

                // Step 3: Check availability (dummy = always true)
                boolean isAvailable = true;

                if (!isAvailable) {
                    System.out.println("Room not available");
                    return;
                }

                // Step 4: Calculate price (dummy logic)
                double pricePerNight = 2000;
                int days = 4; // example
                double totalPrice = pricePerNight * days;

                // Step 5: Payment (dummy success)
                boolean paymentSuccess = true;

                if (!paymentSuccess) {
                    System.out.println("Payment failed");
                    return;
                }

                // Step 6: Booking confirmation
                String bookingId = "BKG" + System.currentTimeMillis();

                System.out.println("Booking Successful!");
                System.out.println("Booking ID: " + bookingId);
                System.out.println("Total Price: " + totalPrice);
            }
        }







