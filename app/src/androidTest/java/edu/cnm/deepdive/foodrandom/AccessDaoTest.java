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