package tw.ivan.servlets;

import jakarta.servlet.ServletException;
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
//package tw.brad.servlets;：定義程式所在的套件，
//組織程式碼結構，通常反映開發者的命名空間（例如 tw.brad 可能表示台灣的 Brad 開發者）。
//導入的類別：
//jakarta.servlet.*：Jakarta EE 的 Servlet API，用於處理 Web 請求和響應。
//ServletException：處理 Servlet 執行期間的異常（例如初始化錯誤）。
//HttpServlet：基類，提供處理 HTTP 請求的方法（如 doGet 和 doPost）。
//HttpServletRequest：封裝客戶端請求的數據（例如表單參數）。
//HttpServletResponse：用於構造回傳給客戶端的響應。
//annotation.WebServlet：用於註解 Servlet 的 URL 映射，取代 web.xml 配置。
//java.io.*：
//IOException：處理 I/O 操作（例如寫入響應）的異常。
//PrintWriter：用於向客戶端輸出字串（例如 HTML），但在此程式中未使用。
//java.util.Enumeration：用於迭代請求參數或標頭，但在此程式中未使用，可能是疏忽或為未來擴展保留。
@WebServlet("/Ivan07")
public class Ivan07 extends HttpServlet {
//2. Servlet 註解與類別定義
//功能與意圖：
//@WebServlet("/Ivan07")：註解指定此 Servlet 映射到 URL 路徑 /Ivan07。
//當用戶訪問 http://<server>/<context>/Brad07 時，伺服器容器（如 Tomcat）會調用此 Servlet。
//這是現代 Servlet 配置方式，簡化了傳統 web.xml 的設定。
//Ivan07 是相對路徑，基於應用程式的上下文路徑。
//public class Brad07 extends HttpServlet：定義 Ivan07 類別，
//繼承 HttpServlet，使其成為一個 HTTP Servlet，能處理 GET 和 POST 請求。
//HttpServlet 提供 doGet、doPost 等方法，供子類別覆寫以實現特定功能。
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
//3. 處理 GET 請求
//功能與意圖：
//doGet 方法處理 HTTP GET 請求，當用戶通過 GET 方法訪問 /Ivan07（例如直接輸入 URL 或提交 GET 表單）時執行。
//這段程式碼直接調用 doPost(request, response)，將 GET 請求的處理委託給 doPost 方法。
//這表示 GET 和 POST 請求將執行相同的邏輯，無需為 GET 單獨實現處理。
//設計意圖：
//統一 GET 和 POST 的處理邏輯，簡化程式碼。
//適用於表單處理場景，因為表單可能以 GET 或 POST 提交（例如，HTML 表單的 method 屬性）。	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String account = request.getParameter("account");
		String passwd  = request.getParameter("passwd");
		String gender  = request.getParameter("gender");
		String[] habits = request.getParameterValues("habits");
//4. 處理 POST 請求與參數提取
//@Override：
//這就像是在跟 Java 說：「嘿，我要改進一個原本就有的功能！」這裡是改進 HttpServlet 裡的 doPost 方法，專門處理表單用 POST 方式送來的資料。
//簡單說，這是一個標記，告訴系統這段程式是要「重新定義」怎麼處理 POST 請求。
//
//protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException：
//這行定義了一個名為 doPost 的功能，專門處理網頁表單用 POST 方式提交的資料。
//request：就像一個包裹，裡面裝了用戶在表單填的東西（比如帳號、密碼）。
//response：是你要回給用戶的東西（比如顯示「註冊成功」頁面），不過這段程式碼還沒用到它。
//throws ServletException, IOException：這是說如果程式出錯（比如網路問題或伺服器壞掉），它會把錯誤丟出去，讓其他地方處理。
//
//String account = request.getParameter("account");：
//這行是在從「包裹」（request）裡拿出用戶填的「帳號」。
//request.getParameter("account") 就像是說：「幫我找表單裡名叫 'account' 的欄位，告訴我用戶填了什麼。」
//比如用戶在表單輸入「user123」，這行執行後，account 就會變成 "user123"。
//如果表單沒這個欄位，account 會是 null（空）。
//
//String passwd = request.getParameter("passwd");：
//跟上面差不多，這是在拿「密碼」。
//如果表單有個欄位叫 passwd，用戶填了「abc123」，那 passwd 就會變成 "abc123"。
//同樣的，如果沒填或沒這個欄位，會得到 null。
//
//String gender = request.getParameter("gender");：
//這是拿「性別」的資料。
//通常性別是單選框（比如「男」或「女」），表單會送像 "m"（男）或 "f"（女）這樣的值過來。
//比如用戶選了「男」，gender 就會是 "m"。
//
//String[] habits = request.getParameterValues("habits");：
//這行有點特別，因為它在拿「興趣」，而且興趣可能是多選的（比如複選框，允許選好幾個）。
//request.getParameterValues("habits") 是在說：
//「幫我把所有名叫 'habits' 的欄位值都拿出來，給我一個清單。」
//比如用戶勾選了「打電腦」和「打籃球」，
//表單可能送 habits=1 和 habits=2 過來，這行會把 habits 設成一個陣列：["1", "2"]。
//如果沒選任何興趣，habits 會是 null。
		System.out.printf("%s", gender);
//		System.out.printf("%s", gender);：
//		這行是在伺服器的控制台（日誌視窗）印出用戶選的「性別」。
//		System.out.printf 是一個印東西的指令，%s 是說「我要印一個字串」，gender 是那個字串的內容。
//		比如，表單送來的 gender 是 "m"（代表男），這行執行後，控制台就會顯示：m
		try {
			for(String habit:habits){
				System.out.println(habit);
			}	
//try {：
//這是開始一個「小心操作」的區塊，說：「我要試著做下面的事，但如果出錯，別讓程式崩潰。」
//為什麼要小心？因為接下來要處理 habits（興趣），而 habits 可能有問題（比如是空的），所以用 try 把風險包起來。
//for(String habit : habits) {：
//這是一個迴圈，用來把用戶選的「興趣」一個一個拿出來。
//habits 是一個字串陣列（String[]），裡面裝了用戶在表單勾選的興趣值（比如 ["1", "2"]，代表「打電腦」和「打籃球」）。
//for(String habit : habits) 的意思是：「從 habits 陣列裡，每次拿一個值出來，放到 habit 變數，然後處理它。」
//比如，如果 habits 是 ["1", "2"]，這迴圈會跑兩次：
//第一次，habit 是 "1"。
//第二次，habit 是 "2"。
//System.out.println(habit);：
//這行是在控制台印出每一個 habit 的值。
//接上面的例子，如果 habits 是 ["1", "2"]，控制台會顯示	
//這就像是把用戶選的興趣清單列出來，讓程式設計者確認「有沒有收到所有勾選的項目」。
//println 會自動換行，所以每個 habit 印在不同行。
		}catch(Exception e) {}
	}
}	
//白話解釋
//try {：
//這就像在說：「我要開始做一件有點風險的事，小心點！」
//為什麼有風險？因為接下來要處理的 habits（興趣清單）可能有問題，比如沒東西（null），如果直接用會出錯。
//try 是告訴程式：「試試看下面的事，如果順利就繼續，如果有問題就跳到 catch 處理。」
//
//for(String habit : habits) {：
//這是一個迴圈，意思是：「把 habits 這個清單裡的東西，拿出來一個一個看。」
//habits 是一個字串陣列（String[]），裡面裝了用戶在表單勾選的興趣，比如 ["1", "2"]（代表「打電腦」和「打籃球」）。
//for(String habit : habits) 就像在說：「從 habits 裡每次抓一個東西，放到 habit 這個變數，然後我來處理。」
//舉例：如果 habits 是 ["1", "2"]，這迴圈會跑兩次：
//第一次，habit 是 "1"（打電腦）。
//第二次，habit 是 "2"（打籃球）。
//
//System.out.println(habit);：
//這行是把 habit 的值寫到伺服器的控制台（日誌視窗，只有程式設計者看得到）。
//System.out.println 就像是用筆把東西記下來，還會自動換行。
//接上面的例子，如果 habits 是 ["1", "2"]，控制台會顯示：
//
//} catch(Exception e) {}：
//這是「安全網」的部分，搭配前面的 try。
//如果 try 裡的程式碼出問題（比如 habits 是 null，導致迴圈沒東西可跑），
//程式會跳到這邊。
//Exception e 就像是說：「不管什麼錯誤（e 是錯誤的細節），我都抓起來。」
//{} 裡什麼都沒寫，意思是：「就算出錯，我也啥都不幹，當沒事發生。」
//舉例：如果用戶沒選任何興趣，habits 是 null，迴圈會出錯（NullPointerException），
//但因為有這個 catch，程式不會崩潰，只是安靜地跳過。
//
//這段程式碼在幹嘛？
//簡單來說，這段程式碼是在「檢查興趣清單」，想把用戶在表單勾選的興趣（像「打電腦」「打籃球」）
//一個一個印到伺服器的控制台，讓程式設計者確認有沒有收到正確的資料。
//因為清單可能有問題（比如空的），所以加了個「安全網」（try-catch），確保程式不會因為錯誤而當機。
//這段程式跟您提供的 HTML 表單有關，表單裡的「興趣」複選框（name="habits"，值是 1 到 6）就是這邊要處理的資料。