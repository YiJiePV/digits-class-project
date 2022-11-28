/*Karena Qian
 * CS 210
 * May 13, 2020
 * This program contains methods that do various tasks, including finding the greatest common divisor
 * of 2 numbers, testing whether a set of numbers are consecutive, testing whether a number consists of only
 * odd numbers, calculating the sum of all the digits in a number, and calculating the range of the digits
 * in a number.*/
public class Assignment3 {
//use the main method for calling methods
	public static void main(String[] args) {
		//calls method gcd (finds greatest common divisor)
		int gcdTest1 = gcd(-927686892, 2);
		int gcdTest2 = gcd(0, 0);
		//sets boolean test and displays results
		boolean gcdTestAll = gcdTest1 == 2 && gcdTest2 == 0;
		System.out.println(gcdTest1 + " & " + gcdTest2 + " = " + gcdTestAll);
		
		//calls method allDigitsOdd (tests whether integer has only odd digits)
		boolean oddTest1 = allDigitsOdd(-79957);
		boolean oddTest2 = allDigitsOdd(79957);
		boolean oddTest3 = allDigitsOdd(0);
		//displays results
		System.out.println(oddTest1 + ", " + oddTest2 + ", " + oddTest3);
		
		//calls method consecutive (tests whether set of integers are consecutive)
		boolean conTest1 = consecutive(984753, 984754, 984755);
		boolean conTest2 = consecutive(0, 0, 0);
		//displays results
		System.out.println(conTest1 + ", " + conTest2);
		
		//calls digitSum (calculates sum of all digits in integer)
		int testSum1 = digitSum(568679);
		int testSum2 = digitSum(-568679);
		int testSum3 = digitSum(0);
		//displays results
		System.out.println(testSum1 + ", " + testSum2 + ", " + testSum3);
		
		//calls digitRange (calculates range of digits in integer)
		int testRange1 = digitRange(799857);
		int testRange2 = digitRange(0);
		//displays results
		System.out.println(testRange1 + ", " + testRange2);

	}
	//int method for gcd takes in 2 int values
	public static int gcd(int num1, int num2){ 
		//set and initialize storage variable 
	    int storeNum = 0;
	    //while the 2nd number doesn't equal 0...
	    while(num2 != 0){
	    	//swap 1st num w/ 2nd num and 2nd num w/ remainder of 1st num / 2nd num
	        storeNum = num1 % num2;
	        //1st num will become the divisor
	        num1 = num2; 
	        //update while loop
	        num2 = storeNum;
	    }
	    //return the value of divisor
	    return Math.abs(num1);
	}
	//boolean method for consecutive takes in 3 int values
	public static boolean consecutive(int num1, int num2, int num3){
		//set and initialize boolean variable
	    boolean test = false;
	    //if numbers fulfill one of the 6 different orders (specifically k k+1 k+2), they are consecutive
	    //if 1st num is GREATER than 2nd num...
	    if(num1 > num2){
	    	//...and 1st num is LESS than 3rd num
	        if(num1 < num3){
	        	//the order is: Num2 Num1 Num3
				test = num2 == num1 - 1 && num3 == num1 + 1;
	        }
	        //ELSE: ...and 1st num is GREATER than 3rd num...
	        else{
	        	//...and 2nd num is LESS than 3rd num
	            if(num2 < num3){
	            	//the order is: Num2 Num3 Num1
					test = num2 == num3 - 1 && num1== num3 + 1; 
	            }
	            //ELSE: ...and 2nd num is GREATER than 3rd num
	            else{
	            	//the order is: Num3 Num2 Num1
					test = num3 == num2 - 1 && num1 == num2 + 1;
	            }
	        }
	    }
	    //ELSE: 1st num is LESS than 2nd num...
	    else{
	    	//...and 2nd num is LESS than 3rd num
	        if(num2 < num3){
	        	//the order is: Num1 Num2 Num3
				test = num1 == num2 -1 && num3 == num2 + 1;
	        }
	        //ELSE: ...and 2nd num is GREATER than 3rd num
	        else{
	        	//...and 1st num is LESS than 3rd num
	            if(num1 < num3){
	            	//the order is: Num1 Num3 Num2
					test = num1 == num3 - 1 && num2 == num3 + 1;
	            }
	            //ELSE: ...and 1st num is GREATER than 3rd num
	            else{
	            	//the order is: Num3 Num1 Num2
					test = num3 == num1 - 1 && num2 == num1 + 1;
	            }
	        }
	    }
	    //returns resulting boolean
	    return test;
	}
	//int method for digitSum takes in 1 int value
	public static int digitSum(int pm){
		//set and initialize storage variable
	    int total = 0;
	    //while the absolute value of parameter is greater than 0...
	    while(Math.abs(pm) > 0){
	    	//add one digit from right to total
	        total += Math.abs(pm) % 10;
	        //eliminates last digit and moves number to right and updates loop
	        pm = pm / 10;
	    }
	    //returns sum
	    return total;
	}
	//int method for digitRange takes 1 int value
	public static int digitRange(int pm){
		//set and initialize storage variables
	    int number = Math.abs(pm) % 10;
	    int max = number;
	    int min = number;
	    //while the absolute value of parameter is greater than 0...
	    while(Math.abs(pm) > 0){
	    	//if rightmost digit is greater than max and former digit (or equals latter)...
	        if(Math.abs(pm) % 10 > max && Math.abs(pm) % 10 >= number){
	        	//set max to new right digit
	            max = Math.abs(pm) % 10;
	        }
	        //else if rightmost digit is smaller than min and former digit (or equals latter)...
	        else if (Math.abs(pm) % 10 < min && Math.abs(pm) % 10 <= number){
	        	//set min to new right digit
	            min = Math.abs(pm) % 10;
	        }
	        //update former digit and loop
	        number = Math.abs(pm) % 10;
	        pm = pm / 10;
	    }
	    //calculate range and return result
	    int range = max - min + 1;
	    return range;
	}
	//boolean method for allDigitOdd takes in 1 int variable
	public static boolean allDigitsOdd(int num){
		//set and initialize boolean and storage variables
	    boolean isOdd = false;
	    int digit = 0;
	    //while the absolute value of num is greater than 0
	    while(Math.abs(num) > 0){
	    	//update storage to rightmost digit
	        digit = num % 10;
	        //if digit is even number
	        if (digit % 2 == 0){
	        	//change boolean to false and stop the whole process
	            isOdd = false;
	            break;
	        }
	        //else if digit is odd number
	        else if(digit % 2 != 0){
	        	//change boolean to true and update loop
	            isOdd = true;
	            num = num / 10;
	        }
	    }
	    //return resulting boolean
	    return isOdd;
	}
}
