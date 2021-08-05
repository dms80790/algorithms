//David Stropkey
//CS 1501 Wehar
//Assignment 4

//NOTE TO GRADER: I know the program doesn't run and my method does not create the table with the maximum number of cookies for each
//combination of cost/time.  I couldn't figure out how to calculate the maximum number at each table cell, and I ran out of time. This 
//is simply as far as I got.

public class KnapsackSolver {

	public static int[][] buildTable(Order[] orders, int costLimit, int timeLimit){
	// Problem #1
	// Fill in this method to create a (costLimit + 1) by (timeLimit + 1) table
	// that for each (i, j) stores the maximum number of cookies that can be
	// produced with cost at most i in time at most j.
	
		int[][] table = new int[costLimit + 1][timeLimit + 1];
		
		for(int i = 0; i < costLimit + 1; i++){
			for(int j = 0; j < timeLimit + 1; j++)
				int totalCost = 0, totalTime = 0; tempCost = 0; tempTime = 0;    //keeps track of cost and time used for each cell
				int tempNumCookies = 0;   //keeps track of the number of cookies for each cell
				int orderNum = 0;
				
				for(int k = 0; k < orders.length; orders++){
					if((orders[k].cost < (i - totalCost)) && (orders[k].time < (j - totalTime))){
						if(orders[k].numCookies > tempNumCookies){
							tempNumCookies = orders[k].numCookies;
							orderNum = k;
						}	
						
						tempCost += orders[orderNum].cost;
						tempTime += orders[orderNum].time;
						table[i][j] = max(table[i-j], i);
						
					}//end if
				}//end orders for
			}//end j for
		}//end i for
	
		return table;
	}//end BuildTable

	public static Multiset solve(Order[] orders, int costLimit, int timeLimit){
	// Problem #2
	// Fill in this method to create a multiset that represents a combination of
	// cookie choices that maximizes the number of cookies with cost at most 
	// costLimit in time at most timeLimit.  Note: You can call buildTable as
	// a subroutine.
		
		int i = 0; int j = 0;
		int[][] maxTable;
		int maxCookies = 0;
	
	    //call to buildTable to calculate maximum number of cookies at each cost and time pair
		maxTable = buildTable(orders, costLimit, timeLimit);
	
		//find the maximum number of cookies
		for(int i = 0; i < (costLimit + 1); i++){
			for(int j = 0; j < (timeLimit + 1); j++){
				if(maxTable[i][j] > maxCookies){
					maxCookies = maxTable[i][j];
					cost = maxTable[i];
					time = maxTable[j];
				}//end if
			}//end time for
		}//end cost for
		
		//after finding the time and cost associated with the maximum number of cookies, calculate
		//how many of each order satisfies the time and cost.
		
		
		
		Multiset choices = new MultiSet();
		choices.add();
		
		return choices;
	}//end solve