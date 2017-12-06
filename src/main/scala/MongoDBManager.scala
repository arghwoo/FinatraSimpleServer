package io.arghwoo.simpleapiserver

import com.mongodb.casbah._
import com.mongodb.casbah.commons.MongoDBObject

class MongoDBManager private {
  val MONGODB_URI = "127.0.0.1"
  val usersCollection = MongoClient()("test")("users_colle")

  val booksCollection = MongoClient()("test")("books_colle")

  def usersInsertDoc(request: UserResPostRequest): Boolean = {
    if (usersCollection.findOne(MongoDBObject("_id" -> request.user_id)).isEmpty) {
      val dbObj = MongoDBObject("_id" -> request.user_id, "first_name" -> request.first_name,
        "last_name" -> request.last_name, "age" -> request.age, "city" -> request.city)
      usersCollection.insert(dbObj)
      true
    } else {
      false
    }
  }

  def usersUpdateDoc(request: UserResPutRequest): Boolean = {
    if (usersCollection.findOne(MongoDBObject("_id" -> request.id)).nonEmpty) {
      val dbObj = MongoDBObject("_id" -> request.id, "first_name" -> request.first_name,
        "last_name" -> request.last_name, "age" -> request.age, "city" -> request.city)
      usersCollection.findAndModify(MongoDBObject("_id" -> request.id), dbObj)
      true
    } else {
      false
    }
  }

  def userQueryDoc(userId: String): String = {
    usersCollection.findOne(MongoDBObject("_id" -> userId)).mkString
  }

  def usersDeleteDoc(userId: String): Boolean = {
    if (usersCollection.findOne(MongoDBObject("_id" -> userId)).nonEmpty) {
      val query = MongoDBObject("_id" -> userId)
      usersCollection.findAndRemove(query)
      true
    } else {
      false
    }
  }



  def booksInsertDoc(request: BookResPostRequest): Boolean = {
    if (booksCollection.findOne(MongoDBObject("_id" -> request.isbn)).isEmpty) {
      val dbObj = MongoDBObject("_id" -> request.isbn, "name" -> request.name,
        "category" -> request.category)
      booksCollection.insert(dbObj)
      true
    } else {
      false
    }
  }

  def bookUpdateDoc(request: BookResPutRequest): Boolean = {
    if (booksCollection.findOne(MongoDBObject("_id" -> request.isbn)).nonEmpty) {
      val dbObj = MongoDBObject("_id" -> request.isbn, "name" -> request.name,
        "category" -> request.category)
      booksCollection.findAndModify(MongoDBObject("isbn" -> request.isbn), dbObj)
      true
    } else {
      false
    }
  }

  def bookQueryDoc(isbn: String): String = {
    booksCollection.findOne(MongoDBObject("_id" -> isbn)).mkString
  }


  def booksDeleteDoc(isbn: String): Boolean = {
    if (booksCollection.findOne(MongoDBObject("_id" -> isbn)).nonEmpty) {
      val query = MongoDBObject("_id" -> isbn)
      booksCollection.findAndRemove(query)
      true
    } else {
      false
    }
  }



}

object MongoDBManager {

  private val mongodbManager = new MongoDBManager

  def apply() = mongodbManager

}
