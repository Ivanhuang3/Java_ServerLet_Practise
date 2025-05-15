package tw.ivan.servlets;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.InputStream;

//1. 開頭的「家」和「工具箱」
//白話解釋：
//package tw.brad.servlets;：這是給程式取個「家」，把它放在 tw.brad.servlets 這個資料夾，方便伺服器找到。
//import ...：這就像拉來一堆工具箱，幫程式做事：
//HttpServlet：讓程式能處理網頁請求。
//HttpServletRequest 和 HttpServletResponse：
//一個是網頁送來的「點單」（請求），一個是程式回給網頁的「菜」（回應）。
//Part：專門處理上傳檔案的工具。
//MultipartConfig：告訴伺服器「我要處理檔案上傳」。
//InputStream 和 IOException：幫忙讀檔案和處理錯誤。
//其他的是處理異常或注解的工具。

@WebServlet("/Ivan09")
@MultipartConfig( location = 
		"C:\\Users\\saucy\\eclipse-workspace\\bb\\src\\main\\java\\tw\\ivan\\servletsn\\servlets")
public class Ivan09 extends HttpServlet {
//2. 設定網址和上傳資料夾
//白話解釋：
//@WebServlet("/Ivan09")：這是給程式取個網址，
//告訴伺服器「如果有人訪問 /Ivan09（像是 www.example.com/Brad09），就找我處理！」
//@MultipartConfig(location = "C:\\Users\\User\\git\\...\\upload")：
//這是說「我要處理檔案上傳，檔案通通存到這個資料夾：
//這就像告訴服務生「把客人送來的東西放這個櫃子裡」。
//public class Brad09 extends HttpServlet：這是說 Ivan09 是個「超級服務生」，
//繼承了 HttpServlet 的本領，專門處理網頁的請求。
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//3.處理上傳檔案（doPost）:
//白話解釋：
//doPost 是處理「客人送資料」的請求（比如上傳檔案時，網頁用 POST 方式送資料）。
//這就像服務生接到客人送來的一包東西（檔案），開始處理。
//throws ServletException, IOException：
//這是說如果出了問題（像是檔案壞了或網路斷了），程式會「喊救命」讓伺服器處理。
		String urip = request.getRemoteAddr();
		Part part = request.getPart("upload");
//4.拿到客人的 IP 和檔案:
//白話解釋：
//request.getRemoteAddr()：
//這是看客人的「身分證」，拿到上傳檔案的人的 IP 位址（像是 192.168.1.1），存到 urip 變數。
//request.getPart("upload")：這是從客人送來的包裹裡，
//拿出名叫 "upload" 的檔案（就像網頁表單裡
//<input type="file" name="upload">）。檔案被包在 part 這個物件裡。	
		String type = part.getContentType();
		String name = part.getName();
		long size = part.getSize();
		String fileName = part.getSubmittedFileName();
		
		System.out.println(urip);
		System.out.println(type);
		System.out.println(name);
		System.out.println(fileName);
//5. 檢查檔案的詳細資訊
//白話解釋：
//這段是在檢查檔案的「規格」，就像服務生打開包裹看看裡面是啥：
//part.getContentType()：看檔案類型（比如 image/jpeg 是圖片，text/plain 是文字檔）。
//part.getName()：看檔案在表單裡的名字（這裡應該是 "upload"）。
//part.getSize()：看檔案多大（單位是 bytes，比如 1024 表示 1KB）。
//part.getSubmittedFileName()：看檔案原本的名字（比如 myphoto.jpg）。
//System.out.println(...)：
//把這些資訊（IP、檔案類型、名字、大小、檔名）通通印到控制台（伺服器的日誌），
//就像服務生大喊「這是誰送的！這是啥檔案！多大！」方便檢查。
		//==============
		InputStream in = part.getInputStream();
		byte[] buf = in.readAllBytes();
//6. 讀取檔案內容
//part.getInputStream()：這是把檔案打開，像開水龍頭一樣，讓程式可以讀裡面的資料，存到 in。
//in.readAllBytes()：把檔案的全部內容（一堆 0 和 1）讀出來，存到 buf 這個陣列裡。
//這就像服務生把包裹裡的東西（檔案內容）全部倒出來，準備處理。現在程式只是讀了，但沒用這些資料做啥（有點像備用）。
		//---------------
		if (part.getSize() > 0) {
			part.write("brad1.jpg");
			System.out.println("Upload Success");
		}else {
			System.out.println("Upload failure");
//7. 存檔案並檢查結果
//白話解釋：
//part.getSize() > 0：先檢查檔案有沒有內容（大小是不是大於 0）。如果有，代表客人真的送了東西。
//part.write("brad1.jpg")：
//如果有檔案，就把它存到 @MultipartConfig 設定的資料夾（C:...upload），
//而且不管客人上傳啥檔名，程式都強制存成 brad1.jpg（這有點怪，可能會覆蓋舊檔案）。
//System.out.println("Upload Success")：存好了就喊「上傳成功啦！」
//如果檔案大小是 0（沒東西），就喊「上傳失敗！」。
//這就像服務生確認包裹有東西就收下，沒東西就說「你送空包裹幹嘛？」
		}
	}
}
