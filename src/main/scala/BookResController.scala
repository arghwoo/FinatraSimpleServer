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
    mongodbManager.bookUpdateDoc(request)
    "{\"result\" : \"done\"}"
  }

  post(uriBookApi) { request: BookResPostRequest =>
    mongodbManager.booksInsertDoc(request)
    "{\"result\" : \"done\"}"
  }

  delete(uriBookEp) { request: Request =>
    info("hi")
    mongodbManager.booksDeleteDoc(request.params("isbn"))
    "{\"result\" : \"done\"}"
  }
}
