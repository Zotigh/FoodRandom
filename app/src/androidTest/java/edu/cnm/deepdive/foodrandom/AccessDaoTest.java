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

package edu.cnm.deepdive.foodrandom;


import static org.junit.Assert.*;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import edu.cnm.deepdive.foodrandom.model.FoodDB;
import edu.cnm.deepdive.foodrandom.model.dao.AccessDao;
import edu.cnm.deepdive.foodrandom.model.entity.Recipe;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * creates a simple test to test the Dao.
 */
public class AccessDaoTest {

  private AccessDao accessDao;
  private FoodDB foodDB;

  @Before
  public void setUp() throws Exception {

    Context context = InstrumentationRegistry.getTargetContext();
    foodDB = Room.inMemoryDatabaseBuilder(context, FoodDB.class).build();
    accessDao = foodDB.getAccessDao();
  }

  @Test
  public void select() {
    Recipe recipe = new Recipe();
    String title = "Test Recipe instance";
    recipe.setRecipeName(title);
    List<Long> ids = accessDao.insert(recipe);
    assertEquals(1, ids.size());
  }

  @After
  public void tearDown() throws Exception {
    foodDB.close();
  }
}