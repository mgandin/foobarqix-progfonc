package com.octo.spike;

import java.util.List;
import java.util.Map;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;

public class FooBar {

	private Integer n = 0;
	private char integerAsChar;
	private String result = "";
	
	private Map<Integer, String> codes = ImmutableMap.of(3,"FOO",5,"BAR",7,"QIX");
	private Map<Character, String> codesContains = ImmutableMap.of('3',"FOO",'5',"BAR",'7',"QIX");

	List<Integer> integers = Lists.newArrayList(3,5,7);
	List<Character> chars = Lists.newArrayList('3','5','7');
	
	private Predicate<Integer> modulo = new Predicate<Integer>() {

		public boolean apply(Integer modulo) {
			return n % modulo == 0;
		}

	};
	
	private Predicate<Character> contains = new Predicate<Character>() {

		public boolean apply(Character toContains) {
			return integerAsChar == toContains;
		}

	};
	
	private Function<Integer, String> map = new Function<Integer, String>() {

		public String apply(Integer integer) {
			return codes.get(integer);
		}

	};
	
	private Function<Character, String> mapContains = new Function<Character, String>() {

		public String apply(Character integer) {
			return codesContains.get(integer);
		}

	};
	
	private Function<String, String> concat = new Function<String, String>() {

		public String apply(String integer) {
			result += integer;
			return result;
		}

	};
	
	public String translate(Integer integer) {
		n = integer;
	
		String foobarModulo = FluentIterable.from(integers).filter(modulo).transform(map).transform(concat).last().or("");
		String integerAsString = String.valueOf(integer);
		for (int i = 0; i < integerAsString.length(); i++) {
			integerAsChar = integerAsString.charAt(i);
			foobarModulo += FluentIterable.from(chars).filter(contains).transform(mapContains).first().or("");
		}
		return foobarModulo.isEmpty() ? integer.toString() : foobarModulo ;
	}

	public static void main(String[] args) {
		
		for (int i = 1; i <= 100; i++) {
			System.out.println(new FooBar().translate(i));
		}
	}

}
