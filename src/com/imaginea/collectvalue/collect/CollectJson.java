package com.imaginea.collectvalue.collect;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.imaginea.collectvalue.util.Util;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.ReadContext;
import com.jayway.jsonpath.spi.json.JsonOrgJsonProvider;
import com.jayway.jsonpath.spi.mapper.JsonOrgMappingProvider;

/**
 * @author gurubaladhinesh
 *
 */
public class CollectJson implements Collect {

	Configuration config = Configuration.builder().jsonProvider(new JsonOrgJsonProvider())
			.mappingProvider(new JsonOrgMappingProvider()).build();

	/**
	 * Reads json string from file and extracts value for list of key paths provided
	 */
	@Override
	public Map<String, Object> collect(File file, List<String> pathList) throws IOException {
		String json = Util.readFile(file);
		ReadContext context = JsonPath.parse(json, config);
		return extractValue(context, pathList);
	}

	/**
	 * Extracts value from json string for list of key paths provided
	 */
	@Override
	public Map<String, Object> collect(String json, List<String> pathList) {
		Configuration config = Configuration.builder().jsonProvider(new JsonOrgJsonProvider()).build(); // JsonPath.parse(json);
		ReadContext context = JsonPath.parse(json, config);
		return extractValue(context, pathList);
	}

	/**
	 * @param context
	 * @param pathList
	 * @return Map with input path as key and extracted json value as value
	 */
	private Map<String, Object> extractValue(ReadContext context, List<String> pathList) {
		Map<String, Object> valueMap = new HashMap<String, Object>();
		for (String path : pathList) {
			if (!valueMap.containsKey(path)) {
				Object value = context.read(path);
				valueMap.put(path, value);
			}
		}
		return valueMap;
	}
}
