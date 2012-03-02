/*
 * Copyright (C) 2012 Scott M. Everts Greysky Software.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy
 * of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package com.greyskysoftware.demo.apps;

import java.util.ArrayList;

import android.app.ListActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class AsyncDemo extends ListActivity {

	private static final String[] items = {
		"lorem", "ipsum", "dolor",
		"sit", "amet", "consectetuer",
		"adipiscing", "elit", "morbi",
		"vel", "ligula", "vitae",
		"arcu", "aliquet", "mollis",
		"etiam", "vel", "erat",
		"placerat", "ante",
		"porttitor", "sodales",
		"pellentesque", "augue",
		"purus"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.asyncdemo);
		setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, 
				new ArrayList<String>()));
		
		new AddStringTask().execute();
	}

	private class AddStringTask extends AsyncTask<Void, String, Void> {

		@Override
		protected Void doInBackground(Void... params) {
			for (String i : items) {
				publishProgress(i);
				SystemClock.sleep(200);
			}
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			Toast
				.makeText(AsyncDemo.this, "done", Toast.LENGTH_SHORT)
				.show();
		}

		@SuppressWarnings("unchecked")
		@Override
		protected void onProgressUpdate(String... item) {
			((ArrayAdapter<String>) getListAdapter()).add(item[0]);
		}
		
	}
	
}
