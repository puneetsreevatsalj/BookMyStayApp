public abstract class Room {
    protected String roomType;
    protected int beds;
    protected int size; // in sq.ft
    protected int price; // in INR
    protected int availability;

    public Room(String roomType, int beds, int size, int price, int availability) {
        this.roomType = roomType;
        this.beds = beds;
        this.size = size;
        this.price = price;
        this.availability = availability;
    }

    public void displayRoomDetails() {
        System.out.println(roomType + " | Beds: " + beds + " | Size: " + size + " sq.ft | Price: INR " + price + " | Available: " + availability);
    }
}