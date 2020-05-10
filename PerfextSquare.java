/*
 Given a positive integer num, write a function which returns True if num is a perfect square else False.
Note: Do not use any built-in library function such as sqrt.

Example 1:
Input: 16
Output: true

Example 2:
Input: 14
Output: false
 */
public class PerfextSquare
{

	public boolean isPerfectSquare(int num) 
    {
       
        int flag=0;
        if(num%2==0)
        {
            for(int i=2;i<=(num/2);i=i+2)
            {
                if((i*i)==num)
                {
                    flag=1;
                    break;
                }
                else if((i*i)>num)
                {
                    break;
                }
            }
            if(flag==1)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            if(num==1)
            {
                return true;
            }
            else
            {
                for(int i=1;i<=(num/2);i=i+2)
                {
                    if((i*i)==num)
                    {
                        flag=1;
                        break;
                    }
                    else if((i*i)>num)
                    {
                        break;
                    }
                }
                if(flag==1)
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
            
        }
    }
        
        
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		PerfextSquare p=new PerfextSquare();
		System.out.print(p.isPerfectSquare(14));

	}

}
