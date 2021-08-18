package com.example.util;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class EnabledItems {

	public static final Map<Boolean, String> ENABLEDITEMS;

	static {
		Map<Boolean, String> enabledItems = new LinkedHashMap<Boolean, String>();
		enabledItems.put(true, "有効");
		enabledItems.put(false, "無効");
		ENABLEDITEMS = Collections.unmodifiableMap(enabledItems);
	}

}
