package tw.ivan.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
//2. 匯入語句
//jakarta.servlet.ServletException：
//用於處理 Servlet 執行時可能發生的異常。
//jakarta.servlet.annotation.WebServlet：
//提供 @WebServlet 註解，用於宣告 Servlet 的配置（如 URL 映射）。
//jakarta.servlet.http.HttpServlet：
//Servlet 的基類，Ivan04 繼承自它以實現 HTTP 相關功能。
//jakarta.servlet.http.HttpServletRequest：
//表示客戶端的 HTTP 請求，包含請求的參數、頭資訊等。
//jakarta.servlet.http.HttpServletResponse：
//表示伺服器的 HTTP 回應，用於向客戶端發送資料。
//java.io.IOException：處理輸入/輸出操作（例如寫入回應）時可能發生的異常。
//java.io.PrintWriter：用於向客戶端輸出文字內容。
//java.util.Enumeration：用於迭代請求的參數或頭資訊（在本程式碼中未使用）。

@WebServlet("/Ivan04")
//3. Servlet 註解
//目的：宣告 ivan04 為一個 Servlet，並指定其 URL 映射。
//說明：@WebServlet 是一個 Jakarta Servlet 規範的註解，
//用於配置 Servlet，而無需傳統的 web.xml 文件。這裡的 "/ivan04" 
//表示當客戶端訪問應用程式上下文路徑下的 /ivan04（例如 http://localhost:8080/應用程式名稱/Brad04）時，會觸發此 Servlet 的處理邏輯。
public class Ivan04 extends HttpServlet {
//目的：定義 ivan04 類別並繼承 HttpServlet。
//說明：ivan04 是一個自訂的 Servlet 類別，透過繼承 HttpServlet
//，它具備處理 HTTP 請求（如 GET、POST）的能力。
//HttpServlet 提供了一個框架，讓開發者可以覆寫方法（如 doGet 或 doPost）來處理特定的 HTTP 請求。
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//5. doGet 方法
//目的：定義處理 HTTP GET 請求的邏輯。
//說明：
//doGet 是 HttpServlet 類別中的方法，專門處理客戶端的 GET 請求（例如透過瀏覽器輸入 URL）。
//HttpServletRequest request：包含客戶端發送的請求資訊（如參數、頭資訊）。
//HttpServletResponse response：用於構建並發送回應給客戶端。
//throws ServletException, IOException：表示此方法可能拋出 Servlet 相關異常或 I/O 異常，需由容器或呼叫者處理。	
		//response.getWriter().println("Hello,Brad");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<h1>Hello, Brad </h1>");
//6. 回應設置與內容輸出
//目的：設置回應的內容類型並向客戶端輸出 HTML 內容。
//說明：
//response.setContentType("text/html; charset=UTF-8")：
//設置回應的 MIME 類型為 text/html，表示回應內容是 HTML 格式，並指定字符編碼為 UTF-8 以支援多語言（例如中文）。
//PrintWriter out = response.getWriter()：
//取得一個 PrintWriter 物件，用於向客戶端寫入文字回應。
//out.print("<h1>Hello, Brad</h1>")：
//向客戶端輸出一個 HTML 標籤 <h1>Hello, Brad</h1>，這會在瀏覽器中顯示為一級標題「Hello, Brad」。
	}
//7.總結
//這個 Servlet 的整體功能是：
//
//當客戶端透過 GET 請求訪問 /ivan04 路徑時，伺服器會執行 ivan04 類別的 doGet 方法。
//方法設置回應為 HTML 格式，並使用 UTF-8 編碼。
//最終向客戶端輸出一個簡單的 HTML 標題 <h1>Hello, Brad</h1>，顯示在瀏覽器中。
}
