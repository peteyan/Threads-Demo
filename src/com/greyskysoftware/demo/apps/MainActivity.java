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

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}

	public void onThreadDemoClick(View v) {
		Intent intent = new Intent(this, ThreadDemo.class);
		startActivity(intent);
	}

	public void onAsynch(View v) {
		Intent intent = new Intent(this, AsyncDemo.class);
		startActivity(intent);
	}
	
	public void onRotationAsynch (View v) {
		Intent intent = new Intent(this, RotationAsyncDemo.class);
		startActivity(intent);
	}
}