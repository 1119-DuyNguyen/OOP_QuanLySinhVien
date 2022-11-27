package DanhSach;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import LopHoc.Lop;
import Mon.Mon;
import Nguoi.SinhVien;

public class DanhSachSV extends DanhSach {
	// private static SinhVien sVien[] = new SinhVien[100];

	private SinhVien dsSV[] = new SinhVien[20];
	private String urlFile = "data/SinhVien.txt";
	private static String formatHeader = String.format("%-6s|%-20s|%-5s|%-10s|%-40s|%-20s|%s", "mã SV", "Họ và Tên",
			"GT", "SĐT", "Địa chỉ", "Mã Lớp", "Điểm trung bình");

	public DanhSachSV(String urlFile) {
		this.urlFile = urlFile;
	}

	public DanhSachSV() {
		khoiTaoFile();
	}

	public String getUrlFile() {
		return urlFile;
	}

	public void setUrlFile(String urlFile) {
		this.urlFile = urlFile;
		khoiTaoFile();
	}

	public void docFile() {
		FileReader fReader;
		try {
			fReader = new FileReader(urlFile);

			BufferedReader bufferreader = new BufferedReader(fReader);
			String line = bufferreader.readLine();
			int i = 0;
			while (line != null) {
				String data[] = line.split("\\|");

				// xóa khoảng trắng
				for (int index = 0; index < data.length; ++index) {
					data[index] = data[index].trim();
				}

				Mon listMon[] = null;
				for (int index = 0; index < data.length; ++index) {
					data[index] = data[index].trim();
					if (data[index].contains(",")) {

						String listMonString[] = data[index].split(",");

						listMon = new Mon[listMonString.length];

						for (int iMon = 0; iMon < listMonString.length; ++iMon) {
							String dataMon[] = listMonString[iMon].split("#");
							// System.out.println(listMonString[iMon].split("#"));

							listMon[iMon] = new Mon(dataMon[0].trim(), Float.parseFloat(dataMon[1]));
						}
					}
				}
				if (i + 1 > dsSV.length) {
					dsSV = Arrays.copyOf(dsSV, (i + 1) * 2);
				}

				dsSV[i++] = new SinhVien(data[0], data[1], data[2], data[3], data[4], data[5], listMon);

				line = bufferreader.readLine();
			}

			bufferreader.close();
			size = i;
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
			for (SinhVien n : dsSV) {
				if (n != null)
					writer.write(n + "\n");

			}
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public int timKiemSVTheoMaSo(String maSV, boolean isApproximately) {
		if (isApproximately) {
			for (int i = 0; i < size; ++i) {
				if (dsSV[i].getMaSV().contains(maSV)) {
					return i;
				}

			}
		} else {
			for (int i = 0; i < size; ++i) {
				if (dsSV[i].getMaSV().equals(maSV)) {
					return i;
				}

			}
		}

		return -1;
	}

	public int timKiemSVTheoHoTen(String hoTen, boolean isApproximately) {
		if (isApproximately) {
			System.out.println("Các sinh viên phù hợp:");
			Boolean isMatch = false;
			System.out.println(formatHeader);
			for (int i = 0; i < size; ++i) {
				if (dsSV[i].getHoTen().contains(hoTen)) {
					isMatch = true;
					dsSV[i].xuatThongTin();
				}

			}
			if (!isMatch) {
				System.out.println("Không tìm thấy kết quả hợp lệ");
			}

			return -1;
		} else {
			for (int i = 0; i < size; ++i) {
				if (dsSV[i].getHoTen().equals(hoTen)) {
					return i;
				}

			}
		}

		return -1;
	}

	@Override
	public void them1PhanTu() {

		if (size + 1 > dsSV.length)
			dsSV = Arrays.copyOf(dsSV, (size + 1) * 2);

		dsSV[size++] = new SinhVien();
		System.out.println("Sinh viên đã nhập là :");
		System.out.println(formatHeader);
		dsSV[size - 1].xuatThongTin();
		ghiFile();

		// TODO Auto-generated method stub

	}

	public void xuatKQ1SV(int index) {
		System.out.println(formatHeader);
		dsSV[index].xuatThongTin();

	}

	public void xuatKQTimKiem(int index) {
		System.out.println("Thông tin sinh viên cần tìm:");
		xuatKQ1SV(index);
	}

	@Override
	public void themNPhanTu(int n) {
		// TODO Auto-generated method stub

		int beforeAdd;
		if (size == 0) {
			beforeAdd = 0;
		} else
			beforeAdd = size;

		for (int i = 0; i < n; ++i) {
			if (size + 1 > dsSV.length)
				dsSV = Arrays.copyOf(dsSV, (size + 1) * 2);
			System.out.println("Nhập phần tử thứ " + Integer.toString(i + 1));
			dsSV[size++] = new SinhVien();
		}
		System.out.println("Thông tin đã nhập là :");
		System.out.println(formatHeader);
		while (beforeAdd < size) {
			dsSV[beforeAdd++].xuatThongTin();
		}
		ghiFile();
	}

	@Override
	public void xoaPhanTu(String maSV) {
		// TODO Auto-generated method stub
		int index = timKiemSVTheoMaSo(maSV, false);
		if (index >= 0) {
			for (int j = index + 1; j < dsSV.length; ++j) {
				dsSV[j - 1] = dsSV[j];
			}
			dsSV[--size] = null;
		} else
			System.out.println(maSV + " không tồn tại!");

		ghiFile();

	}

	@Override
	public void xuatDanhSach() {
		// TODO Auto-generated method stub

		System.out.println(formatHeader);
		for (SinhVien sv : dsSV) {
			if (sv != null)
				sv.xuatThongTin();

		}
	}

	@Override
	public void suaPhanTu(String maSV) {
		// TODO Auto-generated method stub
		int index = timKiemSVTheoMaSo(maSV, false);
		if (index >= 0) {
			System.out.println("Thông tin sinh viên trước khi sửa:");
			System.out.println(formatHeader);
			dsSV[index].xuatThongTin();
			dsSV[index].suaThongTin();

			ghiFile();
		} else
			System.out.println("Không tồn tại mã số " + maSV);

	}

	@Override
	public void nhapNPhanTu(int n) {
		// TODO Auto-generated method stub
		dsSV = new SinhVien[n];
		size = 0;
		SinhVien.writeFileCurrentMaSV(0);
		themNPhanTu(n);
	}

	@Override
	public void khoiTaoFile() {
		// TODO Auto-generated method stub
		File file = new File(this.urlFile);
		if (!file.exists()) {
			try {
				// khởi tạo mẫu
				file.createNewFile();
				Mon mon[] = new Mon[2];
				mon[0] = new Mon("Cơ sở dữ liệu", 3f);
				mon[1] = new Mon("OOP", 5f);
				Mon mon1[] = new Mon[2];
				mon1[0] = new Mon("kỹ thuật lập trình", 9f);
				mon1[1] = new Mon("OOP", 10f);
				dsSV[0] = new SinhVien("0", "Nguyễn Thanh Duy", "Nam", "123456789",
						"273 An Dương Vương – Phường 3 – Quận 5", "DKP1211", mon1);
				dsSV[1] = new SinhVien("1", "Võ Khương Duy", "Nam", "123456789",
						"273 An Dương Vương – Phường 3 – Quận 5", "DKP1212", mon);
				dsSV[2] = new SinhVien("2", "Lê Nguyễn Minh Huy", "Nam", "123456789",
						"273 An Dương Vương – Phường 3 – Quận 5", "DKP1212", mon1);
				dsSV[3] = new SinhVien("3", "Nguyễn Hữu Đạt", "Nam", "123456789",
						"273 An Dương Vương – Phường 3 – Quận 5", "DKP1212", mon);
				dsSV[4] = new SinhVien("4", "Bùi Nguyên Minh Thư", "Nam", "123456789",
						"273 An Dương Vương – Phường 3 – Quận 5", "DKP1212", mon1);
				this.size = 5;
				ghiFile();
				// String formatString = String.format("%-4s|%s|%-20s|%s", maSV,
				// super.toString(), maLop,
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {

			// ghiFile();
			docFile();

		}
	}

	public SinhVien getSV(int index) {
		return dsSV[index];
	}

	public void setMonSV(int index, DSMon dsMon) {
		dsSV[index].setNhungMonHoc(dsMon);
	}

	public void thongKeDuDieuKienHocBong() {
		// TODO Auto-generated method stub
		System.out.println(formatHeader);
		for (SinhVien sv : this.dsSV) {
			if (sv == null)
				continue;
			if (sv.tinhDiemTB() > 8f) {

				sv.xuatThongTin();

			}
		}
	}

	public void thongKeSVNoMon() {
		// TODO Auto-generated method stub
		String formatHeaderNoMon = String.format("%-6s|%-20s|%-20s|%-20s", "mã SV", "Họ và Tên", "Tên Môn", " Điểm");
		System.out.println(formatHeaderNoMon);
		for (SinhVien sv : this.dsSV) {
			if (sv == null)
				continue;
			sv.xuatNhungMonSVRot();
		}
	}

	public void thongKeSVTheoLop() {
		// TODO Auto-generated method stub
		String formatHeader = String.format("%-6s|%-20s|%-5s|%-10s|%-40s|%-20s|%s", "mã SV", "Họ và Tên", "GT", "SĐT",
				"Địa chỉ", "Mã Lớp", "Điểm trung bình");
		Lop dsLop[] = new DSLop().getDsLop();
		for (Lop lop : dsLop) {
			if (lop == null)
				continue;
			System.out.println("Lớp :" + lop.getTenLop() + "(" + lop.getMaLop() + ") ");
			System.out.println("Mã cố vấn quản lý : " + lop.getMaCoVan());
			System.out.println("Thành viên của lớp :");
			int count = 0;
			System.out.println(formatHeader);
			for (SinhVien sVien : dsSV) {
				if (sVien == null)
					continue;
				if (sVien.getMaLop().equals(lop.getMaLop())) {
					sVien.xuatThongTin();
					++count;
				}
			}
			System.out.println("Tổng thành viên : " + count);
		}

	}

}
