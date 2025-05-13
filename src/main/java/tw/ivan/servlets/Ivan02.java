package tw.ivan.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
//jakarta.servlet.ServletException：
//用於處理 Servlet 執行時可能拋出的異常。
//jakarta.servlet.annotation.WebServlet：
//提供一個註解，用於配置 Servlet 的 URL 映射等屬性。
//jakarta.servlet.http.HttpServlet：
//HTTP 協議的 Servlet 基礎類，Brad02 繼承自它以處理 HTTP 請求。
//jakarta.servlet.http.HttpServletRequest：
//表示客戶端的 HTTP 請求，包含請求的參數、頭資訊等。
//jakarta.servlet.http.HttpServletResponse：
//表示伺服器的 HTTP 回應，用於設定回應內容或狀態。
//java.io.IOException：
//處理輸入/輸出操作（如寫入回應）時可能發生的異常。

@WebServlet("/Ivan02")
//說明：這是 Servlet 的註解，指定當用戶訪問應用程式中的
///ivan02 路徑（例如 http://localhost:8080/你的應用程式/ivan02）時，
//由 ivan02 類處理請求。這個註解簡化了 Servlet 的配置，無需使用 web.xml 文件。
public class Ivan02 extends HttpServlet {
//說明：定義了一個公開類 ivan02，它繼承自 HttpServlet，
//使其成為一個能夠處理 HTTP 請求的 Servlet。HttpServlet 提供了處理 HTTP 方法
//（如 GET、POST）的基礎功能，ivan02 可以覆寫這些方法來實現自訂邏輯。
	protected void doGet(
		HttpServletRequest request,
		HttpServletResponse response)
				throws ServletException, IOException{
//說明：這是覆寫的 doGet 方法，用於處理 HTTP GET 請求。
//HttpServletRequest request：包含客戶端的請求資訊，例如查詢參數或請求路徑。
//HttpServletResponse response：用於構造伺服器回應，例如設定回應的內容或狀態碼。
//throws ServletException, IOException：表示該方法可能拋出 Servlet 相關異常或輸入/輸出異常。	
		response.getWriter().println("Hello, ivan");
//說明：這是 doGet 方法的主體，負責生成回應：
//response.getWriter()：取得一個 PrintWriter 物件，用於向客戶端寫入文字回應。
//.println("Hello, ivan")：向回應中寫入字串 "Hello, ivan"，並自動追加換行符。
//當客戶端訪問 /ivan02，會收到一個簡單的文字回應："Hello, ivan"。
	}
}
//總結
//這段程式碼定義了一個簡單的 Java Servlet，當用戶通過 GET 請求訪問 /ivan02 時，
//伺服器會回應文字 "Hello, ivan"。這是一個基礎的 Servlet 示例，
//展示如何處理 HTTP GET 請求並回傳簡單的文字內容。與之前的 ivan01 相比，
//ivan02 的回應更簡單，僅輸出固定字串，沒有使用請求的上下文路徑。
