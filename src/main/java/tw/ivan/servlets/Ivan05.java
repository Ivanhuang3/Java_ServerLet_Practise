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
//jakarta.servlet.ServletException：用於處理 serverlet 執行時可能發生的異常。
//jakarta.servlet.annotation.WebServlet：提供 @WebServlet 註解，用於配置 serverlet 的 URL 映射。
//jakarta.servlet.http.HttpServlet：serverlet 的基類，Brad05 繼承自它以實現 HTTP 請求處理。
//jakarta.servlet.http.HttpServletRequest：表示客戶端的 HTTP 請求，包含請求參數、頭資訊等。
//jakarta.servlet.http.HttpServletResponse：表示伺服器的 HTTP 回應，用於向客戶端發送資料。
//java.io.IOException：處理輸入/輸出操作（例如寫入回應）時可能發生的異常。
//java.io.PrintWriter：用於向客戶端輸出文字內容。
//java.util.Enumeration：用於迭代請求的參數或頭資訊，但在此程式碼中未使用（可能是為未來擴展保留）。

@WebServlet("/Ivan05")
//3. Servlet 註解
//目的：宣告 ivan05 為一個 Servlet，並指定其 URL 映射。
//說明：@WebServlet("/ivan05") 
//註解表示當客戶端訪問應用程式上下文路徑下的 /ivan05
//（例如 http://localhost:8080/應用程式名稱/Brad05）時，會觸發此 Servlet 的處理邏輯。這個註解取代了傳統 web.xml 配置檔案的角色，簡化 Servlet 配置。
public class Ivan05 extends HttpServlet {
//4. 類別宣告
//目的：定義 ivan05 類別並繼承 HttpServlet。
//說明：ivan05 是一個自訂的 Servlet 類別，透過繼承 HttpServlet，
//它能夠處理 HTTP 請求（如 GET 或 POST）。HttpServlet 提供了一個框架，
//允許開發者覆寫方法（如 doGet）來實現特定的請求處理邏輯。
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//5. doGet 方法
//目的：定義處理 HTTP GET 請求的邏輯。
//說明：doGet 是 HttpServlet 類別中的方法，專門處理客戶端的 GET 請求（例如透過瀏覽器輸入 URL 或點擊連結）。
//HttpServletRequest request：包含客戶端發送的請求資訊，例如查詢參數（如 x 和 y）。
//HttpServletResponse response：用於構建並發送回應給客戶端。
//throws ServletException, IOException：表示此方法可能拋出 Servlet 相關異常或 I/O 異常，需由容器或呼叫者處理。
		// ivan05?x=10&y=3
		//打在瀏覽器網址後面	
		String x = request.getParameter("x");
		String y = request.getParameter("y");
		int result = Integer.parseInt(x) + Integer.parseInt(y);
//6. 獲取並處理請求參數
//目的：從客戶端的 GET 請求中提取參數並進行計算。
//說明：
//request.getParameter("x")：從請求中提取名為 x 的參數值（例如 "10"），並存入字串變數 x。
//request.getParameter("y")：從請求中提取名為 y 的參數值（例如 "3"），並存入字串變數 y。
//Integer.parseInt(x) + Integer.parseInt(y)：
//將字串 x 和 y 轉換為整數（10 和 3），然後相加，結果存入 result（例如 10 + 3 = 13）。
		
        response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.printf("%s + %s = %d", x, y, result );
		response.flushBuffer();
//7. 設置回應並輸出結果
//目的：設置回應格式並將計算結果輸出到客戶端。
//說明：
//response.setContentType("text/html; charset=UTF-8")：
//設置回應的 MIME 類型為 text/html，表示回應內容是 HTML 格式，
//並指定字符編碼為 UTF-8 以支援多語言顯示（例如中文）。
//PrintWriter out = response.getWriter()：
//取得一個 PrintWriter 物件，用於向客戶端寫入文字回應。
//out.printf("%s + %s = %d", x, y, result)：
//使用格式化輸出，將 x、 y 和 result 的值嵌入字串，
//生成類似 "10 + 3 = 13" 的內容，並輸出到客戶端。
//這個輸出會在瀏覽器中顯示為純文字（雖然設置了 text/html，但未包含 HTML 標籤）。
//response.flushBuffer()：
//強制將回應緩衝區的內容立即發送到客戶端。通常，Servelet 容器會緩衝輸出以提高效率，
//但這裡明確要求立即發送，確保客戶端能快速看到結果。
	}
}
//總結
//這個 Servelet 的整體功能是：
//
//當客戶端透過 GET 請求訪問 /Brad05 並附帶查詢參數（例如 /Brad05?x=10&y=3）時，
//伺服器會執行 Brad05 類別的 doGet 方法。
//方法從請求中提取參數 x 和 y，將其轉換為整數並相加。
//設置回應為 HTML 格式（使用 UTF-8 編碼），並將計算結果（例如 "10 + 3 = 13"）輸出到客戶端。
//最後，立即將回應發送給客戶端。
//
//為什麼需要throws
//protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//這裡的 throws ServletException, IOException 表示 doGet 方法可能拋出以下兩種異常：
//
//ServletException：與 Servlet 執行相關的異常，例如初始化失敗或請求處理錯誤。
//IOException：與輸入/輸出操作相關的異常，例如寫入回應流失敗。
//這些異常是 檢查型異常（Checked Exceptions），Java 要求必須明確處理或聲明拋出。
//2. 為什麼需要 throws？
//(1) Java 的異常處理機制
//Java 的異常分為兩類：
//
//檢查型異常（Checked Exceptions）：繼承自 Exception（但不是 RuntimeException 的子類），
//例如 IOException 和 ServletException。編譯器要求程式碼必須處理這些異常，否則編譯會失敗。處理方式有兩種：
//使用 try-catch 塊捕獲並處理異常。
//使用 throws 將異常拋給上層呼叫者。
//非檢查型異常（Unchecked Exceptions）：繼承自 RuntimeException，
//例如 NumberFormatException。這些異常不需要強制處理，編譯器不會檢查。
//在 doGet 方法中，使用的 API（如 response.getWriter() 或 out.print）
//可能拋出 IOException，而 HttpServlet 的框架可能拋出 ServletException。
//這些都是檢查型異常，因此必須在方法簽名中使用 throws 聲明，或者在方法內部使用 try-catch 處理。
//
//(2) Servlet 框架的設計要求
//Servlet 是運行在 Servlet 容器（如 Apache Tomcat）中的組件，容器負責調用 doGet 方法。
//當 doGet 方法拋出異常時，容器需要捕獲並處理這些異常（例如，記錄日誌或返回錯誤頁面）。
//因此，Servlet 的 doGet 方法必須聲明可能拋出的異常（ServletException 和 IOException），以便容器知道如何處理。
//
//如果移除 throws ServletException, IOException，並試圖在方法內部不處理這些異常，
//程式碼將無法編譯，因為 Java 編譯器會要求明確處理檢查型異常。
//
//(3) 避免在 Servlet 中捕獲所有異常
//雖然可以在 doGet 方法內部使用 try-catch 捕獲 ServletException 和 IOException，但這通常不是最佳做法，因為：
//容器需要知道異常：Servlet 容器（如 Tomcat）通常會根據異常類型執行特定操作，例如返回 HTTP 500 錯誤頁面或記錄日誌。
//如果在 doGet 中捕獲所有異常，容器可能無法正確響應。
//程式碼簡潔性：將異常拋給容器處理，可以讓 doGet 方法專注於業務邏輯，而不是異常處理邏輯。
//因此，throws 允許 doGet 方法將異常「委託」給容器處理，保持程式碼清晰。
