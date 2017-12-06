package io.arghwoo.simpleapiserver

import com.mongodb.casbah._
import com.mongodb.casbah.commons.MongoDBObject

class MongoDBManager private {
  val MONGODB_URI = "127.0.0.1"
  val usersCollection = MongoClient()("test")("users_colle")

  val booksCollection = MongoClient()("test")("books_colle")

  def usersInsertDoc(request: UserResPostRequest): Unit = {
    val dbObj = MongoDBObject("user_id" -> request.user_id, "first_name" -> request.first_name,
        "last_name" -> request.last_name, "age" -> request.age, "city" -> request.city)
    usersCollection.insert(dbObj)
  }

  def usersDeleteDoc(userId: String): Unit = {
    val query = MongoDBObject("user_id" -> userId)
    usersCollection.findAndRemove(query)
  }

  def booksInsertDoc(request: BookResPostRequest): Unit = {
    val dbObj = MongoDBObject("isbn" -> request.isbn, "name" -> request.name,
      "category" -> request.category)
    booksCollection.insert(dbObj)
  }

  def booksDeleteDoc(isbn: String): Unit = {
    println("isbn = " + isbn)
    val query = MongoDBObject("isbn" -> isbn)
    booksCollection.findAndRemove(query)
  }



}

object MongoDBManager {

  private val mongodbManager = new MongoDBManager

  def apply() = mongodbManager

}
