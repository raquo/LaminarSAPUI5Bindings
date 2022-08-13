package be.doeraene.webcomponents.ui5

import be.doeraene.webcomponents.ui5.configkeys.PageBackgroundDesign
import be.doeraene.webcomponents.ui5.internal.Slot
import com.raquo.domtypes.generic.codecs.{BooleanAsAttrPresenceCodec, StringAsIsCodec}
import com.raquo.laminar.api.L.*
import com.raquo.laminar.builders.HtmlTag
import com.raquo.laminar.keys.{ReactiveHtmlAttr, ReactiveProp, ReactiveStyle}
import com.raquo.laminar.nodes.ReactiveHtmlElement
import org.scalajs.dom

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/** The ui5-page is a container component that holds one whole screen of an application. The page has three distinct
  * areas that can hold content - a header, content area and a footer.
  *
  * @see
  *   <a href="https://sap.github.io/ui5-webcomponents/playground/components/Page/">the doc</a> for more information.
  */
object Page {

  @js.native
  trait RawElement extends js.Object {}

  @js.native
  @JSImport("@ui5/webcomponents-fiori/dist/Page.js", JSImport.Default)
  object RawImport extends js.Object

  // object-s are lazy so you need to actually use them in your code to prevent dead code elimination
  used(RawImport)

  type Ref         = dom.html.Element with RawElement
  type ModFunction = Page.type => Mod[ReactiveHtmlElement[Ref]]

  private val tag: HtmlTag[Ref] = customHtmlTag("ui5-page")

  val id: ReactiveProp[String, String] = idAttr

  val backgroundDesign: ReactiveHtmlAttr[PageBackgroundDesign] =
    customHtmlAttr("background-design", PageBackgroundDesign.AsStringCodec)

  val disableScrolling: ReactiveHtmlAttr[Boolean] =
    customHtmlAttr("disable-scrolling", BooleanAsAttrPresenceCodec)

  val floatingFooter: ReactiveHtmlAttr[Boolean] =
    customHtmlAttr("floating-footer", BooleanAsAttrPresenceCodec)

  val hideFooter: ReactiveHtmlAttr[Boolean] =
    customHtmlAttr("hide-footer", BooleanAsAttrPresenceCodec)

  object slots {
    val footer: Slot = new Slot("footer")
    val header: Slot = new Slot("header")
  }

  object events {}

  def apply(mods: ModFunction*): HtmlElement = tag(mods.map(_(Page)): _*)

}
