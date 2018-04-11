import java.util.Scanner;

public class HannuoTest {
	
	public void move(char from, char to){
		System.out.println(from+"-->"+to);
	}

	public void HannuoMethod(int level,char a,char b, char c){
		if(level==1){
			this.move(a, c);
		}else{
			HannuoMethod(level-1,a,c,b);
			this.move(a, c);
			HannuoMethod(level-1,b,a,c);
		}
	}

		public static void main(String[] args){
			HannuoTest h=new HannuoTest();
			h.HannuoMethod(5, 'A', 'B', 'C');
		
		}

   /* public void move(char N,char M)
    {
        System.out.println("´Ó " + N +" ->ÒÆµ½->  " + M);
    }

    public void hanoi(int n,char A,char B,char C)
    {
        if(n == 1)
        	this.move( A, C);
        else
        {
            hanoi(n - 1, A, C, B);
            this.move( A, C);
            hanoi(n - 1, B, A, C);
        }
    }
    public static void main(String[] args) {
    	HannuoTest h=new HannuoTest();

        h.hanoi(4, 'A', 'B', 'C');

    }*/
	
	
	
}
