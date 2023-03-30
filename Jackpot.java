package Java;
import java.util.Random;
import java.util.Scanner;

public class Jackpot {
    
public static void main(String[] args) {
    
    int[] arrayTarget = {0,0,0,0,0,0,0};
    /**  this is a comment */
    Random r = new Random();
    try (Scanner s = new Scanner(System.in)) {
        for (int i = 0; i < arrayTarget.length-1; ) {
            int number = r.nextInt(33) + 1;
            if(!contain(arrayTarget,number)){
                arrayTarget[i] = number;
                i++;
            }
        }    
        arrayTarget[6]= r.nextInt(16) + 1;

        System.out.println("================");
        for (int j = 0; j < arrayTarget.length; j++) 
            System.out.print(arrayTarget[j] + " ");
        System.out.println("\n================");

        int[] UserArray = {0,0,0,0,0,0,0};
        for (int i = 0; i < UserArray.length; i++) {
            UserArray[i] = s.nextInt();
        }

        int RedCount = 0; int BlueCount = 0;
        int RedArray[]={0,0,0,0,0,0};
        
        for (int k = 0; k < RedArray.length; k++) 
            RedArray[k] = arrayTarget[k];
        
        for (int i = 0; i < UserArray.length-1; i++) {
            if(contain(RedArray, UserArray[i]))
                RedCount++;
        }
        if(arrayTarget[6]==UserArray[6])
            BlueCount++;
        //System.out.println("RedCount="+RedCount+" "+"BlueCount="+BlueCount);

        if(RedCount==6 && BlueCount==1)
            System.out.println("中奖1000万");
        else if(RedCount==6 && BlueCount==0)
            System.out.println("中奖500万");
        else if(RedCount==5 && BlueCount==1)
            System.out.println("中奖3000元");
        else if((RedCount==5 && BlueCount==0)||(RedCount==4 && BlueCount==1))
            System.out.println("中奖200元");
        else if((RedCount==4 && BlueCount==0)||(RedCount==3 && BlueCount==1)||RedCount==2 && BlueCount==1)
            System.out.println("中奖10元");
        else if((RedCount==1 && BlueCount==1)||(RedCount==0 && BlueCount==1))
            System.out.println("中奖5元");
        else
            System.out.println("谢谢惠顾");
    }
}

public static boolean contain (int[] array,int key){
    boolean flag=false;
    for (int i = 0; i < array.length; i++) 
        if(array[i]==key)
            flag = true;
    return flag;
}
}
