
public class Reverse
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
    public void reverse()
	{
	    Node current=head;
	    Node prev=null;
	    Node next=null;
	    while(current!=null)
	    {
	        next=current.next;
	        current.next=prev;
	        prev=current;
	        current=next;
	    }
	    head=prev;
	    display();
	}
    public static void main(String[] args)
    {
        Reverse m =new Reverse();
        m.insertBeg(10);
        m.insertEnd(20);
        m.insertEnd(30);
        m.display();
        m.reverse();
    }
  /*
output:
10->20->30->40->null
20->10->40->30->null
  */
}
