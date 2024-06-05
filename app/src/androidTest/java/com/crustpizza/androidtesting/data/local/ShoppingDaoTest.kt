package com.crustpizza.androidtesting.data.local

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
class ShoppingDaoTest {

    private lateinit var database: ShoppingItemDatabase
    private lateinit var dao: ShoppingDao

    @Before
    fun setup() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            ShoppingItemDatabase::class.java
        ).allowMainThreadQueries().build()

        dao = database.shoppingDao()
    }


    @Test
    fun insertShoppingItem() {
        runBlocking {
            val shoppingItem = ShoppingItem(1, "test", 1, 1f, "ur")
            dao.insertShoppingItem(shoppingItem)

            val allShoppingItems = dao.observeAllShoppingItems()

        }
    }


    @After
    fun tearDown() {
        database.close()
    }

}