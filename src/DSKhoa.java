
public class DSKhoa {
//	private String[] stringTenKhoa = { "Công nghệ thông tin",
//			"Toán" };
//	private String[] stringMaKhoa = { "CNTT", "Toan"};
	private String[] stringTenKhoa = { "Công nghệ thông tin"};
private String[] stringMaKhoa = { "CNTT"};
	{
		Khoa[] ds = new Khoa[1];//chuyen thanh 2 neu ma them 2 khoa
		for(int i = 0 ; i < ds.length ; i++)
		{
			ds[i].setTenKhoa(stringTenKhoa[i]);
			ds[i].setMaKhoa(stringMaKhoa[i]);
		}
	}
}

