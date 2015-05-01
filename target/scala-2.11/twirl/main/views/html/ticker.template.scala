
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
object ticker extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[beans.TickerFact,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(ticker: beans.TickerFact):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.28*/("""

"""),format.raw/*3.1*/("""<!DOCTYPE html>

<html>
<head>
    <title>Ticker</title>
    <link rel="stylesheet" media="screen" href=""""),_display_(/*8.50*/routes/*8.56*/.Assets.at("stylesheets/main.css")),format.raw/*8.90*/("""">
    <link rel="shortcut icon" type="image/png" href=""""),_display_(/*9.55*/routes/*9.61*/.Assets.at("images/favicon.png")),format.raw/*9.93*/("""">
    <script src=""""),_display_(/*10.19*/routes/*10.25*/.Assets.at("javascripts/hello.js")),format.raw/*10.59*/("""" type="text/javascript"></script>
    </head>
    <body>
        <p>
        Price: """),_display_(/*14.17*/ticker/*14.23*/.price),format.raw/*14.29*/("""</br>
        Change: """),_display_(/*15.18*/ticker/*15.24*/.change),format.raw/*15.31*/("""</br>
        Change Percent: """),_display_(/*16.26*/ticker/*16.32*/.changePrcnt),format.raw/*16.44*/("""</br>
        Market Cap: """),_display_(/*17.22*/ticker/*17.28*/.marketCap),format.raw/*17.38*/("""</br>
        </p>
    </body>
</html>
"""))}
  }

  def render(ticker:beans.TickerFact): play.twirl.api.HtmlFormat.Appendable = apply(ticker)

  def f:((beans.TickerFact) => play.twirl.api.HtmlFormat.Appendable) = (ticker) => apply(ticker)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Thu Apr 30 18:49:31 PDT 2015
                  SOURCE: /Users/anhngo/pergit/stock/app/views/ticker.scala.html
                  HASH: 89f56b91ba1d31d1583ca6acb6743d3372d36198
                  MATRIX: 734->1|848->27|876->29|1008->135|1022->141|1076->175|1159->232|1173->238|1225->270|1273->291|1288->297|1343->331|1456->417|1471->423|1498->429|1548->452|1563->458|1591->465|1649->496|1664->502|1697->514|1751->541|1766->547|1797->557
                  LINES: 26->1|29->1|31->3|36->8|36->8|36->8|37->9|37->9|37->9|38->10|38->10|38->10|42->14|42->14|42->14|43->15|43->15|43->15|44->16|44->16|44->16|45->17|45->17|45->17
                  -- GENERATED --
              */
          