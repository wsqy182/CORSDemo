package CorsDemo;

import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

public class Servlet extends HttpServlet {
  private String requestId;

  public String getRequestId() {
    return requestId;
  }

  public void setRequestId(String requestId) {
    this.requestId = requestId;
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
    handleRequest(request, response);
  }

  private void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
    this.requestId = UUID.randomUUID().toString();
    System.out.println("request handle!" + this.requestId);
    response.getWriter().append(JSON.toJSONString(this));
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
    handleRequest(request, response);
  }
}
