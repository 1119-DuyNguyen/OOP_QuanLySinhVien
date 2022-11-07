
public class DSNganh {

//	private String[] stringTenNganh = {"kỹ thuật phần mềm", "kế toán" };
//	private String[] stringMaNganh = { "KTPM", "KT" };
	private String[] stringTenNganh = {"kỹ thuật phần mềm" };
	private String[] stringMaNganh = { "KTPM"};
	{
		Nganh[] ds = new Nganh[1];//chuyen thanh 2
		for (int i = 0; i < ds.length; i++) {
			ds[i].setTenNganh(stringTenNganh[i]);
			ds[i].setMaNganh(stringMaNganh[i]);
		}
	}
}
