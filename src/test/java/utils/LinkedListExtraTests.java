package utils;

import business.Song;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author michelle
 */
public class LinkedListExtraTests {

//    @Test
//    public void testAdd() {
//        // Create a new LinkedList
//        LinkedList list = new LinkedList();
//
//        // Create some songs
//        Song song1 = new Song("Artist1", "Title1");
//        Song song2 = new Song("Artist2", "Title2");
//        Song song3 = new Song("Artist3", "Title3");
//
//        // Add songs to the list
//        list.add(song1);
//        list.add(song2);
//        list.add(song3);
//
//        // Check if the size of the list is as expected
//        assertEquals(3, list.size());
//
//        // Check if the first song added is at the head of the list
//        assertEquals(song1, list.get(0));
//
//        // Check if the last song added is at the tail of the list
//        assertEquals(song3, list.tail());
//
//        // Add another song
//        Song song4 = new Song("Artist4", "Title4");
//        list.add(song4);
//
//        // Check if the size of the list is updated
//        assertEquals(4, list.size());
//
//        // Check if the last song added is now the tail of the list
//        assertEquals(song4, list.tail());
//    }


    @Test
    public void testAdd2() {
        // Create a new LinkedList with a capacity of 3
        LinkedList list = new LinkedList(3);

        // Create some songs
        Song song1 = new Song("Artist1", "Title1");
        Song song2 = new Song("Artist2", "Title2");
        Song song3 = new Song("Artist3", "Title3");
        Song song4 = new Song("Artist4", "Title4");

        // Add songs to the list
        assertTrue(list.add(song1)); // Add successful, list size: 1
        assertTrue(list.add(song2)); // Add successful, list size: 2
        assertTrue(list.add(song3)); // Add successful, list size: 3
        assertFalse(list.add(song4)); // Add unsuccessful (list is full), list size remains 3

        // Check if the size of the list is as expected
        assertEquals(3, list.size());

        // Check if the first song added is at the head of the list
        assertEquals(song1, list.get(0));

        // Check if the last song added is at the tail of the list
        assertEquals(song3, list.tail());

        // Add another song (should not be added as the list is already full)
        assertFalse(list.add(new Song("Artist5", "Title5"))); // Add unsuccessful, list size remains 3
    }



}


