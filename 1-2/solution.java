import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class Solution{
    private static int getNum(String line){
        int first = -1, last=0;
        for(char c: line.toCharArray()){
            if(Character.isDigit(c)){
                last = Character.getNumericValue(c);
                if(first<0) first = last;
            }
        }
        return (first*10)+last;
    }

    public static void main(String[] args){
        File f = new File("./input.txt");
        Scanner sc;

        int ans=0;
        try{
            sc = new Scanner(f);
            
            String line;
            while(sc.hasNextLine()){
                line = sc.nextLine();
                ans+=getNum(line);
            }

            sc.close();
        } catch(FileNotFoundException e){
            System.out.println("File not found.");
        }

        System.out.println("Answer = " + ans);
    }
}