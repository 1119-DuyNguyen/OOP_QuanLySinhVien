package DanhSach;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import LopHoc.Khoa;

public class DSKhoa extends DanhSach implements suggestDS {
//	private String[] stringTenKhoa = { "Công nghệ thông tin",
//			"Toán" };
//	private String[] stringMaKhoa = { "CNTT", "Toan"};
	private String[] stringTenKhoa = { "Công nghệ thông tin" };
	private String[] stringMaKhoa = { "CNTT" };
	static Khoa[] dsKhoa = new Khoa[1];

	private static final String urlFile = "data/khoa.txt";

	public DSKhoa() {
		File file = new File("data/Khoa.txt");
		if (!file.exists()) {
			try {
				file.createNewFile();
				for (int i = 0; i < dsKhoa.length; i++) {
					if (dsKhoa[i] == null) {
						dsKhoa[i] = new Khoa(stringMaKhoa[i], stringTenKhoa[i],
								new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()));

					}
				}
				ghiFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// ghiFile();
		docFile();

	}

	public void docFile() {
		FileReader fReader;
		try {
			fReader = new FileReader(urlFile);

			BufferedReader bufferreader = new BufferedReader(fReader);
			// File file = new File("resources/commands.txt");

			String line = bufferreader.readLine();
			int i = 0;
			while (line != null) {
				String data[] = line.split("\\|");

//			for (String d : data) {
//				System.out.println(d);
//			}
				for (int index = 0; index < data.length; ++index) {
					data[index] = data[index].trim();
				}
				if (i + 1 > dsKhoa.length) {
					dsKhoa = Arrays.copyOf(dsKhoa, (i + 1) * 2);
				}
				dsKhoa[i++] = new Khoa(data[0], data[1], data[2]);
				this.size = i;
				line = bufferreader.readLine();
			}
			bufferreader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void ghiFile() {
		FileWriter fw;
		try {
			fw = new FileWriter(urlFile);

			BufferedWriter writer = new BufferedWriter(fw);
			for (Khoa n : dsKhoa) {
				writer.write(n + "\n");

			}
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void them1PhanTu() {
//		// TODO Auto-generated method stub
//		private int n;
//		static Khoa ds[];
//		
//	    public int getN() {
//			return n;
//		}
//		public void setN(int n) {
//			this.n = n;
//		}
//		public static Khoa[] getDs() {
//			return ds;
//		}
//		public static void setDs(Khoa[] ds) {
//			DsKhoa.ds = ds;
//		}
//		    
//			n=Integer.parseInt(sc.nextLine());
//			ds = new Khoa [n];
//			for (int i=0;i<ds.length;i++) {
//				ds[i]= new Khoa(maKhoa,tenKhoa);
//				ds[i].docFile();
//			}
//
//			Scanner sc = new Scanner(System.in);
//
//		    for(int i = ds.length - 1 ; i > 0 ; i--)
//		    {
//		        System.out.println("\nNhap ma khoa muon them:");
//			    maKhoa = sc.nextLine();
//				ds[i]=ds[i-1];
//				n++;
//				
//			}
//		    System.out.println("\nDanh sach Khoa sau khi them la:\n");
//		    ghiFile();
	}

	@Override
	public void themNPhanTu(int n) {
		// TODO Auto-generated method stub
		System.out.println("\nNhap so khoa muon them:\n");

		System.out.println("\nDanh sach Khoa sau khi them la:\n");

		ghiFile();

	}

	@Override
	public void xoaPhanTu(String maSo) {
		// TODO Auto-generated method stub
		int found = 0;
//		for (int i = 0; i < ds.length; i++) {
//			if (ds[i] == maKhoa) {
//				found = 1;
//
//				for (int j = i; j < ds.length; j++) {
//					ds[j] = ds[j + 1];
//				}
//				System.out.println("\n Da xoa Khoa = " + maKhoa);
//
//				break;
//			}
//		}
//		if (found == 0) {
//			System.out.println("\n Khoa khong ton tai." + maKhoa);
//			return 0;
//		} else {
//			return 1;
//		}
	}

	@Override
	public void xuatDanhSach() {
		// TODO Auto-generated method stub
		System.out.printf("%-20s|%-20s\n", "Mã Khoa", "Tên Khoa");
		for (Khoa k : dsKhoa) {
			if (k != null)
				System.out.println(k);

		}
	}

	@Override
	public void suaPhanTu(String maSo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void nhapNPhanTu(int n) {
		// TODO Auto-generated method stub

	}

	@Override
	public String suggest() {

		// TODO Auto-generated method stub
		System.out.println("Danh sách môn hợp lệ");

		for (int i = 0; i < size; ++i) {
			System.out.println(i + ". " + dsKhoa[i]);
		}
		System.out.println(size + "." + "Quay lại");
		System.out.println("Chọn môn để nhập");
		while (true) {
			int choice = Integer.parseInt(sc.nextLine());
			if (choice > 0 && choice < size) {
				return dsKhoa[choice].getMaKhoa();
			} else if (choice == size) {
				return null;
			} else {
				System.out.println("Nhập sai lựa chọn");
			}
		}
	}

	@Override
	public void xoaNPhanTu(int n) {
		// TODO Auto-generated method stub

	}

}
