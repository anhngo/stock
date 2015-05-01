// @SOURCE:/Users/anhngo/pergit/stock/conf/routes
// @HASH:7ab509a29c45c27ad3910b7b11470d72b8d7f0d3
// @DATE:Thu Apr 30 16:42:13 PDT 2015

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset
import _root_.play.libs.F

import Router.queryString


// @LINE:11
// @LINE:8
// @LINE:7
// @LINE:6
package controllers {

// @LINE:11
class ReverseAssets {


// @LINE:11
def at(file:String): Call = {
   implicit val _rrc = new ReverseRouteContext(Map(("path", "/public")))
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                        

}
                          

// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {


// @LINE:8
def getTickersList(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "tickers")
}
                        

// @LINE:7
def getTicker(symbol:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "tickers/" + implicitly[PathBindable[String]].unbind("symbol", dynamicString(symbol)))
}
                        

// @LINE:6
def index(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix)
}
                        

}
                          
}
                  


// @LINE:11
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.javascript {
import ReverseRouteContext.empty

// @LINE:11
class ReverseAssets {


// @LINE:11
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        

}
              

// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {


// @LINE:8
def getTickersList : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.getTickersList",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "tickers"})
      }
   """
)
                        

// @LINE:7
def getTicker : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.getTicker",
   """
      function(symbol) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "tickers/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("symbol", encodeURIComponent(symbol))})
      }
   """
)
                        

// @LINE:6
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        

}
              
}
        


// @LINE:11
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.ref {


// @LINE:11
class ReverseAssets {


// @LINE:11
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      

}
                          

// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {


// @LINE:8
def getTickersList(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.getTickersList(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "getTickersList", Seq(), "GET", """""", _prefix + """tickers""")
)
                      

// @LINE:7
def getTicker(symbol:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.getTicker(symbol), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "getTicker", Seq(classOf[String]), "GET", """""", _prefix + """tickers/$symbol<[^/]+>""")
)
                      

// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      

}
                          
}
        
    