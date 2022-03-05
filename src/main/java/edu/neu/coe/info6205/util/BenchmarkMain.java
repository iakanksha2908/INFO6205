package edu.neu.coe.info6205.util;
import java.util.*;
import com.google.common.base.Supplier;

import edu.neu.coe.info6205.sort.Helper;
import edu.neu.coe.info6205.sort.elementary.InsertionSort;

public class BenchmarkMain<X> {


	
	public static void main(String[] args) {
		
		InsertionSort in = new InsertionSort();
		int length = 12000;
		int reps = 500; 
		Random random = new Random();
		
		Integer[] sorted = new Integer [length];
		Integer[] random_arr = new Integer [length];
		Integer[] reverse = new Integer [length];
		Integer[] partial_or= new Integer [length];
		
		//For random array
		for (int i = 0; i < length; i++) {
			random_arr[i] = (int)(Math.random()*100);
			sorted[i] = random_arr[i];
			
		}
		
		
		
		in.sort(sorted); //sorted array
		
		for(int i=0;i<sorted.length;i++) {
			
			if(i<=length/2)
				partial_or[i]= sorted[i];	//partially ordered
			else 
				partial_or[i] = random_arr[i];
			
			reverse[length-i-1] = sorted[i];	//reverse ordered
			
		}

		
		
		Benchmark_Timer<Integer[]> timer_r = new Benchmark_Timer<>("BenchMarking",null,(x) -> in.sort(x,0,x.length), null);
				
				Supplier s_reverse = () -> reverse;
				Supplier s_random = () -> random_arr;
				Supplier s_partial = () -> partial_or;
				Supplier s_sorted = () -> sorted;
				
				double time_reverse = timer_r.runFromSupplier(s_reverse, reps);
			
				double time_sorted = timer_r.runFromSupplier(s_sorted,reps);
				System.out.println("For sorted array of length n " +length+ " mean time: " +time_sorted);
				System.out.println();
				
				double time_partial = timer_r.runFromSupplier(s_partial,reps);
				System.out.println("For partial array of length n " +length+ " mean time: " +time_partial);
				System.out.println();
				
				double time_random = timer_r.runFromSupplier(s_random,reps);
				System.out.println("For random array of length n " +length+ " mean time: " +time_random);
				System.out.println();
				
				
				System.out.println("For reverse array of length n " +length+ " mean time: " +time_reverse);
				System.out.println();
				
			}

}








				
//***********************
				
//				List<Integer> list = new ArrayList<Integer>();
//				
//				for(int i = 0;i<100;i++) {
//					list.add(i);
//				}
//				
//				Collections.shuffle(list);
//				Integer[] arr = new Integer[list.size()];
//				arr = list.toArray(arr);
//				List<Integer> finalist = Arrays.asList(arr);
//				
//		Consumer< Integer[]> arrconsumer = arr2->
//		{
//			
//			is.sort(arr,0,arr.length);
//		};
////		
//		Benchmark_Timer benchmark = new Benchmark_Timer<Integer[]>("TEST", arrconsumer);
//		
//		
//		Supplier<List<Integer>> supplier = ()-> finalist;
//		
//		 
//		 System.out.println("Final output is " + benchmark.runFromSupplier(supplier, 10));
//		

