package io.arghwoo.simpleapiserver

import com.twitter.finagle.http.Request
import com.twitter.finatra.http.Controller

class UserResController extends Controller {
  val uriUserEp : String = "/users/:id"
  val uriUserApi : String = "/users"
  val mongodbManager = MongoDBManager()

  get(uriUserEp) { request: Request =>
    val result: String = mongodbManager.userQueryDoc(request.params("id"))
    if (result.isEmpty()) {
      "{\"result\" : \"none\"}"
    }
    else {
      "{\"result\" : " + result + "}"
    }
  }

  put(uriUserEp) { request: UserResPutRequest =>
    if (mongodbManager.usersUpdateDoc(request)) {
      "{\"result\" : \"done\"}"
    } else {
      "{\"result\" : \"failed\"}"
    }
  }

  post(uriUserApi) { request: UserResPostRequest =>
    if (mongodbManager.usersInsertDoc(request)) {
      "{\"result\" : \"done\"}"
    } else {
      "{\"result\" : \"failed\"}"
    }
  }

  delete(uriUserEp) { request: Request =>
    if (mongodbManager.usersDeleteDoc(request.params("id"))) {
      "{\"result\" : \"done\"}"
    } else {
      "{\"result\" : \"faled\"}"
    }
  }
}
