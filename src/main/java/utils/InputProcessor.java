package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputProcessor {

	private InputProcessor() {
	}

	public static String readLine() {
		//https://velog.io/@yeezze/BufferedReader%EB%A5%BC-%EB%8B%AB%EC%95%84%EB%B3%BC%EA%B9%8C
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			return br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
