package tw.ivan.servlets;
//動態code後端程式設計
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
//1. 套件與導入
//功能與意圖：
//package tw.brad.servlets;：定義程式所在的套件，組織程式碼結構，通常反映應用程式模組或開發者的命名空間
//（例如 tw.brad 可能表示台灣的 Brad 開發者）。
//導入的類別：
//jakarta.servlet.*：
//Jakarta EE 提供的 Servlet API，用於處理 Web 請求和響應。
//ServletException：處理 Servlet 執行期間的異常。
//HttpServlet：基類，提供處理 HTTP 請求的框架。
//HttpServletRequest：封裝客戶端請求的數據（例如查詢參數）。
//HttpServletResponse：用於構造回傳給客戶端的響應。
//annotation.WebServlet：
//用於註解 Servlet 的 URL 映射，取代傳統的 web.xml 配置。
//java.io.*：
//IOException：處理 I/O 操作（例如寫入響應）時的異常。
//PrintWriter：用於向客戶端輸出字串（例如 HTML 內容）。
//java.util.Enumeration：用於迭代請求參數或標頭，
//但在此程式中未使用，可能是程式設計者的疏忽或為了未來擴展保留。


@WebServlet("/Ivan06")
//2. Servlet 註解與類別定義
//@WebServlet("/Ivan06")：這是一個 Jakarta EE 註解，
//指定當用戶訪問 URL 路徑 /Ivan06 時
//（例如 http://localhost:8080/<context>/Ivan06），容器（如 Tomcat）會調用此 Servlet。
public class Ivan06 extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//3. 處理 GET 請求		
//功能與意圖：doGet 是 HttpServlet 提供的 protected 方法，用於處理 HTTP GET 請求。
//GET 請求通常用於查詢或獲取資源，適合此程式的用途（用戶提交參數以獲取計算結果）。
//參數：HttpServletRequest request：包含客戶端的請求數據，例如 URL 查詢參數（x、y、op）。
//HttpServletResponse response：用於構造回傳給客戶端的響應（例如 HTML 頁面）。
//異常：ServletException：處理 Servlet 執行中的錯誤（例如初始化問題）。IOException：處理 I/O 操作的錯誤（例如無法寫入響應）。
//設計意圖：專注於 GET 請求，符合簡單 Web 計算器的使用場景（通過 URL 或表單提交數據）。		
		//Ivan06?x=10&y=3
		String x, y, op, result;
		x = y =op = result = "";
		try {
			x = request.getParameter("x");
			y = request.getParameter("y");
			op = request.getParameter("op");
//4. 宣告變數與獲取參數，功能與意圖：
//變數宣告：
//x：第一個運算數（字串形式，從查詢參數獲取）。
//y：第二個運算數（字串形式）。
//op：運算符號（字串，表示 1=加、2=減、3=乘、4=除）。
//result：計算結果（字串形式，用於顯示）。
//初始化：將所有變數初始化為空字串 ("")，避免後續操作時因 null 值引發 NullPointerException。
//			
//x = request.getParameter("x"); 的作用
//是從 HTTP 請求（通常是 URL 查詢字串或表單提交）中提取名為 x 的參數值，
//並將其儲存在字串變數 x 中。
//			
//try 塊：將參數獲取和後續計算包在 try 塊中，捕獲可能的異常（例如參數缺失或無效輸入）。
//設計意圖：通過簡單的參數提取，支援動態輸入。
//初始化變數確保程式穩健性，特別是在首次訪問（無參數）或輸入無效時。
			int intX = Integer.parseInt(x);
			int intY = Integer.parseInt(y);
			switch(op) {
			case "1" : result = intX + intY + ""; break;
			case "2" : result = intX - intY + ""; break;
			case "3" : result = intX * intY + ""; break;
			case "4" :
				result = (intX / intY) + "..." + (intX & intY);
				break;
			}
//5. 計算邏輯-功能與意圖：
//轉換為整數：Integer.parseInt(x)：將字串 x 轉為整數 intX。
//同樣將 y 轉為 intY。
//如果 x 或 y 不是有效整數（例如空字串、非數字），會拋出 NumberFormatException，由外層 try 捕獲。
//運算邏輯：使用 switch 根據 op 的值執行不同運算：
//case "1"：加法 (intX + intY)，結果轉為字串（通過 + ""）。
//case "2"：減法 (intX - intY)。
//case "3"：乘法 (intX * intY)。
//case "4"：除法 (intX / intY)，計算商並附加餘數 (intX % intY)，格式為 商 ... 餘數。
//每個 case 結束時使用 break 跳出 switch。
//結果儲存：計算結果存入 result，為字串形式，方便後續顯示在 HTML 中。
		}catch(Exception e) {
			x = y = op = "";
		}
