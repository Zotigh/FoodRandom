/*
 *  Copyright 2019 Lance Zotigh & Deep Dive Coding
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package edu.cnm.deepdive.foodrandom.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import edu.cnm.deepdive.foodrandom.model.entity.Recipe;
import java.util.List;

/**
 * Declares basic CRUD operations for {@link Recipe} instances in the local database, using Room
 * annotations.
 */
@Dao
public interface AccessDao {

  /**
   * Inserts one or more{@link Recipe} instance into the local database. Any primary key or
   * foreign key constraint violations will result in the existing records being retained.
   *
   * @param recipes {@link Recipe} instance to be inserted.
   */
  @Insert(onConflict = OnConflictStrategy.IGNORE)
  List<Long> insert(Recipe... recipes);

  /**
   * Will Delete one or more {@link Recipe} instances from local database when implemented.
   *
   * @param recipeName  instances of {@link Recipe} to be deleted from database.
   * @return number of records deleted.
   */
  @Delete
  int delete(Recipe... recipeName);
}
