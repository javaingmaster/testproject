package project;
import java.util.ArrayList;

public class BasicCompute
{
    public static double compute_withoutR(ArrayList<Character> a,int start,int length,ArrayList<Double> b,int startN)
    {
        int beginvalue=start;
        int count=0;
        for(int i=start;beginvalue<start+length;beginvalue++)
        {
            if(a.get(i).equals('*')||a.get(i).equals('/')){
                if(a.get(i).equals('*')) {
                    double temp = Mul.mul(b.get(startN+i-start),b.get(startN+i-start+1));
                 
                    b.remove(startN+i-start);
                    b.remove(startN+i-start);
                    b.add(startN+i-start,temp);
                  
                    a.remove(i);
                   
                    count++;
                }else{
                    double temp = Div.div(b.get(startN+i-start),b.get(startN+i-start+1));
                  
                    b.remove(startN+i-start);
                    b.remove(startN+i-start);
                    b.add(startN+i-start,temp);
                 
                    a.remove(i);
               
                    count++;
                }
            }else {
              
                i++;
            }
        }
        beginvalue=start;
        for(int i=start;beginvalue<start+length-count;beginvalue++){
            if(a.get(i).equals('+')||a.get(i).equals('-')){
                if(a.get(i).equals('+')) {
                    double temp = Plus.plus(b.get(startN+i-start),b.get(startN+i-start+1));
                   
                    b.remove(startN+i-start);
                    b.remove(startN+i-start);
                    b.add(startN+i-start,temp);
                    a.remove(i);
                }else{
                    double temp =Sub.sub(b.get(startN+i-start),b.get(startN+i-start+1));
                  
                    b.remove(startN+i-start);
                    b.remove(startN+i-start);
                    b.add(startN+i-start,temp);
                    a.remove(i);
                }
            }else{
                System.out.println("basic error");
            }
        }

        return b.get(startN);
    }
}

