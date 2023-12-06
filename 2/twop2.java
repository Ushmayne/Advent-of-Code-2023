import java.io.*;
import java.util.Scanner;
import java.util.regex.*;
import java.util.HashMap;


class main{

    public static void main(String[] args){

        String[] a1 = new String[100];
        readFile(a1);
        int sum = 0;

        

        for(int i = 0;i<a1.length;i++){//a1.length
            

            sum+=power(a1[i]);

        }

        System.out.println(sum);




    }

    /*
     * keep a hash map that tracks how many of each color has been used before the semi colon, 
     * if at any point they are more than what is possible return false
     * 12 red, 13 green and 14 blue
     */
    public static int power(String a){
        int games = numbGames(a);//using to find out how many games there are 
        String [] s1 = a.split(":");//first split it at the semi colon
        String [] s2 = s1[1].split(";");
        int minr=1, ming=1, minb=1;


        //System.out.println(a);
        for(int i=0;i<s2.length;i++){
            //System.out.println(s2[i]);
        }
        

        for(int i = 0; i < games; i++){

            HashMap<String, Integer> colors = new HashMap<String, Integer>();
            colors.put("Red",0);
            colors.put("Green",0);
            colors.put("Blue",0);
            
            
            String [] s3 = s2[i].split(",");

            for(int j=0;j<s3.length;j++){

                int temp = 0;

                boolean t1 = true;
                //System.out.println(s3[j]);

                for(int k=0;t1;k++){
                    if(Character.isDigit(s3[j].charAt(k))){
                        if(Character.isDigit(s3[j].charAt(k+1))){
                            temp = ((Character.getNumericValue(s3[j].charAt(k)))*10)+Character.getNumericValue(s3[j].charAt(k+1));
                            k++;
                        }else{
                            temp = Character.getNumericValue(s3[j].charAt(k));

                        }
                    
                    
                }
                
                

                //System.out.println(s3[j].charAt(k));

                switch (s3[j].charAt(k)){

                    case 'r':
                    //System.out.println(colors.get("Red"));
                    temp+=colors.get("Red");
                    colors.put("Red",temp);
                    t1 = false;
                    break;

                    case 'g':
                    temp+=colors.get("Green");
                    colors.put("Green",temp);
                    t1 = false;
                    break;

                    case 'b':
                    temp+=colors.get("Blue");
                    colors.put("Blue",temp);
                    t1 = false;
                    break;
                    
                    default:
                    break;
                }


                }
                

                
                

                //System.out.println(s3[j]);
            }
            if(colors.get("Red")>minr){
                minr=colors.get("Red");
            }
             if(colors.get("Green")>ming){
                ming=colors.get("Green");
            }
             if(colors.get("Blue")>minb){
                minb=colors.get("Blue");

            }


            //for(int j = 0; )


        }



        return(ming*minr*minb);
    }


    public static int numbGames(String a){

        int count = 1;

        Pattern pat = Pattern.compile(";");
        Matcher mat = pat.matcher(a);
        

        while(mat.find())
            count++;

            //System.out.println("+");
        return(count);
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


