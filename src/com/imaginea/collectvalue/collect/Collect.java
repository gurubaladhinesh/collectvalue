package com.imaginea.collectvalue.collect;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;



public interface Collect {

	/**
	 * @param json
	 * @param pathList
	 * @return
	 * @throws IOException
	 */
	public Map<String, Object> collect(String json, List<String> pathList) throws IOException;

	/**
	 * @param json
	 * @param pathList
	 * @return
	 * @throws IOException
	 */
	public Map<String, Object> collect(File json, List<String> pathList) throws IOException;

}
