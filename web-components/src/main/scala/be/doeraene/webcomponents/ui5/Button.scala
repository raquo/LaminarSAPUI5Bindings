package be.doeraene.webcomponents.ui5

import be.doeraene.webcomponents.ui5.configkeys.{ButtonDesign, IconName}
import be.doeraene.webcomponents.ui5.eventtypes.EventWithPreciseTarget
import com.raquo.domtypes.generic.codecs.{BooleanAsAttrPresenceCodec, StringAsIsCodec}
import com.raquo.laminar.api.L.*
import com.raquo.laminar.builders.HtmlTag
import com.raquo.laminar.keys.{ReactiveHtmlAttr, ReactiveProp, ReactiveStyle}
import com.raquo.laminar.nodes.ReactiveHtmlElement
import org.scalajs.dom

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import be.doeraene.webcomponents.WebComponent

/** The ui5-button component represents a simple push button. It enables users to trigger actions by clicking or tapping
  * the ui5-button, or by pressing certain keyboard keys, such as Enter.
  *
  * @see
  *   <a href="https://sap.github.io/ui5-webcomponents/playground/components/Button/">the doc</a> for more information.
  */
object Button extends WebComponent with HasIcon {

  @js.native
  trait RawElement extends js.Object {}

  @js.native
  @JSImport("@ui5/webcomponents/dist/Button.js", JSImport.Default)
  object RawImport extends js.Object

  // object-s are lazy so you need to actually use them in your code to prevent dead code elimination
  used(RawImport)

  type Ref = dom.html.Element & RawElement

  protected val tag: HtmlTag[Ref] = customHtmlTag("ui5-button")

  lazy val disabled: ReactiveHtmlAttr[Boolean] = customHtmlAttr("disabled", BooleanAsAttrPresenceCodec)

  lazy val design: ReactiveHtmlAttr[ButtonDesign] = customHtmlAttr("design", ButtonDesign.AsStringCodec)

  lazy val tooltip: ReactiveHtmlAttr[String] = customHtmlAttr("tooltip", StringAsIsCodec)

  lazy val iconEnd: ReactiveHtmlAttr[Boolean] = customHtmlAttr("icon-end", BooleanAsAttrPresenceCodec)

  lazy val iconOnly: ReactiveHtmlAttr[Boolean] = customHtmlAttr("icon-only", BooleanAsAttrPresenceCodec)

  lazy val submits: ReactiveHtmlAttr[Boolean] = {
    SubmitsSupport
    customHtmlAttr("submits", BooleanAsAttrPresenceCodec)
  }

  object slots {}

  object events {
    val onClick: EventProp[EventWithPreciseTarget[Ref]] = new EventProp("click")
  }

  def apply(mods: ModFunction*): HtmlElement = tag(mods.map(_(Button)): _*)

}
