package com.imaginea.collectvalue;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.imaginea.collectvalue.collect.Collect;
import com.imaginea.collectvalue.collect.ResponseFormat;
import com.imaginea.collectvalue.factory.CollectFactory;

public class CollectValueMain {

	public static void main(String[] args) throws IOException {

		Collect collectObj = CollectFactory.getInstance(ResponseFormat.JSON);
		List<String> pathList = new ArrayList<String>();

		pathList.add("$.store.book[0].author");
		pathList.add("$.store.book[0]");
		pathList.add("$.store.book[*]");
		pathList.add("$.store.book[0].price");
		pathList.add("$.store.*");
		pathList.add("$.store..price");

		File file = new File(
				"/home/gurubaladhinesh/Documents/workspace-sts-3.9.9.RELEASE/CollectValue/data/sample.json");

		Map<String, Object> valueMap = collectObj.collect(file, pathList);

		System.out.println(valueMap);
	}
}
