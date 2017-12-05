package io.arghwoo.simpleapiserver

import com.twitter.finatra.request.RouteParam

case class BookRequest(
                        @RouteParam("book_id") bookId:String,
                        id: Long,
                        name: String,
                        category: String)