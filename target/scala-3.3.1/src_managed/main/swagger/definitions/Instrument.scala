/*
 * This file was generated by guardrail (https://github.com/guardrail-dev/guardrail).
 * Modifications will be overwritten; instead edit the OpenAPI/Swagger spec file.
 */
package swagger.definitions
import cats.syntax.either._
import io.circe.syntax._
import cats.instances.all._
import _root_.swagger.Implicits._
case class Instrument(id: Option[Long] = None)
object Instrument {
  implicit val encodeInstrument: _root_.io.circe.Encoder.AsObject[Instrument] = {
    _root_.io.circe.Encoder.AsObject.instance[Instrument](a => _root_.io.circe.JsonObject.fromIterable(_root_.scala.Vector(("id", a.id.asJson))))
  }
  implicit val decodeInstrument: _root_.io.circe.Decoder[Instrument] = new _root_.io.circe.Decoder[Instrument] { final def apply(c: _root_.io.circe.HCursor): _root_.io.circe.Decoder.Result[Instrument] = for (v0 <- c.downField("id").as[Option[Long]]) yield Instrument(v0) }
}