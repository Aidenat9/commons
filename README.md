### Android Commons ###

Various useful utilities for Android apps development.

[![](https://jitpack.io/v/Aidenat9/commons.svg)](https://jitpack.io/#Aidenat9/commons)

### Usage ###


Step 1. Add the JitPack repository to your build file

    gradle

Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.Aidenat9:commons:v1.0.0'
	}



### Main features ###

#### Views ####
Simple utility class to find views within layout with implicit types casting
(e.g. `TextView tv = Views.find(layout, R.id.text_view);`)
Includes other methods to simplify work with views and layouts.

#### Navigate ####
Helper methods to navigate between screens and to open external app to perform related actions,
for example: share text; compose email or sms; open browser or Google Play, pick phone number
and many more.

#### SpannableBuilder ####
SpannableStringBuilder implementation that helps applying various text styles to a single TextView.

#### Fonts ####
Utility to set custom fonts for all views extending TextView, uses android:tag to store font info.

#### InstanceStateManager ####
Helper methods to save and restore instance state of activities and fragments.

#### ItemsAdapter & LayoutItemsAdapter ####
BaseAdapter implementations to be used with java.util.List.
LayoutItemsAdapter class provides methods to populate any ViewGroup with views from adapter
with optional views recycling mechanism.

#### KeyboardHelper ####
Helper methods to show / hide keyboard and listen for keyboard state.

#### Convertable & ConvertUtils ####
Helper utils to convert one set of objects into another.

#### ThreadSafeDateFormatter ####
Thread safe wrapper for SimpleDateFormatter.

#### ISO8601DateFormatter ####
ISO 8601 date parser and formatter.

#### FillWidthImageView ####
ImageView that will be scaled to fit entire available width preserving aspect ratio (by adjusting view's height). It is also possible to set aspect ratio of the image before it is loaded into the view.

#### BoundedFrameLayout & BoundedLinearLayout & BoundedRelativeLayout ####
Base view groups implementations that allows setting maxWidth and maxHeight.
#### PermissionUtils ####
权限判断工具类
#### SpUtil ####
微信开源mmkv封装工具
#### RoundCornerImageView ####
圆角矩形图片
#### ImageLoaderImpl ####
图片加载工具实现


#### 其他一些工具请下载源码查看 ####


#### License ####

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

