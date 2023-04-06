
import java.util.Scanner;

public class Project {
    public static void main(String[] args) {
        Scanner scan =new Scanner (System.in);
        System.out.println("Enter the number of darts to be thrown: ");
      int n = scan.nextInt();
      int dart =n;
      double x = 0 ,y = 0;
  
        double  ca=0;
        double  cb =0;
        double  cc =0;
        double  cd =0;
        double  ce =0;
        double  cf =0;
        double  cun =0;
     
     double a,b;
     while(n>0)   {
         a=(int)(Math.random()*11);
         b=(int)(Math.random()*11);
         double k =a/10;
         double l =b/10;
         int m = (int)(Math.random()*4);
            switch (m) {
                case 0: x=k; y=l;break;
                case 1: x=-1*k; y=-1*l;break;
                case 2: x=k;y=-1*l;break;
                case 3 : x=-1*k;y=l; break;
                default:System.out.println("Error"); break;}
            double z= x+y;
            
         if(x>0 && y <0){
             
                System.out.println("Coordinates:("+x+","+y+")");
                System.out.println("Region:F");cf++; }
         else if(x<0&&y>0){
                 System.out.println("Coordinates:("+x+","+y+")");
                 System.out.println("Region:C");cc++;}
         else if(x>0 && y>0&&z<1){
               System.out.println("Coordinates:("+x+","+y+")");
               System.out.println("Region:A"); ca++;}
         else if (x>0&&y>0&&z>1){
              System.out.println("Coordinates:("+x+","+y+")");
              System.out.println("Region:B"); cb++;}
         else if (x<y&&x<0&&y<0){
              System.out.println("Coordinates:("+x+","+y+")");
              System.out.println("Region:D");cd++;}
         else if (x<0&&y<0&&y<x){
              System.out.println("Coordinates:("+x+","+y+")");
              System.out.println("Region:E");ce++;}
         else if(x+y==1){
              System.out.println("Coordinates:("+x+","+y+")");
              System.out.println("Region:Undecided"); cun++;}
         else if (x==y){
              System.out.println("Coordinates:("+x+","+y+")");
              System.out.println("Region:Undecided");cun++;}
 n--;}
int answera=(int)((ca*100)/dart);
int answerb=(int) ((cb*100)/dart);
int answerc=(int) ((cc*100)/dart);
int answerd=(int) ((cd*100)/dart);
int answere=(int) ((ce*100)/dart);
int answerf=(int) ((cf*100)/dart);
int answerun=(int) ((cun*100)/dart);
 
 
System.out.println("Region statistics:");
System.out.println("A:"+ca);
System.out.println("A=%"+answera);
System.out.println("B:"+cb);
System.out.println("B=%"+answerb);
System.out.println("C:"+cc);
System.out.println("C=%"+answerc);
System.out.println("D:"+cd);
System.out.println("D=%"+answerd);
System.out.println("E:"+ce);
System.out.println("E=%"+answere);
System.out.println("F:"+cd);
System.out.println("F=%"+answerf);
System.out.println("Undecided:"+cun);
System.out.println("Undecided=%"+answerun);
     
     
     
     
     
    }
      
    
    }
