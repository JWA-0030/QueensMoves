//Jesse Alsing

import java.io.*;
import java.util.*;
import java.lang.*;
import static java.lang.Math.pow;

public class SneakyQueens{
	
	 public static boolean allTheQueensAreSafe(ArrayList<String> coordinateStrings, int boardSize){
		 
		 //Here I initialize all my hash tables
		 //I used hash tables because they have the fastest search time of O(n) average and because if we encounter a hit we immediate break the Big-Oh is always O(1)
		HashSet<Integer> xValue = new HashSet<>();
		HashSet<Integer> yValue = new HashSet<>();
		HashSet<Integer> D1Value = new HashSet<>();
		HashSet<Integer> D2Value = new HashSet<>();
		
		//this is my only for loop to loop through all the coordinates
		for(int i = 0; i < coordinateStrings.size(); i++){
			// I could have just tested if it was a character and made a new array as long as it was a letter but I know i can split it
			//by going to the index where letters and numbers meet and one aray looks behind it and takes all the letters, the other looks infront of the split
			// and making a string with the numbers
			String[] part = coordinateStrings.get(i).split("(?<=\\D)(?=\\d)");
			// this is my function call to convert the bases
			int xval = charToInt(part[0]);
			//this is a fun java function that changes all the numbers in an array to thier int values (in base 10)
			int yval = Integer.parseInt(part[1], 10);
			/*I used this function because we know the slope of a line is y = mx + b so i know that the slope (b) will always be 1
			in this case so i solved for m and dropped the 1 bcasue no diagonal on a chess boards slope will be different than 1*/
			int DiagonalDown = xval + yval;
			int DiagonalUp = xval - yval;
			
			//here I find if any value is found more than once and if a hit occurs i return false, if not i add the values to the hash tables
			if(xValue.contains(xval)|| yValue.contains(yval)|| D1Value.contains(DiagonalDown)|| D2Value.contains(DiagonalUp)){
				return false;
			}
			else{
				xValue.add(xval);
				yValue.add(yval);
				D1Value.add(DiagonalDown);
				D2Value.add(DiagonalUp);
			}
		 }
		 return  true;
	 }
	 
	 public static int charToInt(String xValue){
		 int sum = 0, val = 0;
		// i had to do a length variable because i decrement length later and iff i just used the length it throws off the for loop
		 int length = xValue.length();
		 
		 for(int i = 0; i < xValue.length(); i++){
			//I know that I can just subtract the ASCII value of lower case a and add one 
			val = (xValue.charAt(i) - 'a') + 1;
			sum += val * pow(26, --length);
		 }
		 return sum;
	 }
	 
	 //although this assignment required alot of thought (mostly about diagonals), I rally enjoyed this assignment
	 //fixing errors was my biggest difficulty becasue my java knowledge is a bit rusty
	 public static double difficultyRating(){

		 return 2.2;
	 }
	//approximately half this time was fixing my syntactic errors lol
	 public static double hoursSpent(){
		 return 15;
	 }

	
	
}