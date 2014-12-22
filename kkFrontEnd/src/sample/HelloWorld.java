package sample;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.FacebookClient.AccessToken;
import com.restfb.Parameter;
import com.restfb.types.FacebookType;
import com.restfb.types.User;

/**
 * Servlet implementation class HelloWorld
 */
@WebServlet("/HelloWorld")
public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloWorld() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String appId = "827325393990771";
		String appSecret = "778f4616087b7ae8954b17d003cc8fc9";
		//access_token=CAALwcrQ49HMBALrDRdOu0TzgHXmfjzKH7Ogi7CuFOgvLQSuV3G0biRAMtqWZAWd6R8iX1whq6lYXqiZAVzXsb822CdQamAQErNTeZCZCdiU5srFgnjP2s0OLEPtZB3uhGnAJBf1XSrl4CqUB38VfW0D4WbVPCRmNFmiZA5ZAGWrzRjwQZCXwC07ZAMaWZBthbPmQBVZBwfMlHuGXPBxZBGeXRMOB&expires=5184000
		//access_token=CAALwcrQ49HMBAH9V3cwZCkFEjPODBVTc22RAqluN4q0qwQouqcoZAZCDPMO5nBAW28xuEd2eRF4f64z8JZBGCMm39qIulkrF3UwM2EjlJZAT0v8VTgmuOxuN5UU1RxNZAbJka8JVa63Bm0Cz4PonOJuNauEgBDeqWZABYZAuJ4yGZAxG3IpNQz1oSgELBsWxMonZCwdoGPfMHb7nCL2QOmtYwZA&expires=5183692
		FacebookClient facebookClient = new DefaultFacebookClient("CAALwcrQ49HMBAH9V3cwZCkFEjPODBVTc22RAqluN4q0qwQouqcoZAZCDPMO5nBAW28xuEd2eRF4f64z8JZBGCMm39qIulkrF3UwM2EjlJZAT0v8VTgmuOxuN5UU1RxNZAbJka8JVa63Bm0Cz4PonOJuNauEgBDeqWZABYZAuJ4yGZAxG3IpNQz1oSgELBsWxMonZCwdoGPfMHb7nCL2QOmtYwZA");
		//FacebookClient facebookClient = new MyFacebookClient(appId, appSecret);
		
		// access token 
		AccessToken accessToken = new DefaultFacebookClient().obtainAppAccessToken(appId,appSecret);
		String token=accessToken.getAccessToken();
		
		
		User user = facebookClient.fetchObject("me", User.class);
		
		System.out.println(user.getName());
		//https://graph.facebook.com/oauth/access_token?client_id=827325393990771&client_secret=778f4616087b7ae8954b17d003cc8fc9&grant_type=fb_exchange_token&fb_exchange_token=CAALwcrQ49HMBABxztswCW1UNqdNrIOvx4NSlEep4HspyZCGZA5TjUBtGxktGuOBFR5AUsOzg1zC62f3jhFJLbhswWGiEkyMZBar05lfZBGECzQRBDaghSH0hyaBmXrsMRFaRmZBlo89R1iKqRLtiGdT1slVbcI5nnwFApnNkWzkKLhwktjFYF5LIFjnnZBlMrZCzUTS1pLrhDVY5TR4UZC28yZBmE6XYGPZBwZD
		FacebookType publishMessageResponse =
				  facebookClient.publish("me/feed", FacebookType.class,
				    Parameter.with("message", "Is this a post ??"));
		System.out.println("Published message ID: " + publishMessageResponse.getId());
		
		response.getWriter().write("Hello World");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
