import java.io.*;
import java.util.Scanner;


class main{

    public static void main(String[] args){

        String[] a1 = new String[1000];
        readFile(a1);
        boolean check = true;
        int sum = 0;

        System.out.println(a1.length);
        for(int i = 0;i<a1.length;i++){
            int temp = 0;
            for(int k=0;check;k++){
                if(Character.isDigit(a1[i].charAt(k))){
                    temp = Character.getNumericValue(a1[i].charAt(k))*10;
                    check = false;
                }
            }
            for(int l=a1[i].length()-1;check == false;l--){
                if(Character.isDigit(a1[i].charAt(l))){
                    temp += Character.getNumericValue(a1[i].charAt(l));
                    check = true;
                }
            }
            sum+=temp;
            

        }
        System.out.println(sum);




    }

    public static void readFile(String [] a1){
        int i = 0;
        try {
        File myObj = new File("input.txt");
        Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
            a1[i]= myReader.nextLine();
            i++;
            
        }
        myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
        }

        
    }


}




