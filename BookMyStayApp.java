public class BookMyStayApp {
    public static void main(String[] args) {
        System.out.println("Welcome to BookMyStay - Hotel Booking System v3.0");

        Room single = new SingleRoom(0); // availability now managed centrally
        Room doubleR = new DoubleRoom(0);
        Room suite = new SuiteRoom(0);

        RoomInventory inventory = new RoomInventory();
        inventory.addRoomType(single.roomType, 5);
        inventory.addRoomType(doubleR.roomType, 3);
        inventory.addRoomType(suite.roomType, 2);

        // Display room details
        System.out.println("\nRoom Details:");
        single.displayRoomDetails();
        doubleR.displayRoomDetails();
        suite.displayRoomDetails();

        // Display centralized inventory
        inventory.displayInventory();

        // Example of updating inventory
        inventory.updateAvailability("Single Room", 4);
        System.out.println("\nInventory after booking 1 Single Room:");
        inventory.displayInventory();
    }
}