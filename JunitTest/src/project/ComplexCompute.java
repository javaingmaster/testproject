package project;

import java.util.ArrayList;

public class ComplexCompute
{
    static String temp=null;
    public static String complexcompute(ArrayList<Character>sign, ArrayList<Double>number,String display){
      
        String processString=display;

        boolean isleftR=false;
        int leftbound=0,rightbound;

        for(int i=0;i<processString.length();i++){
            if(processString.charAt(i)=='('){
                sign.add(processString.charAt(i));
                isleftR=true;

            }
            else if(processString.charAt(i)==')'||processString.charAt(i)=='+'||processString.charAt(i)=='*'||processString.charAt(i)=='/'){
                sign.add(processString.charAt(i));
                isleftR=false;

            }else if(processString.charAt(i)=='-'&&!isleftR&&i!=0){
                sign.add(processString.charAt(i));
                isleftR=false;

            }else if (processString.charAt(i)=='-'&&(isleftR||i==0)){
                if(i==0){
                    leftbound = i+1;
                    for (rightbound = leftbound; rightbound < processString.length(); rightbound++) {
                        if (processString.charAt(rightbound) == '(' || processString.charAt(rightbound) == ')' || processString.charAt(rightbound) == '+' || processString.charAt(rightbound) == '-' || processString.charAt(rightbound) == '*' || processString.charAt(rightbound) == '/') {
                            number.add(Double.parseDouble(processString.substring(leftbound-1, rightbound)));
                            break;
                        }
                    }
                    if (rightbound == processString.length()) {
                        number.add(Double.parseDouble(processString.substring(leftbound-1, rightbound - 1) + processString.charAt(processString.length() - 1)));
                    }
                    isleftR = false;
                    i = rightbound - 1;

                }else {
                    leftbound = i+1;
                    for (rightbound = leftbound; rightbound < processString.length(); rightbound++) {
                        if (processString.charAt(rightbound) == '(' || processString.charAt(rightbound) == ')' || processString.charAt(rightbound) == '+' || processString.charAt(rightbound) == '-' || processString.charAt(rightbound) == '*' || processString.charAt(rightbound) == '/') {
                            number.add(Double.parseDouble(processString.substring(leftbound-1, rightbound)));
                            break;
                        }
                    }
                    if (rightbound == processString.length()) {
                        number.add(Double.parseDouble(processString.substring(leftbound-1, rightbound - 1) + processString.charAt(processString.length() - 1)));
                    }
                    isleftR = false;
                    i = rightbound - 1;

                }
            }else if((processString.charAt(i)>='0')&&(processString.charAt(i)<='9')){
                leftbound=i;
                for(rightbound=leftbound;rightbound<processString.length();rightbound++){
                    if(processString.charAt(rightbound)=='('||processString.charAt(rightbound)==')'||processString.charAt(rightbound)=='+'||processString.charAt(rightbound)=='-'||processString.charAt(rightbound)=='*'||processString.charAt(rightbound)=='/'){
                        number.add(Double.parseDouble(processString.substring(leftbound,rightbound)));
                        break;
                    }
                }
                if(rightbound==processString.length()){
                    number.add(Double.parseDouble(processString.substring(leftbound,rightbound-1)+processString.charAt(processString.length()-1)));
                }
                isleftR=false;
                i=rightbound-1;

                //System.out.println(i);
            }
            else{
                System.out.println("计算表达式输入错误");
            }
        }

        int leftRCount=0,leftRLastindex=-1,leftNindex=0,rightRindex=0;

        for(int i=0;i<sign.size();i++){
            if(sign.get(i).equals('(')){
                leftRCount++;
            }
        }

        if(leftRCount==0){
            return String.valueOf(BasicCompute.compute_withoutR(sign,0,sign.size(),number,0));
        
        }else {

            for (int loop = 0; loop < leftRCount; loop++) {

                for (int i = 0; i < sign.size(); i++) {
                    if (sign.get(i).equals('(')) {
                        leftRLastindex = i;
                    }
                }

                for (int i = 0; i < sign.size(); i++) {
                    if (i < leftRLastindex && (sign.get(i).equals('+') || sign.get(i).equals('-') || sign.get(i).equals('*') || sign.get(i).equals('/'))) {
                        leftNindex++;
                    }
                    if (i > leftRLastindex && sign.get(i).equals(')')) {
                        rightRindex = i;
                        break;
                    }
                }

                double temp = BasicCompute.compute_withoutR(sign, leftRLastindex + 1, rightRindex - leftRLastindex - 1, number, leftNindex);

                sign.remove(leftRLastindex);
                sign.remove(leftRLastindex);
                leftNindex = 0;
            }

            return String.valueOf(BasicCompute.compute_withoutR(sign, 0, sign.size(), number, 0));          
        }
    }
}