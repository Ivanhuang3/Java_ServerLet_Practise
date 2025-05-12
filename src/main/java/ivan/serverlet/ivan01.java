package ivan.serverlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
//jakarta.servlet.ServletException：用於處理 Servlet 執行時可能拋出的異常。
//jakarta.servlet.annotation.WebServlet：用於標記 Servlet 的註解，定義其 URL 映射等屬性。
//jakarta.servlet.http.HttpServlet：提供 HTTP 協議相關的 Servlet 基礎類，Brad01 繼承自它。
//jakarta.servlet.http.HttpServletRequest：表示客戶端的 HTTP 請求，包含請求的參數、頭資訊等。
//jakarta.servlet.http.HttpServletResponse：表示伺服器的 HTTP 回應，用於設定回應內容和狀態。
//java.io.IOException：處理輸入/輸出操作（如寫入回應）時可能發生的異常。

@WebServlet("/ivan01")
//說明：這是一個 Servlet 註解，用來配置 Servlet 的 URL 映射。
//這表示當用戶訪問應用程式中的 /ivan01 路徑時
//（例如 http://localhost:8080/你的應用程式/ivan01），會由 ivan01 類處理請求。這個註解取代了傳統的 web.xml 配置文件。
public class ivan01 extends HttpServlet {
//說明：定義了一個名為 ivan01 的公開類，
//該類繼承自 HttpServlet，使其成為一個能夠處理 HTTP 請求的 Servlet。
//HttpServlet 提供了處理 HTTP 請求（如 GET、POST）的方法，ivan01 可以覆寫這些方法來實現自訂邏輯。
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//說明：這是 ivan01 類中覆寫的 doGet 方法，用於處理 HTTP GET 請求。
//HttpServletRequest request：包含客戶端的請求資訊，例如查詢參數、URL 路徑等。
//HttpServletResponse response：用於構造伺服器回應，例如設定回應內容或狀態碼。
//throws ServletException, IOException：表示該方法可能拋出 Servlet 相關異常或輸入/輸出異常。
		response.getWriter().append("AAAServed at: ").append(request.getContextPath());
	}
}
//說明：這行程式碼是 doGet 方法的主體，負責生成回應：
//response.getWriter()：取得一個 PrintWriter 物件，用於向客戶端寫入文字回應。
//.append("AAAServed at: ")：向回應中追加字串 "AAAServed at: "。
//.append(request.getContextPath())：追加當前應用程式的上下文路徑（context path）。
//上下文路徑是應用程式在伺服器上的根路徑，例如 /myapp。
//最終，客戶端會收到一個文字回應，格式類似 "AAAServed at: /你的應用程式路徑"。
//
//這段程式碼定義了一個簡單的 Java Servlet，當用戶通過 GET 請求訪問 /ivan01 時，
//伺服器會回應一段文字，包含固定字串 "AAAServed at: " 以及應用程式的上下文路徑。
//這是一個基本的 Servlet 示例，通常用於測試或展示 Servlet 的功能。