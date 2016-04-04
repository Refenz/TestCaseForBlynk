package com.example.android.apis.test;

import android.test.ActivityInstrumentationTestCase2;
import android.app.Activity;
import junit.framework.AssertionFailedError;
import com.bitbar.recorder.extensions.ExtSolo;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Pattern;

public class Test extends ActivityInstrumentationTestCase2<Activity> {

	private static final String LAUNCHER_ACTIVITY_CLASSNAME = "com.blynk.android.activity.ProxyActivity";
	private static Class<?> launchActivityClass;
	static {
		try {
			launchActivityClass = Class.forName(LAUNCHER_ACTIVITY_CLASSNAME);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	private ExtSolo solo; // ExtSolo is an extension of Robotium Solo that helps collecting better test execution data during test runs

	@SuppressWarnings("unchecked")
	public Test() {
		super((Class<Activity>) launchActivityClass);
	}

	@Override
	public void setUp() throws Exception {
		super.setUp();
		solo = new ExtSolo(getInstrumentation(), getActivity(), this.getClass().getCanonicalName(), getName());
	}

	@Override
	public void tearDown() throws Exception {
		solo.finishOpenedActivities();
		solo.tearDown();
		super.tearDown();
	}

	private void assertsGroup_1Login() throws Exception {
		assertTrue(solo.searchText(Pattern.quote("Create New Account")));
		assertTrue(solo.searchText(Pattern.quote("Log In")));
		assertTrue(solo.searchText(Pattern.quote("Why do I need an account?")));
	}

	public void test0001Login() throws Exception {
	
			solo.waitForActivity("ProxyActivity");
			solo.waitForActivity("StartActivity");
			assertsGroup_1Login();
			assertTrue("Wait for button (id: cc.blynk.R.id.login_button) failed.",
					solo.waitForButtonById("cc.blynk.R.id.login_button", 20000));
			solo.clickOnButton((Button) solo.findViewById("cc.blynk.R.id.login_button"));
			solo.waitForActivity("LoginActivity");
			assertTrue("Wait for edit text (id: cc.blynk.R.id.edit_login) failed.",
					solo.waitForEditTextById("cc.blynk.R.id.edit_login", 20000));
			solo.enterText((EditText) solo.findViewById("cc.blynk.R.id.edit_login"), "roma_kirichenko_@mail.ru");
			assertTrue("Wait for edit text (id: cc.blynk.R.id.edit_psw) failed.",
					solo.waitForEditTextById("cc.blynk.R.id.edit_psw", 20000));
			solo.enterText((EditText) solo.findViewById("cc.blynk.R.id.edit_psw"), "me901989");
			assertTrue("Wait for button (id: cc.blynk.R.id.login_button) failed.",
					solo.waitForButtonById("cc.blynk.R.id.login_button", 20000));
			solo.clickOnButton((Button) solo.findViewById("cc.blynk.R.id.login_button"));
			solo.waitForActivity("DashboardListActivity");
	
	}

	public void test0002GUIAcknowledgements() throws Exception {
	
			assertTrue("Wait for text (id: cc.blynk.R.id.action_acknowledgements) failed.",
					solo.waitForTextById("cc.blynk.R.id.action_acknowledgements", 20000));
			solo.clickOnText((TextView) solo.findViewById("cc.blynk.R.id.action_acknowledgements"));
			solo.waitForActivity("AcknowledgementsActivity");
			assertTrue(solo.searchText(Pattern.quote("Acknowledgements")));
			assertTrue(solo.searchText(Pattern.quote("Android Support")));
			assertTrue(solo.searchText(Pattern.quote(
					"Apache License, Version 2.0\n\nLicensed under the Apache License, Version 2.0 (the License); you may not use this file except in compliance with the License. You may obtain a copy of the License at\n\n http://www.apache.org/licenses/LICENSE-2.0\n\n Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an AS IS BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.")));
			assertTrue(solo.searchText(Pattern.quote(
					"Apache License, Version 2.0\nCopyright (c) 2011 The Android Open Source Project\n\nLicensed under the Apache License, Version 2.0 (the License); you may not use this file except in compliance with the License. You may obtain a copy of the License at\n\n http://www.apache.org/licenses/LICENSE-2.0\n\n Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an AS IS BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.")));
			assertTrue(solo.searchText(Pattern.quote(
					"Apache License, Version 2.0\nCopyright (c) 2013 Christopher Jenkins\n\nLicensed under the Apache License, Version 2.0 (the License); you may not use this file except in compliance with the License. You may obtain a copy of the License at\n\n http://www.apache.org/licenses/LICENSE-2.0\n\n Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an AS IS BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.")));
			assertTrue(solo.searchText(Pattern.quote(
					"Apache License, Version 2.0\nCopyright (c) 2015 Julio Viera\n\nLicensed under the Apache License, Version 2.0 (the License); you may not use this file except in compliance with the License. You may obtain a copy of the License at\n\n http://www.apache.org/licenses/LICENSE-2.0\n\n Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an AS IS BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.")));
			assertTrue(solo.searchText(Pattern.quote("Butter Knife")));
			assertTrue(solo.searchText(Pattern.quote("Calligraphy")));
			assertTrue(solo.searchText(Pattern.quote("EventBus")));
			assertTrue(solo.searchText(Pattern.quote("Gson Fire")));
			assertTrue(solo.searchText(Pattern.quote("JobQueue")));
			assertTrue(solo.searchText(Pattern.quote("LogBack")));
			assertTrue(solo.searchText(Pattern.quote(
					"The MIT License (MIT)\nCopyright (c) 2013 Path, Inc.\n\nPermission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the Software), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:\n\n The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.\n\n THE SOFTWARE IS PROVIDED AS IS, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.")));

	}

	public void test0003GUINewProject() throws Exception {

			assertTrue("Wait for text (id: cc.blynk.R.id.action_add) failed.",
					solo.waitForTextById("cc.blynk.R.id.action_add", 20000));
			solo.clickOnText((TextView) solo.findViewById("cc.blynk.R.id.action_add"));
			solo.waitForActivity("DashboardCreateActivity");
			assertTrue(solo.searchText(Pattern.quote("AUTH TOKEN")));
			assertTrue(solo.searchText(Pattern.quote("Arduino UNO")));
			assertTrue(solo.searchText(Pattern.quote("Create")));
			assertTrue(solo.searchText(Pattern.quote("Create New Project")));
			assertTrue(solo.searchText(Pattern.quote("E-mail")));
			assertTrue(solo.searchText(Pattern.quote("HARDWARE MODEL")));
			assertTrue(solo.searchText(Pattern.quote("Refresh")));
			assertTrue("Wait for image button (index: 0) failed.", solo.waitForImageButton(0, 20000));
			solo.clickOnImageButton(0);
			solo.waitForActivity("DashboardListActivity");

	}

	public void test0004GUINewProjectCreate() throws Exception {
	
			assertTrue("Wait for text (id: cc.blynk.R.id.action_add) failed.",
					solo.waitForTextById("cc.blynk.R.id.action_add", 20000));
			solo.clickOnText((TextView) solo.findViewById("cc.blynk.R.id.action_add"));
			solo.waitForActivity("DashboardCreateActivity");
			assertTrue("Wait for edit text (id: cc.blynk.R.id.edit_name) failed.",
					solo.waitForEditTextById("cc.blynk.R.id.edit_name", 20000));
			solo.enterText((EditText) solo.findViewById("cc.blynk.R.id.edit_name"), "TestProgect1");
			assertTrue("Wait for button (id: cc.blynk.R.id.btn_create) failed.",
					solo.waitForButtonById("cc.blynk.R.id.btn_create", 20000));
			solo.clickOnButton((Button) solo.findViewById("cc.blynk.R.id.btn_create"));
			solo.waitForActivity("DashboardListActivity");
			solo.waitForActivity("DashboardActivity");
			assertTrue(solo.searchText(Pattern.quote("TestProgect1")));
	
	}

	public void test0005GUINewProject1Setings() throws Exception {

			assertTrue("Wait for view (id: cc.blynk.R.id.click_view) failed.",
					solo.waitForViewById("cc.blynk.R.id.click_view", 20000));
			solo.clickOnView(solo.findViewById("cc.blynk.R.id.click_view"));
			solo.waitForActivity("DashboardActivity");
			assertTrue("Wait for text (id: cc.blynk.R.id.action_settings) failed.",
					solo.waitForTextById("cc.blynk.R.id.action_settings", 20000));
			solo.clickOnText((TextView) solo.findViewById("cc.blynk.R.id.action_settings"));
			solo.waitForActivity("DashboardEditActivity");
			assertTrue(solo.searchText(Pattern.quote("AUTH TOKEN")));
			assertTrue(solo.searchText(Pattern.quote("Arduino UNO")));
			assertTrue(solo.searchText(Pattern.quote("Delete")));
			assertTrue(solo.searchText(Pattern.quote("E-mail")));
			assertTrue(solo.searchText(Pattern.quote("Free 30 days trial")));
			assertTrue(solo.searchText(Pattern.quote("Generate Link")));
			assertTrue(solo.searchText(Pattern.quote("HARDWARE MODEL")));
			assertTrue(solo.searchText(Pattern.quote("How it Works")));
			assertTrue(solo.searchText(Pattern.quote("KEEP SCREEN ALWAYS ON")));
			assertTrue(solo.searchText(Pattern.quote("OFF")));
			assertTrue(solo.searchText(Pattern.quote("ON")));
			assertTrue(solo.searchText(Pattern.quote("Project Settings")));
			assertTrue(solo.searchText(Pattern.quote("Refresh")));
			assertTrue(solo.searchText(Pattern.quote("SHARED ACCESS - ")));
			assertTrue(solo.searchText(Pattern.quote("Share Project")));
			assertTrue(solo.searchText(Pattern.quote("TestProgect1")));
	
	}

	public void test0006GUINewProject1WidgetBox() throws Exception {
	
			assertTrue("Wait for view (id: cc.blynk.R.id.click_view) failed.",
					solo.waitForViewById("cc.blynk.R.id.click_view", 20000));
			solo.clickOnView(solo.findViewById("cc.blynk.R.id.click_view"));
			solo.waitForActivity("DashboardActivity");
			assertTrue("Wait for text (id: cc.blynk.R.id.action_add) failed.",
					solo.waitForTextById("cc.blynk.R.id.action_add", 20000));
			solo.clickOnText((TextView) solo.findViewById("cc.blynk.R.id.action_add"));
			assertTrue(solo.searchText(Pattern.quote("Bridge")));
			assertTrue(solo.searchText(Pattern.quote("Button")));
			assertTrue(solo.searchText(Pattern.quote("CONTROLLERS")));
			assertTrue(solo.searchText(Pattern.quote("DISPLAYS")));
			assertTrue(solo.searchText(Pattern.quote("Email")));
			assertTrue(solo.searchText(Pattern.quote("Gauge")));
			assertTrue(solo.searchText(Pattern.quote("Graph")));
			assertTrue(solo.searchText(Pattern.quote("History Graph")));
			assertTrue(solo.searchText(Pattern.quote("LCD")));
			assertTrue(solo.searchText(Pattern.quote("LED")));
			assertTrue(solo.searchText(Pattern.quote("Large Slider")));
			assertTrue(solo.searchText(Pattern.quote("NOTIFICATIONS")));
			assertTrue(solo.searchText(Pattern.quote("OTHER")));
			assertTrue(solo.searchText(Pattern.quote("Push")));
			assertTrue(solo.searchText(Pattern.quote("Slider")));
			assertTrue(solo.searchText(Pattern.quote("Terminal")));
			assertTrue(solo.searchText(Pattern.quote("TestProgect1")));
			assertTrue(solo.searchText(Pattern.quote("Timer")));
			assertTrue(solo.searchText(Pattern.quote("Twitter")));
			assertTrue(solo.searchText(Pattern.quote("Two Axis Joystick")));
			assertTrue(solo.searchText(Pattern.quote("Value Display")));
			assertTrue(solo.searchText(Pattern.quote("WIDGET BOX")));
			assertTrue(solo.searchText(Pattern.quote("zeRGBa")));

	}

	public void test0007GUINewProject1SetingsAssertChangeModel() throws Exception {
	
			assertTrue("Wait for view (id: cc.blynk.R.id.click_view) failed.",
					solo.waitForViewById("cc.blynk.R.id.click_view", 20000));
			solo.clickOnView(solo.findViewById("cc.blynk.R.id.click_view"));
			solo.waitForActivity("DashboardActivity");
			assertTrue("Wait for text (id: cc.blynk.R.id.action_settings) failed.",
					solo.waitForTextById("cc.blynk.R.id.action_settings", 20000));
			solo.clickOnText((TextView) solo.findViewById("cc.blynk.R.id.action_settings"));
			solo.waitForActivity("DashboardEditActivity");
			assertTrue("Wait for button (id: cc.blynk.R.id.btn_model) failed.",
					solo.waitForButtonById("cc.blynk.R.id.btn_model", 20000));
			solo.clickOnButton((Button) solo.findViewById("cc.blynk.R.id.btn_model"));
			solo.clickOnScreen(solo.toScreenX(0.274f), solo.toScreenY(1.362f));
			assertTrue("Wait for text (id: cc.blynk.R.id.buttonDefaultPositive) failed.",
					solo.waitForTextById("cc.blynk.R.id.buttonDefaultPositive", 20000));
			solo.clickOnText((TextView) solo.findViewById("cc.blynk.R.id.buttonDefaultPositive"));
			assertTrue(solo.searchText(Pattern.quote("Cancel")));
			assertTrue(solo.searchText(Pattern.quote("This will reset all widget settings in your project")));
			assertTrue(solo.searchText(Pattern.quote("\u041E\u041A")));
			assertTrue("Wait for text (id: cc.blynk.R.id.buttonDefaultNegative) failed.",
					solo.waitForTextById("cc.blynk.R.id.buttonDefaultNegative", 20000));
			solo.clickOnText((TextView) solo.findViewById("cc.blynk.R.id.buttonDefaultNegative"));
	
	}



	public void test0009GUINewProject1WidgetBoxAddButton() throws Exception {
		
			assertTrue("Wait for view (id: cc.blynk.R.id.click_view) failed.",
					solo.waitForViewById("cc.blynk.R.id.click_view", 20000));
			solo.clickOnView(solo.findViewById("cc.blynk.R.id.click_view"));
			solo.waitForActivity("DashboardActivity");
			assertTrue("Wait for text (id: cc.blynk.R.id.action_add) failed.",
					solo.waitForTextById("cc.blynk.R.id.action_add", 20000));
			solo.clickOnText((TextView) solo.findViewById("cc.blynk.R.id.action_add"));
			assertTrue("Wait for text (id: cc.blynk.R.id.action_add) failed.",
					solo.waitForTextById("cc.blynk.R.id.action_add", 20000));
			solo.clickOnText((TextView) solo.findViewById("cc.blynk.R.id.action_add"));
			assertTrue("Wait for view (index: 26) failed.", solo.waitForView(26, 20000));
			solo.clickOnView(26);
			assertTrue(solo.searchText(Pattern.quote("BUTTON")));
	
	}

	public void test0010GUINewProject1WidgetBoxAddPropertyButton() throws Exception {

			assertTrue("Wait for view (id: cc.blynk.R.id.click_view) failed.",
					solo.waitForViewById("cc.blynk.R.id.click_view", 20000));
			solo.clickOnView(solo.findViewById("cc.blynk.R.id.click_view"));
			solo.waitForActivity("DashboardActivity");
			solo.clickOnScreen(solo.toScreenX(0.108f), solo.toScreenY(0.353f));
			solo.waitForActivity("ButtonEditActivity");
			assertTrue(solo.searchText(Pattern.quote("Button Settings")));
			assertTrue(solo.searchText(Pattern.quote("Delete")));
			assertTrue(solo.searchText(Pattern.quote("MODE")));
			assertTrue(solo.searchText(Pattern.quote("OUTPUT")));
			assertTrue(solo.searchText(Pattern.quote("PIN")));
			assertTrue(solo.searchText(Pattern.quote("PUSH")));
			assertTrue(solo.searchText(Pattern.quote("SWITCH")));
	}
			
	public void test0011GUINewProject1WidgetBoxDeleteButton() throws Exception {
	
			assertTrue("Wait for view (id: cc.blynk.R.id.click_view) failed.",
					solo.waitForViewById("cc.blynk.R.id.click_view", 20000));
			solo.clickOnView(solo.findViewById("cc.blynk.R.id.click_view"));
			solo.waitForActivity("DashboardActivity");
			solo.clickOnScreen(solo.toScreenX(0.063f), solo.toScreenY(0.301f));
			solo.waitForActivity("ButtonEditActivity");
			assertTrue("Wait for button (id: cc.blynk.R.id.button_delete) failed.",
					solo.waitForButtonById("cc.blynk.R.id.button_delete", 20000));
			solo.clickOnButton((Button) solo.findViewById("cc.blynk.R.id.button_delete"));
			solo.waitForActivity("DashboardActivity");
			assertTrue(solo.searchText(Pattern.quote("TestProgect1")));
	
	}

	public void test0012GUINewProject1WidgetBoxAddSlider() throws Exception {
		
			assertTrue("Wait for view (id: cc.blynk.R.id.click_view) failed.",
					solo.waitForViewById("cc.blynk.R.id.click_view", 20000));
			solo.clickOnView(solo.findViewById("cc.blynk.R.id.click_view"));
			solo.waitForActivity("DashboardActivity");
			assertTrue("Wait for text (id: cc.blynk.R.id.action_add) failed.",
					solo.waitForTextById("cc.blynk.R.id.action_add", 20000));
			solo.clickOnText((TextView) solo.findViewById("cc.blynk.R.id.action_add"));
			assertTrue("Wait for view (index: 30) failed.", solo.waitForView(30, 20000));
			solo.clickOnView(30);
			assertTrue(solo.searchText(Pattern.quote("0")));
			assertTrue(solo.searchText(Pattern.quote("SLIDER")));
	
	}
	public void test0013GUINewProject1WidgetBoxPropertySlider() throws Exception {
		
			assertTrue("Wait for view (id: cc.blynk.R.id.click_view) failed.",
					solo.waitForViewById("cc.blynk.R.id.click_view", 20000));
			solo.clickOnView(solo.findViewById("cc.blynk.R.id.click_view"));
			solo.waitForActivity("DashboardActivity");
			solo.waitForActivity("SliderEditActivity");
			assertTrue(solo.searchText(Pattern.quote("0")));
			assertTrue(solo.searchText(Pattern.quote("255")));
			assertTrue(solo.searchText(Pattern.quote("Delete")));
			assertTrue(solo.searchText(Pattern.quote("OUTPUT")));
			assertTrue(solo.searchText(Pattern.quote("PIN")));
			assertTrue(solo.searchText(Pattern.quote("Slider Settings")));
		}
	public void test0014GUINewProject1WidgetBoxDeleteSlider() throws Exception {
		
			assertTrue("Wait for view (id: cc.blynk.R.id.click_view) failed.",
					solo.waitForViewById("cc.blynk.R.id.click_view", 20000));
			solo.clickOnView(solo.findViewById("cc.blynk.R.id.click_view"));
			solo.waitForActivity("DashboardActivity");
			solo.clickOnScreen(solo.toScreenX(0.151f), solo.toScreenY(0.169f));
			solo.waitForActivity("SliderEditActivity");
			assertTrue("Wait for button (id: cc.blynk.R.id.button_delete) failed.",
					solo.waitForButtonById("cc.blynk.R.id.button_delete", 20000));
			solo.clickOnButton((Button) solo.findViewById("cc.blynk.R.id.button_delete"));
			solo.waitForActivity("DashboardActivity");
			assertTrue(solo.searchText(Pattern.quote("TestProgect1")));
		
	}

	public void test0015GUINewProject1WidgetBoxAddLargeSlider() throws Exception {
		
			assertTrue("Wait for view (id: cc.blynk.R.id.click_view) failed.",
					solo.waitForViewById("cc.blynk.R.id.click_view", 20000));
			solo.clickOnView(solo.findViewById("cc.blynk.R.id.click_view"));
			solo.waitForActivity("DashboardActivity");
			assertTrue("Wait for text (id: cc.blynk.R.id.action_add) failed.",
					solo.waitForTextById("cc.blynk.R.id.action_add", 20000));
			solo.clickOnText((TextView) solo.findViewById("cc.blynk.R.id.action_add"));
			assertTrue("Wait for view (index: 34) failed.", solo.waitForView(34, 20000));
			solo.clickOnView(34);
			assertTrue(solo.searchText(Pattern.quote("0")));
			assertTrue(solo.searchText(Pattern.quote("SLIDER")));
	
	}
	public void test0016GUINewProject1WidgetBoxPropertyLargeSlider() throws Exception {

			assertTrue("Wait for view (id: cc.blynk.R.id.click_view) failed.",
					solo.waitForViewById("cc.blynk.R.id.click_view", 20000));
			solo.clickOnView(solo.findViewById("cc.blynk.R.id.click_view"));
			solo.waitForActivity("DashboardActivity");
			solo.waitForActivity("SliderEditActivity");
			assertTrue(solo.searchText(Pattern.quote("0")));
			assertTrue(solo.searchText(Pattern.quote("255")));
			assertTrue(solo.searchText(Pattern.quote("Delete")));
			assertTrue(solo.searchText(Pattern.quote("OUTPUT")));
			assertTrue(solo.searchText(Pattern.quote("PIN")));
			assertTrue(solo.searchText(Pattern.quote("Slider Settings")));
		}
	public void test0017GUINewProject1WidgetBoxDeleteLargeSlider() throws Exception {
	
			assertTrue("Wait for view (id: cc.blynk.R.id.click_view) failed.",
					solo.waitForViewById("cc.blynk.R.id.click_view", 20000));
			solo.clickOnView(solo.findViewById("cc.blynk.R.id.click_view"));
			solo.waitForActivity("DashboardActivity");
			solo.clickOnScreen(solo.toScreenX(0.339f), solo.toScreenY(0.263f));
			solo.waitForActivity("SliderEditActivity");
			assertTrue("Wait for button (id: cc.blynk.R.id.button_delete) failed.",
					solo.waitForButtonById("cc.blynk.R.id.button_delete", 20000));
			solo.clickOnButton((Button) solo.findViewById("cc.blynk.R.id.button_delete"));
			solo.waitForActivity("DashboardActivity");
			assertTrue(solo.searchText(Pattern.quote("TestProgect1")));
	
	}

	public void test0018GUINewProject1WidgetBoxAddTimer() throws Exception {
		
			assertTrue("Wait for view (id: cc.blynk.R.id.click_view) failed.",
					solo.waitForViewById("cc.blynk.R.id.click_view", 20000));
			solo.clickOnView(solo.findViewById("cc.blynk.R.id.click_view"));
			solo.waitForActivity("DashboardActivity");
			assertTrue("Wait for text (id: cc.blynk.R.id.action_add) failed.",
					solo.waitForTextById("cc.blynk.R.id.action_add", 20000));
			solo.clickOnText((TextView) solo.findViewById("cc.blynk.R.id.action_add"));
			assertTrue("Wait for view (index: 38) failed.", solo.waitForView(38, 20000));
			solo.clickOnView(38);
			assertTrue(solo.searchText(Pattern.quote("--:--:--")));
			assertTrue(solo.searchText(Pattern.quote("TIMER")));
		
	}
	public void test0019GUINewProject1WidgetBoxPropertyTimer() throws Exception {

			assertTrue("Wait for view (id: cc.blynk.R.id.click_view) failed.",
					solo.waitForViewById("cc.blynk.R.id.click_view", 20000));
			solo.clickOnView(solo.findViewById("cc.blynk.R.id.click_view"));
			solo.waitForActivity("DashboardActivity");
			solo.waitForActivity("TimerEditActivity");
			assertTrue(solo.searchText(Pattern.quote("--:--:--")));
			assertTrue(solo.searchText(Pattern.quote("Delete")));
			assertTrue(solo.searchText(Pattern.quote("OUTPUT")));
			assertTrue(solo.searchText(Pattern.quote("PIN")));
			assertTrue(solo.searchText(Pattern.quote("START")));
			assertTrue(solo.searchText(Pattern.quote("STOP")));
			assertTrue(solo.searchText(Pattern.quote("TIME")));
			assertTrue(solo.searchText(Pattern.quote("Timer Settings")));
		}
			
	public void test0020GUINewProject1WidgetBoxAddDeleteTimer() throws Exception {
		
			assertTrue("Wait for view (id: cc.blynk.R.id.click_view) failed.",
					solo.waitForViewById("cc.blynk.R.id.click_view", 20000));
			solo.clickOnView(solo.findViewById("cc.blynk.R.id.click_view"));
			solo.waitForActivity("DashboardActivity");
			solo.waitForActivity("TimerEditActivity");
			assertTrue("Wait for button (id: cc.blynk.R.id.button_delete) failed.",
					solo.waitForButtonById("cc.blynk.R.id.button_delete", 20000));
			solo.clickOnButton((Button) solo.findViewById("cc.blynk.R.id.button_delete"));
			solo.waitForActivity("DashboardActivity");
			assertTrue(solo.searchText(Pattern.quote("TestProgect1")));
	
	}

	public void test0021GUINewProject1WidgetBoxAddTwoAxisJoystick() throws Exception {
	
			assertTrue("Wait for view (id: cc.blynk.R.id.click_view) failed.",
					solo.waitForViewById("cc.blynk.R.id.click_view", 20000));
			solo.clickOnView(solo.findViewById("cc.blynk.R.id.click_view"));
			solo.waitForActivity("DashboardActivity");
			assertTrue("Wait for text (id: cc.blynk.R.id.action_add) failed.",
					solo.waitForTextById("cc.blynk.R.id.action_add", 20000));
			solo.clickOnText((TextView) solo.findViewById("cc.blynk.R.id.action_add"));
			assertTrue("Wait for view (index: 42) failed.", solo.waitForView(42, 20000));
			solo.clickOnView(42);
			assertTrue(solo.searchText(Pattern.quote("128\n128")));
			assertTrue(solo.searchText(Pattern.quote("JOYSTICK")));
	
	}
	public void test0022GUINewProject1WidgetBoxPropertyTwoAxisJoystick() throws Exception {

			assertTrue("Wait for view (id: cc.blynk.R.id.click_view) failed.",
					solo.waitForViewById("cc.blynk.R.id.click_view", 20000));
			solo.clickOnView(solo.findViewById("cc.blynk.R.id.click_view"));
			solo.waitForActivity("DashboardActivity");
			solo.clickOnScreen(solo.toScreenX(0.246f), solo.toScreenY(0.782f));
			solo.waitForActivity("TwoAxisJoystickEditActivity");
			assertTrue(solo.searchText(Pattern.quote("0")));
			assertTrue(solo.searchText(Pattern.quote("255")));
			assertTrue(solo.searchText(Pattern.quote("AUTORETURN")));
			assertTrue(solo.searchText(Pattern.quote("Delete")));
			assertTrue(solo.searchText(Pattern.quote("MERGE")));
			assertTrue(solo.searchText(Pattern.quote("OFF")));
			assertTrue(solo.searchText(Pattern.quote("ON")));
			assertTrue(solo.searchText(Pattern.quote("OUTPUT")));
			assertTrue(solo.searchText(Pattern.quote("PIN")));
			assertTrue(solo.searchText(Pattern.quote("ROTATE ON TILT")));
			assertTrue(solo.searchText(Pattern.quote("SPLIT")));
			assertTrue(
					solo.searchText(Pattern.quote("To access values use:\nx = param[0].asInt();\ny = param[1].asInt();")));
			assertTrue(solo.searchText(Pattern.quote("Two Axis Joystick Settings")));
		}
	public void test0023GUINewProject1WidgetBoxDeleteTwoAxisJoystick() throws Exception {
		
			assertTrue("Wait for view (id: cc.blynk.R.id.click_view) failed.",
					solo.waitForViewById("cc.blynk.R.id.click_view", 20000));
			solo.clickOnView(solo.findViewById("cc.blynk.R.id.click_view"));
			solo.waitForActivity("DashboardActivity");
			solo.clickOnScreen(solo.toScreenX(0.264f), solo.toScreenY(0.330f));
			solo.waitForActivity("TwoAxisJoystickEditActivity");
			assertTrue("Wait for button (id: cc.blynk.R.id.button_delete) failed.",
					solo.waitForButtonById("cc.blynk.R.id.button_delete", 20000));
			solo.clickOnButton((Button) solo.findViewById("cc.blynk.R.id.button_delete"));
			solo.waitForActivity("DashboardActivity");
			assertTrue(solo.searchText(Pattern.quote("TestProgect1")));
	
	}

	public void test0024GUINewProject1WidgetBoxAddZeRGBa() throws Exception {
	
			assertTrue("Wait for view (id: cc.blynk.R.id.click_view) failed.",
					solo.waitForViewById("cc.blynk.R.id.click_view", 20000));
			solo.clickOnView(solo.findViewById("cc.blynk.R.id.click_view"));
			solo.waitForActivity("DashboardActivity");
			assertTrue("Wait for text (id: cc.blynk.R.id.action_add) failed.",
					solo.waitForTextById("cc.blynk.R.id.action_add", 20000));
			solo.clickOnText((TextView) solo.findViewById("cc.blynk.R.id.action_add"));
			assertTrue("Wait for view (index: 46) failed.", solo.waitForView(46, 20000));
			solo.clickOnView(46);
			assertTrue(solo.searchText(Pattern.quote("142")));
			assertTrue(solo.searchText(Pattern.quote("196")));
			assertTrue(solo.searchText(Pattern.quote("36")));
			assertTrue(solo.searchText(Pattern.quote("ZERGBA")));

	}
	public void test0025GUINewProject1WidgetBoxPropertyTwoAxisJoystick() throws Exception {

			assertTrue("Wait for view (id: cc.blynk.R.id.click_view) failed.",
					solo.waitForViewById("cc.blynk.R.id.click_view", 20000));
			solo.clickOnView(solo.findViewById("cc.blynk.R.id.click_view"));
			solo.waitForActivity("DashboardActivity");
			solo.waitForActivity("RGBEditActivity");
			assertTrue(solo.searchText(Pattern.quote("0")));
			assertTrue(solo.searchText(Pattern.quote("255")));
			assertTrue(solo.searchText(Pattern.quote("Delete")));
			assertTrue(solo.searchText(Pattern.quote("MERGE")));
			assertTrue(solo.searchText(Pattern.quote("OUTPUT")));
			assertTrue(solo.searchText(Pattern.quote("PIN")));
			assertTrue(solo.searchText(Pattern.quote("SPLIT")));
			assertTrue(
					solo.searchText(Pattern.quote("r = param[0].asInt();\ng = param[1].asInt();\nb = param[2].asInt();")));
			assertTrue(solo.searchText(Pattern.quote("zeRGBa Settings")));
		}
	public void test0026GUINewProject1WidgetBoxDeleteZeRGBa() throws Exception {
	
			assertTrue("Wait for view (id: cc.blynk.R.id.click_view) failed.",
					solo.waitForViewById("cc.blynk.R.id.click_view", 20000));
			solo.clickOnView(solo.findViewById("cc.blynk.R.id.click_view"));
			solo.waitForActivity("DashboardActivity");
			solo.clickOnScreen(solo.toScreenX(0.230f), solo.toScreenY(0.490f));
			solo.waitForActivity("RGBEditActivity");
			assertTrue("Wait for button (id: cc.blynk.R.id.button_delete) failed.",
					solo.waitForButtonById("cc.blynk.R.id.button_delete", 20000));
			solo.clickOnButton((Button) solo.findViewById("cc.blynk.R.id.button_delete"));
			solo.waitForActivity("DashboardActivity");
			assertTrue(solo.searchText(Pattern.quote("TestProgect1")));
	
	}

	public void test0027GUINewProject1WidgetBoxAddValueDisplay() throws Exception {
		
			assertTrue("Wait for view (id: cc.blynk.R.id.click_view) failed.",
					solo.waitForViewById("cc.blynk.R.id.click_view", 20000));
			solo.clickOnView(solo.findViewById("cc.blynk.R.id.click_view"));
			assertTrue("Wait for view (id: cc.blynk.R.id.click_view) failed.",
					solo.waitForViewById("cc.blynk.R.id.click_view", 20000));
			solo.clickOnView(solo.findViewById("cc.blynk.R.id.click_view"));
			solo.waitForActivity("DashboardActivity");
			assertTrue("Wait for text (id: cc.blynk.R.id.action_add) failed.",
					solo.waitForTextById("cc.blynk.R.id.action_add", 20000));
			solo.clickOnText((TextView) solo.findViewById("cc.blynk.R.id.action_add"));
			assertTrue("Wait for view (index: 53) failed.", solo.waitForView(53, 20000));
			solo.clickOnView(53);
			assertTrue(solo.searchText(Pattern.quote("----")));
			assertTrue(solo.searchText(Pattern.quote("VALUE")));
	
	}
	public void testVatest0028GUINewProject1WidgetBoxPropertyValueDisplaylueDisplay() throws Exception {

			assertTrue("Wait for view (id: cc.blynk.R.id.click_view) failed.",
					solo.waitForViewById("cc.blynk.R.id.click_view", 20000));
			solo.clickOnView(solo.findViewById("cc.blynk.R.id.click_view"));
			solo.waitForActivity("DashboardActivity");
			solo.waitForActivity("ValueDisplayEditActivity");
			assertTrue(solo.searchText(Pattern.quote("0")));
			assertTrue(solo.searchText(Pattern.quote("1 sec")));
			assertTrue(solo.searchText(Pattern.quote("1023")));
			assertTrue(solo.searchText(Pattern.quote("Delete")));
			assertTrue(solo.searchText(Pattern.quote("INPUT")));
			assertTrue(solo.searchText(Pattern.quote("PIN")));
			assertTrue(solo.searchText(Pattern.quote("READING FREQUENCY")));
			assertTrue(solo.searchText(Pattern.quote("Value Display Settings")));
		}
	public void test0029GUINewProject1WidgetBoxDeleteValueDisplay() throws Exception {
	
			assertTrue("Wait for view (id: cc.blynk.R.id.click_view) failed.",
					solo.waitForViewById("cc.blynk.R.id.click_view", 20000));
			solo.clickOnView(solo.findViewById("cc.blynk.R.id.click_view"));
			solo.waitForActivity("DashboardActivity");
			solo.waitForActivity("ValueDisplayEditActivity");
			assertTrue("Wait for button (id: cc.blynk.R.id.button_delete) failed.",
					solo.waitForButtonById("cc.blynk.R.id.button_delete", 20000));
			solo.clickOnButton((Button) solo.findViewById("cc.blynk.R.id.button_delete"));
			solo.waitForActivity("DashboardActivity");
			assertTrue(solo.searchText(Pattern.quote("TestProgect1")));
	
	}

	public void test0030GUINewProject1WidgetBoxAddLED() throws Exception {
		
			assertTrue("Wait for view (id: cc.blynk.R.id.click_view) failed.",
					solo.waitForViewById("cc.blynk.R.id.click_view", 20000));
			solo.clickOnView(solo.findViewById("cc.blynk.R.id.click_view"));
			solo.waitForActivity("DashboardActivity");
			assertTrue("Wait for text (id: cc.blynk.R.id.action_add) failed.",
					solo.waitForTextById("cc.blynk.R.id.action_add", 20000));
			solo.clickOnText((TextView) solo.findViewById("cc.blynk.R.id.action_add"));
			assertTrue("Wait for view (index: 57) failed.", solo.waitForView(57, 20000));
			solo.clickOnView(57);
			assertTrue(solo.searchText(Pattern.quote("LED")));
	
	}
	public void test0031GUINewProject1WidgetBoxPropertyLED() throws Exception {

			assertTrue("Wait for view (id: cc.blynk.R.id.click_view) failed.",
					solo.waitForViewById("cc.blynk.R.id.click_view", 20000));
			solo.clickOnView(solo.findViewById("cc.blynk.R.id.click_view"));
			solo.waitForActivity("DashboardActivity");
			solo.clickOnScreen(solo.toScreenX(0.048f), solo.toScreenY(0.259f));
			solo.clickOnScreen(solo.toScreenX(0.048f), solo.toScreenY(0.259f));
			solo.waitForActivity("LedEditActivity");
			solo.waitForActivity("LedEditActivity");
			assertTrue(solo.searchText(Pattern.quote("Delete")));
			assertTrue(solo.searchText(Pattern.quote("INPUT")));
			assertTrue(solo.searchText(Pattern.quote("Led Settings")));
			assertTrue(solo.searchText(Pattern.quote("PIN")));
		}
	public void test0032GUINewProject1WidgetBoxDeleteLED() throws Exception {
	
			assertTrue("Wait for view (id: cc.blynk.R.id.click_view) failed.",
					solo.waitForViewById("cc.blynk.R.id.click_view", 20000));
			solo.clickOnView(solo.findViewById("cc.blynk.R.id.click_view"));
			solo.waitForActivity("DashboardActivity");
			solo.waitForActivity("LedEditActivity");
			assertTrue("Wait for button (id: cc.blynk.R.id.button_delete) failed.",
					solo.waitForButtonById("cc.blynk.R.id.button_delete", 20000));
			solo.clickOnButton((Button) solo.findViewById("cc.blynk.R.id.button_delete"));
			solo.waitForActivity("DashboardActivity");
			assertTrue(solo.searchText(Pattern.quote("TestProgect1")));
		
	}

	public void test0033GUINewProject1WidgetBoxAddCauge() throws Exception {
	
			assertTrue("Wait for view (id: cc.blynk.R.id.click_view) failed.",
					solo.waitForViewById("cc.blynk.R.id.click_view", 20000));
			solo.clickOnView(solo.findViewById("cc.blynk.R.id.click_view"));
			solo.waitForActivity("DashboardActivity");
			assertTrue("Wait for text (id: cc.blynk.R.id.action_add) failed.",
					solo.waitForTextById("cc.blynk.R.id.action_add", 20000));
			solo.clickOnText((TextView) solo.findViewById("cc.blynk.R.id.action_add"));
			assertTrue("Wait for view (index: 61) failed.", solo.waitForView(61, 20000));
			solo.clickOnView(61);
			assertTrue(solo.searchText(Pattern.quote("VALUE")));
		
	}
	public void test0034GUINewProject1WidgetBoxPropertyCauge() throws Exception {

			assertTrue("Wait for view (id: cc.blynk.R.id.click_view) failed.",
					solo.waitForViewById("cc.blynk.R.id.click_view", 20000));
			solo.clickOnView(solo.findViewById("cc.blynk.R.id.click_view"));
			solo.waitForActivity("DashboardActivity");
			solo.waitForActivity("GaugeEditActivity");
			assertTrue(solo.searchText(Pattern.quote("0")));
			assertTrue(solo.searchText(Pattern.quote("1 sec")));
			assertTrue(solo.searchText(Pattern.quote("1023")));
			assertTrue(solo.searchText(Pattern.quote("Delete")));
			assertTrue(solo.searchText(Pattern.quote("Gauge Settings")));
			assertTrue(solo.searchText(Pattern.quote("INPUT")));
			assertTrue(solo.searchText(Pattern.quote("PIN")));
			assertTrue(solo.searchText(Pattern.quote("READING FREQUENCY")));
		}
	public void test0035GUINewProject1WidgetBoxDeleteCauge() throws Exception {

			assertTrue("Wait for view (id: cc.blynk.R.id.click_view) failed.",
					solo.waitForViewById("cc.blynk.R.id.click_view", 20000));
			solo.clickOnView(solo.findViewById("cc.blynk.R.id.click_view"));
			solo.waitForActivity("DashboardActivity");
			solo.waitForActivity("GaugeEditActivity");
			assertTrue("Wait for button (id: cc.blynk.R.id.button_delete) failed.",
					solo.waitForButtonById("cc.blynk.R.id.button_delete", 20000));
			solo.clickOnButton((Button) solo.findViewById("cc.blynk.R.id.button_delete"));
			solo.waitForActivity("DashboardActivity");
			assertTrue(solo.searchText(Pattern.quote("TestProgect1")));

	}

	public void test0036GUINewProject1WidgetBoxAddLCD_______WRONG() throws Exception {

			assertTrue("Wait for view (id: cc.blynk.R.id.click_view) failed.",
					solo.waitForViewById("cc.blynk.R.id.click_view", 20000));
			solo.clickOnView(solo.findViewById("cc.blynk.R.id.click_view"));
			solo.waitForActivity("DashboardActivity");
			assertTrue("Wait for text (id: cc.blynk.R.id.action_add) failed.",
					solo.waitForTextById("cc.blynk.R.id.action_add", 20000));
			solo.clickOnText((TextView) solo.findViewById("cc.blynk.R.id.action_add"));
			assertTrue("Wait for view (index: 65) failed.", solo.waitForView(65, 20000));
			solo.clickOnView(65);
			assertTrue(solo.searchText(Pattern.quote("TestProgect1")));

	}
	public void test0037GUINewProject1WidgetBoxPropertyLCD_______WRONG() throws Exception {

			assertTrue("Wait for view (id: cc.blynk.R.id.click_view) failed.",
					solo.waitForViewById("cc.blynk.R.id.click_view", 20000));
			solo.clickOnView(solo.findViewById("cc.blynk.R.id.click_view"));
			solo.waitForActivity("DashboardActivity");
			solo.clickOnScreen(solo.toScreenX(0.369f), solo.toScreenY(0.357f));
			solo.waitForActivity("LCDEditActivity");
			assertTrue(solo.searchText(Pattern.quote("0")));
			assertTrue(solo.searchText(Pattern.quote("1 sec")));
			assertTrue(solo.searchText(Pattern.quote("1023")));
			assertTrue(solo.searchText(Pattern.quote("ADVANCED")));
			assertTrue(solo.searchText(Pattern.quote("COLORS")));
			assertTrue(solo.searchText(Pattern.quote("Delete")));
			assertTrue(solo.searchText(Pattern.quote("Example:\nlcd.print(0, 0, \"Hello LCD!\");")));
			assertTrue(solo.searchText(Pattern.quote("INPUT")));
			assertTrue(solo.searchText(Pattern.quote("LCD Settings")));
			assertTrue(solo.searchText(Pattern.quote("MESSAGE")));
			assertTrue(solo.searchText(Pattern.quote("PIN")));
			assertTrue(solo.searchText(Pattern.quote("READING FREQUENCY")));
			assertTrue(solo.searchText(Pattern.quote("SIMPLE")));
			assertTrue(solo.searchText(Pattern.quote("Screen")));
			assertTrue(solo.searchText(Pattern.quote("T")));
			assertTrue(solo.searchText(Pattern.quote("Text")));
		}
	public void test0038GUINewProject1WidgetBoxDeleteLCD() throws Exception {

			assertTrue("Wait for view (id: cc.blynk.R.id.click_view) failed.",
					solo.waitForViewById("cc.blynk.R.id.click_view", 20000));
			solo.clickOnView(solo.findViewById("cc.blynk.R.id.click_view"));
			solo.waitForActivity("DashboardActivity");
			solo.clickOnScreen(solo.toScreenX(0.304f), solo.toScreenY(0.346f));
			solo.waitForActivity("LCDEditActivity");
			assertTrue("Wait for button (id: cc.blynk.R.id.button_delete) failed.",
					solo.waitForButtonById("cc.blynk.R.id.button_delete", 20000));
			solo.clickOnButton((Button) solo.findViewById("cc.blynk.R.id.button_delete"));
			solo.waitForActivity("DashboardActivity");
			assertTrue(solo.searchText(Pattern.quote("TestProgect1")));

	}

	public void test0039GUINewProject1WidgetBoxAddGraph() throws Exception {

			assertTrue("Wait for view (id: cc.blynk.R.id.click_view) failed.",
					solo.waitForViewById("cc.blynk.R.id.click_view", 20000));
			solo.clickOnView(solo.findViewById("cc.blynk.R.id.click_view"));
			solo.waitForActivity("DashboardActivity");
			assertTrue("Wait for text (id: cc.blynk.R.id.action_add) failed.",
					solo.waitForTextById("cc.blynk.R.id.action_add", 20000));
			solo.clickOnText((TextView) solo.findViewById("cc.blynk.R.id.action_add"));
			assertTrue("Wait for view (index: 69) failed.", solo.waitForView(69, 20000));
			solo.clickOnView(69);
			assertTrue(solo.searchText(Pattern.quote("VALUE")));

	}
	public void test0040GUINewProject1WidgetBoxPropertyGraph() throws Exception {

			assertTrue("Wait for view (id: cc.blynk.R.id.click_view) failed.",
					solo.waitForViewById("cc.blynk.R.id.click_view", 20000));
			solo.clickOnView(solo.findViewById("cc.blynk.R.id.click_view"));
			solo.waitForActivity("DashboardActivity");
			solo.clickOnScreen(solo.toScreenX(0.262f), solo.toScreenY(0.409f));
			solo.clickOnScreen(solo.toScreenX(0.262f), solo.toScreenY(0.409f));
			solo.waitForActivity("GraphEditActivity");
			assertTrue(solo.searchText(Pattern.quote("0")));
			assertTrue(solo.searchText(Pattern.quote("1 sec")));
			assertTrue(solo.searchText(Pattern.quote("1023")));
			assertTrue(solo.searchText(Pattern.quote("BAR")));
			assertTrue(solo.searchText(Pattern.quote("Delete")));
			assertTrue(solo.searchText(Pattern.quote("Graph Settings")));
			assertTrue(solo.searchText(Pattern.quote("INPUT")));
			assertTrue(solo.searchText(Pattern.quote("LINE")));
			assertTrue(solo.searchText(Pattern.quote("PIN")));
			assertTrue(solo.searchText(Pattern.quote("READING FREQUENCY")));
			assertTrue(solo.searchText(Pattern.quote("STYLE")));
		}
	public void test0041GUINewProject1WidgetBoxDeleteGraph() throws Exception {

			assertTrue("Wait for view (id: cc.blynk.R.id.click_view) failed.",
					solo.waitForViewById("cc.blynk.R.id.click_view", 20000));
			solo.clickOnView(solo.findViewById("cc.blynk.R.id.click_view"));
			solo.waitForActivity("DashboardActivity");
			solo.waitForActivity("GraphEditActivity");
			assertTrue("Wait for button (id: cc.blynk.R.id.button_delete) failed.",
					solo.waitForButtonById("cc.blynk.R.id.button_delete", 20000));
			solo.clickOnButton((Button) solo.findViewById("cc.blynk.R.id.button_delete"));
			solo.waitForActivity("DashboardActivity");
			assertTrue(solo.searchText(Pattern.quote("TestProgect1")));

	}

	public void test0042GUINewProject1WidgetBoxAddHistoryGraph() throws Exception {

			assertTrue("Wait for view (id: cc.blynk.R.id.click_view) failed.",
					solo.waitForViewById("cc.blynk.R.id.click_view", 20000));
			solo.clickOnView(solo.findViewById("cc.blynk.R.id.click_view"));
			solo.waitForActivity("DashboardActivity");
			assertTrue("Wait for text (id: cc.blynk.R.id.action_add) failed.",
					solo.waitForTextById("cc.blynk.R.id.action_add", 20000));
			solo.clickOnText((TextView) solo.findViewById("cc.blynk.R.id.action_add"));
			assertTrue("Wait for view (index: 73) failed.", solo.waitForView(73, 20000));
			solo.clickOnView(73);
			assertTrue(solo.searchText(Pattern.quote("1d")));
			assertTrue(solo.searchText(Pattern.quote("1h")));
			assertTrue(solo.searchText(Pattern.quote("1m")));
			assertTrue(solo.searchText(Pattern.quote("1w")));
			assertTrue(solo.searchText(Pattern.quote("3m")));
			assertTrue(solo.searchText(Pattern.quote("6h")));

	}
	public void test0043GUINewProject1WidgetBoxPropertyHistoryGraph() throws Exception {

			assertTrue("Wait for view (id: cc.blynk.R.id.click_view) failed.",
					solo.waitForViewById("cc.blynk.R.id.click_view", 20000));
			solo.clickOnView(solo.findViewById("cc.blynk.R.id.click_view"));
			solo.waitForActivity("DashboardActivity");
			solo.clickOnScreen(solo.toScreenX(0.286f), solo.toScreenY(0.472f));
			solo.waitForActivity("HistoryGraphEditActivity");
			assertTrue(solo.searchText(Pattern.quote("Data to show")));
			assertTrue(solo.searchText(Pattern.quote("Delete")));
			assertTrue(solo.searchText(Pattern.quote("History Graph Settings")));
			assertTrue(solo.searchText(Pattern.quote("OFF")));
			assertTrue(solo.searchText(Pattern.quote("ON")));
			assertTrue(solo.searchText(Pattern.quote("PIN")));
			assertTrue(solo.searchText(Pattern.quote("SHOW LEGEND")));
		}
	public void test0044GUINewProject1WidgetBoxDeleteHistoryGraph() throws Exception {

			assertTrue("Wait for view (id: cc.blynk.R.id.click_view) failed.",
					solo.waitForViewById("cc.blynk.R.id.click_view", 20000));
			solo.clickOnView(solo.findViewById("cc.blynk.R.id.click_view"));
			solo.waitForActivity("DashboardActivity");
			solo.clickOnScreen(solo.toScreenX(0.337f), solo.toScreenY(0.440f));
			solo.waitForActivity("HistoryGraphEditActivity");
			assertTrue("Wait for button (id: cc.blynk.R.id.button_delete) failed.",
					solo.waitForButtonById("cc.blynk.R.id.button_delete", 20000));
			solo.clickOnButton((Button) solo.findViewById("cc.blynk.R.id.button_delete"));
			solo.waitForActivity("DashboardActivity");
			assertTrue(solo.searchText(Pattern.quote("TestProgect1")));

	}

	public void test0045GUINewProject1WidgetBoxAddTerminal() throws Exception {

			assertTrue("Wait for view (id: cc.blynk.R.id.click_view) failed.",
					solo.waitForViewById("cc.blynk.R.id.click_view", 20000));
			solo.clickOnView(solo.findViewById("cc.blynk.R.id.click_view"));
			solo.waitForActivity("DashboardActivity");
			assertTrue("Wait for text (id: cc.blynk.R.id.action_add) failed.",
					solo.waitForTextById("cc.blynk.R.id.action_add", 20000));
			solo.clickOnText((TextView) solo.findViewById("cc.blynk.R.id.action_add"));
			assertTrue("Wait for view (index: 77) failed.", solo.waitForView(77, 20000));
			solo.clickOnView(77);
			assertTrue(solo.searchText(Pattern.quote("TERMINAL")));

	}
	public void test0046GUINewProject1WidgetBoxPropertyTerminal() throws Exception {

			assertTrue("Wait for view (id: cc.blynk.R.id.click_view) failed.",
					solo.waitForViewById("cc.blynk.R.id.click_view", 20000));
			solo.clickOnView(solo.findViewById("cc.blynk.R.id.click_view"));
			solo.waitForActivity("DashboardActivity");
			solo.clickOnScreen(solo.toScreenX(0.359f), solo.toScreenY(0.480f));
			solo.waitForActivity("TerminalEditActivity");
			assertTrue(solo.searchText(Pattern.quote("AUTOSCROLL")));
			assertTrue(solo.searchText(Pattern.quote("Delete")));
			assertTrue(solo.searchText(Pattern.quote("Example:\nterminal.print(\"Hello World\")")));
			assertTrue(solo.searchText(Pattern.quote("INPUT")));
			assertTrue(solo.searchText(Pattern.quote("INPUT LINE")));
			assertTrue(solo.searchText(Pattern.quote("OFF")));
			assertTrue(solo.searchText(Pattern.quote("ON")));
			assertTrue(solo.searchText(Pattern.quote("PIN")));
			assertTrue(solo.searchText(Pattern.quote("Terminal Settings")));
		}
	public void test0047GUINewProject1WidgetBoxDeleteTerminal() throws Exception {

			assertTrue("Wait for view (id: cc.blynk.R.id.click_view) failed.",
					solo.waitForViewById("cc.blynk.R.id.click_view", 20000));
			solo.clickOnView(solo.findViewById("cc.blynk.R.id.click_view"));
			solo.waitForActivity("DashboardActivity");
			solo.clickOnScreen(solo.toScreenX(0.400f), solo.toScreenY(0.472f));
			solo.waitForActivity("TerminalEditActivity");
			assertTrue("Wait for button (id: cc.blynk.R.id.button_delete) failed.",
					solo.waitForButtonById("cc.blynk.R.id.button_delete", 20000));
			solo.clickOnButton((Button) solo.findViewById("cc.blynk.R.id.button_delete"));
			solo.waitForActivity("DashboardActivity");
			assertTrue(solo.searchText(Pattern.quote("TestProgect1")));

	}

	public void test0048GUINewProject1WidgetBoxAddTwitter_______WRONG() throws Exception {

			assertTrue("Wait for view (id: cc.blynk.R.id.click_view) failed.",
					solo.waitForViewById("cc.blynk.R.id.click_view", 20000));
			solo.clickOnView(solo.findViewById("cc.blynk.R.id.click_view"));
			solo.waitForActivity("DashboardActivity");
			assertTrue("Wait for text (id: cc.blynk.R.id.action_add) failed.",
					solo.waitForTextById("cc.blynk.R.id.action_add", 20000));
			solo.clickOnText((TextView) solo.findViewById("cc.blynk.R.id.action_add"));
			assertTrue("Wait for view (index: 84) failed.", solo.waitForView(84, 20000));
			solo.clickOnView(84);
			assertTrue(solo.searchText(Pattern.quote("TestProgect1")));

	}
	public void test0049GUINewProject1WidgetBoxPropertyTwitter_______WRONG() throws Exception {

			assertTrue("Wait for view (id: cc.blynk.R.id.click_view) failed.",
					solo.waitForViewById("cc.blynk.R.id.click_view", 20000));
			solo.clickOnView(solo.findViewById("cc.blynk.R.id.click_view"));
			solo.waitForActivity("DashboardActivity");
			solo.waitForActivity("TwitterEditActivity");
			assertTrue(solo.searchText(Pattern.quote("Connect Twitter")));
			assertTrue(solo.searchText(Pattern.quote("Delete")));
			assertTrue(solo.searchText(Pattern.quote("TWITTER ACCOUNT")));
			assertTrue(solo.searchText(Pattern.quote("Twitter Settings")));
		}

	public void test0050GUINewProject1WidgetBoxDeleteTwitter() throws Exception {

			assertTrue("Wait for view (id: cc.blynk.R.id.click_view) failed.",
					solo.waitForViewById("cc.blynk.R.id.click_view", 20000));
			solo.clickOnView(solo.findViewById("cc.blynk.R.id.click_view"));
			solo.waitForActivity("DashboardActivity");
			solo.waitForActivity("TwitterEditActivity");
			assertTrue("Wait for button (id: cc.blynk.R.id.button_delete) failed.",
					solo.waitForButtonById("cc.blynk.R.id.button_delete", 20000));
			solo.clickOnButton((Button) solo.findViewById("cc.blynk.R.id.button_delete"));
			solo.waitForActivity("DashboardActivity");
			assertTrue(solo.searchText(Pattern.quote("TestProgect1")));

	}

	public void test0051GUINewProject1WidgetBoxAddPush________WRONG() throws Exception {

			assertTrue("Wait for view (id: cc.blynk.R.id.click_view) failed.",
					solo.waitForViewById("cc.blynk.R.id.click_view", 20000));
			solo.clickOnView(solo.findViewById("cc.blynk.R.id.click_view"));
			solo.waitForActivity("DashboardActivity");
			assertTrue("Wait for text (id: cc.blynk.R.id.action_add) failed.",
					solo.waitForTextById("cc.blynk.R.id.action_add", 20000));
			solo.clickOnText((TextView) solo.findViewById("cc.blynk.R.id.action_add"));
			assertTrue("Wait for view (index: 88) failed.", solo.waitForView(88, 20000));
			solo.clickOnView(88);
			assertTrue(solo.searchText(Pattern.quote("TestProgect1")));

	}
	public void test0052GUINewProject1WidgetBoxPropertyPush________WRONG() throws Exception {

			assertTrue("Wait for view (id: cc.blynk.R.id.click_view) failed.",
					solo.waitForViewById("cc.blynk.R.id.click_view", 20000));
			solo.clickOnView(solo.findViewById("cc.blynk.R.id.click_view"));
			solo.waitForActivity("DashboardActivity");
			solo.clickOnScreen(solo.toScreenX(0.111f), solo.toScreenY(0.244f));
			solo.waitForActivity("NotificationEditActivity");
			assertTrue(solo.searchText(Pattern.quote("Delete")));
			assertTrue(solo.searchText(Pattern.quote("HIGH")));
			assertTrue(solo.searchText(Pattern.quote("NORMAL")));
			assertTrue(solo.searchText(Pattern.quote("NOTIFY WHEN HARDWARE GOES OFFLINE")));
			assertTrue(solo.searchText(Pattern.quote("Notification Settings")));
			assertTrue(solo.searchText(Pattern.quote("OFF")));
			assertTrue(solo.searchText(Pattern.quote("ON")));
			assertTrue(solo.searchText(Pattern.quote("PRIORITY")));
		}
	public void test0053GUINewProject1WidgetBoxDeletePush() throws Exception {

			assertTrue("Wait for view (id: cc.blynk.R.id.click_view) failed.",
					solo.waitForViewById("cc.blynk.R.id.click_view", 20000));
			solo.clickOnView(solo.findViewById("cc.blynk.R.id.click_view"));
			solo.waitForActivity("DashboardActivity");
			solo.waitForActivity("NotificationEditActivity");
			assertTrue("Wait for button (id: cc.blynk.R.id.button_delete) failed.",
					solo.waitForButtonById("cc.blynk.R.id.button_delete", 20000));
			solo.clickOnButton((Button) solo.findViewById("cc.blynk.R.id.button_delete"));
			solo.waitForActivity("DashboardActivity");
			assertTrue(solo.searchText(Pattern.quote("TestProgect1")));

	}

	public void test0054GUINewProject1WidgetBoxAddEmail______WRONG() throws Exception {

			assertTrue("Wait for view (id: cc.blynk.R.id.click_view) failed.",
					solo.waitForViewById("cc.blynk.R.id.click_view", 20000));
			solo.clickOnView(solo.findViewById("cc.blynk.R.id.click_view"));
			solo.waitForActivity("DashboardActivity");
			assertTrue("Wait for text (id: cc.blynk.R.id.action_add) failed.",
					solo.waitForTextById("cc.blynk.R.id.action_add", 20000));
			solo.clickOnText((TextView) solo.findViewById("cc.blynk.R.id.action_add"));
			assertTrue("Wait for view (index: 92) failed.", solo.waitForView(92, 20000));
			solo.clickOnView(92);
			assertTrue(solo.searchText(Pattern.quote("TestProgect1")));

	}
	public void test0055GUINewProject1WidgetBoxPropertyEmail______WRONG() throws Exception {

			assertTrue("Wait for view (id: cc.blynk.R.id.click_view) failed.",
					solo.waitForViewById("cc.blynk.R.id.click_view", 20000));
			solo.clickOnView(solo.findViewById("cc.blynk.R.id.click_view"));
			solo.waitForActivity("DashboardActivity");
			solo.waitForActivity("MailEditActivity");
			assertTrue(solo.searchText(Pattern.quote("Delete")));
			assertTrue(solo.searchText(Pattern.quote("Email Settings")));
		}
	public void test0056GUINewProject1WidgetBoxDeleteEmail() throws Exception {

			assertTrue("Wait for view (id: cc.blynk.R.id.click_view) failed.",
					solo.waitForViewById("cc.blynk.R.id.click_view", 20000));
			solo.clickOnView(solo.findViewById("cc.blynk.R.id.click_view"));
			solo.waitForActivity("DashboardActivity");
			solo.clickOnScreen(solo.toScreenX(0.088f), solo.toScreenY(0.212f));
			solo.waitForActivity("MailEditActivity");
			assertTrue("Wait for button (id: cc.blynk.R.id.button_delete) failed.",
					solo.waitForButtonById("cc.blynk.R.id.button_delete", 20000));
			solo.clickOnButton((Button) solo.findViewById("cc.blynk.R.id.button_delete"));
			solo.waitForActivity("DashboardActivity");
			assertTrue(solo.searchText(Pattern.quote("TestProgect1")));

	}

	public void test0057GUINewProject1WidgetBoxAddBridge______WRONG() throws Exception {
	
			assertTrue("Wait for view (id: cc.blynk.R.id.click_view) failed.",
					solo.waitForViewById("cc.blynk.R.id.click_view", 20000));
			solo.clickOnView(solo.findViewById("cc.blynk.R.id.click_view"));
			solo.waitForActivity("DashboardActivity");
			assertTrue("Wait for text (id: cc.blynk.R.id.action_add) failed.",
					solo.waitForTextById("cc.blynk.R.id.action_add", 20000));
			solo.clickOnText((TextView) solo.findViewById("cc.blynk.R.id.action_add"));
			assertTrue("Wait for view (index: 99) failed.", solo.waitForView(99, 20000));
			solo.clickOnView(99);
			assertTrue(solo.searchText(Pattern.quote("TestProgect1")));
	
	}
	public void test0058GUINewProject1WidgetBoxPropertyBridge______WRONG() throws Exception {

			assertTrue("Wait for view (id: cc.blynk.R.id.click_view) failed.",
					solo.waitForViewById("cc.blynk.R.id.click_view", 20000));
			solo.clickOnView(solo.findViewById("cc.blynk.R.id.click_view"));
			solo.waitForActivity("DashboardActivity");
			solo.clickOnScreen(solo.toScreenX(0.097f), solo.toScreenY(0.250f));
			solo.waitForActivity("BridgeEditActivity");
			assertTrue(solo.searchText(Pattern.quote("Bridge Settings")));
			assertTrue(solo.searchText(Pattern.quote("Delete")));
		}
	public void test0059GUINewProject1WidgetBoxDeleteBridge() throws Exception {
		
			assertTrue("Wait for view (id: cc.blynk.R.id.click_view) failed.",
					solo.waitForViewById("cc.blynk.R.id.click_view", 20000));
			solo.clickOnView(solo.findViewById("cc.blynk.R.id.click_view"));
			solo.waitForActivity("DashboardActivity");
			solo.clickOnScreen(solo.toScreenX(0.082f), solo.toScreenY(0.218f));
			solo.waitForActivity("BridgeEditActivity");
			assertTrue("Wait for button (id: cc.blynk.R.id.button_delete) failed.",
					solo.waitForButtonById("cc.blynk.R.id.button_delete", 20000));
			solo.clickOnButton((Button) solo.findViewById("cc.blynk.R.id.button_delete"));
			solo.waitForActivity("DashboardActivity");
			assertTrue(solo.searchText(Pattern.quote("TestProgect1")));
	
	}

}
