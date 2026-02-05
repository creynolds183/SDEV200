package MatchGroupSymbols;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class MatchGroupSymbolsClass {
    public static void main(String[] args) {
        // create blank variables for later use
        String data = "";
        Stack<String> fileStack = new Stack<>();
        int mismatchedGroupingSymbols = 0;

        // get user input
        Scanner newFile = new Scanner(System.in);
        
        //use the input to get a file catch if file does not exist
        String fileName = newFile.nextLine();
        try {
            Scanner file = new Scanner(new File(fileName));
            while (file.hasNextLine()){
                data = data + file.nextLine();
                
            }
            //convert file into an array of strings
            List<String> fileArray = new ArrayList<String>(Arrays.asList(data.trim().split("")));
            //get all grouping symbols into a stack checking when adding a symbol if a single symbol is mismatched the file has inccorect grouping pairs
            for (String c : fileArray) {
                if (c.equals("[")){
                    fileStack.add(c);
                } else if(c.equals("]")){
                    if (fileStack.isEmpty()){
                        mismatchedGroupingSymbols ++;
                    }else if(!fileStack.pop().equals("[")){
                        mismatchedGroupingSymbols ++;
                    }
                } else if (c.equals("{")){
                    fileStack.add(c);
                }else if ( c.equals("}")){
                    if (fileStack.isEmpty()){
                        mismatchedGroupingSymbols ++;
                    }else if(!fileStack.pop().equals("{")){
                        mismatchedGroupingSymbols ++;
                    }
                }else if (c.equals("(")){
                    fileStack.add(c);
                }else if( c.equals(")")){
                    if (fileStack.isEmpty()){
                        mismatchedGroupingSymbols ++;
                    }else if(!fileStack.pop().equals("(")){
                        mismatchedGroupingSymbols ++;
                    }
                }
                
            }

            if (mismatchedGroupingSymbols > 0){
                System.out.println("incorrect grouping pairs");
            }else {
                System.out.println("Correct grouping pairs");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Please enter a valid file, restart program."); 
        }
        
    }
}
