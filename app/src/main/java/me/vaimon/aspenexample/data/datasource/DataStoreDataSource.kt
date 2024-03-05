package me.vaimon.aspenexample.data.datasource

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.map
import javax.inject.Inject

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "AspenStatic")

class DataStoreDataSource @Inject constructor(
    @ApplicationContext context: Context
) {
    companion object {
        private val locationKey = stringPreferencesKey("location")
    }

    private val dataStore = context.dataStore

    val location = dataStore.data.map { preferences ->
        preferences[locationKey]
    }

    suspend fun saveLocation(location: String) = dataStore.edit { preferences ->
        preferences[locationKey] = location
    }
}