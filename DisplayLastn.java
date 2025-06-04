
public class DisplayLastn
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
    public void displaynthend(int n)
    {
        Node current=head;
        if(head==null)
        {
            System.out.println("No elements");
            return;
        }
        Node slow=head,fast=head;
        while(n>0)
        {
            fast=fast.next;
            n--;
        }
        while(fast!=null)
        {
            slow=slow.next;
            fast=fast.next;
        }
        
        System.out.print(slow.data);
    }
    public static void main(String[] args)
    {
        DisplayLastn m=new DisplayLastn();
        m.insertBeg(10);
        m.insertEnd(20);
        m.insertEnd(30);
        m.display();
        m.displaynthend(2);
    }
/*
output:
10->20->30->null
20
*/
}
