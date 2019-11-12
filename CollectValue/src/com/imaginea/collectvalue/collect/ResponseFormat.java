package com.imaginea.collectvalue.collect;

public enum ResponseFormat {
	JSON(new CollectJson()), XML(new CollectXml());

	private Collect collector;

	ResponseFormat(Collect collector) {
		this.collector = collector;
	}

	public Collect getCollector() {
		return this.collector;
	}
}