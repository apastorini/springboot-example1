package com.gofore.grandma.exception;

public class ReceipeNotFoundException extends RuntimeException  {
	

	
	private static final long serialVersionUID = 1L;

		public ReceipeNotFoundException(String name) {
		    super("Could not find receipe " + name);
		  }
		
}
