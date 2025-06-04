
public class Displayfirstn
{
    static class Node{
        int data;
        Node next;
        Node(int data)
        {
            this.data=data;
            this.next=null;
        }
    }
    public Node head;
    public void insertBeg(int data)
    {
        Node newnode=new Node(data);
        newnode.next=head;
        head=newnode;
        return;
        
    }
    public void insertEnd(int data)
    {
        
        if(head==null)
        {
            insertBeg(data);
            return;
        }
        Node newnode=new Node(data);
        Node current=head;
        while(current.next!=null)
        {
            current=current.next;
        }
        current.next=newnode;
        
    }
    public void display()
    {
        Node current=head;
        if(head==null)
        {
            System.out.println("No elements");
            return;
        }
        while(current!=null)
        {
            System.out.print(current.data+"->");
            current=current.next;
        }
        System.out.println("null");
        
    }
    public void displaynth(int n)
    {
        Node current=head;
        if(head==null)
        {
            System.out.println("No elements");
            return;
        }
        int i=1;
        while(current!=null && i<n)
        {
            i++;
            current=current.next;
        }
        System.out.print(current.data);
    }
    public static void main(String[] args)
    {
        Displayfirstn m=new Displayfirstn();
        m.insertBeg(10);
        m.insertEnd(20);
        m.insertEnd(30);
        m.display();
        m.displaynth(2);
    }
}
