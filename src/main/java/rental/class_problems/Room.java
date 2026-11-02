package rental.class_problems;

public abstract class Room {

    private String roomNumber;

    public Room(String roomNumber) {
        if (roomNumber == null || roomNumber.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Room number cannot be blank"
            );
        }

        this.roomNumber = roomNumber;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public abstract double calculatePrice(int nights);
}