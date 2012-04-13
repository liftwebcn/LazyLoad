package com.ciriscr.lazyload.snippet

import net.liftweb.util.Helpers._
import net.liftweb.http.S

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
    )
  } //render

}  //Test 
