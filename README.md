# FoodRandom(RanFoo)

# generate a random food plate

# Motives/Aims
 * The basic functionality will be to randomize food based on something the users types and return a name, picture and list 
 of ingredients to see if that would be something they would like to make.
 * I feel that the people that would be intrested are those people that have no clue as to the many ways you can cook something
  and this will open the door to more opportunities to explore different dishes. I often have this problem and think it would be 
  nice to have something like this.

 # User Stories
 	
  * AS A/AN...  I WANT TO...	 SO THAT...
 	* As a (User) I want to (Have a system that can take what I like and make a random decision) so that (I dont have to decide what to make for a meal.) 
 	* As a (User) I want to (Be able to have something that will contour to my dietary restrictions) so that (I dont have to worry.)

# Current State
 * This app is semi usable with out an internet connection as the user can save a recipe they are interested in.  
 * At the time of this there are no bugs I am aware of. There are however a couple things that I given more time 
 would have liked to implemented. This includes three main things... The first is having the search result fragment 
 be saved on the back stack and not disappear every time you switch between fragments. The second is being able to 
 delete an item in the list of saved fragments. The third is to enable a link that will take the user to the yummily 
 website so they can see preparation instructions as well as tutorial videos on the result they get back. Besides that
 I believe my app Is semi close complete.

# android version Tested on
  * LGE LG_Q710AL (Android 8.1.0 API 27) LG Stylo 4
  * Target Sdk Version: 28
  * Min Sdk Version: 21
	
# External Sources
* [Yummily Api]{https://developer.yummly.com/}
 
#Asthetics
* I think that to me it is apparent that there are some things that could be visually done to improve the asthetics. Mainly I think the image that is loaded is very bad to say the least. The ListView has no borders. The layout could possibly have a better back ground than just plain white. The Buttons could be customized. Some animations would be cool and make it seem more "alive" and thus more visually pleasing.
* Style the Buttons.
* Hide the text Editor once a selection is made.
* Hide the save button until the user gets a response from the api back. 
* Change the layout to be a scroll view.
* Add animations.

# Stretch Goals(simplist to hardest)
* Add a delete option in the list of saved fragments.
* Save the fragment to the back stack of the main fragment so when you switch between them it is not lost.
* Make a second request to the api for the instructions on the how to make the recipe as it requires a seperate request with different request params.

## Links to more documentation
 + [ERD](Food(Random)ERD(V.3).pdf)
 + [DDL](docs/ddl.md)
 + [Javadoc](docs/api/)
 + [Wire Frame](Random%20Food%20Wire%20Frame.pdf)
 + [Basic User Instructions](basicUserInstructions.md)
 + [Build Instructions](BuildInstructions.md)
