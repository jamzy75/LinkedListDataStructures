package utils;

import business.Song;
import org.w3c.dom.Node;

/**
 *
 * @author michelle
 */
public class LinkedList {
    private Node head;
    private Node tail;
    private int numElements;

    public LinkedList(){
        head = null;
        numElements = 0;
    }

    public int size(){
        return numElements;
    }

    public Song get(int pos){
        // Validate position to confirm it's GREATER THAN -1
        // AND LESS THAN number of elements
        if(pos < 0 || pos >= numElements){
            // If validation fails, throw an exception
            throw new IndexOutOfBoundsException("Illegal position supplied: " + pos);
        }

        // Build your representative node - set it to the start of the list:
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

    public void add(Song song){
        Node newNode = new Node(song);
        if(numElements == 0){
            head = newNode;
            tail = newNode;
        }else{
            tail.setNext(newNode);
            tail = newNode;
        }
        numElements++;
    }

    public boolean isEmpty() {
        return numElements == 0;
    }

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
