/*
Given an input of aaabbbbcca, output 3a4b2c1a
 */

public class CharCount1a2b3c {
    public String charCount(String input){
        StringBuilder returnString = new StringBuilder();
        char[] charArray = input.toCharArray();

        //check if input is empty
        if(charArray.length == 0){
            return "";
        }

        int consecCount = 0;
        char currChar = charArray[0];

        for(int i = 0; i < charArray.length; i++){
            if(currChar == charArray[i]){
                consecCount++;
            }else{
                returnString.append(consecCount+""+currChar);
                consecCount = 1;
                currChar = charArray[i];
            }
        }

        if(consecCount > 0){
            returnString.append(consecCount+""+currChar);
        }

        return returnString.toString();
    }

    public static void main(String args[]){
        CharCount1a2b3c test = new CharCount1a2b3c();
        System.out.println(test.charCount("aaabbbbcca"));
    }
}
