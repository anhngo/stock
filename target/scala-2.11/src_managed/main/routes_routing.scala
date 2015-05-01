// @SOURCE:/Users/anhngo/pergit/stock/conf/routes
// @HASH:7ab509a29c45c27ad3910b7b11470d72b8d7f0d3
// @DATE:Thu Apr 30 16:42:13 PDT 2015


import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset
import _root_.play.libs.F

import Router.queryString

object Routes extends Router.Routes {

import ReverseRouteContext.empty

private var _prefix = "/"

def setPrefix(prefix: String): Unit = {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:6
private[this] lazy val controllers_Application_index0_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
private[this] lazy val controllers_Application_index0_invoker = createInvoker(
controllers.Application.index(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "index", Nil,"GET", """ Home page""", Routes.prefix + """"""))
        

// @LINE:7
private[this] lazy val controllers_Application_getTicker1_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("tickers/"),DynamicPart("symbol", """[^/]+""",true))))
private[this] lazy val controllers_Application_getTicker1_invoker = createInvoker(
controllers.Application.getTicker(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "getTicker", Seq(classOf[String]),"GET", """""", Routes.prefix + """tickers/$symbol<[^/]+>"""))
        

// @LINE:8
private[this] lazy val controllers_Application_getTickersList2_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("tickers"))))
private[this] lazy val controllers_Application_getTickersList2_invoker = createInvoker(
controllers.Application.getTickersList(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "getTickersList", Nil,"GET", """""", Routes.prefix + """tickers"""))
        

// @LINE:11
private[this] lazy val controllers_Assets_at3_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
private[this] lazy val controllers_Assets_at3_invoker = createInvoker(
controllers.Assets.at(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """tickers/$symbol<[^/]+>""","""controllers.Application.getTicker(symbol:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """tickers""","""controllers.Application.getTickersList()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]]
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:6
case controllers_Application_index0_route(params) => {
   call { 
        controllers_Application_index0_invoker.call(controllers.Application.index())
   }
}
        

// @LINE:7
case controllers_Application_getTicker1_route(params) => {
   call(params.fromPath[String]("symbol", None)) { (symbol) =>
        controllers_Application_getTicker1_invoker.call(controllers.Application.getTicker(symbol))
   }
}
        

// @LINE:8
case controllers_Application_getTickersList2_route(params) => {
   call { 
        controllers_Application_getTickersList2_invoker.call(controllers.Application.getTickersList())
   }
}
        

// @LINE:11
case controllers_Assets_at3_route(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at3_invoker.call(controllers.Assets.at(path, file))
   }
}
        
}

}
     