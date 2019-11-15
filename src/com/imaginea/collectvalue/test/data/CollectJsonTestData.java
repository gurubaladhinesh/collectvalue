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

	// 5th test case
	List<String> INPUT_PATH_5 = Arrays.asList("$..book[2]");
	String OUTPUT_EXPECTED_5 = "[{\"author\":\"Herman Melville\",\"price\":8.99,\"isbn\":\"0-553-21311-3\",\"category\":\"fiction\",\"title\":\"Moby Dick\"}]";

	// 6th test case
	List<String> INPUT_PATH_6 = Arrays.asList("$..book[-2]");
	String OUTPUT_EXPECTED_6 = "[{\"author\":\"Herman Melville\",\"price\":8.99,\"isbn\":\"0-553-21311-3\",\"category\":\"fiction\",\"title\":\"Moby Dick\"}]";

	// 7th test case
	List<String> INPUT_PATH_7 = Arrays.asList("$..book[0,1]");
	String OUTPUT_EXPECTED_7 = "[{\"author\":\"Nigel Rees\",\"price\":8.95,\"category\":\"reference\",\"title\":\"Sayings of the Century\"},{\"author\":\"Evelyn Waugh\",\"price\":12.99,\"category\":\"fiction\",\"title\":\"Sword of Honour\"}]";

	// 8th test case
	List<String> INPUT_PATH_8 = Arrays.asList("$..book[:2]");
	String OUTPUT_EXPECTED_8 = "[{\"author\":\"Nigel Rees\",\"price\":8.95,\"category\":\"reference\",\"title\":\"Sayings of the Century\"},{\"author\":\"Evelyn Waugh\",\"price\":12.99,\"category\":\"fiction\",\"title\":\"Sword of Honour\"}]";

	// 9th test case
	List<String> INPUT_PATH_9 = Arrays.asList("$..book[1:2]");
	String OUTPUT_EXPECTED_9 = "[{\"author\":\"Evelyn Waugh\",\"price\":12.99,\"category\":\"fiction\",\"title\":\"Sword of Honour\"}]";

	// 10th test case
	List<String> INPUT_PATH_10 = Arrays.asList("$..book[-2:]");
	String OUTPUT_EXPECTED_10 = "[{\"author\":\"Herman Melville\",\"price\":8.99,\"isbn\":\"0-553-21311-3\",\"category\":\"fiction\",\"title\":\"Moby Dick\"},{\"author\":\"J. R. R. Tolkien\",\"price\":22.99,\"isbn\":\"0-395-19395-8\",\"category\":\"fiction\",\"title\":\"The Lord of the Rings\"}]";

	// 11th test case
	List<String> INPUT_PATH_11 = Arrays.asList("$..book[2:]");
	String OUTPUT_EXPECTED_11 = "[{\"author\":\"Herman Melville\",\"price\":8.99,\"isbn\":\"0-553-21311-3\",\"category\":\"fiction\",\"title\":\"Moby Dick\"},{\"author\":\"J. R. R. Tolkien\",\"price\":22.99,\"isbn\":\"0-395-19395-8\",\"category\":\"fiction\",\"title\":\"The Lord of the Rings\"}]";

	// 12th test case
	List<String> INPUT_PATH_12 = Arrays.asList("$..book[?(@.isbn)]");
	String OUTPUT_EXPECTED_12 = "[{\"author\":\"Herman Melville\",\"price\":8.99,\"isbn\":\"0-553-21311-3\",\"category\":\"fiction\",\"title\":\"Moby Dick\"},{\"author\":\"J. R. R. Tolkien\",\"price\":22.99,\"isbn\":\"0-395-19395-8\",\"category\":\"fiction\",\"title\":\"The Lord of the Rings\"}]";

	// 13th test case
	List<String> INPUT_PATH_13 = Arrays.asList("$.store.book[?(@.price < 10)]");
	String OUTPUT_EXPECTED_13 = "[{\"author\":\"Nigel Rees\",\"price\":8.95,\"category\":\"reference\",\"title\":\"Sayings of the Century\"},{\"author\":\"Herman Melville\",\"price\":8.99,\"isbn\":\"0-553-21311-3\",\"category\":\"fiction\",\"title\":\"Moby Dick\"}]";

	// 14th test case
	List<String> INPUT_PATH_14 = Arrays.asList("$..book[?(@.price <= $['expensive'])]");
	String OUTPUT_EXPECTED_14 = "[{\"author\":\"Nigel Rees\",\"price\":8.95,\"category\":\"reference\",\"title\":\"Sayings of the Century\"},{\"author\":\"Herman Melville\",\"price\":8.99,\"isbn\":\"0-553-21311-3\",\"category\":\"fiction\",\"title\":\"Moby Dick\"}]";

	// 15th test case
	List<String> INPUT_PATH_15 = Arrays.asList("$..book[?(@.author =~ /.*REES/i)]");
	String OUTPUT_EXPECTED_15 = "[{\"author\":\"Nigel Rees\",\"price\":8.95,\"category\":\"reference\",\"title\":\"Sayings of the Century\"}]";

	// 16th test case
	List<String> INPUT_PATH_16 = Arrays.asList("$..*");
	String OUTPUT_EXPECTED_16 = "[{\"bicycle\":{\"color\":\"red\",\"price\":19.95},\"book\":[{\"author\":\"Nigel Rees\",\"price\":8.95,\"category\":\"reference\",\"title\":\"Sayings of the Century\"},{\"author\":\"Evelyn Waugh\",\"price\":12.99,\"category\":\"fiction\",\"title\":\"Sword of Honour\"},{\"author\":\"Herman Melville\",\"price\":8.99,\"isbn\":\"0-553-21311-3\",\"category\":\"fiction\",\"title\":\"Moby Dick\"},{\"author\":\"J. R. R. Tolkien\",\"price\":22.99,\"isbn\":\"0-395-19395-8\",\"category\":\"fiction\",\"title\":\"The Lord of the Rings\"}]},10,{\"color\":\"red\",\"price\":19.95},[{\"author\":\"Nigel Rees\",\"price\":8.95,\"category\":\"reference\",\"title\":\"Sayings of the Century\"},{\"author\":\"Evelyn Waugh\",\"price\":12.99,\"category\":\"fiction\",\"title\":\"Sword of Honour\"},{\"author\":\"Herman Melville\",\"price\":8.99,\"isbn\":\"0-553-21311-3\",\"category\":\"fiction\",\"title\":\"Moby Dick\"},{\"author\":\"J. R. R. Tolkien\",\"price\":22.99,\"isbn\":\"0-395-19395-8\",\"category\":\"fiction\",\"title\":\"The Lord of the Rings\"}],\"red\",19.95,{\"author\":\"Nigel Rees\",\"price\":8.95,\"category\":\"reference\",\"title\":\"Sayings of the Century\"},{\"author\":\"Evelyn Waugh\",\"price\":12.99,\"category\":\"fiction\",\"title\":\"Sword of Honour\"},{\"author\":\"Herman Melville\",\"price\":8.99,\"isbn\":\"0-553-21311-3\",\"category\":\"fiction\",\"title\":\"Moby Dick\"},{\"author\":\"J. R. R. Tolkien\",\"price\":22.99,\"isbn\":\"0-395-19395-8\",\"category\":\"fiction\",\"title\":\"The Lord of the Rings\"},\"Nigel Rees\",8.95,\"reference\",\"Sayings of the Century\",\"Evelyn Waugh\",12.99,\"fiction\",\"Sword of Honour\",\"Herman Melville\",8.99,\"0-553-21311-3\",\"fiction\",\"Moby Dick\",\"J. R. R. Tolkien\",22.99,\"0-395-19395-8\",\"fiction\",\"The Lord of the Rings\"]";

	// 17th test case
	List<String> INPUT_PATH_17 = Arrays.asList("$..book.length()");
	String OUTPUT_EXPECTED_17 = "[4]";

}