//6. 異常處理
//獲 try 塊中的所有異常（Exception 是最廣泛的異常類型）。
//異常可能包括：
//NumberFormatException：當 x 或 y 無法轉為整數時（例如空字串、非數字）。
//其他未預期的異常（例如 NullPointerException，雖然程式已通過初始化避免）。
//處理方式：將 x、y 和 op 重設為空字串，result 已初始化為空，因此不會顯示錯誤結果。
		//----------------------------------------
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.printf("<meta charset='UTF-8' />\n")
		.printf("<form action='Brad06'>\n")
		.printf("<input name='x' value='%s' />\n", x)
		.printf("<select name='op'>\n")
		.printf("<option value='1' %s>+</option>\n", 
						op.equals("1")?"selected":"")
		.printf("<option value='2' %s>-</option>\n", 
						op.equals("2")?"selected":"")
		.printf("<option value='3' %s>x</option>\n", 
						op.equals("3")?"selected":"")
		.printf("<option value='4' %s>/</option>\n", 
						op.equals("4")?"selected":"")
		.printf("</select>\n")
		.printf("<input name='y' value='%s' />\n", y)
		.printf("<input type='submit' value='=' />\n")
		.printf("%s", result)
		.printf("</form>\n");
//7. 設置響應與生成 HTML
//功能與意圖：
//設置響應：
//response.setContentType("text/html; charset=UTF-8")：
//定響應內容類型為 HTML，並使用 UTF-8 編碼，確保中文字符（例如運算符號 ×）正確顯示。
//PrintWriter out = response.getWriter()：獲取用於向客戶端寫入響應的物件，支援字串輸出。
//生成 HTML 表單：
//使用 out.printf 動態生成 HTML，通過格式化字串插入變數值。
//HTML 結構：
//<meta charset='UTF-8' />：
//確保瀏覽器以 UTF-8 解碼頁面，避免亂碼。
//<form action='Brad06'>：
//創建表單，提交到 /Brad06，使用 GET 方法（因為未指定 method，默認為 GET）。
//<input name='x' value='%s' />：輸入框，顯示 x 的值（從查詢參數或重設後的空字串）。
//<select name='op'>：下拉選單，包含四個運算選項：
//<option value='1' %s>+</option>：加法選項，value='1' 表示提交時傳遞 op=1。
//使用三元運算符 op.equals("1")?"selected":"" 檢查 op 是否為 1，若是則添加 selected 屬性，使該選項預選。
//減法、乘法、除法選項類似，分別對應 op=2、op=3、op=4。
//<input name='y' value='%s' />：第二個輸入框，顯示 y 的值。
//<input type='submit' value='=' />：提交按鈕，標籤為 =，點擊後觸發表單提交。
//%s：直接輸出 result（計算結果或空字串）。
//</form>：關閉表單。
//設計意圖：
//提供簡單的 Web 界面，允許用戶輸入兩個數字和運算符號，提交後顯示結果。
//保留上次輸入（x、y）和選中的運算符號（op），提升用戶體驗。
//使用純 HTML 輸出，無需額外的 JSP 或前端框架，適合教學或輕量應用。
	}
}