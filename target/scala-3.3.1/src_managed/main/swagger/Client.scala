/*
 * This file was generated by guardrail (https://github.com/guardrail-dev/guardrail).
 * Modifications will be overwritten; instead edit the OpenAPI/Swagger spec file.
 */
package swagger
import _root_.swagger.Implicits._
import _root_.swagger.Http4sImplicits._
import _root_.swagger.definitions._
import org.http4s.circe._
import cats.data.EitherT
import cats.implicits._
import cats.effect.IO
import cats.effect.Async
import cats.effect.Sync
import org.http4s.{ Status => _, _ }
import org.http4s.client.{Client => Http4sClient}
import org.http4s.client.UnexpectedStatus
import org.http4s.dsl.io.Path
import org.http4s.multipart._
import org.http4s.headers._
import org.http4s.implicits._
import org.http4s.EntityEncoder._
import org.http4s.EntityDecoder._
import org.http4s.Media
import org.typelevel.ci.CIString
import fs2.Stream
import io.circe.Json
import scala.language.higherKinds
import scala.language.implicitConversions
object Client {
  def apply[F[_]](host: String)(implicit F: Async[F], httpClient: Http4sClient[F]): Client[F] = new Client[F](host = host)(F = F, httpClient = httpClient)
  def httpClient[F[_]](httpClient: Http4sClient[F], host: String)(implicit F: Async[F]): Client[F] = new Client[F](host = host)(F = F, httpClient = httpClient)
}
class Client[F[_]](host: String)(implicit F: Async[F], httpClient: Http4sClient[F]) {
  val basePath: String = ""
  private def parseOptionalHeader(response: Response[F], header: String): F[Option[String]] = F.pure(response.headers.get(CIString(header)).map(_.head.value))
  private def parseRequiredHeader(response: Response[F], header: String): F[String] = response.headers.get(CIString(header)).map(_.head.value).fold[F[String]](F.raiseError(ParseFailure("Missing required header.", s"HTTP header '$header' is not present.")))(F.pure)
  private[this] val xxxOkDecoder = jsonOf[F, _root_.swagger.definitions.Xxx]
  def xxx(headers: List[Header.ToRaw] = List.empty): F[XxxResponse] = {
    val allHeaders: List[org.http4s.Header.ToRaw] = List[Header.ToRaw](org.http4s.headers.Accept(org.http4s.MediaType.application.json.withQValue(org.http4s.QValue.One))) ++ headers ++ List[Option[Header.ToRaw]]().flatten
    val req = Request[F](method = Method.GET, uri = Uri.unsafeFromString(host + basePath + "/xxx"), headers = Headers(allHeaders))
    httpClient.run(req).use({
      case _root_.org.http4s.Status.Ok(resp) =>
        F.map(xxxOkDecoder.decode(resp, strict = false).value.flatMap(F.fromEither))(XxxResponse.Ok.apply): F[XxxResponse]
      case resp =>
        F.raiseError[XxxResponse](UnexpectedStatus(resp.status, Method.GET, req.uri))
    })
  }
}
sealed abstract class XxxResponse {
  def fold[A](handleOk: _root_.swagger.definitions.Xxx => A): A = this match {
    case x: XxxResponse.Ok =>
      handleOk(x.value)
  }
}
object XxxResponse { case class Ok(value: _root_.swagger.definitions.Xxx) extends XxxResponse }