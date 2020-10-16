//Kate Walker 
public class LinkedList<E> {
    static class Node<E> {//Node class
        public E data;//section for data
        public Node<E> next;//store next node

        public Node(E data) {//constructor for data
            this.data = data;
        }

        public Node(E data, Node<E> next) {//get data and the next node
            this.data = data;
            this.next = next;
        }

    }
    private Node<E> head,tail;//Node for head and tail
    private int size;//int to store the size of the linked list

    public int getSize() {//function to get the size of the linkedlist

        return this.size;//return the size
    }

    public boolean isEmpty() {//function to check if the linked list is empty

        return (this.getSize() == 0);//if the size equals 0 it is empty
    }

    public LinkedList() {//constructor for linkedlist class
        this.head = null;
        this.tail = null;
        size = 0;
    }
    public void add(E item) {//function to add item
        Node<E> newNode = new Node<>(item, null);//make a new node
        if (isEmpty()) {//if the list is empty set the newnode to be both the head and the tail
            head = newNode;
        }
        else {//else set the tail and tail.next to new node
            tail.next = newNode;
        }
        tail = newNode;
        size++;//increment the size
    }

    public void add(E item, int position) {//function to add at a specific index
        if (this.head == null || position <= 1) {//if the head is null or the position is less than 1
            this.head = new Node<>(item, this.head);//set the head to a new node
        }
        else {
            Node<E> front = this.head;//set front value to head
            while (front.next != null && size < position - 1) {//while the front.next value is not null & the size is less than the position -1
                front = front.next;//set front equal to front.next
                size++;//increment the size
            }
            front.next = new Node<>(item, front.next);//set front.next to a new node with the value
        }
    }
    public E get(int position) {//function to get a node at a specified position

        if (this.head != null && position >= 0) {//if the head is not null and the position is greater than or equal to 0
            Node<E> p = this.head;//set node p to the head
            while (p != null && size < position) {//while p is not null and size is less than the position
                p = p.next;//set p to p.next
                size++;//increment the size
            }

            if (p != null) {//if p equals null
                return p.data;//return the data at node p
            }
        }
        return null;//return null if not valid position
    }

    public E remove(int position) {//function to remove a node

        E old = null;//make a variable to hold the old value set it to null

        if (this.head != null && position >= 0) {//if the head is not null and the position is greater than or equal to 0

            if (position == 0) {//if the position equals 0
                old = this.head.data;//set old to the value of the head
                this.head = this.head.next;//set head to head.next
            }
            else {

                Node<E> first = this.head;//set first value to the head
                while (first.next != null && size < position - 1) {//while first.next is not null and size is less than the position minus 1
                    first = first.next;//set first to first.next
                    size++;//increment size
                }

                if (first.next != null) {//if first.next is null
                    old = first.next.data;//set old value to first.next
                    first.next = first.next.next;//set first.next equal to first.next.next
                }
            }
        }
        return old;//return the old node that was removed
    }

    public Node<E> reverse(Node<E>head) {//function to reverse the linked list
        Node<E> previous = null;//make a node previous and set it to null
        Node<E> current = head;//make a node current and set it to the head
        Node<E> next;//make a node next
        while (current != null) {//while current is not null
            next = current.next;//set next to current.next
            current.next = previous;//set current.next to previous
            previous = current;//set previous to current
            current = next;//set current to next
        }
        head = previous;//set head to previous
        return head;//return the head
    }

    void printList(Node<E> node)//function to print the linkedlist
    {
        while (node != null) {//while the node is not null
            System.out.print(node.data + " ");//print the node data and a space
            node = node.next;//set node to node.next
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();//make an object of the linkedlist class

        for(int i=1; i<5; i++){//loop to add values to the linkedlist
            list.add(i);
        }

        System.out.println("Linked List: ");
        list.printList(list.head);//print the original linkedlist

        list.add(7);//add 7 to the linkedlist
        System.out.println();
        System.out.println("List after adding 7: ");
        list.printList(list.head);//print the updated linkedlist

        list.add(2,3);//add 2 at index 3 to the linkedlist
        System.out.println();
        System.out.println("List after adding 2: ");
        list.printList(list.head);//print the updated linkedlist
        System.out.println();

        System.out.println("Number being removed: ");
        System.out.println(list.remove(1));//remove the value at index 1
        System.out.println("Remove number at index 1: ");
        list.printList(list.head);//print the updated linkedlist
        System.out.println();

        System.out.println("Return value at index 0: ");
        System.out.println(list.get(0));//get the value at index 0

        list.head = list.reverse(list.head);//call reverse function on the linkedlist
        System.out.println("Reversed list: ");
        list.printList(list.head);//print the reversed linkedlist
    }
}





