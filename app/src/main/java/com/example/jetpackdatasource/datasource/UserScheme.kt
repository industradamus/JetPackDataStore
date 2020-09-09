package com.example.jetpackdatasource.datasource

import androidx.datastore.preferences.preferencesKey


/**
 * @author s.buvaka
 */
object UserScheme {
    val FIELD_NAME = preferencesKey<String>("name")
    val FIELD_LAST_NAME = preferencesKey<String>("last_name")
    val FIELD_AGE = preferencesKey<Int>("age")
    val FIELD_IS_ACTIVE = preferencesKey<Boolean>("is_active")
}
