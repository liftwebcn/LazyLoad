package com.ciriscr.lazyload.snippet

import net.liftweb.util.Helpers._
import net.liftweb.http.{SHtml, S}
import net.liftweb.http.js.JsCmds

class Test{

  //"Database"
  val objects = List.fill(30)("Random number: %s".format(math.random))
  val itemsPerLoad = 10
  var actual = 0

  private def nextPage: List[String] = this.objects.drop(this.actual).take(this.itemsPerLoad)

  def render = {
    "#elementsTable *" #> (S.eagerEval andThen
      "@element *" #> nextPage.map{ elem =>
        "@number *" #> elem
      }
    ) & "button [onclick]" #> SHtml.ajaxInvoke{ () =>
      this.actual += this.itemsPerLoad
      //Add the new elements to the page
      //HELP HERE :D
      JsCmds.Alert("See the code")
    }
  } //render

}  //Test 
