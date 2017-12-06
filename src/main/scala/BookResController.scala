package io.arghwoo.simpleapiserver

import com.twitter.finagle.http.Request
import com.twitter.finatra.http.Controller

class BookResController extends Controller{
  val uriBookEp : String = "/books/:isbn"
  val uriBookApi : String = "/books"
  val mongodbManager = MongoDBManager()

  get(uriBookEp) { request: Request =>
    val result: String = mongodbManager.bookQueryDoc(request.params("isbn"))
    if (result.isEmpty()) {
      "{\"result\" : \"none\"}"
    }
    else {
      "{\"result\" : " + result + "}"
    }
  }

  put(uriBookEp){ request: BookResPutRequest =>
    if (mongodbManager.bookUpdateDoc(request)) {
      "{\"result\" : \"done\"}"
    } else {
      "{\"result\" : \"failed\"}"
    }
  }

  post(uriBookApi) { request: BookResPostRequest =>
    if (mongodbManager.booksInsertDoc(request)) {
      "{\"result\" : \"done\"}"
    } else {
      "{\"result\" : \"failed\"}"
    }
  }

  delete(uriBookEp) { request: Request =>
    if (mongodbManager.booksDeleteDoc(request.params("isbn"))) {
      "{\"result\" : \"done\"}"
    } else {
      "{\"result\" : \"failed\"}"
    }
  }
}
