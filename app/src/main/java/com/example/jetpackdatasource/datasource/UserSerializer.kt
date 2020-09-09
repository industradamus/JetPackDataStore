package com.example.jetpackdatasource.datasource

import androidx.datastore.CorruptionException
import androidx.datastore.Serializer
import androidx.datastore.preferences.protobuf.InvalidProtocolBufferException
import com.example.jetpackdatasource.User
import java.io.InputStream
import java.io.OutputStream

/**
 * @author s.buvaka
 */
object UserSerializer : Serializer<User> {

    override fun readFrom(input: InputStream): User {
        try {
            return User.parseFrom(input)
        } catch (exception: InvalidProtocolBufferException) {
            throw CorruptionException("Cannot read proto.", exception)
        }
    }

    override fun writeTo(t: User, output: OutputStream) = t.writeTo(output)
}
