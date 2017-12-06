package io.arghwoo.simpleapiserver

import com.twitter.finagle.http.Request
import com.twitter.finatra.http.Controller

class BookResController extends Controller{
  val uriBookEp : String = "/books/:isbn"
  val uriBookApi : String = "/books"
  val mongodbManager = MongoDBManager()

  get(uriBookEp) { request: Request =>
    info("hi")
    val userName:String = request.uri
    "Hello " + request.params("isbn") + ", method is " + request.method.name
  }

  put(uriBookEp){ request: BookResPutRequest =>
    //val doc: Document = Document("isbn" -> request.isbn, "name" -> request.name,
     // "category" -> request.category)
    "OK"
  }

  post(uriBookApi) { request: BookResPostRequest =>
    mongodbManager.booksInsertDoc(request)
    "OK"
  }

  delete(uriBookEp) { request: Request =>
    info("hi")
    mongodbManager.booksDeleteDoc(request.params("isbn"))
    "Hello " + request.params("isbn") + ", method is " + request.method.name
  }
}
