package lab1;
public class lab1 {
	public static int a(int a,int b,int c)
	{
		int k =0;
		if((a <= 0 || b <= 0 || c <= 0)||(a + b <= c || a + c <= b || b + c <= a))
		{
			k=-1;
			System.out.println("Not a triangle!");
			return k;
		}
		else 
		{
			if(a == b || a == c || b == c)
			{
				if(a==b && b==c)
				{
					System.out.println("Is a equilateral!");
					k=1;
					return k;
				}
				else
				{
					System.out.println("Is a isosceles!");
					k=2;
					return k;
				}
			}
			else
			{
				System.out.println("Is a scalene!");
				k=3;
				return k;
			}
		}
	}
	public static void main(String args[])
	{	
		a(0,0,0);
		a(1,1,1);
		a(2,2,3);
		a(3,4,5);
	}
}
