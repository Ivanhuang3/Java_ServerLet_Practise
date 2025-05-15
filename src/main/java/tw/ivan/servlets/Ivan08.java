package tw.ivan.servlets;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
//1. 包和導入語句
//package tw.brad.servlets;：定
//義這個類別所在的包（package），用於組織程式碼，這裡是 tw.brad.servlets 包。
//import 語句：導入所需的類和接口，這些是 Jakarta Servlet API 和 Java I/O 相關的類，
//提供了 Servlet 開發所需的功能，例如：
//ServletConfig：用於獲取 Servlet 的配置資訊。
//ServletException：處理 Servlet 相關的異常。
//WebServlet：用於注解 Servlet，定義其 URL 映射。
//HttpServlet：這是 Servlet 的基類，提供了處理 HTTP 請求的方法。
//HttpServletRequest 和 HttpServletResponse：分別表示 HTTP 請求和響應物件。
//IOException：處理輸入/輸出異常。
@WebServlet("/Ivan08")
public class Ivan08 extends HttpServlet{
//@WebServlet("/Ivan08")：這是一個注解，標記這個類是一個 Servlet，
//並指定它的 URL 映射路徑為 /Ivan08。
//當客戶端訪問應用程式中的 /Ivan08 路徑時，這個 Servlet 會被觸發。
//public class Brad08 extends HttpServlet：定義了一個名為 Ivan08 的類，
//繼承自 HttpServlet，使其具備處理 HTTP 請求的能力。
	private int i;
	public Ivan08() {
		System.out.println("Ivan08()");
	}
//3. 成員變數和建構子
//解釋：
//private int i;：定義一個私有整數變數 i，用於計數或追蹤某種狀態（
//在這段程式碼中，後面用於記錄 doGet 請求次數）。
//public Ivan08()：這是 Ivan08 類的建構子，當 Servlet 實例被創建時會被呼叫。
//程式碼中輸出 "Ivan08()" 到控制台，用於調試，確認建構子被執行。
	@Override
	public void init() throws ServletException {
		System.out.println("init()");
		super.init();
	
	}
//4. init() 方法（無參數）
//init() 是 Servlet 生命週期中的初始化方法，
//當 Servlet 實例創建後，Servlet 容器會呼叫這個方法進行初始化。
//@Override 表示這是覆寫父類（GenericServlet）的方法。
//System.out.println("init()");：輸出 "init()" 到控制台，確認該方法被執行。
//super.init();：呼叫父類的 init 方法，確保父類的初始化邏輯被執行。
//throws ServletException：表示該方法可能拋出 Servlet 相關的異常。
//
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init(config)");
		super.init(config);
	}
//5. init(ServletConfig config) 方法
//這是另一個 init 方法，接受一個 ServletConfig 參數，
//用於接收 Servlet 的配置資訊（例如 web.xml 或注解中的參數）。
//System.out.println("init(config)");：
//輸出 "init(config)" 到控制台，確認該方法被執行。
//super.init(config);：呼叫父類的 init(ServletConfig) 方法，
//將配置資訊傳遞給父類，確保父類完成必要的初始化。
//這兩個 init 方法的區別在於，帶 ServletConfig 的版本是更底層的方法，
//無參數的 init 是為了讓開發者覆寫時更方便（無需處理 ServletConfig）。
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service(brad):" + request.getMethod());
		super.service(request, response);
	}
//6. service 方法:
//service 方法是 Servlet 生命週期中處理客戶端請求的核心方法，
//負責接收 HTTP 請求並分發到適當的處理方法（例如 doGet 或 doPost）。
//request.getMethod()：獲取 HTTP 請求的方法（例如 GET、POST 等）。
//System.out.println("service(brad):" + request.getMethod());：
//輸出 "service(brad):" 加上請求方法到控制台，用於調試，確認請求類型。
//super.service(request, response);：
//呼叫父類（HttpServlet）的 service 方法，父類會根據請求方法分發到對應的 doGet 或 doPost 方法。
//throws ServletException, IOException：表示該方法可能拋出 Servlet 或 I/O 相關的異常。

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet:" + i++);
	}
//7. doGet 方法
//doGet 方法專門處理 HTTP GET 請求。
//System.out.println("doGet:" + i++);：
//輸出 "doGet:" 加上當前 i 的值到控制台，然後將 i 自增 1。這裡用 i 來記錄 doGet 方法被呼叫的次數。
//這個方法目前僅用於調試，實際應用中通常會在這裡處理 GET 請求的邏輯，例如返回 HTML 頁面或 JSON 數據。
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
//8. doPost 方法
//解釋：
//doPost 方法專門處理 HTTP POST 請求。
//System.out.println("doPost");：輸出 "doPost" 到控制台，確認該方法被執行。
//目前這個方法只有簡單的調試輸出，實際應用中會處理 POST 請求的數據，例如表單提交。
//		
//總結與程式碼整體說明
//這段程式碼是一個簡單的 Java Servlet，名為Ivan08，用於處理 HTTP 請求。它的主要功能包括：
//生命週期管理：通過建構子、init 方法和 service 方法，
//展示了 Servlet 的初始化和請求處理過程，並通過控制台輸出來追蹤這些方法的執行。
//請求處理：實現了 doGet 和 doPost 方法，分別處理 GET 和 POST 請求，同時使用變數 i 記錄 doGet 的呼叫次數。
//調試用途：程式碼中大量使用 System.out.println 來輸出訊息，主要是為了調試和確認 Servlet 的生命週期及請求處理流程。
//
//運行時的行為：
//當 Servlet 容器（例如 Tomcat）啟動並載入Ivan08 時：
//執行建構子，輸出 "Ivan08()"。
//執行 init(ServletConfig config)，輸出 "init(config)"。
//執行無參數的 init()，輸出 "init()"。
//當客戶端發送請求到 /Ivan08：
//service 方法被呼叫，輸出 "service(brad):<請求方法>"。
//根據請求方法，分發到 doGet（輸出 "doGet:<i值>" 並遞增 i）
//或 doPost（輸出 "doPost"）。
//
//大白話總結
//這程式就像一個餐廳服務生 Ivan08，負責處理網頁的點單（GET 或 POST 請求）。它的工作流程是：
//出生：伺服器啟動時，程式被創建（喊「Ivan08()」）。
//準備：做兩次熱身（喊「init(config)」和「init()」）。
//接待：有人來點單時，檢查是啥單（喊「service(brad):GET」或「service(brad):POST」）。
//處理：如果是「看東西」（GET），
//喊「doGet:<次數>」並記錄次數；如果是「送資料」（POST），喊「doPost」。
//現在這程式只是個「喊話機器」，一直在控制台喊它在幹嘛，但
//沒真的給客人東西（像網頁或資料）。它就像個新手服務生，只會說「收到！收到！」但還沒學會怎麼端菜。
	}

}
