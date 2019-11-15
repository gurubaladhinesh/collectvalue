package com.imaginea.collectvalue.test.data;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public interface CollectJsonTestData {

	public static final String SAMPLE_JSON_FILE_NAME = "sample.json";
	public static final File SAMPLE_JSON_FILE = new File(
			CollectJsonTestData.class.getResource(SAMPLE_JSON_FILE_NAME).getPath());
	public static final String RESPONSE_FORMAT_JSON = "json";

	// 1st test case input and expected output
	List<String> INPUT_PATH_1 = Arrays.asList("$.store.book[*].author");
	String OUTPUT_EXPECTED_1 = "[\"Nigel Rees\",\"Evelyn Waugh\",\"Herman Melville\",\"J. R. R. Tolkien\"]"; 

	// 2nd test case input and expected output
	List<String> INPUT_PATH_2 = Arrays.asList("$..author");
	String OUTPUT_EXPECTED_2 = "[\"Nigel Rees\",\"Evelyn Waugh\",\"Herman Melville\",\"J. R. R. Tolkien\"]";

	// 3rd test case input and expected output
	List<String> INPUT_PATH_3 = Arrays.asList("$.store.*");
	String OUTPUT_EXPECTED_3 = "[{\"color\":\"red\",\"price\":19.95},[{\"author\":\"Nigel Rees\",\"price\":8.95,\"category\":\"reference\",\"title\":\"Sayings of the Century\"},{\"author\":\"Evelyn Waugh\",\"price\":12.99,\"category\":\"fiction\",\"title\":\"Sword of Honour\"},{\"author\":\"Herman Melville\",\"price\":8.99,\"isbn\":\"0-553-21311-3\",\"category\":\"fiction\",\"title\":\"Moby Dick\"},{\"author\":\"J. R. R. Tolkien\",\"price\":22.99,\"isbn\":\"0-395-19395-8\",\"category\":\"fiction\",\"title\":\"The Lord of the Rings\"}]]";

	// 4th test case input and expected output
	List<String> INPUT_PATH_4 = Arrays.asList("$.store..price");
	String OUTPUT_EXPECTED_4 = "[19.95,8.95,12.99,8.99,22.99]";

}
