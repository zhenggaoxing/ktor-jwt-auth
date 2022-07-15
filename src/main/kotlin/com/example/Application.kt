package com.example

import io.ktor.server.application.*
import com.example.plugins.*
//import kotlinx.coroutines.GlobalScope
//import kotlinx.coroutines.launch
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo

fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module() {
    val dbName = "kotr-jwt-auth"
    val mongoPw = System.getenv("MONGO_PW")
    val connectionString = "mongodb+srv://admin:$mongoPw@cluster0.ze81cza.mongodb.net/$dbName?retryWrites=true&w=majority"
    val db = KMongo.createClient(connectionString).coroutine.getDatabase(dbName)

    configureRouting()
    configureSecurity()
    configureMonitoring()
    configureSerialization()
}
