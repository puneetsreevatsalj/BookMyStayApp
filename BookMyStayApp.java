public class BookMyStayApp {
    public static void main(String[] args) {
        System.out.println("Welcome to BookMyStay - Hotel Booking System v2.0");

        Room single = new SingleRoom(5);
        Room doubleR = new DoubleRoom(3);
        Room suite = new SuiteRoom(2);

        System.out.println("\nRoom Availability:");
        single.displayRoomDetails();
        doubleR.displayRoomDetails();
        suite.displayRoomDetails();
    }
}