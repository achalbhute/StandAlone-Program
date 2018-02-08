import java.util.*;
import java.lang.*;
import java.io.*;

class Gridle
{
    static List<Integer> transaction(int size, int[] input){
        int[] right= new int[size]; 
        List<Integer> output = new ArrayList<Integer>();
        int prev=0;
        for(int i=size-1; i>=0; i--){
            if(i==size-1)
                right[i]=0;
            else{
		    prev+=input[i+1];
		    right[i]=prev;
	    }
        }
        prev=0;
        if(right[0]==0){
                output.add(0);
	}
        for(int i=1; i<size; i++)
        {
            prev+=input[i-1];
            if(right[i] == prev){
                output.add(i);
            }
        }
        return output;
    }
	public static void main (String[] args) throws java.lang.Exception
	{
	    	int[] input= {9,-7,6,-8,3,-9,-5,3,-6,-8,5};
		for(int pos:transaction(11,input))
    			System.out.println(pos);
	}
}
