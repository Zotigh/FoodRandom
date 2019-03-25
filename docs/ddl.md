```sql
CREATE TABLE IF NOT EXISTS `Recipe` (
 `recipe_id` 		INTEGER 	PRIMARY KEY AUTOINCREMENT NOT NULL,
 `ingredients` 		TEXT 		NOT NULL,
 `recipe_name` 		TEXT,
 `smallImageUrls` 	TEXT, 
 `recipeKey` 		TEXT
 );
 
 
```