package com.codepath.upkar.persistencedemo;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

@Table(name = "input_values")
public class InputValue extends Model {
	@Column(name = "text")
	String text;

	public InputValue() {
		super();
	}

	public InputValue(String text) {
		super();
		this.text = text;
	}

	public static InputValue queryMostRecent() {
		InputValue result = null;
		result = new Select().from(InputValue.class).orderBy("id DESC")
				.limit("1").executeSingle();
		return result;
	}
}
