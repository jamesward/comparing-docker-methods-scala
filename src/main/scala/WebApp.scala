import java.net.InetSocketAddress

import com.sun.net.httpserver.{HttpHandler, HttpServer}

import scala.util.Using

object WebApp extends App {

  val port = sys.env.getOrElse("PORT", "8080").toInt

  val server = HttpServer.create(new InetSocketAddress(port), 0)

  val handler: HttpHandler = exchange => {
    val response = "hello, world".getBytes
    exchange.sendResponseHeaders(200, response.length)
    Using(exchange.getResponseBody)(_.write(response))
  }

  server.createContext("/", handler)

  println(s"Listening at http://localhost:$port")

  server.start()

}
