package quhe;

public class TestString {

	public static void main(String[] args) {

		//Ωÿ»° ”∆µµÿ÷∑
		String v_address="<iframe height=498 width=510 "
				+ "src='http://player.youku.com/embed/XMzE3Mjk2NDY2OA==' "
				+ "frameborder=0 'allowfullscreen'></iframe>";
		String v_aqy="<iframe height=498 width=510 src='http://player.youku.com/embed/XMTM5MTQ0MzUxMg==' frameborder=0 'allowfullscreen'></iframe>";
		int beginIndex,endIndex;
		beginIndex=0;
		endIndex=0;
		beginIndex=v_address.indexOf("http");
		endIndex=v_address.indexOf("' ");
		//endIndex+=2;
		String v_http;
		v_http=v_address.substring(beginIndex, endIndex);
		
		System.out.println(v_http+":"+beginIndex+":"+endIndex);
		beginIndex=v_aqy.indexOf("http");
		endIndex=v_aqy.indexOf("' ");
		System.out.println(v_aqy.substring(beginIndex, endIndex));
	}

}
