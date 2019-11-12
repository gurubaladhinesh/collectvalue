package com.imaginea.collectvalue.test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import com.imaginea.collectvalue.collect.Collect;
import com.imaginea.collectvalue.collect.ResponseFormat;
import com.imaginea.collectvalue.factory.CollectFactory;
import com.imaginea.collectvalue.test.data.CollectJsonTestData;

public class CollectJsonTest implements CollectJsonTestData {

	Collect collectJson = CollectFactory.getInstance(ResponseFormat.JSON);

	@Test
	public void testCollectFileListOfString1() {
		try {
			Map<String, Object> valueMap = collectJson.collect(SAMPLE_JSON_FILE, INPUT_PATH_1);
			Object actualResult = valueMap.entrySet().stream().findFirst().get().getValue();
			assertThat(actualResult, instanceOf(JSONArray.class));
			assertTrue(OUTPUT_EXPECTED_1.equals(actualResult.toString()));
		} catch (IOException e) {
			assertTrue(false);
		}
	}

	@Test
	public void testCollectFileListOfString2() {
		try {
			Map<String, Object> valueMap = collectJson.collect(SAMPLE_JSON_FILE, INPUT_PATH_2);
			Object actualResult = valueMap.entrySet().stream().findFirst().get().getValue();
			assertThat(actualResult, instanceOf(JSONArray.class));
			assertTrue(OUTPUT_EXPECTED_2.equals(actualResult.toString()));
		} catch (IOException e) {
			assertTrue(false);
		}
	}

	@Test
	public void testCollectFileListOfString3() {
		try {
			Map<String, Object> valueMap = collectJson.collect(SAMPLE_JSON_FILE, INPUT_PATH_3);
			Object actualResult = valueMap.entrySet().stream().findFirst().get().getValue();
			assertThat(actualResult, instanceOf(JSONArray.class));
			assertTrue(((JSONArray) actualResult).toList().size() == 2);
			assertThat(((JSONArray) actualResult).get(1), instanceOf(JSONArray.class));
			assertTrue(((JSONArray) ((JSONArray) actualResult).get(1)).toList().size() == 4);

			((JSONArray) ((JSONArray) actualResult).get(1)).forEach((p) -> {
				assertThat(p, instanceOf(JSONObject.class));
				assertTrue(((JSONObject) p).has("category"));
				assertTrue(((JSONObject) p).has("author"));
				assertTrue(((JSONObject) p).has("title"));
				assertTrue(((JSONObject) p).has("price"));
			});
			assertTrue(((JSONObject) ((JSONArray) actualResult).get(0)).length() == 2);
			assertTrue(OUTPUT_EXPECTED_3.equals(actualResult.toString()));

		} catch (IOException e) {
			assertTrue(false);
		}
	}

	@Test
	public void testCollectFileListOfString4() {
		try {
			Map<String, Object> valueMap = collectJson.collect(SAMPLE_JSON_FILE, INPUT_PATH_4);
			Object actualResult = valueMap.entrySet().stream().findFirst().get().getValue();
			assertThat(actualResult, instanceOf(JSONArray.class));
			assertTrue(OUTPUT_EXPECTED_4.equals(actualResult.toString()));
		} catch (IOException e) {
			assertTrue(false);
		}
	}
}
