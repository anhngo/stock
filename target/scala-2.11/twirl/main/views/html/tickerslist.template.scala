
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
object tickerslist extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[java.util.List[beans.TickerDim],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(tickers: java.util.List[beans.TickerDim]):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.44*/("""

"""),format.raw/*3.1*/("""<!DOCTYPE html>

<html>
<head>
    <title>Tickers List</title>
    <link rel="stylesheet" media="screen" href=""""),_display_(/*8.50*/routes/*8.56*/.Assets.at("stylesheets/main.css")),format.raw/*8.90*/("""">
    <link rel="shortcut icon" type="image/png" href=""""),_display_(/*9.55*/routes/*9.61*/.Assets.at("images/favicon.png")),format.raw/*9.93*/("""">
    <script src=""""),_display_(/*10.19*/routes/*10.25*/.Assets.at("javascripts/hello.js")),format.raw/*10.59*/("""" type="text/javascript"></script>
    </head>
    <body>
        """),_display_(/*13.10*/for(ticker <- tickers) yield /*13.32*/ {_display_(Seq[Any](format.raw/*13.34*/("""
            """),format.raw/*14.13*/("""<p>
            Symbol: """),_display_(/*15.22*/ticker/*15.28*/.symbol),format.raw/*15.35*/("""</br>
            Name: """),_display_(/*16.20*/ticker/*16.26*/.name),format.raw/*16.31*/("""</br>
            Market Cap Type: """),_display_(/*17.31*/ticker/*17.37*/.marketCapType.name()),format.raw/*17.58*/("""</br>
            IPO Year: """),_display_(/*18.24*/ticker/*18.30*/.ipoYear),format.raw/*18.38*/("""</br>
            Sector: """),_display_(/*19.22*/ticker/*19.28*/.sector),format.raw/*19.35*/("""</br>
            Industry : """),_display_(/*20.25*/ticker/*20.31*/.industry),format.raw/*20.40*/("""
            """),format.raw/*21.13*/("""</p>
        """)))}),format.raw/*22.10*/("""
    """),format.raw/*23.5*/("""</body>
</html>
"""))}
  }

  def render(tickers:java.util.List[beans.TickerDim]): play.twirl.api.HtmlFormat.Appendable = apply(tickers)

  def f:((java.util.List[beans.TickerDim]) => play.twirl.api.HtmlFormat.Appendable) = (tickers) => apply(tickers)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Thu Apr 30 18:49:31 PDT 2015
                  SOURCE: /Users/anhngo/pergit/stock/app/views/tickerslist.scala.html
                  HASH: e28f2d0a23985f5bef2cf3742e4de53bd0d8c0c1
                  MATRIX: 754->1|884->43|912->45|1050->157|1064->163|1118->197|1201->254|1215->260|1267->292|1315->313|1330->319|1385->353|1479->420|1517->442|1557->444|1598->457|1650->482|1665->488|1693->495|1745->520|1760->526|1786->531|1849->567|1864->573|1906->594|1962->623|1977->629|2006->637|2060->664|2075->670|2103->677|2160->707|2175->713|2205->722|2246->735|2291->749|2323->754
                  LINES: 26->1|29->1|31->3|36->8|36->8|36->8|37->9|37->9|37->9|38->10|38->10|38->10|41->13|41->13|41->13|42->14|43->15|43->15|43->15|44->16|44->16|44->16|45->17|45->17|45->17|46->18|46->18|46->18|47->19|47->19|47->19|48->20|48->20|48->20|49->21|50->22|51->23
                  -- GENERATED --
              */
          