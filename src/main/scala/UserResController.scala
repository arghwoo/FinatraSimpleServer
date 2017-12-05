
package io.arghwoo.simpleapiserver

import com.twitter.finagle.http.Request
import com.twitter.finatra.http.Controller
import org.mongodb.scala.Document

class UserResController extends Controller {
  val uriUserEp : String = "/users/:id"
  val uriUserApi : String = "/users"
  get(uriUserEp) { request: Request =>
    info("hi")
    val userName:String = request.uri
    "Hello " + request.params("id") + ", method is " + request.method.name
  }

  put(uriUserEp) { request: UserResPutRequest =>
    info("hi")
    val doc: Document = Document("user_id" -> request.id, "first_name" -> request.first_name,
      "last_name" -> request.last_name, "age" -> request.age, "city" -> request.city)
    request.id + " OK"
  }

  post(uriUserApi) { request: UserResPostRequest =>
    val doc: Document = Document("user_id" -> request.user_id, "first_name" -> request.first_name,
      "last_name" -> request.last_name, "age" -> request.age, "city" -> request.city)
    request.user_id + " OK"
  }

  delete(uriUserEp) { request: Request =>
    info("hi")
    "Hello " + request.params("id") + ", method is " + request.method.name
  }
}
