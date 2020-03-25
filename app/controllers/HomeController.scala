package controllers

import java.security.SecureRandom

import akka.http.scaladsl.model.StatusCodes
import javax.inject.Inject
import play.api.libs.ws.{DefaultWSProxyServer, WSAuthScheme, WSClient, WSRequest, WSResponse}
import play.api.mvc._
import play.twirl.api.Html

import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success}


/**
 * A controller full of vulnerabilities.
 */
class HomeController @Inject()(wsClient: WSClient, cc: MessagesControllerComponents)(implicit ec: ExecutionContext) extends MessagesAbstractController(cc) {


  def index = Action { implicit request  =>
     Ok(Html(s"""
       <html>
         <body>
           <ul>
             <li><a href="${routes.HomeController.predictableRandom()}">Predictable Random</a></li>
           </ul>
         </body>
       </html>
     """))
  }

  /**
   * Usage of predictable random (pattern: PREDICTABLE_RANDOM_SCALA)
   */
  def predictableRandom = Action { implicit request  =>
    val random = new util.Random(new SecureRandom())

    // [RuleTest] Cross-Site Scripting: Reflected
    val html = Html(s"hey! you're predictable $random times")

    Ok(html) as HTML
  }

}
