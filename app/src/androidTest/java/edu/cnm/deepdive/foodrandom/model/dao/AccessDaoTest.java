package edu.cnm.deepdive.foodrandom.model.dao;

import static org.junit.Assert.*;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import edu.cnm.deepdive.foodrandom.model.FoodDB;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
//TODO Fill with Test and make new tests

  @After
  public void tearDown() throws Exception {
    foodDB.close();
  }
}