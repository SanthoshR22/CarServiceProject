package com.practice.csa.example;

import java.util.List;
import java.util.function.Function;

public class CarExample {
	public static void main(String[] args) {
		
		List<String> numString = List.of(1,2,3,4,5,6,7,8,9,10)
		.stream()//[Stream<Iterable<Integer>>>]-returning.
		.map(num -> String.valueOf(num))//[Stream<Iterable<String>>].returing
		.toList();//[List<String>]
		
		
	}
		
}
