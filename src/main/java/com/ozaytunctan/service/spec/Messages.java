package com.ozaytunctan.service.spec;

import java.util.List;

public interface Messages {

	public String get(String key);

	public String get(String key, String lang);

	public List<String> get(String... keys);

}
