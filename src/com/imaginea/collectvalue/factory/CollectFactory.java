package com.imaginea.collectvalue.factory;

import com.imaginea.collectvalue.collect.Collect;
import com.imaginea.collectvalue.collect.ResponseFormat;

public class CollectFactory {

	/**
	 * @param format
	 * @return
	 */
	public static Collect getInstance(ResponseFormat responseFormat) {
		Collect collectObj;
		switch (responseFormat) {
		case JSON:
			collectObj = ResponseFormat.JSON.getCollector();
			break;
		case XML:
			collectObj = ResponseFormat.XML.getCollector();
			break;
		default:
			collectObj = ResponseFormat.JSON.getCollector();
			break;
		}
		return collectObj;
	}
}
