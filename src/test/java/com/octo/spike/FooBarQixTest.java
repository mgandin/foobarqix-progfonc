package com.octo.spike;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FooBarQixTest {

	@Test public void should_return_number() {
		// Given
		FooBar fooBar = new FooBar();
		
		// When
		String result = fooBar.translate(1);
		
		// Then
		assertEquals("1", result);
	}

	@Test public void should_return_foo() {
		// Given
		FooBar fooBar = new FooBar();

		// When
		String result = fooBar.translate(3);
		
		// Then
		assertEquals("FOOFOO" ,result);
	}
	
	@Test public void should_return_bar() {
		// Given
		FooBar fooBar = new FooBar();

		// When
		String result = fooBar.translate(5);
		
		// Then
		assertEquals("BARBAR" ,result);
	}
	
	@Test public void should_return_qix() {
		// Given
		FooBar fooBar = new FooBar();

		// When
		String result = fooBar.translate(7);
		
		// Then
		assertEquals("QIXQIX" ,result);
	}

	@Test public void should_return_foobar() {
		// Given
		FooBar fooBar = new FooBar();

		// When
		String result = fooBar.translate(15);
		
		// Then
		assertEquals("FOOBARBAR" ,result);
	}
	
	@Test public void should_return_fooqix() {
		// Given
		FooBar fooBar = new FooBar();

		// When
		String result = fooBar.translate(21);
		
		// Then
		assertEquals("FOOQIX" ,result);
	}
	
	@Test public void should_return_bar_qix_foo_bar() {
		// Given
		FooBar fooBar = new FooBar();

		// When
		String result = fooBar.translate(35);
		
		// Then
		assertEquals("BARQIXFOOBAR" ,result);
	}
}
