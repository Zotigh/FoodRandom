# FoodRandom(RanFoo)

# generate a random food plate

# Purpose
 The basic functionality of this app is to randomize food based on something the users types and return a name, picture and list 
 of ingredients to see if that would be something they would like to make.
 
 I feel that the people that would be intrested are those people that have no clue as to the many ways you can cook something
  and this will open the door to more opportunities to explore different dishes. I often have this problem and think it would be 
  nice to have something like this.
* Use of multiple fragments with a bottom navigation as well as use of the back button between the list of recipes and the fragment it is displayed from.
* Shared preference that saves the last input the user type in the text editor
* Use of a SQLite local database that saves the users saved recipe information.
* The use of a list view to display the users saved recipes.
* Consumption of External Sources from the Yummily api (see bellow for link to api).
* Custom drawables in the standard android icon format
* Automated testing that tests a Dao as well as basic app functionality.

# User Stories 
### AS A/AN...  I WANT TO...	 SO THAT...
 * As a (User) I want to (Have a system that can take what I like and make a random decision) so that (I dont have to decide what to make for a meal.) 
 * As a (User) I want to (Be able to have something that will contour to my dietary restrictions) so that (I dont have to worry.)

# Current State
 * This app is semi usable with out an internet connection as the user can save a recipe they are interested in.  
 * At the time of this there are no bugs I am aware of. There are however a couple things that I given more time 
 would have liked to implemented. This includes three main things... The first is having the search result fragment 
 be saved on the back stack and not disappear every time you switch between fragments. The second is being able to 
 delete an item in the list of saved fragments. The third is to enable a link that will take the user to the Yummily 
 website so they can see preparation instructions as well as tutorial videos on the result they get back. Besides that
 I believe my app Is semi close complete.

# android version Tested on
  * LGE LG_Q710AL (Android 8.1.0 API 27) LG Stylo 4
  * Target Sdk Version: 28
  * Min Sdk Version: 21
	
# 3rd part resources
* implementation 'com.google.code.gson:gson:2.8.5'
* implementation 'com.squareup.retrofit2:retrofit:2.5.0'
* implementation 'com.squareup.retrofit2:converter-gson:2.5.0'
* implementation 'com.facebook.stetho:stetho:1.5.0'
* implementation 'com.google.android.gms:play-services-plus:16.0.0'
* implementation 'android.arch.persistence.room:runtime:1.1.1'
* implementation 'com.github.bumptech.glide:glide:4.9.0'
	
# External Sources
* [Yummily Api](https://developer.yummly.com/)
 
# Aesthetics
* I think that to me it is apparent that there are some things that could be visually done to improve the aesthetics. Mainly I think the image that is loaded is very bad to say the least. The ListView has no borders. The layout could possibly have a better back ground than just plain white. The Buttons could be customized. Some animations would be cool and make it seem more "alive" and thus more visually pleasing.
* Style the Buttons.
* Hide the text Editor once a selection is made.
* Hide the save button until the user gets a response from the api back. 
* Change the layout to be a scroll view.
* Add animations.

# Stretch Goals(simplest to hardest)
* Add a delete option in the list of saved fragments.
* Save the fragment to the back stack of the main fragment so when you switch between them it is not lost.
* Make a second request to the api for the instructions on the how to make the recipe as it requires a separate request with different request params.

# Testing
### AccessDaoTest
#### Operations
* Creates a new Instance of Recipe.

# Copyrights and Licenses
* junit 4 [License](https://junit.org/junit4/license.html)
* [gson](https://github.com/google/gson/blob/master/LICENSE)
* [retrofit](https://square.github.io/retrofit/)
* stetho [License](https://github.com/facebook/stetho/blob/master/LICENSE)
* [play services plus](https://developers.google.com/android/guides/setup)
* [glide](https://github.com/bumptech/glide/blob/master/LICENSE)

## Links to more documentation
 + [ERD](Food(Random)ERD(V.3).pdf)
 + [DDL](docs/ddl.md)
 + [Javadoc](docs/api/)
 + [Wire Frame](Random%20Food%20Wire%20Frame.pdf)
 + [Basic User Instructions](basicUserInstructions.md)
 + [Build Instructions](BuildInstructions.md)
