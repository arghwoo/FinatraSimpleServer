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

  def usersUpdateDoc(request: UserResPutRequest): Unit = {
    val dbObj = MongoDBObject("user_id" -> request.id, "first_name" -> request.first_name,
      "last_name" -> request.last_name, "age" -> request.age, "city" -> request.city)
    usersCollection.findAndModify(MongoDBObject("user_id" -> request.id), dbObj)
  }

  def userQueryDoc(userId: String): String = {
    usersCollection.findOne(MongoDBObject("user_id" -> userId)).mkString
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

  def bookUpdateDoc(request: BookResPutRequest): Unit = {
    val dbObj = MongoDBObject("isbn" -> request.isbn, "name" -> request.name,
      "category" -> request.category)
    booksCollection.findAndModify(MongoDBObject("isbn" -> request.isbn), dbObj)
  }

  def bookQueryDoc(isbn: String): String = {
    booksCollection.findOne(MongoDBObject("isbn" -> isbn)).mkString
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
