# Purpose
 The basic functionality of this app is to randomize food based on something the users types and return a name, picture and list 
 of ingredients to see if that would be something they would like to make.
 
 I feel that the people that would be intrested are those people that have no clue as to the many ways you can cook something
  and this will open the door to more opportunities to explore different dishes. I often have this problem and think it would be 
  nice to have something like this.
* Use of multiple fragments with a `BottomNavigationView` as well as use of the back button between the list of recipes and the fragment it is displayed from.
* Shared preference that saves the last input the user type in the text editor
* Use of a SQLite local database that saves the users saved recipe information.
* The use of a `ListView` to display the users saved recipes.
* Consumption of External Sources from the Yummily api (see bellow for link to api).
* Custom drawables in the standard android icon format
* Automated testing that tests a Dao as well as basic app functionality.

# Current State
* This app is semi usable with out an internet connection as the user can save a recipe they are interested in.  
* At the time of this there are no bugs I am aware of. There are however a couple things that I given more time 
 would have liked to implemented. This includes three main things... The first is having the search result fragment 
 be saved on the back stack and not disappear every time you switch between fragments. The second is being able to 
 delete an item in the list of saved fragments. The third is to enable a link that will take the user to the Yummily 
 website so they can see preparation instructions as well as tutorial videos on the result they get back. Besides that
 I believe my app Is semi close complete.
 
# Testing
###  Physical android device and version Tested on
#### LGE LG_Q710AL (Android 8.1.0 API 27) LG Stylo 4
* No Known issues have occurred, except for functions that are not yet implemented.

### AccessDaoTest
#### Operations
* Creates a new Instance of Recipe.

### MainActivityTest
#### Operations
* Types the string "beef" in the text editor
* Performs the click on the randomize button
* Clicks on the navigation to the saved fragment
* Checks to make sure the saved fragment was loaded 
* Clicks on the first item in the list
* Finally checks to make sure that the fragment displaying the selected item from the list is displayed. 
	
# 3rd-party resources
### Libraries
 + [Google Gson](https://github.com/google/gson)
 + [Retrofit 2](https://square.github.io/retrofit/)
 + [Facebook Stetho](https://github.com/facebook/stetho)
 + [Glide](https://github.com/bumptech/glide)
 + [Room](https://developer.android.com/topic/libraries/architecture/room)
 + [Play Services Plus](https://developers.google.com/android/guides/releases)
	
## External Sources
 + [Yummily Api](https://developer.yummly.com/)
 
# Potential Improvements
### Stretch Goals(simplest to hardest)
* Add a delete option in the list of saved fragments.
* Save the fragment to the back stack of the main fragment so when you switch between them it is not lost.
* Make a second request to the api for the instructions on the how to make the recipe as it requires a separate request with different request params.

### Aesthetics
* I think that to me it is apparent that there are some things that could be visually done to improve the aesthetics. Mainly I think the image that is loaded is very bad to say the least. The ListView has no borders. The layout could possibly have a better back ground than just plain white. The Buttons could be customized. Some animations would be cool and make it seem more "alive" and thus more visually pleasing.
* Style the Buttons.
* Hide the text Editor once a selection is made.
* Hide the save button until the user gets a response from the api back. 
* Change the layout to be a scroll view.
* Add animations.

# Design & technical documentation
 + [ERD](Food(Random)ERD(V.3).pdf)
 + [DDL](docs/ddl.md)
 + [Javadoc](docs/api/)
 + [Wire Frame](Random%20Food%20Wire%20Frame.pdf)
 + [User Stories](userStories.md)
 
# Copyrights and Licenses
Copyright 2019 Lance Zotigh & Deep Dive Coding
Licensed under the Apache License, Version 2.0 (the “License”); you may not use this file except in compliance with the License. You may obtain a copy of the License at

 + [Link to the Apache License](http://www.apache.org/licenses/LICENSE-2.0)

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an “AS IS” BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
 + [junit 4 License](https://junit.org/junit4/license.html)
 + [gson](https://github.com/google/gson/blob/master/LICENSE)
 + [stetho License](https://github.com/facebook/stetho/blob/master/LICENSE)
 + [glide](https://github.com/bumptech/glide/blob/master/LICENSE)


# Instructions
 + [Build Instructions](BuildInstructions.md)
 + [Basic User Instructions](basicUserInstructions.md)
 
