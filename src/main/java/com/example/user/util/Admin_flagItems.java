package com.example.user.util;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 有効/無効の選択肢の定数.
 */
public class Admin_flagItems {

	public static final Map<Boolean, String> ADMINFLAGITMES;

	static {
		Map<Boolean, String> Admin_flagItems = new LinkedHashMap<Boolean, String>();
		Admin_flagItems.put(true, "有効");
		Admin_flagItems.put(false, "無効");
		ADMINFLAGITMES = Collections.unmodifiableMap(Admin_flagItems);
	}

}
