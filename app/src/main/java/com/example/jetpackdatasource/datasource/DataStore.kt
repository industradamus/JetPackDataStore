package com.example.jetpackdatasource.datasource

import android.content.Context
import androidx.datastore.DataStore
import androidx.datastore.createDataStore
import androidx.datastore.handlers.ReplaceFileCorruptionHandler
import com.example.jetpackdatasource.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

/**
 * @author s.buvaka
 */
object DataStore {

    fun getUserProtoDataStore(context: Context): DataStore<User> =
        context.createDataStore(
            fileName = "user.pb",
            serializer = UserSerializer,
            corruptionHandler = ReplaceFileCorruptionHandler {
                User.getDefaultInstance().toBuilder()
                    .setName("Test Name")
                    .setLastName("Test Last Name")
                    .setAge(0)
                    .setIsActive(false)
                    .build()
            },
            scope = CoroutineScope(Dispatchers.IO + SupervisorJob())
        )
}

