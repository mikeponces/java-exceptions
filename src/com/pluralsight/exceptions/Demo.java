package com.pluralsight.exceptions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Demo {

	public void tryCatch() {
		int i = 12;
		int j = 2;

		try {
			int result = i / (j - 2);
			System.out.println(result);
		} catch (ArithmeticException e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		} finally {

		}
		// TODO: more code
	}

	public void finallyBlock(String fileName) {
		BufferedReader reader = null;

		try {
			reader = new BufferedReader(new FileReader(fileName));
			String inputLine = null;
			while((inputLine = reader.readLine()) != null) {
				System.out.println(inputLine);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void tryWithResources(String fileName) {
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName));){
			String inputLine = null;
			while((inputLine = reader.readLine()) != null) {
				System.out.println(inputLine);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void throwMethod1(String fileName) {
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName));){
			throwMethod2(reader);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void throwMethod2(BufferedReader reader) throws IOException {
		String inputLine = null;
		while((inputLine = reader.readLine()) != null) {
			System.out.println(inputLine);
		}
	}

	public void throwException() throws IOException {
		throw new IOException("Invalid");
	}

	public void throwCustomException() throws CustomException {
		try {
			throw new CustomException("Specific text");
		} catch(CustomException e) {
			throw e;
		}catch(Exception e) {
			throw new CustomException("Error", e);
		}
	}
}
