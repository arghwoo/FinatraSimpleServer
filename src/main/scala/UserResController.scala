
package io.arghwoo.simpleapiserver

import com.mongodb.casbah.commons.{MongoDBObject, MongoDBObjectBuilder}
import com.twitter.finagle.http.Request
import com.twitter.finatra.http.Controller

class UserResController extends Controller {
  val uriUserEp : String = "/users/:id"
  val uriUserApi : String = "/users"
  val mongodbManager = MongoDBManager()

  get(uriUserEp) { request: Request =>
    info("hi")
    val userName:String = request.uri
    "Hello " + request.params("id") + ", method is " + request.method.name
  }

  put(uriUserEp) { request: UserResPutRequest =>
    info("hi")
    //val doc: Document = Document("user_id" -> request.id, "first_name" -> request.first_name,
    //  "last_name" -> request.last_name, "age" -> request.age, "city" -> request.city)
    request.id + " OK"
  }

  post(uriUserApi) { request: UserResPostRequest =>
    mongodbManager.usersInsertDoc(request)
    request.user_id + " OK"
  }

  delete(uriUserEp) { request: Request =>
    info("hi")
    mongodbManager.usersDeleteDoc(request.params("id"))
    "Hello " + request.params("id") + ", method is " + request.method.name
  }
}
