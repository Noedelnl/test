package ss.week2;

import org.junit.Before;
import org.junit.Test;

import ss.week2.Guest;
import ss.week2.Room;

import static org.junit.Assert.*;

public class RoomTest {
    private Guest guest;
    private Room room;

    @Before
    public void setUp() {
        guest = new Guest("Jip");
        room = new Room(101);
    }

    @Test
    public void testSetUp() {
        assertEquals(101, room.getNumber());
        assertFalse(room.getSafe().isActive());
    }

    @Test
    public void testSetGuest() {
        room.setGuest(guest);
        assertEquals(guest, room.getGuest());
    }
}
