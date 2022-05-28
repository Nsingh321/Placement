package LinkedListPractise;

public class reverseLL {

    private static class Node{
        int data;
        Node next;
        private Node(int data){
            this.data = data;
        }
    }
    Node head;
    Node revHead;

    private void addFirst(int d){
        Node toAdd = new Node(d);
        if (head == null){
            head = toAdd;
            return;
        }
        toAdd.next = head;
        head = toAdd;

    }

    private void display(Node head){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+"--> ");
            temp = temp.next;
        }
        System.out.println("NULL");

    }

    //DONE
    private Node reverseLL1(Node head){

        Node p = null;
        Node temp = head;
        while(temp!=null){
            Node f = temp.next;
            temp.next = p;
            p = temp;
            temp = f;
        }
        head = p;
        return head;
    }

    private Node removeNthNodefromLast(Node head,int x){

       //optimized code
        //move fast pointer completely = n
        //then slow starts from head and
        //then move slow and fast together till fast.next!=null


        //dummy node
        Node start = new Node(0);

        //this dummy node points to head
        start.next = head;

        //fast and slow pointers starts from start(dummy node)
        Node fast = start;
        Node slow = start;

        for(int i = 1;i<=x;i++){
            //move fast pointer equal to 'x' completely
            fast = fast.next;
        }

        //now move slow and fast pointer together till fast.next!=null
        while(fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }

        //now fast pointer is at the last node so delete the next node of slow pointer
        slow.next = slow.next.next;
        return start.next;//which is the head





    }



    //DONE
    public Node removeElements(Node head, int val) {
        //1
        if (head == null) return null;

        while(head!=null && head.data == val){
            head = head.next;
        }

        if (head == null) return null;


        Node temp = head;
        while(temp.next!=null){
            if(temp.next.data == val){
                temp.next = temp.next.next;
            }
            else{
                temp = temp.next;
            }
        }
        return head;



    }


    public static void main(String[] args) {
        reverseLL obj = new reverseLL();

        obj.addFirst(6);
        obj.addFirst(1);
//        obj.addFirst(6);
//        obj.addFirst(4);
//        obj.addFirst(5);


        //obj.display(obj.head);
//        obj.head =  obj.reverseLL1(obj.head);
        obj.display(obj.head);



       obj.head =  obj.removeNthNodefromLast(obj.head,2);
       obj.display(obj.head);


//
//        Node newHead = obj.reverseLL1(obj.head);
//        obj.display(newHead);

/*
        REMOVE ELEMENTS
        obj.newHead = obj.removeElements(obj.head,6);
        obj.display(obj.newHead);
*/

    }
}
