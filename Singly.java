
public class Singly
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
    public void insertPos(int data,int pos)
    {
        if(pos<0)
        {
            System.out.println("Invalid position");
            return;
        }
        if(pos==1)
        {
            insertBeg(data);
            return;
        }
        Node newnode=new Node(data);
        Node current=head;
        for(int i=0;i<pos-1 && current!=null;i++)
        {
            current=current.next;
        }
        if(current==null)
        {
            System.out.println("Invalid position");
        }
        newnode.next=current.next;
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
        System.out.print("null");
        
    }
    public void delBeg()
    {
        System.out.println(head.data+" deleted");
        head=head.next;
        
    }
    public void delEnd()
    {
        Node current=head;
        while(current.next.next!=null)
        {
            current=current.next;
        }
        System.out.println(current.next.data+" deleted");
        current.next=null;
    }
    public void delPos(int pos)
    {
        Node current =head;
        if(pos<0)
        {
            System.out.println("Invalid position");
            return;
        }
        if(pos==1)
        {
            delBeg();
            return;
        }
        
        for(int i=0;i<pos-2 && current!=null;i++)
        {
            current=current.next;
        }
        if(current==null)
        {
            System.out.println("Invalid ");
            return;
        }
        System.out.println(current.next.data+" deleted");
        current.next=current.next.next;
 
    }
    
	public static void main(String[] args) {
		Singly m=new Singly();
		m.insertBeg(10);
		m.insertEnd(20);
		m.insertEnd(40);
		m.insertPos(30,2);
		m.display();
		System.out.println();
		m.delBeg();
		m.delEnd();
		m.display();
		System.out.println();
		m.insertBeg(10);
		m.insertEnd(40);
		
		m.display();
		System.out.println();
	}
}
/*
output:
10->20->30->40->null
10 deleted
40 deleted
20->30->null
10->20->30->40->null
  */
