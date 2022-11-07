
public class DSMon {
	private String[] stringTenMon = {"hệ điều hành","cơ sở dữ liệu",
	"đại số tuyến tính", "giải tích số"};
	private String[] stringMaMon = {"HDH","CSDL"
	,"DSTT","GTS"};
	{
		Mon[] ds = new Mon[4];
		for(int i = 0 ; i < ds.length ; i++)
		{
			ds[i].setTenMon(stringTenMon[i]);
			ds[i].setMaMon(stringMaMon[i]);
		}
	}
}
