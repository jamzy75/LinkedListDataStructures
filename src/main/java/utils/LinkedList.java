package utils;

import business.Song;

/**
 *
 * @author michelle
 */
public class LinkedList {
    private Node head;
    private Node tail;
    private int numElements;

    private int capacity;

    public LinkedList(){
        head = null;
        numElements = 0;
    }

    public LinkedList(int capacity) {
        this.head = null;
        this.numElements = 0;
        this.capacity = capacity;
    }

    public int size(){
        return numElements;
    }

    /**
     * Retrieves the song at the specified position in this list.
     * @param pos  the position of the song to be retrieved.
     * @return  return the data help in the position
     */
    public Song get(int pos){
        // Validate position to confirm it's GREATER THAN -1
        // AND LESS THAN number of elements
        if(pos < 0 || pos >= numElements){
            // If validation fails, throw an exception
            throw new IndexOutOfBoundsException("Illegal position supplied: " + pos);
        }

        // Build  node - set it to the start of the list:
        Node current = head;
        // for each element from head up to specified position:
        for(int i = 0; i < pos; i++){
            // Move to the next element in the list
            // Set current to next element in list
            current = current.getNext();
        }
        // Now we're at the right position,
        // return the data held here
        return current.getData();
    }

    /**
     * Returns the index of the first occurrence of the specified song in this list,
     *   or -1 if this list does not contain the song.
     *
     * @param songArray the song to search for
     * @return the index of the first occurrence of the specified song in this list,
     *           or -1 if this list does not contain the song.
     *
     */
    public int indexOf(Song songArray){
        Node current = head;
        for(int i = 0; i < numElements; i++){

            Song currentData = current.getData();
            if(songArray.equals(currentData)){
                return i;
            }
            current = current.getNext();
        }
        return -1;
    }

//    /**
//     *  adds the specified song to the end of this list
//     * @param song  the song to be added to this list
//     */
//
//    public void add(Song song)  {
//            Node newNode = new Node(song);
//            if (numElements == 0) {
//                head = newNode;
//                tail = newNode;
//            } else {
//                tail.setNext(newNode);
//                tail = newNode;
//            }
//            numElements++;
//        }


    /**
     * Adds the specified song to the end of this list if the list is not full.
     *
     * @param song the song to be added to this list.
     * @return true if the song was successfully added, false otherwise (if the list is full).
     */
    public boolean add(Song song) {
        if (numElements < capacity) {
            Node newNode = new Node(song);
            if (numElements == 0) {
                head = newNode;
                tail = newNode;
            } else {
                tail.setNext(newNode);
                tail = newNode;
            }
            numElements++;
            return true; // Song added successfully
        } else {
            return false; // List is full, cannot add more songs
        }
    }

    /**
     *Returns true if this list contains no songs.
     * @return true if this list contains no songs, false otherwise
     */
    public boolean isEmpty() {
        return numElements == 0;
    }

    /**
     * Returns the last song in this list.
     * @return the last song in this list, or null if the list is empty
     */
    public Song tail(){
        if(head == null){
            return null;
        }
        Node current = head;
        while(current.getNext() != null){
            current = current.getNext();
        }
        return current.getData();
    }


    /**
     * Removes the first occurrence of the specified song from this list, if it is present.
     *
     * @param song the song to be removed from this list (must not be null).
     * @return true if this list contained the specified song and it was removed, false otherwise.
     */
    public boolean remove(Song song) {
        if (isEmpty()) {
           return false;
        }

        Node current = head;
        Node previous = null;

        while (current != null) {
            if (current.getData().equals(song)) {
                if (previous != null) {
                    // If the song to be removed is not the head of the list
                    previous.setNext(current.getNext());
                    if (current.getNext() == null) {
                        // If the removed node was the tail, update tail reference
                        tail = previous;
                    }
                } else {
                    // If the song to be removed is the head of the list
                    head = current.getNext();
                    if (head == null) {
                        // If the list becomes empty after removal
                        tail = null;
                    }
                }
                numElements--;
                return true;
            }
            previous = current;
            current = current.getNext();
        }
        return false; // Song not found
    }

    protected static class Node{
        private Song data;
        private Node next;

        public Node(Song data){
            this.data = data;
            next = null;
        }

        public void setNext(Node next){
            this.next = next;
        }

        public Node getNext(){
            return this.next;
        }

        public void setData(Song data){
            this.data = data;
        }

        public Song getData(){
            return this.data;
        }
    }

}
