package be.doeraene.webcomponents.ui5

import com.raquo.domtypes.generic.codecs.{BooleanAsAttrPresenceCodec, IntAsStringCodec, StringAsIsCodec}
import com.raquo.laminar.api.L.*
import com.raquo.laminar.builders.HtmlTag
import com.raquo.laminar.keys.{ReactiveHtmlAttr, ReactiveProp, ReactiveStyle}
import com.raquo.laminar.nodes.ReactiveHtmlElement
import org.scalajs.dom

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import be.doeraene.webcomponents.ui5.internal.Slot
import be.doeraene.webcomponents.ui5.eventtypes.{HasDetail, HasItem, HasTargetRef}
import be.doeraene.webcomponents.WebComponent

/** The ui5-li-groupheader is a special list item, used only to separate other list items into logical groups.
  *
  * @see
  *   <a href="https://sap.github.io/ui5-webcomponents/playground/components/List/">the doc</a> for more information.
  */
object UListGroupHeader extends WebComponent {

  @js.native
  trait RawElement extends js.Object {}

  @js.native
  @JSImport("@ui5/webcomponents/dist/List.js", JSImport.Default)
  object RawImport extends js.Object

  // object-s are lazy so you need to actually use them in your code to prevent dead code elimination
  used(RawImport)

  type Ref = dom.html.Element with RawElement

  protected val tag: HtmlTag[Ref] = customHtmlTag("ui5-li-groupheader")

  lazy val accessibleName: ReactiveHtmlAttr[String] = customHtmlAttr("accessible-name", StringAsIsCodec)
  lazy val selected: ReactiveHtmlAttr[Boolean]      = customHtmlAttr("selected", BooleanAsAttrPresenceCodec)

  object slots {}

  object events {}

  def apply(mods: ModFunction*): HtmlElement = tag(mods.map(_(UListGroupHeader)): _*)

}
