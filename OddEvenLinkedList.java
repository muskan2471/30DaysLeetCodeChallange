/*
Given a singly linked list, group all odd nodes together followed by the even nodes. 
Please note here we are talking about the node number and not the value in the nodes.
You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

Example 1:
Input: 1->2->3->4->5->NULL
Output: 1->3->5->2->4->NULL

Example 2:
Input: 2->1->3->5->6->4->7->NULL
Output: 2->3->6->7->1->5->4->NULL
 */

class ListNode {
    int val;
	ListNode next;
	ListNode() 
	{
		   
	}
	 ListNode(int val) 
	 { 
		 this.val = val;
	 }
	 ListNode(int val, ListNode next) 
	 { this.val = val;
	 this.next = next; 
	 }
 }
 
public class OddEvenLinkedList
{
	ListNode list;
    ListNode evenList;
    ListNode oddList;
    void insertInEven(int d)
    {
        if(evenList==null)
        {
            evenList=new ListNode(d);
        }
        else
        {
            ListNode current=evenList;
            while(current.next!=null)
            {
                current=current.next;
            }
            current.next=new ListNode(d);
        }
    }
    void insertInOdd(int d)
    {
        if(oddList==null)
        {
            oddList=new ListNode(d);
        }
        else
        {
            ListNode current=oddList;
            while(current.next!=null)
            {
                current=current.next;
            }
            current.next=new ListNode(d);
        }
    }
    ListNode joinList()
    {
        list=oddList;
        ListNode current=list;
        while(current.next!=null)
        {
            current=current.next;
        }
        current.next=evenList;
        return list;
    }
    public ListNode oddEvenList(ListNode head) 
    {
        if(head==null)
        {
            return null;
        }
        else
        {
            int i=1;
            ListNode current=head;
            while(current!=null)
            {
                if(i%2==0)
                {
                    insertInEven(current.val);
                }
                else
                {
                    insertInOdd(current.val);
                }
                current=current.next;
                i=i+1;
            }
            ListNode list=joinList();
            return list;
        }   
    }
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		OddEvenLinkedList n=new OddEvenLinkedList();
		ListNode head=new ListNode(30);
		head.next=new ListNode(40);	
		head.next.next=new ListNode(50);	
		head.next.next.next=new ListNode(60);
		ListNode newNode=n.oddEvenList(head);
		while(newNode!=null)
		{
			System.out.print(newNode.val+" ");
			newNode=newNode.next;
		}

	}

}
