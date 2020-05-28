
public class CountingBits 
{
	public int[] countBits(int num) 
    {
        int res[]=new int[num+1];
        res[0]=0;
        for(int i=1;i<=num;i++)
        {
            res[i]=count(i);
        }
        return res;
        
    }
    int count(int num)
    {
        int cnt=0;
        while(num!=0)
        {
            int rem=num%2;
            if(rem==1)
            {
                cnt++;
            }
            num=num/2;
        }
        return cnt;
    }

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		CountingBits c=new CountingBits();
		int res[]=c.countBits(5);
		for(int i=0;i<res.length;i++)
		{
			System.out.print(res[i]+" ");
		}

	}

}
