
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._

import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._

/**/
object index extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(message: String):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.19*/("""

"""),format.raw/*3.1*/("""<!DOCTYPE html>

<html>
<head>
    <title>Hello</title>
    <link rel="stylesheet" media="screen" href=""""),_display_(/*8.50*/routes/*8.56*/.Assets.at("stylesheets/main.css")),format.raw/*8.90*/("""">
    <link rel="shortcut icon" type="image/png" href=""""),_display_(/*9.55*/routes/*9.61*/.Assets.at("images/favicon.png")),format.raw/*9.93*/("""">
    <script src=""""),_display_(/*10.19*/routes/*10.25*/.Assets.at("javascripts/hello.js")),format.raw/*10.59*/("""" type="text/javascript"></script>
    </head>
    <body>
        """),_display_(/*13.10*/message),format.raw/*13.17*/("""
    """),format.raw/*14.5*/("""</body>
</html>
"""))}
  }

  def render(message:String): play.twirl.api.HtmlFormat.Appendable = apply(message)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (message) => apply(message)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Sat Jul 04 16:57:57 PDT 2015
                  SOURCE: /Users/anhngo/pergit/stock/app/views/index.scala.html
                  HASH: 2b74f025b1aeab340b4d0c16c0191cd95e0ff661
                  MATRIX: 723->1|828->18|856->20|987->125|1001->131|1055->165|1138->222|1152->228|1204->260|1252->281|1267->287|1322->321|1416->388|1444->395|1476->400
                  LINES: 26->1|29->1|31->3|36->8|36->8|36->8|37->9|37->9|37->9|38->10|38->10|38->10|41->13|41->13|42->14
                  -- GENERATED --
              */
          