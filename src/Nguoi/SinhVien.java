package Nguoi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import DanhSach.DSLop;
import DanhSach.DSMon;
import Mon.Mon;

public class SinhVien extends Nguoi implements ActionMemberClassroom {
	private String maSV;
	private String maLop = "Chưa có";
	private DSMon nhungMonHoc = new DSMon();
	private static int createdMaSV = 4;
	static {
		// Khởi tạo data
		File file = new File("data/maSV.txt");
		if (!file.exists()) {
			try {
				file.createNewFile();
				SinhVien.writeFileCurrentMaSV(createdMaSV);

			} catch (IOException e) {

				e.printStackTrace();
			}
		} else {

			// ghiFile();
			// SinhVien.readFileCurrentMaSV();
			readFileCurrentMaSV();
		}
	}

	public SinhVien() {
		super();
		DSLop ds = new DSLop();
		this.maLop = ds.suggestMa();
		SinhVien.writeFileCurrentMaSV(SinhVien.createdMaSV + 1);
		this.maSV = Integer.toString(SinhVien.createdMaSV);

	}

	public SinhVien(String maSV, String hoTen, String gioiTinh, String soDt, String diaChi, String maLop,
			Mon[] nhungMonHoc) {
		super(hoTen, gioiTinh, soDt, diaChi);
		this.maSV = maSV;
		this.maLop = maLop;
		this.nhungMonHoc = new DSMon(nhungMonHoc);
	}

	public String getMaSV() {
		return maSV;
	}

	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}

	public String toStringShow() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	// to string sẽ đọc ghi file
	@Override
	public String toString() {
		String toStringMonString;

		if (nhungMonHoc == null) {
			toStringMonString = "";

		} else {
			String joinMonString[];
			Mon listMon[] = nhungMonHoc.getDsMon();
			joinMonString = new String[listMon.length];
			for (int i = 0; i < listMon.length; ++i) {
				if (listMon[i] != null)
					joinMonString[i] = listMon[i].toString();
				// xóa null của joinMon
				else
					joinMonString[i] = "";
			}

			toStringMonString = String.join(",", joinMonString);
		}
		String formatString = String.format("%-6s|%s|%-20s|%s", maSV, super.toString(), maLop, toStringMonString);
		return formatString;
	}

	public String getMaLop() {
		return maLop;
	}

	public void setMaLop(String maLop) {
		this.maLop = maLop;
	}

	public void xuatThongTin() {
		float dtb = this.tinhDiemTB();
		String toStringDTB;
		if (dtb >= 0f) {
			toStringDTB = String.format("%-4.2f", dtb);
		} else {
			toStringDTB = "Chưa nhập điểm";
		}
		String formatString = String.format("%-6s|%s|%-20s|%s", maSV, super.toString(), maLop, toStringDTB);
		System.out.println(formatString);

	}

	@Override
	public void xemLop() {
		System.out.println("Thông tin chi tiết lớp học :");
		DSLop ds = new DSLop();
		ds.xuatDSTheoMaLop(this.maLop);
	}

	public float tinhDiemTB() {
		float dtb = 0;
		int index = 0;
		if (this.nhungMonHoc == null) {
			return -1f;
		}
		for (Mon mon : this.nhungMonHoc.getDsMon()) {
			if (mon != null) {
				dtb += mon.getDiem();
				++index;
			}

		}
		// Nếu môn bị null => chưa khởi tạo
		if (index == 0) {
			return -1f;
		} else {

			dtb /= index;
			return dtb;
		}
	}

	// đọc file
	private static void readFileCurrentMaSV() {
		FileReader fReader;
		try {
			fReader = new FileReader("data/maSV.txt");

			BufferedReader bufferreader = new BufferedReader(fReader);
			SinhVien.createdMaSV = Integer.parseInt(bufferreader.readLine());

			bufferreader.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// ghi file
	public static void writeFileCurrentMaSV(int currentMaSV) {
		SinhVien.createdMaSV = currentMaSV;
		FileWriter fw;
		try {
			fw = new FileWriter("data/maSV.txt");

			BufferedWriter writer = new BufferedWriter(fw);
			writer.write(Integer.toString(currentMaSV));
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void suaThongTin() {
		System.out.println("\n-----------Sửa thông tin-----------");
		System.out.println("0. Quay lại");
		System.out.println("1. Sửa họ tên");
		System.out.println("2. Sửa giới tính");
		System.out.println("3. Sửa số điện thoại");
		System.out.println("4. Sửa địa chỉ");
		System.out.println("5. Sửa mã lớp");
		System.out.println("---------------------------");
		int chon = 0;
		do {
			try {

				System.out.print("Nhap lua chon: ");
				chon = Integer.parseInt(sc.nextLine());
				switch (chon) {
				case 0:
					break;
				case 1:
					System.out.print("Nhập họ tên: ");
					setHoTen(sc.nextLine());
					break;
				case 2:
					System.out.print("Nhập giới tính: ");
					setGioiTinh();
					break;
				case 3:

					System.out.print("Nhập số điện thoại: ");
					setSoDt(sc.nextLine());
					break;
				case 4:
					System.out.print("Nhập địa chỉ: ");
					setDiaChi(sc.nextLine());
					break;
				case 5:

					DSLop ds = new DSLop();
					setMaLop(ds.suggestMa());
					break;
				default:
					System.out.println("Lựa chọn không hợp lệ ! Hãy chọn lại");
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Lựa chọn không hợp lệ ! Hãy chọn lại");
				chon = -1;
			}
		} while (chon > 6 || chon < 0);

	}

	public DSMon getNhungMonHoc() {
		return nhungMonHoc;
	}

	public void setNhungMonHoc(DSMon nhungMonHoc) {
		this.nhungMonHoc = nhungMonHoc;
	}

	public void xuatNhungMonSVRot() {
		Mon listMon[] = nhungMonHoc.getDsMon();
		for (Mon mon : listMon) {
			if (mon == null)
				continue;

			if (mon.getDiem() < 5f) {
				this.xuatThongTinMon(mon.getTenMH(), mon.getDiem());
			}
		}
	}

	private void xuatThongTinMon(String tenMon, float diem) {

		String svNoMonToString = String.format("%-6s|%-20s|%-20s|%-4.2f", this.maSV, this.getHoTen(), tenMon, diem);
		System.out.println(svNoMonToString);
	}
}
