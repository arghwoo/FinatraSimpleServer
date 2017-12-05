package io.arghwoo.simpleapiserver

import com.twitter.finatra.request.RouteParam

case class UserResPutRequest(
                        @RouteParam("id") id:String,
                        first_name : String,
                        last_name : String,
                        age: Int,
                        city: String)

case class UserResPostRequest(
                              user_id:String,
                              first_name : String,
                              last_name : String,
                              age: Int,
                              city: String)