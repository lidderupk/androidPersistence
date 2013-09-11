package com.codepath.upkar.persistencedemo;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Button btnPersist;
	SharedPreferences pref;
	private EditText etValue;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		etValue = (EditText) findViewById(R.id.etValue);

		// pref = PreferenceManager.getDefaultSharedPreferences(this);

		btnPersist = (Button) findViewById(R.id.btnPersist);
		btnPersist.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				onPersist(v);
			}
		});

		onLoad();
	}

	public void onPersist(View v) {
		// Editor edit = pref.edit();
		// edit.putString("test", etValue.getText().toString());
		// // edit.commit();
		// edit.apply();
		// /*
		// * apply introduced in API9 - does it asynchronisly.
		// */
		// Toast.makeText(getBaseContext(), "Saved", Toast.LENGTH_SHORT).show();

		InputValue value = new InputValue(etValue.getText().toString());
		value.save();
		Toast.makeText(getBaseContext(), "Saved", Toast.LENGTH_SHORT).show();
	}

	/*
	 * retrieve the value from storage and put into editText
	 */
	public void onLoad() {
		// String value = pref.getString("test", "");
		// etValue.setText(value);
		InputValue recent = InputValue.queryMostRecent();
		etValue.setText(recent == null ? "" : recent.text);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
