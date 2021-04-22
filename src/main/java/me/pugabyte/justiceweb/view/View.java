package me.pugabyte.justiceweb.view;

import java.util.Locale;

public enum View {
	INDEX,
	HISTORY_INDEX;

	public String view() {
		return name().toLowerCase().replaceAll("_", "/");
	}
}
