package project;


public class Div
{
    public static double div(double x,double y)
    {
        if(y!=0.0) {
                return x / y;
        }else{
            System.out.println("div 0 error");
            return 0;
        }
    }
}
