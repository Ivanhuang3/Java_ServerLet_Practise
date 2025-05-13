package tw.ivan.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
//說明：這些是導入（import）語句，引入程式碼中需要的外部類和接口：
//jakarta.servlet.ServletException：處理 Servlet 執行時可能拋出的異常。
//jakarta.servlet.annotation.WebServlet：提供註解，用於配置 Servlet 的 URL 映射。
//jakarta.servlet.http.HttpServlet：HTTP 協議的 Servlet 基礎類，Brad03 繼承自它以處理 HTTP 請求。
//jakarta.servlet.http.HttpServletRequest：表示客戶端的 HTTP 請求，包含請求參數、頭資訊等。
//jakarta.servlet.http.HttpServletResponse：表示伺服器的 HTTP 回應，用於設定回應內容或狀態。
//java.io.IOException：處理輸入/輸出操作時可能發生的異常。
//java.util.Enumeration：用於迭代一組物件（在這裡是用來迭代 HTTP 請求的頭資訊名稱）。

@WebServlet("/Ivan03")
public class Ivan03 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//說明：這是覆寫的 doGet 方法，用於處理 HTTP GET 請求。
//HttpServletRequest request：包含客戶端的請求資訊，例如頭資訊、參數或路徑。
//HttpServletResponse response：用於構造伺服器回應，例如設定回應內容或狀態碼。
//throws ServletException, IOException：表示該方法可能拋出 Servlet 相關異常或輸入/輸出異常。		
		Enumeration<String> names = request.getHeaderNames();
//說明：這行從 request 物件中獲取所有 HTTP 請求頭的名稱，
//並將其儲存在一個 Enumeration<String> 物件 names 中。
//HTTP 請求頭包含客戶端發送的元資料，例如 User-Agent、Host、Accept 等。
		while (names.hasMoreElements()) {
			String name = names.nextElement();
			String value = request.getHeader(name);
			System.out.printf("%s : %s\n", name, value);
//說明：這段程式碼遍歷所有的請求頭並將它們的名稱和值輸出到伺服器的控制台：
//while (names.hasMoreElements())：檢查 names 是否還有未處理的頭名稱。
//String name = names.nextElement()：獲取下一個頭名稱。
//String value = request.getHeader(name)：根據頭名稱從 request 中獲取對應的頭值。
//System.out.printf("%s : %s\n", name, value)：
//將頭名稱和值以格式化字串輸出到伺服器控制台，格式為 名稱 : 值，每行一個頭資訊，並換行。
		}
	}
}
//這段程式碼定義了一個 Java Servlet，當用戶通過 GET 請求訪問 /Brad03 時，
//Servlet 會從 HTTP 請求中提取所有頭資訊（header），
//並將它們的名稱和值打印到伺服器的控制台（而非回應給客戶端）。
//這是一個用於調試或檢查請求頭的 Servlet，適合用來了解客戶端發送的元資料。
//與之前的 Brad01 和 Brad02 不同，Brad03 不直接回應客戶端，而是將資訊輸出到伺服器端控制台。
